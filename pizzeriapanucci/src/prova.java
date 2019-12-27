public class prova {
    public static void main(String[] args) {
        System.out.println("Test Main");


        Cliente c= new Cliente("marco", "polo", "marcopolo@gmail.com");
        System.out.println(c.getNome());
        System.out.println(c.getCognome());
        System.out.println(c.getEmail());


    }
}
