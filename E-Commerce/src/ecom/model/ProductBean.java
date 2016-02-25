package ecom.model;

import java.io.Serializable;

import ecom.common.Status;

public class ProductBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long   productId;
	private long   sellerId;
	private String sellerCompany;
	
	private String category;
	private String subCategory;
	private String productName;
	private String companyName;
	
	private KeyFeatures keyFeatures;
	private Price price;
	
	private int    stock;
	private String warranty;
	private Status status;
	
	// Getter & Setter

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}	

	public long getSellerId() {
		return sellerId;
	}

	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public KeyFeatures getKeyFeatures() {
		return keyFeatures;
	}

	public void setKeyFeatures(KeyFeatures keyFeatures) {
		this.keyFeatures = keyFeatures;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getSellerCompany() {
		return sellerCompany;
	}

	public void setSellerCompany(String sellerCompany) {
		this.sellerCompany = sellerCompany;
	}
	
	
}
