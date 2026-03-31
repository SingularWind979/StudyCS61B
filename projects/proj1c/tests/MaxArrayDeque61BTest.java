import org.junit.jupiter.api.*;

import java.util.Comparator;
import deque.MaxArrayDeque61B;

import static com.google.common.truth.Truth.assertThat;

/**
 * Tests the MaxArrayDeque61B class.
 *
 * @author SingularWind
 */
public class MaxArrayDeque61BTest {
    /** Comparator for integers. */
    private final Comparator<Integer> integerOrderComparator = Comparator.naturalOrder();

    /** Comparator for strings. */
    private final Comparator<String> stringOrderComparator = Comparator.naturalOrder();
    private final Comparator<String> stringLengthComparator = Comparator.comparing(String::length);

    /** Comparator for animals. */
    private final Comparator<Animal> animalAgeComparator = Comparator.comparing(Animal::age);
    private final Comparator<Animal> animalNameComparator = Comparator.comparing(Animal::name);

    /** Abstract class for animals. */
    @SuppressWarnings("InnerClassMayBeStatic")
    private abstract class Animal {
        private final String name;
        private final int age;

        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String name() {
            return name;
        }

        public int age() {
            return age;
        }
    }

    /** Concrete class for cats. */
    private class Cat extends Animal {
        public Cat(String name, int age) {
            super(name, age);
        }
    }

    /** Concrete class for dogs. */
    private class Dog extends Animal {
        public Dog(String name, int age) {
            super(name, age);
        }
    }

    @Test
    public void basicTest() {
        MaxArrayDeque61B<Integer> mad = new MaxArrayDeque61B<>(integerOrderComparator);

        mad.addFirst(1);

        assertThat(mad.max()).isEqualTo(1);

        mad.addFirst(2);

        assertThat(mad.max()).isEqualTo(2);

        mad.addFirst(3);

        assertThat(mad.max()).isEqualTo(3);
    }

    @Test
    public void basicStringTest() {
        MaxArrayDeque61B<String> mad = new MaxArrayDeque61B<>(stringOrderComparator);

        mad.addFirst("xyz");

        assertThat(mad.max()).isEqualTo("xyz");
        assertThat(mad.max(stringLengthComparator)).isEqualTo("xyz");

        mad.addFirst("xy");

        assertThat(mad.max()).isEqualTo("xyz");
        assertThat(mad.max(stringLengthComparator)).isEqualTo("xyz");

        mad.addFirst("fury road");

        assertThat(mad.max()).isEqualTo("xyz");
        assertThat(mad.max(stringLengthComparator)).isEqualTo("fury road");
    }

    @Test
    public void basicAnimalTest() {
        MaxArrayDeque61B<Animal> mad = new MaxArrayDeque61B<>(animalAgeComparator);

        Animal[] animal = {
            new Cat("Zoe", 1),
            new Cat("Kitty", 3),
            new Dog("Spot", 30)
        };

        for (Animal a : animal) {
            mad.addFirst(a);
        }

        assertThat(mad.max()).isEqualTo(animal[2]);
        assertThat(mad.max(animalNameComparator)).isEqualTo(animal[0]);
    }
}
