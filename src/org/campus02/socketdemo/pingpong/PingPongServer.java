package org.campus02.socketdemo.pingpong;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PingPongServer {

    public static void main(String[] args) {
        // Server erstellen
        try (ServerSocket server = new ServerSocket(1234)) {
            // server soll ewig laufen
            while (true) {
                // auf Client Connection warten
                // Kanal zum Lesen und Schreiben öffnen
                System.out.println("Warte auf Client");
                try(Socket client = server.accept();
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(client.getInputStream())
                    );
                    BufferedWriter bw = new BufferedWriter(
                            new OutputStreamWriter(client.getOutputStream())
                    )
                ) {
                    System.out.println("Client hat sich verbunden");
                    // zuerst lesen

                    String line;
                    while ((line = br.readLine()) != null) {
                        // Logik
                        // wenn PING -> PONG
                        // wenn PONG -> PING
                        // sonst -> ERROR

                        switch (line) {
                            case "PONG":
                                bw.write("--> PING");
                                break;
                            case "PING":
                                bw.write("--> PONG");
                                break;
                            default:
                                bw.write("--> ERROR");
                        }
                        bw.newLine();
                        bw.flush(); // !!!!!!!!!!!!
                    }
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
