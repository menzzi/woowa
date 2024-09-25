package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        HashSet<Integer> lottoNumbers = new HashSet<>(numbers);
        if(lottoNumbers.size() != numbers.size()){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }

    public static List<Integer> generateLotto(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int countMatchNumber(WinningLotto winningLotto){
        int matchCount = 0;
        for(Integer number:numbers){
            if (winningLotto.getWinningLotto().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean isMatchBonusNumber(WinningLotto winningLotto){
        boolean checkMatch = false;
        if(numbers.contains(winningLotto.getBonusNumber())){
            checkMatch = true;
        }
        return checkMatch;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
