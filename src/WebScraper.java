import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return null;
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     *
     * @param unused to show that we're not using it
     * @return returns a System Print
     */

    public static void main(String[] unused) {
        String input = urlToString("http://erdani.com/tdpl/hamlet.txt");
        String[] inputArray = input.split(" ");
        int counter = 0;
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i].startsWith("prince")
                    || inputArray[i].equalsIgnoreCase("prince")) {
                counter = counter + 1;
            }
        }
        System.out.println(counter);
    }
}
