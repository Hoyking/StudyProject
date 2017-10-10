package lesson1.practice.car;

public abstract class SoftCar extends Car {

    protected int seatNum;

    public SoftCar(){}

    public SoftCar(String name, int seatNum) {
        super(name);
        this.seatNum = seatNum;
    }

}
