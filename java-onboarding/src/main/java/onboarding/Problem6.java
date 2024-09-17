package onboarding;

import java.util.*;

public class Problem6 {
    public HashMap<String,Integer> makeCheckMap(List<List<String>> forms){
        HashMap<String,Integer> map = new HashMap<>();

        for(List<String> form:forms){
            String nickname = form.get(1);
            for(int i=0;i<nickname.length()-1;i++){
                String subNickname = nickname.substring(i,i+2);
                map.put(subNickname,map.getOrDefault(subNickname,0)+1);
            }
        }
        Set<String> keySet = map.keySet();
        List<String> removeKey = new ArrayList<>();
        for(String key:keySet){
            if(map.get(key) == 1){
                // map.remove(key); -> 순회하면서 remove 하니까 ConcurrentModificationException 오류 발생
                removeKey.add(key);
            }
        }
        for(String key:removeKey){
            map.remove(key);
        }
        return map;
    }

    public ArrayList<String> printEmail(HashMap<String,Integer> map, List<List<String>> forms){
        ArrayList<String> emails = new ArrayList<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickName = form.get(1);

            Set<String> keySet = map.keySet();
            for (String key : keySet) {
                if (nickName.contains(key)) {
                    emails.add(email);
                    break;
                }
            }
        }
        return emails;
    }

    public List<String> removeDuplicationAndSort(List<String> answer){
        Collections.sort(answer);
        HashSet<String> set = new HashSet<>(answer);
        answer = new ArrayList<>(set);
        return answer;
    }

    public static List<String> solution(List<List<String>> forms) {
        Problem6 T = new Problem6();

        HashMap<String,Integer> map = T.makeCheckMap(forms);
        List<String> answer = T.printEmail(map,forms);
        answer = T.removeDuplicationAndSort(answer);
        return answer;
    }
}
