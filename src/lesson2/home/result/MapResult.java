package lesson2.home.result;

import lesson2.home.mehods.AbstractMapMethods;
import lesson2.practice.object.Car;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapResult {

    private Map<String, Car> map;
    private AbstractMapMethods mapMethods;

    public MapResult(Map<String, Car> map, AbstractMapMethods mapMethods) {
        this.map = map;
        this.mapMethods = mapMethods;
    }

    private void printMap() {
        map.entrySet().forEach(entry -> System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue().toString()));
        System.out.println();
    }

    public void deleteByMaxSpeed() {
        mapMethods.deleteByMaxSpeed(map);
        System.out.println("Collection after deleting cars with max speed:");
        printMap();
    }

    public void deleteByMinSpeed() {
        mapMethods.deleteByMinSpeed(map);
        System.out.println("Collection after deleting cars with min speed:");
        printMap();
    }

    public void deleteBelowSpeed(int speed) {
        mapMethods.deleteBelowSpeed(map, speed);
        System.out.println("Map after deleting cars with speed below " + speed + ":");
        printMap();
    }

    public void deleteOverSpeed(int speed) {
        mapMethods.deleteOverSpeed(map, speed);
        System.out.println("Map after deleting cars with speed over " + speed + ":");
        printMap();
    }

    public void totalSpeed() {
        System.out.println("Total speed of cars: " + mapMethods.totalSpeed(map));
        System.out.println();
    }

    public void getThirdCar() {
        System.out.print("Third element of map: ");
        try{
            Map.Entry<String, Car> entry = mapMethods.getThirdCar(map);
            System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
        } catch (NullPointerException e) {
            System.out.println("null");
        }
        System.out.println();
    }

    public void secondAndThirdCars() {
        List<Map.Entry<String, Car>> entries = mapMethods.secondAndThirdCars(map);
        System.out.println("Second and third elements of collection: ");
        for(Map.Entry<String, Car> entry : entries) {
            try {
                System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue());
            } catch(NullPointerException e) {
                System.out.println("null");
            }
        }
        System.out.println();
    }

    public void overSpeedBelowWeightPattern(int speed, double weight) {
        Set<Map.Entry<String, Car>> cars = mapMethods.overSpeedBelowWeightPattern(map, speed, weight);
        System.out.println("Cars with speed over " + speed + " and weight below " + weight + ":");
        cars.forEach(entry -> System.out.println("Key: " + entry.getKey() + ", value: " + entry.getValue().toString()));
        System.out.println();
    }

    public void charEntry(char c) {
        System.out.println("Entry of the character '" + c + "' in car names:");
        for(Map.Entry<String, Boolean> entry : mapMethods.charEntry(map, c).entrySet()) {
            System.out.println("Car name: " + entry.getKey() + ", character entry: " + entry.getValue());
        }
        System.out.println();
    }

    public void carNameConversion() {
        mapMethods.carNameConversion(map);
        System.out.println("Collection after car names conversion:");
        printMap();
    }

    public void doubleSort() {
        mapMethods.doubleSort(map);
    }

}
