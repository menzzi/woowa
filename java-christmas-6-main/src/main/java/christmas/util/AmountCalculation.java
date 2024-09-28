package christmas.util;

import christmas.domain.Menu;
import christmas.domain.MenuCategory;
import christmas.domain.MenuItem;

import java.util.Map;

public class AmountCalculation {
    public int calculateTotalAmount(Map<String,Integer> orderList){
        int totalAmount = 0;
        for(Map.Entry<String,Integer> order:orderList.entrySet()){
            int price = findPrice(order.getKey());
            totalAmount += price * order.getValue();
        }
        return totalAmount;
    }

    private int findPrice(String menuName){
        for(MenuCategory category: Menu.ALL_CATEGORIES){
            try{
                MenuItem item = category.getItemByName(menuName);
                return item.getPrice();
            }catch (IllegalArgumentException ignored){

            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
