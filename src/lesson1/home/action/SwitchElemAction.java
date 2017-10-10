package lesson1.home.action;

import lesson1.home.data.NumbersArraySingleton;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SwitchElemAction implements ActionPerformer {

    @Override
    public void performAction() {
        NumbersArraySingleton numArray = NumbersArraySingleton.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите заменяемое число: ");
        int value1;
        try {
            value1 = scanner.nextInt();
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
            value2 = scanner.nextInt();
        } catch (InputMismatchException e) {
            wrongValueErrorMessage();
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

    private void successMessage() {
        System.out.println("Элемент был успешно заменен.");
    }

}
