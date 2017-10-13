package lesson2.practice.comparator;

import lesson2.practice.object.Car;

import java.util.Comparator;

public class WeightComparator<T> implements Comparator<T> {

    @Override
    public int compare(T car1, T car2) {
        return Double.compare(((Car)car1).getWeight(), ((Car)car2).getWeight());
    }

}
