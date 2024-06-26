package utils;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.ByteArrayOutputStream;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ScreenCapture{
	private BufferedImage screenFullImage;
	private String fileName;
	private String format;
	private byte[] imageData;
	
	public ScreenCapture() {
		try {
            Robot robot = new Robot();
            format = "jpg";

            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            screenFullImage = robot.createScreenCapture(screenRect);

			// Vẽ thêm con trỏ chuột
			Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
			int mouseX = mouseLocation.x - screenRect.x;
			int mouseY = mouseLocation.y - screenRect.y;
			Graphics2D g2d = screenFullImage.createGraphics();
			g2d.setColor(Color.RED);
			g2d.fillOval(mouseX, mouseY, 15, 15);
			g2d.dispose();


            // Tạo tên file dựa trên thời gian hiện tại
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            fileName = "screenshot_" + dateFormat.format(new Date()) + "." + format;
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(screenFullImage, "png", baos);
            imageData = baos.toByteArray();
        } catch (AWTException e) {
            System.err.println(e);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

    public BufferedImage getScreenFullImage() {
		return screenFullImage;
	}

	public void setScreenFullImage(BufferedImage screenFullImage) {
		this.screenFullImage = screenFullImage;
	}

	public byte[] getImageData() {
		return imageData;
	}

	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	public static void main(String[] args) {
        new ScreenCapture().saveImage();
    }
}