package org.campus02.socketdemo.pingpong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

// Business Logik
// Entkapselt vom Server
public class PingPongObjectHandler {

    private Socket client;

    public PingPongObjectHandler(Socket client) {
        this.client = client;
    }

    public void process() {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(client.getInputStream())
        );
             ObjectOutputStream oos = new ObjectOutputStream(
                     client.getOutputStream()
             )) {
            String line;
            while ((line = br.readLine()) != null) {
                // Logik
                // wenn PING -> PONG
                // wenn PONG -> PING
                // sonst -> ERROR

                switch (line) {
                    case "PONG":
                        oos.writeObject(new Response(200, "PING"));
                        break;
                    case "PING":
                        oos.writeObject(new Response(200, "PONG"));
                        break;
                    default:
                        oos.writeObject(new Response(500, "ERROR"));
                }
                oos.flush(); // !!!!!!!!!!!!
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
