package lesson1.home.menu;

import lesson1.home.action.*;
import lesson1.home.menu.item.ActionMenuItem;
import lesson1.home.menu.item.CompositeMenuItem;
import lesson1.home.menu.item.MenuItem;

public class MenuBuilderSingleton {

    private volatile static MenuBuilderSingleton instance;
    private CompositeMenuItem startMenuItem;

    static {
        instance = new MenuBuilderSingleton();
    }

    private MenuBuilderSingleton() {}

    public static MenuBuilderSingleton getInstance() {
        return instance;
    }

    public void buildMenu() {
        MenuItem[] firstLevelMenu = new MenuItem[3];
        MenuItem[] secondLevelMenu1 = new MenuItem[3];
        MenuItem[] secondLevelMenu2 = new MenuItem[4];
        MenuItem[] thirdLevelMenu1 = new MenuItem[6];
        MenuItem[] thirdLevelMenu2 = new MenuItem[3];

        thirdLevelMenu1[0] = new ActionMenuItem("Найти максимум", thirdLevelMenu1, new MaxValueAction());
        thirdLevelMenu1[1] = new ActionMenuItem("Найти минимум", thirdLevelMenu1, new MinValueAction());
        thirdLevelMenu1[2] = new ActionMenuItem("Найти количество", thirdLevelMenu1, new ArrayLengthAction());
        thirdLevelMenu1[3] = new ActionMenuItem("Найти сумму", thirdLevelMenu1, new SumAction());
        thirdLevelMenu1[4] = new ActionMenuItem("Найти среднее значение", thirdLevelMenu1, new AverageValueAction());
        thirdLevelMenu1[5] = new CompositeMenuItem("Назад", secondLevelMenu1);

        thirdLevelMenu2[0] = new ActionMenuItem("Проверить, входит ли число в массив", thirdLevelMenu2,
                new ElemContainingAction());
        thirdLevelMenu2[1] = new ActionMenuItem("Заменить элемент массива на другой", thirdLevelMenu2,
                new ReplaceElemAction());
        thirdLevelMenu2[2] = new CompositeMenuItem("Назад", secondLevelMenu1);

        secondLevelMenu1[0] = new CompositeMenuItem("Вычисления значений", thirdLevelMenu1);
        secondLevelMenu1[1] = new CompositeMenuItem("Поиск", thirdLevelMenu2);
        secondLevelMenu1[2] = new CompositeMenuItem("Назад", firstLevelMenu);

        secondLevelMenu2[0] = new ActionMenuItem("Печать массива в прямом порядке", secondLevelMenu2,
                new DirectOrderPrintingAction());
        secondLevelMenu2[1] = new ActionMenuItem("Печать массива в обратном порядке", secondLevelMenu2,
                new ReverseOrderPrintingAction());
        secondLevelMenu2[2] = new ActionMenuItem("Печать массива в отсортированном порядке", secondLevelMenu2,
                new SortedPrintingAction());
        secondLevelMenu2[3] = new CompositeMenuItem("Назад", firstLevelMenu);

        firstLevelMenu[0] = new CompositeMenuItem("Операции", secondLevelMenu1);
        firstLevelMenu[1] = new CompositeMenuItem("Печать", secondLevelMenu2);
        firstLevelMenu[2] = new ActionMenuItem("Выход", firstLevelMenu, new ExitAction());

        startMenuItem = new CompositeMenuItem("Меню", firstLevelMenu);
    }

    public CompositeMenuItem getStartMenuItem() {
        return startMenuItem;
    }

}
