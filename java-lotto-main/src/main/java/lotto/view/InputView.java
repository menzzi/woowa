package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputUserAmount(){
        System.out.println("구입 금액을 입력하세요.");
        return Console.readLine();
    }

    public static String inputLottoNumber(){
        System.out.println("당첨 번호를 입력하세요.");
        return Console.readLine();
    }

    public static String inputBonusNumber(){
        System.out.println("보너스 번호를 입력하세요.");
        return Console.readLine();
    }
}
