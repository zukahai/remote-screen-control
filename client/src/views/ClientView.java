package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JSeparator;

public class ClientView extends JFrame {

	private JPanel contentPane;
	private JTextField ip_tf;
	private JTextField port_tf;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPanel connect_pn;
	private JPanel main_pn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientView frame = new ClientView();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ClientView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 920, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 303, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		main_pn = new JPanel();
		main_pn.setBounds(10, 11, 283, 331);
		panel.add(main_pn);
		main_pn.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 11, 283, 126);
		main_pn.add(panel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(65, 50, 208, 26);
		panel_1_1.add(textField);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblId.setBounds(10, 56, 61, 14);
		panel_1_1.add(lblId);
		
		JLabel lblChoPhpKt = new JLabel("Cho phép kết nối", SwingConstants.CENTER);
		lblChoPhpKt.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblChoPhpKt.setBounds(10, 11, 263, 14);
		panel_1_1.add(lblChoPhpKt);
		
		JLabel lblPass = new JLabel("PASS");
		lblPass.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblPass.setBounds(10, 93, 61, 14);
		panel_1_1.add(lblPass);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(65, 87, 208, 26);
		panel_1_1.add(textField_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 148, 263, 2);
		main_pn.add(separator);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(0, 161, 283, 171);
		main_pn.add(panel_1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(81, 50, 192, 26);
		panel_1_2.add(textField_2);
		
		JLabel lblNewLabel_1 = new JLabel("IP");
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 56, 61, 14);
		panel_1_2.add(lblNewLabel_1);
		
		JLabel lbliuKhinMn = new JLabel("Điều khiển màn hình máy khác", SwingConstants.CENTER);
		lbliuKhinMn.setFont(new Font("Roboto", Font.PLAIN, 17));
		lbliuKhinMn.setBounds(10, 11, 263, 14);
		panel_1_2.add(lbliuKhinMn);
		
		JLabel lblPort_1 = new JLabel("PASS");
		lblPort_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblPort_1.setBounds(10, 93, 61, 14);
		panel_1_2.add(lblPort_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(81, 87, 192, 26);
		panel_1_2.add(textField_3);
		
		JButton connect_screen = new JButton("Kết nối");
		connect_screen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		connect_screen.setFont(new Font("Roboto", Font.PLAIN, 11));
		connect_screen.setBounds(101, 125, 89, 23);
		panel_1_2.add(connect_screen);
		
		connect_pn = new JPanel();
		connect_pn.setBounds(13, 57, 273, 171);
		panel.add(connect_pn);
		connect_pn.setLayout(null);
		
		ip_tf = new JTextField();
		ip_tf.setBounds(81, 50, 192, 26);
		connect_pn.add(ip_tf);
		ip_tf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("IP");
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel.setBounds(25, 56, 46, 14);
		connect_pn.add(lblNewLabel);
		
		JLabel lblKtNiTi = new JLabel("Kết nối tới máy chủ", SwingConstants.CENTER);
		lblKtNiTi.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblKtNiTi.setBounds(10, 11, 263, 14);
		connect_pn.add(lblKtNiTi);
		
		JLabel lblPort = new JLabel("PORT");
		lblPort.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblPort.setBounds(25, 93, 46, 14);
		connect_pn.add(lblPort);
		
		port_tf = new JTextField();
		port_tf.setColumns(10);
		port_tf.setBounds(81, 87, 192, 26);
		connect_pn.add(port_tf);
		
		JButton connect_server = new JButton("Kết nối");
		connect_server.setFont(new Font("Roboto", Font.PLAIN, 11));
		connect_server.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelMain();
			}
		});
		connect_server.setBounds(101, 125, 89, 23);
		connect_pn.add(connect_server);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(336, 11, 546, 384);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton screen_shot = new JButton("Screen Shot");
		screen_shot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		screen_shot.setBounds(10, 11, 257, 113);
		panel_1.add(screen_shot);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(277, 11, 257, 113);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(10, 135, 257, 113);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setBounds(277, 135, 257, 113);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(10, 259, 257, 113);
		panel_1.add(btnNewButton_3);
		
		JButton btnNewButton_1_2 = new JButton("New button");
		btnNewButton_1_2.setBounds(277, 259, 257, 113);
		panel_1.add(btnNewButton_1_2);
		setLocationRelativeTo(null);
		
		setPanelConnect();
		setVisible(true);
	}
	
	public void setPanelConnect() {
		main_pn.setVisible(false);
		connect_pn.setVisible(true);
	}
	
	public void setPanelMain() {
		main_pn.setVisible(true);
		connect_pn.setVisible(false);
	}
}