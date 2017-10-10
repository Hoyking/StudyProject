package lesson1.home.action;

import lesson1.home.data.NumbersArraySingleton;

public class MaxValueAction implements ActionPerformer {

    @Override
    public void performAction() {
        NumbersArraySingleton numArray = NumbersArraySingleton.getInstance();
        int maxValue = numArray.getValue(0);
        for(int index = 1; index < numArray.getSize(); index++) {
            if(numArray.getValue(index) > maxValue)
                maxValue = numArray.getValue(index);
        }
        System.out.println("Максимальное значение: " + maxValue);
        printSeparator();
    }

}
