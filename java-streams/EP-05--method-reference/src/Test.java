public class Test {
    public static void main(String[] args) {
        IAddition iAddition = (a, b) -> {
            return a + b;
        };

        int sum = iAddition.sum(10, 20);
        System.out.println(sum);

        IAddition iAddition2 = Test::doAddition;
        int sum1 = iAddition2.sum(10, 20);
        System.out.println(sum1);
    }

    public static int doAddition(int a, int b) {
        return a + b;
    }
}
