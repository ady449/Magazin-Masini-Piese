package Clase;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import Conne.Database;

/**
 * In aceasta clasa sunt functii create pentru diverse folosinte , in special functii pentru afisarea
 * obiectelor. 
 * 
 * @author Adi
 *
 */
public class Util {
	
	public static List<Item> RendItems(boolean Tip, String Afisare, JPanel IC) {
		/**
		 * Functia este folosita in frame-ul 1.
		 */
		Database db = new Database();
		List<Item> items = new ArrayList<Item>();
	
		
		if(Tip == true) {
			String querry = "SELECT * FROM cars";
			try {
				db.connect();
				
				ResultSet result = db.select(querry);
				
				while(result.next()) {
					final int idcar= result.getInt("id_car");
					items.add(new Cars(idcar, result.getString("name"),result.getInt("count"), result.getInt("price"), result.getInt("numberOfkm"), result.getString("Description"), result.getInt("model_id"), result.getDate("date")));
					if(Afisare == "afisare") {
						JPanel Item = new JPanel();
						Item.setLayout(new GridLayout(0, 1, 0, 0));
						
						JPanel panel_4 = new JPanel();
						FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
						flowLayout_2.setVgap(30);
						flowLayout_2.setHgap(10);
						panel_4.setBackground(new Color(157, 138, 118));
						Item.add(panel_4);
						
						JLabel lblNewLabel_4 = new JLabel("pret: "+ result.getInt("price"));
						panel_4.add(lblNewLabel_4, BorderLayout.SOUTH);
						
						JLabel count1 = new JLabel("Count: "+ result.getInt("count"));
						panel_4.add(count1, BorderLayout.WEST);
						
						JLabel lblNewLabel_3 = new JLabel(result.getString("name"));
						panel_4.add(lblNewLabel_3);
						
						JPanel panel_5 = new JPanel();
						panel_5.setBackground(Color.GREEN);
						Item.add(panel_5);
						panel_5.setLayout(new GridLayout(0, 1, 0, 0));
						
						
						JButton Delete_1 = new JButton("Delete item");
						Delete_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								
								try {
									
									String delquery = "DELETE FROM `cars` WHERE `cars`.`id_car` = "+ idcar;
									var panel =(Component) e.getSource();
									Container parent = panel.getParent();
									var grandparent = parent.getParent();
									var ggparent = grandparent.getParent();
									int status=db.createOrUpdateOrDelete(delquery);
									System.out.println(status);
									
									ggparent.remove(grandparent);
									ggparent.getParent().revalidate();
									ggparent.getParent().repaint();
									
									
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									System.out.println("aici ii bai");
									e1.printStackTrace();
								}
								
							}
						});
						Delete_1.setAlignmentX(Component.CENTER_ALIGNMENT);
						panel_5.add(Delete_1);
						
						IC.add(Item);
						IC.revalidate();
						IC.repaint();
						
					}
				

				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}else {
			String querry = "SELECT * FROM piese";
			try {
				db.connect();
				
				ResultSet result = db.select(querry);
				
				while(result.next()) {
					final int idcar= result.getInt("id_piesa");
					Piesa p = new Piesa(idcar, result.getString("name"),result.getInt("count"), result.getInt("price"), result.getInt("producator"), result.getBoolean("uzura_nou"), result.getDate("date"));
					items.add(p);
					if(Afisare == "afisare") {
						JPanel Item = new JPanel();
						Item.setLayout(new GridLayout(0, 1, 0, 0));
						
						JPanel panel_4 = new JPanel();
						FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
						flowLayout_2.setVgap(30);
						flowLayout_2.setHgap(10);
						panel_4.setBackground(new Color(157, 138, 118));
						Item.add(panel_4);
						
						JLabel lblNewLabel_4 = new JLabel("pret: "+ p.getPrice());
						panel_4.add(lblNewLabel_4, BorderLayout.SOUTH);
						
						JLabel count1 = new JLabel("Count: "+ p.getCount());
						panel_4.add(count1, BorderLayout.WEST);
						
						JLabel lblNewLabel_3 = new JLabel(p.getName());
						panel_4.add(lblNewLabel_3);
						
						JPanel panel_5 = new JPanel();
						panel_5.setBackground(Color.GREEN);
						Item.add(panel_5);
						panel_5.setLayout(new GridLayout(0, 1, 0, 0));
						
						
						JButton Delete_1 = new JButton("Delete item");
						Delete_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								
								try {
									
									String delquery = "DELETE FROM `piese` WHERE `piese`.`id_piesa` = "+ idcar;
									var panel =(Component) e.getSource();
									Container parent = panel.getParent();
									var grandparent = parent.getParent();
									var ggparent = grandparent.getParent();
									int status=db.createOrUpdateOrDelete(delquery);
									System.out.println(status);
									
									ggparent.remove(grandparent);
									ggparent.getParent().revalidate();
									ggparent.getParent().repaint();
									
									
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									System.out.println("aici ii bai");
									e1.printStackTrace();
								}
//							db.disconnect();
								
//						SwingUtilities.updateComponentTreeUI(ggparent.getParent());
							}
						});
						Delete_1.setAlignmentX(Component.CENTER_ALIGNMENT);
						panel_5.add(Delete_1);
						
						IC.add(Item);
						IC.revalidate();
						IC.repaint();
						
						
					}
						
					}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		return items;

		
	}
		
	
	public static List<Item> RendItems3(boolean Tip, String Afisare, JPanel IC, JPanel ContinutCos) {
		/**
		 * Functia 
		 */
		Database db = new Database();
		List<Item> items = new ArrayList<Item>();
		List<Item> ic = new ArrayList<Item>();
		
		if(Tip == true) {
			String querry = "SELECT * FROM cars";
			try {
				db.connect();
				
				ResultSet result = db.select(querry);
				
				while(result.next()) {
					final int idcar= result.getInt("id_car");
					Cars car= (new Cars(idcar, result.getString("name"),result.getInt("count"), result.getInt("price"), result.getInt("numberOfkm"), result.getString("Description"), result.getInt("model_id"), result.getDate("date")));
					items.add(car);
					if(Afisare == "afisare") {
						JPanel Item = new JPanel();
						Item.setLayout(new GridLayout(0, 1, 0, 0));
						
						JPanel panel_2_1 = new JPanel();
						panel_2_1.setBackground(new Color(157, 138, 118));
						Item.add(panel_2_1);
						panel_2_1.setLayout(new GridLayout(4, 8, 0, 0));
						
						JLabel label = new JLabel("");
						panel_2_1.add(label);
						
						JLabel label_1 = new JLabel("");
						panel_2_1.add(label_1);
						
						JLabel lblNewLabel_2 = new JLabel("Nume: "+ car.getName());
						lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_2);
						
						JLabel label_9 = new JLabel("");
						panel_2_1.add(label_9);
						
						JLabel label_7 = new JLabel("");
						panel_2_1.add(label_7);
						
						JLabel label_2 = new JLabel("");
						panel_2_1.add(label_2);
						
						JLabel label_3 = new JLabel("");
						panel_2_1.add(label_3);
						
						JLabel label_4 = new JLabel("");
						panel_2_1.add(label_4);
						
						JLabel label_5 = new JLabel("");
						panel_2_1.add(label_5);
						
						JLabel label_6 = new JLabel("");
						panel_2_1.add(label_6);
						
						JLabel lblNewLabel_14 = new JLabel("Marca: ");
						lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_14);
						
						JLabel label_8 = new JLabel("");
						panel_2_1.add(label_8);
						
						JLabel lblNewLabel_10 = new JLabel("Pret: "+ car.getPrice());
						lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_10);
						
						JLabel label_8_2 = new JLabel("");
						panel_2_1.add(label_8_2);
						
						JLabel lblNewLabel_12 = new JLabel("Data fabricatiei: "+ car.getDate());
						lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_12);
						
						JLabel lblNewLabel_15 = new JLabel("Model: "+ car.getModel_id());
						lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_15);
						
						JLabel label_8_1 = new JLabel("");
						panel_2_1.add(label_8_1);
						
						JLabel lblNewLabel_11 = new JLabel("Descriere: "+car.getDescription());
						lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_11);
						
						JLabel label_10 = new JLabel("");
						panel_2_1.add(label_10);
						
						JLabel lblNewLabel_13 = new JLabel("Km: "+ car.getNumberOfkm());
						lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_13);
						
						JPanel panel_4_1_1 = new JPanel();
						panel_4_1_1.setBackground(new Color(157, 138, 118));
						panel_4_1_1.setLayout(new GridLayout(0, 3, 0, 0));
						Item.add(panel_4_1_1);
						
						JPanel panel_6 = new JPanel();
						panel_6.setBackground(new Color(157, 138, 118));
						panel_4_1_1.add(panel_6);
						
						JButton btnNewButton = new JButton("Adauga cos");
						panel_4_1_1.add(btnNewButton);
						
						
						btnNewButton.addActionListener(new ActionListener() { // buton aduaga cos
							
							public void actionPerformed(ActionEvent e) {
								
								var panel =(Component) e.getSource();
								
								Container parent = panel.getParent();
								var gparent = parent.getParent();
								var ggparent = gparent.getParent();
								var gggparent = ggparent.getParent();
								
								ItemCos(car,ContinutCos);
//								
								
								gggparent.getParent().revalidate();
								gggparent.getParent().repaint();
							}
						});
						
						
						
						IC.add(Item);
						IC.revalidate();
						IC.repaint();
						
					}
				

				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}else {
			String querry = "SELECT * FROM piese";
			try {
				db.connect();
				
				ResultSet result = db.select(querry);
				
				while(result.next()) {
					final int idcar= result.getInt("id_piesa");
					String querry2 = String.format("SELECT `manufacturer_name` FROM manufacturer inner JOIN piese on piese.producator= id where piese.id_piesa =%d", idcar);
					ResultSet result2 =db.select(querry2);
					var producator = "";
					while(result2.next()) {
						 producator=result2.getString("manufacturer_name");	
					}
					Piesa piesa =new Piesa(idcar, result.getString("name"),result.getInt("count"), result.getInt("price"), result.getInt("producator"), result.getBoolean("uzura_nou"), result.getDate("date"));
					items.add(piesa);
					if(Afisare == "afisare") {
						JPanel Item = new JPanel();
						Item.setLayout(new GridLayout(0, 1, 0, 0));
						
						JPanel panel_2_1 = new JPanel();
						panel_2_1.setBackground(new Color(157, 138, 118));
						Item.add(panel_2_1);
						panel_2_1.setLayout(new GridLayout(4, 3, 0, 5));
						
						JLabel label = new JLabel("");
						panel_2_1.add(label);
						
			
						JLabel lblNewLabel_2 = new JLabel("Nume: "+ piesa.getName());
						lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_2);
						
						JLabel label_9 = new JLabel("");
						panel_2_1.add(label_9);
						
						JLabel label_7 = new JLabel("");
						panel_2_1.add(label_7);
						
						JLabel label_2 = new JLabel("");
						panel_2_1.add(label_2);
						
						JLabel label_3 = new JLabel("");
						panel_2_1.add(label_3);
						
						JLabel lblNewLabel_10 = new JLabel("Pret: "+ piesa.getPrice());
						lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_10);
						
						JLabel lblNewLabel_15 = new JLabel("Marca:"+ producator );
						lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_15);
						
						JLabel lblNewLabel_12 = new JLabel("Data: "+ piesa.getData());
						lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_12);
						
						JLabel lblNewLabel_13 = new JLabel("Numar: "+ piesa.getCount());
						lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_13);
						
						JLabel label_4 = new JLabel("");
						panel_2_1.add(label_4);
						
						JLabel lblNewLabel_11 = new JLabel("Este nou: "+piesa.getUzuraNou());
						lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_11);
						
						
						JPanel panel_4_1_1 = new JPanel();
						panel_4_1_1.setBackground(new Color(157, 138, 118));
						panel_4_1_1.setLayout(new GridLayout(0, 3, 0, 0));
						Item.add(panel_4_1_1);
						
						JPanel panel_6 = new JPanel();
						panel_6.setBackground(new Color(157, 138, 118));
						panel_4_1_1.add(panel_6);
						
						JButton btnNewButton = new JButton("Adauga cos");
						panel_4_1_1.add(btnNewButton);
						
						

						btnNewButton.addActionListener(new ActionListener() { // buton aduaga cos
							
							public void actionPerformed(ActionEvent e) {
								
								var panel =(Component) e.getSource();
								
								Container parent = panel.getParent();
								var gparent = parent.getParent();
								var ggparent = gparent.getParent();
								var gggparent = ggparent.getParent();
								
								ItemCos(piesa,ContinutCos);
//								gparent.remove(parent);
								
								gggparent.getParent().revalidate();
								gggparent.getParent().repaint();
							}
						});
						
						IC.add(Item);
						IC.revalidate();
						IC.repaint();
						
						
					}
						
					}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		return items;

		
	}
	
	/**
	 * 
	 * @param Tip daca Tip primeste valoarea "true" atunci se vor afisa obiectele tip Cars, iar daca primeste "false",
	 * se vor afisa obictele tip Piesa.
	 * @param Afisare daca Afisare primeste "afisare" atunci va afisa itemele si le va returna intr-o lista de obiect Item, atfel va returna doar aceste obiecte.
	 * 
	 * @param IC locul unde se vor afisa itemele.
	 * @param ContinutCos locul in care va trimite functia obiectele la apasarea butonului "adauga cos".
	 * @return List<Item>
	 */
	public static List<Item> RendItems2(boolean Tip, String Afisare, JPanel IC, JPanel ContinutCos) {
		/**
		 * Functia 
		 */
		Database db = new Database();
		List<Item> items = new ArrayList<Item>();
		List<Item> ic = new ArrayList<Item>();
		
		if(Tip == true) {
			String querry = "SELECT * FROM cars";
			try {
				db.connect();
				
				ResultSet result = db.select(querry);
				
				while(result.next()) {
					final int idcar= result.getInt("id_car");
					Cars car= (new Cars(idcar, result.getString("name"),result.getInt("count"), result.getInt("price"), result.getInt("numberOfkm"), result.getString("Description"), result.getInt("model_id"), result.getDate("date")));
					items.add(car);
					if(Afisare == "afisare") {
						JPanel Item = new JPanel();
						Item.setLayout(new GridLayout(0, 1, 0, 0));
						
						JPanel panel_2_1 = new JPanel();
						panel_2_1.setBackground(new Color(157, 138, 118));
						Item.add(panel_2_1);
						panel_2_1.setLayout(new GridLayout(4, 8, 0, 0));
						
						JLabel label = new JLabel("");
						panel_2_1.add(label);
						
						JLabel label_1 = new JLabel("");
						panel_2_1.add(label_1);
						
						JLabel lblNewLabel_2 = new JLabel("Nume: "+ car.getName());
						lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_2);
						
						JLabel label_9 = new JLabel("");
						panel_2_1.add(label_9);
						
						JLabel label_7 = new JLabel("");
						panel_2_1.add(label_7);
						
						JLabel label_2 = new JLabel("");
						panel_2_1.add(label_2);
						
						JLabel label_3 = new JLabel("");
						panel_2_1.add(label_3);
						
						JLabel label_4 = new JLabel("");
						panel_2_1.add(label_4);
						
						JLabel label_5 = new JLabel("");
						panel_2_1.add(label_5);
						
						JLabel label_6 = new JLabel("");
						panel_2_1.add(label_6);
						
						JLabel lblNewLabel_14 = new JLabel("Marca: ");
						lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_14);
						
						JLabel label_8 = new JLabel("");
						panel_2_1.add(label_8);
						
						JLabel lblNewLabel_10 = new JLabel("Pret: "+ car.getPrice());
						lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_10);
						
						JLabel label_8_2 = new JLabel("");
						panel_2_1.add(label_8_2);
						
						JLabel lblNewLabel_12 = new JLabel("Data fabricatiei: "+ car.getDate());
						lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_12);
						
						JLabel lblNewLabel_15 = new JLabel("Model: "+ car.getModel_id());
						lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_15);
						
						JLabel label_8_1 = new JLabel("");
						panel_2_1.add(label_8_1);
						
						JLabel lblNewLabel_11 = new JLabel("Descriere: "+car.getDescription());
						lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_11);
						
						JLabel label_10 = new JLabel("");
						panel_2_1.add(label_10);
						
						JLabel lblNewLabel_13 = new JLabel("Km: "+ car.getNumberOfkm());
						lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_13);
						
						JPanel panel_4_1_1 = new JPanel();
						panel_4_1_1.setBackground(Color.GRAY);
						panel_4_1_1.setLayout(new GridLayout(0, 3, 0, 0));
						Item.add(panel_4_1_1);
						
						JButton Delete_1 = new JButton("Delete item");
						Delete_1.setBackground(Color.ORANGE);
						Delete_1.setAlignmentX(0.5f);
						panel_4_1_1.add(Delete_1);
						
						JPanel panel_6 = new JPanel();
						panel_6.setBackground(new Color(157, 138, 118));
						panel_4_1_1.add(panel_6);
						
						JButton btnNewButton = new JButton("Adauga cos");
						panel_4_1_1.add(btnNewButton);
						
						
