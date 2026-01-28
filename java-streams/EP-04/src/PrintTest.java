public class PrintTest {
    public static void main(String[] args) {
        IPrint iPrint = PrintTest::print;
        iPrint.printData("abhilash");
    }

    public static String print(String string){
        System.out.println(string);
        return string;
    }
}
