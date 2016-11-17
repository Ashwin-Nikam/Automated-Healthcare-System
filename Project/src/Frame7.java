import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;


public class Frame7 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame7 frame = new Frame7();
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
	public Frame7() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Edit Treatment");
		Image img3 = new ImageIcon(this.getClass().getResource("/update.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img3));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame9 f9 = new Frame9();
				f9.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton.setBounds(38, 178, 289, 57);
		contentPane.add(btnNewButton);
		Image img2 = new ImageIcon(this.getClass().getResource("/add.png")).getImage();
		
		JButton btnNewButton_2 = new JButton("Edit symptom");
		Image img4 = new ImageIcon(this.getClass().getResource("/edit1.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(img4));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame5 f5 = new Frame5();
				f5.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_2.setBounds(389, 178, 289, 57);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		Image img = new ImageIcon(this.getClass().getResource("/back.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon(img));
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Frame6 f6 = new Frame6();
				f6.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(218, 300, 289, 57);
		contentPane.add(btnNewButton_3);
		
		JLabel lblEditRecords = new JLabel("Edit Records");
		Image img1 = new ImageIcon(this.getClass().getResource("/edit.png")).getImage();
		lblEditRecords.setIcon(new ImageIcon(img1));
		lblEditRecords.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblEditRecords.setBounds(246, 46, 230, 62);
		contentPane.add(lblEditRecords);
	}
}
