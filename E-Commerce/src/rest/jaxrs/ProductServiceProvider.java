package rest.jaxrs;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.StringReader;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.BindingType;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPBinding;

@WebServiceProvider
@ServiceMode(Mode.MESSAGE)
@BindingType(HTTPBinding.HTTP_BINDING)
public class ProductServiceProvider implements Provider<Source> {

	@Resource
	private WebServiceContext webServiceContext;  // to get Message Context

	@Override
	public Source invoke(Source request) {   // Source is for XML source
		
		if (webServiceContext == null) throw new RuntimeException("Injection failed on WebServiceContext");
		
		MessageContext messageContext = webServiceContext.getMessageContext();
		String httpVerb = (String) messageContext.get(MessageContext.HTTP_REQUEST_METHOD);
		httpVerb = httpVerb.trim().toUpperCase();
		
		if (httpVerb.equals("GET"))   return doGet(messageContext);
		else return null;	
	}
	
	
	private Source doGet(MessageContext messageContext) {
		
		String queryString = (String) messageContext.get(MessageContext.QUERY_STRING);
		
		if (queryString == null) return productsToXml();
		else { return null; }
	}
	
	private StreamSource productsToXml() {
		
		String xmlStr = toXml(new ProductService().getProductBeans());
		return toSource(xmlStr);
	}
	
	private String toXml(Object object) {
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		XMLEncoder encoder = new XMLEncoder(out);
		encoder.writeObject(object);
		encoder.close();
		return out.toString();
	}
	
	private StreamSource toSource(String xmlStr) {		
		return new StreamSource(new StringReader(xmlStr));
	}
}
