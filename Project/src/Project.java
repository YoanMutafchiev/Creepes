import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.text.html.HTML;

import com.sun.jdi.connect.spi.Connection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import com.mysql.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import javax.swing.JDesktopPane;
import java.awt.Dialog.ModalExclusionType;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Project {
    protected static String text;
	JFrame frame;
	private JLabel label_1;
	private JLabel label_2;
	protected  JTextField userLogin;
	protected  JPasswordField passwordField;
	private JButton btnNewButton_2;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Project window = new Project();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the application.
	 */
	public Project() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(800,200,400,400);
		frame.setResizable(false);
		frame.getContentPane().setEnabled(false);
		frame.setSize(new Dimension(400, 400));
		frame.getContentPane().setLayout(null);
		
		label_1 = new JLabel("\u0418\u043C\u0435:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		label_1.setBounds(10, 127, 75, 28);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("\u041F\u0430\u0440\u043E\u043B\u0430:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		label_2.setBounds(10, 154, 87, 19);
		frame.getContentPane().add(label_2);
		
		userLogin = new JTextField();
		userLogin.setBounds(107, 129, 176, 20);
		frame.getContentPane().add(userLogin);
		userLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(107, 154, 176, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("\u0412\u043B\u0435\u0437");
		btnNewButton.setFont(new Font("Sitka Small", Font.PLAIN, 18));
		btnNewButton.setBounds(136, 195, 112, 40);
		frame.getContentPane().add(btnNewButton);
		
		JLabel picture = new JLabel("");
		Image images = new ImageIcon(this.getClass().getResource("/loginPicture.jpg")).getImage();
		
		JButton btnNewButton_1 = new JButton("\u0418\u0437\u0445\u043E\u0434");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(295, 326, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("\u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0430\u0446\u0438\u044F");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register registerFrame = new Register();
				frame.setVisible(false);
				registerFrame.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(136, 259, 110, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JCheckBox adminCheck = new JCheckBox("ADMIN");
		adminCheck.setOpaque(false);
		adminCheck.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adminCheck.setForeground(Color.WHITE);
		adminCheck.setBackground(UIManager.getColor("Button.disabledShadow"));
		adminCheck.setBounds(287, 129, 97, 23);
		frame.getContentPane().add(adminCheck);
		picture.setIcon(new ImageIcon(images));
		picture.setBounds(0, 0, 402, 371);
		frame.getContentPane().add(picture);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					String userName = userLogin.getText();
					String passField = passwordField.getText();
					Class.forName("com.mysql.jdbc.Driver");
					
					java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
					//java.sql.Connection con = DriverManager.getConnection("jdbc:mysql:54.38.160.124","root","Sedemedobro4islo");
				
					Statement stmt = con.createStatement();
					String sql = "Select name,password,type from users where name = '"+userName+"'AND password = '"+passField+"'";
					ResultSet rs = stmt.executeQuery(sql);
					
					
					
					
					
					
					if(rs.next()) {
						//Проверка за админ
						if(rs.getString("name").equals(userName) && rs.getString("password").equals(passField) && rs.getString("type").equals("ADMIN") && adminCheck.isSelected()) {
							JOptionPane.showMessageDialog(frame, "Добре дошъл "+rs.getString("name"));
							adminFrame frame2 = new adminFrame();
							//frame2.setSize(new Dimension(1600, 1000));
							frame.setVisible(false);
							frame2.setVisible(true);
							
						} 
						// Проверка дали клиент е маркирал админ и се опитва да влезе като такъв
						else if(rs.getString("name").equals(userName) && rs.getString("password").equals(passField) && adminCheck.isSelected()) {
							JOptionPane.showMessageDialog(frame, "Нямате администраторски акаунт!!!");
						} 
						// Клиентски акаунт
						else if(rs.getString("name").equals(userName) && rs.getString("password").equals(passField)) {
							JOptionPane.showMessageDialog(frame, "Добре дошъл "+rs.getString("name"));
							MainMenu frame2 = new MainMenu();
							//frame2.setSize(new Dimension(1600, 1000));
							frame.setVisible(false);
							frame2.setVisible(true);
							text = rs.getString("name");
							//System.out.println(text);
							
						}
					}else {
						JOptionPane.showMessageDialog(frame, "Грешно име или парола!");
					}
					
				} catch(Exception ee) {
					System.out.println(ee);
				}
			}
		});{
			
		}
		
		
	}

	public static String getText() {
		return text;
	}

	public void setText(String text) {
		Project.text = text;
	}
}
