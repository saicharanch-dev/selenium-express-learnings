import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

public class Test2 {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(2,5,6,54,2,4,1,0);
        Consumer<List<Integer>> sortingLogic= Collections::sort;
        sortingLogic.accept(integerList);
        System.out.println(integerList);

        BiFunction<Integer,Integer,Integer> sumFeature=Integer::sum;
        Integer sum = sumFeature.apply(10, 20);
        System.out.println(sum);

        BiFunction<Integer,Integer,Integer> sumFeature2=Test2::multiply;
        Integer sum1 = sumFeature2.apply(10, 20);
        System.out.println(sum1);

        BiPredicate<String,String> checkIfTwoStringsAreEqual= Objects::equals;
        boolean result = checkIfTwoStringsAreEqual.test("Abhi","Abhi123");
        System.out.println(result);

        BiFunction<String,String, Boolean> checkIfTwoStringsAreEqual1= Objects::equals;
        boolean result1 = checkIfTwoStringsAreEqual1.apply("Abhi","Abhi123");
        System.out.println(result1);


        Function<Object,Integer> calculateHash= Objects::hashCode;
        Integer hash = calculateHash.apply(new Test2());
        System.out.println(hash);

        Consumer<Object> calculateHash1= Objects::hashCode;
        calculateHash1.accept(new Test2());

        Consumer<String> printLogic = System.out::println;
        printLogic.accept("Hi saicharan");

        // here toUpperCase is not static method, but how we used it for method reference?
        // check EP-05
        IUpperCase iUpperCase = String::toUpperCase;
        String str = iUpperCase.convertStringToUpperCase("sai");
        System.out.println(str);
    }

    public static int multiply(int val1,int val2){
        return val1*val2;
    }
}