//						JButton Delete_1 = new JButton("Delete item");
						Delete_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								
								try {
									
									String delquery = "DELETE FROM `cars` WHERE `cars`.`id_car` = "+ idcar;
									var panel =(Component) e.getSource();
									Container parent = panel.getParent();
									var grandparent = parent.getParent();
									var ggparent = grandparent.getParent();
									int status=db.createOrUpdateOrDelete(delquery);
									System.out.println(status);
									
									ggparent.remove(grandparent);
									ggparent.getParent().revalidate();
									ggparent.getParent().repaint();
									
									
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									System.out.println("aici ii bai");
									e1.printStackTrace();
								}
								
							}
						});
						Delete_1.setAlignmentX(Component.CENTER_ALIGNMENT);
//						Item.add(Delete_1);
						
						
						btnNewButton.addActionListener(new ActionListener() { // buton aduaga cos
							
							public void actionPerformed(ActionEvent e) {
								
								var panel =(Component) e.getSource();
								
								Container parent = panel.getParent();
								var gparent = parent.getParent();
								var ggparent = gparent.getParent();
								var gggparent = ggparent.getParent();
								
								ItemCos(car,ContinutCos);
//								
								
								gggparent.getParent().revalidate();
								gggparent.getParent().repaint();
							}
						});
						
						
						
						IC.add(Item);
						IC.revalidate();
						IC.repaint();
						
					}
				

				}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}else {
			String querry = "SELECT * FROM piese";
			try {
				db.connect();
				
				ResultSet result = db.select(querry);
				
				while(result.next()) {
					final int idcar= result.getInt("id_piesa");
					String querry2 = String.format("SELECT `manufacturer_name` FROM manufacturer inner JOIN piese on piese.producator= id where piese.id_piesa =%d", idcar);
					ResultSet result2 =db.select(querry2);
					var producator = "";
					while(result2.next()) {
						 producator=result2.getString("manufacturer_name");	
					}
					Piesa piesa =new Piesa(idcar, result.getString("name"),result.getInt("count"), result.getInt("price"), result.getInt("producator"), result.getBoolean("uzura_nou"), result.getDate("date"));
					items.add(piesa);
					if(Afisare == "afisare") {
						JPanel Item = new JPanel();
						Item.setLayout(new GridLayout(0, 1, 0, 0));
						
						JPanel panel_2_1 = new JPanel();
						panel_2_1.setBackground(new Color(157, 138, 118));
						Item.add(panel_2_1);
						panel_2_1.setLayout(new GridLayout(4, 3, 0, 5));
						
						JLabel label = new JLabel("");
						panel_2_1.add(label);
						
			
						JLabel lblNewLabel_2 = new JLabel("Nume: "+ piesa.getName());
						lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_2);
						
						JLabel label_9 = new JLabel("");
						panel_2_1.add(label_9);
						
						JLabel label_7 = new JLabel("");
						panel_2_1.add(label_7);
						
						JLabel label_2 = new JLabel("");
						panel_2_1.add(label_2);
						
						JLabel label_3 = new JLabel("");
						panel_2_1.add(label_3);
						
						JLabel lblNewLabel_10 = new JLabel("Pret: "+ piesa.getPrice());
						lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_10);
						
						JLabel lblNewLabel_15 = new JLabel("Marca:"+ producator );
						lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_15);
						
						JLabel lblNewLabel_12 = new JLabel("Data: "+ piesa.getData());
						lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_12);
						
						JLabel lblNewLabel_13 = new JLabel("Numar: "+ piesa.getCount());
						lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_13);
						
						JLabel label_4 = new JLabel("");
						panel_2_1.add(label_4);
						
						JLabel lblNewLabel_11 = new JLabel("Este nou: "+piesa.getUzuraNou());
						lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_11);
						
						
						JPanel panel_4_1_1 = new JPanel();
						panel_4_1_1.setBackground(Color.GRAY);
						panel_4_1_1.setLayout(new GridLayout(0, 3, 0, 0));
						Item.add(panel_4_1_1);
						
						JButton Delete_1 = new JButton("Delete item");
						Delete_1.setBackground(Color.ORANGE);
						Delete_1.setAlignmentX(0.5f);
						panel_4_1_1.add(Delete_1);
						
						JPanel panel_6 = new JPanel();
						panel_6.setBackground(new Color(157, 138, 118));
						panel_4_1_1.add(panel_6);
						
						JButton btnNewButton = new JButton("Adauga cos");
						panel_4_1_1.add(btnNewButton);
						
						
						
						Delete_1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								
								try {
									
									String delquery = "DELETE FROM `piese` WHERE `piese`.`id_piesa` = "+ idcar;
									var panel =(Component) e.getSource();
									Container parent = panel.getParent();
									var grandparent = parent.getParent();
									var ggparent = grandparent.getParent();
									int status=db.createOrUpdateOrDelete(delquery);
									System.out.println(status);
									
									ggparent.remove(grandparent);
									ggparent.getParent().revalidate();
									ggparent.getParent().repaint();
									
									
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									System.out.println("aici ii bai");
									e1.printStackTrace();
								}


							}
						});
						Delete_1.setAlignmentX(Component.CENTER_ALIGNMENT);
