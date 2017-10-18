package lesson2.home.mehods;

import lesson2.practice.object.Car;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface Methods {

    void deleteByMaxSpeed(Collection<Car> collection);

    void deleteByMinSpeed(Collection<Car> collection);

    void deleteBelowSpeed(Collection<Car> collection, int speed);

    void deleteOverSpeed(Collection<Car> collection, int speed);

    int totalSpeed(Collection<Car> collection);

    Car getThirdCar(Collection<Car> collection);

    Car[] secondAndThirdCars(Collection<Car> collection);

    List<Car> overSpeedBelowWeightPattern(Collection<Car> collection, int speed, double weight);

    Map<String, Boolean> charEntry(Collection<Car> collection, char c);

    void carNameConversion(Collection<Car> collection);

    void doubleSort(Collection<Car> collection);

    default void reestablishCarNames(Car[] cars) {
        for(Car car : cars) {
            if(car.getName().contains("_1"))
                car.setName(car.getName().substring(0, car.getName().length() - 2));
        }
    }

}
