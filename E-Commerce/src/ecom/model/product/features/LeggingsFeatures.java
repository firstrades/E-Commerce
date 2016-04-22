package ecom.model.product.features;

import java.io.Serializable;

public class LeggingsFeatures implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long   id;
	private long   productId;
	private long   sellerId;
	
	private String pattern;
	private String fabric;
	private String style;
	private String season;
	private String waistband;
	
	
	
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
	public long getSellerId() {
		return sellerId;
	}
	public void setSellerId(long sellerId) {
		this.sellerId = sellerId;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public String getFabric() {
		return fabric;
	}
	public void setFabric(String fabric) {
		this.fabric = fabric;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getWaistband() {
		return waistband;
	}
	public void setWaistband(String waistband) {
		this.waistband = waistband;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
