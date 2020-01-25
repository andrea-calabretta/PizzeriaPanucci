import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class TestRegistrazioneCliente {
    public static void main(String[] args) {
        PanucciSystem PnS=PanucciSystem.getIstance();
        System.out.println("Test Registrazione Cliente");


        System.out.println("Inserisci il tuo nome:");
        Scanner input = new Scanner(System.in);
        String nome = input.nextLine();
        System.out.println("Inserisci il tuo cognome :");
        String cognome = input.nextLine();
        System.out.println("Inserisci il tuo numero telefonico :");
        String telefono = input.nextLine();
        System.out.println("Inserisci la tua mail :");
        String mail = input.nextLine();


        try {
            PnS.registrazioneCliente(nome, cognome, telefono, mail);
            System.out.println("Inserimento avvenuto, riepilogo utente");
            System.out.println(PnS.getCliente(3).toString());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
