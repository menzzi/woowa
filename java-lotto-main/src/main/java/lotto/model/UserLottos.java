package lotto.model;

import java.util.List;

public class UserLottos {
    private static List<List<Integer>> userLottos;

    public static List<List<Integer>> generateUserLottos(int countLottoTicket){
        while(countLottoTicket > 0){
            List<Integer> lottoTicket = lottoMachine.generateNumber();
            userLottos.add(lottoTicket);
            countLottoTicket--;
        }
        return userLottos;
    }

}