//						panel_5.add(Delete_1);
						
						

						btnNewButton.addActionListener(new ActionListener() { // buton aduaga cos
							
							public void actionPerformed(ActionEvent e) {
								
								var panel =(Component) e.getSource();
								
								Container parent = panel.getParent();
								var gparent = parent.getParent();
								var ggparent = gparent.getParent();
								var gggparent = ggparent.getParent();
								
								ItemCos(piesa,ContinutCos);
//								gparent.remove(parent);
								
								gggparent.getParent().revalidate();
								gggparent.getParent().repaint();
							}
						});
						
						IC.add(Item);
						IC.revalidate();
						IC.repaint();
						
						
					}
						
					}
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
		}
		return items;

		
	}

	/**
	 * 
	 * @param Tip Tip daca Tip primeste valoarea "true" atunci se vor afisa obiectele tip Cars, iar daca primeste "false",
	 * se vor afisa obictele tip Piesa.
	 * @param Afisare  Afisare daca Afisare primeste "afisare" atunci va afisa itemele si le va returna intr-o lista de obiect Item, atfel va returna doar aceste obiecte.
	 * 
	 * @param IC locul unde se vor afisa itemele.
	 * @return va afisa obiectele fara butonul delete si va returna o lista de obiecte Item
	 */
	public static List<Item> RendItemsWithoutDelete(boolean Tip, String Afisare, JPanel IC) {
	
	Database db = new Database();
	List<Item> items = new ArrayList<Item>();

	
	if(Tip == true) {
		String querry = "SELECT * FROM cars";
		try {
			db.connect();
			
			ResultSet result = db.select(querry);
			
			while(result.next()) {
				final int idcar= result.getInt("id_car");
				Cars car= (new Cars(idcar, result.getString("name"),result.getInt("count"), result.getInt("price"), result.getInt("numberOfkm"), result.getString("Description"), result.getInt("model_id"), result.getDate("date")));
				items.add(car);
				
//				if(Afisare == "afisare") {
//					JPanel Item = new JPanel();
//					Item.setLayout(new GridLayout(0, 1, 0, 0));
//					
//					JPanel panel_4 = new JPanel();
//					FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
//					flowLayout_2.setVgap(30);
//					flowLayout_2.setHgap(10);
//					panel_4.setBackground(new Color(157, 138, 118));
//					Item.add(panel_4);
//					
//					JLabel lblNewLabel_4 = new JLabel("pret: "+ result.getInt("price"));
//					panel_4.add(lblNewLabel_4, BorderLayout.SOUTH);
//					
//					JLabel count1 = new JLabel("Count: "+ result.getInt("count"));
//					panel_4.add(count1, BorderLayout.WEST);
//					
//					JLabel lblNewLabel_3 = new JLabel(result.getString("name"));
//					panel_4.add(lblNewLabel_3);
					
					
					if(Afisare.equals("afisare")) {
						JPanel Item = new JPanel();
						Item.setLayout(new GridLayout(0, 1, 0, 0));
						
						JPanel panel_2_1 = new JPanel();
						panel_2_1.setBackground(new Color(157, 138, 118));
						Item.add(panel_2_1);
						panel_2_1.setLayout(new GridLayout(4, 3, 0, 0));
						
						JLabel label = new JLabel("");
						panel_2_1.add(label);
						
//						JLabel label_1 = new JLabel("");
//						panel_2_1.add(label_1);
						
						JLabel lblNewLabel_2 = new JLabel("Nume: "+ car.getName());
						lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_2);
						
						JLabel label_9 = new JLabel("");
						panel_2_1.add(label_9);
//						
						JLabel label_7 = new JLabel("");
						panel_2_1.add(label_7);
//						
						JLabel label_2 = new JLabel("");
						panel_2_1.add(label_2);
						
						JLabel label_3 = new JLabel("");
						panel_2_1.add(label_3);
//						
//						JLabel label_4 = new JLabel("");
//						panel_2_1.add(label_4);
//						
//						JLabel label_5 = new JLabel("");
//						panel_2_1.add(label_5);
//						
//						JLabel label_6 = new JLabel("");
//						panel_2_1.add(label_6);
						
						JLabel lblNewLabel_14 = new JLabel("Marca: ");
						lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_14);
						
//						JLabel label_8 = new JLabel("");
//						panel_2_1.add(label_8);
						
						JLabel lblNewLabel_10 = new JLabel("Pret: "+ car.getPrice());
						lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_10);
						
//						JLabel label_8_2 = new JLabel("");
//						panel_2_1.add(label_8_2);
						
						JLabel lblNewLabel_12 = new JLabel("Data:"+ car.getDate());
						lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_12);
						
						JLabel lblNewLabel_15 = new JLabel("Model: "+ car.getModel_id());
						lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_15);
						
