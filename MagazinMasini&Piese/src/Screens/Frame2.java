package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;

import Clase.Item;
import Clase.Util;

/**
 * frame-ul atunci cand este logat un utilizator fara contul de admin.
 * 
 * @author Adi
 *
 */
public class Frame2 extends JFrame {

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	protected static final Container ContinutCos = null;
	private JPanel contentPane;
	private JButton GolesteCos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame2 frame = new Frame2();
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
	public Frame2() {
		List<Item> items = Util.RendItems(true, "faraAfisare", null);
		for (Item i : Util.RendItems(false, "faraAfisare", null)) {
			items.add(i);
		}

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
		gbl_contentPane.columnWidths = new int[] { 253, 784 };
		gbl_contentPane.rowHeights = new int[] { 54, 655, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, 1.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel TopPanel = new JPanel();
		TopPanel.setMinimumSize(new Dimension(400, 100));
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
		NavBar.setMaximumSize(new Dimension(200, 32767));
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

				JOptionPane.showMessageDialog(null, "numberphone\n" + "Orar: L-V 08-17");
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
				new Frame3().setVisible(true);
				dispose();
			}
		});
		LoginButton.setBackground(new Color(232, 220, 185));
		NavBar.add(LoginButton);

		JLabel Logout = new JLabel("logout");
		Logout.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		LoginButton.add(Logout);

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
		ItemContainer.setLayout(new GridLayout(0, 1, 0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		ItemContainer.add(tabbedPane);

		JPanel Masini = new JPanel();
		Masini.setAlignmentX(Component.RIGHT_ALIGNMENT);
		Masini.setBackground(new Color(195, 200, 190));
		tabbedPane.addTab("Masini", null, Masini, null);

		Masini.setLayout(new GridLayout(3, 4, 5, 5));

		JPanel Piese = new JPanel();
		tabbedPane.addTab("Piese", null, Piese, null);
		Piese.setLayout(new GridLayout(3, 4, 10, 10));

		JPanel Cos = new JPanel();
		tabbedPane.addTab("Cos", null, Cos, null);
		Cos.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		Cos.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new GridLayout(1, 2, 5, 5));

		GolesteCos = new JButton("Goleste Cos");
		GolesteCos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var panel = (Container) e.getSource();
				Container parent = panel.getParent();
				var gparent = parent.getParent();

				Component[] comps = gparent.getComponents();
				Container elcomps = (Container) comps[1];
				Component[] comps2 = elcomps.getComponents();
				for (Component comp : comps2) {
					elcomps.remove(comp);
				}

				gparent.getParent().revalidate();
				gparent.getParent().repaint();
			}
		});

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		int suma = 0;

		panel.add(GolesteCos);

		JButton Cumpar = new JButton("Cumpara");
		Cumpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var panel = (Container) e.getSource();
				Container parent = panel.getParent();
				var gparent = parent.getParent();

				Component[] comps = gparent.getComponents();
				Container elcomps = (Container) comps[1];
				Component[] comps2 = elcomps.getComponents();
				for (Component comp : comps2) {
					elcomps.remove(comp);
				}

				gparent.getParent().revalidate();
				gparent.getParent().repaint();
			}
		});
		panel.add(Cumpar);

		JPanel ContinutCos = new JPanel();
//		List<Item> cosUser= new ArrayList<Item>();
		Util.RendItems3(true, "afisare", Masini, ContinutCos);
		Util.RendItems3(false, "afisare", Piese, ContinutCos);

		Cos.add(ContinutCos, BorderLayout.CENTER);
		ContinutCos.setLayout(new GridLayout(10, 1, 5, 5));

	}

	public void ItemCos(Item item, JPanel ContinutCos) {
		JPanel panel_1 = new JPanel();
		ContinutCos.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(238, 232, 170));
		panel_1.add(panel_4);
		panel_4.setLayout(new GridLayout(3, 4, 0, 0));

		JLabel lblNewLabel_8 = new JLabel("");
		panel_4.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("");
		panel_4.add(lblNewLabel_9);

		JLabel lblNewLabel_8_1 = new JLabel("");
		panel_4.add(lblNewLabel_8_1);

		JLabel lblNewLabel_5 = new JLabel("Nume: " + item.getName());
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_5);

		JLabel lblNewLabel_7 = new JLabel("Cantitate: " + item.getCount());
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_7);

		JLabel lblNewLabel_6 = new JLabel("Pret(ron): " + item.getPrice());
		panel_4.add(lblNewLabel_6);

		JLabel lblNewLabel_8_2 = new JLabel("");
		panel_4.add(lblNewLabel_8_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(238, 232, 170));
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		JButton btnNewButton_1 = new JButton("New button");
		panel_3.add(btnNewButton_1, BorderLayout.EAST);

		JButton DeleteItemButton = new JButton("Delete");
		DeleteItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				var panel = (Component) e.getSource();
				Container parent = panel.getParent();
				var gparent = parent.getParent();
				var ggparent = gparent.getParent();

				ggparent.remove(gparent);
				ggparent.getParent().revalidate();
				ggparent.getParent().repaint();
			}
		});
		panel_3.add(DeleteItemButton, BorderLayout.EAST);
	}
}
