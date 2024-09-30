package christmas.util;

import christmas.domain.Menu;

import java.util.Map;

public class CountMenuCategory {
    public static int countDessert(Map<String, Integer> orderMenu){
        int dessertCount = 0;
        for(String menuName:orderMenu.keySet()){
            try {
                Menu.DESSERTS.getItemByName(menuName);
                dessertCount++;
            } catch (IllegalArgumentException e) {
                break;
            }
        }
        return dessertCount;
    }

    public static int countMain(Map<String, Integer> orderMenu){
        int mainCount = 0;
        for(String menuName:orderMenu.keySet()){
            try {
                Menu.MAINS.getItemByName(menuName);
                mainCount++;
            } catch (IllegalArgumentException e) {
                break;
            }
        }
        return mainCount;
    }
}
