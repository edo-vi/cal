
import org.apache.http.client.utils.URIBuilder;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Downloader {
    private static String host = "logistica.univr.it/aule/Orario/ec_download_ical_grid.php";


    Downloader(ArrayList<HttpGetQuery> arr) throws Exception {
        URL url = buildURL(arr);
        URL secondURL = new URL("https://logistica.univr.it/aule/Orario/ec_download_ical_grid.php?form-type=corso&list=0&anno=2018&corso=420&anno2=999|2&anno2_multi=999|2&visualizzazione_orario=cal&date=22-10-2018&periodo_didattico=&_lang=it&ar_codes_=EC123053|EC123042|EC124717|EC124716|EC123048|EC124720&ar_select_=true|true|true|true|true|true&txtaa=2018/2019&txtcorso=Laurea in informatica (Corsi di laurea)&txtanno=2 anno - Unico&docente=&attivita=&txtdocente=&txtattivita=");

        System.out.println(secondURL.getQuery());
        System.out.println(url.getQuery());
        InputStream in = url.openStream();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder result = new StringBuilder();
            String line;
            while((line = reader.readLine()) != null) {
                result.append(line);
            }
            System.out.println(result.toString());
            /*ICalendar cal = Biweekly.parse(in).first();

            stream.close();
            int a = 9; */
        } catch(Exception e) {
            throw new Error();
        }

    }

    private URL buildURL(ArrayList<HttpGetQuery> arr) throws MalformedURLException, URISyntaxException {
        String scheme = "https://";
        String fi = scheme+host+"?";
        URIBuilder builder = new URIBuilder();
        for(HttpGetQuery q : arr) {
            fi += (q.fst()+"="+q.snd()+"&");
        }
        return new URL(fi);
    }
}
