package lesson2.practice.string;

import lesson2.practice.object.Car;

import java.util.*;

public class StringMapTest implements Testable {

    private Car[] array = {new Car(1, "Ferrari", 1.3, 350),
            new Car(2, "Toyota", 1.8, 240),
            new Car(2, "Toyota", 1.8, 240),
            new Car(3, "Audi", 1.7, 280)};

    private Map<Car, Integer> map;

    public StringMapTest() {
        map = new HashMap<Car, Integer>();
    }

    public StringMapTest(Comparator<Car> comparator) {
        map = new TreeMap<Car, Integer>(comparator);
    }

    @Override
    public void test() {
        putValueToMap(array);
        printMapEntries(map);
    }

    private void putValueToMap(Car[] array) {
        for(Car item: array) {
            map.put(item, new Random().nextInt(10) + 1);
        }
    }

    private void printMapEntries(Map<Car, Integer> map) {
        for(Map.Entry<Car, Integer> entry: map.entrySet()) {
            System.out.println("Item: " + entry.getKey().toString() + ", number: " + entry.getValue());
        }
        System.out.println("Array length: " + array.length);
        System.out.println("Map size: " + map.size());
    }

}
