package lesson1.practice;

public abstract class SoftCar extends Car {

    protected int seatNum;

    public SoftCar(){}

    public SoftCar(String name, int seatNum) {
        super(name);
        this.seatNum = seatNum;
    }

}
