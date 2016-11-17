import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import net.proteanit.sql.DbUtils;


public class Frame4 extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton_1;
	FileWriter fw,fw1;
	BufferedWriter bw,bw1;
	FileReader fr;
	BufferedReader br;
	String path;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) throws Exception{
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame4 frame = new Frame4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}  */

	/**
	 * Create the frame.
	 */
	public Frame4(String usern,int uT) throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 746, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(11, 181, 709, 172);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Start diagnosis");
		Image img = new ImageIcon(this.getClass().getResource("/diagnosis.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String age;
				age = textField.getText();*/
				dispose();
				
				try {
					if(uT==0){//for an existing user.
						dispose();
					Frame24 f=new Frame24(usern);
					f.setVisible(true);
					}
					else
					{
						dispose();
						Final f1 = new Final();
						f1.findMAxSympInitial(usern);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(62, 364, 269, 60);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back");
		Image img1 = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img1));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Frame3 f3 = new Frame3(usern,uT);
				f3.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_1.setBounds(407, 364, 269, 60);
		contentPane.add(btnNewButton_1);
		
		JLabel lblIfAnyPrevious = new JLabel("If you want the system to know about any medical history ,");
		lblIfAnyPrevious.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblIfAnyPrevious.setBounds(62, 13, 614, 41);
		contentPane.add(lblIfAnyPrevious);
		
		
		
		
		JButton btnNewButton_3 = new JButton("Open document");
		Image img3 = new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon(img3));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			try{
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File file = chooser.getSelectedFile();
				path = file.getAbsolutePath();
				fr = new FileReader(path);
				br = new BufferedReader(fr);
				textArea.read(br, null);
				textArea.requestFocus();
				}catch(Exception err){
					System.out.println(err);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_3.setBounds(62, 96, 269, 60);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Insert document");
		Image img2 = new ImageIcon(this.getClass().getResource("/add2.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img2));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try{
					
					textArea.setText(null);
					
					File file1 = new File(""+usern+".txt");
					if(file1.exists()==false){
						file1.createNewFile();
						System.out.println("File created");
						fw = new FileWriter(file1,true);
						bw = new BufferedWriter(fw);
						fr = new FileReader(path);
						br = new BufferedReader(fr);
						String line = br.readLine();
						bw.write("External report\r\n");
						while(line !=null){
							bw.write(line);
							bw.newLine();
							line = br.readLine();
						}
						bw.write("\r\n");
						bw.close();
						
					}else{
						fw1 = new FileWriter(file1,true);
						bw1 = new BufferedWriter(fw1);
						fr = new FileReader(path);
						br = new BufferedReader(fr);
						String line = br.readLine();
						bw1.write("\r\n\r\nExternal report\r\n");
						while(line !=null){
							bw1.write(line);
							bw1.newLine();
							line = br.readLine();
						}
						bw1.write("\r\n");
						
						bw1.close();
						
					} 	br.close();
					
					JOptionPane.showMessageDialog(null, "Document added to medical records!");
						
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Document not found!");
					System.out.println(e);
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_2.setBounds(407, 96, 269, 60);
		contentPane.add(btnNewButton_2);
		
		JLabel lblYouCanOpen = new JLabel("you can open a medical document and insert it. ");
		lblYouCanOpen.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblYouCanOpen.setBounds(62, 40, 614, 41);
		contentPane.add(lblYouCanOpen);
		
		
		
		
		
		
	}
}
