package lesson2.home.result;

import lesson2.home.mehods.Methods;
import lesson2.practice.object.Car;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class Result {

    private Collection<Car> collection;
    private Methods methods;

    public Result(Collection<Car> collection, Methods methods) {
        this.collection = collection;
        this.methods = methods;
    }

    private void printCollection() {
        collection.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }
    
    public void deleteByMaxSpeed() {
        methods.deleteByMaxSpeed(collection);
        System.out.println("Collection after deleting cars with max speed:");
        printCollection();
    }

    public void deleteByMinSpeed() {
        methods.deleteByMinSpeed(collection);
        System.out.println("Collection after deleting cars with min speed:");
        printCollection();
    }

    public void deleteBelowSpeed(int speed) {
        methods.deleteBelowSpeed(collection, speed);
        System.out.println("Collection after deleting cars with speed below " + speed + ":");
        printCollection();
    }

    public void deleteOverSpeed(int speed) {
        methods.deleteOverSpeed(collection, speed);
        System.out.println("Collection after deleting cars with speed over " + speed + ":");
        printCollection();
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
        for(Car car : cars) {
            try {
                System.out.println(car.toString());
            } catch(NullPointerException e) {
                System.out.println("null");
            }
        }
        System.out.println();
    }

    public void overSpeedBelowWeightPattern(int speed, double weight) {
        List<Car> cars = methods.overSpeedBelowWeightPattern(collection, speed, weight);
        System.out.println("Cars with speed over " + speed + " and weight below " + weight + ":");
        cars.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

    public void charEntry(char c) {
        System.out.println("Entry of the character '" + c + "' in car names:");
        for(Map.Entry<String, Boolean> entry : methods.charEntry(collection, c).entrySet()) {
            System.out.println("Car name: " + entry.getKey() + ", character entry: " + entry.getValue());
        }
        System.out.println();
    }

    public void carNameConversion() {
        methods.carNameConversion(collection);
        System.out.println("Collection after car names conversion:");
        printCollection();
    }

    public void doubleSort() {
        methods.doubleSort(collection);
    }

}
