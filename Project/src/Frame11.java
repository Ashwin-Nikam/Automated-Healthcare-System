import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Frame11 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 frame = new Frame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Frame11(int uType) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoginPage = new JLabel("User Login Page");
		lblLoginPage.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblLoginPage.setBounds(251, 11, 235, 37);
		contentPane.add(lblLoginPage);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(345, 108, 122, 29);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(345, 176, 122, 29);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(540, 108, 136, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(540, 176, 136, 34);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		Image img1 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnLogin.setIcon(new ImageIcon(img1));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String uname = textField.getText();
					String pass = passwordField.getText();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","ashwin123");
					PreparedStatement st = con.prepareStatement("SELECT * FROM userinfo WHERE Username = '"+uname+"' AND Password = '"+pass+"'");
					ResultSet rs = st.executeQuery();
					int count = 0;
					while(rs.next()){
						count++;
					}if(count==1){
						dispose();
						Frame3 f3 = new Frame3(uname,uType);
						f3.setVisible(true);
						JOptionPane.showMessageDialog(null, "Welcome "+uname+"");
					}else if(count==0){
						JOptionPane.showMessageDialog(null, "Invalid Username/Password");
						textField.setText(null);
						passwordField.setText(null);
					}else if(count>1){
						JOptionPane.showMessageDialog(null, "Multiple entries for username/passwords");
						textField.setText(null);
						passwordField.setText(null);
					}
					}catch(Exception err){
						System.out.println(err);
						JOptionPane.showMessageDialog(null, "Error ! Check whether Username and Password have been properly entered");
						textField.setText(null);
						passwordField.setText(null);
					}
				
			}
		});
		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnLogin.setBounds(470, 235, 206, 65);
		contentPane.add(btnLogin);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(34, 86, 261, 262);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("Home");
		Image img2 = new ImageIcon(this.getClass().getResource("/home.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Frame14 f14 = new Frame14();
				f14.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(275, 342, 206, 65);
		contentPane.add(btnNewButton);
	}
	

}
