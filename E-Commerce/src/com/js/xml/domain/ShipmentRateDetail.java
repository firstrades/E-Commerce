package com.js.xml.domain;

public class ShipmentRateDetail {

	private String rateType;
	private String RateScale;
	private String RateZone;
	private String PricingCode;
	private String RatedWeightMethod;
	private CurrencyExchangeRate currencyExchangeRate = new CurrencyExchangeRate();
	private String DimDivisor;
	private String FuelSurchargePercent;
	private TotalBillingWeight totalBillingWeight = new TotalBillingWeight();
	
	
	
	public String getRateType() {
		return rateType;
	}
	public void setRateType(String rateType) {
		this.rateType = rateType;
	}
	public String getRateScale() {
		return RateScale;
	}
	public void setRateScale(String rateScale) {
		RateScale = rateScale;
	}
	public String getRateZone() {
		return RateZone;
	}
	public void setRateZone(String rateZone) {
		RateZone = rateZone;
	}
	public String getPricingCode() {
		return PricingCode;
	}
	public void setPricingCode(String pricingCode) {
		PricingCode = pricingCode;
	}
	public String getRatedWeightMethod() {
		return RatedWeightMethod;
	}
	public void setRatedWeightMethod(String ratedWeightMethod) {
		RatedWeightMethod = ratedWeightMethod;
	}
	public String getDimDivisor() {
		return DimDivisor;
	}
	public void setDimDivisor(String dimDivisor) {
		DimDivisor = dimDivisor;
	}
	public String getFuelSurchargePercent() {
		return FuelSurchargePercent;
	}
	public void setFuelSurchargePercent(String fuelSurchargePercent) {
		FuelSurchargePercent = fuelSurchargePercent;
	}
	public CurrencyExchangeRate getCurrencyExchangeRate() {
		return currencyExchangeRate;
	}
	public TotalBillingWeight getTotalBillingWeight() {
		return totalBillingWeight;
	}
	
	
	
}
