/** @author rob nebeker */
// W04 JSON HTTP

package w04.json;

import java.net.*;
import java.io.*;
import java.util.*;

public class Http {

    public static String getHttpContent(String string) {

        String content="";

        try {
            URL url = new URL(string);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line= reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            content = stringBuilder.toString();

        } catch (Exception e) {
            System.err.println(e.toString());
        }

        return content;
    }

    public static Map getHttpHeaders(String string) {
        Map hashmap = null;

        try {
            URL url = new URL(string);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();

            hashmap = http.getHeaderFields();

        } catch(Exception e) {
            System.err.println(e.toString());
        }

        return hashmap;

    }

    public static void main(String[] args) {
        System.out.println(Http.getHttpContent("http://www.msn.com"));

        Map<Integer, List<String>> m = Http.getHttpHeaders("http://www.msn.com");


        for (Map.Entry<Integer,List<String>> entry : m.entrySet()) {
            try {
                System.out.println("Key= " + entry.getKey() +
                                             entry.getValue());

            } catch(Exception e) {
                System.err.println(e.toString());
            }
        }
    }
}