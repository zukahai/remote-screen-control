package views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class NumberChooser {
    public NumberChooser() {
        // Tạo JFrame
        JFrame frame = new JFrame("Number Chooser");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo JPanel
        JPanel panel = new JPanel();

        // Tạo JLabel
        JLabel label = new JLabel("Chọn độ sáng từ 0 đến 100");

        // Tạo JSlider để chọn số từ 1 đến 100
        JSlider numberSlider = new JSlider(JSlider.HORIZONTAL, 0, 100, 1);
        numberSlider.setMajorTickSpacing(10);
        numberSlider.setMinorTickSpacing(1);
        numberSlider.setPaintTicks(true);
        numberSlider.setPaintLabels(true);

        // Thêm sự kiện thay đổi vào JSlider
        numberSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                if (!source.getValueIsAdjusting()) {
                    int selectedNumber = source.getValue();
                    System.out.println("Selected number: " + selectedNumber);
                }
            }
        });

        // Thêm JLabel và JSlider vào JPanel
        panel.add(label);
        panel.add(numberSlider);

        // Thêm JPanel vào JFrame
        frame.add(panel);

        // Hiển thị JFrame
        frame.setVisible(true);
        
        frame.setLocationRelativeTo(null);
    }
}
