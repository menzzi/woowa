package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeTest {
    @Test
    @DisplayName("BridgeMaker 테스트")
    void bridgeMakerTest() {
        // Mock 데이터를 생성
        List<Integer> predefinedNumbers = Arrays.asList(0, 1, 0, 1, 0); // 0은 "D", 1은 "U"
        BridgeNumberGenerator mockGenerator = new MockBridgeNumberGenerator(predefinedNumbers);
        BridgeMaker bridgeMaker = new BridgeMaker(mockGenerator);

        // 길이가 5인 다리 생성
        List<String> expectedBridge = Arrays.asList("D", "U", "D", "U", "D");
        List<String> actualBridge = bridgeMaker.makeBridge(5);

        // 결과 비교
        assertEquals(expectedBridge, actualBridge);
    }
    // BridgeNumberGenerator를 Mock으로 구현하는 클래스
    private static class MockBridgeNumberGenerator implements BridgeNumberGenerator {
        private final List<Integer> predefinedNumbers;
        private int index = 0;

        public MockBridgeNumberGenerator(List<Integer> predefinedNumbers) {
            this.predefinedNumbers = predefinedNumbers;
        }

        @Override
        public int generate() {
            if (index >= predefinedNumbers.size()) {
                throw new IllegalStateException("No more predefined numbers");
            }
            return predefinedNumbers.get(index++);
        }
    }
}
