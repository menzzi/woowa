package onboarding;

import java.util.List;

class Problem1 {

    public static boolean checkException(List<Integer> pages){
        int left = pages.get(0);
        int right = pages.get(1);

        if(left != right -1){
            return false;
        }
        if(left < 1 || right > 400){
            return false;
        }
        if(left % 2 == 0){
            return false;
        }

        return true;
    }
    public static int[] split(int num){
        int third = num / 100;
        int second = (num % 100)/10;
        int first = num % 10;

        int[] splitNum = {third,second,first};
        return splitNum;
    }

    public static int calculateMaxAddOrMultiply(List<Integer> pages){
        int max = 0;
        int[] left = split(pages.get(0));
        int[] right = split(pages.get(1));

        int add = Math.max(left[0] + left[1] + left[2],right[0] + right[1] + right[2]);
        if(left[0]==0){
            left[0] = 1;
        }
        if(right[0]==0){
            right[0]=1;
        }
        int multiply = Math.max(left[0]*left[1]*left[2],right[0]*right[1]*right[2]);

        max = Math.max(add,multiply);

        return max;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(!checkException(pobi)||!checkException(crong)){
            return -1;
        }

        int maxPobi = calculateMaxAddOrMultiply(pobi);
        int maxCrong = calculateMaxAddOrMultiply(crong);

        if(maxPobi > maxCrong){
            return 1;
        }else if(maxPobi == maxCrong){
            return 0;
        }else{
            return 2;
        }

    }
}