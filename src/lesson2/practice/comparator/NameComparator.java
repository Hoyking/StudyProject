package lesson2.practice.comparator;

import lesson2.practice.object.Car;

import java.util.Comparator;

public class NameComparator<T> implements Comparator<T> {

    @Override
    public int compare(T car1, T car2) {
        return ((Car)car1).getName().compareTo(((Car)car2).getName());
    }

}
