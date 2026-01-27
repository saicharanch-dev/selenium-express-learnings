import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Test4 {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //Imperative way of coding
//        for(Integer num: numbers){
//            if(num>5){
//                System.out.println(num);
//            }
//        }

        // declarative way of coding
        Stream<Integer> streamOfIntegers = Arrays.stream(numbers);
        Stream<Integer> filteredIntegerStream = streamOfIntegers.filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 5;
            }
        });
        filteredIntegerStream
                .forEach(num -> System.out.println(num));
    }
}
