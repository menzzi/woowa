package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private static List<Integer> computerNumber;

    public static List<Integer> generateComputerNumber(){
        computerNumber = new ArrayList<>();
        while(computerNumber.size() < 3){
            int number = Randoms.pickNumberInRange(1,9);
            if(!computerNumber.contains(number)){
                computerNumber.add(number);
            }
        }
        return computerNumber;
    }
}
