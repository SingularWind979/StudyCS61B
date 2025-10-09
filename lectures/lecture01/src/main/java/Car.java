import lombok.Data;

@Data
public class Car {
    private final String model;
    private final String color;

    private double speed;

    public Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public Car(String model) {
        this(model, "unknown");
    }

    public Car() {
        this("unknown", "unknown");
    }

    /**
     * Print the information of the car.
     */
    public void printInfo() {
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Speed: " + speed);
    }

    /**
     * Drive the car.
     * Accelerate the car.
     * Stop the car.
     */
    public void drive() {
        if (speed > 0) {
            System.out.println("Car is already moving.");
            return;
        }
        System.out.println(color + " " + model + " Drive");
    }
    public void accelerate(double speedUp) {
        if (speed >= 100) {
            System.out.println("Car is moving too fast.");
            return;
        }
        speed += speedUp;
        System.out.println(color + " " + model + " Accelerate");
    }
    public void stop() {
        if (speed <= 0) {
            System.out.println("Car is already stopped.");
            return;
        }
        speed = 0;
        System.out.println(color + " " + model + " Stop");
    }

    public static void main(String[] args) {
        Car car1 = new Car("Model S", "Red");
        car1.printInfo();
        car1.drive();
        car1.accelerate(20);
        car1.printInfo();
        car1.stop();
        car1.printInfo();

        Car car2 = new Car("Model X");
        car2.printInfo();
        car2.drive();
        car2.accelerate(20);
        car2.printInfo();
        car2.stop();
    }
}