package models;

import java.io.IOException;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.net.InetAddress;

public class Server extends Thread {
    private int port;
    private ServerSocket serverSocket = null;
    private String content = "";
    public static HashMap<User, Socket> users = new HashMap<>();
    public Server(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Máy chủ đã khởi động ở cổng " + port);
            addContent("Máy chủ đã khởi động ở cổng " + port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client kết nối:\n" + socket);
                addContent("Client kết nối:\n" + socket);
                User user = new User();
                users.put(user, socket);
                writeObject(user, socket);
                
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
//                Messager messager = new Messager("Turn off screen");
//                writeObject(messager, socket);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void writeObject(Object object, Socket socket) {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(object);
			System.out.println("WriteObject to Client: " + object);
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
            System.out.println("Read Object From Server: " + object);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return object;
    }
    
    public static String getIPv4() {
    	String ip = "";
    	try {
    		InetAddress myIP=InetAddress.getLocalHost();
            ip = myIP.getHostAddress();
            System.out.println("Địa chỉ IP của tôi là: " + ip);
    	} catch (Exception e) {
			// TODO: handle exception
		}
    	return ip;
    }
    
    public static String getCurrentTimeAsString() {
        LocalTime currentTime = LocalTime.now();
        return currentTime.getHour() + " giờ " + currentTime.getMinute() + " phút " + currentTime.getSecond() + " giây.";
    }
    
    public void addContent(String text) {
    	content = "____________________________________________________________" + "\n" + content;
    	content = text + "\n" + content;
    	content = getCurrentTimeAsString() + "\n" + content;
    }
    
    public static Socket findSocketByUser(User user) {
    	for (User u: users.keySet())
    		System.out.println(u);
    	return users.get(user);
    }

    public int getPort() {
		return port;
	}
    
	public void setPort(int port) {
		this.port = port;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	public HashMap<User, Socket> getUsers() {
		return users;
	}
	
	public void setUsers(HashMap<User, Socket> users) {
		this.users = users;
	}
	
	public static void main(String[] args) {
        Server server = new Server(6868);
        server.start();
    }
}