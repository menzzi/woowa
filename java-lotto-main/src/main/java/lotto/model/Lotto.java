package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.exception.Exception;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplication(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            Exception.countException();
            throw new IllegalArgumentException();
        }
    }

    public void validateDuplication(List<Integer> numbers){
        HashSet<Integer> duplicateCheck = new HashSet<>(numbers);
        if(duplicateCheck.size()!=6){
            Exception.duplicateException();
            throw new IllegalArgumentException();
        }
    }

    public void validateRange(List<Integer> numbers){
        for (Integer number : numbers) {
            if (number > 45 || number < 1) {
                Exception.rangeException();
                throw new IllegalArgumentException();
            }
        }
    }
}
