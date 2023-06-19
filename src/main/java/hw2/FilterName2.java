package hw2;

import java.util.List;
import java.util.stream.Collectors;

public class FilterName2 {
    public static List<String> sortString(List<String> strings) {
        return strings.stream()
                .map(s -> s.toUpperCase())
                .sorted((s1, s2) -> s2.compareTo(s1))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = List.of("1. Ivan", "2. Peter", "3. Sergiy", "4. David", "5. Richard");
        List<String> sortString = sortString(strings);
        sortString.forEach(System.out::println);
    }
}
