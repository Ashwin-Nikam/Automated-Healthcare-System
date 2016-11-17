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
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Frame8 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame8 frame = new Frame8();
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
	public Frame8() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectIdOf = new JLabel("Select id of the entry to be deleted :");
		lblSelectIdOf.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblSelectIdOf.setBounds(10, 148, 358, 33);
		contentPane.add(lblSelectIdOf);
		
		textField = new JTextField();
		textField.setBounds(403, 148, 152, 43);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		Image img2 = new ImageIcon(this.getClass().getResource("/delete.png")).getImage();
		btnDelete.setIcon(new ImageIcon(img2));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					int id = Integer.parseInt(textField.getText());
					textField.setText(null);
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","ashwin123");
					PreparedStatement st = con.prepareStatement("DELETE FROM disease_treatment WHERE id = '"+id+"'");
					PreparedStatement st1 = con.prepareStatement("DELETE FROM symptoms WHERE id = '"+id+"'");
					st.execute();
					st1.execute();
					PreparedStatement st2 = con.prepareStatement("SELECT * from disease_treatment");
					ResultSet rs = st2.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					}catch(Exception e){
						System.out.println(e);
						JOptionPane.showMessageDialog(null, "Error ! Check whether Id has been properly entered");
						textField.setText(null);
					}
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnDelete.setBounds(39, 209, 293, 53);
		contentPane.add(btnDelete);
		
		JButton btnNewButton = new JButton("Show records");
		Image img = new ImageIcon(this.getClass().getResource("/view.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","ashwin123");
					PreparedStatement st = con.prepareStatement("SELECT * from disease_treatment");
					ResultSet rs = st.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					}catch(Exception err){
						System.out.println(err);
					}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(61, 84, 271, 53);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 275, 716, 154);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Back");
		Image img1 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img1));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame6 f6 = new Frame6();
				f6.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_1.setBounds(403, 84, 271, 53);
		contentPane.add(btnNewButton_1);
		
		JLabel lblRemoveRecords = new JLabel("Remove records");
		Image img3 = new ImageIcon(this.getClass().getResource("/remove.png")).getImage();
		lblRemoveRecords.setIcon(new ImageIcon(img3));
		lblRemoveRecords.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblRemoveRecords.setBounds(252, 11, 271, 53);
		contentPane.add(lblRemoveRecords);
		
		JButton btnNewButton_2 = new JButton("Update Association");
		Image img4 = new ImageIcon(this.getClass().getResource("/update1.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img4));
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
			} }
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_2.setBounds(403, 211, 293, 53);
		contentPane.add(btnNewButton_2);
	}
}
