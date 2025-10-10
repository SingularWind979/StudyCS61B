public class DogLauncher {
    public static void main(String[] args) {
        System.out.println(Dog.binomen);
        Dog[] dogs = new Dog[3];
        dogs[0] = new Dog(10);
        dogs[0].makeNoise();
        dogs[1] = new Dog(20);
        dogs[1].makeNoise();
        dogs[2] = new Dog(100);
        dogs[2].makeNoise();
        Dog maxDog = Dog.maxDog(Dog.maxDog(dogs[0], dogs[1]), dogs[2]);
        maxDog.makeNoise();
        Dog minDog = dogs[0].minDog(dogs[1]).minDog(dogs[2]);
        minDog.makeNoise();
    }
}
