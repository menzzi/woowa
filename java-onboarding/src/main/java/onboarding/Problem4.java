package onboarding;

public class Problem4 {

    public static int checkLeftOrRight(char c){
        int asciiChar = (int)c;
        if((asciiChar >= 65 && asciiChar <= 77) || (asciiChar >= 97 && asciiChar <= 109)){
            return -1;
        }else if((asciiChar > 77 && asciiChar <= 90) || (asciiChar > 109 && asciiChar <= 122)){
            return 1;
        }

        return 0;
    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for(int i=0;i<word.length();i++){
            checkLeftOrRight(word.charAt(i));
        }

        return answer.toString();
    }
}
