import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortTest1 {
    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(6,1,4,8,9,2,4,5);
        System.out.println("Before sorting done "+integerList);

        //invoking static method using class name
        // only static methods can be used as method reference
        Isort isort = Collections::sort;

        isort.sortAList(integerList);
        System.out.println("After sorting done "+integerList);

    }
}
