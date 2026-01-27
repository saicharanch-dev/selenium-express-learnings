import java.util.stream.Stream;

public class Test3 {
    public static void main(String[] args) {
        Stream.of("saicharan", "rakesh", "rahul", "rishikanth", "nikhil")
                .forEach(name -> System.out.println(name));
    }
}
