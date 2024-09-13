package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.BridgeGame.move;
import static bridge.view.InputView.readBridgeSize;

public class BridgeGameController {
    boolean isRetry = true;
    private Bridge userBridge;
    public OutputView output;

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        userBridge = new Bridge();
        do{
            startGame();
            output.printResult(userBridge);
        }while(isRetry);
    }
    public void startGame(){
        int size = inputSize();
        List<String> answerBridge = makeAnswerBridge(size);
        boolean isCollect = true;
        while(isCollect){
            isCollect = move(answerBridge,userBridge, InputView.readMoving());
            output.printMap(userBridge);
        }

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

}
