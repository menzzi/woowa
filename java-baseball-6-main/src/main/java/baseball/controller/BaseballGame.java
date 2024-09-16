package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Result;
import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public void oneGame(){
        List<Integer> computerNumber = Computer.generateComputerNumber();
        List<Integer> userNumber = convertStringToList(InputView.userNumberInput());

        Result gameResult = compareNumber(computerNumber,userNumber);

    }

    public List<Integer> convertStringToList(String input){
        List<Integer> user = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            user.add((int) input.charAt(i));
        }
        return user;
    }

    public Result compareNumber(List<Integer> computerNumber, List<Integer> userNumber){
        int ballCount = 0;
        int strikeCount = 0;

        for(int i = 0; i < userNumber.size(); i++){
            if(computerNumber.get(i)==userNumber.get(i)){
                strikeCount++;
                continue;
            }
            if(computerNumber.contains(userNumber.get(i))){
                ballCount++;
            }
        }

        return new Result(ballCount,strikeCount);
    }

}
