public class RigaDiComanda {
    private Pizza pizza;
    private int quantita;
    private double subtotale;

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


    public float CalcolaSubTotale() {
        return this.pizza.getPrezzo();
    }
}
