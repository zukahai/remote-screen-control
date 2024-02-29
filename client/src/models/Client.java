package models;

import java.net.Socket;

public class Client {
    private User user;
    private Socket socket;
    private String ip;
    private int port;

    public Client() {
        this.user = null;
        ip = "localhost";
        port = 6868;
        try {
            this.socket = new Socket(ip, port);
            System.out.println("Connected to server");
            ClientThread clientThread = new ClientThread(this);
            clientThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Client(String ip, int port) {
        this.user = null;
        try {
            this.socket = new Socket(ip, port);
            System.out.println("Connected to server");
            ClientThread clientThread = new ClientThread(this);
            clientThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        Client client = new Client();
    }
}