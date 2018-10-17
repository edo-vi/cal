
public class UrlBuilder {
    private static String[] defaultSlices = {
            "https://logistica.univr.it/aule/Orario/ec_download_ical_grid.php?form-type=corso&list=0&anno=2018&corso=420&anno", //2
            "=999%7C2&anno", //2
            "_multi=999%7C2&anno", //2
            "=999%7C2&visualizzazione_orario=cal&date=2", // 17/10/2018
            "&periodo_didattico=&_lang=it&ar_codes_=EC123053|EC123042|EC124717|EC124716|EC123048|EC124720&ar_select_" +
            "=true|true|true|true|true|true&txtaa=", //"2018/2019"
            "&txtcorso=Laurea%20in%20informatica%20(Corsi%20di%20laurea)&txtanno=", //2
            "%20anno%20-%20Unico&docente=&attivita=&txtdocente=&txtattivita="};

    private Tuple<String, String>[] params;
    UrlBuilder(String[] args) {

    }
}