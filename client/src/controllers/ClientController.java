package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Client;
import models.Messager;
import models.User;
import views.ClientView;

public class ClientController extends Thread{
	private Client client;
	private ClientView clientView;
	private boolean isConnect = false;
	
	public ClientController() {
		clientView = new ClientView();
		
		clientView.connect_server.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ip = clientView.ip_tf.getText();
				int port = Integer.parseInt(clientView.port_tf.getText());
				client = new Client(ip, port);
			}
		});
		
		clientView.connect_screen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(clientView.idTf.getText());
				int pass = Integer.parseInt(clientView.passTf.getText());
				User user = new User(id, pass);
				Messager messager = new Messager("connect", user);
				client.writeObjectToServer(messager);
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