package interfaccia;

import pizzeriaPanucci.Cliente;
import pizzeriaPanucci.PanucciSystem;

import java.util.Scanner;
import java.lang.Integer;


public class RegistrazioneCliente {
    public static void main(String[] args) {
        PanucciSystem PnS= PanucciSystem.getIstance();
        System.out.println("Test Registrazione pizzeriaPanucci.Cliente");


        System.out.println("Inserisci il tuo nome:");
        Scanner input = new Scanner(System.in);
        String nome = input.nextLine();
        System.out.println("Inserisci il tuo cognome :");
        String cognome = input.nextLine();
        System.out.println("Inserisci la tua mail :");
        String telefono = input.nextLine();
        System.out.println("Inserisci il tuo indirizzo :");
        String mail = input.nextLine();

        try {
            PnS.registrazioneCliente(nome, cognome, telefono, mail);
            System.out.println("Inserimento avvenuto");


        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
