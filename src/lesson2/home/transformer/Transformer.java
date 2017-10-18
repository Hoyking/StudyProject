package lesson2.home.transformer;

import lesson2.practice.object.Car;

import java.util.*;

public class Transformer {

    private Transformer() {}

    public static List<Car> arrayListTransformer(Car[] cars) {
        List<Car> carList = new ArrayList<>(cars.length);
        carList.addAll(Arrays.asList(cars));
        return carList;
    }

    public static Map<String, Car> hashMapTransformer(Car[] cars) {
        Map<String, Car> map = new HashMap<>(cars.length);
        for(Car car : cars) {
            map.put(car.getName(), car);
        }
        return map;
    }

}
