package christmas.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DiscountTest {
    @Test
    void DiscountPolicy_테스트(){
        int orderDate = 3;
        int dessertCount = 2;
        int mainCount = 1;

        int[] discountResult = Discount.discountPolicy(orderDate,dessertCount,mainCount);

        assertArrayEquals(new int[]{1200, 4046, 0, 1000}, discountResult);
    }
}
