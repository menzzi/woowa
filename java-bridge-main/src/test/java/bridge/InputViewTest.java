package bridge;

import bridge.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class InputViewTest {

    @Test
    @DisplayName("다리 길이 입력 실패")
    void readBridgeSize_InvalidInput() {
        String input = "21";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> {
            InputView.readBridgeSize(); // 21은 유효하지 않으므로 예외 발생
        });
    }

    @Test
    @DisplayName("다리 길이 입력 실패 2")
    void readBridgeSize_InvalidInput2() {
        String input = "U";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> {
            InputView.readBridgeSize(); // 21은 유효하지 않으므로 예외 발생
        });
    }

    @Test
    @DisplayName("다리 길이 입력 성공")
    void readBridgeSize_validInput() {
        String input = "10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> {
            int size = InputView.readBridgeSize();
            assertEquals(10, size);
        });
    }

    @Test
    @DisplayName("이동할 칸 입력 실패")
    void readBridgeSize_InvalidMoving() {
        String input = "R";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> {
            InputView.readMoving();
        });
    }

    @Test
    @DisplayName("이동할 칸 입력 실패 2")
    void readBridgeSize_InvalidMoving2() {
        String input = "4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> {
            InputView.readMoving();
        });
    }

    @Test
    @DisplayName("이동할 칸 입력 성공")
    void readBridgeSize_validMoving() {
        String input = "U";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> {
            String inputMoving = InputView.readMoving();
            assertEquals("U", inputMoving);
        });
    }

    @Test
    @DisplayName("게임 재시도, 종료 여부 입력 실패")
    void readBridgeSize_InvalidGameCommand() {
        String input = "U";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> {
            InputView.readGameCommand();
        });
    }

    @Test
    @DisplayName("게임 재시도, 종료 여부 입력 실패 2")
    void readBridgeSize_InvalidGameCommand2() {
        String input = "4";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, () -> {
            InputView.readGameCommand();
        });
    }

    @Test
    @DisplayName("게임 재시도, 종료 여부 입력 성공")
    void readBridgeSize_validGameCommand() {
        String input = "R";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertDoesNotThrow(() -> {
            String inputMoving = InputView.readGameCommand();
            assertEquals("R", inputMoving);
        });
    }
}
