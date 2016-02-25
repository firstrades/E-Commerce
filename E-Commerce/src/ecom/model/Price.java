package ecom.model;

import java.io.Serializable;

public class Price implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private double listPrice;
	private double discount;
	private double salePrice;
	private double markup;
	
	
	public double getListPrice() {
		return listPrice;
	}
	public void setListPrice(double listPrice) {
		this.listPrice = listPrice;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}
	public double getMarkup() {
		return markup;
	}
	public void setMarkup(double markup) {
		this.markup = markup;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/******************* Process Methods ************************/
	
	public double getMarkedupSellPrice() {	
		double newSalePrice = getMarkup() + getSalePrice();
		return round(newSalePrice, 2);
	}
	
	public double getMarkedupDiscount() {	
		
		double ratio      = getMarkedupSellPrice() / getListPrice();
		double percentage = (1 - ratio) * 100;
		
		return round(percentage, 2);
	}
	
	/********** private method ************/
	
	private double round(double value, int places) {
		
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    
	    return (double) tmp / factor;
	}
	
	
}
