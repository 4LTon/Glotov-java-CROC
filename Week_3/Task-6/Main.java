import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) {
        String source = "" +
                "/*\n" +
                " * My first ever program in Java!\n" +
                " */\n" +
                "class Hello { // class body starts here \n" +
                "\n" +
                "    /* main method */\n" +
                "    public static void main(String[] args/* we put command line arguments here*/) {\n" +
                "        // this line prints my first greeting to the screen\n" +
                "        System.out.println(\"Hi!\"); // :)\n" +
                "    }\n" +
                "} // the end\n" +
                "// to be continued...";

        String noComments = removeJavaComments(source);
        System.out.println(noComments);
    }

    public static String removeJavaComments(String source) {

        Pattern pattern = Pattern.compile("(/\\*\\n*.*\\s*\\*/)|(/{2}.*)");
        Matcher matcher = pattern.matcher(source);

        return (String) matcher.replaceAll("");
    }
}