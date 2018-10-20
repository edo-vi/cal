public class MyMain {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(new Option(arg, '='));
        }
        Parser par = new Parser(args);
        Downloader down = new Downloader(par.getQueries());
    }
}
