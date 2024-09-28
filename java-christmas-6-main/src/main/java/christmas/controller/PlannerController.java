package christmas.controller;

import christmas.validator.Validator;
import christmas.view.InputView;

import java.util.HashMap;
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
            Validator.validateMenuExist(menu[0]);
            Validator.validateDuplicate(orderList,menu[0]);
            int count = dealMenuNumber(menu[1]);
            orderList.put(menu[0],count);
            totalCount += count;
        }
        Validator.validateTotalNumber(totalCount);
        return orderList;
    }

    private String[] convertStringToArray(String input){
        return input.split(",");
    }


    private int dealMenuNumber(String count){
        Validator.validateNumber(count);
        int number = Integer.parseInt(count);
        Validator.validateNumberRange(number);
        return number;
    }
}
