package lotto.view;

public class OutputView {

    public static void printTicketCount(int count){
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printRank(String message, int countMatch){
        System.out.println(message + countMatch + "개");
    }

}
