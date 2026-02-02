/**
 * A class that models a car with a model, color, and gas.
 *
 * @author SingularWind
 */
public class Car {
    String model;
    String color;
    int gas;

    public Car(String model, String color, int gas) {
        this.model = model;
        this.color = color;
        this.gas = gas;
    }

    public void printInfo() {
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Gas: " + gas);
    }

    public void drive() {
        if (getGas() < 5) {
            System.out.println("Not enough gas to drive!");
            return;
        }
        gas -= 5;
        System.out.println("Driving " + model);
    }

    public double getGas() {
        return gas;
    }

    public void addGas(int amount) {
        gas += amount;
    }

    public static void main(String[] args) {
        Car car1 = new Car("BMW", "Red", 1);
        car1.printInfo();
        car1.drive();
        car1.addGas(5);
        car1.drive();

        System.out.println("-".repeat(50));

        Car car2 = new Car("Mercedes", "White", 10);
        car2.printInfo();
        car2.drive();
        car2.drive();
    }
}
