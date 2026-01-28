import java.util.function.BiFunction;

public class Sample {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "world";

        String result = str1.concat(str2);
        System.out.println(result);

        BiFunction<String, String, String> concatFn = String::concat;
        String res = concatFn.apply("seleniun", "express");
        System.out.println(res);
    }
}
