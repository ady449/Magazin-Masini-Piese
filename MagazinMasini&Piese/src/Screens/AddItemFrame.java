package Screens;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Clase.Cars;
import Clase.Item;
import Clase.Piesa;
import Conne.Database;

import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JTabbedPane;
import java.awt.Rectangle;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class AddItemFrame extends JFrame {
	

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;
	protected int modelIdSelected;
	protected int IdProducator;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItemFrame frame = new AddItemFrame();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					
//		            frame.dispose();
		    
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddItemFrame() throws SQLException {
		
		Database db = new Database();
		List<Cars> cars = new ArrayList<Cars>();
		List<Piesa> piesee = new ArrayList<Piesa>();
		List<String> producatorName = new ArrayList<String>();
		List<String> modelCarName = new ArrayList<String>();
		
		db.connect();
		
		String querry = "SELECT * FROM cars";
		String querry2 = "SELECT model_name FROM `model_car` ORDER BY `model_car`.`id` ASC";
		String querry3  ="SELECT  * FROM piese";
		String querry4 = "SELECT manufacturer_name FROM manufacturer ORDER BY manufacturer.id ASC";
		ResultSet result4 = db.select(querry4);
		while(result4.next()) {
			producatorName.add(result4.getString("manufacturer_name"));
		}
		ResultSet result2= db.select(querry2);
		while(result2.next()) {
			modelCarName.add(result2.getString("model_name"));
		}
//		Car(int id_car, String name, int count, int price, int numberOfkm, String description, int model_id, int date_id)
		ResultSet result = db.select(querry);
		while(result.next()) {
			cars.add(new Cars(result.getInt("id_car"), result.getString("name"),result.getInt("count"), result.getInt("price"), result.getInt("numberOfkm"), result.getString("Description"), result.getInt("model_id"), result.getDate("date")));
		}
		
		ResultSet result3 = db.select(querry3);
		while(result3.next()) {
			piesee.add(new Piesa(result3.getInt("id_piesa"), result3.getString("name"), result3.getInt("count"), result3.getInt("price"), result3.getInt("producator"), result3.getBoolean("uzura_nou"), result3.getDate("date")));
		}
		db.disconnect();
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
		gbl_contentPane.rowHeights = new int[]{62, 655, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setMinimumSize(new Dimension(100, 100));
		panel_3.setBackground(new Color(30, 59, 44));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridwidth = 2;
		gbc_panel_3.anchor = GridBagConstraints.NORTH;
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		contentPane.add(panel_3, gbc_panel_3);
		FlowLayout fl_panel_3 = new FlowLayout(FlowLayout.CENTER, 20, 30);
		panel_3.setLayout(fl_panel_3);
		
		JLabel lblNewLabel = new JLabel("Magazin Masini&Piese");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 19));
		panel_3.add(lblNewLabel);
		
		JPanel NavBar = new JPanel();
		NavBar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		NavBar.setBackground(new Color(88, 128, 107));
		GridBagConstraints gbc_NavBar = new GridBagConstraints();
		gbc_NavBar.insets = new Insets(0, 0, 0, 5);
		gbc_NavBar.fill = GridBagConstraints.BOTH;
		gbc_NavBar.gridx = 0;
		gbc_NavBar.gridy = 1;
		contentPane.add(NavBar, gbc_NavBar);
		NavBar.setLayout(new GridLayout(10, 1, 10, 10));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(232, 220, 185));
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				JOptionPane.showMessageDialog(null, "numberphone\n"
						+ "Orar: L-V 08-17");
			}
		});
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setHgap(20);
		flowLayout.setVgap(25);
		flowLayout.setAlignOnBaseline(true);
		NavBar.add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contact");
		panel_1.add(lblNewLabel_2);
		
		JPanel Inapoi = new JPanel();
		Inapoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new Frame1().setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}

			
		});
		FlowLayout fl_Inapoi = (FlowLayout) Inapoi.getLayout();
		fl_Inapoi.setVgap(25);
		fl_Inapoi.setHgap(20);
		Inapoi.setBackground(new Color(232, 220, 185));
		NavBar.add(Inapoi);
		
		JLabel lblNewLabel_2_1 = new JLabel("Inapoi");
		Inapoi.add(lblNewLabel_2_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 1;
		gbc_tabbedPane.gridy = 1;
		contentPane.add(tabbedPane, gbc_tabbedPane);
		
		JPanel masini = new JPanel();
		tabbedPane.addTab("Masini", null, masini, null);
		masini.setLayout(new GridLayout(8, 2, 10, 10));
		
		JLabel lblNewLabel_6 = new JLabel("Nume");
		lblNewLabel_6.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		masini.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textField.setMargin(new Insets(10, 0, 20, 0));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		masini.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Numar");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setHorizontalTextPosition(SwingConstants.CENTER);
		masini.add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setMargin(new Insets(10, 0, 20, 0));
		textField_1.setBounds(new Rectangle(3, 3, 6, 7));
		masini.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Pret");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setHorizontalTextPosition(SwingConstants.CENTER);
		masini.add(lblNewLabel_7);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setMargin(new Insets(10, 0, 20, 0));
		masini.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Numarul de km al masinii");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setHorizontalTextPosition(SwingConstants.CENTER);
		masini.add(lblNewLabel_8);
		
		textField_3 = new JTextField();
		textField_3.setMargin(new Insets(10, 0, 20, 0));
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		masini.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Descriere");
		lblNewLabel_9.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		masini.add(lblNewLabel_9);
		
		textField_4 = new JTextField();
		textField_4.setMargin(new Insets(10, 0, 20, 0));
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		masini.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Modelul masinii");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setHorizontalTextPosition(SwingConstants.CENTER);
		masini.add(lblNewLabel_10);
		
		 
		JComboBox comboBox = new JComboBox<>(modelCarName.toArray());
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == comboBox) {
//					System.out.println(comboBox.getSelectedIndex());
					modelIdSelected = comboBox.getSelectedIndex();
				}
			}
		});
		masini.add(comboBox);
		
		JLabel lblNewLabel_11 = new JLabel("Data fabricatiei");
		lblNewLabel_11.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		masini.add(lblNewLabel_11);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd/MM/yyyy");
		masini.add(dateChooser);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				SimpleDateFormat dateFormat = new SimpleDateFormat();
				
