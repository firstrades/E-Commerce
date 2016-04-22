package ecom.SERVLET.seller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.json.JSONArray;
import org.json.JSONException;

import ecom.DAO.Seller.EditProductDAO;
import ecom.model.ProductBean;
import ecom.model.Size;
import ecom.model.product.features.LeggingsFeatures;
import ecom.model.product.features.MobileFeatures;
import ecom.model.product.features._LaptopFeatures;
import ecom.model.product.features._TopFeatures;

@MultipartConfig
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EditProductDAO editProductDAO;
 
	@Override
	public void init() {
		editProductDAO = new EditProductDAO();
	}
	
	@Override
	public void destroy() { 
		System.gc();
		System.out.println("EditProductServlet Destroyed"); 
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
		
		if (servletPath.equals("/MobileEdit")) {
			
			System.out.println("Entered MobileEdit");
			
			long productId = 0L;
			
			if(request.getParameter("productId") != null) {
			
				/*********************************************
				 				* Get Request *
				 *********************************************/
				
				productId = Long.parseLong(request.getParameter("productId"));
				
				/*****************************************
				 			* Set Session *
				 *****************************************/
				
				session.setAttribute("productId", productId);
			} else {
				
				/*****************************************
				 			* Get Session *
				 *****************************************/
				productId = (Long) session.getAttribute("productId");				
			}
			
			/*********************************************
			 * Database - Get product table & mobile_spec table 
			 *********************************************/		
			ProductBean productBean       = editProductDAO.getBasicFeatures(productId);
			MobileFeatures mobileFeatures = editProductDAO.getMobileFeatures(productId);
			
			/*****************************************
			 			* Set Request *
			 *****************************************/
			
			request.setAttribute("productBean", productBean);
			request.setAttribute("mobileFeatures", mobileFeatures);
			
			/*********************************************
			 				* Next Page *
			 *********************************************/
			
			request.getRequestDispatcher("jsp_Seller_Product/MobileEditPage.jsp").forward(request, response);
		}
		else if (servletPath.equals("/EditBasicProduct")) {
			
			System.out.println("Entered EditBasicProduct");
			
			/*********************************************
							* Get Request *
			*********************************************/
			
			/*String productId1 = request.getParameter("productId");  
			long productId = Long.parseLong(productId1);
			
			String sellerId1 = request.getParameter("sellerId");
			long   sellerId   = Long.parseLong(sellerId1);
			
			String category         = request.getParameter("category").trim();                  
			String subCategory      = request.getParameter("subCategory").trim(); 
			String company          = request.getParameter("company").trim(); 
			String product          = request.getParameter("product").trim();
			
			String kf1              = request.getParameter("kf1").trim(); 
			String kf2              = request.getParameter("kf2").trim();
			String kf3              = request.getParameter("kf3").trim();
			String kf4              = request.getParameter("kf4").trim();			
			
			Double listPrice        = Double.parseDouble  (request.getParameter("listPrice").trim()); 
			Double discount         = Double.parseDouble  (request.getParameter("discount").trim()); 
			Double salePrice        = Double.parseDouble  (request.getParameter("salePrice").trim()); 	
			
			int stock                = Integer.parseInt    (request.getParameter("stock").trim());
			String warranty          = request.getParameter("warranty").trim();*/
			
			ProductBean productBean = new ProductBean();
			
			productBean.setProductId                 (Long.parseLong(request.getParameter("productId")));				
			
			productBean.setCategory                  (request.getParameter("category"           ));
			productBean.setSubCategory               (request.getParameter("subCategory"        ));
			productBean.setCompanyName               (request.getParameter("companyOfTheProduct").trim());
			productBean.setProductName               (request.getParameter("productName"        ).trim());
			
			productBean.getKeyFeatures().setKf1      (request.getParameter("kf1").trim());
			productBean.getKeyFeatures().setKf2      (request.getParameter("kf2").trim());
			productBean.getKeyFeatures().setKf3      (request.getParameter("kf3").trim());
			productBean.getKeyFeatures().setKf4      (request.getParameter("kf4").trim());	
			
			productBean.getPrice().setManufacturingCost     (Double.parseDouble(request.getParameter("manufacturingCost").trim())     );
			productBean.getPrice().setProfitMarginPercentage(Double.parseDouble(request.getParameter("profitMarginPercentage").trim()));
			productBean.getPrice().setSalePriceToAdmin      (Double.parseDouble(request.getParameter("salePriceToAdmin").trim())      );
			productBean.getPrice().setSalePriceCustomer     (Double.parseDouble(request.getParameter("salePriceToCustomer").trim())   );
			productBean.getPrice().setMarkup                (Double.parseDouble(request.getParameter("markupPercentage").trim())      );				
			productBean.getPrice().setListPrice             (Double.parseDouble(request.getParameter("listPrice").trim())             );
			productBean.getPrice().setDiscount              (Double.parseDouble(request.getParameter("discount").trim())              );								
			
			productBean.setStock                     (Integer.parseInt(request.getParameter("stock").trim())             );
			productBean.setWeight                    (Double.parseDouble(request.getParameter("weight").trim())          );
			productBean.setWarranty                  (request.getParameter("warranty").trim()                            );
			productBean.setCancellationAfterBooked   (Integer.parseInt(request.getParameter("cancellationPeriod").trim()));
			
			
			/*******************************************************
			 	*  Database - Edit Product Table  *
			*******************************************************/		
			productBean = editProductDAO.editProduct(productBean);
			
			/*********************************************
						* JSON Response *
			*********************************************/
			
			JSONArray jsonArray = new JSONArray();
			
			try {
				
				jsonArray.put(productBean.getCategory());
				jsonArray.put(productBean.getSubCategory());
				jsonArray.put(productBean.getCompanyName());
				jsonArray.put(productBean.getProductName());
				jsonArray.put(productBean.getKeyFeatures().getKf1());
				jsonArray.put(productBean.getKeyFeatures().getKf2());
				jsonArray.put(productBean.getKeyFeatures().getKf3());
				jsonArray.put(productBean.getKeyFeatures().getKf4());			
				jsonArray.put(productBean.getPrice().getListPrice());
				jsonArray.put(productBean.getPrice().getDiscount());
				jsonArray.put(productBean.getPrice().getSalePriceCustomer());
				jsonArray.put(productBean.getStock());
				jsonArray.put(productBean.getWarranty());
				
			} catch (JSONException e) {				
				e.printStackTrace();
			}
			
			/*********************************************
							* Next Page *
			*********************************************/
			
			response.setContentType("application/json");
			response.getWriter().write(jsonArray.toString());
			
			//response.sendRedirect("MobileEdit");
		}
		else if (servletPath.equals("/EditIconImage")) {
			
			System.out.println("Entered EditIconImage");
			
			/*********************************************
						* Get Request *
			*********************************************/
			
			String productId1 = request.getParameter("productId");   
			long productId = Long.parseLong(productId1);
			
			String sellerId1 = request.getParameter("sellerId");
			long sellerId    = Long.parseLong(sellerId1);
			
			Part part               = request.getPart("iconImage");			
			InputStream inputStream = part.getInputStream();               
			
			/*******************************************************
			 	*  Database - Edit Product Table  *
			*******************************************************/			
			@SuppressWarnings("unused")
			boolean status = editProductDAO.editImage(productId, sellerId, inputStream, "iconImage");
			
			/*********************************************
						* Next Page *
			*********************************************/
			
			//response.sendRedirect("MobileEdit");
		}
		else if (servletPath.equals("/EditImage1")) {
			
			System.out.println("Entered EditImage1");
			
			/*********************************************
						* Get Request *
			*********************************************/
			
			String productId1 = request.getParameter("productId");  
			long productId = Long.parseLong(productId1);
			
			String sellerId1 = request.getParameter("sellerId");
			long sellerId    = Long.parseLong(sellerId1);
			
			Part part               = request.getPart("image1");			
			InputStream inputStream = part.getInputStream();               
			
			/*******************************************************
			 	*  Database - Edit Product Table  *
			*******************************************************/		
			@SuppressWarnings("unused")
			boolean status = editProductDAO.editImage(productId, sellerId, inputStream, "image1");
			
			/*********************************************
						* Next Page *
			*********************************************/
			
			//response.sendRedirect("MobileEdit");
		}
		else if (servletPath.equals("/EditImage2")) {
	
			System.out.println("Entered EditImage2");
			
			/*********************************************
						* Get Request *
			*********************************************/
			
			String productId1 = request.getParameter("productId");  
			long productId = Long.parseLong(productId1);
			
			String sellerId1 = request.getParameter("sellerId");
			long sellerId    = Long.parseLong(sellerId1);
			
			Part part               = request.getPart("image2");			
			InputStream inputStream = part.getInputStream();               
			
			/*******************************************************
			 	*  Database - Edit Product Table  *
			*******************************************************/			
			@SuppressWarnings("unused")
			boolean status = editProductDAO.editImage(productId, sellerId, inputStream, "image2");
			
			/*********************************************
						* Next Page *
			*********************************************/
			
			//response.sendRedirect("MobileEdit");
		}
		
		else if (servletPath.equals("/EditMobileAdvanceFeatures")) {
			
			System.out.println("Entered EditMobileAdvanceFeatures");
			
			/*********************************************
						* Get Request *
			*********************************************/
			
			String productId1 = request.getParameter("productId");  
			long productId = Long.parseLong(productId1);
			
			String sellerId1 = request.getParameter("sellerId");
			long   sellerId  = Long.parseLong(sellerId1);
			
			String internalStorage = request.getParameter("internalStorage").trim();                  
			String os              = request.getParameter("os").trim(); 
			String touch           = request.getParameter("touch").trim(); 
			String wifi            = request.getParameter("wifi").trim();			
			String fm              = request.getParameter("fm").trim(); 
			String frontCamera     = request.getParameter("frontCamera").trim();
			String rearCamera      = request.getParameter("rearCamera").trim();
			String connectivity    = request.getParameter("connectivity").trim();			
			
			
			/*******************************************************
				*  Database - Edit Product Table  *
			*******************************************************/
			MobileFeatures mobileFeatures = editProductDAO.editMobileFeatures(productId, sellerId, internalStorage, os, touch, wifi, fm, frontCamera,
					rearCamera, connectivity);
			
			/*********************************************
						* JSON Response *
			*********************************************/
			
			JSONArray jsonArray = new JSONArray();
			
			jsonArray.put(mobileFeatures.getConnectivity());
			jsonArray.put(mobileFeatures.getFm());
			jsonArray.put(mobileFeatures.getFrontCamera());
			jsonArray.put(mobileFeatures.getInternalStorage());
			jsonArray.put(mobileFeatures.getOs());
			jsonArray.put(mobileFeatures.getRearCamera());
			jsonArray.put(mobileFeatures.getTouch());
			jsonArray.put(mobileFeatures.getWifi());
			
			/*********************************************
						* Next Page *
			*********************************************/
			
			response.setContentType("application/json");
			response.getWriter().write(jsonArray.toString());
			
			//response.sendRedirect("MobileEdit");
		
		}
		
		else if (servletPath.equals("/LeggingsEdit")) {
			
			System.out.println("Entered LeggingsEdit");
			
			long productId = 0L;
			
			if(request.getParameter("productId") != null) {
			
				/************** Get Request *****************/				
				productId = Long.parseLong(request.getParameter("productId"));
				
				/************** Set Session *****************/				
				session.setAttribute("productId", productId);
				
			} else {
				
				/************** Get Session *****************/
				productId = (Long) session.getAttribute("productId");				
			}
			
			/********** Database - Get product table & p_leggings_spec table ***************/			
			ProductBean productBean           = editProductDAO.getBasicFeatures(productId);
			LeggingsFeatures leggingsFeatures = editProductDAO.getLeggingsFeatures(productId);
			Size size                         = editProductDAO.getSizes(productId);
			
			/*****************************************
			 			* Set Request *
			 *****************************************/
			
			request.setAttribute("productBean",      productBean     );
			request.setAttribute("leggingsFeatures", leggingsFeatures);
			request.setAttribute("size",             size            );
			
			/*********************************************
			 				* Next Page *
			 *********************************************/
			
			request.getRequestDispatcher("jsp_Seller_Product/LeggingsEditPage.jsp").forward(request, response);
		}
		
		else if (servletPath.equals("/EditLeggingsAdvanceFeatures")) {
			
			System.out.println("Entered EditLeggingsAdvanceFeatures");
			
			/*********************************************
						* Get Request *
			*********************************************/
			
			String productId1 = request.getParameter("productId");  
			long productId = Long.parseLong(productId1);
			
			String sellerId1 = request.getParameter("sellerId");
			long   sellerId  = Long.parseLong(sellerId1);
			
			String pattern    = request.getParameter("pattern")  .trim();                  
			String fabric     = request.getParameter("fabric")   .trim(); 
			String style      = request.getParameter("style")    .trim(); 
			String season     = request.getParameter("season")   .trim();			
			String waistband  = request.getParameter("waistband").trim(); 
					
			
			
			/*******************************************************
				*  Database - Edit Product Table  *
			*******************************************************/
			LeggingsFeatures leggingsFeatures = editProductDAO.editLeggingsFeatures(productId, sellerId, pattern,
					fabric, style, season, waistband);
			
			/*********************************************
						* JSON Response *
			*********************************************/
			
			JSONArray jsonArray = new JSONArray();
			
			jsonArray.put(leggingsFeatures.getPattern()  );
			jsonArray.put(leggingsFeatures.getFabric()   );
			jsonArray.put(leggingsFeatures.getStyle()    );
			jsonArray.put(leggingsFeatures.getSeason()   );
			jsonArray.put(leggingsFeatures.getWaistband());			
			
			/*********************************************
						* Next Page *
			*********************************************/
			
			response.setContentType("application/json");
			response.getWriter().write(jsonArray.toString());			
			
		
		} //EditLeggingsAdvanceFeatures
		
		else if (servletPath.equals("/EditSizeFeatures")) {
			
			System.out.println("Entered EditSizeFeatures");
			
			/************ Get Request *****************/		
			
			 
			long productId = Long.parseLong(request.getParameter("productId"));		    System.out.println("productId: " + productId); 
			long sellerId  = Long.parseLong(request.getParameter("sellerId"));
			
			int size26  = Integer.parseInt(request.getParameter("size26").trim());      System.out.println("size26: " + size26);            
			int size28  = Integer.parseInt(request.getParameter("size28").trim()); 
			
			int size30  = Integer.parseInt(request.getParameter("size30").trim());                  
			int size32  = Integer.parseInt(request.getParameter("size32").trim()); 
			int size34  = Integer.parseInt(request.getParameter("size34").trim());                  
			int size36  = Integer.parseInt(request.getParameter("size36").trim()); 
			int size38  = Integer.parseInt(request.getParameter("size38").trim()); 
			
			int size40  = Integer.parseInt(request.getParameter("size40").trim()); 
			int size42  = Integer.parseInt(request.getParameter("size42").trim());                  
			int size44  = Integer.parseInt(request.getParameter("size44").trim()); 
			int size46  = Integer.parseInt(request.getParameter("size46").trim());                  
			int size48  = Integer.parseInt(request.getParameter("size48").trim()); 
					
			
			
			/*************  Database - Edit Product Table  *************/			
			Size size = editProductDAO.editSizes(productId, sellerId, size26, size28, size30, size32, size34, size36, size38,
					size40, size42, size44, size46, size48);
			
			
			/*************** JSON Response ***********/		
			
			JSONArray jsonArray = new JSONArray();
			
			jsonArray.put(size.getQtyOfSize26());
			jsonArray.put(size.getQtyOfSize28());
			jsonArray.put(size.getQtyOfSize30());
			jsonArray.put(size.getQtyOfSize32());
			jsonArray.put(size.getQtyOfSize34());
			jsonArray.put(size.getQtyOfSize36());
			jsonArray.put(size.getQtyOfSize38());
			jsonArray.put(size.getQtyOfSize40());
			jsonArray.put(size.getQtyOfSize42());
			jsonArray.put(size.getQtyOfSize44());
			jsonArray.put(size.getQtyOfSize46());
			jsonArray.put(size.getQtyOfSize48());
			
			/*********************************************
						* Next Page *
			*********************************************/
			
			response.setContentType("application/json");
			response.getWriter().write(jsonArray.toString());			
			
		
		} //EditSizeFeatures
		
		
		
		
		
		
		
		
		
		
		
		
		
		/************ Laptop ************/
		
		else if (servletPath.equals("/LaptopEdit")) {
			
			System.out.println("Entered LaptopEdit");
			
			long productId = 0L;
			
			if(request.getParameter("productId") != null) {
			
				/************** Get Request *****************/				
				productId = Long.parseLong(request.getParameter("productId"));
				
				/************** Set Session *****************/				
				session.setAttribute("productId", productId);
				
			} else {
				
				/************** Get Session *****************/
				productId = (Long) session.getAttribute("productId");				
			}
			
			/********** Database - Get product table & p_leggings_spec table ***************/			
			ProductBean productBean        = editProductDAO.getBasicFeatures(productId);
			_LaptopFeatures laptopFeatures = editProductDAO.getLaptopFeatures(productId);
			
			
			/*****************************************
			 			* Set Request *
			 *****************************************/
			
			request.setAttribute("productBean",      productBean     );
			request.setAttribute("laptopFeatures",   laptopFeatures);
			
			
			/*********************************************
			 				* Next Page *
			 *********************************************/
			
			request.getRequestDispatcher("jsp_Seller_Product/LaptopEditPage.jsp").forward(request, response);
		} //LaptopEdit
		
		else if (servletPath.equals("/EditLaptopAdvanceFeatures")) {
			
			System.out.println("Entered EditLaptopAdvanceFeatures");
			
			/*********************************************
						* Get Request *
			*********************************************/
			
			String productId1 = request.getParameter("productId");  
			long productId = Long.parseLong(productId1);
			
			String sellerId1 = request.getParameter("sellerId");
			long   sellerId  = Long.parseLong(sellerId1);
			
			String webCamera         = request.getParameter("webCamera")       .trim();                  
			String powerSupply       = request.getParameter("powerSupply")     .trim(); 
			String batteryCell       = request.getParameter("batteryCell")     .trim(); 
			String screenSize        = request.getParameter("screenSize")      .trim();			
			String hddCapacity       = request.getParameter("hddCapacity")     .trim(); 
			String graphicProcessor  = request.getParameter("graphicProcessor").trim();
			String os                = request.getParameter("os")              .trim();
			String processor         = request.getParameter("processor")       .trim();			
					
			
			
			/*******************************************************
				*  Database - Edit Product Table  *
			*******************************************************/
			_LaptopFeatures laptopFeatures = editProductDAO.editLaptopFeatures(productId, sellerId, webCamera,
					powerSupply, batteryCell, screenSize, hddCapacity, graphicProcessor, os, processor);
			
			/*********************************************
						* JSON Response *
			*********************************************/
			
			JSONArray jsonArray = new JSONArray();
			
			jsonArray.put(laptopFeatures.getId());
			jsonArray.put(laptopFeatures.getProductId()       );
			jsonArray.put(laptopFeatures.getSellerId()        );
			jsonArray.put(laptopFeatures.getWebCamera()       );
			jsonArray.put(laptopFeatures.getPowerSupply()     );
			jsonArray.put(laptopFeatures.getBatteryCell()     );					
			jsonArray.put(laptopFeatures.getScreenSize()      );
			jsonArray.put(laptopFeatures.getHddCapacity()     );
			jsonArray.put(laptopFeatures.getGraphicProcessor());
			jsonArray.put(laptopFeatures.getOs()              );
			jsonArray.put(laptopFeatures.getProcessor()       );  
			
			/*********************************************
						* Next Page *
			*********************************************/
			
			response.setContentType("application/json");
			response.getWriter().write(jsonArray.toString());			
			
		
		} //EditLaptopAdvanceFeatures 
		
		
		
		
		
		
		
		
		
		
		
		/************* TOP ************/
		
		else if (servletPath.equals("/TopEdit")) {
			
			System.out.println("Entered TopEdit");
			
			long productId = 0L;
			
			if(request.getParameter("productId") != null) {
			
				/************** Get Request *****************/				
				productId = Long.parseLong(request.getParameter("productId"));
				
				/************** Set Session *****************/				
				session.setAttribute("productId", productId);
				
			} else {
				
				/************** Get Session *****************/
				productId = (Long) session.getAttribute("productId");				
			}
			
			/********** Database - Get product table & p_leggings_spec table ***************/			
			ProductBean productBean  = editProductDAO.getBasicFeatures(productId);
			_TopFeatures topFeatures = editProductDAO.getTopFeatures(productId);
			Size size                = editProductDAO.getSizes(productId);
			
			/*****************************************
			 			* Set Request *
			 *****************************************/
			
			request.setAttribute("productBean", productBean);
			request.setAttribute("topFeatures", topFeatures);
			request.setAttribute("size",        size       );
			
			/*********************************************
			 				* Next Page *
			 *********************************************/
			
			request.getRequestDispatcher("jsp_Seller_Product/TopEditPage.jsp").forward(request, response);
		} // TopEdit
		
		else if (servletPath.equals("/EditTopAdvanceFeatures")) {
			
			System.out.println("Entered EditTopAdvanceFeatures");
			
			/*********************************************
						* Get Request *
			*********************************************/
			
			String productId1 = request.getParameter("productId");  
			long productId = Long.parseLong(productId1);
			
			String sellerId1 = request.getParameter("sellerId");
			long   sellerId  = Long.parseLong(sellerId1);
			
			String sleeve    = request.getParameter("sleeve")  .trim();                  
			String fabric    = request.getParameter("fabric")  .trim(); 
			String neck      = request.getParameter("neck")    .trim(); 
			String pattern   = request.getParameter("pattern") .trim();			
			String occasion  = request.getParameter("occasion").trim(); 
					
			
			
			/*******************************************************
				*  Database - Edit Product Table  *
			*******************************************************/
			_TopFeatures topFeatures = editProductDAO.editTopFeatures(productId, sellerId, sleeve,
					fabric, neck, pattern, occasion);
			
			/*********************************************
						* JSON Response *
			*********************************************/
			
			JSONArray jsonArray = new JSONArray();
			
			jsonArray.put(topFeatures.getId        ());
			jsonArray.put(topFeatures.getProductId ());
			jsonArray.put(topFeatures.getSellerId  ());
			jsonArray.put(topFeatures.getSleeve    ());
			jsonArray.put(topFeatures.getFabric    ());
			jsonArray.put(topFeatures.getNeck      ());
			jsonArray.put(topFeatures.getPattern   ());
			jsonArray.put(topFeatures.getOccasion  ());
			
			/*********************************************
						* Next Page *
			*********************************************/
			
			response.setContentType("application/json");
			response.getWriter().write(jsonArray.toString());			
			
		
		} //EditTopAdvanceFeatures
	}
}
