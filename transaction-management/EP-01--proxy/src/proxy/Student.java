package proxy;

public class Student implements DailySession{
    private Attendance attendance;

    @Override
    public void attendLesson() {
        System.out.println("attending the session");
    }

    public void attendLesson(Integer id){
        System.out.println("student with id "+ id+ " attending the session");
    }


    public Student(Attendance attendance) {
        this.attendance = attendance;
    }

    public Attendance getAttendance() {
        return attendance;
    }

    public void setAttendance(Attendance attendance) {
        this.attendance = attendance;
    }
}
