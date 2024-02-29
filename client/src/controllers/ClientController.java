package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import models.Client;
import views.ClientView;

public class ClientController {
	private Client client;
	private ClientView clientView;
	
	public ClientController() {
		clientView = new ClientView();
		
		clientView.connect_server.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ip = clientView.ip_tf.getText();
				int port = Integer.parseInt(clientView.port_tf.getText());
				client = new Client(ip, port);
				clientView.setPanelMain();
			}
		});
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientController clientController = new ClientController();
	}

}