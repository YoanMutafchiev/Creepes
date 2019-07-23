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
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class MenuOrder extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton button;
	private JLabel order;
	private JTextField orderField;
	private JButton acceptButton;
	private JButton rejectButton;
	private JButton travelButton;
	private JButton finishedButton;
	private JButton deleteAllButton;
	private JLabel pizzaPicture;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuOrder frame = new MenuOrder();
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
	public MenuOrder() {
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
		scrollPane.setBounds(10, 11, 916, 739);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				orderField.setText(table.getValueAt(index, 0).toString());
				
			}
		});
		table.setDefaultEditor(Object.class, null);
		scrollPane.setViewportView(table);
		
		button = new JButton("\u041D\u0430\u0437\u0430\u0434");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminFrame frame = new adminFrame();
				frame.setVisible(true);
				dispose();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBounds(1285, 727, 89, 23);
		contentPane.add(button);
		
		order = new JLabel("\u041F\u043E\u0440\u044A\u0447\u043A\u0430:");
		order.setForeground(Color.WHITE);
		order.setFont(new Font("Sitka Text", Font.PLAIN, 16));
		order.setBounds(953, 12, 80, 14);
		contentPane.add(order);
		
		orderField = new JTextField();
		orderField.setEditable(false);
		orderField.setColumns(10);
		orderField.setBounds(1043, 9, 298, 20);
		contentPane.add(orderField);
		
		acceptButton = new JButton("\u041F\u0440\u0438\u0435\u043C\u0438");
		acceptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = orderField.getText();
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
					String sql1 = "UPDATE orders SET type = 'ACCEPTED' WHERE id = '"+id+"'";
					PreparedStatement pst = con1.prepareStatement(sql1);
					pst.execute();
					updateRecords();
				}catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		acceptButton.setBounds(944, 53, 89, 23);
		contentPane.add(acceptButton);
		
		rejectButton = new JButton("\u041E\u0442\u043A\u0430\u0436\u0438");
		rejectButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = orderField.getText();
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
					String sql1 = "UPDATE orders SET type = 'REJECTED' WHERE id = '"+id+"'";
					PreparedStatement pst = con1.prepareStatement(sql1);
					pst.execute();
					updateRecords();
				}catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		rejectButton.setBounds(1052, 53, 89, 23);
		contentPane.add(rejectButton);
		
		travelButton = new JButton("\u041F\u044A\u0442\u0443\u0432\u0430");
		travelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = orderField.getText();
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
					String sql1 = "UPDATE orders SET type = 'TRAVELLING' WHERE id = '"+id+"'";
					PreparedStatement pst = con1.prepareStatement(sql1);
					pst.execute();
					updateRecords();
				}catch (Exception e1) {
					System.out.println(e1);
				}
			}
			
		});
		travelButton.setBounds(1158, 53, 89, 23);
		contentPane.add(travelButton);
		
		finishedButton = new JButton("\u0417\u0430\u0432\u044A\u0440\u0448\u0435\u043D\u0430");
		finishedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String id = orderField.getText();
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
					String sql1 = "UPDATE orders SET type = 'FINISHED' WHERE id = '"+id+"'";
					PreparedStatement pst = con1.prepareStatement(sql1);
					pst.execute();
					updateRecords();
				}catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		finishedButton.setBounds(1257, 53, 117, 23);
		contentPane.add(finishedButton);
		
		deleteAllButton = new JButton("\u0418\u0437\u0442\u0440\u0438\u0439 \u0432\u0441\u0438\u0447\u043A\u0438 \u043F\u043E\u0440\u044A\u0447\u043A\u0438");
		deleteAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Class.forName("com.mysql.jdbc.Driver");
				java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
				String sql = "DELETE from orders";
				PreparedStatement pst = con.prepareStatement(sql);
				JOptionPane.showMessageDialog(orderField, "Всички поръчки са изчистени успешно! ");
				pst.execute();
				updateRecords();
				}catch (Exception e1) {
					System.out.println(e1);
					
				}
			}
		});
		deleteAllButton.setBounds(932, 565, 209, 23);
		contentPane.add(deleteAllButton);
		
		pizzaPicture = new JLabel("");
		Image images = new ImageIcon(this.getClass().getResource("pizza800.jpg")).getImage();
		pizzaPicture.setIcon(new ImageIcon(images));
		pizzaPicture.setBounds(140, 0, 1244, 750);
		contentPane.add(pizzaPicture);
	}
	public void updateRecords() {
		try {
			String as = Project.getText();
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","1234");
			String sql = "Select * from orders where type  != 'IN BASKET' ";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs  = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}catch (Exception e1) {
			System.out.println(e1);
		
	
		}
		
	}
}
