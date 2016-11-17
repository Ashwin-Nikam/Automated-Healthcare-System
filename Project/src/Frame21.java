import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.JTextPane;

public class Frame21 extends JFrame {

	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame2 frame = new frame2();
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
	public Frame21(String x,String username) {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 742, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		String maxsympstr4frame = x;
		
		JLabel lblEnterYourSymptomsconditions = new JLabel("Are you experiencing : ");
		lblEnterYourSymptomsconditions.setHorizontalAlignment(SwingConstants.LEFT);
		Image img2 = new ImageIcon(this.getClass().getResource("/doctor1.png")).getImage();
		lblEnterYourSymptomsconditions.setIcon(new ImageIcon(img2));
		lblEnterYourSymptomsconditions.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblEnterYourSymptomsconditions.setBounds(12, 44, 655, 64);
		contentPane.add(lblEnterYourSymptomsconditions);
		
		JButton noButton = new JButton("No");
		Image img1 = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
		noButton.setIcon(new ImageIcon(img1));
		noButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				Final sc= new Final();
				try {
					sc.forNoAss(maxsympstr4frame,username);
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
		Image img = new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		yesButton.setIcon(new ImageIcon(img));
		yesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Final sc=new Final();
				try {
					sc.finalForYes(maxsympstr4frame,username);
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				dispose();
			}
				
				
			
		});

		yesButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		yesButton.setBounds(91, 218, 244, 70);
		contentPane.add(yesButton);
		
		JLabel label = new JLabel(maxsympstr4frame);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("Times New Roman", Font.BOLD, 25));
		label.setBounds(81, 85, 574, 64);
		contentPane.add(label);
	}
}
