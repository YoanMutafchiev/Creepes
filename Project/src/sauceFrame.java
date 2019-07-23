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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class sauceFrame extends JFrame {

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
					sauceFrame frame = new sauceFrame();
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
	public sauceFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				updateRecords();
			}

			private void updateRecords() {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
					String sql = "Select * from sauce";
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
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 64, 649, 349);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				int column = table.getSelectedColumn();
				idField.setText(table.getValueAt(index, 1).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("\u0410\u043A\u0442\u0443\u0430\u043B\u0438\u0437\u0438\u0440\u0430\u0439");
		button.setVisible(false);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
					String sql = "Select * from sauce";
					PreparedStatement pst = con.prepareStatement(sql);
					ResultSet rs  = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					idField.setText("");
					countField.setText("");
				}catch (Exception e1) {
					
				
			
				}
			}
		});
		button.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		button.setBounds(271, 424, 166, 23);
		contentPane.add(button);
		
		idField = new JTextField();
		idField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE    )) {
					e.consume();
				}
			}
		});
		idField.setOpaque(false);
		idField.setEditable(false);
		idField.setColumns(10);
		idField.setBounds(858, 62, 134, 20);
		contentPane.add(idField);
		
		JLabel sauceLabel = new JLabel("\u0421\u043E\u0441:");
		sauceLabel.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		sauceLabel.setBounds(759, 62, 89, 22);
		contentPane.add(sauceLabel);
		
		JLabel countLabel = new JLabel("\u0411\u0440\u043E\u0439:");
		countLabel.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		countLabel.setBounds(759, 98, 59, 30);
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
		countField.setBounds(858, 102, 134, 20);
		contentPane.add(countField);
		
		JButton basketButton = new JButton("\u0414\u043E\u0431\u0430\u0432\u0438 \u0432 \u043A\u043E\u0448\u043D\u0438\u0446\u0430\u0442\u0430");
		basketButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String as = Project.getText();
				Date thisDate = new Date();
				SimpleDateFormat dateForm = new SimpleDateFormat("dd/M/Y HH:mm");
				String date = dateForm.format(thisDate);
			
				
			String sauceText = idField.getText();
			String counts = countField.getText();
			
		try {
			if(counts.isEmpty() || sauceText.isEmpty() || counts.equals("0")) {
				JOptionPane.showMessageDialog(idField, "Моля попълнете полетата, бройката трябва да е по-голяма от 0!");
			}else {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
			String sql = "select price from sauce where name = '"+sauceText+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
           if(!rs.next()) {				
			} else {
          
           String priceOfSauce = rs.getString("price");
           
           Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
			String sql1 = "INSERT INTO orders (userName,productName,quantity,price,date) VALUES(?,?,?,?,?)";
			PreparedStatement pst = con1.prepareStatement(sql1);
			pst.setString(1,as);
			pst.setString(2,sauceText);
			pst.setString(3,counts);
			pst.setString(4,priceOfSauce);
			pst.setString(5,date);
			pst.execute();
			JOptionPane.showMessageDialog(countField, "Продуктът е добавен в кошницата!");
			pst.close();
			idField.setText("");
			countField.setText("");
			}
			}
		}catch (Exception e1) {
			System.out.println(e1);
		}
			
			}
		});
		basketButton.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		basketButton.setBounds(832, 170, 229, 35);
		contentPane.add(basketButton);
		
		JButton button_2 = new JButton("\u041D\u0430\u0437\u0430\u0434");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				orderMenu frame = new orderMenu();
				frame.setVisible(true);
				dispose();
			}
		});
		button_2.setBounds(859, 426, 73, 22);
		contentPane.add(button_2);
		
		JLabel pizzaPicture = new JLabel("");
		Image images = new ImageIcon(this.getClass().getResource("pizzaFrame.jpg")).getImage();
		pizzaPicture.setIcon(new ImageIcon(images));
		pizzaPicture.setBounds(0, 0, 1384, 461);
		contentPane.add(pizzaPicture);
		
	}
}
