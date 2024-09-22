package lotto.controller;

import lotto.view.InputView;
import lotto.view.OutputView;

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
        String userMoney = input.inputMoney();
        int ticketCount = convertMoneyToTicketCount(userMoney);
        output.printTicketCount(ticketCount);



    }
    private int convertMoneyToTicketCount(String userMoney){
        return Integer.parseInt(userMoney)/1000;
    }
}
