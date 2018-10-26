import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class MyDate {
    private int year;
    private int month;
    private int day;
    private String dayofweek;

    MyDate(Date date) {
        LocalDate temp = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        year=temp.getYear();
        month=temp.getMonthValue();
        day=temp.getDayOfMonth();
        dayofweek=temp.getDayOfWeek().getDisplayName(TextStyle.FULL_STANDALONE, Locale.ITALIAN);
    }

    public int hashCode() {
        return year+month+day;
    }

    public boolean equals(Object o) {
        o = (MyDate) o;
        return this.year==((MyDate) o).year && this.month==((MyDate) o).month &&
                this.day == ((MyDate) o).day && this.dayofweek .equals(((MyDate) o).dayofweek);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getDayofweek() {
        return dayofweek;
    }

    public void setDayofweek(String dayofweek) {
        this.dayofweek = dayofweek;
    }
}
