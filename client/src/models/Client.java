package models;

import java.net.Socket;

import javax.swing.ImageIcon;

public class Client {
    private Socket socket;
    private String ip;
    private int port;
    public ClientThread clientThread;

    public Client() {
        ip = "localhost";
        port = 6868;
        try {
            this.socket = new Socket(ip, port);
            System.out.println("Connected to server");
            clientThread = new ClientThread(socket);
            clientThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Client(String ip, int port) {
        try {
            this.socket = new Socket(ip, port);
            System.out.println("Connected to server");
            clientThread = new ClientThread(socket);
            clientThread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void writeObjectToServer(Object object) {
    	clientThread.writeObject(object, socket);
    }

    public void setUser(User user) {
        clientThread.setUser(user);
    }

    public User getUser() {
        User user = clientThread.getUser();
        setUser(user);
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

    public User getUserConnect() {
		return clientThread.getUserConnect();
	}
    
    public ImageIcon getScreen() {
		return clientThread.getScreen();
	}
    
    public void setScreen(ImageIcon imageIcon) {
    	clientThread.setScreen(imageIcon);
    }

	public void setUserConnect(User userConnect) {
		clientThread.setUserConnect(userConnect);
	}

	public static void main(String[] args) {
        Client client = new Client();
    }
}