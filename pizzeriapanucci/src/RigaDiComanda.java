public class RigaDiComanda {
    private Pizza pizza;
    private int quantita;
    private float subtotale;

    public RigaDiComanda(Pizza pizza) {
        this.pizza=pizza;
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
        this.subtotale=this.pizza.getPrezzo();
        return this.subtotale;
    }
}
