package Clase;
/**
 *	Item este clasa de baza a claselor Cars si Piesa
 * @author Adi
 *
 */
public class Item {
	String name;
	int price;
	int count;
	/**
	 * 
	 * @param name numele obiectului
	 * @param price pretul
	 * @param count numarul de obiecte
	 */
	public Item(String name, int price, int count) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
	}
	public Item() {
		this.name ="";
		this.price = 0;
		this.count =0;
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getCount() {
		return count;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "name=" + name + ", price=" + price + ", count=" + count;
	}
}
