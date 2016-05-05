package ecom.SERVLET.seller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.SOAPException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

import com.mysql.jdbc.PacketTooBigException;

import ecom.DAO.Seller.ProductDAO;
import ecom.DAO.Seller.SellerDAO;
import ecom.Implementation.Courier.SOAP.TrackByNumber;
import ecom.Implementation.Courier.SOAP.TrackingIdGeneration;
import ecom.Interface.Courier.TrackByNumberInterface;
import ecom.Interface.Courier.TrackingIdGenerationInterface;
import ecom.beans.TransientData;
import ecom.model.OrderTable;
import ecom.model.ProductBean;
import ecom.model.User;


@MultipartConfig
public class SellerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SellerDAO sellerDAO;
	private ProductDAO productDAO;
	
	@Override
	public void init() {
		sellerDAO = SellerDAO.getNewInstance();
		productDAO = new ProductDAO();
	}
	
	@Override
	public void destroy() { 
		System.gc();
		System.out.println("SellerServlet Destroyed"); 
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
		
		HttpSession session = request.getSession();
		
		String servletPath = request.getServletPath();
		
		if (servletPath.equals("/CreateProduct")) {
			
			System.out.println("Entered CreateProduct");
			
			/*******************************************************
			 				*  Get Request  *
			 *******************************************************/
				
			
			ProductBean productBean = new ProductBean();                              // 1
			
			productBean.setCategory   (request.getParameter("category")   .trim());
			productBean.setSubCategory(request.getParameter("subCategory").trim());
			productBean.setCompanyName(request.getParameter("company")    .trim());
			productBean.setProductName(request.getParameter("product")    .trim());
			
			productBean.getKeyFeatures().setKf1(request.getParameter("kf1").trim());
			productBean.getKeyFeatures().setKf2(request.getParameter("kf2").trim());
			productBean.getKeyFeatures().setKf3(request.getParameter("kf3").trim());
			productBean.getKeyFeatures().setKf4(request.getParameter("kf4").trim());
			
			productBean.getPrice().setManufacturingCost     (Double.parseDouble(request.getParameter("manufacturingCost")     .trim()));
			productBean.getPrice().setProfitMarginPercentage(Double.parseDouble(request.getParameter("profitMarginPercentage").trim()));
			productBean.getPrice().setSalePriceToAdmin      (Double.parseDouble(request.getParameter("salePriceToAdmin")      .trim()));
			productBean.getPrice().setListPrice             (Double.parseDouble(request.getParameter("listPrice")             .trim()));
			productBean.getPrice().setDiscount              (Double.parseDouble(request.getParameter("discount")              .trim()));
			
			productBean.setStock                  (Integer.parseInt(request.getParameter("stock")             .trim()));
			productBean.setWeight                 (Double.parseDouble(request.getParameter("weight")          .trim()));
			productBean.setWarranty               (request.getParameter("warranty")                           .trim());
			productBean.setCancellationAfterBooked(Integer.parseInt(request.getParameter("cancellationPeriod").trim()));
			
			
			
			//Images
			Part part1               = request.getPart     ("iconImage");	 // 2	
			InputStream inputStream1 = part1.getInputStream();   
			
			Part part2               = request.getPart     ("image1"   );	// 3	
			InputStream inputStream2 = part2.getInputStream(); 
			
			Part part3               = request.getPart     ("image2"   );		// 4
			InputStream inputStream3 = part3.getInputStream(); 
			
			/*******************************************************
								*  Get Session  *
			*******************************************************/
			User user = (User) session.getAttribute("user");				
			
			/*******************************************************
			 	*  Database - Insert & Generate Product Code  *
			*******************************************************/			
			boolean status = false, isPacketTooBig = false;
			try {
				status = ProductDAO.addProduct(user, inputStream1, inputStream2, inputStream3, productBean);
			} catch (PacketTooBigException e) {
				isPacketTooBig = true;
				e.printStackTrace();
			}
			
			if (status == true)
				System.out.println("Database Updated");
			else
				System.out.println("Database Not Updated");	
			
			
			/*******************************************************
							*  Send Response  *
			*******************************************************/
			if (isPacketTooBig)
				response.getWriter().write("Decrease Image Size.");
			else
				response.getWriter().write("Product Sent For Approval.");
			
		}		
		
		else if (servletPath.equals("/AddProduct")) {
			
			System.out.println("Entered AddProduct");
			
			request.getRequestDispatcher("jsp_Seller/Product_Add.jsp").forward(request, response);
		}
		
		else if (servletPath.equals("/ViewProductList")) {
			
			System.out.println("Entered ViewProductList");
			
			/*******************************************************
							*  Get Request  *
			*******************************************************/			
			String category    = request.getParameter("category");           
			String subCategory = request.getParameter("subCategory");     
			
			/*******************************************************
								*  Get Session  *
			*******************************************************/	
			
			//Long sellerId = (Long) session.getAttribute("sellerId");
			
			User user     = (User) session.getAttribute("user");
			
			/*******************************************************
			 	*  Database - Get Product List  *
			*******************************************************/				
			List<ProductBean> productList = productDAO.getProducts(category, subCategory, user);
			
			int MAX = TransientData.getMAX(user.getUserInfo().getId(), category, subCategory);
			
			/****************** Sort In Descending Order ***************************/
			
			Comparator<ProductBean> compare = new Comparator<ProductBean>() {
				
				@Override
				public int compare(ProductBean a, ProductBean b) {
					
					if (a.getProductId() < b.getProductId())
						
						return 1;
					
					else if (a.getProductId() > b.getProductId())
						
						return -1;
					
					else
						
						return 0;
				}
			};
			
			Collections.sort(productList, compare);
			
			/*************** Set Request **************************/
			
			request.setAttribute("MAX", MAX);
			
			/*******************************************************
							*  Set Session  *
			*******************************************************/

			session.setAttribute("productList", productList);				
			
			/*******************************************************
						*  Send Response  *
			*******************************************************/
			
			request.getRequestDispatcher("jsp_Seller/ViewProductList.jsp").forward(request, response);
		}
		
		else if (servletPath.equals("/ViewProductList_Ajax")) {
			
			System.out.println("Entered ViewProductList_Ajax");			
			
			/*******************************************************
							  *  Get Session  *
			*******************************************************/				
			@SuppressWarnings("unchecked")
			List<ProductBean> productList = (List<ProductBean>) session.getAttribute("productList");
			
			/******************* Get Size **********************/
			
			final int shownMAX         = (int) session.getAttribute("MAX");			
			final int productListSIZE  = productList.size();
			
			/*************** Create JSON Data ********************/
			
			if (productListSIZE > shownMAX) {
			
					JSONArray  jsonArray  = new JSONArray();
					
					for (int i = shownMAX; i < productListSIZE; i++) {
						
						JSONObject jsonObject = new JSONObject();
						
						try {
							jsonObject.put("category",    productList.get(i).getCategory());
							jsonObject.put("subCategory", productList.get(i).getSubCategory());
							jsonObject.put("productName", productList.get(i).getProductName());
							jsonObject.put("companyName", productList.get(i).getCompanyName());
							jsonObject.put("companyName", productList.get(i).getCompanyName());
							jsonObject.put("productId",   productList.get(i).getProductId());
							jsonObject.put("listPrice",   productList.get(i).getPrice().getListPrice());
							jsonObject.put("discount",    productList.get(i).getPrice().getDiscount());
							jsonObject.put("salePrice",   productList.get(i).getPrice().getSalePriceToAdmin());
							jsonObject.put("markup",      productList.get(i).getPrice().getMarkup());
							jsonObject.put("kf1",         productList.get(i).getKeyFeatures().getKf1());
							jsonObject.put("kf2",         productList.get(i).getKeyFeatures().getKf2());
							jsonObject.put("kf3",         productList.get(i).getKeyFeatures().getKf3());
							jsonObject.put("kf4",         productList.get(i).getKeyFeatures().getKf4());							
								String editPage = getEditPageName(productList.get(i).getSubCategory());
							jsonObject.put("editPage",    editPage);
							
							
							jsonArray.put(jsonObject);
							
						} catch (JSONException e) {					
							e.printStackTrace();
						}
					}  // for close
					
					/*************** Send Data ********************/
					response.setContentType("application/json");  
					response.getWriter().write(jsonArray.toString());
			
			} // if close
			
			
		}
		
		else if (servletPath.equals("/DeleteProduct")) {
			
			System.out.println("Entered DeleteProduct");	
			
			String productId1  = null;
			String category    = null;
			String subCategory = null;
			
			if (request.getParameter("productId") == null) {    // Angular
			
			        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			        
			        String jsonData = null;
			        
			        if (br != null) {
			        	
			            jsonData = br.readLine();                               
			        }
			        
			        try {
			        	
						JSONObject jsonObject1 = new JSONObject(jsonData);
						
						productId1  = jsonObject1.getString("productId");        System.out.println("DP1: " + productId1);
						category    = jsonObject1.getString("productId");        System.out.println("DP2: " + category);
						subCategory = jsonObject1.getString("subCategory");      System.out.println("DP3: " + subCategory);
						
					} catch (JSONException e) {				
						e.printStackTrace();
					}
	        
			} else {   // jQuery
			
					/*******************************************************
									*  Get Request  *
					*******************************************************/
					productId1  = request.getParameter("productId");          System.out.println("DP1: " + productId1);
					category    = request.getParameter("category");           System.out.println("DP2: " + category);
					subCategory = request.getParameter("subCategory");        System.out.println("DP3: " + subCategory);
				
			}
			
			/******************************************************
			 				*  Processing  *
			 ******************************************************/
			
			long productId = Long.parseLong(productId1);
			
			/*******************************************************
			 	*  Database - Delete rows from tables  *
			*******************************************************/			
			boolean status = productDAO.deleteProduct(productId, subCategory);			
			System.out.println(status);
			
			/*******************************************************
							*  Send Response  *
			*******************************************************/
			
			if (status == true) {
				
				JSONObject jsonObject = new JSONObject();
				
				try {
					jsonObject.put("success", true);
				} catch (JSONException e) {					
					e.printStackTrace();
				}
				
				response.setContentType("application/json");
				response.getWriter().write(jsonObject.toString());
			} // if close
			

		} //  /DeleteProduct
		
		else if (servletPath.equals("/RetrieveOrderedItemsForSeller")) {
			
			System.out.println("Entered RetrieveOrderedItemsForSeller");
			
			/********** Get Session **************/
			User user = (User) session.getAttribute("user");
			
			/************* Database **************/			
			List<OrderTable> orderTables = sellerDAO.getOrderTables(user);
			
			/********* Set Request *************/
			request.setAttribute("orderTables", orderTables);
			
			
			/********* Next Page **********/
			
			request.getRequestDispatcher("jsp_Seller/OrderedItemsStatus.jsp").forward(request, response);
			
		} //  /RetrieveOrderedItemsForSeller
		
		else if (servletPath.equals("/GenerateTrackNumberCOD")) {
			
			System.out.println("Entered GenerateTrackNumberCOD");	
						
			/*********** Call API *************/		
			
			String paymentType = "COD";	    boolean pickup = false;
			
			try {
				
				pickup = callShipTransaction(request, paymentType, pickup);					
				
			} catch (SOAPException | ParserConfigurationException | SAXException | ParseException e) {				
				e.printStackTrace();			
			} catch (Exception e) {
				e.printStackTrace();					
			}
			
			
			/************* JSON Data for Next Page ****************/
			JSONObject jsonObject = new JSONObject();
			
			try {
				jsonObject.put("pickup", pickup);
			} catch (JSONException e) {	e.printStackTrace(); }
			
			response.setContentType("application/json");
			response.getWriter().write(jsonObject.toString());
			
		} //  /GenerateTrackNumberCOD
		
		else if (servletPath.equals("/GenerateTrackNumberBANK")) {
			
			System.out.println("Entered GenerateTrackNumberBANK");
			
			/*********** Call API *************/
			
			String paymentType = "BANK";    boolean pickup = false;			
			
			try {				
				
				pickup = callShipTransaction(request, paymentType, pickup);
				
			} catch (SOAPException | ParserConfigurationException | SAXException | ParseException e) {				
				e.printStackTrace();
			}
			
			
			/************* JSON Data for Next Page ****************/
			JSONObject jsonObject = new JSONObject();
			
			try {
				jsonObject.put("pickup", pickup);
			} catch (JSONException e) {	e.printStackTrace(); }
			
			response.setContentType("application/json");
			response.getWriter().write(jsonObject.toString());
			
		} //  /GenerateTrackNumberBANK
		
		else if (servletPath.equals("/SetPickedUp")) {
			
			System.out.println("Entered SetPickedUp");
			
			/********* Get Request **********/
			
			long   orderTableId = Long.parseLong(request.getParameter("orderTableId"));
			String date         = request.getParameter("date");
			String courierName  = request.getParameter("courierName");
			
			boolean picked = false;
			
			/*********** Database *************/		
			picked = sellerDAO.setPickedUp(orderTableId, date, courierName);
			
			
			/************* JSON Data for Next Page ****************/
			JSONObject jsonObject = new JSONObject();
			
			try {
				jsonObject.put("picked", picked);
			} catch (JSONException e) {	e.printStackTrace(); }
			
			response.setContentType("application/json");
			response.getWriter().write(jsonObject.toString());
			
		} //  /SetPickedUp
		
		else if (servletPath.equals("/GetTrackingDetails")) {
			
			System.out.println("Entered GetTrackingDetails");
			
			/********* Get Request **********/
			
			long orderTableId = Long.parseLong(request.getParameter("orderTableId"));		
			
			/*********** Database *************/			
			TrackByNumberInterface trackByNumberInterface = TrackByNumber.getNewInstance();
			
			try {
				
				trackByNumberInterface.getTrackingStatus(orderTableId);
				
			} catch (UnsupportedOperationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SOAPException e) {
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
			
			
			
			/************* JSON Data for Next Page ****************/
			JSONObject jsonObject = new JSONObject();
			
			try {
				jsonObject.put("picked", true);
			} catch (JSONException e) {	e.printStackTrace(); }
			
			response.setContentType("application/json");
			response.getWriter().write(jsonObject.toString());
			
		} //  /GetTrackingDetails
		
		
		else if (servletPath.equals("/SetItemCancelled")) {
			
			System.out.println("Entered SetItemCancelled");
			
			/********* Get Request **********/
			
			long orderTableId = Long.parseLong(request.getParameter("orderTableId"));	
			
			/*********** Database *************/			
			boolean status = sellerDAO.setItemCancelled(orderTableId);	
			//boolean status = true;
			
			/************* JSON Data for Next Page ****************/
			JSONObject jsonObject = new JSONObject();
			
			try {
				jsonObject.put("cancelled", status);
			} catch (JSONException e) {	e.printStackTrace(); }
			
			response.setContentType("application/json");
			response.getWriter().write(jsonObject.toString());
			
		} //  /SetItemCancelled
		
		
		else if (servletPath.equals("/GeneratePDF")) {
			
			System.out.println("Entered GeneratePDF");
			
			/********* Get Request **********/
			
			long orderTableId = Long.parseLong(request.getParameter("orderTableId"));	
			
			/*********** Database *************/			
			String base64 = sellerDAO.generatePDF(orderTableId);	
			//boolean status = true;
			
			/************* JSON Data for Next Page ****************/
			JSONObject jsonObject = new JSONObject();
			
			try {
				jsonObject.put("base64", base64);
			} catch (JSONException e) {	e.printStackTrace(); }
			
			response.setContentType("application/json");
			response.getWriter().write(jsonObject.toString());
			
		} //  /SetItemCancelled
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private boolean callShipTransaction(HttpServletRequest request, String paymentType, boolean pickup) throws SOAPException, IOException, ParserConfigurationException, SAXException, ParseException {
		
		/*********** Get Request *******************/			
		long orderTableId = Long.parseLong(request.getParameter("orderTableId"));  
		
		TrackingIdGenerationInterface trackingIdGeneration = TrackingIdGeneration.getNewInstance();
		
		pickup = trackingIdGeneration.getTrackingNumber(orderTableId, paymentType);  
		
		return pickup;
	}
	
	public static String getEditPageName(String subCategory) {
		
		String editPage = null;  
		
		switch (subCategory) {
		//Electronics
		case "Mobile"            : editPage = "MobileEdit";                      break;
		case "Laptop"            : editPage = "LaptopEdit";                      break;
		//Women
		case "Leggings"          : editPage = "LeggingsEdit";                    break;
		case "Top"               : editPage = "TopEdit";                         break;
		//Men
		case "MenTshirt"         : editPage = "MenTshirtEdit";                   break;
		case "Jeans"             : editPage = "MenJeansEdit";                    break;
		//Kids
		case "Boys_Shirt"        : editPage = "Boys_ShirtEdit";                  break;
		}		
		
		return editPage;
	}
	
}
