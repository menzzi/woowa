package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;

import java.util.List;

import static bridge.view.InputView.readBridgeSize;

public class BridgeGameController {
    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        do{
            startGame();
        }while(isProgress());
    }
    public void startGame(){
        int size = inputSize();
        List<String> answerBridge = makeAnswerBridge(size);

    }
    public int inputSize(){
        int size;
        try{
            size = readBridgeSize();
        }catch(IllegalArgumentException e){
            return inputSize();
        }
        return size;
    }

    public List<String> makeAnswerBridge(int size){
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        return bridgeMaker.makeBridge(size);
    }

    public boolean isProgress(){
        return false;
    }
}
