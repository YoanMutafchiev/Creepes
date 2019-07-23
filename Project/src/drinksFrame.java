import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class drinksFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField drinkField;
	private JTextField countField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					drinksFrame frame = new drinksFrame();
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
	public drinksFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				updateRecords();
			}

			private void updateRecords() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
					String sql = "Select * from drinks";
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs  = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					drinkField.setText("");
					countField.setText("");
				}catch (Exception e1) {
					
				
			
				}
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton button = new JButton("\u041D\u0430\u0437\u0430\u0434");
		button.setBounds(834, 387, 96, 30);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderMenu frame = new orderMenu();
				frame.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 11, 663, 411);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				int column = table.getSelectedColumn();
				drinkField.setText(table.getValueAt(index, 1).toString());
			}
		});
		scrollPane.setViewportView(table);
		
		JButton button_1 = new JButton("\u0410\u043A\u0442\u0443\u0430\u043B\u0438\u0437\u0438\u0440\u0430\u0439");
		button_1.setVisible(false);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
					String sql = "Select * from drinks";
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs  = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					drinkField.setText("");
					countField.setText("");
				}catch (Exception e1) {
					
				
			
				}
				
				
				
			}
		});
		button_1.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		button_1.setBounds(272, 427, 166, 23);
		contentPane.add(button_1);
		
		JLabel drinkLabel = new JLabel("\u041D\u0430\u043F\u0438\u0442\u043A\u0430:");
		drinkLabel.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		drinkLabel.setBounds(735, 26, 89, 22);
		contentPane.add(drinkLabel);
		
		drinkField = new JTextField();
		drinkField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE    )) {
					e.consume();
				}
				
			}
		});
		drinkField.setOpaque(false);
		drinkField.setEditable(false);
		drinkField.setColumns(10);
		drinkField.setBounds(834, 26, 134, 20);
		contentPane.add(drinkField);
		
		JLabel countLabel = new JLabel("\u0411\u0440\u043E\u0439:");
		countLabel.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		countLabel.setBounds(735, 64, 59, 30);
		contentPane.add(countLabel);
		
		countField = new JTextField();
		countField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE    )) {
					e.consume();
				}
				
			}
		});
		countField.setColumns(10);
		countField.setBounds(834, 68, 134, 20);
		contentPane.add(countField);
		
		JButton basketOrd = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438 \u0432 \u043A\u043E\u0448\u043D\u0438\u0446\u0430\u0442\u0430");
		basketOrd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String as = Project.getText();
				//System.out.println(as);
				Date thisDate = new Date();
				SimpleDateFormat dateForm = new SimpleDateFormat("dd/M/Y HH:mm");
				//System.out.println(dateForm.format(thisDate));
				String date = dateForm.format(thisDate);
				//System.out.println(date);
				
			String drinkText = drinkField.getText();
			String counts = countField.getText();
			
			try {
				if(counts.isEmpty() || drinkText.isEmpty() || counts.equals("0")) {
					JOptionPane.showMessageDialog(drinkField, "Моля попълнете полетата, бройката трябва да е по-голяма от 0!");
				}else {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
			String sql = "select price from drinks where name = '"+drinkText+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
           if(!rs.next()) {
			} else {
				String priceOfDrink = rs.getString("price");
		           
		           Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
					String sql1 = "INSERT INTO orders (userName,productName,quantity,price,date) VALUES(?,?,?,?,?)";
					PreparedStatement pst = con1.prepareStatement(sql1);
					pst.setString(1,as);
					pst.setString(2,drinkText);
					pst.setString(3,counts);
					pst.setString(4,priceOfDrink);
					pst.setString(5,date);
					pst.execute();
					JOptionPane.showMessageDialog(countField, "Продуктът е добавен в кошницата!");
					pst.close();
					drinkField.setText("");
					countField.setText("");
			}
				}
			} catch (Exception e1) {
				System.out.println(e1);
			}
			
			
			}
		});
		basketOrd.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		basketOrd.setBounds(794, 132, 229, 35);
		contentPane.add(basketOrd);
		
		JLabel pizzaPicture = new JLabel("");
		Image images = new ImageIcon(this.getClass().getResource("pizzaFrame.jpg")).getImage();
		pizzaPicture.setIcon(new ImageIcon(images));
		pizzaPicture.setBounds(0, 0, 1384, 461);
		contentPane.add(pizzaPicture);
		
	}
}
