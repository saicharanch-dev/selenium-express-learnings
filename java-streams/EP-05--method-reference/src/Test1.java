public class Test1 {
    public static void main(String[] args) {
        IAddition iAddition = (a, b) -> {
            return a + b;
        };

        Test1 test1 =new Test1();
//        test1.doAddition(10.,20);

        int sum = iAddition.sum(10, 20);
        System.out.println(sum);

        IAddition iAddition2 = test1::doAddition;
        int sum1 = iAddition2.sum(10, 20);
        System.out.println(sum1);
    }

    public int doAddition(int a, int b) {
        return a + b;
    }
}
