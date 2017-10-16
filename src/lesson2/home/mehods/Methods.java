package lesson2.home.mehods;

import lesson2.practice.object.Car;

import java.util.Collection;

public interface Methods {

    void deleteByMaxSpeed(Collection<Car> collection);

    void deleteByMinSpeed(Collection<Car> collection);

    void deleteBelowSpeed(Collection<Car> collection, int speed);

    void deleteOverSpeed(Collection<Car> collection, int speed);

    int totalSpeed(Collection<Car> colection);
}
