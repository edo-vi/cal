public class MyMain {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(new Options(arg, '='));
        }
    }
}
