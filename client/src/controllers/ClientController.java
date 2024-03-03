package controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;

import models.Client;
import models.Messager;
import models.User;
import views.ClientView;

public class ClientController extends Thread {
	private Client client;
	private ClientView clientView;
	private boolean isConnect = false;

	public ClientController() {
		clientView = new ClientView();

		clientView.connectServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ip = clientView.ip_tf.getText();
				int port = Integer.parseInt(clientView.port_tf.getText());
				client = new Client(ip, port);
			}
		});

		clientView.connectScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(clientView.idTf.getText());
				int pass = Integer.parseInt(clientView.passTf.getText());
				User user = new User(id, pass);
				Messager messager = new Messager("connect", user);
				client.writeObjectToServer(messager);
			}
		});

		clientView.screenCapture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (client == null) {
					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy chủ");
					return;
				}
				if (client.getUserConnect() == null) {
					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy khác");
					return;
				}
				User userConnect = client.getUserConnect();
				Messager messager = new Messager("Screen Capture", userConnect);
				client.writeObjectToServer(messager);
			}
		});

		clientView.changeDesktopBackground.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (client == null) {
					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy chủ");
					return;
				}
				if (client.getUserConnect() == null) {
					JOptionPane.showMessageDialog(null, "Chưa kết nối đến máy khác");
					return;
				}
				JFileChooser fileChooser = new JFileChooser();
				// Chỉ cho phép chọn các file hình ảnh
				fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
					public boolean accept(File f) {
						return f.getName().toLowerCase().endsWith(".jpg") || f.getName().toLowerCase().endsWith(".jpeg")
								|| f.getName().toLowerCase().endsWith(".png")
								|| f.getName().toLowerCase().endsWith(".gif") || f.isDirectory();
					}

					public String getDescription() {
						return "Image files (*.jpg, *.jpeg, *.png, *.gif)";
					}
				});

				int result = fileChooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					File selectedFile = fileChooser.getSelectedFile();
					// Xử lý file đã chọn ở đây, ví dụ: hiển thị đường dẫn file
					JOptionPane.showMessageDialog(null, "Đường dẫn tới ảnh: " + selectedFile.getAbsolutePath());

					try {
						// Đọc hình ảnh từ file
						File imageFile = new File(selectedFile.getAbsolutePath());
						FileInputStream fileInputStream = new FileInputStream(imageFile);
						byte[] imageData = new byte[(int) imageFile.length()];
						fileInputStream.read(imageData);
						
						Messager messager = new Messager("Client To Server: Change Desktop Background", imageData);
						client.writeObjectToServer(messager);
					} catch (Exception e1) {
						// TODO: handle exception
						e1.printStackTrace();
					}
				}
			}
		});
	}

	@Override
	public void run() {

		while (true) {
			System.out.print("");
			if (isConnect) {

			} else {
				if (client == null)
					continue;
				User user = client.getUser();
				if (user != null) {
					isConnect = true;
					clientView.setUser(user);
					clientView.setPanelMain();
					System.out.println("Connect");
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientController clientController = new ClientController();
		clientController.start();
	}
}