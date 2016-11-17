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
import javax.swing.JTextArea;
import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Frame9 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblEnterNewTreatment;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame9 frame = new Frame9();
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
	public Frame9() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the id of the disease :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(82, 31, 278, 39);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(409, 36, 77, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblEnterNewTreatment = new JLabel("Enter new treatment");
		lblEnterNewTreatment.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblEnterNewTreatment.setBounds(232, 124, 211, 50);
		contentPane.add(lblEnterNewTreatment);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(82, 185, 557, 142);
		contentPane.add(textArea);
		
		btnNewButton = new JButton("Update");
		Image img = new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int id = Integer.parseInt(textField.getText());
					String update = textArea.getText();
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","ashwin123");
					PreparedStatement st = con.prepareStatement("UPDATE disease_treatment SET treatment = '"+update+"' WHERE id = "+id+";");
					st.executeUpdate();
					textField.setText(null);
					textArea.setText(null);
					JOptionPane.showMessageDialog(null, "Update successful");
					}catch(Exception e){
						System.out.println(e);
						JOptionPane.showMessageDialog(null, "Error ! Id of disease entered is incorrect !");
						textField.setText(null);
						textArea.setText(null);
					}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(82, 350, 194, 64);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back");
		Image img1 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img1));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame7 f7 = new Frame7();
				f7.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_1.setBounds(445, 350, 194, 64);
		contentPane.add(btnNewButton_1);
	}
}
