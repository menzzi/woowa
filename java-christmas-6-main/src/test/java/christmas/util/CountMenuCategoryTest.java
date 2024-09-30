package christmas.util;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountMenuCategoryTest {
    @Test
    void 디저트_카운트_테스트() {
        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("초코케이크", 2);
        orderMenu.put("레드와인", 1);

        int dessertCount = CountMenuCategory.countDessert(orderMenu);

        assertEquals(2, dessertCount);
    }

    @Test
    void 메인_카운트_테스트() {
        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("초코케이크", 2);
        orderMenu.put("티본스테이크", 1);

        int mainCount = CountMenuCategory.countMain(orderMenu);

        assertEquals(1, mainCount);
    }
}
