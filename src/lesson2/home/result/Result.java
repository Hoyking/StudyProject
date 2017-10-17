package lesson2.home.result;

import lesson2.home.mehods.Methods;
import lesson2.practice.object.Car;

import java.util.Collection;
import java.util.List;

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
        System.out.println();
    }

    public void deleteByMinSpeed() {
        methods.deleteByMinSpeed(collection);
        System.out.println("Collection after deleting cars with min speed:");
        collection.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

    public void deleteBelowSpeed(int speed) {
        methods.deleteBelowSpeed(collection, speed);
        System.out.println("Collection after deleting cars with speed below " + speed + ":");
        collection.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

    public void deleteOverSpeed(int speed) {
        methods.deleteOverSpeed(collection, speed);
        System.out.println("Collection after deleting cars with speed over " + speed + ":");
        collection.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

    public void totalSpeed() {
        System.out.println("Total speed of cars: " + methods.totalSpeed(collection));
        System.out.println();
    }

    public void getThirdCar() {
        System.out.print("Third element of collection: ");
        try{
            System.out.println(methods.getThirdCar(collection).toString());
        } catch (NullPointerException e) {
            System.out.println("null");
        }
        System.out.println();
    }

    public void secondAndThirdCars() {
        Car[] cars = methods.secondAndThirdCars(collection);
        System.out.println("Second and third elements of collection: ");
        try {
            System.out.println(cars[0].toString());
        } catch (NullPointerException e) {
            System.out.println("null, null");
            System.out.println();
        }
        try {
            System.out.println(cars[1].toString());
        } catch (NullPointerException e) {
            System.out.println("null");
            System.out.println();
        }
    }

    public void overSpeedBelowWeightPattern(int speed, double weight) {
        List<Car> cars = methods.overSpeedBelowWeightPattern(collection, speed, weight);
        System.out.println("Cars with speed over " + speed + " and weight below " + weight + ":");
        for(Car car: cars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

}
