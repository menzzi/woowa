package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.*;

public class LottoController {
    private List<Lotto> userLottos;
    private Result winningResult;

    public void run(){
        try{
            start();
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    public void start(){
        int countLottoTicket = inputUserAmount();
        OutputView.printTicketCount(countLottoTicket);

        userLottos = makeLottoList(countLottoTicket);
        winningResult = wingingResult(userLottos);
        lottoResult(userLottos,winningResult,countLottoTicket);
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

    public void lottoResult(List<Lotto> userLottos, Result winningResult, int countLottoTicket){
        Map<Rank,Integer> result = setResult();
        Rank rank;
        OutputView.printRankMessage();

        for(int i=0;i<userLottos.size();i++){
            rank = Result.match(userLottos.get(i));
            result.put(rank,result.get(rank)+1);
        }

        for(int i = Rank.values().length-1; i>=0 ; i--){
            printResult(result);
        }
        printRate(result,countLottoTicket);
    }
    public static void printResult(Map<Rank,Integer> result){
        for(int i = Rank.values().length-1; i>=0 ; i--){
            if(Rank.values()[i] != Rank.MISS){
                OutputView.printRank(Rank.values()[i].getMessage(),result.get(Rank.values()[i]));
            }
        }
    }
    public static void printRate(Map<Rank,Integer> result, int amount){
        double rate = 0;
        for(Rank rank : result.keySet()){
            rate += (result.get(rank) * rank.getLottoMoney());
        }
        rate /= (amount*1000);
        OutputView.printRate(rate);
    }


    private Map<Rank,Integer> setResult(){
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
