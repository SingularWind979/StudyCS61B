/**
 * A class that models a dog.
 *
 * @author SingularWind
 */
public class Dog {
    String name;
    int weight;
    public static final String BINOMEN = "Canis familiaris";

    public Dog(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public void makeNoise() {
        System.out.println("name: " + name);
        System.out.println("weight: " + weight);
        System.out.print("make noise: ");
        if (weight < 10) {
            System.out.println("yip");
        } else if (weight < 30) {
            System.out.println("bark");
        } else {
            System.out.println("wag");
        }
    }

    public static Dog maxDog(Dog d1, Dog d2) {
        return (d1.weight > d2.weight) ? d1 : d2;
    }

    public Dog maxDog(Dog d2) {
        return Dog.maxDog(this, d2);
    }
}
