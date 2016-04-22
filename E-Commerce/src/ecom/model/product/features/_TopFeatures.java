package ecom.model.product.features;

import java.io.Serializable;

public class _TopFeatures implements Serializable {
	private static final long serialVersionUID = 1L;

	private long   id;
	private long   productId;
	private long   sellerId;
	
	private String sleeve;
	private String fabric;
	private String neck;
	private String pattern;
	private String occasion;
	
	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getId() {
		return id;
	}
	public long getProductId() {
		return productId;
	}
	public long getSellerId() {
		return sellerId;
	}
	public String getSleeve() {
		return sleeve;
	}
	public String getFabric() {
		return fabric;
	}
	public String getNeck() {
		return neck;
	}
	public String getPattern() {
		return pattern;
	}
	public String getOccasion() {
		return occasion;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}
	public void setSleeve(String sleeve) {
		this.sleeve = sleeve;
	}
	public void setFabric(String fabric) {
		this.fabric = fabric;
	}
	public void setNeck(String neck) {
		this.neck = neck;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}
	
	
	
	
}
