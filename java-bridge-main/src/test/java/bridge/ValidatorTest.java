package bridge;

import bridge.validator.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {

    @Test
    @DisplayName("정상 입력: 3 이상의 숫자")
    void readBridgeSize_validInput() {
        final int input = 4;

        assertDoesNotThrow(() -> {
            Validator.validateBridgeSize(input);
        });
    }

    @Test
    @DisplayName("범위를 벗어난 입력")
    void readBridgeSize_validInput2() {
        final int input = 21;

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateBridgeSize(input);
        });
    }

    @Test
    @DisplayName("숫자가 아닌 문자 입력")
    void readBridgeSize_validInput3() {
        String input = "U\n";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateNumericInput(input);
        });
    }

}
