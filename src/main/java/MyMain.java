import biweekly.component.VEvent;

import java.net.MalformedURLException;

public class MyMain {
    public static void main(String[] args) throws Exception {
        Parser par = new Parser(args);
        //todo remove
        try {
            Downloader dwnldr = new Downloader(par.getQueries());
            for (VEvent ve: dwnldr.getEvents()) {
                System.out.println(ve.getSummary().getValue());
                System.out.println(ve.getDateStart().getValue());
                System.out.println(ve.getDateEnd().getValue());
                System.out.println();
            }
        } catch (MalformedURLException e) {
            System.out.println("Error: " + e);
        }


    }
}
