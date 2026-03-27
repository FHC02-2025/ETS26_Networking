package org.campus02.socketdemo.pingpong;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class PingPongObjectClient {

    public static void main(String[] args) {
        // zum server verbinden
        try (Socket server = new Socket("localhost", 1234);
             ObjectInputStream ois = new ObjectInputStream(
                     server.getInputStream()
             );
             BufferedWriter bw = new BufferedWriter(
                     new OutputStreamWriter(server.getOutputStream())
             );
             BufferedReader cli = new BufferedReader(
                     new InputStreamReader(System.in)
             )
        ) {

            // zuerst user input
            String input;
            while ((input = cli.readLine()) != null) {

                // wenn input == EXIT -> beenden
                if (input.equals("EXIT")) {
                    // aus while aussteigen -> beenden
                    break;
                }

                // schicke user input an server
                bw.write(input);
                bw.newLine();
                bw.flush();

                // lesen vom server
                Response response = (Response) ois.readObject();
                System.out.println("Status:" + response.getStatus());
                System.out.println("Message:" + response.getMessage());
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
