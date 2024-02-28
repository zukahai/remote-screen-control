package tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class ScreenOff {
    public static void main(String[] args) {
        try {
Robot robot = new Robot();
            
            // Nhấn phím Ctrl
            robot.keyPress(KeyEvent.VK_CONTROL);
            
            // Nhấn phím Alt
            robot.keyPress(KeyEvent.VK_ALT);
            
            // Nhấn phím Delete
            robot.keyPress(KeyEvent.VK_DELETE);
            
            // Giải phóng phím Delete
            robot.keyRelease(KeyEvent.VK_DELETE);
            
            // Giải phóng phím Alt
            robot.keyRelease(KeyEvent.VK_ALT);
            
            // Giải phóng phím Ctrl
            robot.keyRelease(KeyEvent.VK_CONTROL);
            
            System.out.println("ofxf screen");
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}

