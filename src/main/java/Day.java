import java.util.ArrayList;

public class Day {
    private MyDate date;
    private ArrayList<Class> classes;

    Day(MyDate d, ArrayList<Class> c) {
        setDate(d);
        setClasses(c);
    }

    public MyDate getDate() {
        return date;
    }

    public void setDate(MyDate date) {
        this.date = date;
    }

    public ArrayList<Class> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }
}
