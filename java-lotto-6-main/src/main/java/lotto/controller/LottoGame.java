package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final InputView input;
    private final OutputView output;
    private WinningLotto winningLotto;

    public LottoGame(InputView input, OutputView output, WinningLotto winningLotto) {
        this.input = input;
        this.output = output;
        this.winningLotto = winningLotto;
    }

    public void run(){

    }

    public void proceedGame(){
        String userMoney = inputMoney();
        int ticketCount = convertMoneyToTicketCount(userMoney);
        output.printTicketCount(ticketCount);
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<ticketCount;i++){
            List<Integer> lotto = Lotto.generateLotto();
            lottos.add(new Lotto(lotto));
        }
        //로또 결과 출력
        winningLotto = makeWinningLotto();
        // 생성한 로또와 결과 비교하기
        // 수익률 출력하기


    }

    private int convertMoneyToTicketCount(String userMoney){
        return Integer.parseInt(userMoney)/1000;
    }
    private List<Integer> covertStringToList(String[] numbers){
        List<Integer> WinningLotto = new ArrayList<>();
        for(String value : numbers){
            WinningLotto.add(Integer.parseInt(value));
        }
        return WinningLotto;
    }

    private String inputMoney(){
        String userMoney;
        try{
            userMoney = input.inputMoney();
        } catch (IllegalArgumentException e) {
            return inputMoney();
        }
        return userMoney;
    }

    private String[] inputWinningLotto(){
        String[] lotto;
        try{
            lotto = input.inputWinLottoNumber();
        }catch(IllegalArgumentException e){
            return inputWinningLotto();
        }
        return lotto;
    }

    private int inputBonusNumber(){
        int bonus;
        try{
            bonus = input.inputBonusNumber();
        }catch(IllegalArgumentException e){
            return inputBonusNumber();
        }
        return bonus;
    }

    private WinningLotto makeWinningLotto(){
        try{
            String[] winningNumbers = inputWinningLotto();
            int bonus = inputBonusNumber();
            winningLotto = new WinningLotto(covertStringToList(winningNumbers),bonus);
        }catch(IllegalArgumentException e){
            return makeWinningLotto();
        }
        return winningLotto;
    }
}
