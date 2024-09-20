package view;

import org.junit.jupiter.api.Test;
import racingcar.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OutputViewTest {
    private final OutputView outputView = new OutputView();

    @Test
    void 결과_출력_성공() {
        // Given
        Map<String, String> cars = new HashMap<>();
        cars.put("pobi", "----");
        cars.put("woni", "---");

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // When
        outputView.printResult(cars);

        // Then
        String expectedOutput = "pobi : ----\nwoni : ---\n";
        assertEquals(expectedOutput, outputStream.toString());

        // Reset the output
        System.setOut(System.out);
    }

    @Test
    void 우승자_한명_출력() {
        // Given
        List<String> result = Arrays.asList("pobi");

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // When
        outputView.printWinner(result);

        // Then
        String expectedOutput = "최종 우승자 : pobi\n";
        assertEquals(expectedOutput, outputStream.toString());

        // Reset the output
        System.setOut(System.out);
    }

    @Test
    void 우승자_여러명_출력() {
        // Given
        List<String> result = Arrays.asList("pobi", "woni");

        // Capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // When
        outputView.printWinner(result);

        // Then
        String expectedOutput = "최종 우승자 : pobi, woni\n";
        assertEquals(expectedOutput, outputStream.toString());

        // Reset the output
        System.setOut(System.out);
    }

}
