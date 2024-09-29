package christmas.util;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmountCalculationTest {

    @Test
    void 전체금액_계산(){
        Map<String,Integer> orderList = new HashMap<>();
        orderList.put("해산물파스타", 2);
        orderList.put("레드와인", 1);
        orderList.put("초코케이크", 1);

        int totalAmount = AmountCalculation.calculateTotalAmount(orderList);

        assertEquals(145000, totalAmount);
    }

    @Test
    void 전체금액_계산2(){
        Map<String,Integer> orderList = new HashMap<>();
        orderList.put("초코케이크", 1);

        int totalAmount = AmountCalculation.calculateTotalAmount(orderList);

        assertEquals(15000, totalAmount);
    }
}
