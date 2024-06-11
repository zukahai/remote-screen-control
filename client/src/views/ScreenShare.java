package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ScreenShare extends JFrame {

    private JPanel contentPane;
    public JButton screenShareButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ScreenShare frame = new ScreenShare();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ScreenShare() {
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 698, 497);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(1, 0, 0, 0));

        screenShareButton = new JButton("");
        contentPane.add(screenShareButton);
        this.setVisible(true);

		System.out.println("ScreenShare is running");

        // Đảm bảo JFrame có thể nhận sự kiện bàn phím
        setFocusable(true);
        requestFocusInWindow();
    }

    public void setIcon(ImageIcon icon) {
        screenShareButton.setIcon(icon);
    }
}
