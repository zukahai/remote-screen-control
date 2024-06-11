package views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ScreenShare extends JFrame {

    private JPanel contentPane;
    private JButton screenShare;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 698, 497);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(1, 0, 0, 0));

        screenShare = new JButton("New button");
        contentPane.add(screenShare);
        this.setVisible(true);

        // Thêm KeyListener để lắng nghe sự kiện bàn phím
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Không cần xử lý sự kiện này trong trường hợp này
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Đang bấm phím: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Không cần xử lý sự kiện này trong trường hợp này
            }
        });

        // Đảm bảo JFrame có thể nhận sự kiện bàn phím
        setFocusable(true);
        requestFocusInWindow();
    }

    public void setIcon(ImageIcon icon) {
        screenShare.setIcon(icon);
    }
}
