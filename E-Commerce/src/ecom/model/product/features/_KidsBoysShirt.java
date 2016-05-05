package ecom.model.product.features;

import ecom.model.Clothings;

public class _KidsBoysShirt extends Clothings {
	private static final long serialVersionUID = -2645046077018471394L;
	
	//Advance Features
	private   long   id;
	protected String sleeve;
	protected String fabric;
	protected String type; 
	protected String fit; 
	protected String pattern;
		
	public _KidsBoysShirt() {				
		sizeStyle = KIDS_YEAR_STYLE;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
