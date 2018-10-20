public class MyMain {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(new Option(arg, '='));
        }
        Parser par = new Parser(args);
    }

    private static boolean isNumeric(char a) {
        return (int) a >= '0' && (int) a <= '9';
    }

}
