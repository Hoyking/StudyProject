package lesson1.home.menu;

import lesson1.home.action.ActionPerformer;

public class ActionMenuItem extends MenuItem {

    private ActionPerformer performer;

    public ActionMenuItem() {}

    public ActionMenuItem(String name, MenuItem[] childMenu, ActionPerformer performer) {
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
