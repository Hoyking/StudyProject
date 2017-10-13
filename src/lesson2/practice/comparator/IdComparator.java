package lesson2.practice.comparator;

import lesson2.practice.object.Car;

import java.util.Comparator;

public class IdComparator<T> implements Comparator<T> {

    @Override
    public int compare(T car1, T car2) {
        return Integer.compare(((Car)car1).getId(), ((Car)car2).getId());
    }

}
