package lesson2.home;

import lesson2.home.mehods.CollectionMethods;
import lesson2.home.mehods.CollectionStreamMethods;
import lesson2.home.mehods.MapMethods;
import lesson2.home.result.MapResult;
import lesson2.home.result.Result;
import lesson2.home.transformer.Transformer;
import lesson2.practice.object.Car;

public class CollectionMethodsMain {

    private Car[] cars = {new Car(1, "Ferrari", 1.3, 350),
            new Car(2, "Toyota", 1.8, 240),
            new Car(2, "Toyota", 1.8, 240),
            new Car(3, "Audi", 1.7, 280),
            new Car(4, "Lamborghini", 1.4, 350)};

    public void test() {
        Result listResult = new Result(Transformer.arrayListTransformer(cars), new CollectionStreamMethods());
        //listResult.deleteByMaxSpeed();
        //listResult.deleteByMinSpeed();
        //listResult.deleteBelowSpeed(290);
        //listResult.deleteOverSpeed(290);
        //listResult.totalSpeed();
        //listResult.getThirdCar();
        //listResult.secondAndThirdCars();
        //listResult.overSpeedBelowWeightPattern(300, 1.5);
        //listResult.charEntry('a');
        //listResult.carNameConversion();
        listResult.doubleSort();

        //MapResult mapResult = new MapResult(Transformer.hashMapTransformer(cars), new MapMethods());
        //mapResult.deleteByMaxSpeed();
        //mapResult.deleteByMinSpeed();
        //mapResult.deleteBelowSpeed(290);
        //mapResult.deleteOverSpeed(290);
        //mapResult.totalSpeed();
        //mapResult.getThirdCar();
        //mapResult.secondAndThirdCars();
        //mapResult.overSpeedBelowWeightPattern(300, 1.5);
        //mapResult.charEntry('r');
        //mapResult.carNameConversion();
        //mapResult.doubleSort();
    }

}
