import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.cj.xdevapi.PreparableStatement;

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

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField phoneField;
	private JPasswordField confPass;
	private JPasswordField passField;

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
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 100, 700, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u041D\u0430\u0437\u0430\u0434");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Project window = new Project();
				window.frame.setVisible(true);
				adminFrame frame = new adminFrame();
				frame.setVisible(false);
				dispose();
			}
		});
		btnNewButton.setBounds(562, 704, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("\u0414\u043E\u0431\u0440\u0435 \u0434\u043E\u0448\u043B\u0438");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 34));
		label.setBounds(224, 109, 308, 110);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u0418\u043C\u0435: *");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 18));
		label_1.setBounds(10, 257, 66, 23);
		contentPane.add(label_1);
		
		nameField = new JTextField();
		nameField.setBounds(10, 291, 298, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("\u0432 \u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u043E\u043D\u043D\u0430\u0442\u0430 \u0444\u043E\u0440\u043C\u0430 \u043D\u0430 \u043F\u0438\u0446\u0430\u0440\u0438\u044F");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setBounds(10, 191, 418, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\"\u0412\u043A\u0443\u0441\u043D\u0430 \u043F\u0438\u0446\u0430\"");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 28));
		lblNewLabel_1.setBounds(438, 183, 318, 36);
		contentPane.add(lblNewLabel_1);
		
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
		
		JLabel lblEmail = new JLabel("Email: ");
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
		
		JLabel pizzaPicture = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/registerScreen.jpg")).getImage();
		
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
		pizzaPicture.setIcon(new ImageIcon(img));
		pizzaPicture.setBounds(0, 0, 684, 761);
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
	    						String sql = "INSERT INTO users (name,password,email, phone) VALUES(?,?,?,?)";
	    						PreparedStatement pst = con.prepareStatement(sql);
	    						pst.setString(1,user);
	    						pst.setString(2,password);
	    						pst.setString(3,email);
	    						pst.setString(4,phone);
	    						//ResultSet rs = stmt.executeQuery(sql);
	    						pst.execute();
	    						JOptionPane.showMessageDialog(passField, "Регистрацията е направена успешно! ");
	    						pst.close();
	    						Project window = new Project();
	    						window.frame.setVisible(true);
	    						adminFrame frame = new adminFrame();
	    						
	    						dispose();
	    						
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
}
