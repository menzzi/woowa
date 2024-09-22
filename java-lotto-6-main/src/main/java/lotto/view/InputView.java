package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.Validator;

public class InputView {
    public static String inputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        Validator.validateInputMoney(input);
        return input;
    }
    public static String inputWinLottoNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }
    public static int inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        Validator.validateBonusNumber(input);
        return Integer.parseInt(input);
    }
}
