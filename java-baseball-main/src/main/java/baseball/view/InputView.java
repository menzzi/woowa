package baseball.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getUserInput(String message){
        System.out.printf(message);
        return scanner.nextLine();
    }
}