//						JLabel label_8_1 = new JLabel("");
//						panel_2_1.add(label_8_1);
//						
						JLabel lblNewLabel_11 = new JLabel("Descriere: "+car.getDescription());
						lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_11);
						
//						JLabel label_10 = new JLabel("");
//						panel_2_1.add(label_10);
						
						JLabel lblNewLabel_13 = new JLabel("Km: "+ car.getNumberOfkm());
						lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
						panel_2_1.add(lblNewLabel_13);
						

					IC.add(Item);
					IC.revalidate();
					IC.repaint();
					
				}
			

			}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}else {
		String querry = "SELECT * FROM piese";
		try {
			db.connect();
			
			ResultSet result = db.select(querry);
			
			while(result.next()) {
				final int idcar= result.getInt("id_piesa");
				Piesa p = new Piesa(idcar, result.getString("name"),result.getInt("count"), result.getInt("price"), result.getInt("producator"), result.getBoolean("uzura_nou"), result.getDate("date"));
				items.add(p);
				if(Afisare == "afisare") {
					JPanel Item = new JPanel();
					Item.setLayout(new GridLayout(0, 1, 0, 0));
					
					JPanel panel_4 = new JPanel();
					FlowLayout flowLayout_2 = (FlowLayout) panel_4.getLayout();
					flowLayout_2.setVgap(30);
					flowLayout_2.setHgap(10);
					panel_4.setBackground(new Color(157, 138, 118));
					Item.add(panel_4);
					
					JLabel lblNewLabel_4 = new JLabel("Pret: "+ p.getPrice());
					panel_4.add(lblNewLabel_4, BorderLayout.SOUTH);
					
					JLabel count1 = new JLabel("Count: "+ p.getCount());
					panel_4.add(count1, BorderLayout.WEST);
					
					JLabel lblNewLabel_3 = new JLabel(p.getName());
					panel_4.add(lblNewLabel_3);
					
	
					IC.add(Item);
					IC.revalidate();
					IC.repaint();
					
					
				}
					
				}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
	}
	return items;

	
}

	/**
	 * 
	 * @param item un obiect
	 * @param ContinutCos
	 * 
	 */
	public static void ItemCos (Item item, JPanel ContinutCos) {
		/**
		 * afiseaza itemele in cos
		 */
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
	
	JLabel lblNewLabel_5 = new JLabel("Nume: "+ item.getName());
	lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
	panel_4.add(lblNewLabel_5);
	
	JLabel lblNewLabel_7 = new JLabel("Cantitate: "+ item.getCount());
	lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
	panel_4.add(lblNewLabel_7);
	
	JLabel lblNewLabel_6 = new JLabel("Pret(ron): "+ item.getPrice());
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
			
			var panel =(Component) e.getSource();
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
	/**
	 * 
	 * @param car
	 * @param IC
	 * @param db
	 * @throws SQLException
	 */
	public static void CreateItem(Cars car, JPanel IC, Database db) throws SQLException {
		
		
		db.connect();
		
		String querry_insert = String.format("INSERT INTO `cars` (`id_car`, `name`, `count`, `price`, `numberOfkm`, `Description`, `model_id`, `date_id`) VALUES (NULL, '%s', '%d', '%d', '%d', '%s', '%d', '%d')", car.getName(), car.getCount(), car.getPrice(), car.getNumberOfkm(), car.getDescription(), 2, 1);
		int status=db.createOrUpdateOrDelete(querry_insert);
		System.out.println(status);
		db.disconnect();
	
		
	}
}
