import java.util.ArrayList;

public class Record {
    private ArrayList<Day> days;

    Record(ArrayList<Day> dys) {
        days=dys;
    }

    public String toString() {
        String init = "";
        for (Day d : days) {
            MyDate date = d.getDate();
            init += date.getDayofweek()+" " + date.getDay()+"/"+date.getMonth() + "\n";
            for (Class c : d.getClasses()) {
                init += c.getName() + " " + c.getStartTime() + " - " + c.getEndTime() + "\n";
            }
            init+="\n";
        }
        return init;
    }
    public void print() {
        System.out.println(this);
    }
}
