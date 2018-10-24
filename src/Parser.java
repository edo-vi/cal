
import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.spi.CalendarDataProvider;

public class Parser {
    private static final HttpGetQuery[] base = new HttpGetQuery[] {
            new HttpGetQuery("form-type","corso"),
            new HttpGetQuery("list","0"),
            new HttpGetQuery("visualizzazione_orario","cal"),
            /* tx- probably not required
            new HttpGetQuery("txtaa","2018/2019"), //periodo scolastico
            new HttpGetQuery("txtcorso","Laurea%20in%20informatica%20(Corsi%20di%20laurea)"),
            new HttpGetQuery("txtanno","2%20anno%20-%20Unico"),
            new HttpGetQuery("txtdocente",""),
            new HttpGetQuery("txtattività",""), */
            new HttpGetQuery("_lang","it")
    };

    private ArrayList<HttpGetQuery> getQueries;

    Parser(String[] args){
        //Optionify arguments
        ArrayList<Option> baseArgs = new ArrayList<>();
        for (String s : args) {
            baseArgs.add(new Option(s));
        }
        this.getQueries = new ArrayList<>(Arrays.asList(Parser.base));

        //check presence of specific param to build get params, otherwise it'll
        //use defaults
        this.getQueries.addAll(getDefaults(baseArgs));

    }

    private ArrayList<HttpGetQuery> getDefaults(ArrayList<Option> args) {
        ArrayList<HttpGetQuery> list = new ArrayList<>();
        // keys in args
        HashMap<String, String> arguments = new HashMap<>();

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
        } else {
            list.add(handleCourse(arguments.get("corso")));
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
        ) || date.charAt(2) != '/' || date.charAt(5) != '/') {
            throw new Error("Wrong date format. Use dd/mm/yyyy");
        } else {
            String year = date.substring(6);
            return new ArrayList<>(Arrays.asList(new HttpGetQuery("date", date), new HttpGetQuery("anno", year)));

        }
    }

    private HttpGetQuery handleCourse(String course) {
        switch (course) {
            case "informatica":
                return new HttpGetQuery("corso","420");
            default:
                throw new Error("Course '" + course + "' non supported. Try something different.");
        }
    }

    private ArrayList<HttpGetQuery> handleYear(String year) {
        switch(year) {
            case "1":
                return new ArrayList<>(Arrays.asList(new HttpGetQuery("anno2", "999%7C1"), new HttpGetQuery("anno2_multi", "999%7C1")));
            case "2":
                return new ArrayList<>(Arrays.asList(new HttpGetQuery("anno2", "999%7C2"), new HttpGetQuery("anno2_multi", "999%7C2")));
            case "3":
                return new ArrayList<>(Arrays.asList(new HttpGetQuery("anno2", "999%7C3"), new HttpGetQuery("anno2_multiueries", "999%7C3")));
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
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String resu = dateFormat.format(cal.getTime());
        return new ArrayList<>(Arrays.asList(new HttpGetQuery[]{
                new HttpGetQuery("anno",String.valueOf(year)),
                new HttpGetQuery("date", resu)
        }));
    }
}

final class HttpGetQuery extends Tuple<String,String> {
    HttpGetQuery(String a, String b) {
        super(a,b);
    }
}

