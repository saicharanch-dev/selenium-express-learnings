import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Test4Modified {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stream<Integer> streamOfIntegers = Arrays.stream(numbers);
        streamOfIntegers
                .peek(num -> System.out.println("peek processing number : " + num))
                .filter((num -> {
                    System.out.println("filter applying filter condition on number : " + num);
                    return num > 5;
                }))
                .forEach((num -> {
                    System.out.println("pinting the number : " + num);
                    System.out.println(num);
                }));
    }
}
