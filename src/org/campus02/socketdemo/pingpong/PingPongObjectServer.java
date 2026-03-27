package org.campus02.socketdemo.pingpong;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PingPongObjectServer {

    public static void main(String[] args) {
        // Server erstellen
        try (ServerSocket server = new ServerSocket(1234)) {
            // server soll ewig laufen
            while (true) {
                // auf Client Connection warten
                // Kanal zum Lesen und Schreiben öffnen
                System.out.println("Warte auf Client");
                try(Socket client = server.accept()) {
                    System.out.println("Client hat sich verbunden");
                    // zuerst lesen
                    PingPongObjectHandler pingPongObjectHandler = new PingPongObjectHandler(client);
                    pingPongObjectHandler.process();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
