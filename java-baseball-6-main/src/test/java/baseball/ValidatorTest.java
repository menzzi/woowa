package baseball;

import baseball.validator.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {
    @Test
    void validateLength1(){
        final String input = "34";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateInputLength(input);
        });
    }
    @Test
    void validateLength2(){
        final String input = "345";

        assertDoesNotThrow(() -> {
            Validator.validateInputLength(input);
        });
    }
    @Test
    void validateDuplicate1(){
        final String input = "335";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateDuplicateNumber(input);
        });
    }
    @Test
    void validateDuplicate2(){
        final String input = "345";

        assertDoesNotThrow(() -> {
            Validator.validateDuplicateNumber(input);
        });
    }
    @Test
    void validateNumberFormat1(){
        final String input = "><*";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateNumberFormat(input);
        });
    }
    @Test
    void validateNumberFormat(){
        final String input = "345";

        assertDoesNotThrow(() -> {
            Validator.validateNumberFormat(input);
        });
    }

    @Test
    void validateUserInput1(){
        final String input = "12";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateUserInput(input);
        });
    }
    @Test
    void validateUserInput2(){
        final String input = "123";

        assertDoesNotThrow(() -> {
            Validator.validateUserInput(input);
        });
    }
    @Test
    void validateRetryInput1(){
        final String input = "3";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateRetryInput(input);
        });
    }
    @Test
    void validateRetryInput2(){
        final String input = "1";

        assertDoesNotThrow(() -> {
            Validator.validateRetryInput(input);
        });
    }
}
