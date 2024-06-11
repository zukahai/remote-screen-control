package views;

import java.awt.Cursor;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

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
        // screenShareButton.addActionListener(e -> hideCursor());
        contentPane.add(screenShareButton);
        this.setVisible(true);

		System.out.println("ScreenShare is running");

        // Đảm bảo JFrame có thể nhận sự kiện bàn phím
        setFocusable(true);
        requestFocusInWindow();
    }

    public void hideCursor() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = toolkit.createCustomCursor(cursorImage, new Point(0, 0), "blank cursor");
        this.setCursor(blankCursor);
    }

    public void setIcon(ImageIcon icon) {
        screenShareButton.setIcon(icon);
    }
}
