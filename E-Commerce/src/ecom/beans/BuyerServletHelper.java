package ecom.beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ecom.model.CustomerOrderHistroy;

public class BuyerServletHelper {

	public static BuyerServletHelper getNewInstance() {		
		return new BuyerServletHelper();
	}
	
	public Map<String, List<CustomerOrderHistroy>> getCustomerOrderHistroyMap(Set<String> orderTableIds, 
			List<CustomerOrderHistroy> customerOrderHistroys) {		
		
		Map<String, List<CustomerOrderHistroy>> map = new HashMap<>();
		
		for (String orderTableId : orderTableIds) {
			
			List<CustomerOrderHistroy> list = new ArrayList<>();
			
			for (CustomerOrderHistroy customerOrderHistroy : customerOrderHistroys) {				
				
				if (customerOrderHistroy.getOrderId().equals(orderTableId)) {
					
					list.add(customerOrderHistroy);
				}				
			}			
			
			map.put(orderTableId, list);		
		}
		
		return map;
	}
	
	public boolean ifOrderCouldBeReturned(String deliveryDate, int calcellationAfterBooked) {
		
		String[] dateParts = deliveryDate.split("-");
		Calendar deliveredDate = Calendar.getInstance();
		deliveredDate.set(Integer.parseInt(dateParts[2]), Integer.parseInt(dateParts[0])-1, Integer.parseInt(dateParts[1]));
		deliveredDate.add(Calendar.DATE, calcellationAfterBooked);
		
		System.out.println(deliveredDate.get(Calendar.DATE) + " " + deliveredDate.get(Calendar.MONTH));
		
		Date dateToday = new Date();
		Calendar current = Calendar.getInstance();
		current.setTime(dateToday);	
		
		System.out.println(current.get(Calendar.DATE) + " " + current.get(Calendar.MONTH));
		
		int i = current.compareTo(deliveredDate);
		
		if (i < 0)
		
			return true;
		
		else 
			
			return false;
	}
}
