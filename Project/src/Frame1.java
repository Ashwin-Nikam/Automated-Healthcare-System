import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class Frame1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 751, 481);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAutomatedHealthcareSystem = new JLabel("Automated Healthcare System");
		lblAutomatedHealthcareSystem.setForeground(Color.BLACK);
		lblAutomatedHealthcareSystem.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblAutomatedHealthcareSystem.setBounds(186, 11, 375, 49);
		frame.getContentPane().add(lblAutomatedHealthcareSystem);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the only place where medical treatment doesn't require a doctor !");
		lblWelcomeToThe.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblWelcomeToThe.setBounds(67, 302, 640, 41);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JButton btnNewButton = new JButton("Enter App");
		Image img2 = new ImageIcon(this.getClass().getResource("/enter1.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Frame14 f14 = new Frame14();
				f14.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(219, 354, 288, 59);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/diagnosis3.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(229, 71, 256, 244);
		frame.getContentPane().add(lblNewLabel);
		
	}
}
