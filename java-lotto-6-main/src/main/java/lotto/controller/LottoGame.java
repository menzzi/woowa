package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final InputView input;
    private final OutputView output;

    public LottoGame(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
    }

    public void run(){

    }

    public void proceedGame(){
        String userMoney = inputMoney();
        int ticketCount = convertMoneyToTicketCount(userMoney);
        output.printTicketCount(ticketCount);



    }

    private int convertMoneyToTicketCount(String userMoney){
        return Integer.parseInt(userMoney)/1000;
    }

    private List<Integer> convertStringToList(String input){
        String[] splitInput = input.split(",");
        List<Integer> numbers = new ArrayList<>();
    }

    private String inputMoney(){
        String userMoney;
        try{
            userMoney = input.inputMoney();
        } catch (IllegalArgumentException e) {
            return inputMoney();
        }
        return userMoney;
    }
}
