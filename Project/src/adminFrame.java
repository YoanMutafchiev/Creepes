import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class adminFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminFrame frame = new adminFrame();
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
	public adminFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 0, 500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u0418\u0437\u0445\u043E\u0434");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(1476, 917, 98, 33);
		contentPane.add(btnNewButton);
		
		JButton workersButton = new JButton("\u0410\u043A\u0430\u0443\u043D\u0442\u0438");
		workersButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminRegister frame = new adminRegister();
				frame.setVisible(true);
				dispose();
				
			}
		});
		workersButton.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 30));
		workersButton.setBounds(111, 164, 253, 114);
		contentPane.add(workersButton);
		
		JButton acceptOrderButton = new JButton("\u041F\u043E\u0440\u044A\u0447\u043A\u0438");
		acceptOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuOrder frame = new MenuOrder();
				frame.setVisible(true);
				dispose();
			}
		});
		acceptOrderButton.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 30));
		acceptOrderButton.setBounds(111, 321, 253, 114);
		contentPane.add(acceptOrderButton);
		
		JButton pricesButton = new JButton("\u0426\u0435\u043D\u0438");
		pricesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prices frame = new prices();
				frame.setVisible(true);
				dispose();
			}
		});
		pricesButton.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 30));
		pricesButton.setBounds(114, 495, 250, 114);
		contentPane.add(pricesButton);
		
		JButton exitButton = new JButton("\u0418\u0437\u043B\u0435\u0437");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Project window = new Project();
				window.frame.setVisible(true);
				adminFrame frame = new adminFrame();
				frame.setVisible(false);
				dispose();
			}
		});
		exitButton.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 30));
		exitButton.setBounds(114, 665, 249, 107);
		contentPane.add(exitButton);
		
		JLabel adminFramePicture = new JLabel("");
		adminFramePicture.setBounds(0, 0, 484, 861);
		contentPane.add(adminFramePicture);
		Image img = new ImageIcon(this.getClass().getResource("/mainAdminMenu.jpg")).getImage();
		adminFramePicture.setIcon(new ImageIcon(img));
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Project window = new Project();
				window.frame.setVisible(true);
				adminFrame frame = new adminFrame();
				frame.setVisible(false);
				dispose();
			}
			
		});
		
		
	}
}
	
