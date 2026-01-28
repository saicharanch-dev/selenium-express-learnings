public class SumTest2 {
    public static void main(String[] args) {

        //method  reference
        Isum isum = SumTest2::addition;
        int sum = isum.sum(10, 20);
        System.out.println("printing sum method reference way : " + sum);
    }

    public static int addition(int value1, int value2) {
        return value1 + value2;
    }
}
