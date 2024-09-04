package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    public void run(){

    }
    public void start(){
        int countLottoTicket = inputUserAmount();
        OutputView.printTicketCount(countLottoTicket);
        List<List<Integer>> userLottos = UserLottos.generateUserLottos(countLottoTicket);


    }

    public int inputUserAmount(){
        String userAmount = InputView.inputUserAmount();
        return UserAmount.calculateAmount(userAmount);
    }
    public Result compareLottos(List<List<Integer>> lottoList){
        Lotto lotto = new Lotto(InputView.inputLottoNumber());
        int ball = InputView.inputBonusNumber();

        for(int i=0;i<lottoList.size();i++){

        }
    }
    public Map<Rank,Integer> resultMap(){

    }

}
