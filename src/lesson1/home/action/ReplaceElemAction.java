package lesson1.home.action;

import lesson1.home.data.NumbersArraySingleton;
import lesson1.home.scanner.InputScannerSingleton;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReplaceElemAction implements ActionPerformer {

    @Override
    public void performAction() {
        NumbersArraySingleton numArray = NumbersArraySingleton.getInstance();

        System.out.print("Введите заменяемое число: ");
        int value1;
        try {
            value1 = InputScannerSingleton.getInstance().getScanner().nextInt();
        } catch (InputMismatchException e) {
            wrongValueErrorMessage();
            return;
        }

        int index;
        try {
            index = numArray.indexOf(value1);
        } catch (NoSuchElementException e) {
            noSuchElemErrorMessage();
            return;
        }

        System.out.print("Введите новое число: ");
        int value2;
        try {
            value2 = InputScannerSingleton.getInstance().getScanner().nextInt();
        } catch (InputMismatchException e) {
            wrongValueErrorMessage();
            return;
        }

        if(!numArray.checkForUniqueness(value2)) {
            duplicateValueErrorMessage();
            return;
        }

        numArray.setValueAt(index, value2);
        successMessage();
        printSeparator();
    }

    private void wrongValueErrorMessage() {
        System.out.println("Введено неверное значение.");
        System.out.println();
    }

    private void noSuchElemErrorMessage() {
        System.out.println("Данное число не входит в массив.");
        System.out.println();
    }

    private void duplicateValueErrorMessage() {
        System.out.println("Данное число уже присутствует в массиве.");
        System.out.println();
    }

    private void successMessage() {
        System.out.println("Элемент был успешно заменен.");
    }

}
