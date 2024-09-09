package bridge;

import bridge.domain.Bridge;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeTest {
    private Bridge bridge;
    private Map<Integer, StringBuilder> bridgeStatus;

    @BeforeEach
    void setUp() {
        bridgeStatus = new HashMap<>();
        bridgeStatus.put(0, new StringBuilder());
        bridgeStatus.put(1, new StringBuilder());
        bridge = new Bridge(bridgeStatus);
    }

    @Test
    @DisplayName("Bridge 테스트 (입력 : D)")
    void updateBridgeStatus_Down() {
        bridge.updateBridgeStatus(0);
        assertEquals(" O ", bridgeStatus.get(0).toString());
        assertEquals("   ", bridgeStatus.get(1).toString());
    }
    @Test
    @DisplayName("Bridge 테스트 (입력 : DD)")
    void updateBridgeStatus_DownDown() {
        bridge.updateBridgeStatus(0);
        bridge.updateBridgeStatus(0);
        assertEquals(" O | O ", bridgeStatus.get(0).toString());
        assertEquals("   |   ", bridgeStatus.get(1).toString());
    }

    @Test
    @DisplayName("Bridge 테스트 (입력 : U)")
    void updateBridgeStatus_Up() {
        bridge.updateBridgeStatus(1);
        assertEquals("   ", bridgeStatus.get(0).toString());
        assertEquals(" O ", bridgeStatus.get(1).toString());
    }

    @Test
    @DisplayName("Bridge 테스트 (입력 : UU)")
    void updateBridgeStatus_UpUp() {
        bridge.updateBridgeStatus(1);
        bridge.updateBridgeStatus(1);
        assertEquals("   |   ", bridgeStatus.get(0).toString());
        assertEquals(" O | O ", bridgeStatus.get(1).toString());
    }

    @Test
    @DisplayName("Bridge 테스트 (입력 : UD)")
    void updateBridgeStatus_UpDown() {
        bridge.updateBridgeStatus(1);
        bridge.updateBridgeStatus(0);
        assertEquals("   | O ", bridgeStatus.get(0).toString());
        assertEquals(" O |   ", bridgeStatus.get(1).toString());
    }

}
