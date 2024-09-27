package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuTest {
    @Test
    void 메뉴찾기_실패(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Menu.MAINS.getItemByName("스파게티");
        });

        assertEquals("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.", exception.getMessage());
    }

    @Test
    void 메뉴찾기_성공(){
        MenuItem item = Menu.APPETIZERS.getItemByName("양송이수프");
        assertEquals("양송이수프", item.getName());
        assertEquals(6000, item.getPrice());
    }
}
