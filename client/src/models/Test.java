package models;

import utils.ChangeDesktopBackground;

public class Test extends Thread{
	public boolean isStart = false;
	ChangeDesktopBackground background;
	
	public Test(ChangeDesktopBackground background) {
		this.background = background;
	}
	
	@Override
	public void run() {
		isStart = true;
		while(true) {
			try {
				for (int i = 0; i < 10; i++)
					background.changeDesktop();
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
