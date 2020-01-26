package interfaccia;

import pizzeriaPanucci.Cliente;
import pizzeriaPanucci.PanucciSystem;
import java.util.List;
import pizzeriaPanucci.Pizza;

public class TestScontoEPagamento {
    public static void main(String[] args) {
        PanucciSystem PnS= PanucciSystem.getIstance();
        /*System.out.println("Test Pagamento e sconto");
        Cliente c=PnS.getCliente(1);
        PnS.nuovaComanda(c, c.getIndirizzo());

        Pizza pc=PnS.selectPizza(1);
        PnS.confermaPizzaComanda(pc, 20);
        System.out.println(PnS.calcolaImporto());

        System.out.println(PnS.associaSconto());
        String info[] = new String[2];
        info[0]="antonio";
        info[1]="antonio";
        System.out.println(PnS.effettuaPagamento("paypal", info));*/

        /*List<Cliente> prova= PnS.getListaClienti();
        for (Cliente c: prova){
            System.out.println(c.toString());
        }*/

        Cliente c=PnS.getCliente(1);
        System.out.println(c.toString());






    }
}
