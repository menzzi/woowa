package baseball.view;

public class OutputView {
    public void printResult(int ball, int strike){
        if(isNothing(ball,strike)){
            printNothing();
            return;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
    public boolean isNothing(int ball, int strike){
        if(ball == 0 && strike == 0) return true;
        return false;
    }

    public void printNothing(){
        System.out.println("낫싱");
    }

}
