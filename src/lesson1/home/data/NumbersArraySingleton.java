package lesson1.home.data;

import lesson1.home.exception.NotUniqueValueException;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class NumbersArraySingleton {

    private int[] array;
    private int lastArrayIndex;
    private volatile static NumbersArraySingleton instance;

    static {
        instance = new NumbersArraySingleton();
    }

    private NumbersArraySingleton() {
        lastArrayIndex = -1;
    }

    public static NumbersArraySingleton getInstance() {
        return instance;
    }

    public int getValue(int index) {
        if(index > lastArrayIndex)
            throw new IndexOutOfBoundsException();
        else
            return array[index];
    }

    public void setMaximumSize(int size) {
        array = new int[size];
    }

    public int getMaximumSize() {
        return array.length;
    }

    public void addValue(int value) throws NotUniqueValueException {
        if(!checkForUniqueness(value))
            throw new NotUniqueValueException("Введенное значение уже присутствует в массиве");
        else {
            lastArrayIndex++;
            array[lastArrayIndex] = value;
            if(lastArrayIndex == array.length - 1)
                throw new IndexOutOfBoundsException();
        }
    }

    public void setValueAt(int index, int value) throws IndexOutOfBoundsException {
        if(index >= getSize())
            throw new IndexOutOfBoundsException();
        array[index] = value;
    }

    public boolean checkForUniqueness(int value) {
        if(lastArrayIndex == -1)
            return true;
        for(int index = 0; index <= lastArrayIndex; index++) {
            if(value == array[index])
                return false;
        }
        return true;
    }

    public int getSize() {
        return lastArrayIndex + 1;
    }

    public int[] getArrayCopy() {
        return Arrays.copyOf(array, getSize());
    }

    public int indexOf(int value) throws NoSuchElementException {
        for(int index = 0; index < getSize(); index++) {
            if(value == array[index])
                return index;
        }
        throw new NoSuchElementException("Элемент не входит в массив");
    }

}
