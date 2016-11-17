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

public class Frame26 extends JFrame {

	
	
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
	public Frame26(String usern) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblEnterYourSymptomsconditions = new JLabel("Based on the responses regaurding your past symptoms,");
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
		
		JLabel lblTheSystemWill = new JLabel("The system will now ask you some varied symptoms.");
		lblTheSystemWill.setHorizontalAlignment(SwingConstants.LEFT);
		lblTheSystemWill.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblTheSystemWill.setBounds(79, 194, 655, 64);
		contentPane.add(lblTheSystemWill);
		
		JLabel lblBasedOnThe = new JLabel("Please respond in the best possible way .");
		lblBasedOnThe.setHorizontalAlignment(SwingConstants.LEFT);
		lblBasedOnThe.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblBasedOnThe.setBounds(79, 227, 655, 64);
		contentPane.add(lblBasedOnThe);
		
		
		JButton btnNewButton_1 = new JButton("GO");
		
		
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
		btnNewButton_1.setBounds(231, 341, 211, 54);
		contentPane.add(btnNewButton_1);
		
	}
}


