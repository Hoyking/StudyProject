package lesson1.home.action;

import lesson1.home.data.NumbersArraySingleton;

public class DirectOrderPrintingAction implements ActionPerformer {

    @Override
    public void performAction() {
        NumbersArraySingleton numArray = NumbersArraySingleton.getInstance();
        System.out.print("Прямой порядок: ");
        for(int index = 0; index < numArray.getSize();
            System.out.print(numArray.getValue(index) + " "), index++) {}
        System.out.println();
        printSeparator();
    }

}
