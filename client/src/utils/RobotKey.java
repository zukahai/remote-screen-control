package utils;

public class RobotKey {
    public static void keyPress(int key) {
        if (key == 0) {
            return;
        }
        try {
            java.awt.Robot robot = new java.awt.Robot();
            robot.keyPress(key);
        } catch (java.awt.AWTException e) {
            e.printStackTrace();
        }
    }
}
