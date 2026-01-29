package dto;

public class Client {
    public static void main(String[] args) {
        ITEmployee itEmployee = new ITEmployee();
        itEmployee.setId(101);
        itEmployee.setName("abhilash");
        itEmployee.setSalary(30000);

        itEmployee.giveHike(5000);

        System.out.println(itEmployee.getSalary());
    }
}
