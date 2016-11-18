package com.gcdk35;

import com.gcdk35.Threads.CloseServerThreadUDP;
import com.gcdk35.Threads.ServerThreadUDP;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by ryan on 28/10/16.
 */
public class UDPServer implements IServer {
    private DatagramSocket socket;

    public UDPServer(int port) throws IOException {
        this.socket = new DatagramSocket(port);
        Runtime.getRuntime().addShutdownHook(new CloseServerThreadUDP(socket));
    }

    public void start() {
        try {
            byte[] buffer = new byte[1000];
            DatagramPacket packet = new DatagramPacket(buffer,buffer.length);
            while (true) {
                //declare variables that we need for this instance
                String clientSentence;
                String capitalizedSentence;
                socket.receive(packet);

                //Process the data, and generate some output
                clientSentence = new String(buffer);
                capitalizedSentence = clientSentence.toUpperCase();

                //take the data, and change the format into a packet to send
                buffer = capitalizedSentence.getBytes();
                DatagramPacket output = new DatagramPacket(buffer,buffer.length,packet.getSocketAddress());

                //Log
                System.out.println(clientSentence + " replies with " + capitalizedSentence);

                //send it to the client
                socket.send(output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
