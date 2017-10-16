package lesson2.home.mehods;

import lesson2.practice.object.Car;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

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
    public int totalSpeed(Collection<Car> colection) {
        int totalSpeed = 0;
        Iterator<Car> iterator = colection.iterator();
        while(iterator.hasNext())
            totalSpeed += iterator.next().getSpeed();
        return totalSpeed;
    }

}
