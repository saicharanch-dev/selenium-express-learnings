import java.util.stream.Stream;

public class Test6 {
    public static void main(String[] args) {
        //sort - stateful intermediate operation
        Stream.of(10, 1, 3, 2, 4, 7, 6, 8, 5, 9)
                .filter(num -> {
                    System.out.println("filter filtering num : " + num);
                    return num > 0;
                })
                .sorted()
                .peek(num -> System.out.println("peek displaying num : " + num))
                .forEach(num -> System.out.println("forEach displaying num: " + num));

    }
}
