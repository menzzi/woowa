package christmas.util;

import java.util.Set;

public class Discount {
    private static final Set<Integer> WEEKEND_DATES = Set.of(1,2,8,9,15,16,22,23,29,30);
    private static final Set<Integer> STAR_DATES = Set.of(3,10,17,24,25,31);
    private static final int WEEKDAY_DISCOUNT_AMOUNT = 2023;
    private static final int WEEKEND_DISCOUNT_AMOUNT = 2023;
    private static final int SPECIAL_DISCOUNT_AMOUNT = 1000;
    private static final int EVENT_START = 1;
    private static final int CHRISTMAS_EVENT_END = 25;
    private static final int OTHER_EVENT_END = 31;

    public int calculateChristmasDiscount(int orderDate){
        if(orderDate > CHRISTMAS_EVENT_END){
            return 0;
        }
        return 1000 + 100 * (orderDate - EVENT_START);
    }

    public int weekdayDiscount(int orderDate, int dessertCount){
        if(STAR_DATES.contains(orderDate) || WEEKEND_DATES.contains(orderDate)){
            return 0;
        }
        return dessertCount * WEEKDAY_DISCOUNT_AMOUNT;
    }
}
