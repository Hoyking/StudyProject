package lesson1.home.menu;

public class MenuPrinter {

    public static void printWrongValueErrorMessage(int inputFinishChar) {
        System.out.println();
        System.out.println("Введено неверное значение. Вы можете продолжить ввод чисел или выйти из режима ввода," +
                " введя '" + inputFinishChar + "'.");
        System.out.println();
    }

    public static void printMaxValueErrorMessage(int inputFinishChar) {
        System.out.println();
        System.out.println("Введено максимальное количество чисел. Введите '" + inputFinishChar + "' для выхода из режима ввода.");
        System.out.println();
    }

    public static void printNotUniqueErrorMessage(int inputFinishChar) {
        System.out.println();
        System.out.println("Введенное значение не является уникальным. Вы можете продолжить ввод чисел или выйти из режима ввода," +
                " введя '" + inputFinishChar + "'.");
        System.out.println();
    }

    public static void printEmptyArrayErrorMessage() {
        System.out.println();
        System.out.println("Введите хотя бы одно значение.");
        System.out.println();
    }

    public static void printSeparator() {
        System.out.println();
        System.out.println("--------------------");
        System.out.println();
    }

}
