package org.campus02.socketdemo;

import java.io.*;
import java.net.Socket;

public class MyFirstClientDemo {

    public static void main(String[] args) {

        // 1. Socket erstellen (Client)
        try (Socket client = new Socket("info.cern.ch", 80);
             // Kanal zum Lesen öffnen
             BufferedReader br = new BufferedReader(
                     new InputStreamReader(client.getInputStream()));
             // Kanal zum Schreiben öffnen
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(client.getOutputStream())
             )
        ){
            // Kommunikation mit dem Server
            // Server hört -> wir schreiben was wir haben wollen

            // 1. Weg dem Protokoll zu folgen
            //bw.write("GET / HTTP/1.1\r\nHost: info.cern.ch\r\n\r\n");

            // 2. Weg dem Protokoll zu folgen
            bw.write("GET / HTTP/1.1");
            bw.newLine();
            bw.write("Host: info.cern.ch");
            bw.newLine();
            bw.newLine();
            bw.flush(); // !!!!!!!!!!!!!!!!!!!!!!!

            // nun erhalten wir die antwort vom server
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
