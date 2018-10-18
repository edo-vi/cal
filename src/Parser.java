import java.sql.Time;
import java.util.ArrayList;
import java.util.TimeZone;

public class Parser {
    private final Option[] base = new Option[] {
        new Option("form-type=corso"),
        new Option("list=0"),
        new Option("anno=2018"),
        new Option("corso=420"), //Informatica
        new Option("anno2=999%7C2"),
        new Option("anno2_multi=999%7C2"),
        new Option("visualizzazione_orario=cal"),
        new Option("date=29-10-2018"), //todo change
        new Option("periodo_didattico="),
        new Option("_lang=it"),
        new Option("txtaa=2018/2019"), //periodo scolastico
        new Option("txtcorso=Laurea%20in%20informatica%20(Corsi%20di%20laurea)"),
        new Option("txtanno=2%20anno%20-%20Unico"),
        new Option("docente="),
        new Option("attivita="),
        new Option("txtdocente="),
        new Option("txtattività=")
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
