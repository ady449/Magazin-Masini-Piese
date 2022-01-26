package Clase;

import java.util.Date;

public class Piesa extends Item{
	int idPiesa;
	int idProducator;
	boolean uzuraNou;
	Date data;
	
 public Piesa() {
	 this.idPiesa=0;
	 this.name="";
	 this.count=0;
	 this.data = new java.util.Date();
	 this.price = 0;
	 this.idProducator = 0;
	 this.uzuraNou = true;
 }

public Piesa(int idPiesa,String name, int count, int price,int idProducator, boolean uzuraNou, Date data) {
	super(name, price, count);
	this.idPiesa = idPiesa;
	this.idProducator = idProducator;
	this.uzuraNou = uzuraNou;
	this.data = data;
}

public int getIdPiesa() {
	return idPiesa;
}

public int getIdProducator() {
	return idProducator;
}

public boolean getUzuraNou() {
	return uzuraNou;
}

public Date getData() {
	return data;
}

public void setIdPiesa(int IdPiesa) {
	this.idPiesa = IdPiesa;
}
public void setIdProducator(int idProducator) {
	this.idProducator = idProducator;
}

public void setUzuraNou(boolean uzuraNou) {
	this.uzuraNou = uzuraNou;
}

public void setData(Date data) {
	this.data = data;
}



}
