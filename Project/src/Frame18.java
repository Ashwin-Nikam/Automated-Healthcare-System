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


public class Frame18 extends JFrame {

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
					Frame18 frame = new Frame18();
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
	public Frame18() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectIdOf = new JLabel("Select id of the entry to be deleted :");
		lblSelectIdOf.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblSelectIdOf.setBounds(10, 164, 358, 33);
		contentPane.add(lblSelectIdOf);
		
		textField = new JTextField();
		textField.setBounds(371, 159, 103, 53);
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
					PreparedStatement st3 = con.prepareStatement("SELECT * from history,userinfo WHERE history.Name = userinfo.Username AND userinfo.id = "+id+";");
					ResultSet rs1 = st3.executeQuery();
					int count = 0;
					
					while(rs1.next()){
						count++;
					}
					
					if(count == 0){
					PreparedStatement st = con.prepareStatement("DELETE userinfo FROM userinfo WHERE id = "+id+"");
					st.execute();
					}
					
					else{
					PreparedStatement st1 = con.prepareStatement("DELETE userinfo,history FROM userinfo,history WHERE userinfo.Username = history.Name AND userinfo.id = "+id+";");
					st1.execute();}
					
					
					PreparedStatement st2 = con.prepareStatement("SELECT * from userinfo");
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
		btnDelete.setBounds(492, 159, 215, 53);
		contentPane.add(btnDelete);
		
		JButton btnNewButton = new JButton("Display existing users");
		Image img = new ImageIcon(this.getClass().getResource("/view.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","ashwin123");
					PreparedStatement st = con.prepareStatement("SELECT * from userinfo");
					ResultSet rs = st.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					}catch(Exception err){
						System.out.println(err);
					}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(45, 84, 307, 53);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 223, 716, 206);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Back");
		Image img1 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img1));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame17 f17 = new Frame17();
				f17.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_1.setBounds(384, 84, 307, 53);
		contentPane.add(btnNewButton_1);
		
		JLabel lblRemoveRecords = new JLabel("Remove existing user");
		Image img3 = new ImageIcon(this.getClass().getResource("/remove1.png")).getImage();
		lblRemoveRecords.setIcon(new ImageIcon(img3));
		lblRemoveRecords.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblRemoveRecords.setBounds(208, 11, 323, 53);
		contentPane.add(lblRemoveRecords);
	}
}