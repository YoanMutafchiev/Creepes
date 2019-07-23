import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JRadioButton;

public class Basket extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton backButton;
	private JTextField nameProductField;
	private JTextField nameField;
	private JTextField phoneField;
	private JTextField addressField;
	private JTextField priceField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Basket frame = new Basket();
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
	public Basket() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				updateRecords();
				calculate();
			}

			
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 973, 418);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();	
				
				nameProductField.setText(table.getValueAt(index, 0).toString());
			
				
			}
		});
		
		
		
		scrollPane.setViewportView(table);
		
		JButton aktualizirane = new JButton("\u0410\u043A\u0442\u0443\u0430\u043B\u0438\u0437\u0438\u0440\u0430\u0439");
		aktualizirane.setVisible(false);
		aktualizirane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String as = Project.getText();
					nameProductField.setText("");
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
					String sql = "Select * from orders where userName = '"+as+"'AND type = IN BASKET";
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs  = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					//drinkField.setText("");
					//countField.setText("");
				}catch (Exception e1) {
					System.out.println(e1);
				
			
				}
			}
		});
		
		aktualizirane.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		aktualizirane.setBounds(300, 438, 166, 23);
		contentPane.add(aktualizirane);
		
		backButton = new JButton("\u041D\u0430\u0437\u0430\u0434");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu frame = new MainMenu();
				frame.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(1200, 420, 96, 30);
		contentPane.add(backButton);
		
		JButton deleteOrder = new JButton("\u0418\u0437\u0442\u0440\u0438\u0439 \u043F\u043E\u0440\u044A\u0447\u043A\u0430");
		deleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String as = Project.getText();
					String text = nameProductField.getText();
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
				
				String sql = "DELETE FROM orders WHERE id = '"+text+"'";
				PreparedStatement pst = con1.prepareStatement(sql);
				pst.execute();
				JOptionPane.showMessageDialog(nameProductField, "Поръчката е изтрита успешно! ");
				} catch (Exception e1) {
					System.out.println(e1);
				}
				updateRecords();
				calculate();
			}
		});
		deleteOrder.setBounds(1186, 55, 137, 36);
		contentPane.add(deleteOrder);
		
		JLabel nameProduct = new JLabel("\u041F\u0440\u043E\u0434\u0443\u043A\u0442:");
		nameProduct.setBounds(1114, 27, 76, 14);
		contentPane.add(nameProduct);
		
		nameProductField = new JTextField();
		nameProductField.setEditable(false);
		nameProductField.setBounds(1200, 24, 81, 20);
		contentPane.add(nameProductField);
		nameProductField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u0418\u043C\u0435:");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel.setBounds(993, 140, 54, 14);
		contentPane.add(lblNewLabel);
		
		nameField = new JTextField();
		nameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE    )) {
					e.consume();
				}
			}
		});
		nameField.setBounds(1079, 136, 295, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel label = new JLabel("\u0422\u0435\u043B\u0435\u0444\u043E\u043D:");
		label.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label.setBounds(993, 172, 76, 14);
		contentPane.add(label);
		
		phoneField = new JTextField();
		phoneField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE    )) {
					e.consume();
				}
			}
		});
		phoneField.setColumns(10);
		phoneField.setBounds(1079, 168, 244, 20);
		contentPane.add(phoneField);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(1079, 207, 295, 20);
		contentPane.add(addressField);
		
		JLabel label_1 = new JLabel("\u0410\u0434\u0440\u0435\u0441:");
		label_1.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label_1.setBounds(993, 211, 76, 14);
		contentPane.add(label_1);
		
		JLabel total = new JLabel("\u0426\u0435\u043D\u0430:");
		total.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		total.setBounds(993, 250, 48, 14);
		contentPane.add(total);
		
		priceField = new JTextField();
		priceField.setEditable(false);
		priceField.setColumns(10);
		priceField.setBounds(1044, 246, 81, 20);
		contentPane.add(priceField);
		
		JButton doAnOrderButton = new JButton("\u041D\u0430\u043F\u0440\u0430\u0432\u0438 \u043F\u043E\u0440\u044A\u0447\u043A\u0430");
		doAnOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String as = Project.getText();
				String name = nameField.getText();
				String phone = phoneField.getText();
				String address = addressField.getText();
				
				
				try {
					if(name.isEmpty() ||  phone.isEmpty() || address.isEmpty() || phone.length()!= 10)  {
						JOptionPane.showMessageDialog(doAnOrderButton, "Моля попълнете всички полета!Телефонният номер трябва да е точно 10 символа!");
					} else { 
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
				String sql1 = "UPDATE orders SET name = '"+name+"', "
						+ "phone = '"+phone+"', address = '"+address+"', type = 'NOT ACCEPTED' WHERE userName = '"+as+"' and type = 'IN BASKET'";
				PreparedStatement pst = con1.prepareStatement(sql1);
				pst.execute();
			 updateRecords();
			 JOptionPane.showMessageDialog(doAnOrderButton, "Поръчката е направена успешно!");
					}
				}catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		doAnOrderButton.setBounds(1158, 241, 148, 30);
		contentPane.add(doAnOrderButton);
		
		JLabel pizzaPicture = new JLabel("");
		Image images = new ImageIcon(this.getClass().getResource("pizzaFrame.jpg")).getImage();
		pizzaPicture.setIcon(new ImageIcon(images));
		pizzaPicture.setBounds(0, -11, 1416, 472);
		contentPane.add(pizzaPicture);
	}
	public void updateRecords() {
		try {
			String as = Project.getText();
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
			String sql = "Select * from orders where userName = '"+as+"'AND type = 'IN BASKET'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs  = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (Exception e1) {
			System.out.println(e1);
		
	
		}
		
	}
	public void calculate() {
		try {
			int rows = table.getRowCount();
			double sum = 0;
			int quantity = 0;
			double total1 = 0;
		
			double total2 = 0;
			double totalSum = 0;
			int totalQuantity = 0;
			for(int i = 0 ; i<rows;i++) {
				totalSum = sum + Double.parseDouble(table.getValueAt(i, 7).toString());
				totalQuantity = quantity + Integer.parseInt(table.getValueAt(i, 6).toString());
				total1 = totalSum * totalQuantity;		
				total2 = total1 + total2;
				total2 = Math.round(total2 * 100.0)/100.0;
			}
			
			String total = Double.toString(total2);
			
			priceField.setText(total);
		}catch (Exception e1) {
			System.out.println(e1);
		} 
	}
}
