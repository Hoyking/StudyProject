package lesson2.practice.string;

import lesson2.practice.object.Car;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StringListTest implements Testable {

    private Car[] array = {new Car(1, "Ferrari", 1.3, 350),
            new Car(2, "Toyota", 1.8, 240),
            new Car(2, "Toyota", 1.8, 240),
            new Car(3, "Audi", 1.7, 280)};

    private List list = new ArrayList();

    @Override
    public void test() {
        addValuesToList(array);
        printListEntries(list);
    }

    private void addValuesToList(Car[] array) {
        for(int index = 0; index < array.length; index++) {
            list.add(array[index]);
        }
    }

    private void printListEntries(List list) {
        for(int index = 0; index < list.size(); index++) {
            System.out.println("Entry : " + list.get(index).toString());
        }
        System.out.println("Array length: " + array.length);
        System.out.println("List size: " + list.size());
    }

}
