package lesson1.home.action;

public interface ActionPerformer {

    public void performAction();

    default public void printSeparator() {
        System.out.println();
        System.out.println("--------------------");
        System.out.println();
    }

}
