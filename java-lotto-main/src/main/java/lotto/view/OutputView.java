package lotto.view;

public class OutputView {

    public static void printTicketCount(int count){
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printRankMessage(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printRank(String message, int countMatch){
        System.out.println(message + countMatch + "개");
    }

    public static void printRate(int rate){
        System.out.println("총 수익률은" + rate + "%입니다.");
    }

}
