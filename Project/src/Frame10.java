import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Frame10 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame10 frame = new Frame10();
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
	public Frame10() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add");
		Image img = new ImageIcon(this.getClass().getResource("/add1.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					String symp = textField.getText();
					Final f1 = new Final();
					f1.forNewSymp(symp);
					textField.setText(null);
					JOptionPane.showMessageDialog(null, "Symptom added !");
					}catch(Exception err){
						System.out.println(err);
						JOptionPane.showMessageDialog(null, "Error ! Symptom entered is incorrect or already been added");
						textField.setText(null);
					}

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(65, 246, 284, 62);
		contentPane.add(btnNewButton);
		
		JLabel lblEnterTheSymptom = new JLabel("Enter the symptom to be added :");
		lblEnterTheSymptom.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblEnterTheSymptom.setBounds(65, 147, 333, 44);
		contentPane.add(lblEnterTheSymptom);
		
		textField = new JTextField();
		textField.setBounds(440, 156, 157, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Back");
		Image img1 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img1));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Frame12 f12 = new Frame12();
				f12.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_1.setBounds(217, 351, 284, 62);
		contentPane.add(btnNewButton_1);
		
		JLabel lblAdd = new JLabel("Add new symptoms");
		Image img2 = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		lblAdd.setIcon(new ImageIcon(img2));
		lblAdd.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblAdd.setBounds(217, 26, 296, 74);
		contentPane.add(lblAdd);
		
		JButton btnNewButton_2 = new JButton("Update Association");
		Image img3 = new ImageIcon(this.getClass().getResource("/update1.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img3));
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
					JOptionPane.showMessageDialog(null, "Operation could not be performed !");
				}
			} 
				}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_2.setBounds(382, 246, 284, 62);
		contentPane.add(btnNewButton_2);
	}
}
