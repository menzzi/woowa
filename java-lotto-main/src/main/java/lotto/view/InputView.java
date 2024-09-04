package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static String inputUserAmount(){
        System.out.println("구입 금액을 입력하세요.");
        return Console.readLine();
    }

    public static List<Integer> inputLottoNumber(){
        System.out.println("당첨 번호를 입력하세요.");
        return convertStringToList(Console.readLine());
    }

    public static String inputBonusNumber(){
        System.out.println("보너스 번호를 입력하세요.");
        return Console.readLine();
    }

    private static List<Integer> convertStringToList(String input){
        List<Integer> lottoNumber = new ArrayList<>();
        for(char c : input.toCharArray()){
            lottoNumber.add(Character.getNumericValue(c));
        }
        return lottoNumber;
    }
}
