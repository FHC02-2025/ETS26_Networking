package org.campus02.urldemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyFirstUrl {

    public static void main(String[] args) {

        try {
            URL myUrl = new URL("https://www.campus02.at");

            // BufferedReader: um zu lesen
            // BufferedWriter: um schreiben

            // zum lesen verwenden wir den Inputstream meiner "myUrl"
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(myUrl.openStream()))) {

                String html;
                while ((html = br.readLine()) != null) {
                    System.out.println(html);
                }

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
