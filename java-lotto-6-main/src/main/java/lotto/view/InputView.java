package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;

public class InputView {
    public static String inputMoney(){
        String input = Console.readLine();
        Validator.validateInputMoney(input);
        return input;
    }
    public static String inputWinLottoNumber(){
        return Console.readLine();
    }
    public static int inputBonusNumber(){
        String input = Console.readLine();
        Validator.validateBonusNumber(input);
        return Integer.parseInt(input);
    }
}
