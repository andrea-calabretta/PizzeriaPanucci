package pizzeriaPanucci;

public abstract class Sconto {
    protected String nome;

    public abstract float calcolaImportoScontato(float totaleNonScontato);


    public  void  setNome(String nome){
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void add(Sconto sconto){ }
    public void remove(Sconto sconto){ }
    public Sconto getSconto(String nome){
        return null;
    }


}
