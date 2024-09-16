package baseball;

import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

public class ComputerTest {
    @Test
    void 컴퓨터_숫자_생성_테스트() {
        try (MockedStatic<Randoms> randomsMock = mockStatic(Randoms.class)) {
            // 랜덤 숫자가 순서대로 1, 2, 3을 반환하도록 설정
            randomsMock.when(() -> Randoms.pickNumberInRange(1, 9))
                    .thenReturn(1, 2, 3);

            // 컴퓨터 숫자 생성
            List<Integer> generatedNumbers = Computer.generateComputerNumber();

            // 예상 결과: [1, 2, 3]
            assertEquals(List.of(1, 2, 3), generatedNumbers);

            // Randoms.pickNumberInRange()가 3번 호출되었는지 확인
            randomsMock.verify(() -> Randoms.pickNumberInRange(1, 9), times(3));
        }
    }

    @Test
    void 중복_숫자_처리_테스트() {
        try (MockedStatic<Randoms> randomsMock = mockStatic(Randoms.class)) {
            // 1, 1, 2, 3을 반환하도록 설정 (중복 처리 확인)
            randomsMock.when(() -> Randoms.pickNumberInRange(1, 9))
                    .thenReturn(1, 1, 2, 3);

            // 컴퓨터 숫자 생성
            List<Integer> generatedNumbers = Computer.generateComputerNumber();

            // 예상 결과: [1, 2, 3] (중복이 제거된 후 최종적으로 [1, 2, 3]이 나와야 함)
            assertEquals(List.of(1, 2, 3), generatedNumbers);

            // Randoms.pickNumberInRange()가 4번 호출되었는지 확인
            randomsMock.verify(() -> Randoms.pickNumberInRange(1, 9), times(4));
        }
    }
}
