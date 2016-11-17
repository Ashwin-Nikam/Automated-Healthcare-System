import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextArea;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Formatter;
import java.util.GregorianCalendar;
import javax.swing.DropMode;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Frame22 extends JFrame {

	private JPanel contentPane;
	FileWriter fw,fw1;
	BufferedWriter bw,bw1;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame4 frame = new frame4();
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
	public Frame22(String disease,String treatment,String usern,ArrayList<String> sympArrForYes) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDisease = new JLabel("According to our system, you are suffering from");
		//Image img1 = new ImageIcon(this.getClass().getResource("/disease.png")).getImage();
		//lblDisease.setIcon(new ImageIcon(img1));
		lblDisease.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblDisease.setHorizontalAlignment(SwingConstants.LEFT);
		lblDisease.setBounds(96, 13, 548, 29);
		contentPane.add(lblDisease);
		
		JLabel lblTreatment = new JLabel("Treatment required    : ");
		Image img2 = new ImageIcon(this.getClass().getResource("/treatment1.png")).getImage();
		lblTreatment.setIcon(new ImageIcon(img2));
		lblTreatment.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblTreatment.setHorizontalAlignment(SwingConstants.CENTER);
		lblTreatment.setBounds(36, 128, 318, 48);
		contentPane.add(lblTreatment);
		
		
		
			
		
		try{
			Calendar cal = new GregorianCalendar();
			int day,month,year,hour,min;
			day = cal.get(Calendar.DAY_OF_MONTH); month = cal.get(Calendar.MONTH); year = cal.get(Calendar.YEAR);
			hour = cal.get(Calendar.HOUR_OF_DAY); min = cal.get(Calendar.MINUTE);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","ashwin123"); 
			PreparedStatement st = con.prepareStatement("INSERT INTO history (Name,Date,Time,Diagnosis) VALUES ('"+usern+"','"+day+"/"+month+"/"+year+"','"+hour+":"+min+"','"+disease+"');");
			st.executeUpdate();
			
			
			
			for(int i=0;i<sympArrForYes.size();i++){
				String temp=sympArrForYes.get(i);
				
				temp=temp.replace(' ','_');
				
				PreparedStatement st2 = con.prepareStatement("UPDATE symphistory SET "+temp+" = 1 WHERE username = '"+usern+"';");
				st2.executeUpdate();
				
			}
			
			File file = new File(""+usern+".txt");
			if(file.exists()==false){
				file.createNewFile();
				System.out.println("File created");
				fw = new FileWriter(file,true);
				bw = new BufferedWriter(fw);
				bw.write("Medical history of "+usern+"\r\nDate: "+day+"/"+month+"/"+year+" \r\n"
						+ "Diagnosis carried out on patient "+usern+" indicated that the patient may be suffering from "+disease+"."
								+ "\r\nThis diagnosis was based on the response given by the patient to symptoms like -- ");
				for(int i=0;i<sympArrForYes.size();i++){
					
					bw.write(sympArrForYes.get(i));
					
					if(i==sympArrForYes.size()-1){
						bw.write(".");
					}
					else
						bw.write(",");
						}
				
				
				bw.write( "\nThe treatment advised to patient includes "+treatment+"\r\n");
				
				System.out.println("First entry in file made");
				bw.close();
				
			}else{
				fw1 = new FileWriter(file,true);
				bw1 = new BufferedWriter(fw1);
				bw1.write("\r\nDate: "+day+"/"+month+"/"+year+" \r\n"
						+ "Diagnosis carried out on patient "+usern+" indicated that the patient may be suffering from "+disease+"."
								+ "\r\nThis diagnosis was based on the response given by the patient to symptoms like -- ");
				for(int i=0;i<sympArrForYes.size();i++){
					
					bw1.write(sympArrForYes.get(i));
				
					if(i==sympArrForYes.size()-1){
						bw1.write(".");
					}
					else
						bw1.write(",");
				}
				
				
				bw1.write( "\nThe treatment advised to patient includes "+treatment+"\r\n");
				
				System.out.println("File updated");
				bw1.close();
			}
			
		} 
		
		
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(98, 175, 561, 160);
		contentPane.add(scrollPane);
		
							
		
		JTextArea textTreatment = new JTextArea();
		scrollPane.setViewportView(textTreatment);
		scrollPane.getVerticalScrollBar();
		textTreatment.setWrapStyleWord(true);
		textTreatment.setEditable(false);
		textTreatment.setText(treatment);
		textTreatment.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		JButton btnNewButton = new JButton("Logout");
		Image img = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame14 f14 = new Frame14();
				f14.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(492, 369, 211, 54);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Try again");
		Image img3 = new ImageIcon(this.getClass().getResource("/update2.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img3));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Final f1 = new Final();
				try {
					f1.findMAxSympInitial(usern);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_1.setBounds(36, 369, 211, 54);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame3 f3 = new Frame3(usern,0);
				f3.setVisible(true);
			}
		});
		Image img4 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img4));
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_2.setBounds(268, 369, 212, 54);
		contentPane.add(btnNewButton_2);
		
		JLabel label = new JLabel(disease);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label.setBounds(96, 41, 573, 34);
		contentPane.add(label);
		
		JLabel lblYouMayWant = new JLabel("You may want to confirm it by undergoing required");
		lblYouMayWant.setHorizontalAlignment(SwingConstants.LEFT);
		lblYouMayWant.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblYouMayWant.setBounds(96, 71, 573, 34);
		contentPane.add(lblYouMayWant);
		
		JLabel lblTestsInA = new JLabel("tests in a nearby hospital.");
		lblTestsInA.setHorizontalAlignment(SwingConstants.LEFT);
		lblTestsInA.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTestsInA.setBounds(96, 100, 573, 34);
		contentPane.add(lblTestsInA);
	}
	
	public void fileFunction(){
		
	}
}


