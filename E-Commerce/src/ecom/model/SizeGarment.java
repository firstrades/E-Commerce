package ecom.model;

import java.io.Serializable;

public class SizeGarment implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	private long productId;	
	private Size size;	
	
	private boolean isProductIdExists;
	
	//Constractor
	public SizeGarment() {
		size = new Size();
		isProductIdExists = false;
	}

	//Getter & Setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isProductIdExists() {
		return isProductIdExists;
	}

	public void setProductIdExists(boolean isProductIdExists) {
		this.isProductIdExists = isProductIdExists;
	}
	
	
	
}
