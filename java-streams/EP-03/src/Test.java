import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .filter(integer -> {
                    System.out.println("filter: applyng filter on the number : " + integer);
                    return integer < 8;
                })
                .map(integer -> {
                    System.out.println("map : mapping number to num*num :" + integer);
                    return integer * integer;
                })
                .forEach(integer -> System.out.println(integer));
    }
}
