package lesson2.home.result;

import lesson2.home.mehods.Methods;
import lesson2.practice.object.Car;

import java.util.Collection;

public class Result {

    private Collection<Car> collection;
    private Methods methods;

    public Result(Collection<Car> collection, Methods methods) {
        this.collection = collection;
        this.methods = methods;
    }

    public Collection<Car> getCollection() {
        return collection;
    }

    public void deleteByMaxSpeed() {
        methods.deleteByMaxSpeed(collection);
        System.out.println("Collection after deleting cars with max speed:");
        collection.forEach(car -> System.out.println(car.toString()));
    }

    public void deleteByMinSpeed() {
        methods.deleteByMinSpeed(collection);
        System.out.println("Collection after deleting cars with min speed:");
        collection.forEach(car -> System.out.println(car.toString()));
    }

    public void deleteUnderSpeed(int speed) {
        methods.deleteBelowSpeed(collection, speed);
        System.out.println("Collection after deleting cars with speed below " + speed + ":");
        collection.forEach(car -> System.out.println(car.toString()));
    }

    public void deleteOverSpeed(int speed) {
        methods.deleteOverSpeed(collection, speed);
        System.out.println("Collection after deleting cars with speed over " + speed + ":");
        collection.forEach(car -> System.out.println(car.toString()));
    }

    public void totalSpeed() {
        System.out.println("Total speed of cars: " + methods.totalSpeed(collection));
    }

}
