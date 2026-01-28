import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Test6 {
    public static void main(String[] args) {
        ArrayList arrayList= new ArrayList<>();
        BiConsumer<ArrayList,Integer> biConsumer= ArrayList::add;
        biConsumer.accept(arrayList,10);
        System.out.println(arrayList);


        BiFunction<ArrayList,Integer,Boolean> biFunction = ArrayList::add;
        Boolean isAdded = biFunction.apply(arrayList, 20);
        System.out.println(isAdded);
        System.out.println(arrayList);

    }
}
