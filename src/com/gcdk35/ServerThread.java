package com.gcdk35;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by ryan on 28/10/16.
 */
public class ServerThread extends Thread {
    private volatile Socket connection;

    public ServerThread(Socket connectionSocket) {
        this.connection = connectionSocket;
    }

    public void run() {
        try {
            String clientSentence;
            String capitalizedSentence;

            BufferedReader clientReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            DataOutputStream outStream = new DataOutputStream(connection.getOutputStream());

            clientSentence = clientReader.readLine();
            capitalizedSentence = clientSentence.toUpperCase();

            System.out.println(clientSentence + " replies with " + capitalizedSentence);

            outStream.writeBytes(capitalizedSentence);
            connection.close();

        } catch (IOException e) {
            e.printStackTrace();

            try {
                connection.close();
                return;

            } catch (IOException e1) {
                e1.printStackTrace();
                System.out.println("Cannot close connection :(");
            }

        }
    }
}
