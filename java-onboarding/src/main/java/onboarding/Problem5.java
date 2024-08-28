package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem5 {

    public int exchange(int money, int unit){
        return money/unit;
    }
    public static List<Integer> solution(int money) {
        Problem5 T = new Problem5();
        List<Integer> answer = new ArrayList<>();
        int[] currency = {50000,10000,5000,1000,500,100,50,10,1};
        for(int unit:currency){
            answer.add(T.exchange(money,unit));
            money %= unit;
        }
        return answer;
    }
}
