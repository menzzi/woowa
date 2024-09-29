package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class PlannerControllerTest {
    private InputView inputView;
    private OutputView outputView;
    private PlannerController plannerController;

    @BeforeEach
    void setUp() {
        inputView = Mockito.mock(InputView.class);
        outputView = Mockito.mock(OutputView.class);
        plannerController = new PlannerController(inputView, outputView);
    }

    @Test
    void 디저트_카운트_테스트() {
        Map<String, Integer> orderMenu = new HashMap<>();
        orderMenu.put("초코케이크", 2);
        orderMenu.put("레드와인", 1);

        int dessertCount = plannerController.countDessert(orderMenu);

        assertEquals(1, dessertCount);  // Only 1 dessert item (초코케이크)
    }

    @Test
    void 없음_출력_테스트() {
        int totalAmount = plannerController.printEachDiscount(new int[]{0, 0, 0, 0},24000);

        assertEquals(0, totalAmount);
        verify(outputView).printEachDiscountNothing();
        verify(outputView).printTotalDiscount(0);
    }
}
