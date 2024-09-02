package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class lottoMachine {
    public List<Integer> generateNumber(){
        List<Integer> userLottoNumber = Randoms.pickUniqueNumbersInRange(1,45,6);
        Collections.sort(userLottoNumber);
        return userLottoNumber;
    }

}
