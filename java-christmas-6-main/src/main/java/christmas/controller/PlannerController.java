package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.Menu;
import christmas.util.*;
import christmas.validator.Validator;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.util.Map;

public class PlannerController {
    private final InputView inputView;
    private final OutputView outputView;

    public PlannerController(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run(){
        try{
            eventPlanner();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            run();
        }
    }

    private void eventPlanner(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        int expectedDate = inputExpectedDate();
        Map<String, Integer> orderMenu = inputOrderMenu();
        int totalAmount = AmountCalculation.calculateTotalAmount(orderMenu);
        outputView.printOrderMenu(expectedDate,orderMenu);
        outputView.printTotalOrderAmount(totalAmount);
        int totalDiscountAmount = applyDiscountPolicy(expectedDate,totalAmount,orderMenu, applyPresentationEvent(totalAmount));
        Badge badge = Badge.giveBadge(totalDiscountAmount);
        outputView.printBadgeName(badge.getBadgeName());
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
            Map<String,Integer> orderList = OrderRecord.orderMenu(inputView.inputMenu());
            Validator.validateOnlyDrink(checkOnlyDrink(orderList));
            return orderList;
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

    private int applyDiscountPolicy(int orderDate, int totalAmount, Map<String, Integer> orderMenu, boolean isPresentation){
        if(totalAmount < 10000){
            printNothing(isPresentation);
            return 0;
        }
        int dessertCount = CountMenuCategory.countDessert(orderMenu);
        int mainCount = CountMenuCategory.countMain(orderMenu);
        int[] discountResult = Discount.discountPolicy(orderDate,dessertCount,mainCount);
        int DiscountAmount = printEachDiscount(discountResult,isPresentation);
        if(DiscountAmount == 0){
            return 0;
        }
        outputView.printTotalDiscount(DiscountAmount);
        calculatePaymentAmount(totalAmount,DiscountAmount);
        return DiscountAmount;
    }

    private void calculatePaymentAmount(int totalAmount, int totalDiscount){
        if(totalAmount < 25000){
            int payment = totalAmount - totalDiscount;
            outputView.printPaymentAmount(payment);
            return;
        }
        int payment = totalAmount - totalDiscount + 25000;
        outputView.printPaymentAmount(payment);
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
