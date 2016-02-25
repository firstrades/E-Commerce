package ecom.model;

import java.io.Serializable;

public class GarmentOrder implements Serializable {
	private static final long serialVersionUID = 1L;	

	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
