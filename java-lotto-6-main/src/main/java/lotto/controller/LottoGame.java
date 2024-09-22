package lotto.controller;

import lotto.view.InputView;

public class LottoGame {

    private final InputView input;

    public LottoGame(InputView input) {
        this.input = input;
    }
    public void run(){

    }
    public void proceedGame(){
        System.out.println("구입금액을 입력해 주세요.");
        String userMoney = input.inputMoney();
        int ticketCount = convertMoneyToTicketCount(userMoney);



    }
    private int convertMoneyToTicketCount(String userMoney){

    }
}
