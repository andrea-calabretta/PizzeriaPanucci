import java.util.List;

public class Menu {
    private List<Pizza> elencoPizze;

    public Menu(List<Pizza> elencoPizze) {
        this.elencoPizze = elencoPizze;
    }

    public List<Pizza> getElencoPizze() {
        return elencoPizze;
    }
}
