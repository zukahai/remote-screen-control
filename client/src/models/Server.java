package models;

import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private int port = 6868;
    private ServerSocket serverSocket = null;
    public Server() {
        port = 6868;
        try {
            serverSocket = new ServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        System.out.println("Hello, World!ssss");
    }
}
