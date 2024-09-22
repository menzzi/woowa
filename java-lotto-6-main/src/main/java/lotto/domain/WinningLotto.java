package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class WinningLotto {
    private final List<Integer> winningLotto;

    public WinningLotto(List<Integer> winningLotto){
        validate(winningLotto);
        validateDuplicate(winningLotto);
        this.winningLotto = winningLotto;
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
}
