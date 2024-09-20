package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.validator.Validator;
import racingcar.view.InputView;

import java.util.*;


public class RacingCarGame {

    private final InputView input;
    private static Map<String,String> cars;

    public RacingCarGame(InputView input) {
        this.input = input;
    }

    public void run(){

    }
    public void oneGame(){
        List<String> carNames = convertStringToList(input.inputCarNames());
        Validator.validateName(carNames);
        cars = Car.resetCar(carNames);
        int tryNum = input.inputTryNumber();
        proceedRacing(tryNum);
        List<String> racingResult = compareRoads();

    }
    public List<String> convertStringToList(String carNames){
        return Arrays.asList(carNames.split(","));
    }

    public static void proceedRacing(int num){
        for(int i=0;i<num;i++){
            moveOnce();
        }
    }
    public static void moveOnce(){
        for (String carName : cars.keySet()) {
            if (isFourOrMore()) {
                plusRoad(carName);
            }
        }
    }
    public static boolean isFourOrMore(){
        int randomNum = Randoms.pickNumberInRange(0,9);
        if(randomNum >= 4) return true;
        return false;
    }
    public static void plusRoad(String carName){
        cars.put(carName, cars.getOrDefault(carName, "") + "-");
    }
    public static List<String> compareRoads(){
        int maxRoad = 0;
        List<String> result = new ArrayList<>();
        for (String carName : cars.keySet()) {
            if(cars.get(carName).length() > maxRoad){
                maxRoad = cars.get(carName).length();
                result = new ArrayList<>();
                result.add(carName);
            }else if(cars.get(carName).length() == maxRoad){
                result.add(carName);
            }
        }
        return result;
    }


}
