package proxy;

public class StudentProxy extends Student{

    public StudentProxy(Attendance attendance) {
        super(attendance);
    }

    @Override
    public void attendLesson(){
        if(!super.getAttendance().isPresent()){
            throw new RuntimeException("Student is not present and can't attend the session");
        }
        super.attendLesson();
    }
}
