import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;


public class Frame6 extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame6 frame = new Frame6();
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
	public Frame6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 494);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewDatabase = new JButton("View Database");
		Image img = new ImageIcon(this.getClass().getResource("/view1.png")).getImage();
		btnViewDatabase.setIcon(new ImageIcon(img));
		btnViewDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","ashwin123");
				PreparedStatement st = con.prepareStatement("SELECT * from disease_treatment");
				ResultSet rs = st.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				}catch(Exception e){
					System.out.println(e);
				}
			}
		});
		btnViewDatabase.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnViewDatabase.setBounds(41, 64, 269, 54);
		contentPane.add(btnViewDatabase);
		
		JButton btnRemoveRecords = new JButton("Remove Records");
		Image img1 = new ImageIcon(this.getClass().getResource("/remove.png")).getImage();
		btnRemoveRecords.setIcon(new ImageIcon(img1));
		btnRemoveRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame8 f8 = new Frame8();
				f8.setVisible(true);
			}
		});
		btnRemoveRecords.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnRemoveRecords.setBounds(383, 64, 269, 54);
		contentPane.add(btnRemoveRecords);
		
		JButton btnEditRecords = new JButton("Edit Records");
		Image img2 = new ImageIcon(this.getClass().getResource("/edit.png")).getImage();
		btnEditRecords.setIcon(new ImageIcon(img2));
		btnEditRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame7 f7 = new Frame7();
				f7.setVisible(true);
			}
		});
		btnEditRecords.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnEditRecords.setBounds(383, 129, 269, 54);
		contentPane.add(btnEditRecords);
		
		JButton btnNewButton = new JButton("Logout");
		Image img4 = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img4));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame14 f14 = new Frame14();
				f14.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(383, 391, 269, 53);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 194, 652, 186);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		Image img3 = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		
		JLabel lblAdminFunctions = new JLabel("Admin Functions");
		lblAdminFunctions.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblAdminFunctions.setBounds(249, 11, 223, 44);
		contentPane.add(lblAdminFunctions);
		
		JButton btnNewButton_2 = new JButton("Add records");
		Image img5 = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img5));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame12 f12 = new Frame12();
				f12.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_2.setBounds(41, 129, 269, 54);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("User info");
		Image img6 = new ImageIcon(this.getClass().getResource("/uinfo1.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon(img6));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame17 f17 = new Frame17();
				f17.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_3.setBounds(41, 391, 269, 53);
		contentPane.add(btnNewButton_3);
	}
}
