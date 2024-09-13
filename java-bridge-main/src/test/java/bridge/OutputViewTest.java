package bridge;

import bridge.domain.Bridge;
import bridge.domain.Result;
import bridge.view.OutputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class OutputViewTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private OutputView outputView;
    private Bridge userBridge;

    @BeforeEach
    public void setUp() {
        // System.out 출력 캡처
        System.setOut(new PrintStream(outputStreamCaptor));

        // 테스트할 OutputView 인스턴스 생성
        outputView = new OutputView();

        // Bridge 상태를 초기화
        userBridge = new Bridge();
    }

    @Test
    @DisplayName("printMap 메서드 출력 테스트")
    public void testPrintMap() {
        Map<Integer, StringBuilder> statusMap = userBridge.getBridgeStatus();
        statusMap.get(1).append(" O ");
        statusMap.get(0).append("   ");
        outputView.printMap(userBridge);

        // 기대하는 출력
        String expectedOutput = "[ O ]\n[   ]\n";

        // 캡처된 출력 확인
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @Test
    @DisplayName("printResult 메서드 출력 테스트")
    public void testPrintResult() {
        Map<Integer, StringBuilder> statusMap = userBridge.getBridgeStatus();
        statusMap.get(1).append(" O ");
        statusMap.get(0).append("   ");
        outputView.printResult(userBridge, Result.SUCCESS,1);

        // 기대하는 출력
        String expectedOutput = "최종 게임 결과\n[ O ]\n[   ]\n\n게임 성공 여부: 성공\n총 시도한 횟수: 1\n";

        // 캡처된 출력 확인
        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }
}
