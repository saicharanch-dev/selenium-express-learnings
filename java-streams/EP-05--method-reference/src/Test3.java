public class Test3 {
    public static void main(String[] args) {
       IAddtionV2 iAddtionV2 = Test3::doAddition;  // new Test3().doAddition(10,20)
        int sum = iAddtionV2.sum(new Test3(),10, 20);
        System.out.println(sum);
    }

    int doAddition(int val1,int val2){
        return val1+val2;
    }
}
