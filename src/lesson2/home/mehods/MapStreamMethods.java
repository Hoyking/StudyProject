package lesson2.home.mehods;

import lesson2.practice.object.Car;

import java.util.*;
import java.util.stream.Collectors;

public class MapStreamMethods implements AbstractMapMethods {

    @Override
    public void deleteByMaxSpeed(Map<String, Car> map) {
        OptionalInt maxSpeed = map.values().stream().mapToInt(Car::getSpeed).max();
        map.entrySet().removeIf(entry -> !maxSpeed.isPresent() || maxSpeed.getAsInt() == entry.getValue().getSpeed());
    }

    @Override
    public void deleteByMinSpeed(Map<String, Car> map) {
        OptionalInt minSpeed = map.values().stream().mapToInt(Car::getSpeed).min();
        map.entrySet().removeIf(entry -> !minSpeed.isPresent() || minSpeed.getAsInt() == entry.getValue().getSpeed());
    }

    @Override
    public void deleteBelowSpeed(Map<String, Car> map, int speed) {
        map.entrySet().removeIf(entry -> entry.getValue().getSpeed() < speed);
    }

    @Override
    public void deleteOverSpeed(Map<String, Car> map, int speed) {
        map.entrySet().removeIf(entry -> entry.getValue().getSpeed() > speed);
    }

    @Override
    public int totalSpeed(Map<String, Car> map) {
        return map.values().stream().mapToInt(Car::getSpeed).sum();
    }

    @Override
    public Map.Entry<String, Car> getThirdCar(Map<String, Car> map) {
        try {
            return map.entrySet().stream().skip(2).collect(Collectors.toList()).get(0);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    @Override
    public List<Map.Entry<String, Car>> secondAndThirdCars(Map<String, Car> map) {
        Map.Entry<String, Car> secondEntry = null;
        Map.Entry<String, Car> thirdEntry;
        List<Map.Entry<String, Car>> list = new ArrayList<>(2);

        try {
            list.add(map.entrySet().stream().skip(1).collect(Collectors.toList()).get(0));
        } catch(IndexOutOfBoundsException e) {
            list.add(null);
        }

        try {
            list.add(map.entrySet().stream().skip(2).collect(Collectors.toList()).get(0));
        } catch(IndexOutOfBoundsException e) {
            list.add(null);
        }

        return list;
    }

    @Override
    public Set<Map.Entry<String, Car>> overSpeedBelowWeightPattern(Map<String, Car> map, int speed, double weight) {
        return map.entrySet().stream().filter(entry -> entry.getValue().getSpeed() > speed && entry.getValue().getWeight() < weight).
                collect(Collectors.toSet());
    }

    @Override
    public Map<String, Boolean> charEntry(Map<String, Car> map, char c) {
        List<Car> trueList = map.values().stream().filter(car -> car.getName().toLowerCase().indexOf(c) != -1).
                collect(Collectors.toList());
        Map<String, Boolean> checkMap = new HashMap<>();
        map.forEach((key, value) -> checkMap.put(value.getName(), trueList.contains(value)));
        return checkMap;
    }

    @Override
    public void carNameConversion(Map<String, Car> map) {
        map.values().forEach(car -> car.setName(car.getName() + "_1"));
    }

    @Override
    public void doubleSort(Map<String, Car> map) {
        List<Car> sortedList = map.values().stream().sorted(Comparator.comparingInt(Car::getSpeed)).collect(Collectors.toList());
        Map<String, Car> speedSortedMap = new LinkedHashMap<>();
        sortedList.forEach(car -> speedSortedMap.put(car.getName(), car));
        printMap(speedSortedMap, "(First sorting) Car map sorted by speed:");

        Map<String, Car> nameSortedMap = new TreeMap<>(String::compareTo);
        nameSortedMap.putAll(map);
        printMap(nameSortedMap, "(Second sorting) Car map sorted by car names:");
    }

    private void printMap(Map<String, Car> map, String message) {
        System.out.println(message);
        map.forEach((key, value) -> System.out.println(" Key: " + key + ", value: " + value.toString()));
        System.out.println();
    }

}
