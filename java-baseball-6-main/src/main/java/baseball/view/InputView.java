package baseball.view;

import baseball.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String userNumberInput(){
        String input = Console.readLine();
        Validator.validateUserInput(input);
        return input;
    }
    public static String retryInput(){
        String input = Console.readLine();
        Validator.validateRetryInput(input);
        return input;
    }
}
