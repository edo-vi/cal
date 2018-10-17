public class Tuple<T,W> {
    public T first;
    public W second;

    Tuple (T fst, W snd) {
        first=fst;
        second=snd;
    }

    public T fst() {
        return this.first;
    }
    public W second() {
        return this.second;
    }

    public static Tuple<String, String> fromString(String s, int length, char separator) {
        String one = "";
        String two = "";
        int i = 0;
        char val = s.charAt(i);

        while(i<length && val != separator) {
            i++;
            val= s.charAt(i);
        }
        one+=s.substring(0,i);
        two+=s.substring(i+1,length);

        return new Tuple<>(one,two);
    }

    public String toString() {
        return "<" + first + ", " + second + ">";
    }
}
