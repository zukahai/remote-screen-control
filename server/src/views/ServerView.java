package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;

public class ServerView extends JFrame {

	private JPanel contentPane;
	private JTextField portTf;
	public JButton startBt;
	public JTextArea contentServer;
	public JLabel ipv4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerView frame = new ServerView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ServerView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#181818"));
		panel.setBounds(0, 0, 465, 338);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ipv4 = new JLabel("", SwingConstants.CENTER);
		ipv4.setForeground(Color.decode("#85ccf2"));
		ipv4.setFont(new Font("Roboto", Font.BOLD, 20));
		ipv4.setBounds(10, 11, 434, 19);
		panel.add(ipv4);
		
		JPanel startPanel = new JPanel();
		startPanel.setBackground(Color.decode("#1e1e1e"));
		startPanel.setBounds(10, 41, 445, 39);
		panel.add(startPanel);
		startPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("PORT");
		lblNewLabel_1.setForeground(Color.decode("#85ccf2"));
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 11, 46, 14);
		startPanel.add(lblNewLabel_1);
		
		portTf = new JTextField();
		portTf.setBackground(Color.decode("#1e1e1e"));
		portTf.setForeground(Color.decode("#85ccf2"));
		portTf.setFont(new Font("Roboto", Font.PLAIN, 12));
		portTf.setBounds(66, 8, 136, 20);
		startPanel.add(portTf);
		portTf.setColumns(10);
		
		startBt = new JButton("Khởi động máy chủ");
		startBt.setBackground(Color.decode("#3d3b37"));
		startBt.setForeground(Color.decode("#85ccf2"));
		startBt.setFont(new Font("Roboto", Font.PLAIN, 12));
		startBt.setBounds(218, 7, 178, 23);
		startPanel.add(startBt);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#1e1e1e"));
		panel_1.setBounds(10, 91, 445, 236);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 425, 225);
		panel_1.add(scrollPane);
		
		contentServer = new JTextArea();
		contentServer.setForeground(Color.decode("#85ccf2"));
		contentServer.setBackground(Color.decode("#1e1e1e"));
		contentServer.setFont(new Font("Roboto", Font.PLAIN, 15));
		scrollPane.setViewportView(contentServer);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	public void setIPv4(String text) {
		ipv4.setText(text);
	}
}
