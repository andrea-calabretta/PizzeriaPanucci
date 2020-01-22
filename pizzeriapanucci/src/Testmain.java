import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Testmain {
    public static void main(String[] args) {
        System.out.println("Test Main");

        PanucciSystem PnS=PanucciSystem.getIstance();
        //System.out.println(PnS.getListaClienti());


        //Cliente Marco polo
        Cliente c=PnS.getCliente(1);
        System.out.println(c);

        //UC1 Gestisci comanda, Marco Polo compra una capricciosa e una margherita
        PnS.nuovaComanda(c.getIndirizzo());

        System.out.println("MENU' PIZZE");
        PnS.elencoPizze().forEach((key1, value) -> {
            Integer key = key1;
            Pizza pizza=value;
            //System.out.println(key);
            System.out.println(pizza.toString());
        });

        System.out.println("Seleziona la pizza");
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()) {
            int idPizza = input.nextInt();
            Pizza pizza=PnS.selectPizza(idPizza);
            System.out.println("Hai selezionato la pizza numero " + idPizza);
            System.out.println("Riepilogo Ingredienti pizza " + pizza.getNome());
            List<Ingrediente> elencoIngredienti = PnS.elencoIngredienti(pizza);

            for(Ingrediente ingrediente: elencoIngredienti){
                System.out.println(ingrediente.getIngrediente());
            };
            System.out.println("Vuoi confermare la pizza " + pizza.getNome()+ "? (Y|N)");
            Scanner input2 = new Scanner(System.in);
            char res=input2.next().charAt(0);
            //System.out.println(res);
            switch (res){
                case 'N':
                    System.out.println("Pizza annullata!");
                    break;
                case 'Y':

                    PnS.confermaPizza(pizza);

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

                            PnS.confermaComanda(c);
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
