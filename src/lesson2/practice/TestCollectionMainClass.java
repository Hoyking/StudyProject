package lesson2.practice;

import lesson2.practice.comparator.IdComparator;
import lesson2.practice.comparator.NameComparator;
import lesson2.practice.comparator.SpeedComparator;
import lesson2.practice.comparator.WeightComparator;
import lesson2.practice.object.Car;
import lesson2.practice.string.StringListTest;
import lesson2.practice.string.StringMapTest;
import lesson2.practice.string.StringSetTest;
import lesson2.practice.string.Testable;

public class TestCollectionMainClass {

    public void main() {
        Testable listTestable = new StringListTest();
        Testable setTestable = new StringSetTest();
        Testable mapTestable = new StringMapTest();
        Testable speedTestable = new StringMapTest(new SpeedComparator<Car>());
        Testable idTestable = new StringMapTest(new IdComparator<Car>());
        Testable nameTestable = new StringMapTest(new NameComparator<>());
        Testable weightTestable = new StringMapTest(new WeightComparator<>());

        printResult(listTestable, "List testable:");
        printResult(setTestable, "Set testable:");
        printResult(mapTestable, "HashMap testable:");
        printResult(speedTestable, "TreeMap testable (compared by car speed):");
        printResult(idTestable, "TreeMap testable (compared by car id):");
        printResult(nameTestable, "TreeMap testable (compared by car name):");
        printResult(weightTestable, "TreeMap testable (compared by car weight):");
    }

    public void printResult(Testable testable, String message) {
        System.out.println(message);
        testable.test();
        System.out.println();
    }

}
