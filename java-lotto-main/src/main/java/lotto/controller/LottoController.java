package lotto.controller;

import lotto.model.User;
import lotto.view.InputView;

public class LottoController {

    public void run(){

    }
    public void start(){
        String userAmount = InputView.inputUserAmount();
        int countLottoTicket = User.calculateAmount(userAmount);


    }
}
