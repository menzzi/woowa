package baseball.controller;

import baseball.domain.Computer;
import baseball.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public void oneGame(){
        List<Integer> computerNumber = Computer.generateComputerNumber();
        List<Integer> userNumber = convertStringToList(InputView.userNumberInput());


    }

    public List<Integer> convertStringToList(String input){
        List<Integer> user = new ArrayList<>();
        for(int i=0;i<input.length();i++){
            user.add((int) input.charAt(i));
        }
        return user;
    }

}
