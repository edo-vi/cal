import java.net.MalformedURLException;

public class MyMain {
    public static void main(String[] args) throws Exception {
        for (String arg : args) {
            System.out.println(new Option(arg, '='));
        }
        Parser par = new Parser(args);
        //todo remove
        for (HttpGetQuery que  : par.getQueries()) {
            System.out.println(que);
        }
        try {
            Downloader dwnldr = new Downloader(par.getQueries());
        } catch (MalformedURLException e) {
            System.out.println("error: " + e);
        }


    }
}
