package lesson2.home.mehods;

import lesson2.practice.object.Car;

import java.util.*;

public class CollectionMethods implements Methods {

    @Override
    public void deleteByMaxSpeed(Collection<Car> collection) {
        int maxSpeed = Collections.max(collection, Comparator.comparingInt(Car::getSpeed)).getSpeed();
        Iterator<Car> iterator = collection.iterator();
        while (iterator.hasNext())
            if(iterator.next().getSpeed() == maxSpeed)
                iterator.remove();
    }

    @Override
    public void deleteByMinSpeed(Collection<Car> collection) {
        int minSpeed = Collections.min(collection, Comparator.comparingInt(Car::getSpeed)).getSpeed();
        Iterator<Car> iterator = collection.iterator();
        while (iterator.hasNext())
            if(iterator.next().getSpeed() == minSpeed)
                iterator.remove();
    }

    @Override
    public void deleteBelowSpeed(Collection<Car> collection, int speed) {
        Iterator<Car> iterator = collection.iterator();
        while (iterator.hasNext())
            if(iterator.next().getSpeed() < speed)
                iterator.remove();
    }

    @Override
    public void deleteOverSpeed(Collection<Car> collection, int speed) {
        Iterator<Car> iterator = collection.iterator();
        while (iterator.hasNext())
            if(iterator.next().getSpeed() > speed)
                iterator.remove();
    }

    @Override
    public int totalSpeed(Collection<Car> collection) {
        int totalSpeed = 0;
        for (Car car : collection)
            totalSpeed += car.getSpeed();
        return totalSpeed;
    }

    @Override
    public Car getThirdCar(Collection<Car> collection) {
        if(collection.size() < 3)
            return null;
        Iterator<Car> iterator = collection.iterator();
        iterator.next();
        iterator.next();
        return iterator.next();
    }

    @Override
    public Car[] secondAndThirdCars(Collection<Car> collection) {
        Iterator<Car> iterator = collection.iterator();
        Car secondCar = null;
        Car thirdCar;
        try {
            iterator.next();
            secondCar = iterator.next();
            thirdCar = iterator.next();
        } catch (NoSuchElementException e) {
            return new Car[]{secondCar, null};
        }
        return new Car[]{secondCar, thirdCar};
    }

    @Override
    public List<Car> overSpeedBelowWeightPattern(Collection<Car> collection, int speed, double weight) {
        List<Car> patternCars = new ArrayList<>();
        for (Car car : collection) {
            if (car.getSpeed() > speed && car.getWeight() < weight)
                patternCars.add(car);
        }
        return patternCars;
    }

    @Override
    public Map<String, Boolean> charEntry(Collection<Car> collection, char c) {
        Map<String, Boolean> charEntryMap = new HashMap<>();
        for(Car car : collection) {
            String name = car.getName().toLowerCase();
            if(name.indexOf(c) == -1)
                charEntryMap.put(name, false);
            else
                charEntryMap.put(name, true);
        }
        return charEntryMap;
    }

    @Override
    public void carNameConversion(Collection<Car> collection) {
        for(Car car : collection) {
            car.setName(car.getName() + "_1");
        }
    }

    @Override
    public void doubleSort(Collection<Car> collection) {
        List list = new ArrayList(collection);
        list.sort(Comparator.comparingInt(Car::getSpeed));
        System.out.println("Car collection sorted by speed: ");
        list.forEach(car -> System.out.println(car.toString()));
        System.out.println();
        list.sort(Comparator.comparing(car -> ((Car)car).getName()));
        System.out.println(" Car collection sorted by name: ");
        list.forEach(car -> System.out.println(" " + car.toString()));
        System.out.println();
    }

}
