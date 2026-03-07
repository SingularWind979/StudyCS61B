import java.util.Comparator;

/**
 * Represents a cat with a name and age.
 *
 * @author SingularWind
 */
public class Cat implements Comparable<Cat> {
    /** The name of the cat. */
    String name;
    /** The age of the cat. */
    int age;

    /**
     *  Constructs a new Cat object with the specified name and age.
     * @param name the name of the cat.
     * @param age the age of the cat.
     */
    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Compares this object with the specified object for order.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Cat o) {
        return this.age - o.age;
    }

    /** Compares cats by name. */
    public static final Comparator<Cat> nameComparator = Comparator.comparing(o -> o.name);
}
