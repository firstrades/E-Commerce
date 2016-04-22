package ecom.model.product.features;

import java.io.Serializable;

public class _LaptopFeatures implements Serializable {
	private static final long serialVersionUID = 1L;

	private long   id;
	private long   productId;
	private long   sellerId;
	
	private String webCamera;
	private String powerSupply;
	private String batteryCell;
	private String screenSize;
	private String hddCapacity;
	private String graphicProcessor;
	private String os;
	private String processor;
	
	
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
	public String getWebCamera() {
		return webCamera;
	}
	public String getPowerSupply() {
		return powerSupply;
	}
	public String getBatteryCell() {
		return batteryCell;
	}
	public String getScreenSize() {
		return screenSize;
	}
	public String getHddCapacity() {
		return hddCapacity;
	}
	public String getGraphicProcessor() {
		return graphicProcessor;
	}
	public String getOs() {
		return os;
	}
	public String getProcessor() {
		return processor;
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
	public void setWebCamera(String webCamera) {
		this.webCamera = webCamera;
	}
	public void setPowerSupply(String powerSupply) {
		this.powerSupply = powerSupply;
	}
	public void setBatteryCell(String batteryCell) {
		this.batteryCell = batteryCell;
	}
	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}
	public void setHddCapacity(String hddCapacity) {
		this.hddCapacity = hddCapacity;
	}
	public void setGraphicProcessor(String graphicProcessor) {
		this.graphicProcessor = graphicProcessor;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	
	
}
