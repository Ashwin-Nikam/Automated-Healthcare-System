import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JPasswordField;


public class Frame16 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame16 frame = new Frame16();
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
	public Frame16(int uT) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewUserInfo = new JLabel("New User Info");
		lblNewUserInfo.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewUserInfo.setBounds(269, 11, 201, 37);
		contentPane.add(lblNewUserInfo);
		
		JLabel lblEnterYourName = new JLabel("Enter your name :");
		lblEnterYourName.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblEnterYourName.setBounds(39, 69, 208, 37);
		contentPane.add(lblEnterYourName);
		
		JLabel lblEnterYourUsername = new JLabel("Enter new username :");
		lblEnterYourUsername.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblEnterYourUsername.setBounds(39, 149, 229, 21);
		contentPane.add(lblEnterYourUsername);
		
		JLabel lblEnterPassword = new JLabel("Enter new password :");
		lblEnterPassword.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblEnterPassword.setBounds(39, 219, 229, 37);
		contentPane.add(lblEnterPassword);
		
		textField = new JTextField();
		textField.setBounds(278, 71, 132, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(278, 142, 133, 42);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		Image img1 = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					String name = textField.getText();
					String uname = textField_1.getText();
					String pass = passwordField.getText();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","ashwin123");
					PreparedStatement st = con.prepareStatement("INSERT INTO userinfo (Name,Username,Password) VALUES('"+name+"','"+uname+"','"+pass+"')");
					st.executeUpdate();
					
					PreparedStatement st1 = con.prepareStatement("INSERT INTO sympHistory (username) VALUES ('"+uname+"');");
					st1.executeUpdate();
					
					textField.setText(null);
					textField_1.setText(null);
					passwordField.setText(null);
					JOptionPane.showMessageDialog(null, "User registered !");
					
					dispose();
					Frame11 f11 = new Frame11(uT);
					f11.setVisible(true);
					
					}catch(Exception err){
						System.out.println(err);
						JOptionPane.showMessageDialog(null, "Error ! Check whether Name, Username and Password have been correctly entered");
						textField.setText(null);
						textField_1.setText(null);
						passwordField.setText(null);
					}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(144, 329, 152, 64);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		Image img2 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img2));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame15 f15 = new Frame15();
				f15.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_1.setBounds(390, 329, 152, 64);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/user2.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img3));
		lblNewLabel.setBounds(432, 27, 288, 276);
		contentPane.add(lblNewLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(278, 219, 132, 42);
		contentPane.add(passwordField);
		
	}
}
