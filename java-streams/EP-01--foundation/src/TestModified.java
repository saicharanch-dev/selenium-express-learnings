import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TestModified {
    public static void main(String[] args) {
        Stream.generate(() -> "Hello stream")
                .forEach(s -> System.out.println("printing the string - " + s));
    }
}
