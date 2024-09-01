package baseball.controller;

import baseball.model.GameResult;
import baseball.model.Number;
import baseball.view.OutputView;
import baseball.view.Validator;
import baseball.view.InputView;

import java.util.List;

import static baseball.view.OutputView.displayGameWinMessage;


public class BaseballGame {
    private static List<Integer> computerNumber;

    public void run(){
        System.out.println("숫자야구 게임을 시작합니다.");
        do{
            proceed();
        }while(isRestartGame());
    }

    private void proceed(){
        computerNumber = initNumber();
        System.out.println(computerNumber);
        proceedGame();
        endGame();
    }
    public void proceedGame(){
        while(true){
            String input = InputView.getUserInput("숫자를 입력해주세요 : ");
            Validator.validateUserInput(input);
            List<Integer> userInput = Number.convertStringToList(input);
            GameResult result = countBallOrStrike(userInput);
            OutputView.displayResult(result);
            if(isThreeStrike(result)){
                return;
            }
        }
    }

    private GameResult countBallOrStrike(List<Integer> userNumber){
        int balls = 0;
        int strikes = 0;

        for(int i = 0; i<userNumber.size(); i++){
            if(userNumber.get(i).equals(computerNumber.get(i))){
                strikes++;
            }else if(computerNumber.contains(userNumber.get(i))){
                balls++;
            }
        }
        return new GameResult(balls,strikes);
    }

    private boolean isThreeStrike(GameResult result){
        return result.getStrikeCount()==3;
    }

    private List<Integer> initNumber(){
        return Number.getComputerNumbers();
    }

    private boolean isRestartGame(){
        String input = InputView.getUserInput("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Validator.validateStringRestartOrEnd(input);
        return input.equals("1");
    }
    private void endGame(){
        displayGameWinMessage();
    }

}

