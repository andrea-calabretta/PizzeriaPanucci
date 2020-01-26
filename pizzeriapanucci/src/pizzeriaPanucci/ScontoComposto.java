package pizzeriaPanucci;

import java.util.LinkedList;

public class ScontoComposto extends Sconto{

    private LinkedList <Sconto> listaSconti;

    public ScontoComposto(String nome) {
        this.nome=nome;
        this.listaSconti = new LinkedList<Sconto>();
    }

    @Override
    public float calcolaImportoScontato(float totaleNonScontato) {
        float risultato=0;
        for (Sconto s: listaSconti){
            risultato+=s.calcolaImportoScontato(risultato);
        }
        return risultato;
    }

    public void add(Sconto s){
        listaSconti.add(s);
    }

    public void remove(Sconto s){
        listaSconti.remove(s);
    }

    public Sconto getSconto (String nome){
        Sconto sconto=null;

        for (Sconto s: listaSconti){
            if (s.getNome()==nome){
                sconto=s;
            }
        }
        return sconto;
    }


}
