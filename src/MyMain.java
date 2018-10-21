public class MyMain {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(new Option(arg, '='));
        }
        Parser par = new Parser(args);
        Downloader dwnldr = new Downloader(par.getQueries());

    }
}
