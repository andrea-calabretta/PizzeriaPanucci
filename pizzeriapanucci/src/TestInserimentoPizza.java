import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestInserimentoPizza {
    public static void main(String[] args) {

        PanucciSystem PnS=PanucciSystem.getIstance();
        System.out.println("Test Inserimento Pizza");


        System.out.println("Inserisci nuova Pizza:");
        Scanner input2 = new Scanner(System.in);
        String nomePizza = input2.nextLine();
        Pizza pc = PnS.nuovaPizza(nomePizza);


        System.out.println("Ecco gli ingredienti disponibili nel Menù:");


        PnS.getIngredientiDisponibili().forEach((key1, value) -> {
            Integer key = key1;
            Ingrediente ingrediente2=value;
            System.out.print("ID: "+key + " ");
            System.out.println(ingrediente2.toString());
        });
        char res;
        do {
            System.out.println("Inserisci ID ingrediente da aggiungere:");
            Scanner id = new Scanner(System.in);
            Integer idIngrediente = id.nextInt();
            PnS.addToPizza(idIngrediente);
            System.out.println("Vuoi inserire un altro ingrediente? (Y|N)");
            res=input2.next().charAt(0);

        } while(res!='N');



        System.out.println("Riepilogo Ingredienti pizza " + pc.getNome());
        List<Ingrediente> elencoIngredienti = PnS.elencoIngredienti(pc);

        for(Ingrediente i: elencoIngredienti){
            System.out.println(i.getIngrediente());
        };
        System.out.println("Vuoi confermare la pizza? (Y|N)");

        res=input2.next().charAt(0);
        //System.out.println(res);
        switch (res) {
            case 'N':
                System.out.println("Pizza annullata!");
                break;
            case 'Y':
                PnS.confermaPizza(1);
                break;
        }

    }
}
