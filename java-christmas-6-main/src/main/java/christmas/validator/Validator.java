package christmas.validator;

public class Validator {
    public static void validateExpectedDate(String input){
        validateNumberFormat(input);
        validateDateRange(input);
    }

    public static void validateNumberFormat(String input){
        try{
            Integer.parseInt(input);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    public static void validateDateRange(String input){
        int date = Integer.parseInt(input);
        if(date < 1 || date > 31){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }
}
