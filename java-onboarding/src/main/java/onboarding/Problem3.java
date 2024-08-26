package onboarding;

public class Problem3 {

    public static int countClap(int num){
        int cnt = 0;
        if(num < 3) return cnt;
        int cur = 3;
        while(cur <= num){
            cnt += count369(cur);
            cur+=1;
        }
        return cnt;
    }
    public static int count369(int cur){
        int cnt = 0;
        while(cur>0){
            if(cur%10==3||cur%10==6||cur%10==9){
                cnt+=1;
            }
            cur/=10;
        }
        return cnt;
    }
    public static int solution(int number) {
        int answer = 0;
        answer = countClap(number);
        return answer;
    }
}
