package org.campus02.urldemo;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class MyFirstUrl {

    public static void main(String[] args) {

        try {
            URL myUrl = new URL("https://www.campus02.at");

            // BufferedReader: um zu lesen
            // BufferedWriter: um schreiben

            // zum lesen verwenden wir den Inputstream meiner "myUrl"
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(myUrl.openStream()));
                 BufferedWriter bw = new BufferedWriter(
                         new FileWriter("data/campus02.html")
                 );
                 PrintWriter pw = new PrintWriter(
                         new FileWriter("data/campus02_pw.html")
                 )
            ) {
                String html;
                while ((html = br.readLine()) != null) {
                    System.out.println(html);

                    // schreibe daten in file
                    bw.write(html);
                    // zeilenumbruch
                    bw.newLine();

                    pw.println(html);
                }
                bw.flush();
                pw.flush();

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
