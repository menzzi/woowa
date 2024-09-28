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
        System.out.println("할인 전 총주문 금액");
        System.out.println(NumberFormat.getInstance().format(totalAmount) + "원");
        System.out.println();
    }
}
