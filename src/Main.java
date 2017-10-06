import lesson1.practice.Car;
import lesson1.practice.HugeSuv;
import lesson1.practice.Sedan;

public class Main {

    public static void main(String[] args) {

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
