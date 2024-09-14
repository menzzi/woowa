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
import static bridge.BridgeGame.retry;
import static bridge.domain.Result.FAILURE;
import static bridge.domain.Result.SUCCESS;
import static bridge.view.InputView.readBridgeSize;

public class BridgeGameController {
    private Bridge userBridge;
    private OutputView output;
    public int tryCount;

    public void run() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        int size = inputSize();
        List<String> answerBridge = makeAnswerBridge(size);
        userBridge = new Bridge();
        boolean isSuccess;
        tryCount = 1;
        do{
            isSuccess = startGame(size, answerBridge);
            if(isSuccess)break;
        }while(isRetryGame());
        output = new OutputView();
        output.printResult(userBridge,Result(isSuccess),tryCount);
    }
    public boolean startGame(int size, List<String> answerBridge){
        for(int idx = 0;idx < size;idx++){
            String direction = inputDirection();
            boolean isCollect = move(answerBridge,userBridge,direction,idx);
            output = new OutputView();
            output.printMap(userBridge);
            if(!isCollect) return false;
        }
        return true;
    }

    public boolean isRetryGame(){
        String input = inputRetry();
        if(input.equals("R")){
            userBridge = retry();
            tryCount++;
            return true;
        }
        return false;
    }
    public String inputRetry(){
        String input;
        try{
            input = InputView.readGameCommand();
        }catch(IllegalArgumentException e){
            output = new OutputView();
            output.printErrorMessage(e);
            return inputRetry();
        }
        return input;
    }

    public String inputDirection(){
        String input;
        try{
            input = InputView.readMoving();
        }catch(IllegalArgumentException e){
            output = new OutputView();
            output.printErrorMessage(e);
            return inputDirection();
        }
        return input;
    }

    public int inputSize(){
        int size;
        try{
            size = readBridgeSize();
        }catch(IllegalArgumentException e){
            output = new OutputView();
            output.printErrorMessage(e);
            return inputSize();
        }
        return size;
    }

    public List<String> makeAnswerBridge(int size){
        BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);
        return bridgeMaker.makeBridge(size);
    }

    public Result Result(boolean isSuccess){
        if(isSuccess){
            return SUCCESS;
        }
        return FAILURE;
    }
}
