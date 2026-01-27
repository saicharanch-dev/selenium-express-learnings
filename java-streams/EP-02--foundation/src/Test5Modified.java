import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test5Modified {
    public static void main(String[] args) {
        // number greater than 3 to words
        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Stream<Integer> integerStream = Arrays.stream(integers);
        Stream<Integer> filteredIntegerStream = integerStream.filter(num -> {
            System.out.println("filter applying filter for number  : "+num);
            return num>5;
        });
        Stream<String> mappedSteam = filteredIntegerStream.map(num -> {
            System.out.println("map mapping number : "+num);
            switch (num) {
                case 1:
                    return "One";
                case 2:
                    return "Two";
                case 3:
                    return "Three";
                case 4:
                    return "Four";
                case 5:
                    return "Five";
                case 6:
                    return "Six";
                case 7:
                    return "Seven";
                case 8:
                    return "Eight";
                case 9:
                    return "Nine";
                case 10:
                    return "Ten";
            }
            return "Numbers in word not available";
        });

        long count = mappedSteam.count();
        System.out.println("inside the mappedStream "+count+ " elements are available");

//        List<String> collect = mappedSteam.collect(Collectors.toList());
//        System.out.println("printing list : "+collect);

//       mappedSteam
//                .forEach(num -> System.out.println(num));
    }
}
