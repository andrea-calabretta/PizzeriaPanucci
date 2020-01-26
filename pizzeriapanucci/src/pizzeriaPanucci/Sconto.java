package pizzeriaPanucci;

public abstract class Sconto {
    protected String nome;

    public abstract float calcolaImportoScontato(float totaleNonScontato);

    public String getNome() {
        return nome;
    }

    public void add(Sconto sconto){ }
    public void remove(Sconto sconto){ }
    public Sconto getSconto(String nome){
        return null;
    }


}
