package lesson2.home.mehods;

import lesson2.practice.object.Car;

import java.util.*;

public class MapMethods implements AbstractMapMethods {

    @Override
    public void deleteByMaxSpeed(Map<String, Car> map) {
        int maxSpeed = Collections.max(map.values(), Comparator.comparingInt(Car::getSpeed)).getSpeed();
        Iterator<Map.Entry<String, Car>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
            if(iterator.next().getValue().getSpeed() == maxSpeed)
                iterator.remove();
    }

    @Override
    public void deleteByMinSpeed(Map<String, Car> map) {
        int minSpeed = Collections.min(map.values(), Comparator.comparingInt(Car::getSpeed)).getSpeed();
        Iterator<Map.Entry<String, Car>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
            if(iterator.next().getValue().getSpeed() == minSpeed)
                iterator.remove();
    }

    @Override
    public void deleteBelowSpeed(Map<String, Car> map, int speed) {
        Iterator<Map.Entry<String, Car>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
            if(iterator.next().getValue().getSpeed() < speed)
                iterator.remove();
    }

    @Override
    public void deleteOverSpeed(Map<String, Car> map, int speed) {
        Iterator<Map.Entry<String, Car>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
            if(iterator.next().getValue().getSpeed() > speed)
                iterator.remove();
    }

    @Override
    public int totalSpeed(Map<String, Car> map) {
        int totalSpeed = 0;
        for (Map.Entry<String, Car> entry : map.entrySet())
            totalSpeed += entry.getValue().getSpeed();
        return totalSpeed;
    }

    @Override
    public Map.Entry<String, Car> getThirdCar(Map<String, Car> map) {
        if(map.size() < 3)
            return null;
        Iterator<Map.Entry<String, Car>> iterator = map.entrySet().iterator();
        iterator.next();
        iterator.next();
        return iterator.next();
    }

    @Override
    public List<Map.Entry<String, Car>> secondAndThirdCars(Map<String, Car> map) {
        Iterator<Map.Entry<String, Car>> iterator = map.entrySet().iterator();
        Map.Entry<String, Car> secondEntry = null;
        Map.Entry<String, Car> thirdEntry;
        List<Map.Entry<String, Car>> list = new ArrayList<>(2);
        try {
            iterator.next();
            secondEntry = iterator.next();
            thirdEntry = iterator.next();
        } catch (NoSuchElementException e) {
            list.add(secondEntry);
            list.add(null);
            return list;
        }
        list.add(secondEntry);
        list.add(thirdEntry);
        return list;
    }

    @Override
    public Set<Map.Entry<String, Car>> overSpeedBelowWeightPattern(Map<String, Car> map, int speed, double weight) {
        Set<Map.Entry<String, Car>> patternCars = new HashSet<>();
        for (Map.Entry<String, Car> entry : map.entrySet()) {
            if (entry.getValue().getSpeed() > speed && entry.getValue().getWeight() < weight)
                patternCars.add(entry);
        }
        return patternCars;
    }

    @Override
    public Map<String, Boolean> charEntry(Map<String, Car> map, char c) {
        Map<String, Boolean> charEntryMap = new HashMap<>();
        for(String name : map.keySet()) {
            if(name.indexOf(c) == -1)
                charEntryMap.put(name, false);
            else
                charEntryMap.put(name, true);
        }
        return charEntryMap;
    }

    @Override
    public void carNameConversion(Map<String, Car> map) {
        for(Car car : map.values()) {
            car.setName(car.getName() + "_1");
        }
    }

    @Override
    public void doubleSort(Map<String, Car> map) {
        List<Car> list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingInt(Car::getSpeed));
        Map<String, Car> speedSortedMap = new LinkedHashMap<>();
        for(Car car : list) {
            speedSortedMap.put(car.getName(), car);
        }
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
