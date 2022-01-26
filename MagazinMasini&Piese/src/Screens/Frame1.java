package Screens;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import Clase.Util;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.ComponentOrientation;
import javax.swing.border.CompoundBorder;
import java.awt.Dimension;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Cursor;
import javax.swing.JPasswordField;
/**
 * frame-ul atunci cand este logat adminul.
 * @author Adi
 *
 */
public class Frame1 extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 frame = new Frame1();
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
	public Frame1() throws SQLException {
		
		
		
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
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setMinimumSize(new Dimension(100, 100));
		panel_3.setBackground(new Color(30, 59, 44));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
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
		NavBar.setBackground(new Color(88, 128, 107));
		GridBagConstraints gbc_NavBar = new GridBagConstraints();
		gbc_NavBar.fill = GridBagConstraints.BOTH;
		gbc_NavBar.gridx = 0;
		gbc_NavBar.gridy = 1;
		contentPane.add(NavBar, gbc_NavBar);
		NavBar.setLayout(new GridLayout(10, 1, 10, 5));
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
		
		
		JLabel lblNewLabel_1 = new JLabel("Add Item");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		
		
		JPanel ItemContainer = new JPanel();
		ItemContainer.setAlignmentX(Component.RIGHT_ALIGNMENT);
		ItemContainer.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		ItemContainer.setBorder(new CompoundBorder());
		ItemContainer.setBackground(new Color(195, 219, 197));
		GridBagConstraints gbc_ItemContainer = new GridBagConstraints();
		gbc_ItemContainer.fill = GridBagConstraints.BOTH;
		gbc_ItemContainer.gridx = 1;
		gbc_ItemContainer.gridy = 1;
		contentPane.add(ItemContainer, gbc_ItemContainer);
		ItemContainer.setLayout(new GridLayout(3, 4, 5, 5));
			
		Util.RendItems(true, "afisare", ItemContainer);
		Util.RendItems(false, "afisare", ItemContainer);
		
		

		JPanel additempop = new JPanel();
		additempop.setBackground(new Color(232, 220, 185));
		additempop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					new AddItemFrame().setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
			}
		});
		NavBar.add(additempop);
		additempop.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel("Add item");
		lblNewLabel_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblNewLabel_1_1.setAlignmentX(0.5f);
		additempop.add(lblNewLabel_1_1, BorderLayout.CENTER);
		
		JPanel Logout = new JPanel();
		Logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Frame3().setVisible(true);
				dispose();
			}
		});
		Logout.setBackground(new Color(232, 220, 185));
		NavBar.add(Logout);
		Logout.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Logout");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		Logout.add(lblNewLabel_3);
				

	
	}
	

	}
