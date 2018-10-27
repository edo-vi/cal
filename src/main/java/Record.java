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
            String a = date.getDayofweek()+" " + date.getDay()+"/"+date.getMonth() + "\n";
            int l = a.length()-1;
            init +=a;
            init+= "══════════════════════╗";
            init += "\n";
            for (Class c : d.getClasses()) {
                init += c.toString();
            }
            init+="\n";
        }
        return init;
    }
    public void print() {
        System.out.println(this);
    }
}
