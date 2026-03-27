package org.campus02.socketdemo;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyFirstServerDemo {

    public static void main(String[] args) {

        // Server erzeugen
        System.out.println("Server wird hochgefahren");
        try (ServerSocket server = new ServerSocket(1234)) {
            System.out.println("Server ist hochgefahren");

            while (true) {
                System.out.println("Server wartet auf Verbindungen");
                // Kanal zum Schreiben
                try (Socket client = server.accept();
                     BufferedWriter bw = new BufferedWriter(
                        new OutputStreamWriter(client.getOutputStream())
                )) {
                    System.out.println("Client hat sich verbunden");
                    bw.write("Hallo lieber Client");
                    bw.flush();
                    System.out.println("Daten an Client gesendet");
                }
            }
            //System.out.println("Server fährt hinunter");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
