import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class Class {
    private String name;
    private Date start;
    private Date end;

    Class(String namev, Date time1, Date time2) {
        setName(namev);
        setStart(time1);
        setEnd(time2);
    }

    public String toString() {
        String name = this.getCustomName();
        int toFill = 21-name.length() + 1; // the difference plus one space
        String init = "";
        init += name;
        for (int i = 0; i< toFill; i++) {
            init+=" ";
        }
        init += "║ ";
        init += this.getStartTime() + " - " + this.getEndTime() + "\n";
        return init;
    }

    public String getName() {
        return name;
    }

    public String getCustomName() {
        String name = this.getName();
        if (name.length()>21 && name.substring(0,17).equals("Programmazione ii")) {
            return "Programmazione II";
        } else if (name.equals("Sistemi operativi teoria")) {
            return "Sistemi operativi";
        } else {
            //trim
            int l = name.length();
            if (21<l) {
                l=21;
            }
            return name.substring(0,l);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart() {
        return start;
    }

    public String getStartTime() {
        Date sta = this.getStart();
        Calendar cal = Calendar.getInstance();
        cal.setTime(sta);
        return String.valueOf(cal.get(Calendar.HOUR_OF_DAY))+ ":" + String.valueOf(cal.get(Calendar.MINUTE));
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public String getEndTime() {
        Date end = this.getEnd();
        Calendar cal = Calendar.getInstance();
        cal.setTime(end);
        return String.valueOf(cal.get(Calendar.HOUR_OF_DAY))+ ":" + String.valueOf(cal.get(Calendar.MINUTE));
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
