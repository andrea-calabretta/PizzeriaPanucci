public class RigaDiComanda {
    private Pizza pizza;
    private int quantita;
    private float subtotale;

    public RigaDiComanda(Pizza pizza, int quantita)
    {
        this.pizza=pizza;
        this.quantita=quantita;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public int getQuantita() {
        return quantita;
    }

    public double getSubtotale() {
        return subtotale;
    }

    @Override
    public String toString() {
        return "RigaDiComanda{" +
                "pizza=" + pizza +
                ", quantita=" + quantita +
                ", subtotale=" + subtotale +
                '}';
    }

    public float CalcolaSubTotale() {
        this.subtotale=this.pizza.getImporto()*this.getQuantita();
        return this.subtotale;
    }
}
