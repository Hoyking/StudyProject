package lesson1.home.menu;

import lesson1.home.data.NumbersArraySingleton;
import lesson1.home.exception.NotUniqueValueException;
import lesson1.home.scanner.InputScannerSingleton;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuStarter {

    private char inputFinishChar;

    public MenuStarter() {
        inputFinishChar = 'q';
        NumbersArraySingleton.getInstance().setMaximumSize(10);
        numbersInput();
        MenuBuilderSingleton.getInstance().buildMenu();
        MenuBuilderSingleton.getInstance().getStartMenuItem().performMenuAction();
    }

    private void numbersInput() {
        System.out.println("Введите до " + NumbersArraySingleton.getInstance().getMaximumSize() + " уникальных целых чисел (" +
                "для завершения ввода введите '" + inputFinishChar + "').");
        while(true) {
            try {
                int value;
                value = InputScannerSingleton.getInstance().getScanner().nextInt();
                try {
                    NumbersArraySingleton.getInstance().addValue(value);
                } catch (IndexOutOfBoundsException e) {
                    MenuPrinter.printMaxValueErrorMessage(inputFinishChar);
                } catch (NotUniqueValueException e) {
                    MenuPrinter.printNotUniqueErrorMessage(inputFinishChar);
                }
            } catch (InputMismatchException e) {
                String inputLine;
                inputLine = InputScannerSingleton.getInstance().getScanner().nextLine();
                if(inputLine.length() != 1 || inputLine.charAt(0) != inputFinishChar) {
                    MenuPrinter.printWrongValueErrorMessage(inputFinishChar);
                } else if (NumbersArraySingleton.getInstance().getSize() == 0){
                    MenuPrinter.printEmptyArrayErrorMessage();
                } else {
                    MenuPrinter.printSeparator();
                    break;
                }
            }
        }
    }

}
