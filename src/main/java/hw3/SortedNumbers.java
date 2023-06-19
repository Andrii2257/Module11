package hw3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SortedNumbers {
    public static void main(String[] args) {
            String[] array = {"1, 2, 0", "4, 5"};

            String sortedNumbersString = Arrays.stream(array)
                    .flatMap(element -> Arrays.stream(element.split(", ")))
                    .map(str -> str.trim())
                    .map(str -> Integer.parseInt(str))
                    .sorted()
                    .map(obj -> obj.toString())
                    .collect(Collectors.joining(", "));

            System.out.println(sortedNumbersString);
        }
    }
