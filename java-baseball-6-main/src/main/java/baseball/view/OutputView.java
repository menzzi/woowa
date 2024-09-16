package baseball.view;

public class OutputView {
    public static void printResult(int ball, int strike){
        if(isNothing(ball,strike)){
            printNothing();
            return;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
    public static boolean isNothing(int ball, int strike){
        if(ball == 0 && strike == 0) return true;
        return false;
    }

    public static void printNothing(){
        System.out.println("낫싱");
    }

    public static void printInputMessage(){
        System.out.print("숫자를 입력해주세요 :");
    }

}
