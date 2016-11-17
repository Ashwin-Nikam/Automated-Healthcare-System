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
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTable;

import net.proteanit.sql.DbUtils;


public class Frame13 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	public int i = 1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame13 frame = new Frame13();
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
	public Frame13() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterNewId = new JLabel("Enter new id :");
		lblEnterNewId.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblEnterNewId.setBounds(10, 10, 146, 36);
		contentPane.add(lblEnterNewId);
		
		JLabel lblEnterDisease = new JLabel("Enter disease :");
		lblEnterDisease.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblEnterDisease.setBounds(338, 10, 146, 36);
		contentPane.add(lblEnterDisease);
		
		JLabel lblEnterTreatment = new JLabel("Enter treatment :");
		lblEnterTreatment.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblEnterTreatment.setBounds(10, 57, 177, 43);
		contentPane.add(lblEnterTreatment);
		
		JLabel lblEnterSymptoms = new JLabel("Enter symptoms :");
		lblEnterSymptoms.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblEnterSymptoms.setBounds(10, 111, 189, 36);
		contentPane.add(lblEnterSymptoms);
		
		textField = new JTextField();
		textField.setBounds(193, 15, 135, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(494, 15, 192, 36);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(194, 112, 121, 36);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(195, 57, 491, 43);
		contentPane.add(scrollPane);
		
		JTextArea textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(i==1){
					String id,disease,treatment;
					id = textField.getText();
					disease = textField_1.getText();
					treatment = textArea_1.getText();
					String symp = textField_2.getText();
					textField_2.setText(null);
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","ashwin123");
					PreparedStatement st = con.prepareStatement("INSERT INTO symptoms (id,"+symp+") VALUES ('"+id+"','1');");
					PreparedStatement st1 = con.prepareStatement("INSERT INTO disease_treatment VALUES ('"+id+"','"+disease+"','"+treatment+"');");
					st.executeUpdate();
					st1.executeUpdate();
					JOptionPane.showMessageDialog(null, "Update successful !");
					i++;
					}else if(i==2){
						String id,disease,treatment;
						id = textField.getText();
						disease = textField_1.getText();
						treatment = textArea_1.getText();
						String symp = textField_2.getText();
						textField_2.setText(null);
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","ashwin123");
						PreparedStatement st = con.prepareStatement("UPDATE symptoms SET "+symp+" = '1' WHERE id = '"+id+"'");
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Update successful !");
					}
					}catch(Exception error){
						System.out.println(error);
						JOptionPane.showMessageDialog(null, "Error ! Check if Id, Disease, Symptom and Treatment have been properly entered");
						textField.setText(null);
						textField_1.setText(null);
						textArea_1.setText(null);
						textField_2.setText(null);
					}
				
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/add1.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(399, 111, 177, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Show records");
		Image img1 = new ImageIcon(this.getClass().getResource("/view.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img1));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","ashwin123");
					PreparedStatement st = con.prepareStatement("SELECT * from disease_treatment");
					ResultSet rs = st.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					textField.setText(null);
					textField_1.setText(null);
					textArea_1.setText(null);
					textField_2.setText(null);
					}catch(Exception err){
						System.out.println(err);
					}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBounds(31, 172, 287, 53);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 236, 696, 142);
		contentPane.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Frame12 f12 = new Frame12();
				f12.setVisible(true);
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img2));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_2.setBounds(301, 390, 165, 43);
		contentPane.add(btnNewButton_2);
		
		
		JButton btnNewButton_3 = new JButton("Update Association");
		Image img4 = new ImageIcon(this.getClass().getResource("/update1.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon(img4));
		btnNewButton_3.addActionListener(new ActionListener() {
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
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_3.setBounds(399, 174, 287, 51);
		contentPane.add(btnNewButton_3);
		
		
		
		
	}
}
