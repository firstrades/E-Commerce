package ecom.model.product.features;

import java.io.Serializable;

public class _MenTshirtFeatures implements Serializable {
	private static final long serialVersionUID = 6410160569276267159L;

	private long   id;
	private long   productId;
	private long   sellerId;
	
	private String sleeve;
	private String fabric;
	private String type;
	private String fit;
	private String pattern;
	
	
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
	public String getType() {
		return type;
	}
	public String getFit() {
		return fit;
	}
	public String getPattern() {
		return pattern;
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
	public void setType(String type) {
		this.type = type;
	}
	public void setFit(String fit) {
		this.fit = fit;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	
}
