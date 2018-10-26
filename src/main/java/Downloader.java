
import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;
import org.apache.http.client.utils.URIBuilder;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Downloader {
    private static String host = "logistica.univr.it/aule/Orario/ec_download_ical_grid.php";


    Downloader(ArrayList<HttpGetQuery> arr) throws Exception {
        URL url = buildURL(arr);
        InputStream stream = url.openStream();
        try {
            ICalendar cal = Biweekly.parse(stream).first();
            List<VEvent> events = cal.getEvents();
            stream.close();
            for( VEvent ev : events) {
                System.out.println(ev.getDateStart().getValue().getRawComponents().getMonth());
            }
        } catch(Exception e) {
            throw new Error();
        }

    }

    private URL buildURL(ArrayList<HttpGetQuery> arr) throws MalformedURLException {
        String scheme = "https://";
        String fi = scheme+host+"?";
        for(HttpGetQuery q : arr) {
            fi += (urlSanitize(q.fst())+"="+urlSanitize(q.snd())+"&");
        }
        return new URL(fi);
    }

    private String urlSanitize(String s) throws Error {
        if (s.contains("{") || s.contains("}") || s.contains("[") ||
            s.contains("]") || s.contains("%") || s.contains(";") ||
            s.contains("=") || s.contains("&")){
            throw new Error("malformed URL");
        } else {
            return s;
        }
    }
}
