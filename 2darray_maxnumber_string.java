import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
       List<List<Integer>> listOfLists = new ArrayList<>();

        // Initializing listOfLists with example data
        listOfLists.add(Arrays.asList(1, 9, 3));
        listOfLists.add(Arrays.asList(5, 2, 8));
        listOfLists.add(Arrays.asList(4, 7, 6));

        List<String> concatenatedStrings = listOfLists.stream()
                .map(row -> {
                    Collections.sort(row, Collections.reverseOrder());
                    return row.stream()
                            .map(Object::toString)
                            .reduce("", (subtotal, element) -> subtotal + element);
                })
                .toList();
        List<Integer> sortedIntegers = concatenatedStrings.stream()
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .toList();
        String finalResult = sortedIntegers.stream().map(Object::toString).reduce("", (first, second) -> first + second);
        System.out.println(finalResult);
    }
}
