package lesson1.practice;

import lesson1.practice.car.Car;
import lesson1.practice.car.HugeSuv;
import lesson1.practice.car.Sedan;

public class CarStarter {

    public static void start() {
        Car nissanPatrol = new HugeSuv("Nissan Patrol");
        Car toyotaAvensis = new Sedan("Toyota Avensis");

        nissanPatrol.printMessage();
        toyotaAvensis.printMessage();

        nissanPatrol.setEngine(4.5);
        nissanPatrol.setMaxSpeed(250);

        toyotaAvensis.setEngine(1.8);
        toyotaAvensis.setMaxSpeed(200);

        nissanPatrol.printCharacteristics();
        toyotaAvensis.printCharacteristics();
    }

}
