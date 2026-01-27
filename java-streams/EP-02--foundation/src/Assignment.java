import java.util.ArrayList;
import java.util.List;

public class Assignment {
    public static void main(String[] args) {

        //print the first 2 students name whose age is greater than 25

        getStudentList().stream()
                .filter(student -> student.getAge() > 25)
                .map(student -> student.getStudentName())
                .limit(2)
                .forEach(studentName -> System.out.println(studentName));


    }

    public static List<Student> getStudentList() {
        ArrayList<Student> studentArrayList = new ArrayList<>();

        Student abhilash = new Student(1, 32, "abhilash");
        Student jatin = new Student(2, 22, "jatin");
        Student rakesh = new Student(3, 20, "rakesh");
        Student soumik = new Student(4, 27, "soumik");
        Student priya = new Student(5, 31, "priya");
        Student lavanya = new Student(6, 30, "lavanya");
        Student chitra = new Student(7, 19, "chitra");

        studentArrayList.add(abhilash);
        studentArrayList.add(jatin);
        studentArrayList.add(rakesh);
        studentArrayList.add(soumik);
        studentArrayList.add(priya);
        studentArrayList.add(lavanya);
        studentArrayList.add(chitra);

        return studentArrayList;
    }
}
