package ecom.model;

import java.io.Serializable;

public class SizeInYears implements Serializable {
	private static final long serialVersionUID = 2744124298256637433L;

	private long id;
	private long productId;
	
	private int stockOfSIZE_1_2;
	private int stockOfSIZE_2_3;
	private int stockOfSIZE_3_4;
	private int stockOfSIZE_4_5;
	private int stockOfSIZE_5_6;
	private int stockOfSIZE_6_7;
	private int stockOfSIZE_7_8;
	private int stockOfSIZE_8_9;
	private int stockOfSIZE_9_10;
	private int stockOfSIZE_10_11;
	private int stockOfSIZE_11_12;
	
	private boolean isProductIdExists;
	
	public SizeInYears() {
		isProductIdExists = false;
	}

	public long getId() {
		return id;
	}

	public long getProductId() {
		return productId;
	}

	public int getStockOfSIZE_1_2() {
		return stockOfSIZE_1_2;
	}

	public int getStockOfSIZE_2_3() {
		return stockOfSIZE_2_3;
	}

	public int getStockOfSIZE_3_4() {
		return stockOfSIZE_3_4;
	}

	public int getStockOfSIZE_4_5() {
		return stockOfSIZE_4_5;
	}

	public int getStockOfSIZE_5_6() {
		return stockOfSIZE_5_6;
	}

	public int getStockOfSIZE_6_7() {
		return stockOfSIZE_6_7;
	}

	public int getStockOfSIZE_7_8() {
		return stockOfSIZE_7_8;
	}

	public int getStockOfSIZE_8_9() {
		return stockOfSIZE_8_9;
	}

	public int getStockOfSIZE_9_10() {
		return stockOfSIZE_9_10;
	}

	public int getStockOfSIZE_10_11() {
		return stockOfSIZE_10_11;
	}

	public int getStockOfSIZE_11_12() {
		return stockOfSIZE_11_12;
	}

	public boolean isProductIdExists() {
		return isProductIdExists;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public void setStockOfSIZE_1_2(int stockOfSIZE_1_2) {
		this.stockOfSIZE_1_2 = stockOfSIZE_1_2;
	}

	public void setStockOfSIZE_2_3(int stockOfSIZE_2_3) {
		this.stockOfSIZE_2_3 = stockOfSIZE_2_3;
	}

	public void setStockOfSIZE_3_4(int stockOfSIZE_3_4) {
		this.stockOfSIZE_3_4 = stockOfSIZE_3_4;
	}

	public void setStockOfSIZE_4_5(int stockOfSIZE_4_5) {
		this.stockOfSIZE_4_5 = stockOfSIZE_4_5;
	}

	public void setStockOfSIZE_5_6(int stockOfSIZE_5_6) {
		this.stockOfSIZE_5_6 = stockOfSIZE_5_6;
	}

	public void setStockOfSIZE_6_7(int stockOfSIZE_6_7) {
		this.stockOfSIZE_6_7 = stockOfSIZE_6_7;
	}

	public void setStockOfSIZE_7_8(int stockOfSIZE_7_8) {
		this.stockOfSIZE_7_8 = stockOfSIZE_7_8;
	}

	public void setStockOfSIZE_8_9(int stockOfSIZE_8_9) {
		this.stockOfSIZE_8_9 = stockOfSIZE_8_9;
	}

	public void setStockOfSIZE_9_10(int stockOfSIZE_9_10) {
		this.stockOfSIZE_9_10 = stockOfSIZE_9_10;
	}

	public void setStockOfSIZE_10_11(int stockOfSIZE_10_11) {
		this.stockOfSIZE_10_11 = stockOfSIZE_10_11;
	}

	public void setStockOfSIZE_11_12(int stockOfSIZE_11_12) {
		this.stockOfSIZE_11_12 = stockOfSIZE_11_12;
	}

	public void setProductIdExists(boolean isProductIdExists) {
		this.isProductIdExists = isProductIdExists;
	}
	
	
}
