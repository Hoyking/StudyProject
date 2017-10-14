package lesson2.practice;

import lesson2.practice.output.ResultOutput;
import lesson2.practice.string.StringListTest;
import lesson2.practice.string.StringMapTest;
import lesson2.practice.string.StringSetTest;
import lesson2.practice.string.Testable;

import java.util.function.Function;

public class TestCollectionMainClass {

    public void runTest() {
        Testable listTestable = new StringListTest();
        Testable setTestable = new StringSetTest();
        Testable hashMapTestable = new StringMapTest();
        Testable treeMapTestable = new StringMapTest(String::compareTo);

        ResultOutput.printResult(listTestable, "List testable:");
        ResultOutput.printResult(setTestable, "Set testable:");
        ResultOutput.printResult(hashMapTestable, "HashMap testable:");
        ResultOutput.printResult(treeMapTestable, "TreeMap testable:");
    }

}
