public class SumTest3 {
    public static void main(String[] args) {

        //method  reference
        Isum isum = Integer::sum;
//         (a,b) -> {
//            return Integer.sum(a, b);
//         };
        int sum = isum.sum(10, 20);
        System.out.println("printing sum method reference way using Integer class : " + sum);
    }
}
