package lesson2.home.transformer;

import lesson2.practice.object.Car;

import java.util.ArrayList;
import java.util.List;

public class Transformer {

    private Transformer() {}

    public static List<Car> arrayListTransformer(Car[] cars) {
        List<Car> carList = new ArrayList<>(cars.length);
        for(Car car: cars)
            carList.add(car);
        return carList;
    }

}
