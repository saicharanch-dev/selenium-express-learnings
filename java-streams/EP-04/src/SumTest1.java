public class SumTest1 {
    public static void main(String[] args) {
        Isum isumLamdaWay = ((value1, value2) -> value1+value2);

        int sum = isumLamdaWay.sum(10, 20);
        System.out.println("printing sum using lamdaway: " + sum);
    }
}
