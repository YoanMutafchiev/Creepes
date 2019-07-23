import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.PreparableStatement;

import net.proteanit.sql.DbUtils;


import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class pizzaFrame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField idField;
	private JTextField countField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pizzaFrame frame = new pizzaFrame();
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
	public pizzaFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				 updateRecords();
			}

			private void updateRecords() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
					String sql = "Select * from pizza";
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs  = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					idField.setText("");
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
		
		JButton backButton = new JButton("\u041D\u0430\u0437\u0430\u0434");
		backButton.setBounds(806, 428, 73, 22);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderMenu frame = new orderMenu();
				frame.setVisible(true);
				dispose();
				
			}
		});
		contentPane.setLayout(null);
		contentPane.add(backButton);
		
		
		JButton button = new JButton("Актуализирай");
		button.setVisible(false);
		button.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
					String sql = "Select * from pizza";
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs  = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					idField.setText("");
					countField.setText("");
				}catch (Exception e1) {
					
				
			
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 25, 649, 397);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				int column = table.getSelectedColumn();
				// id field here 
				idField.setText(table.getValueAt(index, 1).toString());
				
				
				
				
			}
		});
		
         
		scrollPane.setViewportView(table);
		button.setBounds(278, 429, 166, 23);
		contentPane.add(button);
		
		JLabel lblId = new JLabel("\u041F\u0438\u0446\u0430:");
		lblId.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblId.setBounds(724, 23, 89, 22);
		contentPane.add(lblId);
		
		idField = new JTextField();
		idField.setOpaque(false);
		idField.setEditable(false);
		idField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE    )) {
					e.consume();
				}
			}
		});
		idField.setBounds(821, 23, 134, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		
		
		
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
		countField.setBounds(821, 59, 134, 20);
		contentPane.add(countField);
		countField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u0411\u0440\u043E\u0439:");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblNewLabel.setBounds(724, 55, 59, 30);
		contentPane.add(lblNewLabel);
		
		JButton basketButton = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438 \u0432 \u043A\u043E\u0448\u043D\u0438\u0446\u0430\u0442\u0430");
		basketButton.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		basketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String as = Project.getText();
				//System.out.println(as);
				Date thisDate = new Date();
				SimpleDateFormat dateForm = new SimpleDateFormat("dd/M/Y HH:mm");
				String date = dateForm.format(thisDate);
				//System.out.println(date);
			String pizzaText = idField.getText();
			String counts = countField.getText();
			
			
			String pizzaNameField = idField.getText();
			
			try {
				if(counts.isEmpty() || pizzaText.isEmpty() || counts.equals("0")) {
					
					JOptionPane.showMessageDialog(idField, "Моля попълнете полетата, бройката трябва да е по-голяма от 0!");
				} else {
					
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
			String sql = "select price from pizza where name = '"+pizzaNameField+"'";
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
				
			if(!rs.next()) {	
		
			}
			else {
				String priceOfPizza = rs.getString("price");
			  
				//double value = Double.parseDouble(priceOfPizza);
				//System.out.println(priceOfPizza);
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
				
				String sql1 = "INSERT INTO orders (userName,productName,quantity,price,date) VALUES(?,?,?,?,?)";
				
				PreparedStatement pst = con1.prepareStatement(sql1);
				
				pst.setString(1,as);
				pst.setString(2,pizzaNameField);
				pst.setString(3,counts);
				pst.setString(4,priceOfPizza);
				pst.setString(5,date);
				pst.execute();
				JOptionPane.showMessageDialog(countField, "Продуктът е добавен в кошницата!");
				pst.close();
				idField.setText("");
				countField.setText("");
			}
				
			}
			
			} catch (Exception e1) {
			System.out.println(e1);
			}
			
			
			
			}
			
		});
		
		basketButton.setBounds(792, 126, 229, 35);
		contentPane.add(basketButton);
		
		JLabel picture = new JLabel("");
		Image images = new ImageIcon(this.getClass().getResource("pizzaFrame.jpg")).getImage();
		picture.setIcon(new ImageIcon(images));
		picture.setBounds(0, 0, 1384, 461);
		contentPane.add(picture);
		
		
	}
}
