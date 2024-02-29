package models;

import java.io.IOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Server extends Thread {
    private int port;
    private ServerSocket serverSocket = null;
    private HashMap<User, Socket> users = new HashMap<>();
    public Server() {
        port = 6868;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket);
                User user = new User();
                users.put(user, socket);
                writeObject(user, socket);
                Messager messager = new Messager("Turn off screen");
                writeObject(messager, socket);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void writeObject(Object object, Socket socket) {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(object);
			System.out.println("Send to client: " + object);
            System.out.println("Socket: " + socket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public Object readObject(Socket socket) {
        Object object = null;
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            object = objectInputStream.readObject();
            System.out.println("Receive: " + object);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return object;
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }
}