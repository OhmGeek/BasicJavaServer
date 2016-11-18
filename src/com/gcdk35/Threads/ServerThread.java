package com.gcdk35.Threads;

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
            //declare variables that we need for this instance
            String clientSentence;
            String capitalizedSentence;

            //Create a reader, reading in the input from the client
            BufferedReader clientReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            //Create an output stream, so we can write back to the client.
            DataOutputStream outStream = new DataOutputStream(connection.getOutputStream());

            //Process the data, and generate some output
            clientSentence = clientReader.readLine();
            capitalizedSentence = clientSentence.toUpperCase();

            //Log
            System.out.println(clientSentence + " replies with " + capitalizedSentence);

            //Write out the processed info
            outStream.writeBytes(capitalizedSentence);
            //And we're finished. Now possibly onto the next client!
            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
