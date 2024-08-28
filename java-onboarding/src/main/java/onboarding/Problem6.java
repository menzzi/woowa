package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem6 {
    public boolean checkDuplication(String nickname1, String nickname2){
        int countDuplication = 0;
        for(int i=0;i<nickname1.length();i++){
            if(countDuplication >= 1) return true;
            if(nickname1.charAt(i) == nickname2.charAt(i)){
                countDuplication ++;
            }else if(nickname1.charAt(i) != nickname2.charAt(i)){
                countDuplication = 0;
            }
        }
        return false;
    }

    public static List<String> solution(List<List<String>> forms) {
        Problem6 T = new Problem6();
        List<String> answer = List.of("answer");

        for(int i=0;i<forms.size();i++){
            String startNickname = forms.get(i).get(1);
            for(int j=i+1;j<forms.size();j++){
                if(T.checkDuplication(startNickname,forms.get(j).get(1))){
                    return Collections.singletonList("true");
                }
            }
        }
        return answer;
    }
}
