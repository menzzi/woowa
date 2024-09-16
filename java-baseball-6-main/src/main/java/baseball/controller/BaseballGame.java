package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private final InputView input;
    private final OutputView output;

    public BaseballGame(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }
    public void run(){
        do{
            System.out.println("숫자 야구 게임을 시작합니다.");
            oneGame();
        }while(isRetry());

    }
    public void oneGame(){
        List<Integer> computerNumber = Computer.generateComputerNumber();
        boolean proceed = true;
        while(proceed){
            System.out.print("숫자를 입력해주세요 :");
            List<Integer> userNumber = convertStringToList(input.userNumberInput());
            Result gameResult = compareNumber(computerNumber,userNumber);
            output.printResult(gameResult.getBall(),gameResult.getStrike());

            proceed = checkThreeStrike(gameResult.getStrike());
        }
    }

    public List<Integer> convertStringToList(String userInput){
        List<Integer> user = new ArrayList<>();
        for(int i=0;i<userInput.length();i++){
            user.add((int) userInput.charAt(i));
        }
        return user;
    }

    public Result compareNumber(List<Integer> computerNumber, List<Integer> userNumber){
        int ballCount = 0;
        int strikeCount = 0;

        for(int i = 0; i < userNumber.size(); i++){
            if(computerNumber.get(i) == userNumber.get(i)){
                strikeCount++;
                continue;
            }
            if(computerNumber.contains(userNumber.get(i))){
                ballCount++;
            }
        }

        return new Result(ballCount,strikeCount);
    }

    public boolean checkThreeStrike(int strikeCount){
        if(strikeCount==3){
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return false;
        }
        return true;
    }

    public boolean isRetry(){
        String retryInput = input.retryInput();
        return retryInput.equals("1");
    }

}
