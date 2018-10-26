import biweekly.component.VEvent;

import java.time.LocalDate;
import java.util.*;

public class IcalParser {
    private final ArrayList<Class> alldays;
    private ArrayList<Day> days;

    IcalParser(List<VEvent> list) {
        alldays = new ArrayList<>();
        list.sort((a,b) -> a.getDateStart().getValue().compareTo(b.getDateStart().getValue()));
        for (VEvent l : list) {
            alldays.add(new Class(l.getSummary().getValue(), l.getDateStart().getValue(), l.getDateEnd().getValue()));
        }
        this.days = groupByDate(this.alldays);
    }

    public ArrayList<Day> getList() {
        return this.days;
    }
    private ArrayList<Day> groupByDate(ArrayList<Class> arr) {
        HashMap<MyDate, ArrayList<Class>> hash = new HashMap<>();
        for (Class c : arr) {
            MyDate start = new MyDate(c.getStart());
            if (!hash.containsKey(start)) {
                ArrayList<Class> ne = new ArrayList<>();
                ne.add(c);
                hash.put(start, ne);
            } else {
                ArrayList<Class> entry = hash.get(start);
                entry.add(c);
            }
        }
        ArrayList<Day> d = new ArrayList<>();

        hash.forEach((k,v) -> d.add(new Day(k,v)));
        return d;
    }

}

