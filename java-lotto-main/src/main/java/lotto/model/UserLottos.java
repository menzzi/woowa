package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLottos {
    private static List<Integer> userLottos;

    public static List<Integer> generateUserLottos(){
        userLottos = Randoms.pickUniqueNumbersInRange(1,45,6);
        List<Integer> lottoNumber = new ArrayList<>(userLottos);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

}
