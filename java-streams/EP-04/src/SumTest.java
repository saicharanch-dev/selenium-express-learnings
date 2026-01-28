public class SumTest {
    public static void main(String[] args) {
        Isum isum = new Isum() {
            @Override
            public int sum(int value1, int value2) {
                return value1 + value2;
            }
        };

        int sum = isum.sum(10, 20);
        System.out.println("printing sum : " + sum);
    }
}
