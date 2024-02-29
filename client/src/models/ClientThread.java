package models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientThread extends Thread{
    private Client client;

    public ClientThread(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        while (true) {
            Object object = readObject(client.getSocket());
            if (object instanceof User) {
                client.setUser((User) object);
                System.out.println("Object: " + object);
            }

            if (object instanceof Messager) {
                Messager messager = (Messager) object;
                System.out.println("Messager: " + messager);
                switch (messager.getText()) {
                    case "Turn off screen":
                        System.out.println("Off");
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
			System.out.println("Send: " + object);
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
}