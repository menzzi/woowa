package lotto.controller;

import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.UserAmount;
import lotto.model.UserLottos;
import lotto.view.InputView;

import java.util.List;

public class LottoController {
    public void run(){

    }
    public void start(){
        int countLottoTicket = inputUserAmount();
        List<List<Integer>> userLottos = UserLottos.generateUserLottos(countLottoTicket);


    }

    public int inputUserAmount(){
        String userAmount = InputView.inputUserAmount();
        return UserAmount.calculateAmount(userAmount);
    }
    public Result compareLottos(List<List<Integer>> lottoList){
        Lotto lotto = new Lotto(InputView.inputLottoNumber());
        for(int i=0;i<lottoList.size();i++){

        }
    }

}
