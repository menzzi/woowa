package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

public class LottoController {
    private List<Lotto> userLottos;
    private Result winningResult;

    public void run(){
        try{
            start();
        }catch (Exception e){
            log.print("[ERROR] ");
        }
    }

    public void start(){
        int countLottoTicket = inputUserAmount();
        OutputView.printTicketCount(countLottoTicket);

        userLottos = makeLottoList(countLottoTicket);
        winningResult = wingingResult(userLottos);
        lottoResult(userLottos,winningResult);
    }

    public int inputUserAmount(){
        String userAmount = InputView.inputUserAmount();
        return UserAmount.calculateAmount(userAmount);
    }

    public Result wingingResult(List<Lotto> lottoList){
        Lotto lotto = new Lotto(InputView.inputLottoNumber());
        List<Integer> winningNumber = lotto.getLottoNumber();
        int ball = InputView.inputBonusNumber();

        Lotto.validateBonusNumber(winningNumber,ball);
        winningResult = new Result(new Lotto(winningNumber), ball);
        return winningResult;
    }

    public void lottoResult(List<Lotto> userLottos,Result winningResult){

    }

    public Map<Rank,Integer> resultMap(List<Lotto> lottoList){
        Map<Rank,Integer> map = setMap();
        Rank rank;

        for(int i=0;i<lottoList.size();i++){
            map.put();
        }

    }

    private Map<Rank,Integer> setMap(){
        Map<Rank,Integer> result = new LinkedHashMap<>();

        for(Rank rank : Rank.values()){
            result.put(rank,0);
        }
        return result;
    }

    private List<Lotto> makeLottoList(int countLottoTicket){
        userLottos = new ArrayList<>();
        for(int i=0;i<countLottoTicket;i++){
            userLottos.add(makeLotto());
        }
        return userLottos;
    }

    private Lotto makeLotto(){
        UserLottos userLotto = new UserLottos();
        List<Integer> lotto = new ArrayList<>();
        lotto = userLotto.generateUserLottos();
        System.out.println(lotto);
        return new Lotto(lotto);
    }

}
