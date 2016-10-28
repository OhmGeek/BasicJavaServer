package com.gcdk35;
// 1. One client at a time because we only have one thread (which detects a client, then does network stuff, and finally ends with that particular client).
//    While working with that client, no other client can connect.

// 2. Multithreading allows for multiple threads to be run at the same time, meaning we can have multiple connections at a given time, with multiple clients.

// 3. Yes, modifying variables with multiple different threads could lead to erroneous output. We can solve the problem by adding a lock to the given variables,
//    meaning that only the thread that has the lock can modify them, and all others have to wait for the lock to be removed.

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args)  {
	// write your code here

        ServerSocket socket = null;
        try {
            socket = new ServerSocket(3003);
            Runtime.getRuntime().addShutdownHook(new CloseServerThread(socket));
        while(true) {
            Socket connectionSocket = socket.accept();
            Thread t = new ServerThread(connectionSocket);
            t.start();

        }
        } catch (IOException e) {
            e.printStackTrace();
        }




    }


}
