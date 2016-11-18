package com.gcdk35.Threads;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;

/**
 * Created by ryan on 28/10/16.
 */
public class CloseServerThreadUDP extends Thread {
    private volatile DatagramSocket server;

    public CloseServerThreadUDP(DatagramSocket server) {
        this.server = server;
    }

    public void run() {
            server.close();
    }
}

