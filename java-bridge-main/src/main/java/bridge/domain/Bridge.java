package bridge.domain;

import java.util.HashMap;
import java.util.Map;

public class Bridge {
    private final Map<Integer, StringBuilder> bridgeStatus;

    public Bridge() {
        this.bridgeStatus = new HashMap<>();
        bridgeStatus.put(0, new StringBuilder());
        bridgeStatus.put(1, new StringBuilder());
    }

    public Map<Integer, StringBuilder> getBridgeStatus() {
        return this.bridgeStatus;
    }

    public Map<Integer, StringBuilder> updateBridgeStatus(String direc, boolean isTrue) {
        int direction = convertStringToInt(direc);
        if(isFirst(direction)){
            return isTrue? appendCorrect(direction):appendIncorrect(direction);
        }
        appendBar();
        return isTrue? appendCorrect(direction):appendIncorrect(direction);
    }

    public int convertStringToInt(String direc){
        if(direc.equals("U"))return 1;
        return 0;
    }

    public boolean isFirst(int direction){
        if(bridgeStatus.get(direction).length()==0){
            return true;
        }
        return false;
    }

    private  Map<Integer, StringBuilder> appendCorrect(int direction){
        return direction==0? appendDownTrue():appendUpTrue();
    }

    private  Map<Integer, StringBuilder> appendIncorrect(int direction){
        return direction==0? appendDownFalse():appendUpFalse();
    }

    public Map<Integer, StringBuilder> appendDownTrue(){
        bridgeStatus.get(0).append(" O ");
        bridgeStatus.get(1).append("   ");
        return bridgeStatus;
    }

    public Map<Integer, StringBuilder> appendUpTrue(){
        bridgeStatus.get(0).append("   ");
        bridgeStatus.get(1).append(" O ");
        return bridgeStatus;
    }

    public Map<Integer, StringBuilder> appendDownFalse(){
        bridgeStatus.get(0).append(" X ");
        bridgeStatus.get(1).append("   ");
        return bridgeStatus;
    }

    public Map<Integer, StringBuilder> appendUpFalse(){
        bridgeStatus.get(0).append("   ");
        bridgeStatus.get(1).append(" X ");
        return bridgeStatus;
    }

    public void appendBar(){
        bridgeStatus.get(0).append("|");
        bridgeStatus.get(1).append("|");
    }
}
