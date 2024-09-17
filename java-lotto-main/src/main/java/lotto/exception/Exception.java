package lotto.exception;

public class Exception {
    public static void typeException(){
        System.out.println("[ERROR] 문자가 아닌 숫자를 입력하세요.");
    }
    public static void rangeException(){
        System.out.println("[ERROR] 범위는 1~45 입니다.");
    }
    public static void countException(){
        System.out.println("[ERROR] 6개의 숫자를 입력하세요.");
    }
    public static void duplicateException(){
        System.out.println("[ERROR] 중복된 숫자를 입력하셨습니다.");
    }
    public static void moneyRangeException(){
        System.out.println("[ERROR] 금액은 1000원 단위입니다.");
    }

}
