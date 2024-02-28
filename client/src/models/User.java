package models;

import java.net.Socket;

public class User {
    private int id;
    private int password;
    private Socket socket = null;

    public User() {
        this.id = 0;
        this.password = 0;
        this.socket = new Socket();
    }
    
    public User(int id, int password, Socket socket) {
        this.id = id;
        this.password = password;
        this.socket = socket;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPassword() {
        return password;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public Socket getSocket() {
        return socket;
    }
    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
}
