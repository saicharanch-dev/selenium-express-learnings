import java.util.Comparator;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Test7 {
    public static void main(String[] args) {
        Stream.iterate(0, new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer + 1;
            }
        })
//                .filter(integer -> integer<20)
                .limit(20)
//                .sorted(Comparator.reverseOrder())  // java heap memory error
                .forEach(integer -> System.out.println(integer));
    }
}
