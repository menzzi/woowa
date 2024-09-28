package christmas.validator;

import christmas.domain.Menu;
import christmas.domain.MenuCategory;

import java.util.Map;

public class Validator {
    public static void validateExpectedDate(String input){
        validateNumberFormat(input);
        validateDateRange(input);
    }

    public static void validateNumberFormat(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateDateRange(String input){
        int date = Integer.parseInt(input);
        if(date < 1 || date > 31){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateNumber(String count){
        try{
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateNumberRange(int count){
        if(count < 1){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        if(count > 20){
            throw new IllegalArgumentException("[ERROR] 한번에 최대 20개까지만 주문할 수 있습니다.");
        }
    }

    public static void validateTotalNumber(int totalCount){
        if(totalCount > 20){
            throw new IllegalArgumentException("[ERROR] 한번에 최대 20개까지만 주문할 수 있습니다.");
        }
    }

    public static void validateDuplicate(Map<String,Integer> orderList, String menu){
        if(orderList.containsKey(menu)){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateMenuExist(String menuName){
        for (MenuCategory category : Menu.ALL_CATEGORIES) {
            try {
                category.getItemByName(menuName);
                return;
            } catch (IllegalArgumentException ignored) {
                // 다음 카테고리에서 찾기 위해 계속 진행
            }
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }
}
