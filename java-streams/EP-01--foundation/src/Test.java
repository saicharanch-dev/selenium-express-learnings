import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "Hello stream";
            }
        };
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("printing the string - " + s);
            }
        };
        Stream<String> streamOfStrings = Stream.generate(supplier);
        streamOfStrings.forEach(consumer);
    }
}
