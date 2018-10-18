public class Options {

    private Tuple<String, String> entry;

    /*
     * Constructor from a string, with a specified separator 
     */
    Options(String s, char separator) {
        String one = "";
        String two = "";
        int i = s.indexOf(separator);
        if (i<0) {
            throw new Error("No separator");
        }

        one+=s.substring(0,i);
        two=s.substring(i+1);

        this.entry = new Tuple<>(one, two);

    }
    /*
     * Constructor from two strings
     */
    Options(String one, String two) {
        this.entry = new Tuple<>(one, two);
    }

    public String option() {
        return this.entry.fst();
    }

    public String value() {
        return this.entry.snd();
    }

    public String toString() {
        return "{" + entry.fst() + ": " + entry.snd() + "}";
    }

}