package lesson1.home.action;

import lesson1.home.data.NumbersArraySingleton;

public class SumAction implements ActionPerformer {

    @Override
    public void performAction() {
        NumbersArraySingleton numArray = NumbersArraySingleton.getInstance();
        int sum = 0;
        for(int index = 0; index < numArray.getSize(); sum += numArray.getValue(index), index++) {}
        System.out.println("Сумма всех элементов: " + sum);
        printSeparator();
    }

}
