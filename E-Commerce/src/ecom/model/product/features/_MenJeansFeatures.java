package ecom.model.product.features;

import java.io.Serializable;

public class _MenJeansFeatures implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long   id;
	private long   productId;
	private long   sellerId;
	
	private String fabric;
	private String brandFit; 
	private String pattern;
	private String pockets;
	private String beltLoops; 
	private String occasion;
	
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
    public long getSellerId() {
    	return sellerId;
    }
    public void setSellerId(long sellerId) {
    	this.sellerId = sellerId;
    }
    public String getFabric() {
    	return fabric;
    }
    public void setFabric(String fabric) {
    	this.fabric = fabric;
    }
    public String getBrandFit() {
    	return brandFit;
    }
    public void setBrandFit(String brandFit) {
    	this.brandFit = brandFit;
    }
    public String getPattern() {
    	return pattern;
    }
    public void setPattern(String pattern) {
    	this.pattern = pattern;
    }
    public String getPockets() {
    	return pockets;
    }
    public void setPockets(String pockets) {
    	this.pockets = pockets;
    }
    public String getBeltLoops() {
    	return beltLoops;
    }
    public void setBeltLoops(String beltloops) {
    	this.beltLoops = beltloops;
    }
    public String getOccasion() {
    	return occasion;
    }
    public void setOccasion(String occasion) {
    	this.occasion = occasion;
    }
    public static long getSerialversionuid(){
        return serialVersionUID;
    }
    
}

