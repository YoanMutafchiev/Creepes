import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.PreparableStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class adminRegister extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField phoneField;
	private JPasswordField confPass;
	private JPasswordField passField;
	private JTable table;
	private JTextField idField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public adminRegister() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				updateRecords();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u041D\u0430\u0437\u0430\u0434");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				adminFrame frame = new adminFrame();
				frame.setVisible(true);
				dispose();
				
				
			}
		});
		btnNewButton.setBounds(562, 704, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("\u0418\u043C\u0435: *");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		label_1.setBounds(10, 257, 66, 23);
		contentPane.add(label_1);
		
		nameField = new JTextField();
		nameField.setBounds(10, 291, 298, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u041F\u0430\u0440\u043E\u043B\u0430: *");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		label_2.setBounds(10, 322, 261, 23);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u041F\u043E\u0432\u0442\u043E\u0440\u0435\u0442\u0435 \u043F\u0430\u0440\u043E\u043B\u0430\u0442\u0430: *");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		label_3.setBounds(10, 387, 261, 23);
		contentPane.add(label_3);
		
		JLabel lblEmail = new JLabel("Email: *");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		lblEmail.setBounds(10, 449, 79, 23);
		contentPane.add(lblEmail);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(10, 483, 298, 20);
		contentPane.add(emailField);
		
		JLabel label_4 = new JLabel("\u0422\u0435\u043B\u0435\u0444\u043E\u043D \u0437\u0430 \u043A\u043E\u043D\u0442\u0430\u043A\u0442\u0438: *");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		label_4.setBounds(10, 514, 261, 23);
		contentPane.add(label_4);
		
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
		phoneField.setBounds(10, 548, 298, 20);
		contentPane.add(phoneField);
		Image img = new ImageIcon(this.getClass().getResource("register800.jpg")).getImage();
		
		JLabel lblNewLabel_2 = new JLabel("\u043F\u043E\u043B\u0435\u0442\u0430\u0442\u0430 \u0441\u044A\u0441 \u0441\u0438\u043C\u0432\u043E\u043B \"*\", \u0441\u0430 \u0437\u0430\u0434\u044A\u043B\u0436\u0438\u0442\u0435\u043B\u043D\u0438!");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(79, 579, 394, 14);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u0430\u0439");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					registerForm();
					updateRecords();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(280, 604, 119, 31);
		contentPane.add(btnNewButton_1);
		
		passField = new JPasswordField();
		passField.setBounds(10, 356, 298, 20);
		contentPane.add(passField);
		
		confPass = new JPasswordField();
		confPass.setBounds(10, 418, 298, 20);
		contentPane.add(confPass);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(694, 0, 690, 360);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				idField.setText(table.getValueAt(index, 0).toString());
			}
		});
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		lblNewLabel.setBounds(718, 371, 48, 23);
		contentPane.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setEditable(false);
		idField.setBounds(776, 371, 139, 20);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("\u041F\u0440\u0435\u043C\u0430\u0445\u043D\u0438");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idField.getText();
				try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
				
				String sql = "DELETE FROM users WHERE id = '"+id+"'";
				PreparedStatement pst = con.prepareStatement(sql);
				pst.execute();
				JOptionPane.showMessageDialog(idField, "Регистрацията е изтрита успешно! ");
				
				}catch (Exception e1) {
					System.out.println(e1);
				}
				updateRecords();
			}
		});
		btnNewButton_2.setBounds(718, 405, 139, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel pizzaPicture = new JLabel("");
		Image images = new ImageIcon(this.getClass().getResource("register800.jpg")).getImage();
		pizzaPicture.setIcon(new ImageIcon(images));
		pizzaPicture.setBounds(0, 0, 1384, 761);
		contentPane.add(pizzaPicture);
		

		
	}
	public void registerForm() throws SQLException {
		
		String user = nameField.getText();
		String password = passField.getText();
		String confPassword = confPass.getText();
		String phone = phoneField.getText();
	    String email = emailField.getText();
	    // Проверка дали телефонният номер съдържа само цифри
	    if(phone.matches("^[0-9]*$") && phone.length() > 2){
	    	//
	    	if(!user.matches("^[0-9]*$")){
		    	//
	    		if(password.equals(confPassword)) {
	    			
	    			if(phone.length()==10) {
	    				
	    				if(user.isEmpty() || password.isEmpty() || confPassword.isEmpty() || phone.isEmpty()) {
	    					JOptionPane.showMessageDialog(passField, "Моля попълнете всички задължителни полета! ");
	    				}else {
	    					java.sql.Connection con;
	    					try {
	    						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
	    						Statement stmt = con.createStatement();
	    						String sql = "INSERT INTO users (name,password,email, phone,type) VALUES(?,?,?,?,?)";
	    						PreparedStatement pst = con.prepareStatement(sql);
	    						pst.setString(1,user);
	    						pst.setString(2,password);
	    						pst.setString(3,email);
	    						pst.setString(4,phone);
	    						pst.setString(5, "ADMIN");
	    						//ResultSet rs = stmt.executeQuery(sql);
	    						pst.execute();
	    						JOptionPane.showMessageDialog(passField, "Регистрацията е направена успешно! ");
	    						pst.close();
	    						
	    						
	    					} catch (SQLException e) {
	    						// TODO Auto-generated catch block
	    						e.printStackTrace();
	    					}
	    				}
	    			} else {
	    				JOptionPane.showMessageDialog(passField, "Телефонният номер трябва да е точно 10 символа! ");
	    			}
	    		} else {
	    			JOptionPane.showMessageDialog(phoneField, "Паролите не съвпадат! ");
	    		}
		    } else {
		    	JOptionPane.showMessageDialog(phoneField, "Името трябва да съдържа само букви! ");
		    }
	    } else {
	    	JOptionPane.showMessageDialog(phoneField, "Телефонният номер трябва да съдържа само числа! ");
	    }
	    // Проверка дали името съдържа само букви
	    
	    // Проверка дали двете пароли съвпадат
		
		 // Проверка дали всички задължителни полета са попълнени
		
		 // Проверка дали телефонният номер съдържа точно 10 символа
		
		 
		
		
		
		
	}
	public void updateRecords() {
		try {
			String as = Project.getText();
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
			String sql = "Select * from users";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs  = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (Exception e1) {
			System.out.println(e1);
		
	
		}
		
	}
}
