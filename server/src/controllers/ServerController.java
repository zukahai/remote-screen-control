package controllers;

import models.Server;
import views.ServerView;

public class ServerController {
	public Server server;
	public ServerView serverView;
	
	public ServerController() {
		serverView = new ServerView();
		serverView.setIPv4(Server.getIPv4());
	}
	
	public static void main(String[] args) {
		ServerController controller = new ServerController();
	}
}
