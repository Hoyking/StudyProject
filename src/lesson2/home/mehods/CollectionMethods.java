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
        Car thirdCar = null;
        try {
            iterator.next();
            secondCar = iterator.next();
            thirdCar = iterator.next();
        } catch (NoSuchElementException e) {
            return new Car[]{secondCar, thirdCar};
        }
        return new Car[]{secondCar, thirdCar};
    }

    @Override
    public List<Car> overSpeedBelowWeightPattern(Collection<Car> collection, int speed, double weight) {
        List<Car> patternCars = new ArrayList<Car>();
        for (Car car : collection) {
            if (car.getSpeed() > speed && car.getWeight() < weight)
                patternCars.add(car);
        }
        return patternCars;
    }

}
