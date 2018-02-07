package com.company;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Main {
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
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        contents = contents.toUpperCase();
        contents = contents.replaceAll("[^a-zA-Z ]", "");
        String[] result = contents.split(" ");
        int count = 0;
        for(int i = 0; i <= result.length - 1; i++) {
            if (result[i].equals("PRINCE")){
                count++;
            };
        }
        System.out.println(count);
        return contents;
    }
    public static void main(String[] args) {
	// write your code here
        System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
    }
}
