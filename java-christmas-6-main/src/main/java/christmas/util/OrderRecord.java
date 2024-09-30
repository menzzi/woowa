package christmas.util;

import christmas.validator.Validator;

import java.util.HashMap;
import java.util.Map;

public class OrderRecord {
    public static Map<String,Integer> orderMenu(String input){
        String[] userInput = convertStringToArray(input);
        int totalCount = 0;
        Map<String,Integer> orderList = new HashMap<>();
        orderList = registerOrder(userInput, orderList,totalCount);
        return orderList;
    }

    private static String[] convertStringToArray(String input){
        return input.split(",");
    }

    private static Map<String,Integer> registerOrder(String[] userInput, Map<String, Integer> orderList, int totalCount){
        for(String input:userInput){
            String[] menu = input.split("-");
            Validator.validateMenuExist(menu[0]);
            Validator.validateDuplicate(orderList,menu[0]);
            int count = dealMenuNumber(menu[1]);
            orderList.put(menu[0],count);
            totalCount += count;
        }
        Validator.validateTotalNumber(totalCount);
        return orderList;
    }

    private static int dealMenuNumber(String count){
        Validator.validateNumber(count);
        int number = Integer.parseInt(count);
        Validator.validateNumberRange(number);
        return number;
    }
}
