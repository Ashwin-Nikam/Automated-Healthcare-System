import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Frame3 extends JFrame {

	private JPanel contentPane;
	public String usrname;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame3 frame = new Frame3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	
	/**
	 * Create the frame.
	 */
	public Frame3(String username,int uT) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Automated Healthcare System");
		lblWelcomeToThe.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblWelcomeToThe.setBounds(178, 24, 362, 40);
		contentPane.add(lblWelcomeToThe);
		
		JButton btnPerformMedicalDiagnosis = new JButton("Perform Medical Diagnosis");
		Image img3 = new ImageIcon(this.getClass().getResource("/diagnosis.png")).getImage();
		btnPerformMedicalDiagnosis.setIcon(new ImageIcon(img3));
		btnPerformMedicalDiagnosis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Frame4 f4;
				try {
					f4 = new Frame4(username,uT);
					f4.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnPerformMedicalDiagnosis.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnPerformMedicalDiagnosis.setBounds(10, 119, 362, 84);
		contentPane.add(btnPerformMedicalDiagnosis);
		
		JButton btnViewPreviousDiagnosis = new JButton("View previous diagnosis");
		Image img2 = new ImageIcon(this.getClass().getResource("/view1.png")).getImage();
		btnViewPreviousDiagnosis.setIcon(new ImageIcon(img2));
		btnViewPreviousDiagnosis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Frame19 f19 = new Frame19(username,uT);
				f19.setVisible(true);
			}
		});
		btnViewPreviousDiagnosis.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnViewPreviousDiagnosis.setBounds(382, 120, 339, 82);
		contentPane.add(btnViewPreviousDiagnosis);
		
		JButton btnNewButton = new JButton("Logout");
		Image img = new ImageIcon(this.getClass().getResource("/logout.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Frame14 f14 = new Frame14();
				f14.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(189, 242, 339, 83);
		contentPane.add(btnNewButton);
		Image img1 = new ImageIcon(this.getClass().getResource("/admin.png")).getImage();
	}

	

	
}
