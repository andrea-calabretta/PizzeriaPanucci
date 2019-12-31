import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Testmain {
    public static void main(String[] args) {
        System.out.println("Test Main");


        Cliente c= new Cliente("marco", "polo", "marcopolo@gmail.com", "via marco polo");
        System.out.println(c.toString());

        Ingrediente mozzarella=new Ingrediente("mozzarella", 0.5, 1);
        Ingrediente pomodoro=new Ingrediente("pomodoro", 1, 1);
        Ingrediente olio=new Ingrediente("olio", 0.5, 1);

        System.out.println(mozzarella.toString());
        System.out.println(pomodoro.toString());
        System.out.println(olio.toString());

        //creazione pizza margherita

        // (temporanea)
        List<Ingrediente> ingredientiMargherita= new List<Ingrediente>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Ingrediente> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Ingrediente ingrediente) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Ingrediente> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Ingrediente> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public Ingrediente get(int index) {
                return null;
            }

            @Override
            public Ingrediente set(int index, Ingrediente element) {
                return null;
            }

            @Override
            public void add(int index, Ingrediente element) {

            }

            @Override
            public Ingrediente remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Ingrediente> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Ingrediente> listIterator(int index) {
                return null;
            }

            @Override
            public List<Ingrediente> subList(int fromIndex, int toIndex) {
                return null;
            }
        };

        Pizza margherita= new Pizza("Margherita", ingredientiMargherita);











    }
}
