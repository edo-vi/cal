
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class Parser {
    private static final HttpGetQuery[] base = new HttpGetQuery[] {
            new HttpGetQuery("form-type","corso"),
            new HttpGetQuery("list","0"),
            new HttpGetQuery("anno","2018"),
            new HttpGetQuery("visualizzazione_orario","cal"),
            //new HttpGetQuery("periodo_didattico",""),
            new HttpGetQuery("txtaa","2018/2019"), //periodo scolastico
            new HttpGetQuery("txtcorso","Laurea%20in%20informatica%20(Corsi%20di%20laurea)"),
            new HttpGetQuery("txtanno","2%20anno%20-%20Unico"),
            //new HttpGetQuery("docente",""),
            //new HttpGetQuery("attivita",""),
            //new HttpGetQuery("txtdocente",""),
            //new HttpGetQuery("txtattività","")
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
            list.add(new HttpGetQuery("date", "22/10/2018")); //todo add function to extrapolate date from current weeek
        } else {
            list.add(handleDate(arguments.get("date")));
        }
        if (!arguments.keySet().contains("corso")) {
            list.add(new HttpGetQuery("corso","420")); // default is informatica
        } else {
            list.add(handleCourse(arguments.get("corso")));
        }
        /*if (!arguments.keySet().contains("anno")) {
            list.add(new HttpGetQuery("anno", "2018")); // todo also add function
        } else {
            list.add(handleArgument(arguments.get("anno")));
        }*/
        if (!arguments.keySet().contains("anno")) {
            list.add(new HttpGetQuery("anno2","999%7C2")); // second year
            list.add(new HttpGetQuery("anno2_multi","999%7C2"));
        } else {
            list.add(handleYear(arguments.get("date")));
        }
        return list;
    }

    public ArrayList<HttpGetQuery> getQueries() {
        return this.getQueries;
    }

    private HttpGetQuery handleDate(String date) {

    }

    private HttpGetQuery handleCourse(String date) {

    }

    private HttpGetQuery handleYear(String date) {

    }

}

final class HttpGetQuery extends Tuple<String,String> {
    HttpGetQuery(String a, String b) {
        super(a,b);
    }
}

