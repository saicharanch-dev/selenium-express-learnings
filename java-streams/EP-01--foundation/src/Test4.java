import java.util.Arrays;
import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        Student abhilash = new Student(1, "Abhilash", 78748944, 23);
        Student jatin = new Student(2, "jatin", 2321, 50);
        Student rakesh = new Student(3, "rakesh", 665656565, 26);

        List<Student> studentList = Arrays.asList(abhilash, jatin, rakesh);

        for(Student student : studentList){
            System.out.println(student);
        }

        studentList.stream()
                .forEach(student -> System.out.println(student));

    }
}
