package lotto.model;

import lotto.exception.Exception;

public class User {
    public static int calculateAmount(String userAmount){
        int amount = Integer.parseInt(userAmount);
        if(amount % 1000 != 0){
            Exception.moneyRangeException();
            throw new IllegalArgumentException();
        }
        return amount / 1000;
    }
}
