package controllers;

import models.Client;
import views.ClientView;

public class ClientController {
	private Client client;
	private ClientView clientView;
	
	public ClientController() {
		clientView = new ClientView();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClientController clientController = new ClientController();
	}

}
