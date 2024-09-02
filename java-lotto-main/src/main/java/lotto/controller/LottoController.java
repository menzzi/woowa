package lotto.controller;

import lotto.model.UserAmount;
import lotto.view.InputView;

public class LottoController {

    public void run(){

    }
    public void start(){
        String userAmount = InputView.inputUserAmount();
        int countLottoTicket = UserAmount.calculateAmount(userAmount);


    }
}
