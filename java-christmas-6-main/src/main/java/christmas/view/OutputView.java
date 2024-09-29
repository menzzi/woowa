package christmas.view;

import java.text.NumberFormat;
import java.util.Map;

public class OutputView {
    public void printOrderMenu(Map<String,Integer> orderList){
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
        System.out.println();
        System.out.println("<주문 메뉴>");
        for(Map.Entry<String,Integer> order: orderList.entrySet()){
            System.out.println(order.getKey() + " " + order.getValue() + "개");
        }
        System.out.println();
    }

    public void printTotalOrderAmount(int totalAmount){
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(NumberFormat.getInstance().format(totalAmount) + "원");
        System.out.println();
    }

    public void printEachDiscount(int[] discountResult){
        System.out.println("<혜택 내역>");
        printChristmasDiscount(discountResult[0]);
        printWeekdayDiscount(discountResult[1]);
        printWeekendDiscount(discountResult[2]);
        specialDiscount(discountResult[3]);
        System.out.println();
    }

    public void printChristmasDiscount(int amount){
        if(amount == 0){
            return;
        }
        System.out.println("크리스마스 디데이 할인: -" + NumberFormat.getInstance().format(amount) + "원");
    }

    public void printWeekdayDiscount(int amount){
        if(amount == 0){
            return;
        }
        System.out.println("평일 할인: -" + NumberFormat.getInstance().format(amount) + "원");
    }

    public void printWeekendDiscount(int amount){
        if(amount == 0){
            return;
        }
        System.out.println("주말 할인: -" + NumberFormat.getInstance().format(amount) + "원");
    }

    public void specialDiscount(int amount){
        if(amount == 0){
            return;
        }
        System.out.println("특별 할인: -" + NumberFormat.getInstance().format(amount) + "원");
    }

    public void printTotalDiscount(int amount){
        System.out.println("<총혜택 금액>");
        if(amount == 0){
            System.out.println("없음");
            System.out.println();
            return;
        }
        System.out.println("-" + NumberFormat.getInstance().format(amount) + "원");
        System.out.println();
    }

    public void printEachDiscountNothing(){
        System.out.println("<혜택 내역>");
        System.out.println("없음");
        System.out.println();
    }
}
