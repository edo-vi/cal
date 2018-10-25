public class Option {

    private Tuple<String, String> entry;

    /*
     * Constructor from a string, with a specified separator 
     */
    Option(String s, char separator) {
        if(s.charAt(0) != '-') {
            throw new Error("Option format wrong, should be '-option=value");
        }
        String one = "";
        String two = "";
        int i = s.indexOf(separator);
        if (i<0) {
            throw new Error("No separator");
        }

        one+=s.substring(1,i);
        two=s.substring(i+1);

        this.entry = new Tuple<String, String>(one, two);

    }
    /*
     * With no separator (default is '=')
     */
    Option(String s) {
        this(s,'=');
    }

    /*
     * Constructor from two strings
     */
    Option(String one, String two) {
        this.entry = new Tuple<String, String>(one, two);
    }

    public String key() {
        return this.entry.fst();
    }

    public String value() {
        return this.entry.snd();
    }

    public boolean isKey(String s) {
        return this.key().equals(s);
    }

    public boolean isValue(String s) {
        return this.value().equals(s);
    }

    public String toString() {
        return "{" + entry.fst() + ": " + entry.snd() + "}";
    }

}