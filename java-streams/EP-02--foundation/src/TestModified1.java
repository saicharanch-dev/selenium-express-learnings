import java.util.stream.Stream;

public class TestModified1 {
    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6,7,8,9,10)
                .filter(num -> num>5)
                .forEach(num -> System.out.println(num));
    }
}