//				System.out.println(dateFormat.format(dateChooser.getDate()));
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		masini.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Adauga masina");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = textField.getText();
				
				int pret = Integer.parseInt(textField_2.getText());
				int count =Integer.parseInt(textField_1.getText());
				int numberOfkm= Integer.parseInt(textField_3.getText());
				String description = textField_4.getText();
				java.util.Date date = dateChooser.getDate();
				long d = date.getTime();
				java.sql.Date ds = new java.sql.Date(d);
				
				Cars car = new Cars();
				car.setName(name);
				car.setCount(count);
				car.setPrice(pret);
				car.setNumberOfkm(numberOfkm);
				car.setDescription(description);
				car.setModel_id(modelIdSelected+1);
				car.setDate(ds);
				try {
					CreateCar(car,db);
//					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		masini.add(btnNewButton);
		
		JPanel piese = new JPanel();
		tabbedPane.addTab("Piese", null, piese, null);
		piese.setLayout(new GridLayout(7, 2, 10, 10));
		
		JLabel lblNewLabel_12 = new JLabel("Nume");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		piese.add(lblNewLabel_12);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		piese.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_12_1 = new JLabel("Numar");
		lblNewLabel_12_1.setHorizontalAlignment(SwingConstants.CENTER);
		piese.add(lblNewLabel_12_1);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setColumns(10);
		piese.add(textField_6);
		
		JLabel lblNewLabel_12_2 = new JLabel("Pret");
		lblNewLabel_12_2.setHorizontalAlignment(SwingConstants.CENTER);
		piese.add(lblNewLabel_12_2);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setColumns(10);
		piese.add(textField_7);
		
		JLabel lblNewLabel_12_4 = new JLabel("Producator");
		lblNewLabel_12_4.setHorizontalAlignment(SwingConstants.CENTER);
		piese.add(lblNewLabel_12_4);
//		Piesa piesa = new Piesa();
		
		JComboBox comboBox_2 = new JComboBox(producatorName.toArray());
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == comboBox_2) {
//					System.out.println(comboBox.getSelectedIndex());
//					piesa.setIdProducator(comboBox_2.getSelectedIndex());
					IdProducator=comboBox_2.getSelectedIndex();
//					System.out.println(piesa.getIdProducator());
				}
			}
		});
		piese.add(comboBox_2);
		
		JLabel lblNewLabel_12_3 = new JLabel("Piesa noua");
		lblNewLabel_12_3.setHorizontalAlignment(SwingConstants.CENTER);
		piese.add(lblNewLabel_12_3);
		String[] uzuraNou = {"true","false"};
		JComboBox<String> comboBox_1 = new JComboBox<String>(uzuraNou);
		piese.add(comboBox_1);
		
		JLabel lblNewLabel_12_5 = new JLabel("Data Fabricatiei");
		lblNewLabel_12_5.setHorizontalAlignment(SwingConstants.CENTER);
		piese.add(lblNewLabel_12_5);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		piese.add(dateChooser_1);
		
		JButton btnNewButton_3 = new JButton("Clear");
		piese.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Adauga obiect");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField_5.getText();
				
				int pret = Integer.parseInt(textField_7.getText());
				int count =Integer.parseInt(textField_6.getText());
