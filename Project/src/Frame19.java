import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.awt.Font;

import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JTextArea;


public class Frame19 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame19 frame = new Frame19();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} */
	/**
	 * Create the frame.
	 */
	
	public Frame19(String usrname,int uT) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(27, 307, 683, 116);
		contentPane.add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		JLabel lblMedicalHistoryOf = new JLabel("Medical History of "+usrname+"");
		Image img2 = new ImageIcon(this.getClass().getResource("/uinfo.png")).getImage();
		lblMedicalHistoryOf.setIcon(new ImageIcon(img2));
		lblMedicalHistoryOf.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblMedicalHistoryOf.setBounds(160, 11, 430, 48);
		contentPane.add(lblMedicalHistoryOf);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 180, 683, 116);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","ashwin123");
		PreparedStatement st = con.prepareStatement("SELECT * from history WHERE Name = '"+usrname+"'");
		ResultSet rs = st.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs)); 
		}catch(Exception e){
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "No medical history found!");
		}
		
		JButton btnNewButton = new JButton("Show medical history");
		Image img = new ImageIcon(this.getClass().getResource("/view2.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					File file = new File(""+usrname+".txt");
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					textArea.read(br, null);
					br.close();
					textArea.requestFocus();
				} 
				
				
				catch (Exception e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
					JOptionPane.showMessageDialog(null, "No medical history found!");
				}		
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(40, 96, 308, 60);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		Image img1 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img1));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Frame3 f3 = new Frame3(usrname,uT);
				f3.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_1.setBounds(386, 96, 308, 60);
		contentPane.add(btnNewButton_1);
		
		
		
	}
}
