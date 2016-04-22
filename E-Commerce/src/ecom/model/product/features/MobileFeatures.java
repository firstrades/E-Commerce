package ecom.model.product.features;

import java.io.Serializable;

public class MobileFeatures implements Serializable {
	private static final long serialVersionUID = 1L;

	private long   id;
	private long   productId;
	private long   sellerId;
	
	private String internalStorage;
	private String os;
	private String touch;
	private String wifi;
	private String fm;
	private String frontCamera;
	private String rearCamera;
	private String connectivity;
	
	
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
	public String getInternalStorage() {
		return internalStorage;
	}
	public void setInternalStorage(String internalStorage) {
		this.internalStorage = internalStorage;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getTouch() {
		return touch;
	}
	public void setTouch(String touch) {
		this.touch = touch;
	}
	public String getWifi() {
		return wifi;
	}
	public void setWifi(String wifi) {
		this.wifi = wifi;
	}
	public String getFm() {
		return fm;
	}
	public void setFm(String fm) {
		this.fm = fm;
	}
	public String getFrontCamera() {
		return frontCamera;
	}
	public void setFrontCamera(String frontCamera) {
		this.frontCamera = frontCamera;
	}
	public String getRearCamera() {
		return rearCamera;
	}
	public void setRearCamera(String rearCamera) {
		this.rearCamera = rearCamera;
	}
	public String getConnectivity() {
		return connectivity;
	}
	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
