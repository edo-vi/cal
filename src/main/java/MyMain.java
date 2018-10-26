import biweekly.component.VEvent;

import java.net.MalformedURLException;
import java.util.ArrayList;

//mvn clean compile assembly:single
public class MyMain {
    public static void main(String[] args) throws Exception {
        Parser par = new Parser(args);
        try {
            Downloader dwnldr = new Downloader(par.getQueries());
            IcalParser parser = new IcalParser(dwnldr.getEvents());
            ArrayList<Day> days = parser.getList();
            Record r = new Record(days);
            r.print();
        } catch (MalformedURLException e) {
            System.out.println("Error: " + e);
        }


    }
}
