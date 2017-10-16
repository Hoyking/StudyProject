package lesson2.practice.output;

import lesson2.practice.string.Testable;

public class ResultOutput {

    private ResultOutput() {}

    public static void printResult(Testable testable, String message) {
        System.out.println(message);
        testable.test();
        System.out.println();
    }

}
