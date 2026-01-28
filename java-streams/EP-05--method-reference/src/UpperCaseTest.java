public class UpperCaseTest {
    public static void main(String[] args) {
        IUpperCase iUpperCase= new UpperCaseTest()::convertToUpperCase;
        String uppercase = iUpperCase.convertStringToUpperCase("abhilash");
        System.out.println(uppercase);
    }

    String convertToUpperCase(String str){
        return str.toUpperCase();
    }
}
