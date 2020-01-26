package interfaccia;

import pizzeriaPanucci.Ingrediente;
import pizzeriaPanucci.PanucciSystem;

import java.util.Scanner;

public class TestAddIngrediente {
    public static void main(String[] args) {

        System.out.println("Test Add Ingrediente");
        PanucciSystem PnS= PanucciSystem.getIstance();

        System.out.println("Ecco gli ingredienti disponibili nel Menù:");




        System.out.println("Inserisci nome ingrediente:");
        Scanner input = new Scanner(System.in);
        String nome = input.nextLine();
        System.out.println("Inserisci prezzo:");

        float prezzo = input.nextFloat();

        Ingrediente ingrediente = PnS.nuovoIngrediente(nome, prezzo);
        System.out.println("Inserisci ID dell'ingrediente:");
        Integer idIngrediente = input.nextInt();
        try{
            PnS.addIngrediente(idIngrediente,ingrediente);
            System.out.println("Ingrediente Inserito");
            System.out.println(ingrediente.toString());
        }
        catch(Exception ex){
            System.out.println("Id non disponibile");
        }



    }
}
