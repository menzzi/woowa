import org.junit.jupiter.api.Test;
import racingcar.validator.Validator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidatorTest {
    @Test
    void 이름_validator_실패(){
        final List<String> input = new ArrayList<>();
        input.add("pobi");
        input.add("mynameis");

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateName(input);
        });
    }
    @Test
    void 이름_validator_성공(){
        final List<String> input = new ArrayList<>();
        input.add("pobi");
        input.add("hello");

        assertDoesNotThrow(() -> {
            Validator.validateName(input);
        });
    }
    @Test
    void 시도횟수_validator_실패(){
        final String number = "pobi";

        assertThrows(IllegalArgumentException.class, () -> {
            Validator.validateTryNumber(number);
        });
    }
    @Test
    void 시도횟수_validator_성공(){
        final String number = "2";


        assertDoesNotThrow(() -> {
            Validator.validateTryNumber(number);
        });
    }
}
