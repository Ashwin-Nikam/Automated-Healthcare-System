import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Frame24 extends JFrame {

	
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frameForStartingPrevSymp frame = new frameForStartingPrevSymp();
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
	public Frame24(String usern) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblEnterYourSymptomsconditions = new JLabel("Are you experiencing any symptoms that you had in ");
		Image img2 = new ImageIcon(this.getClass().getResource("/doctor1.png")).getImage();
		lblEnterYourSymptomsconditions.setIcon(new ImageIcon(img2));
		lblEnterYourSymptomsconditions.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblEnterYourSymptomsconditions.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterYourSymptomsconditions.setBounds(12, 44, 655, 64);
		contentPane.add(lblEnterYourSymptomsconditions);
		
		JButton noButton = new JButton("No");
		Image img1 = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		noButton.setIcon(new ImageIcon(img1));
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Final sc=new Final();
				try {
					sc.findMAxSympInitial(usern);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				dispose();
			}
				
			
		});
	
		noButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		noButton.setBounds(386, 218, 244, 70);
		contentPane.add(noButton);
		
		JButton yesButton = new JButton("Yes");
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Final sc=new Final();
				try {
					sc.forPastSymptoms(usern);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				dispose();
				
			}
		});
		
		Image img = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		yesButton.setIcon(new ImageIcon(img));
		

		yesButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		yesButton.setBounds(91, 218, 244, 70);
		contentPane.add(yesButton);
		
		JLabel lblNewLabel = new JLabel("the past ?");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(79, 95, 357, 31);
		contentPane.add(lblNewLabel);
	}
}


