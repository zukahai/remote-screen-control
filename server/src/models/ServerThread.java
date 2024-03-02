package models;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerThread extends Thread{
	public Socket socket;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		while(true) {
			Object object = readObject(socket);
			System.out.println("Read from client: " + object);
			
			if (object instanceof Messager) {
				Messager messager = (Messager)object;
				System.out.println("Message: " + messager.getText());
				switch (messager.getText()) {
					case "connect": {
						User user = (User)(messager.getObject());
						Socket socket = Server.findSocketByUser(user);
						if (socket != null) {
							System.out.println("Connect success");
							Messager messager2 = new Messager("Connect success", user);
							writeObject(messager2, this.socket);
							Messager messager3 = new Messager("Have connected");
							writeObject(messager3, socket);
						} else {
							System.out.println("Connect fail");
						}
						break;
					}
				}
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
            System.out.println("ReadObject from Client: " + object);
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
