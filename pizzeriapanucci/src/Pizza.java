import java.util.List;

public class Pizza {
    private String nome;
    private List <Ingrediente> ingredienti;

    public Pizza(String nome,List<Ingrediente> ingredienti) {
        this.nome=nome;
        this.ingredienti = ingredienti;
    }

    public String getNome() {
        return nome;
    }




}
