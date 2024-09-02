package lotto.controller;

import lotto.model.UserAmount;
import lotto.model.UserLottos;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    private static List<List<Integer>> userLottos;
    public void run(){

    }
    public void start(){
        String userAmount = InputView.inputUserAmount();
        int countLottoTicket = UserAmount.calculateAmount(userAmount);
        userLottos = UserLottos.generateUserLottos(countLottoTicket);

    }
}
