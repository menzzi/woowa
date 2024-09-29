package christmas.controller;

import christmas.domain.Menu;
import christmas.util.AmountCalculation;
import christmas.util.Discount;
import christmas.util.PresentationEvent;
import christmas.validator.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.HashMap;
import java.util.Map;

import static christmas.util.PresentationEvent.presentationChampagne;

public class PlannerController {
    private final InputView inputView;
    private final OutputView outputView;

    public PlannerController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){

    }

    private void eventPlanner(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        int expectedDate = inputExpectedDate();
        Map<String, Integer> orderMenu = inputOrderMenu();
        int totalAmount = AmountCalculation.calculateTotalAmount(orderMenu);
        outputView.printOrderMenu(orderMenu);
        outputView.printTotalOrderAmount(totalAmount);
        applyDiscountPolicy(expectedDate,totalAmount,orderMenu, applyPresentationEvent(totalAmount));
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

    private boolean applyPresentationEvent(int totalAmount){
        int presentationAmount = PresentationEvent.presentationChampagne(totalAmount);
        outputView.printPresentationEvent(presentationAmount);
        if(presentationAmount > 0) return true;
        return false;
    }

    private void applyDiscountPolicy(int orderDate, int totalAmount, Map<String, Integer> orderMenu, boolean isPresentation){
        if(totalAmount < 10000){
            printNothing(isPresentation);
            return;
        }
        int dessertCount = countDessert(orderMenu);
        int mainCount = countMain(orderMenu);
        int[] discountResult = Discount.discountPolicy(orderDate,dessertCount,mainCount);
        int total = printEachDiscount(discountResult,isPresentation);
        if(total == 0){
            return;
        }
        outputView.printTotalDiscount(total);
        calculatePaymentAmount(totalAmount,total);
    }

    private void calculatePaymentAmount(int totalAmount, int totalDiscount){
        if(totalAmount < 25000){
            int payment = totalAmount - totalDiscount;
            // 출력
            return;
        }
        int payment = totalAmount - totalDiscount + 25000;
        // 출력
    }

    public int countDessert(Map<String, Integer> orderMenu){
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

    private int countMain(Map<String, Integer> orderMenu){
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

    public int printEachDiscount(int[] discountResult, boolean isPresentation){
        int totalDiscountAmount = 0;
        for(int amount:discountResult){
            totalDiscountAmount += amount;
        }
        if(totalDiscountAmount == 0){
            printNothing(isPresentation);
            return 0;
        }
        if(isPresentation){
            totalDiscountAmount += 25000;
        }
        outputView.printEachDiscount(discountResult,isPresentation);
        return totalDiscountAmount;
    }

    private void printNothing(boolean isPresentation){
        if(!isPresentation){
            outputView.printEachDiscountNothing();
            outputView.printTotalDiscount(0);
            return;
        }
        outputView.printOnlyPresentation();
        outputView.printTotalDiscount(25000);
    }
}
