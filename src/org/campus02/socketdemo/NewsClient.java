package org.campus02.socketdemo;

import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class NewsClient {

    public static void main(String[] args) {

        try (Socket client = SSLSocketFactory.getDefault().createSocket("news.orf.at", 443);
             BufferedReader br = new BufferedReader(
                     new InputStreamReader(client.getInputStream()));
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(client.getOutputStream()))
        ) {

            bw.write("GET / HTTP/1.1\r\nHost:news.orf.at\r\n\r\n");
            bw.flush(); // !!!!!!!!!!!!!!!!!!!!!!

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
