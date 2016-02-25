package ecom.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import ecom.Threads.APIDataThread;
import ecom.model.ProductBean;
import ecom.model.TwoObjects;
import ecom.model.User;

public class ApiDataMultiThreadBean {
	
	private List<TwoObjects<ProductBean, Integer>> productBeanAndQtyList;
	private User user;
	
	public ApiDataMultiThreadBean(List<TwoObjects<ProductBean, Integer>> productBeanAndQtyList, User user) {
		this.productBeanAndQtyList = productBeanAndQtyList;
		this.user = user;
	}
	
	public List<TwoObjects<BigDecimal, String>> getRateAndDeliveryList() {
		
		List<TwoObjects<BigDecimal, String>> apiData = new ArrayList<>();		
		List<Thread> threads = new ArrayList<Thread>();
		
		for (TwoObjects<ProductBean, Integer> productIdAndQty : productBeanAndQtyList) {
		
			long productId = productIdAndQty.getObj1().getProductId();
			
			APIDataThread apiDataThread = new APIDataThread(productId, user);
			apiDataThread.start();
			TwoObjects<BigDecimal, String> apiRateAndDelivery = apiDataThread.getApiRateAndDelivery();			
			
			apiData.add(apiRateAndDelivery);
			threads.add(apiDataThread);
			
		}
		
		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
		
		
		for (TwoObjects<BigDecimal, String> twoObjects : apiData) {
			
			System.out.println(twoObjects.getObj1());
			System.out.println(twoObjects.getObj2());
		}
		
		
		
		return apiData;
	}	

}
