package lesson2.home.test;

import lesson2.home.mehods.AbstractMapMethods;
import lesson2.home.mehods.Methods;
import lesson2.home.result.MapResult;
import lesson2.home.result.Result;
import lesson2.home.transformer.Transformer;
import lesson2.practice.object.Car;

public class Test {

    private Test() {}

    private static Result generateResult(Car[] cars, Methods methods) {
        return new Result(Transformer.arrayListTransformer(cars), methods);
    }

    private static MapResult generateMapResult(Car[] cars, AbstractMapMethods mapMethods) {
        return new MapResult(Transformer.hashMapTransformer(cars), mapMethods);
    }

    public static void deleteByMaxSpeedTest(Car[] cars, Methods methods) {
        generateResult(cars, methods).deleteByMaxSpeed();
    }

    public static void deleteByMaxSpeedTest(Car[] cars, AbstractMapMethods mapMethods) {
        generateMapResult(cars, mapMethods).deleteByMaxSpeed();
    }

    public static void deleteByMinSpeedTest(Car[] cars, Methods methods) {
        generateResult(cars, methods).deleteByMinSpeed();
    }

    public static void deleteByMinSpeedTest(Car[] cars, AbstractMapMethods mapMethods) {
        generateMapResult(cars, mapMethods).deleteByMinSpeed();
    }

    public static void deleteBelowSpeedTest(Car[] cars, Methods methods, int speed) {
        generateResult(cars, methods).deleteBelowSpeed(speed);
    }

    public static void deleteBelowSpeedTest(Car[] cars, AbstractMapMethods mapMethods, int speed) {
        generateMapResult(cars, mapMethods).deleteBelowSpeed(speed);
    }

    public static void deleteOverSpeedTest(Car[] cars, Methods methods, int speed) {
        generateResult(cars, methods).deleteOverSpeed(speed);
    }

    public static void deleteOverSpeedTest(Car[] cars, AbstractMapMethods mapMethods, int speed) {
        generateMapResult(cars, mapMethods).deleteOverSpeed(speed);
    }

    public static void totalSpeedTest(Car[] cars, Methods methods) {
        generateResult(cars, methods).totalSpeed();
    }

    public static void totalSpeedTest(Car[] cars, AbstractMapMethods mapMethods) {
        generateMapResult(cars, mapMethods).totalSpeed();
    }

    public static void getThirdCarTest(Car[] cars, Methods methods) {
        generateResult(cars, methods).getThirdCar();
    }

    public static void getThirdCarTest(Car[] cars, AbstractMapMethods mapMethods) {
        generateMapResult(cars, mapMethods).getThirdCar();
    }

    public static void secondAndThirdCarsTest(Car[] cars, Methods methods) {
        generateResult(cars, methods).secondAndThirdCars();
    }

    public static void secondAndThirdCarsTest(Car[] cars, AbstractMapMethods mapMethods) {
        generateMapResult(cars, mapMethods).secondAndThirdCars();
    }

    public static void overSpeedBelowWeightPatternTest(Car[] cars, Methods methods, int speed, double weight) {
        generateResult(cars, methods).overSpeedBelowWeightPattern(speed, weight);
    }

    public static void overSpeedBelowWeightPatternTest(Car[] cars, AbstractMapMethods mapMethods, int speed, double weight) {
        generateMapResult(cars, mapMethods).overSpeedBelowWeightPattern(speed, weight);
    }

    public static void charEntryTest(Car[] cars, Methods methods, char c) {
        generateResult(cars, methods).charEntry(c);
    }

    public static void charEntryTest(Car[] cars, AbstractMapMethods mapMethods, char c) {
        generateMapResult(cars, mapMethods).charEntry(c);
    }

    public static void carNameConversionTest(Car[] cars, Methods methods) {
        generateResult(cars, methods).carNameConversion();
        methods.reestablishCarNames(cars);
    }

    public static void carNameConversionTest(Car[] cars, AbstractMapMethods mapMethods) {
        generateMapResult(cars, mapMethods).carNameConversion();
        mapMethods.reestablishCarNames(cars);
    }

    public static void doubleSortTest(Car[] cars, Methods methods) {
        generateResult(cars, methods).doubleSort();
    }

    public static void doubleSortTest(Car[] cars, AbstractMapMethods mapMethods) {
        generateMapResult(cars, mapMethods).doubleSort();
    }

}
