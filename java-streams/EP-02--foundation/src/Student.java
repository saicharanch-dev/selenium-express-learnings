public class Student {
    private int id;
    private int age;
    private String studentName;

    public Student(int id, int age, String studentName) {
        this.id = id;
        this.age = age;
        this.studentName = studentName;
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}
