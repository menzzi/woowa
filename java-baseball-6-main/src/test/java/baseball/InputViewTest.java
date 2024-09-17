package baseball;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputViewTest {

    InputView inputView = new InputView();

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 사용자_숫자입력_실패() {
        final String input = "21";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.userNumberInput();
        });
    }

    @Test
    void 사용자_숫자입력_성공(){
        final String input = "123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> {
            inputView.userNumberInput();
        });
    }
    @Test
    void 재시작_종료_입력_실패(){
        final String input = "23";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> {
            inputView.retryInput();
        });
    }
    @Test
    void 재시작_종료_입력_성공(){
        final String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> {
            inputView.retryInput();
        });
    }
}
