import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class orderMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderMenu frame = new orderMenu();
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
	public orderMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 300, 700, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		Image img = new ImageIcon(this.getClass().getResource("/Screenshot_5.jpg")).getImage();
		
		JLabel label_5 = new JLabel("\u0421\u041E\u0421");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sauceFrame frame = new sauceFrame();
				frame.setVisible(true);
				dispose();
				
			}
		});
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		label_5.setBounds(196, 76, 89, 34);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u041D\u0410\u041F\u0418\u0422\u041A\u0418");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				drinksFrame frame = new drinksFrame();
				frame.setVisible(true);
				dispose();
			}
		});
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		label_6.setBounds(295, 76, 105, 34);
		contentPane.add(label_6);
		
		JLabel lblClient = new JLabel("\u041F\u0418\u0426\u0418");
		lblClient.setForeground(Color.WHITE);
		contentPane.add(lblClient);
		lblClient.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		lblClient.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pizzaFrame frame = new pizzaFrame();
				frame.setVisible(true);
				dispose();
				
			}
		});
		lblClient.setBounds(76, 76, 89, 34);
		
		JButton button = new JButton("\u041D\u0430\u0437\u0430\u0434");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu frame = new MainMenu();
				frame.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.setBounds(300, 121, 89, 29);
		contentPane.add(button);
		
		JLabel orderMenuPicture = new JLabel("");
		orderMenuPicture.setBounds(0, 0, 684, 161);
		Image image = new ImageIcon(this.getClass().getResource("/orderMenuPicture.jpg")).getImage();
		orderMenuPicture.setIcon(new ImageIcon(image));
		contentPane.add(orderMenuPicture);
	}
}
