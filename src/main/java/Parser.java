
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Parser {
    private static final HttpGetQuery[] base = new HttpGetQuery[] {
            new HttpGetQuery("form-type","corso"),
            new HttpGetQuery("list","0"),
            new HttpGetQuery("periodo_didattico",""),
            new HttpGetQuery("visualizzazione_orario","cal"),
            new HttpGetQuery("txtaa","2018/2019"), //periodo scolastico
            new HttpGetQuery("txtcorso","Laurea in informatica (Corsi di laurea)"),
            new HttpGetQuery("txtanno","2 anno - Unico"),
            new HttpGetQuery("txtdocente",""),
            new HttpGetQuery("txtattivita",""),
            new HttpGetQuery("_lang","it"),
            new HttpGetQuery("docente",""),
            new HttpGetQuery("attivita",""),
    };

    private ArrayList<HttpGetQuery> getQueries;

    Parser(String[] args){
        //Optionify arguments
        ArrayList<Option> baseArgs = new ArrayList<Option>();
        for (String s : args) {
            baseArgs.add(new Option(s));
        }
        this.getQueries = new ArrayList<HttpGetQuery>(Arrays.asList(Parser.base));

        //check presence of specific param to build get params, otherwise it'll
        //use defaults
        this.getQueries.addAll(getDefaults(baseArgs));

    }

    private ArrayList<HttpGetQuery> getDefaults(ArrayList<Option> args) {
        ArrayList<HttpGetQuery> list = new ArrayList<HttpGetQuery>();
        // keys in args
        HashMap<String, String> arguments = new HashMap<String, String>();

        for (Option arg : args) {
            arguments.put(arg.key(), arg.value());
        }
        if (!arguments.keySet().contains("date")) {
            list.addAll(getCurrentWeek());
        } else {
            list.addAll(handleDate(arguments.get("date")));
        }
        if (!arguments.keySet().contains("corso")) {
            list.add(new HttpGetQuery("corso","420")); // default is informatica
            list.add(new HttpGetQuery("ar_codes_","EC123053|EC123042|EC124717|EC124716|EC123048|EC124720"));
            list.add(new HttpGetQuery("ar_select_","true|true|true|true|true|true"));
        } else {
            list.addAll(handleCourse(arguments.get("corso")));
        }
        if (!arguments.keySet().contains("anno")) {
            list.add(new HttpGetQuery("anno2","999%7C2")); // second year
            list.add(new HttpGetQuery("anno2_multi","999%7C2"));
        } else {
            list.addAll(handleYear(arguments.get("anno")));
        }
        return list;
    }

    public ArrayList<HttpGetQuery> getQueries() {
        return this.getQueries;
    }

    private ArrayList<HttpGetQuery> handleDate(String date) {
        //check correct format of date (aa/bb/cccc),
        if (date.length() != 10 || !(isNumeric(date.charAt(0)) && isNumeric(date.charAt(1))
            && isNumeric(date.charAt(3)) && isNumeric(date.charAt(4)) && isNumeric(date.charAt(6))
            && isNumeric(date.charAt(7)) && isNumeric(date.charAt(8)) && isNumeric(date.charAt(9))
        ) || date.charAt(2) != '-' || date.charAt(5) != '-') {
            throw new Error("Wrong date format. Use dd/mm/yyyy");
        } else {
            String year = date.substring(6);
            return new ArrayList<HttpGetQuery>(Arrays.asList(new HttpGetQuery("date", date), new HttpGetQuery("anno", year)));

        }
    }

    private ArrayList<HttpGetQuery> handleCourse(String course) {
        switch (course) {
            case "informatica":
                return new ArrayList<HttpGetQuery>(Arrays.asList(
                        new HttpGetQuery("corso","420"),
                        new HttpGetQuery("ar_codes_","EC123053|EC123042|EC124717|EC124716|EC123048|EC124720"),
                        new HttpGetQuery("ar_select_","true|true|true|true|true|true")));

            default:
                throw new Error("Course '" + course + "' non supported. Try something different.");
        }
    }

    private ArrayList<HttpGetQuery> handleYear(String year) {
        switch(year) {
            case "1":
                return new ArrayList<HttpGetQuery>(Arrays.asList(new HttpGetQuery("anno2", "999%7C1"), new HttpGetQuery("anno2_multi", "999%7C1")));
            case "2":
                return new ArrayList<HttpGetQuery>(Arrays.asList(new HttpGetQuery("anno2", "999%7C2"), new HttpGetQuery("anno2_multi", "999%7C2")));
            case "3":
                return new ArrayList<HttpGetQuery>(Arrays.asList(new HttpGetQuery("anno2", "999%7C3"), new HttpGetQuery("anno2_multiueries", "999%7C3")));
            default:
                throw new Error ("Year option must be between 1 and 3");
        }
    }

    private static boolean isNumeric(char a) {
        return (int) a >= '0' && (int) a <= '9';
    }

    private ArrayList<HttpGetQuery> getCurrentWeek() {
        Calendar cal = Calendar.getInstance();
        // set date to today
        cal.setTime(new Date());
        //set date to last monday
        while (cal.get(Calendar.DAY_OF_WEEK) != Calendar.MONDAY) {
            cal.add(Calendar.DATE, -1);
        }
        int year = cal.get(Calendar.YEAR);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String resu = dateFormat.format(cal.getTime());
        return new ArrayList<HttpGetQuery>(Arrays.asList(
                new HttpGetQuery("anno",String.valueOf(year)),
                new HttpGetQuery("date", resu)
        ));
    }
}

final class HttpGetQuery extends Tuple<String,String> {
    HttpGetQuery(String a, String b) {
        super(a,b);
    }
}

