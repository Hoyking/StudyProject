package lesson2.practice.comparator;

import java.util.Comparator;

import lesson2.practice.object.Car;

public class SpeedComparator<T> implements Comparator<T> {

    @Override
    public int compare(T car1, T car2) {
        return Integer.compare(((Car)car1).getSpeed(), ((Car)car2).getSpeed());
    }

}
