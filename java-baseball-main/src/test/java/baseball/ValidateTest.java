package baseball;

import baseball.view.Validator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidateTest {

    @Test
    void validateLength1(){
        final String input = "34";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateStringLength(input,3);
        });
    }

    @Test
    void validateLength2(){
        final String input = "3456";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateStringLength(input,3);
        });
    }

    @Test
    void validateNumber1(){
        final String input = "hey";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateStringNumbers(input);
        });
    }

    @Test
    void validateNumber2(){
        final String input = "*^*";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateStringNumbers(input);
        });
    }




}
