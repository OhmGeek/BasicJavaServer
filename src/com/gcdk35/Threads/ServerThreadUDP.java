package com.gcdk35.Threads;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;

/**
 * Created by ryan on 28/10/16.
 */
public class ServerThreadUDP extends Thread {

    private volatile DatagramPacket data;

    public ServerThreadUDP(DatagramPacket connectionSocket) {
        this.data = connectionSocket;
    }

    public void run() {

    }
}
