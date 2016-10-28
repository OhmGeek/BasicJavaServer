package com.gcdk35;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by ryan on 28/10/16.
 */
public class CloseServerThread extends Thread {
    private volatile ServerSocket server;

    public CloseServerThread(ServerSocket server) {
        this.server = server;
    }

    public void run() {
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Server couldn't shutdown :(");
        }
    }

}

