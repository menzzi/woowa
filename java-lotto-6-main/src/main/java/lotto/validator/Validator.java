package lotto.validator;

public class Validator {
    public static void validateInputMoney(String input){
        validateNumberFormat(input);
        validateMoneyUnit(input);
    }
    public static void validateBonusNumber(String input){
        validateNumberFormat(input);
        validateLottoNumberRange(input);
    }
    public static void validateNumberFormat(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자 단위가 아닙니다.");
        }
    }
    public static void validateMoneyUnit(String input){
        int unit = Integer.parseInt(input) % 1000;
        if(unit!=0){
            throw new IllegalArgumentException("[ERROR] 1,000 단위로 입력해주세요.");
        }
    }
    public static void validateLottoNumberRange(String input){
        int number = Integer.parseInt(input);
        if(number < 1 || number > 45){
            throw new IllegalArgumentException("[ERROR] 로또 번호 범위는 1~45 입니다.");
        }
    }
}
