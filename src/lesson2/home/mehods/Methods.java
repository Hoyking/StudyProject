package lesson2.home.mehods;

import lesson2.practice.object.Car;

import java.util.Collection;
import java.util.List;

public interface Methods {

    void deleteByMaxSpeed(Collection<Car> collection);

    void deleteByMinSpeed(Collection<Car> collection);

    void deleteBelowSpeed(Collection<Car> collection, int speed);

    void deleteOverSpeed(Collection<Car> collection, int speed);

    int totalSpeed(Collection<Car> colection);

    Car getThirdCar(Collection<Car> collection);

    Car[] secondAndThirdCars(Collection<Car> collection);

    List<Car> overSpeedBelowWeightPattern(Collection<Car> collection, int speed, double weight);
}
