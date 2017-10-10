package lesson1.home.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MenuItem {

    private MenuItem[] items;
    private String name;

    public abstract void performMenuAction();

    public MenuItem() {}

    public MenuItem(String name, MenuItem[] childMenu) {
        setName(name);
        setItems(childMenu);
    }

    protected void printMenuVariants() {
        int index = 0;
        for(MenuItem item: items) {
            System.out.println(++index + " - " + item.getName());
        }
        System.out.println();
    }

    protected void chooseVariant() {
        System.out.print("Введите значение: ");
        Scanner scanner = new Scanner(System.in);
        int value = 0;

        try {
            value = scanner.nextInt();
            System.out.println();
        } catch (InputMismatchException e) {
            errorMessage();
        }

        try {
            items[value - 1].performMenuAction();
        } catch (IndexOutOfBoundsException e) {
            errorMessage();
        }
    }

    private void errorMessage() {
        System.out.println("Введено неверное значение.");
        System.out.println();
        this.chooseVariant();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItems(MenuItem[] items) {
        this.items = items;
    }

}
