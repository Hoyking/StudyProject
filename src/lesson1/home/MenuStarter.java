package lesson1.home;

import lesson1.home.action.*;
import lesson1.home.data.NumbersArraySingleton;
import lesson1.home.exception.NotUniqueValueException;
import lesson1.home.menu.CompositeMenuItem;
import lesson1.home.menu.FinalMenuItem;
import lesson1.home.menu.MenuItem;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuStarter {

    private char inputFinishChar;

    public MenuStarter() {
        inputFinishChar = 'q';
        NumbersArraySingleton.getInstance().setMaximumSize(10);
        numbersInput();
        buildMenu();
    }

    private void numbersInput() {
        System.out.println("Введите до " + NumbersArraySingleton.getInstance().getMaximumSize() + " уникальных целых чисел (" +
                "для завершения ввода введите '" + inputFinishChar + "').");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                int value = scanner.nextInt();
                try {
                    NumbersArraySingleton.getInstance().addValue(value);
                } catch (IndexOutOfBoundsException e) {
                    printMaxValueErrorMessage();
                } catch (NotUniqueValueException e) {
                    printNotUniqueErrorMessage();
                }
            } catch (InputMismatchException e) {
                String inputLine = scanner.nextLine();
                if(inputLine.length() != 1 || inputLine.charAt(0) != inputFinishChar) {
                    printWrongValueErrorMessage();
                } else {
                    printSeparator();
                    break;
                }
            }
        }
    }

    private void printWrongValueErrorMessage() {
        System.out.println();
        System.out.println("Введено неверное значение. Вы можете продолжить ввод чисел или выйти из режима ввода," +
                            " введя '" + inputFinishChar + "'.");
        System.out.println();
    }

    private void printMaxValueErrorMessage() {
        System.out.println();
        System.out.println("Введено максимальное количество чисел. Введите '" + inputFinishChar + "' для выхода из режима ввода.");
        System.out.println();
    }

    private void printNotUniqueErrorMessage() {
        System.out.println();
        System.out.println("Введенное значение не является уникальным. Вы можете продолжить ввод чисел или выйти из режима ввода," +
                            " введя '" + inputFinishChar + "'.");
        System.out.println();
    }

    private void printSeparator() {
        System.out.println();
        System.out.println("--------------------");
        System.out.println();
    }

    private void buildMenu() {
        MenuItem[] firstLevelMenu = new MenuItem[3];
        MenuItem[] secondLevelMenu1 = new MenuItem[3];
        MenuItem[] secondLevelMenu2 = new MenuItem[4];
        MenuItem[] thirdLevelMenu1 = new MenuItem[6];
        MenuItem[] thirdLevelMenu2 = new MenuItem[3];

        thirdLevelMenu1[0] = new FinalMenuItem("Найти максимум", thirdLevelMenu1, new MaxValueAction());
        thirdLevelMenu1[1] = new FinalMenuItem("Найти минимум", thirdLevelMenu1, new MinValueAction());
        thirdLevelMenu1[2] = new FinalMenuItem("Найти количество", thirdLevelMenu1, new ArrayLengthAction());
        thirdLevelMenu1[3] = new FinalMenuItem("Найти сумму", thirdLevelMenu1, new SumAction());
        thirdLevelMenu1[4] = new FinalMenuItem("Найти среднее значение", thirdLevelMenu1, new AverageValueAction());
        thirdLevelMenu1[5] = new CompositeMenuItem("Назад", secondLevelMenu1);

        thirdLevelMenu2[0] = new FinalMenuItem("Проверить, входит ли число в массив", thirdLevelMenu2,
                new ElemContainingAction());
        thirdLevelMenu2[1] = new FinalMenuItem("Заменить элемент массива на другой", thirdLevelMenu2,
                new SwitchElemAction());
        thirdLevelMenu2[2] = new CompositeMenuItem("Назад", secondLevelMenu1);

        secondLevelMenu1[0] = new CompositeMenuItem("Вычисления значений", thirdLevelMenu1);
        secondLevelMenu1[1] = new CompositeMenuItem("Поиск", thirdLevelMenu2);
        secondLevelMenu1[2] = new CompositeMenuItem("Назад", firstLevelMenu);

        secondLevelMenu2[0] = new FinalMenuItem("Печать массива в прямом порядке", secondLevelMenu2,
                new DirectOrderPrintingAction());
        secondLevelMenu2[1] = new FinalMenuItem("Печать массива в обратном порядке", secondLevelMenu2,
                new ReverseOrderPrintingAction());
        secondLevelMenu2[2] = new FinalMenuItem("Печать массива в отсортированном порядке", secondLevelMenu2,
                new SortedPrintingAction());
        secondLevelMenu2[3] = new CompositeMenuItem("Назад", firstLevelMenu);

        firstLevelMenu[0] = new CompositeMenuItem("Операции", secondLevelMenu1);
        firstLevelMenu[1] = new CompositeMenuItem("Печать", secondLevelMenu2);
        firstLevelMenu[2] = new FinalMenuItem("Выход", firstLevelMenu, new ExitAction());

        CompositeMenuItem menu = new CompositeMenuItem("Меню", firstLevelMenu);
        menu.performMenuAction();
    }

}
