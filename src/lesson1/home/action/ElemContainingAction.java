package lesson1.home.action;

import lesson1.home.data.NumbersArraySingleton;
import lesson1.home.scanner.InputScannerSingleton;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ElemContainingAction implements ActionPerformer {

    @Override
    public void performAction() {
        System.out.print("Введите целое число: ");
        try {
            int value = InputScannerSingleton.getInstance().getScanner().nextInt();
            NumbersArraySingleton numArray = NumbersArraySingleton.getInstance();
            if(numArray.checkForUniqueness(value))
                System.out.println("Число не входит в массив.");
            else
                System.out.println("Число входит в массив.");
        } catch(InputMismatchException e) {
            wrongValueErrorMessage();
        }
        printSeparator();
    }

    private void wrongValueErrorMessage() {
        System.out.println();
        System.out.println("Введено неверное значение.");
    }

}
