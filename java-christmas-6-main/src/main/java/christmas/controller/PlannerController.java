package christmas.controller;

import christmas.view.InputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlannerController {
    private final InputView inputView;

    public PlannerController(InputView inputView){
        this.inputView = inputView;
    }

    public void run(){

    }

    public void eventPlanner(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        int expectedDate = Integer.parseInt(inputView.inputExpectedDate());
    }

    private Map<String,Integer> orderMenu(){
        Map<String,Integer> orderList = new HashMap<>();
        String[] userInput = convertStringToArray(inputView.inputMenu());
        int totalCount = 0;
        for(String input:userInput){
            String[] menu = input.split("-");
            validateDuplicate(orderList,menu[0]);
            int count = dealMenuNumber(menu[1]);
            orderList.put(menu[0],count);
            totalCount += count;
        }
        validateTotalNumber(totalCount);
        return orderList;
    }

    private String[] convertStringToArray(String input){
        return input.split(",");
    }

    private void validateNumber(String count){
        try{
            Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }

    private void validateNumberRange(int count){
        if(count < 1){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
        if(count > 20){
            throw new IllegalArgumentException("[ERROR] 한번에 최대 20개까지만 주문할 수 있습니다.");
        }
    }

    private int dealMenuNumber(String count){
        validateNumber(count);
        int number = Integer.parseInt(count);
        validateNumberRange(number);
        return number;
    }

    private void validateTotalNumber(int totalCount){
        if(totalCount > 20){
            throw new IllegalArgumentException("[ERROR] 한번에 최대 20개까지만 주문할 수 있습니다.");
        }
    }

    private void validateDuplicate(Map<String,Integer> orderList, String menu){
        if(orderList.containsKey(menu)){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
