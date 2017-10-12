package lesson1.home.scanner;

import java.util.Scanner;

public class InputScannerSingleton {

    private volatile static InputScannerSingleton instance;
    private Scanner scanner;

    static {
        instance = new InputScannerSingleton();
    }

    private InputScannerSingleton() {
        scanner = new Scanner(System.in);
    }

    public static InputScannerSingleton getInstance() {
        return instance;
    }

    public Scanner getScanner() {
        return scanner;
    }

}
