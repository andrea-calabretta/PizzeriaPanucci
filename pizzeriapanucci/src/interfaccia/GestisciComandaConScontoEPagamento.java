package interfaccia;

import pizzeriaPanucci.Cliente;
import pizzeriaPanucci.Ingrediente;
import pizzeriaPanucci.PanucciSystem;
import pizzeriaPanucci.Pizza;

import java.util.HashMap;
import java.util.Scanner;

public class GestisciComandaConScontoEPagamento {
    public static void main(String[] args) {
        System.out.println("Test Modifica Pizza");

        PanucciSystem PnS = PanucciSystem.getIstance();

        Cliente c = PnS.getCliente(1);
        System.out.println("Benvenuto " + c.getNome() + " " + c.getCognome());

        //UC1 Gestisci comanda, compra una capricciosa e una margherita

        PnS.nuovaComanda(c, c.getIndirizzo());
        System.out.println("MENU' PIZZE");
        PnS.elencoPizze().forEach((key1, value) -> {
            Integer key = key1;
            Pizza pizza = value;

            System.out.println(pizza.toString());
        });

        System.out.println("Seleziona la pizza");
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()) {
            int idPizza = input.nextInt();
            Pizza pc = PnS.selectPizza(idPizza);
            System.out.println("Hai selezionato la pizza numero " + idPizza);
            System.out.println("Riepilogo Ingredienti pizza " + pc.getNome());
            //List<pizzeriaPanucci.Ingrediente> elencoIngredienti = PnS.elencoIngredienti(pc);
            HashMap<Integer, Ingrediente> elencoIngredienti = PnS.elencoIngredienti(pc);

            /*for (pizzeriaPanucci.Ingrediente ingrediente : elencoIngredienti) {
                System.out.println(ingrediente.getIngrediente());
            };*/
            elencoIngredienti.forEach((key1, value) -> {
                Integer key = key1;
                Ingrediente i=value;
                System.out.print("ID: "+key + " ");
                System.out.println(i.toString());
            });

            System.out.println("Vuoi modificare la pizza " + pc.getNome() + "? (Y|N)");
            Scanner scannermodifica = new Scanner(System.in);
            char modifica = scannermodifica.next().charAt(0);
            switch (modifica) {
                case 'N':
                    System.out.println("Vuoi confermare la pizza " + pc.getNome() + "? (Y|N)");
                    Scanner input2 = new Scanner(System.in);
                    char res = input2.next().charAt(0);
                    //System.out.println(res);
                    switch (res) {
                        case 'N':
                            System.out.println("Pizza annullata!");
                            break;
                        case 'Y':
                            System.out.println("Seleziona la quantità della pizza " + pc.getNome() + ":");
                            Integer quantita = input2.nextInt();

                            PnS.confermaPizzaComanda(pc, quantita);

                            System.out.println("Pizza confermata");
                            System.out.println("Importo Pizza=" + PnS.calcolaImporto() + " euro");
                            System.out.println("Vuoi confermare comanda? (Y|N)");
                            Scanner input3 = new Scanner(System.in);
                            char res3 = input3.next().charAt(0);
                            switch (res3) {
                                case 'N':
                                    System.out.println("comanda annullata!");
                                    break;
                                case 'Y':
                                    System.out.println("Controllo Sconto!!!");
                                    float importoScontato=PnS.associaSconto();
                                    System.out.println("Totale Scontato="+importoScontato);
                                    System.out.println("Scegli metodo Pagamento inserendo il numero corrispondente");
                                    System.out.println("1: PayPal, 2: Carta di Credito, 3: Carta di di Debito");

                                    Integer pagamento = input.nextInt();
                                    String[] info=null;
                                    Scanner scanner=new Scanner(System.in);
                                    boolean validation=false;
                                    switch (pagamento) {

                                        case 1:
                                            info=new String[2];
                                            System.out.println("Inserisci username");
                                            String username=scanner.nextLine();
                                            info[0]=username;
                                            System.out.println("Inserisci password");
                                            String password=scanner.nextLine();
                                            info[1]=password;
                                            validation=PnS.effettuaPagamento("paypal", info);

                                            break;
                                        case 2:
                                            info=new String[4];
                                            System.out.println("Inserisci nome");
                                            String nome=scanner.nextLine();
                                            info[0]=nome;
                                            System.out.println("Inserisci numero carta");
                                            String numero=scanner.nextLine();
                                            info[1]=numero;
                                            System.out.println("Inserisci cvv");
                                            String cvv=scanner.nextLine();
                                            info[2]=cvv;
                                            System.out.println("Inserisci scadenza");
                                            String scadenza=scanner.nextLine();
                                            info[3]=scadenza;
                                            validation=PnS.effettuaPagamento("cartacredito", info);


                                            break;
                                        case 3:
                                            info=new String[4];
                                            System.out.println("Inserisci nome");
                                            nome=scanner.nextLine();
                                            info[0]=nome;
                                            System.out.println("Inserisci numero carta");
                                            numero=scanner.nextLine();
                                            info[1]=numero;
                                            System.out.println("Inserisci cvv");
                                            cvv=scanner.nextLine();
                                            info[2]=cvv;
                                            System.out.println("Inserisci scadenza");
                                            scadenza=scanner.nextLine();
                                            info[3]=scadenza;
                                            validation=PnS.effettuaPagamento("cartadebito", info);

                                            break;

                                        default:
                                            throw new IllegalStateException("Unexpected value: " + pagamento);
                                    }
                                    if(validation) {
                                        PnS.confermaComanda();
                                        System.out.println("Pagamento confermato!");
                                    }
                                    else System.out.println("Pagamento non riuscito, comanda annullata!");


                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Scelta non valida");
                            break;
                    }

                    break;
                case 'Y':
                    Scanner risModifica=new Scanner(System.in);
                    System.out.println("Digita 1: per aggiungere ingredienti, 2: rimuovere ingredienti");
                    Integer scelta =risModifica.nextInt();
                    if (scelta==1){
                        System.out.println("Ecco gli ingredienti disponibili nel Menù:");

                        PnS.getIngredientiDisponibili().forEach((key1, value) -> {
                            Integer key = key1;
                            Ingrediente ingrediente2 = value;
                            System.out.print("ID: " + key + " ");
                            System.out.println(ingrediente2.toString());
                        });
                        do {
                            System.out.println("Inserisci ID ingrediente da aggiungere:");
                            Scanner id = new Scanner(System.in);
                            Integer idIngrediente = id.nextInt();
                            PnS.addToPizza(idIngrediente);
                            System.out.println("Vuoi inserire un altro ingrediente? (Y|N)");
                            res = input.next().charAt(0);

                        } while (res != 'N');
                    } else if(scelta==2){
                        do {
                            System.out.println("Inserisci ID ingrediente da rimuovere:");
                            Scanner id = new Scanner(System.in);
                            Integer idIngrediente = id.nextInt();
                            PnS.removeToPizza(idIngrediente);
                            System.out.println("Vuoi rimuovere un altro ingrediente? (Y|N)");
                            res = input.next().charAt(0);

                        } while (res != 'N');

                    }



                    System.out.println("Riepilogo Ingredienti pizza " + pc.getNome());
                    //List<pizzeriaPanucci.Ingrediente> elencoIngredientiPizza = PnS.elencoIngredienti(pc);
                    elencoIngredienti = PnS.elencoIngredienti(pc);

                    /*for (pizzeriaPanucci.Ingrediente i : elencoIngredientiPizza) {
                        System.out.println(i.getIngrediente());
                    };*/
                    elencoIngredienti.forEach((key1, value) -> {
                        Integer key = key1;
                        Ingrediente i=value;
                        System.out.print("ID: "+key + " ");
                        System.out.println(i.toString());
                    });

                    System.out.println("Vuoi confermare la pizza " + pc.getNome() + "? (Y|N)");

                    res = input.next().charAt(0);
                    //System.out.println(res);
                    switch (res) {
                        case 'N':
                            System.out.println("Pizza annullata!");
                            break;
                        case 'Y':
                            System.out.println("Seleziona la quantità della pizza " + pc.getNome() + ":");
                            Integer quantita = input.nextInt();

                            PnS.confermaPizzaComanda(pc, quantita);

                            System.out.println("Pizza confermata");
                            System.out.println("Importo Pizza=" + PnS.calcolaImporto() + " euro");
                            System.out.println("Vuoi confermare comanda? (Y|N)");
                            Scanner input3 = new Scanner(System.in);
                            char res3 = input3.next().charAt(0);
                            switch (res3) {
                                case 'N':
                                    System.out.println("comanda annullata!");
                                    break;
                                case 'Y':
                                    System.out.println("Controllo Sconto!!!");
                                    float importoScontato=PnS.associaSconto();
                                    System.out.println("Prezzo Scontato="+importoScontato);
                                    System.out.println("Scegli metodo Pagamento inserendo il numero corrispondente");
                                    System.out.println("1: PayPal, 2: Carta di Credito, 3: Carta di di Debito");

                                    Integer pagamento = input.nextInt();
                                    String[] info=null;
                                    Scanner scanner=new Scanner(System.in);
                                    boolean validazione=false;
                                    switch (pagamento) {

                                        case 1:
                                            info=new String[2];
                                            System.out.println("Inserisci username");
                                            String username=scanner.nextLine();
                                            info[0]=username;
                                            System.out.println("Inserisci password");
                                            String password=scanner.nextLine();
                                            info[1]=password;
                                            validazione=PnS.effettuaPagamento("paypal", info);

                                            break;
                                        case 2:
                                            info=new String[4];
                                            System.out.println("Inserisci nome");
                                            String nome=scanner.nextLine();
                                            info[0]=nome;
                                            System.out.println("Inserisci numero carta");
                                            String numero=scanner.nextLine();
                                            info[1]=numero;
                                            System.out.println("Inserisci cvv");
                                            String cvv=scanner.nextLine();
                                            info[2]=cvv;
                                            System.out.println("Inserisci scadenza");
                                            String scadenza=scanner.nextLine();
                                            info[3]=scadenza;
                                            validazione=PnS.effettuaPagamento("cartacredito", info);


                                            break;
                                        case 3:
                                            info=new String[4];
                                            System.out.println("Inserisci nome");
                                            nome=scanner.nextLine();
                                            info[0]=nome;
                                            System.out.println("Inserisci numero carta");
                                            numero=scanner.nextLine();
                                            info[1]=numero;
                                            System.out.println("Inserisci cvv");
                                            cvv=scanner.nextLine();
                                            info[2]=numero;
                                            System.out.println("Inserisci scadenza");
                                            scadenza=scanner.nextLine();
                                            info[3]=numero;
                                            validazione=PnS.effettuaPagamento("cartadebito", info);

                                            break;

                                        default:
                                            throw new IllegalStateException("Unexpected value: " + pagamento);

                                    }
                                    if(validazione) {
                                        PnS.confermaComanda();
                                        System.out.println("Pagamento confermato!");
                                    }
                                    else System.out.println("Pagamento non riuscito, comanda annullata!");



                                    PnS.confermaComanda();
                                    System.out.println("comanda confermata!");
                                    break;
                                default:
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Scelta non valida");
                            break;
                    }


            }
        } else {
            System.out.println("Non hai inserito una pizza valida");
        }
    }
}
