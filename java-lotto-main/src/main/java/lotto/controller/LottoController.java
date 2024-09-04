package lotto.controller;

import lotto.model.UserAmount;
import lotto.model.UserLottos;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    public void run(){

    }
    public void start(){
        String userAmount = InputView.inputUserAmount();
        int countLottoTicket = UserAmount.calculateAmount(userAmount);
        List<List<Integer>> userLottos = UserLottos.generateUserLottos(countLottoTicket);



    }


}
