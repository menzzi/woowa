package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {
    private final InputView inputView = new InputView();

    @AfterEach
    void closeConsole(){
        Console.close();
    }

    @Test
    void 예상날짜_범위_실패(){
        final String input = "35";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.inputExpectedDate();
        });
    }

    @Test
    void 예상날짜_범위_실패2(){
        final String input = "-1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.inputExpectedDate();
        });
    }

    @Test
    void 예상날짜_숫자입력_실패(){
        final String input = "오";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.inputExpectedDate();
        });
    }

    @Test
    void 예상날짜_입력_성공(){
        final String input = "24";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() ->{
            inputView.inputExpectedDate();
        });
    }
}
