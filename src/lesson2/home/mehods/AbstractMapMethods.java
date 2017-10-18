package lesson2.home.mehods;

import lesson2.practice.object.Car;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface AbstractMapMethods {

    void deleteByMaxSpeed(Map<String, Car> map);

    void deleteByMinSpeed(Map<String, Car> map);

    void deleteBelowSpeed(Map<String, Car> map, int speed);

    void deleteOverSpeed(Map<String, Car> map, int speed);

    int totalSpeed(Map<String, Car> map);

    Map.Entry<String, Car> getThirdCar(Map<String, Car> map);

    List<Map.Entry<String, Car>> secondAndThirdCars(Map<String, Car> map);

    Set<Map.Entry<String, Car>> overSpeedBelowWeightPattern(Map<String, Car> map, int speed, double weight);

    Map<String, Boolean> charEntry(Map<String, Car> map, char c);

    void carNameConversion(Map<String, Car> map);

    void doubleSort(Map<String, Car> map);

}
