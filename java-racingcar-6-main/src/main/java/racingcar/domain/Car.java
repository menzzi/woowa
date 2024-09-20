package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Car {

    public static Map<String,String> resetCar(List<String> names){
        Map<String,String> cars = new LinkedHashMap<>();

        for (String name : names) {
            cars.put(name, "");
        }
        return cars;
    }
}
