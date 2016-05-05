package ecom.SERVLET.buyer;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;

import org.xml.sax.SAXException;

import ecom.DAO.Buyer.BuyerSearchDAO;
import ecom.DAO.Buyer.ProductDetailsDAO;
import ecom.DAO.Seller.EditProductDAO;
import ecom.Implementation.Courier.SOAP.EstimatedRateAndDeliveryBean;
import ecom.Interface.Courier.EstimatedRateAndDelivery;
import ecom.beans.TransientData;
import ecom.model.ProductBean;
import ecom.model.SizeGarment;
import ecom.model.SizeInYears;
import ecom.model.TwoObjects;
import ecom.model.User;

@WebServlet("/CompleteProductDetails")
public class CompleteProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EditProductDAO basicFeatures;
	private BuyerSearchDAO buyerSearchDAO;
	
	@Override
	public void init() {
		basicFeatures = new EditProductDAO();
		buyerSearchDAO = new BuyerSearchDAO();
	}
	
	@Override
	public void destroy() { 
		System.gc();
		System.out.println("CompleteProductDetails Destroyed"); 
	};
  
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entered CompleteProductDetails");
		
		HttpSession session = request.getSession();
		
		/******************************************
		 			*  Get Request  *
		 ******************************************/			
			String subCategory = request.getParameter("subCategory");		
			String productId1  = request.getParameter("productId");	
			
		/************* Get Session ***************/
			
			User user = (User) session.getAttribute("user");
		
		/******************************************
		 				* Process *
		 ******************************************/
			long productId = Long.parseLong(productId1);	        
			int  stock     = TransientData.getStock(productId);
		
		/*************************************************************************
		 	* Database Search for 'product' table and different product tables *
		 *************************************************************************/			
			/**
			 * @Basic Product
			 */			
			ProductBean productBean = basicFeatures.getBasicFeatures(productId);		
			
			/**
			 * @Advance Features
			 */
			Map<String,String> featureMap = mapFeatures(subCategory, productId);			
			/**
			 * @Size
			 */			
			SizeGarment sizeGarment = new SizeGarment();
			sizeGarment = buyerSearchDAO.getSizeGarmentModel(productId, sizeGarment);	
			
			SizeInYears sizeInYears = new SizeInYears();
			sizeInYears = buyerSearchDAO.getSizeInYears(productId, sizeInYears);
			
			/**
			 * @API - @Rate @Delivery
			 */			
			boolean error = false;
			EstimatedRateAndDelivery estimatedRateAndDelivery = null;
			try {
				estimatedRateAndDelivery = EstimatedRateAndDeliveryBean.getNewInstance(productId, user, 1);
				
				BigDecimal rate = estimatedRateAndDelivery.getRate();    
				String delivery = estimatedRateAndDelivery.getDelivery();
				
				List<TwoObjects<BigDecimal, String>> apiDataList  = new ArrayList<>();
				TwoObjects<BigDecimal, String> apiRateAndDelivery = new TwoObjects<>();
				apiRateAndDelivery.setObj1(rate    );
				apiRateAndDelivery.setObj2(delivery);
				apiDataList.add(apiRateAndDelivery );
				
			/************** Set Session ***************/
				session.setAttribute("apiDataList", apiDataList);			
			
			/******************************************
			 			* Set Request *
			 ******************************************/
				request.setAttribute("productBean",   productBean);
				request.setAttribute("featureMap",    featureMap);			
				request.setAttribute("stock",         stock);
				request.setAttribute("sizeGarment",   sizeGarment);
				request.setAttribute("sizeInYears",   sizeInYears);
				// API Data
				request.setAttribute("rate",          rate);
				request.setAttribute("delivery",      delivery);
				
				
			} catch (SOAPException e) {
				System.out.println("SOAPException");
				e.printStackTrace();
				error = true;				
			} catch (ParserConfigurationException e) {
				System.out.println("ParserConfigurationException");
				e.printStackTrace();
				error = true;	
			} catch (SAXException e) {
				System.out.println("SAXException");
				e.printStackTrace();
				error = true;	
			} catch (ParseException e) {
				System.out.println("ParseException");
				e.printStackTrace();
				error = true;	
			}
			
			
		/******** Clear Up **********/
			sizeGarment = null;  estimatedRateAndDelivery = null; sizeInYears = null;
			
		
		/******************************************
		 			* Next Page *
		 ******************************************/
			if (error) {
				String errorMsg = "Error! Please try again.";				
				response.sendRedirect("SearchBySubCategory?subCategory="+subCategory+"&errorMsg="+errorMsg);
			}
			else
				request.getRequestDispatcher("jsp_Buyer/ProductDetails.jsp").forward(request, response);
		
	}
	
	private Map<String,String> mapFeatures(String subCategory, long productId) {  
		
		ProductDetailsDAO dao = new ProductDetailsDAO();
	
		Map<String,String> map = null;
		
		switch (subCategory) {
		//Electronics
		case "Mobile"     : map = dao.getMobileFeatures     (productId);    break;
		case "Laptop"     : map = dao.getLaptopFeatures     (productId);    break;
		//Women
		case "Leggings"   : map = dao.getLeggingsFeatures   (productId);    break;
		case "Top"        : map = dao.getTopFeatures        (productId);    break;
		//Men
		case "MenTshirt"  : map = dao.getMenTshirtFeatures  (productId);    break;
		case "Jeans"      : map = dao.getMenJeansFeatures   (productId);    break;
		//Kids
		case "Boys_Shirt" : map = dao.getBoysShirtsFeatures (productId);    break;
		}		
		
		
		return map;
	}
}
