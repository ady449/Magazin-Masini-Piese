package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import Clase.Util;
/**
 *  frame-ul ce poate fi vazut de oricine detine aplicatia fara sa se logheze intr-un fel.
 * @author Adi
 *
 */
public class Frame3 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame3 frame = new Frame3();
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
	public Frame3() {
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
		gbl_contentPane.rowHeights = new int[]{123, 655, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel TopPanel = new JPanel();
		TopPanel.setMinimumSize(new Dimension(400, 120));
		TopPanel.setBackground(new Color(30, 59, 44));
		GridBagConstraints gbc_TopPanel = new GridBagConstraints();
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
		NavBar.setBackground(new Color(88, 128, 107));
		GridBagConstraints gbc_NavBar = new GridBagConstraints();
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
		
		JLabel lblNewLabel_2_1 = new JLabel("Contact");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ContactButton.add(lblNewLabel_2_1);
		
		JPanel LoginButton = new JPanel();
		LoginButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new FrameLogin().setVisible(true);
				dispose();
			}
		});
		LoginButton.setBackground(new Color(232, 220, 185));
		NavBar.add(LoginButton);
		
		JLabel Login = new JLabel("Login & Sign up");
		Login.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		LoginButton.add(Login);
		
		
		JLabel lblNewLabel_1 = new JLabel("Add Item");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNewLabel_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		
		
		
		JPanel ItemContainer = new JPanel();
		ItemContainer.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		ItemContainer.setBorder(new CompoundBorder());
		ItemContainer.setBackground(new Color(195, 219, 197));
		GridBagConstraints gbc_ItemContainer = new GridBagConstraints();
		gbc_ItemContainer.fill = GridBagConstraints.BOTH;
		gbc_ItemContainer.gridx = 1;
		gbc_ItemContainer.gridy = 1;
		contentPane.add(ItemContainer, gbc_ItemContainer);
		ItemContainer.setLayout(new GridLayout(3, 4, 5, 5));
		Util.RendItemsWithoutDelete(true, "afisare", ItemContainer);
		Util.RendItemsWithoutDelete(false, "afisare", ItemContainer);
		
		
		
	}
	
	

	public static void CreateItem(String name, int pret, int count, JPanel IC) {
		JPanel Item = new JPanel();
		Item.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
		flowLayout_2.setVgap(30);
		flowLayout_2.setHgap(10);
		panel_4.setBackground(new Color(157, 138, 118));
		Item.add(panel_4);
		
		
		JLabel lblNewLabel_4 = new JLabel("pret: "+ pret);
		panel_4.add(lblNewLabel_4, BorderLayout.SOUTH);
		
		JLabel count1 = new JLabel("Count: "+ count);
		panel_4.add(count1, BorderLayout.WEST);
		
		JLabel lblNewLabel_3 = new JLabel(name);
		panel_4.add(lblNewLabel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.GREEN);
		Item.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		
		
		JButton Delete_1 = new JButton("Delete item");
		Delete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var panel =(Component) e.getSource();
				Container parent = panel.getParent();
				var grandparent = parent.getParent();
				var ggparent = grandparent.getParent();
				
				ggparent.remove(grandparent);
				ggparent.getParent().revalidate();
				ggparent.getParent().repaint();
			}
		});
		Delete_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_5.add(Delete_1);
		
		IC.add(Item);
	
		
		
	}
}
