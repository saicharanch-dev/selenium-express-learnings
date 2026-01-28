import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Test9 {
    public static void main(String[] args) {
        List<String> stringList = List.of("abhilash", "abhishek","joe","ramesh","clarke","doe");

        stringList
                .stream()
                .map(Employee::new)
                .map(employee -> {
                    employee.setId(ThreadLocalRandom.current().nextInt(1,100));
                    return employee;
                })
                .map(Employee::getName)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }
}
