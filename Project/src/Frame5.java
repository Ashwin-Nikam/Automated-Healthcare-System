import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Frame5 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame5 frame = new Frame5();
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
	public Frame5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterTheId = new JLabel("Enter the id of disease :");
		lblEnterTheId.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblEnterTheId.setBounds(79, 52, 241, 50);
		contentPane.add(lblEnterTheId);
		
		JLabel lblEnterTheSymptom = new JLabel("Enter the symptom :");
		lblEnterTheSymptom.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblEnterTheSymptom.setBounds(104, 140, 216, 50);
		contentPane.add(lblEnterTheSymptom);
		
		JLabel lblEnterValue = new JLabel("Enter value :");
		lblEnterValue.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblEnterValue.setBounds(183, 226, 174, 50);
		contentPane.add(lblEnterValue);
		
		textField = new JTextField();
		textField.setBounds(385, 52, 200, 50);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(385, 140, 200, 50);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(385, 231, 200, 50);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		Image img = new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int id = Integer.parseInt(textField.getText());
					String symp = textField_1.getText();
					int val = Integer.parseInt(textField_2.getText());
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","ashwin123");
					PreparedStatement st = con.prepareStatement("UPDATE symptoms SET "+symp+" = '"+val+"' WHERE id = "+id+"");
					st.executeUpdate();
					JOptionPane.showMessageDialog(null, "Update successful !");
					textField.setText(null);
					textField_1.setText(null);
					textField_2.setText(null);
					}catch(Exception err){
						System.out.println(err);
						JOptionPane.showMessageDialog(null, "Error ! Check whether Id, Symptom and Value have been entered correctly");
						textField.setText(null);
						textField_1.setText(null);
						textField_2.setText(null);
					}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(43, 309, 286, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
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
		btnNewButton_1.setBounds(265, 377, 200, 57);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Association");
		Image img2 = new ImageIcon(this.getClass().getResource("/update1.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img2));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int action = JOptionPane.showConfirmDialog(null, "Are you sure?","Update Association",JOptionPane.YES_NO_OPTION);
				if(action == 0){
				Final f1 = new Final();
				try {
					f1.generateAss();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Operation could not be completed !");
				}
			}
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_2.setBounds(385, 309, 286, 57);
		contentPane.add(btnNewButton_2);
	}
}
