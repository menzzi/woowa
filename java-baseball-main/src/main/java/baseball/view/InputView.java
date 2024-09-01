package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Scanner;

public class InputView {
    public static String getUserInput(String message){
        Scanner scanner = new Scanner(System.in);

        System.out.printf(message);
        String userInput = scanner.nextLine();
        return userInput;
    }
}
