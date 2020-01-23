import java.util.Scanner;

public class testAddIngrediente {
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
        Integer idIngrediente = input.nextInt();
        PnS.addIngrediente(idIngrediente,ingrediente);
        ingrediente.toString();

    }
}
