package utils;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Mouse {
    static int x = -1;
    static int y = -1;

    public static void moveMouse(int x, int y) {
        try {
            java.awt.Robot robot = new java.awt.Robot();
            robot.mouseMove(x, y);
        } catch (java.awt.AWTException e) {
            e.printStackTrace();
        }
    }

    public static void moveMouseXY(int dX, int dY) {
        try {
            java.awt.Robot robot = new java.awt.Robot();
            java.awt.Point point = java.awt.MouseInfo.getPointerInfo().getLocation();
            int x = (int) point.getX();
            int y = (int) point.getY();
            robot.mouseMove(x + dX, y + dY);
        } catch (java.awt.AWTException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Integer> getVectorMousePosition() {
        ArrayList<Integer> position = new ArrayList<>();
        try {
            java.awt.Point point = java.awt.MouseInfo.getPointerInfo().getLocation();
            if (x != -1) {
                position.add((int) point.getX() - x);
                position.add((int) point.getY() - y);
            } else {
                position.add(0);
                position.add(0);
            }
            x = (int) point.getX();
            y = (int) point.getY();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return position;
    }

    public static ArrayList<Integer> getMousePosition() {
        ArrayList<Integer> position = new ArrayList<>();
        try {
            java.awt.Point point = java.awt.MouseInfo.getPointerInfo().getLocation();
            position.add((int) point.getX());
            position.add((int) point.getY());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return position;
    }

    public static void click() {
        try {
            java.awt.Robot robot = new java.awt.Robot();
            robot.mousePress(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
        } catch (java.awt.AWTException e) {
            e.printStackTrace();
        }
    }

    public static void rightClick() {
        try {
            java.awt.Robot robot = new java.awt.Robot();
            robot.mousePress(java.awt.event.InputEvent.BUTTON3_DOWN_MASK);
            robot.mouseRelease(java.awt.event.InputEvent.BUTTON3_DOWN_MASK);
        } catch (java.awt.AWTException e) {
            e.printStackTrace();
        }
    }

    public static void doubleClick() {
        try {
            java.awt.Robot robot = new java.awt.Robot();
            robot.mousePress(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
            robot.mousePress(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
        } catch (java.awt.AWTException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Mouse.moveMouseXY(-100, 100);
    }
}
