package lesson1.home.action;

public class ExitAction implements ActionPerformer {

    @Override
    public void performAction() {
        System.exit(0);
    }

}
