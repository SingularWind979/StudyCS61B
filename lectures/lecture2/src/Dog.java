public class Dog {
    public int weight;
    public static final String binomen = "Canis familiaris";

    public Dog(int weight) {
        this.weight = weight;
    }

    public void makeNoise() {
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

    public static Dog  minDog(Dog d1, Dog d2) {
        return (d1.weight < d2.weight) ? d1 : d2;
    }

    public Dog maxDog(Dog d2) {
        return Dog.maxDog(this, d2);
    }

    public Dog minDog(Dog d2) {
        return Dog.minDog(this, d2);
    }
}
