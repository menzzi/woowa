package view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {
    private final InputView inputView = new InputView();

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 시도횟수_입력_실패() {
        final String input = "h";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.inputTryNumber();
        });
    }

    @Test
    void 시도횟수_입력_성공(){
        final String input = "3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> {
            inputView.inputTryNumber();
        });
    }
}
