package tests;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ScreenCapture {

    public static void main(String[] args) {
        try {
            // Tạo thư mục nếu chưa tồn tại
            File folder = new File("images");
            if (!folder.exists()) {
                folder.mkdir();
            }

            Robot robot = new Robot();
            String format = "jpg";

            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);

            // Tạo tên file dựa trên thời gian hiện tại
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String fileName = "screenshot_" + dateFormat.format(new Date()) + "." + format;

            // Lưu ảnh vào thư mục images
            File file = new File("images", fileName);
            ImageIO.write(screenFullImage, format, file);

            System.out.println("Screenshot saved: " + file.getAbsolutePath());
        } catch (AWTException | IOException ex) {
            System.err.println(ex);
        }
    }
}

