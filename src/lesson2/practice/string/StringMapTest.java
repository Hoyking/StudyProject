package lesson2.practice.string;

import lesson2.practice.object.Car;

import java.util.*;

public class StringMapTest implements Testable {

    private Car[] array = {new Car(1, "Ferrari", 1.3, 350),
            new Car(2, "Toyota", 1.8, 240),
            new Car(2, "Toyota", 1.8, 240),
            new Car(3, "Audi", 1.7, 280)};

    private Map<String, Car> map;

    public StringMapTest() {
        map = new HashMap<>();
    }

    public StringMapTest(Comparator<String> comparator) {
        map = new TreeMap<>(comparator);
    }

    @Override
    public void test() {
        putValueToMap(array);
        printMapEntries(map);
    }

    private void putValueToMap(Car[] array) {
        for(Car item: array) {
            map.put(item.getName(), item);
        }
    }

    private void printMapEntries(Map<String, Car> map) {
        for(Map.Entry<String, Car> entry: map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue().toString());
        }
        System.out.println("Array length: " + array.length);
        System.out.println("Map size: " + map.size());
    }

}
