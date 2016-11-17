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
import java.awt.Color;
import java.awt.SystemColor;


public class Frame15 extends JFrame {

	private JPanel contentPane;
	static int userType; // 1 stands for new , 0 stands for existing.
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame15 frame = new Frame15();
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
	public Frame15() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAreYouAn = new JLabel("Are you an existing user ?");
		Image img = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		lblAreYouAn.setIcon(new ImageIcon(img));
		lblAreYouAn.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblAreYouAn.setBounds(170, 48, 398, 79);
		contentPane.add(lblAreYouAn);
		
		JButton btnNewButton = new JButton("Yes");
		btnNewButton.setBackground(SystemColor.inactiveCaptionBorder);
		Image img1 = new ImageIcon(this.getClass().getResource("/thumbsup.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img1));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				userType=0;
				Frame11 f11 = new Frame11(userType);
				f11.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(89, 189, 209, 60);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("No\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				userType=1;
				Frame16 f16 = new Frame16(userType);
				f16.setVisible(true);
			}
		});
		Image img2 = new ImageIcon(this.getClass().getResource("/thumbsdown.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(img2));
		btnNewButton_1.setBackground(SystemColor.inactiveCaptionBorder);
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_1.setBounds(374, 190, 209, 60);
		contentPane.add(btnNewButton_1);
	}
}
