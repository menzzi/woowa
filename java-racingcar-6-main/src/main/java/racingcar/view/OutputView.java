package racingcar.view;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printResult(Map<String,String> cars){
        for (String carName : cars.keySet()) {
            System.out.println(carName + " : " + cars.get(carName));
        }
    }

    public void printWinner(List<String> result){
        StringBuilder stringBuilder = new StringBuilder();
        if(result.size()==1){
            System.out.println("최종 우승자 : " + result.get(0));
        }else{
            stringBuilder.append("최종 우승자 : ");
            printManyWinner(result,stringBuilder);
            System.out.println(stringBuilder.toString());
        }
    }
    public void printManyWinner(List<String> result,StringBuilder stringBuilder){
        for(int i=0;i<result.size();i++){
            stringBuilder.append(result.get(i));
            if(i!=result.size()-1){
                stringBuilder.append(", ");
            }
        }
    }
}
