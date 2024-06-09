import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        
        // Initializing listOfLists with example data
        listOfLists.add(Arrays.asList(1, 5, 3));
        listOfLists.add(Arrays.asList(9, 2, 8));
        listOfLists.add(Arrays.asList(4, 7, 6));

        List<Integer> combinedList = listOfLists.stream()
                .flatMap(List::stream) // Flattening the list of lists into a single stream of integers
                .sorted(Comparator.reverseOrder()) // Sorting the integers in descending order
                .collect(Collectors.toList()); // Collecting the sorted integers into a list

        // Converting the list of integers to a single concatenated string
        String concatenated = combinedList.stream()
                .map(Object::toString)
                .reduce("", (a, b) -> a + b);

        System.out.println(concatenated);
    }
}
