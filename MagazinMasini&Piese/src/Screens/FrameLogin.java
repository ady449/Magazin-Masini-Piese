package Screens;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import Clase.User;
import Conne.Database;

import java.awt.Insets;
import javax.swing.JTextField;
/**
 * frame-ul de logare si inregistrare
 * @author Adi
 *
 */
public class FrameLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
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
	public FrameLogin() {
		setAlwaysOnTop(true);
		setMinimumSize(new Dimension(840, 480));
		setMaximumSize(new Dimension(1280, 720));
		setVisible(true);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("MagazinMasini&Piese");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1138, 869);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(1280, 720));
		contentPane.setMinimumSize(new Dimension(840, 480));
		contentPane.setMaximumSize(new Dimension(1280, 720));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{253, 784};
		gbl_contentPane.rowHeights = new int[]{120, 655, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel TopPanel = new JPanel();
		TopPanel.setMinimumSize(new Dimension(400, 400));
		TopPanel.setBackground(new Color(30, 59, 44));
		GridBagConstraints gbc_TopPanel = new GridBagConstraints();
		gbc_TopPanel.insets = new Insets(0, 0, 5, 0);
		gbc_TopPanel.gridwidth = 2;
		gbc_TopPanel.anchor = GridBagConstraints.NORTH;
		gbc_TopPanel.fill = GridBagConstraints.BOTH;
		gbc_TopPanel.gridx = 0;
		gbc_TopPanel.gridy = 0;
		contentPane.add(TopPanel, gbc_TopPanel);
		FlowLayout fl_TopPanel = new FlowLayout(FlowLayout.CENTER, 20, 30);
		TopPanel.setLayout(fl_TopPanel);
		
		JLabel lblNewLabel = new JLabel("Magazin Masini&Piese");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		TopPanel.add(lblNewLabel);
		
		JPanel NavBar = new JPanel();
		NavBar.setMaximumSize(new Dimension(200, 32767));
		NavBar.setBackground(new Color(88, 128, 107));
		GridBagConstraints gbc_NavBar = new GridBagConstraints();
		gbc_NavBar.insets = new Insets(0, 0, 0, 5);
		gbc_NavBar.fill = GridBagConstraints.BOTH;
		gbc_NavBar.gridx = 0;
		gbc_NavBar.gridy = 1;
		contentPane.add(NavBar, gbc_NavBar);
		NavBar.setLayout(new GridLayout(10, 1, 10, 5));
		
		JPanel ContactButton = new JPanel();
		ContactButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				JOptionPane.showMessageDialog(null, "numberphone\n"
						+ "Orar: L-V 08-17");
			}
		});
		ContactButton.setBackground(new Color(232, 220, 185));
		NavBar.add(ContactButton);
		ContactButton.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("Contact");
		lblNewLabel_2_1.setBounds(118, 22, 44, 17);
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ContactButton.add(lblNewLabel_2_1);
		
		
		JPanel ItemContainer = new JPanel();
		ItemContainer.setAlignmentX(Component.RIGHT_ALIGNMENT);
		ItemContainer.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		ItemContainer.setBorder(new CompoundBorder());
		ItemContainer.setBackground(new Color(195, 219, 197));
		ItemContainer.setLayout(null);
		GridBagConstraints gbc_ItemContainer = new GridBagConstraints();
		gbc_ItemContainer.fill = GridBagConstraints.BOTH;
		gbc_ItemContainer.gridx = 1;
		gbc_ItemContainer.gridy = 1;
		contentPane.add(ItemContainer, gbc_ItemContainer);
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(252, 213, 68, 14);
		ItemContainer.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setBounds(252, 281, 68, 14);
		ItemContainer.add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(346, 205, 199, 31);
		ItemContainer.add(textField);
		textField.setColumns(10);
		
		textField_1= new JPasswordField();
		textField_1.setColumns(10);
		ItemContainer.add(textField_1);
		
		textField_1.setBounds(346, 273, 199, 31);
		ItemContainer.add(textField_1);
		User user = new User();
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Database db = new Database();
				String uname= textField.getText();
				String upass= textField_1.getText();
				String querry = String.format("select username, password from users where username ='%s' and password = '%s'",uname, upass);
				System.out.println(querry);
				System.out.println(1);
				try {
					db.connect();
					ResultSet result = db.select(querry);
					System.out.println(2);
					while(result.next()) {
						
						System.out.println(3);
						if(uname.equals(result.getString("username")) && upass.equals(result.getString("password")) && uname.equals("admin")) {
//							User user = new User(result.getString("username"), result.getString("password"));
							System.out.println(4);
							new Frame1().setVisible(true);
							dispose();
						}
						if(uname.equals(result.getString("username")) && upass.equals(result.getString("password")) && !uname.equals("admin")){
							new Frame2().setVisible(true);
							dispose();
						}
						
					}
				} catch (Exception ex) {
					// TODO: handle exception
				}
				
			}
		});
		btnNewButton.setBounds(456, 341, 89, 23);
		ItemContainer.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign Up");
		btnNewButton_1.setBounds(346, 341, 89, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Database db = new Database();
				String uname= textField.getText();
				String upass= textField_1.getText();
				String querry = String.format("select username from users where username ='%s'",uname);
				System.out.println(querry);
				System.out.println(1);
				try {
					db.connect();
					ResultSet result = db.select(querry);
					System.out.println(2);
					while(!result.next()) {
						System.out.println(3);
						String querry2 = String.format("INSERT INTO `users` (`id`, `username`, `password`, `cos_id`) VALUES (NULL, '%s', '%s', NULL)" , uname,upass);
						db.createOrUpdateOrDelete(querry2);
						break;
					}
				} catch (Exception ex) {
					// TODO: handle exception
				}
				
			}
		});
		
		ItemContainer.add(btnNewButton_1);
		
	}
	
	

}
