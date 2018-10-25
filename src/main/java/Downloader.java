import biweekly.Biweekly;
import biweekly.ICalendar;
import org.apache.http.client.utils.URIBuilder;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Downloader {
    private static String host = "logistica.univr.it/aule/Orario/ec_download_ical_grid.php";
    private static String example = "logistica.univr.it/aule/Orario/ec_download_ical_list.php?form-type=corso&list=0&anno=2018&corso=420&anno2=999%7C2&anno2_multi=999%7C2&anno2=999%7C2&visualizzazione_orario=cal&date=29-10-2018&periodo_didattico=&_lang=it&&txtaa=2018/2019&txtcorso=Laurea%20in%20informatica%20(Corsi%20di%20laurea)&txtanno=2%20anno%20-%20Unico&docente=&attivita=&txtdocente=&txtattivita=";

    Downloader(ArrayList<HttpGetQuery> arr) throws Exception {
        URL url = buildURL(arr);
        InputStream stream = url.openStream();
        try {
            ICalendar cal = Biweekly.parse(stream).first();
            int a = 9;
        } catch(Exception e) {
            throw new Error();
        }

    }

    private URL buildURL(ArrayList<HttpGetQuery> arr) throws MalformedURLException, URISyntaxException {
        URIBuilder builder = new URIBuilder();
        for(HttpGetQuery q : arr) {
            builder.addParameter(q.fst(), q.snd());
        }
        return builder.setScheme("http").setHost(host).build().toURL();
    }
}
