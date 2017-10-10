package lesson1.practice.car;

public class HugeSuv extends SuvCar {

    public HugeSuv(){}
    public HugeSuv(String name) {
        super(name, "GREATE !");
    }

    @Override
    public void printMessage() {
        System.out.println("Message from huge SUV: Hello! I am " + name + ". My patency is " + patency);
    }
}
