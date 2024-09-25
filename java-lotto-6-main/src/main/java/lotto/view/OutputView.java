package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printTicketCount(int ticketCount){
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    public void printLottoTicketsResult(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            System.out.println(lotto);
        }
    }

    public void printResultList(List<Result> resultList){
        Map<Result, Integer> resultCount = new HashMap<>();

        for (Result result : Result.values()) {
            resultCount.put(result, 0);
        }
        for (Result result : resultList) {
            resultCount.put(result, resultCount.get(result) + 1);
        }

        for(Result result: Result.values()){
            if(result == Result.MISS) continue;
            System.out.println(result.getMessage() + resultCount.get(result) + "개");
        }
    }
}
