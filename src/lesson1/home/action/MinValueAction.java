package lesson1.home.action;

import lesson1.home.data.NumbersArraySingleton;

public class MinValueAction implements ActionPerformer {

    @Override
    public void performAction() {
        NumbersArraySingleton numArray = NumbersArraySingleton.getInstance();
        int minValue = numArray.getValue(0);
        for(int index = 1; index < numArray.getSize(); index++) {
            if(numArray.getValue(index) < minValue)
                minValue = numArray.getValue(index);
        }
        System.out.println("Минимальное значение: " + minValue);
        printSeparator();
    }

}
