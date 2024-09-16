package baseball;

import baseball.controller.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();


        BaseballGame baseballGame = new BaseballGame(inputView,outputView);
        baseballGame.run();
    }
}
