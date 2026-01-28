import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test7 {
    public static void main(String[] args) {
        Supplier<Employee> employeeSupplier = () -> {
            return new Employee();
        };

        Employee employee = employeeSupplier.get();
        System.out.println(employee);

        Supplier<Employee> employeeSupplier1 = Employee::new;
        Employee employee1 = employeeSupplier1.get();
        System.out.println(employee1);

        Function<Integer,Employee> employeeSupplier2 = Employee::new;
        Employee employee2 = employeeSupplier2.apply(10);
        System.out.println(employee2);

        BiFunction<Integer,String,Employee> biFunction = Employee::new;
        Employee employee3 = biFunction.apply(10, "abhilash");
        System.out.println(employee3);
    }
}
