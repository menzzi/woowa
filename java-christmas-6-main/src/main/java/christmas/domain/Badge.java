package christmas.domain;

public enum Badge {
    STAR(5000,"별"),
    TREE(10000, "트리"),
    SANTA(20000,"산타"),
    NOTHING(0,"");

    Badge(int benefitAmount, String badgeName) {
        this.benefitAmount = benefitAmount;
        this.badgeName = badgeName;
    }

    private final int benefitAmount;
    private final String badgeName;

    public static Badge giveBadge(int totalDiscountAmount){
        if(totalDiscountAmount >= SANTA.benefitAmount){
            return SANTA;
        }
        if(totalDiscountAmount >= TREE.benefitAmount){
            return TREE;
        }
        if(totalDiscountAmount>= STAR.benefitAmount){
            return STAR;
        }
        return NOTHING;
    }

    public String getBadgeName() {
        return badgeName;
    }
}
