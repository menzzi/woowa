package christmas.controller;

import christmas.view.InputView;

public class PlannerController {
    private final InputView inputView;

    public PlannerController(InputView inputView){
        this.inputView = inputView;
    }

    public void run(){

    }

    public void eventPlanner(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        int expectedDate = Integer.parseInt(inputView.inputExpectedDate());
    }
}
