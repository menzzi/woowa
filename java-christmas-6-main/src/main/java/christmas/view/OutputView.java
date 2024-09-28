package christmas.view;

import java.text.NumberFormat;
import java.util.Map;

public class OutputView {
    public void printOrderMenu(Map<String,Integer> orderList){
        System.out.println("<주문 메뉴>");
        for(Map.Entry<String,Integer> order: orderList.entrySet()){
            System.out.println(order.getKey() + " " + order.getValue() + "개");
        }
        System.out.println();
    }

    public void printTotalOrderAmount(int totalAmount){
        System.out.println("할인 전 총주문 금액");
        System.out.println(NumberFormat.getInstance().format(totalAmount) + "원");
        System.out.println();
    }
}
