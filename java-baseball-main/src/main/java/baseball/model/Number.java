package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Number {

    private static List<Integer> computerNumbers;

    /* 난수 생성 */
    private static List<Integer> generateNumber(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size() < 3){
            int randomNum = Randoms.pickNumberInRange(1,9);
            if(!computer.contains(randomNum)){
                computer.add(randomNum);
            }
        }
        return computer;
    }

    public Number(){
        this.computerNumbers = generateNumber();
    }

    /* 입력된 문자열 List<Integer>로 변경 */
    public static List<Integer> convertStringToList(String input){
        List<Integer> userNumbers = new ArrayList<>();
        for(char c : input.toCharArray()){
            userNumbers.add(Character.getNumericValue(c));
        }
        return userNumbers;
    }

    public static List<Integer> getComputerNumbers() {
        computerNumbers = generateNumber();
        return computerNumbers;
    }
}
