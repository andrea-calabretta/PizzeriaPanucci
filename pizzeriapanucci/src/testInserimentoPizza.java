import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class testInserimentoPizza {
    public static void main(String[] args) {

        System.out.println("Test Add Ingrediente");
        PanucciSystem PnS=PanucciSystem.getIstance();

        System.out.println("Inserisci nome ingrediente:");
        Scanner input = new Scanner(System.in);
        String nome = input.nextLine();
        System.out.println("Inserisci prezzo:");

        float prezzo = input.nextFloat();

        Ingrediente ingrediente = PnS.nuovoIngrediente(nome, prezzo);
        System.out.println("Inserisci ID dell'ingrediente:");
        Integer idIngrediente1 = input.nextInt();
        PnS.addIngrediente(idIngrediente1,ingrediente);
        ingrediente.toString();





        System.out.println("Test Inserimento Pizza");


        System.out.println("Inserisci nuova Pizza:");
        Scanner input2 = new Scanner(System.in);
        String nomePizza = input2.nextLine();
        Pizza pc = PnS.nuovaPizza(nomePizza);


        System.out.println("Ecco gli ingredienti disponibili nel Menù:");

        HashMap<Integer,Ingrediente> ingredientiDisponibili = PnS.getIngredientiDisponibili();

        PnS.getIngredientiDisponibili().forEach((key1, value) -> {
            Integer key = key1;
            Ingrediente ingrediente2=value;
            System.out.println(ingrediente2.toString());
        });

        //for per ogni ingrediente da aggiungere
        System.out.println("Inserisci ID ingrediente da aggiungere:");
        Integer idIngrediente = input2.nextInt();
        PnS.addToPizza(pc ,idIngrediente);
        //fino a qui

        System.out.println("Riepilogo Ingredienti pizza " + pc.getNome());
        List<Ingrediente> elencoIngredienti = PnS.elencoIngredienti(pc);

        for(Ingrediente i: elencoIngredienti){
            System.out.println(i.getIngrediente());
        };
        System.out.println("Vuoi confermare la pizza?");

        char res=input2.next().charAt(0);
        //System.out.println(res);
        switch (res) {
            case 'N':
                System.out.println("Pizza annullata!");
                break;
            case 'Y':
                PnS.confermaPizzaAdmin(1,pc);
                break;
        }

    }
}
