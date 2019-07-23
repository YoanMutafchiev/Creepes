import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class prices extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField newPizzaField;
	private JTextField ingredField;
	private JTextField newSauceField;
	private JTextField priceSauceField;
	private JTextField newDrinkField;
	private JTextField priceDrinkField;
	private JTextField pizzaEditField;
	private JTextField sauceEditField;
	private JTextField drinkEditField;
	private JTextField newDrinkPriceField;
	private JTextField newSaucePriceField;
	private JTextField newPizzaPriceField;
	private JTextField pricePizzaField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prices frame = new prices();
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
	public prices() {
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
		
		JButton backButton = new JButton("\u041D\u0430\u0437\u0430\u0434");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminFrame frame = new adminFrame();
				frame.setVisible(true);
				dispose();
			}
		});
		backButton.setBounds(1265, 711, 89, 23);
		contentPane.add(backButton);
		
		JLabel lblNewLabel = new JLabel("\u041F\u0438\u0446\u0438:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 48, 14);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u0421\u043E\u0441\u043E\u0432\u0435:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label.setBounds(10, 256, 65, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u041D\u0430\u043F\u0438\u0442\u043A\u0438:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label_1.setBounds(10, 525, 89, 14);
		contentPane.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 24, 694, 221);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();	
				pizzaEditField.setText(table.getValueAt(index, 1).toString());
			}
		});
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 281, 694, 221);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setDefaultEditor(Object.class, null);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_1.getSelectedRow();	
				sauceEditField.setText(table_1.getValueAt(index, 1).toString());
			}
		});
		table_1.setDefaultEditor(Object.class, null);
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 540, 694, 221);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setDefaultEditor(Object.class, null);
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table_2.getSelectedRow();	
				drinkEditField.setText(table_2.getValueAt(index, 1).toString());
			}
		});
		table_2.setDefaultEditor(Object.class, null);;
		scrollPane_2.setViewportView(table_2);
		
		JLabel label_2 = new JLabel("\u041F\u0438\u0446\u0430:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label_2.setBounds(714, 26, 48, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u0421\u043E\u0441:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label_3.setBounds(714, 283, 48, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u041D\u0430\u043F\u0438\u0442\u043A\u0430:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label_4.setBounds(725, 541, 81, 14);
		contentPane.add(label_4);
		
		newPizzaField = new JTextField();
		newPizzaField.setBounds(816, 22, 275, 20);
		contentPane.add(newPizzaField);
		newPizzaField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u0421\u044A\u0441\u0442\u0430\u0432\u043A\u0438:");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label_5.setBounds(714, 57, 92, 14);
		contentPane.add(label_5);
		
		ingredField = new JTextField();
		ingredField.setColumns(10);
		ingredField.setBounds(816, 53, 275, 20);
		contentPane.add(ingredField);
		
		JLabel label_6 = new JLabel("\u0426\u0435\u043D\u0430:");
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label_6.setBounds(714, 307, 92, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("\u0426\u0435\u043D\u0430:");
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label_7.setBounds(725, 576, 92, 14);
		contentPane.add(label_7);
		
		newSauceField = new JTextField();
		newSauceField.setColumns(10);
		newSauceField.setBounds(816, 279, 275, 20);
		contentPane.add(newSauceField);
		
		priceSauceField = new JTextField();
		priceSauceField.setColumns(10);
		priceSauceField.setBounds(816, 302, 275, 20);
		contentPane.add(priceSauceField);
		
		newDrinkField = new JTextField();
		newDrinkField.setColumns(10);
		newDrinkField.setBounds(816, 538, 275, 20);
		contentPane.add(newDrinkField);
		
		priceDrinkField = new JTextField();
		priceDrinkField.setColumns(10);
		priceDrinkField.setBounds(816, 572, 275, 20);
		contentPane.add(priceDrinkField);
		
		JLabel label_8 = new JLabel("\u041F\u0438\u0446\u0430 \u0437\u0430 \u043F\u0440\u043E\u043C\u044F\u043D\u0430:");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label_8.setBounds(714, 152, 177, 14);
		contentPane.add(label_8);
		
		pizzaEditField = new JTextField();
		pizzaEditField.setEditable(false);
		pizzaEditField.setColumns(10);
		pizzaEditField.setBounds(914, 148, 275, 20);
		contentPane.add(pizzaEditField);
		
		JLabel label_9 = new JLabel("\u0421\u043E\u0441 \u0437\u0430 \u043F\u0440\u043E\u043C\u044F\u043D\u0430:");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label_9.setBounds(714, 358, 177, 14);
		contentPane.add(label_9);
		
		sauceEditField = new JTextField();
		sauceEditField.setEditable(false);
		sauceEditField.setColumns(10);
		sauceEditField.setBounds(914, 354, 275, 20);
		contentPane.add(sauceEditField);
		
		JLabel label_10 = new JLabel("\u041D\u0430\u043F\u0438\u0442\u043A\u0430 \u0437\u0430 \u043F\u0440\u043E\u043C\u044F\u043D\u0430:");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label_10.setBounds(714, 621, 205, 14);
		contentPane.add(label_10);
		
		drinkEditField = new JTextField();
		drinkEditField.setEditable(false);
		drinkEditField.setColumns(10);
		drinkEditField.setBounds(914, 617, 275, 20);
		contentPane.add(drinkEditField);
		
		JLabel label_11 = new JLabel("\u041D\u043E\u0432\u0430 \u0446\u0435\u043D\u0430:");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label_11.setBounds(714, 660, 205, 14);
		contentPane.add(label_11);
		
		newDrinkPriceField = new JTextField();
		newDrinkPriceField.setColumns(10);
		newDrinkPriceField.setBounds(816, 656, 275, 20);
		contentPane.add(newDrinkPriceField);
		
		JLabel test = new JLabel("\u041D\u043E\u0432\u0430 \u0446\u0435\u043D\u0430:");
		test.setForeground(Color.WHITE);
		test.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		test.setBounds(714, 383, 205, 14);
		contentPane.add(test);
		
		newSaucePriceField = new JTextField();
		newSaucePriceField.setColumns(10);
		newSaucePriceField.setBounds(816, 383, 275, 20);
		contentPane.add(newSaucePriceField);
		
		JLabel label_13 = new JLabel("\u041D\u043E\u0432\u0430 \u0446\u0435\u043D\u0430:");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label_13.setBounds(714, 177, 205, 14);
		contentPane.add(label_13);
		
		newPizzaPriceField = new JTextField();
		newPizzaPriceField.setColumns(10);
		newPizzaPriceField.setBounds(816, 173, 275, 20);
		contentPane.add(newPizzaPriceField);
		
		JButton addDrinkButton = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438");
		addDrinkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPizza = newDrinkField.getText();
				String price = priceDrinkField.getText();
				try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
				
				String sql1 = "INSERT INTO drinks (name,price) VALUES(?,?)";
				PreparedStatement pst = con1.prepareStatement(sql1);
				pst.setString(1,newPizza);
				pst.setString(2,price);
				pst.execute();
				JOptionPane.showMessageDialog(newPizzaField, "Новата напитка е добавена успешно! ");
				updateRecords();
				newDrinkField.setText("");
				priceDrinkField.setText("");
				}catch (Exception e1) {
				System.out.println(e1);
				}
			}
		});
		addDrinkButton.setBounds(1115, 571, 89, 23);
		contentPane.add(addDrinkButton);
		
		JButton addSauceButton = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438");
		addSauceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPizza = newSauceField.getText();
				String price = priceSauceField.getText();
				try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
				
				String sql1 = "INSERT INTO sauce (name,price) VALUES(?,?)";
				PreparedStatement pst = con1.prepareStatement(sql1);
				pst.setString(1,newPizza);
				pst.setString(2,price);
				pst.execute();
				JOptionPane.showMessageDialog(newPizzaField, "Новият сос е добавена успешно! ");
				updateRecords();
				newSauceField.setText("");
				priceSauceField.setText("");
				}catch (Exception e1) {
				System.out.println(e1);
				}
				
			}
		});
		addSauceButton.setBounds(1115, 301, 89, 23);
		contentPane.add(addSauceButton);
		
		JButton addPizzaButton = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438");
		addPizzaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newPizza = newPizzaField.getText();
				String ingred = ingredField.getText();
				String price = pricePizzaField.getText();
				try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
				
				String sql1 = "INSERT INTO pizza (name,ingredients,price) VALUES(?,?,?)";
				PreparedStatement pst = con1.prepareStatement(sql1);
				pst.setString(1,newPizza);
				pst.setString(2,ingred);
				pst.setString(3,price);
				pst.execute();
				JOptionPane.showMessageDialog(newPizzaField, "Новата пица е добавена успешно! ");
				updateRecords();
				newPizzaField.setText("");
				ingredField.setText("");
				pricePizzaField.setText("");
				}catch (Exception e1) {
				System.out.println(e1);
				}
			}
		});
		addPizzaButton.setBounds(1115, 52, 89, 23);
		contentPane.add(addPizzaButton);
		
		JButton removeDrink = new JButton("\u041F\u0440\u0435\u043C\u0430\u0445\u043D\u0438");
		removeDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String drink = drinkEditField.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
					String sql = "DELETE FROM drinks WHERE name = '"+drink+"'";
					PreparedStatement pst = con1.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(sauceEditField, "Сосът е изтрит успешно! ");
					updateRecords();
					drinkEditField.setText("");
				}catch (Exception e1) {
					System.out.println(e1);
				}
				
			}
		});
		removeDrink.setBounds(1219, 616, 120, 23);
		contentPane.add(removeDrink);
		
		JButton removeSauce = new JButton("\u041F\u0440\u0435\u043C\u0430\u0445\u043D\u0438");
		removeSauce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                  String sauce = sauceEditField.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
					String sql = "DELETE FROM sauce WHERE name = '"+sauce+"'";
					PreparedStatement pst = con1.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(sauceEditField, "Сосът е изтрит успешно! ");
					updateRecords();
					sauceEditField.setText("");
				}catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		removeSauce.setBounds(1219, 353, 120, 23);
		contentPane.add(removeSauce);
		
		JButton removePizza = new JButton("\u041F\u0440\u0435\u043C\u0430\u0445\u043D\u0438");
		removePizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pizza = pizzaEditField.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
					String sql = "DELETE FROM pizza WHERE name = '"+pizza+"'";
					PreparedStatement pst = con1.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(pizzaEditField, "Пицата е изтрита успешно! ");
					updateRecords();
					pizzaEditField.setText("");
				}catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		removePizza.setBounds(1219, 147, 105, 23);
		contentPane.add(removePizza);
		
		JButton newDrinkPriceButton = new JButton("\u041D\u043E\u0432\u0430 \u0446\u0435\u043D\u0430");
		newDrinkPriceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = drinkEditField.getText();
				String price = newDrinkPriceField.getText();
				try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
				String sql = "UPDATE drinks SET price = '"+price+"' WHERE name = '"+name+"'";
				PreparedStatement pst = con1.prepareStatement(sql);
				pst.execute();
				JOptionPane.showMessageDialog(sauceEditField, "Цената е променена успешно! ");
				updateRecords();
				drinkEditField.setText("");
				newDrinkPriceField.setText("");
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		newDrinkPriceButton.setBounds(1115, 655, 120, 23);
		contentPane.add(newDrinkPriceButton);
		
		JButton newSaucePriceButton = new JButton("\u041D\u043E\u0432\u0430 \u0446\u0435\u043D\u0430");
		newSaucePriceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = sauceEditField.getText();
				String price = newSaucePriceField.getText();
				try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
				String sql = "UPDATE sauce SET price = '"+price+"' WHERE name = '"+name+"'";
				PreparedStatement pst = con1.prepareStatement(sql);
				pst.execute();
				JOptionPane.showMessageDialog(sauceEditField, "Цената е променена успешно! ");
				updateRecords();
				sauceEditField.setText("");
				newSaucePriceField.setText("");
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		newSaucePriceButton.setBounds(1115, 378, 120, 23);
		contentPane.add(newSaucePriceButton);
		
		JButton newPizzaPriceButton = new JButton("\u041D\u043E\u0432\u0430 \u0446\u0435\u043D\u0430");
		newPizzaPriceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = pizzaEditField.getText();
				String price = newPizzaPriceField.getText();
				try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
				String sql = "UPDATE pizza SET price = '"+price+"' WHERE name = '"+name+"'";
				PreparedStatement pst = con1.prepareStatement(sql);
				pst.execute();
				JOptionPane.showMessageDialog(sauceEditField, "Цената е променена успешно! ");
				updateRecords();
				pizzaEditField.setText("");
				newPizzaPriceField.setText("");
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		newPizzaPriceButton.setBounds(1115, 172, 120, 23);
		contentPane.add(newPizzaPriceButton);
		
		JLabel label_14 = new JLabel("\u0426\u0435\u043D\u0430:");
		label_14.setForeground(Color.WHITE);
		label_14.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		label_14.setBounds(714, 89, 48, 14);
		contentPane.add(label_14);
		
		pricePizzaField = new JTextField();
		pricePizzaField.setColumns(10);
		pricePizzaField.setBounds(816, 85, 275, 20);
		contentPane.add(pricePizzaField);
		
		JLabel pizzaPicture = new JLabel("");
		Image images = new ImageIcon(this.getClass().getResource("pizza800.jpg")).getImage();
		pizzaPicture.setIcon(new ImageIcon(images));
		pizzaPicture.setBounds(0, 0, 1384, 761);
		contentPane.add(pizzaPicture);
	}
	public void updateRecords() {
		try {
			String as = Project.getText();
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
			
			String sql = "Select * from pizza";
			String sql2 = "Select * from sauce";
			String sql3 = "Select * from drinks";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs  = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			PreparedStatement pst2 = con.prepareStatement(sql2);
			ResultSet rs2  = pst2.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs2));
			
			PreparedStatement pst3 = con.prepareStatement(sql3);
			ResultSet rs3  = pst3.executeQuery();
			table_2.setModel(DbUtils.resultSetToTableModel(rs3));
		}catch (Exception e1) {
			System.out.println(e1);
		
	
		}
		
	}
}
