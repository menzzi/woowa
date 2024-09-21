package racingcar.validator;

import java.util.List;

public class Validator {
    public static void validateName(List<String> names){
        if(names.isEmpty()) throw new IllegalArgumentException("이름이 입력되지 않았습니다. 프로그램을 종료합니다.");

        for(int i=0;i<names.size();i++){
            if(names.get(i).length() >= 6){
                throw new IllegalArgumentException("이름은 5자 이하입니다. 프로그램을 종료합니다.");
            }
        }
    }
    public static void validateTryNumber(String number){
        try{
            Integer.parseInt(number);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("숫자가 아닙니다. 프로그램을 종료합니다.");
        }
    }
}
