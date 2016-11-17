import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Frame14 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame14 frame = new Frame14();
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
	public Frame14() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAutomatedHealthcareSystem = new JLabel("Automated Healthcare System ");
		lblAutomatedHealthcareSystem.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblAutomatedHealthcareSystem.setBounds(179, 11, 417, 43);
		contentPane.add(lblAutomatedHealthcareSystem);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		Image img = new ImageIcon(this.getClass().getResource("/admin.png")).getImage();
		btnAdminLogin.setIcon(new ImageIcon(img));
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Frame2 f2 = new Frame2();
				f2.setVisible(true);
			}
		});
		btnAdminLogin.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnAdminLogin.setBounds(39, 226, 292, 63);
		contentPane.add(btnAdminLogin);
		
		JButton btnUserLogin = new JButton("User Login");
		Image img1 = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		btnUserLogin.setIcon(new ImageIcon(img1));
		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Frame15 f15 = new Frame15();
				f15.setVisible(true);
			}
		});
		btnUserLogin.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnUserLogin.setBounds(397, 226, 292, 63);
		contentPane.add(btnUserLogin);
		
		JButton btnExit = new JButton("Exit");
		Image img3 = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		btnExit.setIcon(new ImageIcon(img3));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnExit.setBounds(214, 332, 292, 63);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/welcome.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(img2));
		lblNewLabel.setBounds(300, 65, 143, 134);
		contentPane.add(lblNewLabel);
		
	}
}
