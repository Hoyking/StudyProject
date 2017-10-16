package lesson2.home;

import lesson2.home.mehods.CollectionMethods;
import lesson2.home.result.Result;
import lesson2.home.transformer.Transformer;
import lesson2.practice.object.Car;

import java.util.ArrayList;

public class CollectionMethodsMain {

    private Car[] cars = {new Car(1, "Ferrari", 1.3, 350),
            new Car(2, "Toyota", 1.8, 240),
            new Car(2, "Toyota", 1.8, 240),
            new Car(3, "Audi", 1.7, 280),
            new Car(4, "lamborghini", 1.4, 350)};

    public void test() {
        Result result = new Result(Transformer.arrayListTransformer(cars), new CollectionMethods());
        result.deleteUnderSpeed(250);
    }

}