//				String producator= textField_9.getText();
//				boolean uzuraNou = Boolean.parseBoolean(comboBox_1.getText());
				java.util.Date date = dateChooser_1.getDate();
				long d = date.getTime();
				java.sql.Date ds = new java.sql.Date(d);
				
				Piesa piesa = new Piesa();
				
				piesa.setName(name);
				piesa.setCount(count);
				piesa.setPrice(pret);
				System.out.println(IdProducator);
				piesa.setIdProducator(IdProducator+1);
				
				
				piesa.setIdProducator(IdProducator);
				comboBox_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (e.getSource() == comboBox_1) {
//							System.out.println(comboBox.getSelectedIndex());
//							piesa.setIdProducator(comboBox_2.getSelectedIndex());
							piesa.setUzuraNou((boolean) comboBox_1.getSelectedItem());
						}
					}
				});

				
				piesa.setData(ds);
				
					
				try {
					CreatePiesa(piesa,db);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//					
				
				
			}
		});
		piese.add(btnNewButton_2);
		
		
		JLabel lblNewLabel_1 = new JLabel("Add Item");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		
	}
	

	
	public static void CreateCar(Cars car, Database db) throws SQLException {
		
		db.connect();
		
		String querry_insert = String.format("INSERT INTO `cars` (`id_car`, `name`, `count`, `price`, `numberOfkm`, `Description`, `model_id`, `date`) VALUES (NULL, '%s', '%d', '%d', '%d', '%s', '%d', '%s')", car.getName(), car.getCount(), car.getPrice(), car.getNumberOfkm(), car.getDescription(), car.getModel_id(), car.getDate());
		int status=db.createOrUpdateOrDelete(querry_insert);
		System.out.println(status);
		
		db.disconnect();
	}
	public static void CreatePiesa(Piesa piesa, Database db) throws SQLException {
		
		db.connect();
		int uz;
		if(piesa.getUzuraNou()) {
			uz = 1;
		}else {
			uz =0;
		}
		System.out.println(piesa.getIdProducator());
		String querry_insert = String.format("INSERT INTO `piese` (`id_piesa`, `name`, `count`, `producator`, `price`, `uzura_nou`, `date`) VALUES (NULL, '%s', '%d', '%d', '%d', '%d', '%s')", piesa.getName(), piesa.getCount(), piesa.getIdProducator(),piesa.getPrice(),uz, piesa.getData());
		int status=db.createOrUpdateOrDelete(querry_insert);
//		System.out.println(status);
		
		db.disconnect();
	}
	
	
	
	}
