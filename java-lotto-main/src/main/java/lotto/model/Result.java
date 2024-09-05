package lotto.model;

public class Result {
    private static Lotto lotto;
    private static int bonusBall;

    public Result(Lotto lotto, int bonusBall) {
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    public static Rank match(Lotto userNumber){
        int countMatch = userNumber.countMatch(lotto);
        boolean bonusMatch = userNumber.containNumber(bonusBall);
        return Rank.valueOf(countMatch, bonusMatch);
    }
}
