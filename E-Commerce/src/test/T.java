/*package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

import ecom.common.FrequentUse;

public class T {
	
	
public void getRateAndDeliveryXML() throws IOException {
		
		String soapMessage = 
		   "<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:SOAP-ENC=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns=\"http://fedex.com/ws/rate/v18\">"
		   +"<SOAP-ENV:Body>"
		   +	"<RateRequest>"
		   +		"<WebAuthenticationDetail>"
		   +			"<UserCredential>"        
		   +				"<Key>"+ FrequentUse.fedExKey +"</Key>"
		   +				"<Password>"+ FrequentUse.fedExPassword +"</Password>"
		   +			"</UserCredential>"
		   +		"</WebAuthenticationDetail>"
		   +		"<ClientDetail>"
		   +			"<AccountNumber>"+ FrequentUse.fedExAccountNumber +"</AccountNumber>"         
		   +			"<MeterNumber>"+ FrequentUse.fedExMeterNumber +"</MeterNumber>"        
		   +		"</ClientDetail>"
		   +        "<TransactionDetail>"     
		   +			"<CustomerTransactionId>FTC</CustomerTransactionId>"        
		   +		"</TransactionDetail>"
		   +		"<Version>"
		   +			"<ServiceId>crs</ServiceId>"
		   +			"<Major>18</Major>"
		   +			"<Intermediate>0</Intermediate>"         
		   +			"<Minor>0</Minor>"         
		   +		"</Version>"   
		   
		   
		   +		"<RequestedShipment>"      
		   +			"<ShipTimestamp>2014-05-23T12:34:56-06:00</ShipTimestamp>"      //----------------   
		   +			"<DropoffType>REGULAR_PICKUP</DropoffType>"         
		   +			"<ServiceType>STANDARD_OVERNIGHT</ServiceType>"         
		   +			"<PackagingType>YOUR_PACKAGING</PackagingType>"         
		   +			"<PreferredCurrency>INR</PreferredCurrency>"         
		   +			"<Shipper>"  	             
		   +				"<Address>"            
		   +					"<StreetLines>"+ this.shipper.getAddress() +"</StreetLines>"  		   
		   +					"<City>"+ this.shipper.getCity() +"</City>"   		  				               
		   +					"<PostalCode>"+ this.shipper.getPin() +"</PostalCode>"               
		   +					"<CountryCode>IN</CountryCode>"               
		   +				"</Address>"           
		   +			"</Shipper>"
		   +			"<Recipient>"	   
		   + 				"<Address>"            
		   +					"<StreetLines>"+ this.recipient.getAddress() +"</StreetLines>"  		   
		   +					"<City>"+ this.recipient.getCity() +"</City>"   		  				               
		   +					"<PostalCode>700067</PostalCode>"               
		   +					"<CountryCode>IN</CountryCode>"               
		   + 				"</Address>"
		   +			"</Recipient>"
		   +			"<ShippingChargesPayment>"         
		   +				"<PaymentType>SENDER</PaymentType>"                 
		   +			"</ShippingChargesPayment>" 
		   +			"<SpecialServicesRequested>"         
		   +				"<SpecialServiceTypes>COD</SpecialServiceTypes>"	               
		   +				"<CodDetail>"	               
		   +					"<CodCollectionAmount>"	                  
		   +						"<Currency>INR</Currency>"	                     
		   +						"<Amount>500</Amount>"	                     
		   +					"</CodCollectionAmount>"
		   +					"<AddTransportationChargesDetail>"	                  
		   +						"<RateTypeBasis>ACCOUNT</RateTypeBasis>"	                     
		   +						"<ChargeBasis>COD_SURCHARGE</ChargeBasis>"
		   +						"<ChargeBasisLevel>CURRENT_PACKAGE</ChargeBasisLevel>"	 
		   +					"</AddTransportationChargesDetail>"
		   +					"<CollectionType>GUARANTEED_FUNDS</CollectionType>"	                  
		   +				"</CodDetail>"
		   +			"</SpecialServicesRequested>"
		   
		   +			"<CustomsClearanceDetail>"         
		   + 				"<DocumentContent>DOCUMENTS_ONLY</DocumentContent>"	               
		   +					"<CustomsValue>"	               
		   +						"<Currency>INR</Currency>"	                  
		   +						"<Amount>100.00</Amount>"	                  
		   +					"</CustomsValue>"
		   +					"<CommercialInvoice>"	               
		   +						"<Purpose>SOLD</Purpose>"	                  
		   +						"<TermsOfSale>FOB_OR_FCA</TermsOfSale>"	                  
		   +					"</CommercialInvoice>"
		   +					"<Commodities>"	               
		   +						"<NumberOfPieces>1</NumberOfPieces>"	                  
		   +						"<Description>ABCD</Description>"	                  
		   +						"<CountryOfManufacture>IN</CountryOfManufacture>"                  
		   +						"<Weight>"	                  
		   +							"<Units>KG</Units>"	                     
		   +							"<Value>0.2</Value>"	                     
		   +						"</Weight>"
		   +						"<Quantity>1</Quantity>"	                  
		   +						"<QuantityUnits>cm</QuantityUnits>"
		   +						"<UnitPrice>"
		   +							"<Currency>INR</Currency>"
		   +							"<Amount>1.000000</Amount>"
		   +						"</UnitPrice>"
		   +						"<CustomsValue>"	                  
		   +							"<Currency>INR</Currency>"	                     
		   +							"<Amount>100.000000</Amount>"
		   +						"</CustomsValue>"
		   +					"</Commodities>"
		   +					"<ExportDetail>"	               
		   +						"<ExportComplianceStatement>30.37(f)</ExportComplianceStatement>"	                  
		   +					"</ExportDetail>"
		   +			"</CustomsClearanceDetail>" 
		   																			// All requierd
		   +			"<RateRequestTypes>LIST</RateRequestTypes>"         
		   +			"<PackageCount>1</PackageCount>"  
		   
		   +			"<RequestedPackageLineItems>"  	   
		   +				"<GroupPackageCount>1</GroupPackageCount>"
		   +				"<Weight>"
		   +					"<Units>KG</Units>"                  
		   +					"<Value>0.2</Value>"
		   +				"</Weight>"	 	   
		   +			"</RequestedPackageLineItems>"
		   
		   +		"</RequestedShipment>"
		   +	"</RateRequest>"
		   +"</SOAP-ENV:Body>"
		   +"</SOAP-ENV:Envelope>";
		
		System.out.println("soapMessage: " + soapMessage);    // http://fedex.com/ws/rate/v18
		
		//-----------------------------------------------------------------------------------
		
		byte[] postDataBytes = null;
		try {
			postDataBytes = soapMessage.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		URL url = null; 
		HttpURLConnection connection = null;
				
			try {
				url = new URL("http://fedex.com/ws/rate/v18");
				
				connection = (HttpURLConnection) url.openConnection();
				
				connection.setRequestMethod("POST");
				connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				connection.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
				connection.setDoOutput(true);
				connection.getOutputStream().write(postDataBytes);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Reader in = null;
			try {
				in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	        for ( int c = in.read(); c != -1; c = in.read() )
	        	
	            System.out.print((char)c);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
*/