package onboarding;

public class Problem4 {

    public static int checkUpOrLow(char c){
        int asciiChar = (int)c;
        if(asciiChar >= 65 && asciiChar <= 90){
            return -1;
        }else if(asciiChar >= 97 && asciiChar <= 122){
            return 1;
        }

        return 0;
    }
    public static char exchangeUpper(char c){
        return (char) ('Z'-(c-'A'));
    }
    public static char exchangeLower(char c){
        return (char) ('z'-(c-'a'));
    }

    public static String solution(String word) {
        StringBuilder answer = new StringBuilder();

        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(checkUpOrLow(ch) == -1){
                answer.append(exchangeUpper(ch));
            }else if(checkUpOrLow(ch) == 1){
                answer.append(exchangeLower(ch));
            }else if(checkUpOrLow(ch) == 0){
                answer.append(" ");
            }
        }

        return answer.toString();
    }
}
