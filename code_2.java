import java.util.*;

public class problem_2 {

    public static List<Object> combine(List<String> list1, List<Integer> list2) {

        List<Object> result = new ArrayList<>();

        // Add first list elements
        for (int i = 0; i < list1.size(); i++) {
            result.add(list1.get(i));
        }

        // Add second list elements
        for (int i = 0; i < list2.size(); i++) {
            result.add(list2.get(i));
        }

        return result;
    }

    public static void main(String[] args) {

        List<String> list1 = Arrays.asList("a", "b", "c");
        List<Integer> list2 = Arrays.asList(1, 2, 3);

        List<Object> result = combine(list1, list2);

        System.out.println(result);
    }
}