import java.io.PrintStream;
import java.util.function.BiConsumer;

public class Test5 {
    public static void main(String[] args) {
        BiConsumer<PrintStream,String> printFn = PrintStream::println;
        printFn.accept(new PrintStream(System.out),"please subscribe");
    }
}
