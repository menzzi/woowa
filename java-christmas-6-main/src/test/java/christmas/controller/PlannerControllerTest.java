package christmas.controller;

import christmas.domain.Badge;
import christmas.view.InputView;
import christmas.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlannerControllerTest {
    private InputView inputView;
    private OutputView outputView;
    private PlannerController plannerController;

    @BeforeEach
    void setUp() {
        inputView = mock(InputView.class);
        outputView = mock(OutputView.class);
        plannerController = new PlannerController(inputView, outputView);
    }

    @Test
    void 없음_출력_테스트() {
        int totalAmount = plannerController.printEachDiscount(new int[]{0, 0, 0, 0},false);

        assertEquals(0, totalAmount);
        verify(outputView).printEachDiscountNothing();
        verify(outputView).printTotalDiscount(0);
    }

    @Test
    void 할인_출력_테스트() {
        int[] discountResult = {1200, 2023, 0, 0};
        boolean isPresentation = false;

        int result = plannerController.printEachDiscount(discountResult, isPresentation);

        verify(outputView).printEachDiscount(discountResult, isPresentation);
        assertEquals(3223, result);
    }

    @Test
    void 베지_획득_테스트() {
        int totalDiscountAmount = 15000;

        Badge badge = Badge.giveBadge(totalDiscountAmount);

        assertEquals(Badge.TREE, badge);
    }
}
