package racingcar.controller;

import racingcar.domain.Car;
import racingcar.validator.Validator;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class RacingCarGame {

    private final InputView input;

    public RacingCarGame(InputView input) {
        this.input = input;
    }

    public void run(){

    }
    public void oneGame(){
        List<String> carNames = convertStringToList(input.inputCarNames());
        Validator.validateName(carNames);
        Map<String,String> cars = Car.resetCar(carNames);

    }
    public List<String> convertStringToList(String carNames){
        return Arrays.asList(carNames.split(","));
    }

    public (List<String> carNames){

    }


}
