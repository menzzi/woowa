package lotto.model;

public enum Rank{
    FIRST(6,2_000_000_000,"6개 일치 (2,000,000,000원) - "),
    SECOND(5,30_000_000,"5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD(5,1_500_000,"5개 일치 (1,500,000원) - "),
    FOURTH(4,50_000,"4개 일치 (50,000원) - "),
    FIFTH(3,5_000,"3개 일치 (5,000원) - "),
    MISS(0,0,"");

    Rank(int countMatch, int lottoMoney, String message) {
        this.countMatch = countMatch;
        this.lottoMoney = lottoMoney;
        this.message = message;
    }

    private int countMatch;
    private int lottoMoney;
    private String message;

    public static Rank valueOf(int countMatch,boolean bonusMatch){
        if(countMatch < 3){
            return MISS;
        }
        if(SECOND.matchCount(countMatch) && bonusMatch){
            return SECOND;
        }
        for(Rank rank : values()){
            if(rank.matchCount(countMatch) && rank != SECOND){
                return rank;
            }
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    private boolean matchCount(int countMatch){
        return this.countMatch == countMatch;
    }

    public String getMessage(){
        return message;
    }
}
