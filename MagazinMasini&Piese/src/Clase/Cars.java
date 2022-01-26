package Clase;

import java.util.Date;
/**
 * Clasa Cars derivata din clasa Item
 * @author Adi
 *
 */
public class Cars extends Item {
	int id_car;
	int numberOfkm;
	String description; 
	int model_id;
	Date date;
	/**
	 * Clasa Cars reprezinta datele unei masini din aplicatie
	 * @param id_car id-ul masinii
	 * @param name	numele
	 * @param count	cate obiecte de acelasi fel sunt in baza de date
	 * @param price pretul
	 * @param numberOfkm numarul de km al masinii
	 * @param description masina poate avea sau nu o descriere
	 * @param model_id modelul masinii
	 * @param date data cand a fost fabricata
	 */
	public Cars(int id_car, String name, int count, int price,  int numberOfkm, String description, int model_id,
			Date date) {
		super(name, price, count);
		this.id_car = id_car;
		this.numberOfkm = numberOfkm;
		this.description = description;
		this.model_id = model_id;
		this.date = date;
	}

	public Cars() {
		this.id_car = 0;
		this.name = "";
		this.count = 0;
		this.price = 0;
		this.numberOfkm = 0;
		this.description = "";
		this.model_id = 0;
		this.date= new java.util.Date();
	}
 
	public int getId_car() {
		return id_car;
	}

	public int getNumberOfkm() {
		return numberOfkm;
	}

	public String getDescription() {
		return description;
	}

	public int getModel_id() {
		return model_id;
	}

	public Date getDate() {
		return date;
	}

	public void setId_car(int id_car) {
		this.id_car = id_car;
	}

	public void setNumberOfkm(int numberOfkm) {
		this.numberOfkm = numberOfkm;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}

	public void setDate(Date date) {
		this.date = date;
	}

//	@Override
//	public String toString() {
//		return "Cars [id_car=" + id_car +super.toString()+ ", numberOfkm=" + numberOfkm + ", description=" + description + ", model_id="
//				+ model_id + ", date=" + date + "]";
//	}

	
	
	
	
	
	
	
	
	
	
	
//	public Cars() {
//		this.id_car = 0;
//		this.name = "";
//		this.count = 0;
//		this.price = 0;
//		this.numberOfkm = 0;
//		this.description = "";
//		this.model_id = 0;
//		this.date= new java.util.Date();
//	}
	

}
