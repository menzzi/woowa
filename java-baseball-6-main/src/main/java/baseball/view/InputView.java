package baseball.view;

import baseball.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String userNumberInput(){
        String input = Console.readLine();
        Validator.validateUserInput(input);
        return input;
    }
    public String retryInput(){
        String input = Console.readLine();
        Validator.validateRetryInput(input);
        return input;
    }
}
