/**
 * Represents a dog with a name and weight.
 *
 * @author SingularWind
 */
public class Dog implements MyComparable<Dog> {
    /** The name of the dog. */
    String name;
    /** The weight of the dog. */
    int weight;

    /**
     * Constructs a new Dog object with the specified name and weight.
     * @param name  the name of the dog.
     * @param weight the weight of the dog.
     */
    public Dog(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Compares this object with the specified object for order.
     *
     * @param other the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     */
    @Override
    public int compareTo(Dog other) {
        return this.weight - other.weight;
    }
}
