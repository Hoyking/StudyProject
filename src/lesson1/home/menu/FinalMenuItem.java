package lesson1.home.menu;

import lesson1.home.action.ActionPerformer;

public class FinalMenuItem extends MenuItem {

    private ActionPerformer performer;

    public FinalMenuItem() {}

    public FinalMenuItem(String name, MenuItem[] childMenu, ActionPerformer performer) {
        super(name, childMenu);
        this.performer = performer;
    }

    @Override
    public void performMenuAction() {
        performer.performAction();
        super.printMenuVariants();
        super.chooseVariant();
    }

}
