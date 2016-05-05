package ecom.model;

import java.io.Serializable;

import ecom.common.Status;

public class ProductBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected long        productId;
	protected long        sellerId;
	protected String      sellerCompany;  
	
	protected String      category;
	protected String      subCategory;
	protected String      productName;
	protected String      companyName;
	
	protected KeyFeatures keyFeatures;                    
	protected Price       price;
	
	protected int         stock;
	protected double      weight;
	protected String      warranty;	
	protected int         cancellationAfterBooked;
	
	protected Status      status;	                         // Enum
	protected Commission  commission;
	protected String      productAdditionDate;
	
	
	public ProductBean() {
		keyFeatures = new KeyFeatures();
		price       = new Price();
		commission  = new Commission();
	}
	
	
	
	// Getter & Setter
	
	
	
	
	
	public long getProductId() {
		return productId;
	}

	public String getProductAdditionDate() {
		return productAdditionDate;
	}

	public void setProductAdditionDate(String productAdditionDate) {
		this.productAdditionDate = productAdditionDate;
	}

	public Commission getCommission() {
		return commission;
	}

	public void setCommission(Commission commission) {
		this.commission = commission;
	}	

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}	

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public int getCancellationAfterBooked() {
		return cancellationAfterBooked;
	}

	public void setCancellationAfterBooked(int cancellationAfterBooked) {
		this.cancellationAfterBooked = cancellationAfterBooked;
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

	public String getSellerCompany() {
		return sellerCompany;
	}

	public void setSellerCompany(String sellerCompany) {
		this.sellerCompany = sellerCompany;
	}
	
	
}
