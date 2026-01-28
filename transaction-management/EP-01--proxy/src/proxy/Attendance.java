package proxy;

import java.util.Date;

public class Attendance {
    private Date date;
    private boolean isPresent;

    public Attendance(Date date, boolean isPresent) {
        this.date = date;
        this.isPresent = isPresent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
