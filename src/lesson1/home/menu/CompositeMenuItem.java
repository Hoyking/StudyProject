package lesson1.home.menu;

public class CompositeMenuItem extends MenuItem {

    public CompositeMenuItem() {}

    public CompositeMenuItem(String name, MenuItem[] childMenu) {
        super(name, childMenu);
    }

    @Override
    public void performMenuAction() {
        super.printMenuVariants();
        super.chooseVariant();
    }

}
