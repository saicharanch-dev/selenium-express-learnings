import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test2 {
    public static void main(String[] args) {

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        integerStream.forEach(consumer);
    }
}
