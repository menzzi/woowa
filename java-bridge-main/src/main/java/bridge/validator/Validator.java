package bridge.validator;

public class Validator {
    public static void validateBridgeSize(int size){
        if(size < 3 || size > 20){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }
    public static void validateNumericInput(String inputSize){
        try {
            Integer.parseInt(inputSize);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값은 숫자여야 합니다.");
        }
    }
    public static void validateDirection(String direction){
        if(!direction.equals("U") && !direction.equals("D")){
            throw new IllegalArgumentException("[ERROR] 올바른 방향을 입력해주세요.");
        }
    }
    public static void validateRetryOrQuit(String retryOrQuit){
        if(!retryOrQuit.equals("R") && !retryOrQuit.equals("Q")){
            throw new IllegalArgumentException("[ERROR] 재시도 : R, 종료 : Q 를 입력하세요.");
        }
    }
}
