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
        int i = s.indexOf(separator);;
        if (i<0) {
            throw new Error("No separator");
        }

        one+=s.substring(0,i);
        if (i<length-1) {
            two+=s.substring(i+1,length);
        }

        return new Tuple<>(one,two);
    }

    public String toString() {
        return "<" + first + ", " + second + ">";
    }
}
