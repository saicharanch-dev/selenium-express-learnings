import java.util.stream.Stream;

public class Test10 {
    public static void main(String[] args) {
        Stream.of("joe","robin","abhilash","krishna","jo","rakesh","kiran")
                .skip(3);
//                .forEach(str -> System.out.println(str));

        Stream.of("joe","robin","abhilash","krishna","jo","rakesh","kiran", "abilash","joe")
                .distinct()
                .forEach(str -> System.out.println(str));
    }
}
