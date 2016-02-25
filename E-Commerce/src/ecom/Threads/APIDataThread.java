package ecom.Threads;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;

import org.xml.sax.SAXException;

import ecom.Implementation.Courier.SOAP.EstimatedRateAndDeliveryBean;
import ecom.Interface.Courier.EstimatedRateAndDelivery;
import ecom.model.TwoObjects;
import ecom.model.User;

public class APIDataThread extends Thread {
	
	private long productId;
	private User user;
	
	TwoObjects<BigDecimal, String> apiRateAndDelivery;

	public APIDataThread(long productId, User user) {
		this.productId = productId;
		this.user      = user;
		this.apiRateAndDelivery = new TwoObjects<BigDecimal, String>();		
	}
	
	public TwoObjects<BigDecimal, String> getApiRateAndDelivery() {
		return apiRateAndDelivery;
	}
	
	public void run() {
		
		EstimatedRateAndDelivery estimatedRateAndDelivery = null;
		
		try {
			estimatedRateAndDelivery = EstimatedRateAndDeliveryBean.getNewInstance(this.productId, user);
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		apiRateAndDelivery.setObj1(estimatedRateAndDelivery.getRate());	
		apiRateAndDelivery.setObj2(estimatedRateAndDelivery.getDelivery());
	}
}
