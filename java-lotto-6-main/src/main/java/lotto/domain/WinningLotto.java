package lotto.domain;

import java.util.HashSet;
import java.util.List;

public class WinningLotto {
    private final List<Integer> winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningLotto, int bonusNumber){
        validate(winningLotto);
        validateDuplicate(winningLotto);
        validateBonusNumber(winningLotto,bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
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

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber){
        if(numbers.contains(bonusNumber)){
            throw new IllegalArgumentException("[ERROR] 로또 번호와 중복되면 안됩니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public List<Integer> getWinningLotto() {
        return winningLotto;
    }
}
