package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public void printTicketCount(int ticketCount){
        System.out.println(ticketCount + "개를 구매했습니다.");
    }
    public void printLottoTicketsResult(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            System.out.println(lotto);
        }
    }
}
