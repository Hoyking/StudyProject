package lesson2.home.transformer;

import lesson2.practice.object.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Transformer {

    private Transformer() {}

    public static List<Car> arrayListTransformer(Car[] cars) {
        List<Car> carList = new ArrayList<>(cars.length);
        carList.addAll(Arrays.asList(cars));
        return carList;
    }

}
