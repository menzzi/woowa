package lotto.model;

import lotto.exception.Exception;

public class User {
    public static int calculateAmount(String userAmount){
        int amount = validateNumber(userAmount);
        validateRange(amount);
        return amount / 1000;
    }

    private static int validateNumber(String userInput){
        try{
            return Integer.parseInt(userInput);
        }catch (NumberFormatException e){
            Exception.typeException();
            throw new IllegalArgumentException();
        }
    }

    private static void validateRange(int amount){
        if(amount % 1000 != 0){
            Exception.moneyRangeException();
            throw new IllegalArgumentException();
        }
    }
}
