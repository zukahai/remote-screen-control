package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import models.User;

import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;

public class ClientView extends JFrame {

	private JPanel contentPane;
	public JTextField ip_tf;
	public JTextField port_tf;
	private JTextField myID;
	private JTextField myPass;
	public JTextField idTf;
	public JTextField passTf;
	private JPanel connect_pn;
	private JPanel main_pn;
	public JButton connectScreen;
	public JButton connectServer;
	public JButton screenCapture;
	public JButton changeDesktopBackground;

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
		setTitle("Điều khiển màn hình");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 620, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#323333"));
		contentPane.setBorder(new CompoundBorder());

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#292a30"));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 303, 384);
		contentPane.add(panel);
		panel.setLayout(null);
		
		main_pn = new JPanel();
		main_pn.setBackground(Color.decode("#2f3239"));
		main_pn.setBounds(10, 11, 283, 331);
		panel.add(main_pn);
		main_pn.setLayout(null);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.decode("#2f3239"));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(0, 11, 283, 126);
		main_pn.add(panel_1_1);
		
		myID = new JTextField();
		myID.setBackground(Color.decode("#acadaf"));
		myID.setFont(new Font("Roboto", Font.BOLD, 13));
		myID.setColumns(10);
		myID.setBounds(49, 50, 224, 26);
		myID.setHorizontalAlignment(JTextField.CENTER);
		panel_1_1.add(myID);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.decode("#fa78af"));
		lblId.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblId.setBounds(10, 56, 61, 14);
		panel_1_1.add(lblId);
		
		JLabel lblChoPhpKt = new JLabel("Cho phép kết nối", SwingConstants.CENTER);
		lblChoPhpKt.setForeground(Color.decode("#85ccf2"));
		lblChoPhpKt.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblChoPhpKt.setBounds(10, 11, 263, 14);
		panel_1_1.add(lblChoPhpKt);
		
		JLabel lblPass = new JLabel("PASS");
		lblPass.setForeground(Color.decode("#fa78af"));
		lblPass.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblPass.setBounds(10, 93, 61, 14);
		panel_1_1.add(lblPass);
		
		myPass = new JTextField();
		myPass.setBackground(Color.decode("#acadaf"));
		myPass.setFont(new Font("Roboto", Font.BOLD, 13));
		myPass.setColumns(10);
		myPass.setBounds(49, 87, 224, 26);
		myPass.setHorizontalAlignment(JTextField.CENTER);
		panel_1_1.add(myPass);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 148, 263, 2);
		main_pn.add(separator);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(Color.decode("#2f3239"));
		panel_1_2.setLayout(null);
		panel_1_2.setBounds(0, 161, 283, 171);
		main_pn.add(panel_1_2);
		
		idTf = new JTextField();
		idTf.setBackground(Color.decode("#acadaf"));
		idTf.setFont(new Font("Roboto", Font.BOLD, 13));
		idTf.setColumns(10);
		idTf.setBounds(52, 50, 221, 26);
		idTf.setHorizontalAlignment(JTextField.CENTER);
		panel_1_2.add(idTf);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setForeground(Color.decode("#fa78af"));
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(10, 56, 61, 14);
		panel_1_2.add(lblNewLabel_1);
		
		JLabel lbliuKhinMn = new JLabel("Điều khiển màn hình máy khác", SwingConstants.CENTER);
		lbliuKhinMn.setForeground(Color.decode("#85ccf2"));
		lbliuKhinMn.setFont(new Font("Roboto", Font.PLAIN, 17));
		lbliuKhinMn.setBounds(10, 11, 263, 14);
		panel_1_2.add(lbliuKhinMn);
		
		JLabel lblPort_1 = new JLabel("PASS");
		lblPort_1.setForeground(Color.decode("#fa78af"));
		lblPort_1.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblPort_1.setBounds(10, 93, 61, 14);
		panel_1_2.add(lblPort_1);
		
		passTf = new JTextField();
		passTf.setBackground(Color.decode("#acadaf"));
		passTf.setFont(new Font("Roboto", Font.BOLD, 13));
		passTf.setColumns(10);
		passTf.setBounds(52, 87, 221, 26);
		passTf.setHorizontalAlignment(JTextField.CENTER);
		panel_1_2.add(passTf);
		
		connectScreen = new JButton("Kết nối");
		connectScreen.setFont(new Font("Roboto", Font.PLAIN, 11));
		connectScreen.setBackground(Color.decode("#3d3b37"));
		connectScreen.setForeground(Color.decode("#85ccf2"));
		connectScreen.setBounds(101, 125, 89, 23);
		panel_1_2.add(connectScreen);
		
		connect_pn = new JPanel();
		connect_pn.setBackground(Color.decode("#2f3239"));
		connect_pn.setBounds(13, 57, 273, 171);
		panel.add(connect_pn);
		connect_pn.setLayout(null);
		
		ip_tf = new JTextField("localhost");
		ip_tf.setBackground(Color.decode("#acadaf"));
		ip_tf.setFont(new Font("Roboto", Font.BOLD, 13));
		ip_tf.setBounds(49, 50, 214, 26);
		ip_tf.setHorizontalAlignment(JTextField.CENTER);
		connect_pn.add(ip_tf);
		ip_tf.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("IP");
		lblNewLabel.setForeground(Color.decode("#fa78af"));
		lblNewLabel.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblNewLabel.setBounds(10, 56, 46, 14);
		connect_pn.add(lblNewLabel);
		
		JLabel lblKtNiTi = new JLabel("Kết nối tới máy chủ", SwingConstants.CENTER);
		lblKtNiTi.setBackground(Color.decode("#3d3b37"));
		lblKtNiTi.setForeground(Color.decode("#85ccf2"));
		lblKtNiTi.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblKtNiTi.setBounds(10, 11, 263, 14);
		connect_pn.add(lblKtNiTi);
		
		JLabel lblPort = new JLabel("PORT");
		lblPort.setForeground(Color.decode("#fa78af"));
		lblPort.setFont(new Font("Roboto", Font.PLAIN, 11));
		lblPort.setBounds(10, 93, 46, 14);
		connect_pn.add(lblPort);
		
		port_tf = new JTextField("6868");
		port_tf.setBackground(Color.decode("#acadaf"));
		port_tf.setFont(new Font("Roboto", Font.BOLD, 13));
		port_tf.setColumns(10);
		port_tf.setHorizontalAlignment(JTextField.CENTER);
		port_tf.setBounds(49, 87, 214, 26);
		connect_pn.add(port_tf);
		
		connectServer = new JButton("Kết nối");
		connectServer.setFont(new Font("Roboto", Font.PLAIN, 11));
		connectServer.setBackground(Color.decode("#3d3b37"));
		connectServer.setForeground(Color.decode("#85ccf2"));
		connectServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanelMain();
			}
		});
		connectServer.setBounds(101, 125, 89, 23);
		connect_pn.add(connectServer);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.decode("#292a30"));
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(336, 11, 257, 384);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		screenCapture = new JButton("");
		screenCapture.setIcon(getIcon("screen_capture"));
		screenCapture.setBounds(10, 11, 113, 113);
		panel_1.add(screenCapture);
		
		changeDesktopBackground = new JButton("");
		changeDesktopBackground.setBounds(133, 11, 113, 113);
		changeDesktopBackground.setIcon(getIcon("coming_soon"));
		panel_1.add(changeDesktopBackground);
		
		JButton screenCapture_2 = new JButton("");
		screenCapture_2.setBounds(10, 135, 113, 113);
		screenCapture_2.setIcon(getIcon("coming_soon"));
		panel_1.add(screenCapture_2);
		
		JButton screenCapture_1_1 = new JButton("");
		screenCapture_1_1.setBounds(133, 135, 113, 113);
		screenCapture_1_1.setIcon(getIcon("coming_soon"));
		panel_1.add(screenCapture_1_1);
		
		JButton screenCapture_3 = new JButton("");
		screenCapture_3.setIcon(getIcon("coming_soon"));
		screenCapture_3.setBounds(10, 260, 113, 113);
		panel_1.add(screenCapture_3);
		
		JButton screenCapture_1_2 = new JButton("");
		screenCapture_1_2.setIcon(getIcon("coming_soon"));
		screenCapture_1_2.setBounds(133, 260, 113, 113);
		panel_1.add(screenCapture_1_2);
		setLocationRelativeTo(null);
		
		setPanelConnect();
		setVisible(true);
	}
	
	public Icon getIcon(String name) {
		int width = 113;
		int height = 113;
		Image image = new ImageIcon(getClass().getResource("/icons/" + name + ".png")).getImage();
		Icon icon = new ImageIcon(image.getScaledInstance(width, height, image.SCALE_SMOOTH));
		return icon;
	}
	
	public void setPanelConnect() {
		main_pn.setVisible(false);
		connect_pn.setVisible(true);
	}
	
	public void setPanelMain() {
		main_pn.setVisible(true);
		connect_pn.setVisible(false);
	}
	
	public void setUser(User user) {
		myID.setText(user.getId() + "");
		myPass.setText(user.getPassword() + "");
	}
}