package models;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ScreenCapture implements Serializable{
	private BufferedImage screenFullImage;
	private String fileName;
	private String format;
	
	public ScreenCapture() {
		try {
            Robot robot = new Robot();
            format = "jpg";

            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            screenFullImage = robot.createScreenCapture(screenRect);

            // Tạo tên file dựa trên thời gian hiện tại
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            fileName = "screenshot_" + dateFormat.format(new Date()) + "." + format;
        } catch (AWTException e) {
            System.err.println(e);
        }
	}
		
	public void saveImage() {
		// Tạo thư mục nếu chưa tồn tại
        File folder = new File("images");
        if (!folder.exists()) {
            folder.mkdir();
        }
		// Lưu ảnh vào thư mục images
        try {
        	File file = new File("images", fileName);
			ImageIO.write(screenFullImage, format, file);
			System.out.println("Screenshot saved: " + file.getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public static void main(String[] args) {
        new ScreenCapture();
    }
}