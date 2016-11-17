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

public class Frame27 extends JFrame {

	
	
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
	public Frame27(String usern) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblEnterYourSymptomsconditions = new JLabel("Based on the set of symptoms that you have confirmed,");
		Image img2 = new ImageIcon(this.getClass().getResource("/doctor1.png")).getImage();
		lblEnterYourSymptomsconditions.setIcon(new ImageIcon(img2));
		lblEnterYourSymptomsconditions.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblEnterYourSymptomsconditions.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterYourSymptomsconditions.setBounds(12, 44, 655, 64);
		contentPane.add(lblEnterYourSymptomsconditions);
		Image img1 = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		
		Image img = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		
		JLabel lblNewLabel = new JLabel("the system cannot detect your condition.");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(79, 95, 559, 31);
		contentPane.add(lblNewLabel);
		
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
		btnNewButton_1.setBounds(79, 295, 211, 54);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Logout");
		Image img11 = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame14 f14 = new Frame14();
				f14.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(413, 295, 211, 54);
		contentPane.add(btnNewButton);
		
	}
}


