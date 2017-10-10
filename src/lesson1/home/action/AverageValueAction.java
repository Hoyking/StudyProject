package lesson1.home.action;

import lesson1.home.data.NumbersArraySingleton;

public class AverageValueAction implements ActionPerformer {

    @Override
    public void performAction() {
        NumbersArraySingleton numArray = NumbersArraySingleton.getInstance();
        int sum = 0;
        for(int index = 0; index < numArray.getSize(); sum += numArray.getValue(index), index++) {}
        System.out.printf("Среднее арифметическое: %.2f", (double)sum / (double)numArray.getSize());
        printSeparator();
    }

}
