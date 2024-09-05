package lotto.model;

import java.util.List;

public class UserLottos {
    private static List<List<Integer>> userLottos;

    public static List<List<Integer>> generateUserLottos(int countLottoTicket){
        while(countLottoTicket > 0){
            List<Integer> lottoTicket = lottoMachine.generateNumber();
            new Lotto(lottoTicket);
            System.out.println(lottoTicket);
            userLottos.add(lottoTicket);
            countLottoTicket--;
        }
        return userLottos;
    }

}
