import java.util.stream.Stream;

public class Test9 {
    public static void main(String[] args) {
        Stream.of("joe","robin","abhilash","krishna","jo","rakesh","kiran")
                .takeWhile(str -> str.length()> 2)
                .forEach(str -> System.out.println(str));
    }
}
