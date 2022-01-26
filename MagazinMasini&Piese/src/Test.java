import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Clase.Cars;
import Clase.Item;
import Clase.Piesa;
import Clase.Util;

class Test {

	@org.junit.jupiter.api.Test
	void test() {
		List<Item> items= new ArrayList<Item>();
		items.add(new Cars());
//		public Cars(int id_car, String name, int count, int price,  int numberOfkm, String description, int model_id,
//				Date date) {
		
		items.add(new Cars(1,"nume", 1, 1, 1, "desc", 1, null));
		items.add(new Cars(1,"nume", 1, 1, 1, "desc", 1, null));
		items.add(new Cars(1,"nbmw", 1, 2, 1, "desc", 1, null));
		
		//Piesa(int idPiesa,String name, int count, int price,int idProducator, boolean uzuraNou, Date data)
		items.add(new Piesa(1,"piesa", 1, 1, 1, true, null));
		items.add(new Piesa());
		
		for( Item p : items) {
			System.out.println(p.getName()+" "+p.getPrice()+ " "+ p.getCount());
		}
		
		List<Item> item = Util.RendItems(true, "faraAfisare", null);
		for(Item i: Util.RendItems(false, "faraAfisare", null)) {
			item.add(i);
			
		}
		for(Item i: item) {
			System.out.println(i);
			
		}
	}

}
