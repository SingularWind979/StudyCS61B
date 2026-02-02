/**
 * Test the Dog class.
 *
 * @author SingularWind
 */
public class DogLauncher {
    public static void main(String[] args) {
        System.out.println("Dog's binomen: " + Dog.BINOMEN);

        Dog[] dogs = new Dog[]{
            new Dog("a", 10),
            new Dog("b", 20),
            new Dog("c", 100)};

        dogs[0].makeNoise();
        dogs[1].makeNoise();
        dogs[2].makeNoise();

        testMaxDog1(dogs);
        testMaxDog2(dogs);
    }

    private static void testMaxDog1(Dog[] dogs) {
        Dog maxDog = Dog.maxDog(Dog.maxDog(dogs[0], dogs[1]), dogs[2]);
        maxDog.makeNoise();
    }

    private static void testMaxDog2(Dog[] dogs) {
        Dog maxDog = dogs[0].maxDog(dogs[1]).maxDog(dogs[2]);
        maxDog.makeNoise();
    }
}
