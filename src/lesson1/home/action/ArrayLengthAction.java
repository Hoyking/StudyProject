package lesson1.home.action;

import lesson1.home.data.NumbersArraySingleton;

public class ArrayLengthAction implements ActionPerformer {

    @Override
    public void performAction() {
        System.out.println("Количество элементов: " + NumbersArraySingleton.getInstance().getSize());
        printSeparator();
    }

}
