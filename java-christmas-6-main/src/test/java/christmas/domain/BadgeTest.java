package christmas.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BadgeTest {

    @Test
    void 배지_별_획득(){
        int totalDiscountAmount = 8000;

        Badge badge = Badge.giveBadge(totalDiscountAmount);

        assertEquals(Badge.STAR, badge);
    }

    @Test
    void 배지_트리_획득(){
        int totalDiscountAmount = 12000;

        Badge badge = Badge.giveBadge(totalDiscountAmount);

        assertEquals(Badge.TREE, badge);
    }

    @Test
    void 배지_산타_획득(){
        int totalDiscountAmount = 21000;

        Badge badge = Badge.giveBadge(totalDiscountAmount);

        assertEquals(Badge.SANTA, badge);
    }

    @Test
    void 배지_낫싱_획득(){
        int totalDiscountAmount = 4000;

        Badge badge = Badge.giveBadge(totalDiscountAmount);

        assertEquals(Badge.NOTHING, badge);
    }
}
