import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.JRadioButton;

public class alreadyOrder extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	private JLabel nameLabel;
	private JLabel phoneLabel;
	private JTextField phoneField;
	private JLabel orderLabel;
	private JTextField orderField;
	private JLabel addressLabel;
	private JTextField addressField;
	private JButton orderButton;
	private JTextField nameField;
	private JLabel quantityLabel;
	private JLabel price;
	private JLabel quantity;
	private JLabel total;
	private JLabel label;
	private JLabel label_1;
	private JTextField countField;
	private JTextField edPriceField;
	private JTextField totalSumField;
	private JButton btnNewButton_1;
	private JLabel pizzaPicture;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					alreadyOrder frame = new alreadyOrder();
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
	public alreadyOrder() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				updateRecords();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 56, 814, 581);
		contentPane.add(scrollPane);
	  
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				orderField.setText(table.getValueAt(index, 5).toString());
				edPriceField.setText(table.getValueAt(index, 7).toString());
				countField.setText(table.getValueAt(index, 6).toString());
				//orderField.setText(table.getValueAt(index, 6).toString());
				double priceTotal = Double.parseDouble(edPriceField.getText());
				double quantityTotal = Double.parseDouble(countField.getText());
				double totale = priceTotal * quantityTotal;
				
				//String edPriceString = Double.toString(quantityTotal);
				String finalTotale = Double.toString(totale);
				totalSumField.setText(finalTotale);
			}
		});
		
		scrollPane.setViewportView(table);
		
		btnNewButton = new JButton("\u041D\u0430\u0437\u0430\u0434");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu frame = new MainMenu();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(1264, 718, 95, 32);
		contentPane.add(btnNewButton);
		
		nameLabel = new JLabel("\u0418\u043C\u0435:");
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		nameLabel.setBounds(868, 145, 48, 14);
		contentPane.add(nameLabel);
		
		phoneLabel = new JLabel("\u0422\u0435\u043B\u0435\u0444\u043E\u043D:");
		phoneLabel.setForeground(Color.WHITE);
		phoneLabel.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		phoneLabel.setBounds(868, 170, 80, 20);
		contentPane.add(phoneLabel);
		
		phoneField = new JTextField();
		phoneField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if((!Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE    )) {
					e.consume();
				}
			}
		});
		phoneField.setColumns(10);
		phoneField.setBounds(992, 172, 298, 20);
		contentPane.add(phoneField);
		
		orderLabel = new JLabel("\u041F\u043E\u0440\u044A\u0447\u043A\u0430:");
		orderLabel.setForeground(Color.WHITE);
		orderLabel.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		orderLabel.setBounds(868, 83, 80, 14);
		contentPane.add(orderLabel);
		
		orderField = new JTextField();
		orderField.setEditable(false);
		orderField.setColumns(10);
		orderField.setBounds(992, 79, 298, 20);
		contentPane.add(orderField);
		
		addressLabel = new JLabel("\u0410\u0434\u0440\u0435\u0441:");
		addressLabel.setForeground(Color.WHITE);
		addressLabel.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		addressLabel.setBounds(868, 201, 80, 14);
		contentPane.add(addressLabel);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(992, 203, 298, 20);
		contentPane.add(addressField);
		
		orderButton = new JButton("\u041F\u043E\u0440\u044A\u0447\u0430\u0439 \u043E\u0442\u043D\u043E\u0432\u043E");
		orderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String as = Project.getText();
				String name = nameField.getText();
				String product = orderField.getText();
				String phone = phoneField.getText();
				String address = addressField.getText();
				String price = edPriceField.getText();
				String quantity = countField.getText();
				
				Date thisDate = new Date();
				SimpleDateFormat dateForm = new SimpleDateFormat("dd/M/Y HH:mm");
				String date = dateForm.format(thisDate);
				try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
				String sql1 = "INSERT INTO orders (userName,name,phone,address,productName,quantity,price,date,type) VALUES(?,?,?,?,?,?,?,?,?)";
				
				PreparedStatement pst = con.prepareStatement(sql1);
				pst.setString(1,as);
				pst.setString(2,name);
				pst.setString(3,phone);
				pst.setString(4,address);
				pst.setString(5,product);
				pst.setString(6,quantity);
				pst.setString(7,price);
				pst.setString(8,date);
				pst.setString(9,"NOT ACCEPTED");
				pst.execute();
				pst.close();
				updateRecords();
				
				JOptionPane.showMessageDialog(countField, "Поръчката е направена успешно! ");
				nameField.setText("");
				phoneField.setText("");
				addressField.setText("");
				}catch (Exception e1) {
				System.out.println(e1);
				}
			}
		});
		orderButton.setBounds(1049, 305, 197, 23);
		contentPane.add(orderButton);
		
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
		nameField.setColumns(10);
		nameField.setBounds(992, 141, 298, 20);
		contentPane.add(nameField);
		
		quantityLabel = new JLabel("\u0411\u0440\u043E\u0439");
		quantityLabel.setForeground(Color.WHITE);
		quantityLabel.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		quantityLabel.setBounds(868, 110, 59, 17);
		contentPane.add(quantityLabel);
		
		price = new JLabel("");
		price.setBounds(992, 381, 48, 14);
		contentPane.add(price);
		
		quantity = new JLabel("");
		quantity.setBounds(868, 297, 48, 14);
		contentPane.add(quantity);
		
		total = new JLabel("");
		total.setBounds(1085, 381, 48, 14);
		contentPane.add(total);
		
		label = new JLabel("\u0421\u0443\u043C\u0430:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label.setBounds(1187, 113, 59, 17);
		contentPane.add(label);
		
		label_1 = new JLabel("\u0415\u0434.\u0446\u0435\u043D\u0430");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label_1.setBounds(1061, 113, 68, 17);
		contentPane.add(label_1);
		
		countField = new JTextField();
		countField.setEditable(false);
		countField.setBounds(992, 110, 59, 20);
		contentPane.add(countField);
		countField.setColumns(10);
		
		edPriceField = new JTextField();
		edPriceField.setEditable(false);
		edPriceField.setColumns(10);
		edPriceField.setBounds(1125, 110, 59, 20);
		contentPane.add(edPriceField);
		
		totalSumField = new JTextField();
		totalSumField.setEditable(false);
		totalSumField.setColumns(10);
		totalSumField.setBounds(1231, 110, 59, 20);
		contentPane.add(totalSumField);
		
		btnNewButton_1 = new JButton("\u0418\u0437\u0442\u0440\u0438\u0439 \u0438\u0441\u0442\u043E\u0440\u0438\u044F ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String as = Project.getText();
				try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
				String sql = "DELETE FROM orders WHERE userName = '"+as+"'";
				PreparedStatement pst = con.prepareStatement(sql);
				JOptionPane.showMessageDialog(phoneField, "Историята на поръчки е изтрита успешно! ");
				pst.execute();
				updateRecords();
				}catch (Exception e1) {
					System.out.println(e1);
					
				}
			}
		});
		btnNewButton_1.setBounds(845, 605, 158, 23);
		contentPane.add(btnNewButton_1);
		
		pizzaPicture = new JLabel("");
		Image images = new ImageIcon(this.getClass().getResource("pizza800.jpg")).getImage();
		pizzaPicture.setIcon(new ImageIcon(images));
		pizzaPicture.setBounds(0, 0, 1384, 761);
		contentPane.add(pizzaPicture);
		table.setDefaultEditor(Object.class, null);
	}
	public void updateRecords() {
		try {
			String as = Project.getText();
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
			String sql = "Select * from orders where userName = '"+as+"'AND type != 'IN BASKET'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs  = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (Exception e1) {
			System.out.println(e1);
		
	
		}
		
	}
}
