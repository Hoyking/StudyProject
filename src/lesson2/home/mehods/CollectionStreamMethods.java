package lesson2.home.mehods;

import lesson2.practice.object.Car;

import java.util.*;
import java.util.stream.Collectors;

public class CollectionStreamMethods implements Methods {

    @Override
    public void deleteByMaxSpeed(Collection<Car> collection) {
        OptionalInt maxSpeed = collection.stream().mapToInt(Car::getSpeed).max();
        collection.removeIf(car -> !maxSpeed.isPresent() || maxSpeed.getAsInt() == car.getSpeed());
    }

    @Override
    public void deleteByMinSpeed(Collection<Car> collection) {
        OptionalInt minSpeed = collection.stream().mapToInt(Car::getSpeed).min();
        collection.removeIf(car -> !minSpeed.isPresent() || minSpeed.getAsInt() == car.getSpeed());
    }

    @Override
    public void deleteBelowSpeed(Collection<Car> collection, int speed) {
        collection.removeIf(car -> car.getSpeed() < speed);
    }

    @Override
    public void deleteOverSpeed(Collection<Car> collection, int speed) {
        collection.removeIf(car -> car.getSpeed() > speed);
    }

    @Override
    public int totalSpeed(Collection<Car> collection) {
        return collection.stream().mapToInt(Car::getSpeed).sum();
    }

    @Override
    public Car getThirdCar(Collection<Car> collection) {
        try {
            return collection.stream().skip(2).collect(Collectors.toList()).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public Car[] secondAndThirdCars(Collection<Car> collection) {
        Car secondCar;
        Car thirdCar;

        try {
            secondCar = collection.stream().skip(1).collect(Collectors.toList()).get(0);
        } catch(IndexOutOfBoundsException e) {
            return new Car[] {null, null};
        }

        try {
            thirdCar = collection.stream().skip(2).collect(Collectors.toList()).get(0);
        } catch(IndexOutOfBoundsException e) {
            return new Car[] {secondCar, null};
        }

        return new Car[] {secondCar, thirdCar};
    }

    @Override
    public List<Car> overSpeedBelowWeightPattern(Collection<Car> collection, int speed, double weight) {
        return collection.stream().filter(car -> car.getSpeed() > speed && car.getWeight() < weight).collect(Collectors.toList());
    }

    @Override
    public Map<String, Boolean> charEntry(Collection<Car> collection, char c) {
        List<Car> trueList = collection.stream().filter(car -> car.getName().toLowerCase().indexOf(c) != -1).collect(Collectors.toList());
        Map<String, Boolean> map = new HashMap<>();
        collection.forEach(car -> map.put(car.getName(), trueList.contains(car)));
        return map;
    }

    @Override
    public void carNameConversion(Collection<Car> collection) {
        collection.forEach(car -> car.setName(car.getName() + "_1"));
    }

    @Override
    public void doubleSort(Collection<Car> collection) {
        List<Car> sortedList = collection.stream().sorted(Comparator.comparingInt(Car::getSpeed)).collect(Collectors.toList());
        System.out.println("(First testing) Car collection sorted by speed: ");
        sortedList.forEach(car -> System.out.println(car.toString()));
        System.out.println();

        sortedList = collection.stream().sorted(Comparator.comparing(Car::getName)).collect(Collectors.toList());
        System.out.println("(Second testing) Car collection sorted by car names: ");
        sortedList.forEach(car -> System.out.println(" " + car.toString()));
        System.out.println();
    }

}
