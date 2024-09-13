package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.Result;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

import static bridge.BridgeGame.move;
import static bridge.domain.Result.SUCCESS;
import static bridge.view.InputView.readBridgeSize;

public class BridgeGameController {
    boolean isRetry = true;
    private Bridge userBridge;
    public OutputView output;
    public int tryCount;

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        userBridge = new Bridge();
        tryCount = 0;
        do{
            startGame();
            output.printResult(userBridge, isSuccess(),tryCount);
        }while(isRetry);
    }
    public void startGame(){
        int size = inputSize();
        List<String> answerBridge = makeAnswerBridge(size);
        boolean isCollect = true;
        while(isCollect){
            tryCount++;
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

    public Result isSuccess(){
        return SUCCESS;
    }

}
