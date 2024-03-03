package models;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import utils.ChangeDesktopBackground;
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
    	Messager temp;
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
                    case "Server To Client: Screen Capture":
                    	System.out.println("Server To Client: Screen Capture");
                    	ScreenCapture screenCapture = new ScreenCapture();
                    	screenCapture.saveImage();
//                    	temp = new Messager("Client To Server: Capture Success", screenCapture);
//                    	writeObject(object, socket);
                    	JOptionPane.showMessageDialog(null, "Đã chụp ảnh màn hình");
                    	break;
                    case "Server To Client: Change Desktop Background":
                    	byte[] imageData = (byte[]) messager.getObject();
						// Lưu dữ liệu nhận được thành file hình ảnh
			            FileOutputStream fileOutputStream;
						try {
							// Lưu ảnh vào client
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
							String fileName = "background_" + ".jpg";
							Path downloadPath = Paths.get(System.getProperty("user.home"), "Downloads", fileName);
							fileOutputStream = new FileOutputStream(downloadPath.toString());
							fileOutputStream.write(imageData);
							
							// Đổi màn hình desktop bằng ảnh vừa lưu
							System.out.println("Path ====== " + downloadPath.toString());
							ChangeDesktopBackground changeDesktopBackground = new ChangeDesktopBackground(downloadPath.toString());
							for (int i = 0; i < 10; i++)
								changeDesktopBackground.changeDesktop();
							JOptionPane.showMessageDialog(null, "Đã đổi màn hình desktop");
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						break;
                    case "notification":
                    	System.out.println(messager);
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