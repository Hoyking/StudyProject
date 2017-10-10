package lesson1.home.action;

import lesson1.home.data.NumbersArraySingleton;

public class ReverseOrderPrintingAction implements ActionPerformer {

    @Override
    public void performAction() {
        NumbersArraySingleton numArray = NumbersArraySingleton.getInstance();
        System.out.print("Обратный порядок: ");
        for(int index = numArray.getSize() - 1; index >= 0;
            System.out.print(numArray.getValue(index) + " "), index--) {}
        System.out.println();
        printSeparator();
    }

}
