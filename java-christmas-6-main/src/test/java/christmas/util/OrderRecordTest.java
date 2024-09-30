package christmas.util;

import org.junit.jupiter.api.*;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderRecordTest {
    @Test
    void 주문기록_테스트() {
        String input = "초코케이크-2,티본스테이크-1";

        Map<String, Integer> result = OrderRecord.orderMenu(input);

        assertEquals(2, result.get("초코케이크"));
        assertEquals(1, result.get("티본스테이크"));
    }

    @Test
    void 주문기록_메뉴존재안함_테스트() {
        String input = "존재하지않는메뉴-1";

        Exception exception = org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> {
            OrderRecord.orderMenu(input);
        });

        String expectedMessage = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}
