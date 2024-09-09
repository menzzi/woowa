package bridge.domain;

import java.util.Map;

public class Bridge {
    private final Map<Integer, StringBuilder> bridgeStatus;

    public Bridge(Map<Integer, StringBuilder> bridgeStatus) {
        this.bridgeStatus = bridgeStatus;
    }

    public Map<Integer, StringBuilder> updateBridgeStatus(int direction) {
        if(direction==0 && isFirst(direction)){
            return appendDownFirst();
        }
        if(direction==0 && !isFirst(direction)){
            return appendDown();
        }
        if(direction==1 && isFirst(direction)){
            return appendUpFirst();
        }
        return appendUp();
    }

    public boolean isFirst(int direction){
        if(bridgeStatus.get(direction).length()==0){
            return true;
        }
        return false;
    }
    public Map<Integer, StringBuilder> appendDownFirst(){
        bridgeStatus.get(0).append(" O ");
        bridgeStatus.get(1).append("   ");
        return bridgeStatus;
    }
    public Map<Integer, StringBuilder> appendUpFirst(){
        bridgeStatus.get(0).append("   ");
        bridgeStatus.get(1).append(" O ");
        return bridgeStatus;
    }
    public Map<Integer, StringBuilder> appendDown(){
        bridgeStatus.get(0).append("| O ");
        bridgeStatus.get(1).append("|   ");
        return bridgeStatus;
    }
    public Map<Integer, StringBuilder> appendUp(){
        bridgeStatus.get(0).append("|   ");
        bridgeStatus.get(1).append("| O ");
        return bridgeStatus;
    }

}
