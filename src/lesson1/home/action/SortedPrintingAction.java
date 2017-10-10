package lesson1.home.action;

import lesson1.home.data.NumbersArraySingleton;

import java.util.Arrays;

public class SortedPrintingAction implements ActionPerformer {

    @Override
    public void performAction() {
        NumbersArraySingleton numArray = NumbersArraySingleton.getInstance();
        int[] tempArray = numArray.getArrayCopy();
        Arrays.sort(tempArray);
        System.out.print("Отсортированный массив: ");
        for(int index = 0; index < tempArray.length;
            System.out.print(tempArray[index] + " "), index++) {}
        System.out.println();
        printSeparator();
    }

}
