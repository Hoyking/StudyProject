package lesson1.practice;

public abstract class SuvCar extends Car {

    protected String patency;

    public SuvCar(){}

    public SuvCar(String name, String patency) {
        super(name);
        this.patency = patency;
    }

}
