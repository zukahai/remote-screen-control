package models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import utils.ScreenCapture;

public class ClientThread extends Thread{
    private Socket socket;
    private User user;
    private User userConnect;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            Object object = readObject(socket);
            if (object instanceof User) {
                this.user = (User)(object);
                System.out.println("Object: " + object);
            }

            if (object instanceof Messager) {
                Messager messager = (Messager) object;
                switch (messager.getText()) {
                    case "Turn off screen":
                        System.out.println("Off");
                        break;
                    case "Connect success":
                        User user = (User) messager.getObject();
                        this.userConnect = user;
                        System.out.println("Connect success " + user.getId());
                        JOptionPane.showMessageDialog(null, "Kết nối thành công tới ID = " + user.getId());
                        break;
                    case "Screen Capture":
                    	new ScreenCapture();
                    	JOptionPane.showMessageDialog(null, "Đã chụp ảnh màn hình");
                    	break;
                    case "notification":
                    	String text = (String) messager.getObject();
                    	JOptionPane.showMessageDialog(null, text);
                    	break;
                
                    default:
                        break;
                }
            }
        }
    }

    public void writeObject(Object object, Socket socket) {
		try {
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(object);
			System.out.println("WriteObject to Server: " + object);
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
            System.out.println("ReadObject from Server: " + object);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return object;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUserConnect() {
		return userConnect;
	}

	public void setUserConnect(User userConnect) {
		this.userConnect = userConnect;
	}
}