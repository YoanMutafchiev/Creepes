import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(750, 0, 500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton menuButton = new JButton("\u041C\u0435\u043D\u044E");
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderMenu frame = new orderMenu();
				frame.setVisible(true);
				dispose();
			}
		});
		menuButton.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 30));
		menuButton.setBounds(111, 164, 253, 114);
		contentPane.add(menuButton);
		
		JButton orderButton = new JButton("\u041F\u043E\u0440\u044A\u0447\u043A\u0438");
		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alreadyOrder frame = new alreadyOrder();
				frame.setVisible(true);
				dispose();
				
			}
		});
		orderButton.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 30));
		orderButton.setBounds(111, 321, 253, 114);
		contentPane.add(orderButton);
		
		JButton profileButton = new JButton("\u041A\u043E\u0448\u043D\u0438\u0446\u0430");
		profileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Basket frame = new Basket();
				frame.setVisible(true);
				dispose();
			}
		});
		profileButton.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 30));
		profileButton.setBounds(114, 495, 250, 114);
		contentPane.add(profileButton);
		
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
		
		JLabel mainAdminPicture = new JLabel("");
		mainAdminPicture.setBounds(0, 0, 484, 861);
		contentPane.add(mainAdminPicture);
		Image img = new ImageIcon(this.getClass().getResource("/mainAdminMenu.jpg")).getImage();
		mainAdminPicture.setIcon(new ImageIcon(img));
	}
}
