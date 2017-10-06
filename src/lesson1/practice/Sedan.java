package lesson1.practice;

public class Sedan extends SoftCar {

    public Sedan(){}

    public Sedan(String name) {
        super(name, 5);
    }

    @Override
    public void printMessage() {
        System.out.println("Message from sedan soft car: Hello! I am " + name + ". I have " + seatNum + " seats.");
    }

}
