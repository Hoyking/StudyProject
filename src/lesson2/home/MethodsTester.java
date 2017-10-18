package lesson2.home;

import lesson2.home.mehods.*;
import lesson2.home.test.Test;
import lesson2.home.transformer.Transformer;
import lesson2.practice.object.Car;

import java.util.Collection;
import java.util.Map;

public class MethodsTester {

    private Car[] cars = {new Car(1, "Ferrari", 1.3, 350),
            new Car(2, "Toyota", 1.8, 240),
            new Car(2, "Toyota", 1.8, 240),
            new Car(3, "Audi", 1.7, 280),
            new Car(4, "Lamborghini", 1.4, 350)};

    public void startTest() {
        Methods methods = new CollectionStreamMethods();
        AbstractMapMethods mapMethods = new MapStreamMethods();

        printCollection(Transformer.arrayListTransformer(cars), "Unchanged collection:");
        Test.deleteByMaxSpeedTest(cars, methods);
        Test.deleteByMinSpeedTest(cars, methods);
        Test.deleteBelowSpeedTest(cars, methods, 290);
        Test.deleteOverSpeedTest(cars, methods, 290);
        Test.totalSpeedTest(cars, methods);
        Test.getThirdCarTest(cars, methods);
        Test.secondAndThirdCarsTest(cars, methods);
        Test.overSpeedBelowWeightPatternTest(cars, methods, 300, 1.5);
        Test.charEntryTest(cars, methods, 'r');
        Test.carNameConversionTest(cars, methods);
        Test.doubleSortTest(cars, methods);

        printMap(Transformer.hashMapTransformer(cars), "Unchanged map:");
        Test.deleteByMaxSpeedTest(cars, mapMethods);
        Test.deleteByMinSpeedTest(cars, mapMethods);
        Test.deleteBelowSpeedTest(cars, mapMethods, 290);
        Test.deleteOverSpeedTest(cars, mapMethods, 290);
        Test.totalSpeedTest(cars, mapMethods);
        Test.getThirdCarTest(cars, mapMethods);
        Test.secondAndThirdCarsTest(cars, mapMethods);
        Test.overSpeedBelowWeightPatternTest(cars, mapMethods, 300, 1.5);
        Test.charEntryTest(cars, mapMethods, 'r');
        Test.carNameConversionTest(cars, mapMethods);
        Test.doubleSortTest(cars, mapMethods);
    }

    private void printCollection(Collection<Car> collection, String message) {
        System.out.println("----------------------");
        System.out.println(message);
        collection.forEach(car -> System.out.println(car.toString()));
        System.out.println("----------------------");
    }

    private void printMap(Map<String, Car> map, String message) {
        System.out.println("----------------------");
        System.out.println(message);
        map.forEach((key, value) -> System.out.println(" Key: " + key + ", value: " + value.toString()));
        System.out.println("----------------------");
    }

}
