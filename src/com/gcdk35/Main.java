package com.gcdk35;
// 1. One client at a time because we only have one thread (which detects a client, then does network stuff, and finally ends with that particular client).
//    While working with that client, no other client can connect.

// 2. Multithreading allows for multiple threads to be run at the same time, meaning we can have multiple connections at a given time, with multiple clients.

// 3. Yes, modifying variables with multiple different threads could lead to erroneous output. We can solve the problem by adding a lock to the given variables,
//    meaning that only the thread that has the lock can modify them, and all others have to wait for the lock to be removed.

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // write your code here

        IServer s;
        try {
            s = new UDPServer(3001);
            s.start();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An IO Exception was thrown");
        }

    }


}
