package onboarding;

import java.util.Stack;

public class Problem2 {

    public static void removeDuplicate(Stack<Character> stack, int cnt){
        if(cnt<2){
            return;
        }
        while(cnt>0){
            stack.pop();
            cnt--;
        }
    }
    public static int countDuplicate(Stack<Character> stack, int cnt, char ch){
        if(stack.isEmpty()){
            stack.push(ch);
            return cnt+1;
        }
        if(stack.peek() == ch){
            stack.push(ch);
            return cnt+1;
        }
        if(stack.peek() != ch){
            removeDuplicate(stack,cnt);
            stack.push(ch);
            cnt = 1;
        }
        return cnt;
    }
    public static String deçrypt(String cryptogram){
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int dupliCount = 0;

        for(char c : cryptogram.toCharArray()){
            dupliCount = countDuplicate(stack,dupliCount,c);
        }
        removeDuplicate(stack,dupliCount);
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
    public static String solution(String cryptogram) {
        String answer = cryptogram;
        String compare = deçrypt(cryptogram);
        while(true){
            if(answer.equals(compare)) break;
            answer = compare;
            compare = deçrypt(answer);
        }
        return answer;
    }
}
