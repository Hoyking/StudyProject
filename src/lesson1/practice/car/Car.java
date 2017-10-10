package lesson1.practice.car;

public abstract class Car {

    protected String name;

    private double engine;
    private int maxSpeed;

    public Car(){}

    public Car(String name) {
        this.name = name;
    }

    public abstract void printMessage();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void printCharacteristics() {
        System.out.println("Characteristics of " + name + ": engine - " + engine + ", max speed - " + maxSpeed);
    }


}
