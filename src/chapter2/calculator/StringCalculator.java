package chapter2.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String text) {
        if (isEmptyOrNull(text)) return 0;

        return sum(toInt(split(text)));
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return sum;
    }

    private boolean isEmptyOrNull(String text) {
        return text.isEmpty() || text == null;
    }

    private int[] toInt(String[] text) {
        int[] numbers = new int[text.length];
        for (int i = 0; i < text.length; i++) {
            numbers[i] = toPositive(Integer.parseInt(text[i]));
        }

        return numbers;
    }

    private int toPositive(int number) {
        if (number < 0) throw new RuntimeException();

        return number;
    }

    private String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimeter = m.group(1);
            return m.group(2).split(customDelimeter);
        }

        return text.split(", | :");
    }
}
