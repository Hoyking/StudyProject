package lesson2.practice.string;

import lesson2.practice.object.Car;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringSetTest implements Testable {

    private Car[] array = {new Car(1, "Ferrari", 1.3, 350),
            new Car(2, "Toyota", 1.8, 240),
            new Car(2, "Toyota", 1.8, 240),
            new Car(3, "Audi", 1.7, 280)};

    private Set<Car> set = new HashSet();

    @Override
    public void test() {
        addValuesToSet(array);
        printSetEntries(set);
    }

    private void addValuesToSet(Car[] array) {
        set.addAll(Arrays.asList(array));
    }

    private void printSetEntries(Set<Car> set) {
        for(Car entry: set) {
            System.out.println("Entry : " + entry.toString());
        }
        System.out.println("Array length: " + array.length);
        System.out.println("Set size: " + set.size());
    }

}
