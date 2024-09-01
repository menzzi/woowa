package baseball.view;

import baseball.model.GameResult;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void displayResult(GameResult result){
        List<String> resultMessage = new ArrayList<>();
        if(isNothing(result)){
            System.out.println("낫싱");
        }
        if(isBall(result)){
            resultMessage.add(result.getBallCount() + "볼");
        }
        if(isStrike(result)){
            resultMessage.add(result.getStrikeCount() + "스트라이크");
        }
        System.out.println(String.join(" ",resultMessage));
    }

    private static boolean isNothing(GameResult result){
        return (result.getBallCount() == 0 && result.getStrikeCount() == 0);
    }
    private static boolean isBall(GameResult result){
        return result.getBallCount() > 0;
    }
    private static boolean isStrike(GameResult result){
        return result.getStrikeCount() > 0;
    }
    public static void displayGameWinMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다. 게임 종료!!");
    }

    public static void displayGameEndMessage(){
        System.out.println("게임이 종료되었습니다.");
    }
}
