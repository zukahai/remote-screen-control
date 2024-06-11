package models;

import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import utils.AdjustBrightness;
import utils.ChangeDesktopBackground;
import utils.MoveMouse;
import utils.RobotKey;
import utils.ScreenCapture;

public class ClientThread extends Thread{
    private Socket socket;
    private User user;
    private User userConnect;
    private Test t = new Test(null);
    private ImageIcon screen = null;

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

            if (object instanceof Messager) {Messager messager = (Messager) object;
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
                    	if (t.isStart)
                    		t.stop();
                    	byte[] imageData = (byte[]) messager.getObject();
						// Lưu dữ liệu nhận được thành file hình ảnh
			            FileOutputStream fileOutputStream;
						try {
							// Lưu ảnh vào client
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
							String fileName = "background" + ".jpg";
							fileOutputStream = new FileOutputStream(fileName);
							fileOutputStream.write(imageData);
							
							// Đổi màn hình desktop bằng ảnh vừa lưu
							String abPath = new File(fileName).getAbsolutePath();
							ChangeDesktopBackground changeDesktopBackground = new ChangeDesktopBackground(abPath);
							t = new Test(changeDesktopBackground);
							t.start();
							JOptionPane.showMessageDialog(null, "Đã nhận yêu cầu đổi màn hình desktop, sẽ đổi hình nền trong giây lát");
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						break;
                    case "Server To Client: AdjustBrightness":
                    	int bright = (int) messager.getObject();
                    	System.out.println("Bright:    "+ bright);
                    	new AdjustBrightness(bright).adjustBrightness();
                    	break;
                    case "Server To Client: ScreenShare":
                    	user = (User) messager.getObject();
                    	
                    	Timer time = new Timer(50, new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								ScreenCapture screenCapture1 = new ScreenCapture();
		                    	byte[] imageData = screenCapture1.getImageData();
		                    	Messager temp = new Messager("Client To Server: Screen", user, imageData);
		                    	writeObject(temp, socket);
							}
						});
                    	time.start();
                    	
                    	break;
                    case "Server To Client: Screen":
                    	imageData = (byte[]) messager.getObject();
                    	screen = new ImageIcon(imageData);
                    	System.out.println("Chia sẻ màn hình");
                    	break;
                    case "notification":
                    	System.out.println(messager);
                    	String text = (String) messager.getObject();
                    	JOptionPane.showMessageDialog(null, text);
                    	break;
						
					case "Server To Client: KeyPressed":
						int key = (int) messager.getObject();
						RobotKey.keyPress(key);
						break;

					case "Server To Client: Mouse":
						System.out.println("\n\n\n\n\n\n aaaaaaa");
						ArrayList<Integer> list = (ArrayList<Integer>) messager.getObject();
						MoveMouse.moveMouseXY(list.get(0), list.get(1));
						MoveMouse.moveMouseXY(-100, 100);
						break;
                
                    default:
					System.out.println("\n\n\n\n\n\n" + messager.getText());
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

	public ImageIcon getScreen() {
		return screen;
	}

	public void setScreen(ImageIcon screen) {
		this.screen = screen;
	}
}