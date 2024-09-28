package christmas.controller;

import christmas.domain.Menu;
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
        int expectedDate = inputExpectedDate();
        Map<String, Integer> orderMenu = inputOrderMenu();
    }

    private Map<String,Integer> orderMenu(){
        String[] userInput = convertStringToArray(inputView.inputMenu());
        int totalCount = 0;
        Map<String,Integer> orderList = new HashMap<>();
        orderList = registerOrder(userInput, orderList,totalCount);
        Validator.validateOnlyDrink(checkOnlyDrink(orderList));
        return orderList;
    }

    private String[] convertStringToArray(String input){
        return input.split(",");
    }

    private Map<String,Integer> registerOrder(String[] userInput, Map<String,Integer> orderList, int totalCount){
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

    private boolean checkOnlyDrink(Map<String,Integer> orderList){
        for(String menuName:orderList.keySet()){
            try {
                Menu.DRINKS.getItemByName(menuName);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return true;
    }

    private int dealMenuNumber(String count){
        Validator.validateNumber(count);
        int number = Integer.parseInt(count);
        Validator.validateNumberRange(number);
        return number;
    }

    private int inputExpectedDate(){
        try{
            return Integer.parseInt(inputView.inputExpectedDate());
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputExpectedDate();
        }
    }

    private Map<String, Integer> inputOrderMenu(){
        try{
            return orderMenu();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputOrderMenu();
        }
    }
}
