import java.util.ArrayList;

public class Parser {
    private final GetQuery[] base = new GetQuery[] {
        new GetQuery("form-type","corso"),
        new GetQuery("list","0"),
        new GetQuery("anno","2018"),
        new GetQuery("corso","420"), //Informatica
        new GetQuery("anno2","999%7C2"),
        new GetQuery("anno2_multi","999%7C2"),
        new GetQuery("visualizzazione_orario","cal"),
        new GetQuery("date","29-10-2018"), //todo change
        //new GetQuery("periodo_didattico",""),
        new GetQuery("_lang","it"),
        new GetQuery("txtaa","2018/2019"), //periodo scolastico
        new GetQuery("txtcorso","Laurea%20in%20informatica%20(Corsi%20di%20laurea)"),
        new GetQuery("txtanno","2%20anno%20-%20Unico"),
        //new GetQuery("docente",""),
        //new GetQuery("attivita",""),
        //new GetQuery("txtdocente",""),
        //new GetQuery("txtattività","")
    };

    Parser(String[] args){
        //Optionify arguments
        ArrayList<Option> baseArgs = new ArrayList<>();
        for (String s : args) {
            baseArgs.add(new Option(s));
        }


        // add current week as default

    }
}


final class GetQuery extends Tuple<String,String> {
    GetQuery(String a, String b) {
        super(a,b);
    }
}