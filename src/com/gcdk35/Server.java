package com.gcdk35;

import com.gcdk35.Threads.CloseServerThread;
import com.gcdk35.Threads.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ryan on 28/10/16.
 */
public class Server {
    private ServerSocket socket;

    public Server(int port) throws IOException {
        this.socket = new ServerSocket(port);
        Runtime.getRuntime().addShutdownHook(new CloseServerThread(socket));
    }

    public void start() {
        try {
            while (true) {
                Socket connectionSocket = socket.accept();
                Thread t = new ServerThread(connectionSocket);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
