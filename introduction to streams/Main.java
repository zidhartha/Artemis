import java.util.*;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) {

    }

    public static double calculate(List<Double> input) {
        return input.stream()
                .filter(num -> num > 0)
                .map(num -> num*num)
                .reduce(0.0, Double::sum);
    }

    public static Set<Person> toSetForEach(List<Person> input) {
        Set<Person> result = new HashSet<>();
        input.forEach(t -> result.add(t));
        return result;
    }

    public static Set<Person> toSet(List<Person> input) {
        return input.stream().collect(Collectors.toSet());
    }

    public static double average(int[] input) {
        return Arrays.stream(input)
                .average()
                .orElse(0.0);
    }

    public static double averageAge(List<Person> input) {
        return input.stream()
                .mapToInt(Person :: getAge)
                .average()
                .getAsDouble();
    }

    public static Map<Integer, List<Person>> groupByAgeForEach(List<Person> input) {
        Map<Integer, List<Person>> result = new HashMap<>();
        input.forEach(person ->
                result.computeIfAbsent(person.getAge(), k -> new ArrayList<>())
                        .add(person));
        return result;
    }

    public static Map<Integer, List<Person>> groupByAge(List<Person> input) {
        return input.stream()
                .collect(Collectors.groupingBy(Person :: getAge));
    }
}