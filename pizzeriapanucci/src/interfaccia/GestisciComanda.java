package interfaccia;

import pizzeriaPanucci.Cliente;
import pizzeriaPanucci.Ingrediente;
import pizzeriaPanucci.PanucciSystem;
import pizzeriaPanucci.Pizza;

import java.util.HashMap;
import java.util.Scanner;

public class GestisciComanda {
    public static void main(String[] args) {
        System.out.println("Test Gestisci Comanda");

        PanucciSystem PnS=PanucciSystem.getIstance();




        Cliente c=PnS.getCliente(1);
        System.out.println("Benvenuto " + c);

        //UC1 Gestisci comanda, compra una capricciosa e una margherita

        PnS.nuovaComanda(c, c.getIndirizzo());

        System.out.println("MENU' PIZZE");
        PnS.elencoPizze().forEach((key1, value) -> {
            Integer key = key1;
            Pizza pizza=value;

            System.out.println(pizza.toString());
        });

        System.out.println("Seleziona la pizza");
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()) {
            int idPizza = input.nextInt();
            Pizza pizza=PnS.selectPizza(idPizza);
            System.out.println("Hai selezionato la pizza numero " + idPizza);
            System.out.println("Riepilogo Ingredienti pizza " + pizza.getNome());
            //List<pizzeriaPanucci.Ingrediente> elencoIngredienti = PnS.elencoIngredienti(pizza);
            HashMap<Integer, Ingrediente> elencoIngredienti = PnS.elencoIngredienti(pizza);

            PnS.getIngredientiDisponibili().forEach((key1, value) -> {
                Integer key = key1;
                Ingrediente ingrediente2 = value;
                System.out.print("ID: " + key + " ");
                System.out.println(ingrediente2.toString());
            });

            /*for(pizzeriaPanucci.Ingrediente ingrediente: elencoIngredienti){
                System.out.println(ingrediente.getIngrediente());
            };*/

            System.out.println("Vuoi confermare la pizza " + pizza.getNome()+ "? (Y|N)");
            Scanner input2 = new Scanner(System.in);
            char res=input2.next().charAt(0);
            //System.out.println(res);
            switch (res){
                case 'N':
                    System.out.println("Pizza annullata!");
                    break;
                case 'Y':
                    System.out.println("Seleziona la quantità della pizza " + pizza.getNome()+ ":");
                    Integer quantita=input2.nextInt();

                    PnS.confermaPizzaComanda(pizza, quantita);

                    System.out.println("Pizza confermata");
                    System.out.println("Importo Pizza="+PnS.calcolaImporto()+" euro");
                    System.out.println("Vuoi confermare comanda? (Y|N)");
                    Scanner input3 = new Scanner(System.in);
                    char res3=input3.next().charAt(0);
                    switch (res3){
                        case 'N':
                            System.out.println("comanda annullata!");
                            break;
                        case 'Y':

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





        } else {
            System.out.println("Non hai inserito una pizza valida");
        }



    }
}
