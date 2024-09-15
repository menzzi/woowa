package baseball.validator;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static void validateUserInput(String input){
        validateInputLength(input);
        validateDuplicateNumber(input);
        validateNumberFormat(input);
    }
    public static void validateInputLength(String input){
        if(input.length()!=3){
            throw new IllegalArgumentException("입력 길이는 3 입니다. 프로그램을 종료합니다.");
        }
    }
    public static void validateDuplicateNumber(String input){
        Set<Integer> numberSet = new HashSet<>();
        for(int i = 0 ; i < input.length() ; i++){
            numberSet.add((int) input.charAt(i));
        }
        if(numberSet.size()!=3){
            throw new IllegalArgumentException("중복된 입력입니다. 프로그램을 종료합니다.");
        }
    }
    public static void validateNumberFormat(String input){
        try{
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 값입니다. 프로그램을 종료합니다.");
        }
    }
    public static void validateRetryInput(String input){
        validateNumberFormat(input);
        validateRetryNumber(input);
    }
    public static void validateRetryNumber(String input){
        if(!input.equals("1")||!input.equals("2")){
            throw new IllegalArgumentException("유효하지 않은 값입니다. 프로그램을 종료합니다.");
        }
    }
}
