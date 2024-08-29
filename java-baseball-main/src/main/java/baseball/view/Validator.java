package baseball.view;

public class Validator {
    public static void validateStringRestartOrEnd(String input){
        if(input.equals("1")||input.equals("2")){
            return;
        }
        throw new IllegalArgumentException("유효하지 않은 값입니다. 프로그램을 종료합니다.");
    }

    public static void validateStringThreeDifferentInput(String input){
        validateStringLength(input,3);
        validateStringNumbers(input);
        validateStringAllDifferent(input);
    }

    public static void validateStringLength(String input, int length){
        if(input.length() != length){
            throw new IllegalArgumentException("입력 길이는 3입니다.");
        }
    }

    public static void validateStringNumbers(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("숫자만 입력해주십시오.");
        }
    }
    public static void validateStringAllDifferent(String input){
        // 중복 검증 구현
    }
}
