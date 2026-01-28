import java.util.function.Function;
import java.util.function.Supplier;

public class Test4 {
    public static void main(String[] args) {
        String str = "selenium express";
        Supplier<String> toUpperCaseFn = str::toUpperCase;
        System.out.println(toUpperCaseFn.get());


        Function<String, String> toUpperCaseFn1 = String::toUpperCase;  // "abhilash".toUpperCase();
        System.out.println(toUpperCaseFn1.apply("abhilash"));
    }
}
