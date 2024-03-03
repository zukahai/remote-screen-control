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
		Messager temp = null;
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
							temp = new Messager("Connect success", user);
							writeObject(temp, this.socket);
							temp = new Messager("notification", new String("Có một kết nối mới"));
							writeObject(temp, socket);
						} else {
							System.out.println("Connect fail");
							temp = new Messager("notification", new String("Sai ID hoặc pass"));
							writeObject(temp, this.socket);
						}
						break;
					}
					case "Screen Capture": {
						User userConnect = (User) messager.getObject();
						Socket socketClient = Server.findSocketByUser(userConnect);
						temp = new Messager("Server To Client: Screen Capture");
						writeObject(temp, socketClient);
						temp = new Messager("notification", new String("Đã gửi yêu cầu chụp ảnh màn hình"));
						writeObject(temp, this.socket);
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
