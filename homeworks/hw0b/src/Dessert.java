/**
 * A class to represent a dessert.
 *
 * @author SingularWind
 */
public class Dessert {
    int flavor;                 // The flavor of the dessert.
    int price;                  // The price of the dessert.
    static int numDesserts = 0; // The number of desserts created.

    /**
     * Constructs a new Dessert object with the specified flavor and price.
     * @param flavor The flavor of the dessert.
     * @param price The price of the dessert.
     */
    public Dessert(int flavor, int price) {
        this.flavor = flavor;
        this.price = price;
        numDesserts++;
    }

    /**
     * Prints the flavor, price, and number of desserts created.
     */
    public void printDessert() {
        System.out.println(flavor + " " + price + " " + numDesserts);
    }

    public static void main(String[] args) {
        System.out.println("I love dessert!");
    }
}
