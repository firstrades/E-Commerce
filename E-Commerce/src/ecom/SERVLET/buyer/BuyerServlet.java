package ecom.SERVLET.buyer;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ecom.DAO.Buyer.BuyerSearchDAO;
import ecom.DAO.User.UserDAO;
import ecom.beans.CartAttributesBean;
import ecom.beans.ApiDataMultiThreadBean;
import ecom.beans.TransientData;
import ecom.model.ProductBean;
import ecom.model.TwoObjects;
import ecom.model.User;

public class BuyerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String servletPath = request.getServletPath();
		
		HttpSession session = request.getSession();
		
		if (servletPath.equals("/SearchBySubCategory")) {
			
			System.out.println("Entered SearchBySubCategory");
			Integer MAX = 50;
			
			/******************************************
			 			*  Get Request  *
			 ******************************************/			
			String subCategory = request.getParameter("subCategory");         //System.out.println(subCategory);				
						
			
			/******************************************
			 	* Database Search for product table *
			 ******************************************/
			BuyerSearchDAO buyerSearchDAO      = new BuyerSearchDAO();
			List<ProductBean> productBeanList1 = buyerSearchDAO.searchBySubCategory(subCategory);	
			
			/*********************************************
			 				* Process *
			 *********************************************/
			
			List<ProductBean> productBeanList = new ArrayList<>();
			
			if (productBeanList1.size() < MAX)    // set MAX
				MAX = productBeanList1.size();
			
			for (int i = 0; i < MAX; i++) {
				
				ProductBean productBean = new ProductBean();				
				
				productBean = productBeanList1.get(i);	System.out.println(i);	//Make a list of MAX data out of total list		
				productBeanList.add(productBean);
			}
			
			//int productBeanList1_Size = productBeanList1.size();
			
			/******************************************
			 			* Set Session *
			 ******************************************/			
			session.setAttribute("productBeanList1", productBeanList1);			
			
			/******************************************
			 			* Set Request *
			 ******************************************/
			request.setAttribute("productBeanList", productBeanList);
			request.setAttribute("MAX", MAX);
			
			/******************************************
			 			* Next Page *
			 ******************************************/
			request.getRequestDispatcher("jsp_Buyer/BuyerSearchPage.jsp").forward(request, response);
	
		} 
		
		else if (servletPath.equals("/SearchBySubCategory_Ajax")) {
			
			System.out.println("Entered SearchBySubCategory_Ajax");
			
			Integer MAX = 50;
			
			/******************************************
			 			*  Get Request  *
			 ******************************************/			
			//String subCategory = request.getParameter("subCategory");         System.out.println(subCategory);
			String MIN1        = request.getParameter("MAX1");              //System.out.println("MIN1: " + MIN1);
			
			/******************************************
			 			*  Get Session  *                   
			 ******************************************/			
			@SuppressWarnings("unused")
			String buyerCode = (String) session.getAttribute("buyerCode");    // no use till now
			@SuppressWarnings("unchecked")
			List<ProductBean> productBeanList1 = (List<ProductBean>) session.getAttribute("productBeanList1");
			
			/******************************************
							* Process *
			******************************************/
			
			int MIN = Integer.parseInt(MIN1);
			int itemMAX = MIN + MAX;			
			int productBeanList1_Size = productBeanList1.size();
			boolean residueProduct = false;
			
			if (itemMAX > productBeanList1_Size) {
				
				itemMAX = productBeanList1_Size;
				residueProduct = true;
			}			
			
			List<ProductBean> productBeanList = new ArrayList<>();
			
			for (int i = MIN; i < itemMAX; i++) {
				
				ProductBean productBean = new ProductBean();				
				
				productBean = productBeanList1.get(i);				
				productBeanList.add(productBean);
			}
			
			
			
			/******************************************
			 	* Database Search for product table *
			 ******************************************/
			//BuyerSearchDAO buyerSearchDAO = new BuyerSearchDAO();
			//List<ProductBean> productBeanList = buyerSearchDAO.searchBySubCategory(subCategory);		
			
			/*********************************************
			 				* Create JSON data *
			 *********************************************/
			
			JSONObject jsonObject;
			JSONArray jsonArray = new JSONArray();		
			JSONObject object = new JSONObject();
			
			try {
				
				for (ProductBean bean : productBeanList) {
					
					jsonObject = new JSONObject();
					
					jsonObject.put("productId",    bean.getProductId());
					jsonObject.put("category",     bean.getCategory());
					jsonObject.put("companyName",  bean.getCompanyName());			
					jsonObject.put("kf1",          bean.getKeyFeatures().getKf1());
					jsonObject.put("kf2",          bean.getKeyFeatures().getKf2());
					jsonObject.put("kf3",          bean.getKeyFeatures().getKf3());
					jsonObject.put("kf4",          bean.getKeyFeatures().getKf4());
					jsonObject.put("discount",     bean.getPrice().getDiscount());
					jsonObject.put("listPrice",    bean.getPrice().getListPrice());
					jsonObject.put("salePriceCustomer",    bean.getPrice().getSalePriceCustomer());
					jsonObject.put("productName",  bean.getProductName());
					jsonObject.put("sellerCode",   bean.getSellerId());
					jsonObject.put("subCategory",  bean.getSubCategory());
				
					jsonArray.put(jsonObject);
				}
				
				object.put("list", jsonArray);
				object.put("max", itemMAX);
				if (productBeanList.isEmpty())
					object.put("hideLoadMore", true);
				if (residueProduct == true)
					object.put("residueProduct", residueProduct);
				
				
				
			} catch (JSONException e) {		
				e.printStackTrace();
			}		
			
			System.out.println(jsonArray.toString());
			
			/*******************************************
			 				* Next Page *
			 *******************************************/
			response.setContentType("application/json");
			response.getWriter().write(object.toString());
	
		}	
		
		else if (servletPath.equals("/AddToCartOrWishlist")) {
			
				System.out.println("Entered AddToCartOrWishlist");
				
				/*************** Get Request **************/
				
					String size1            = (String) request.getParameter("size");  
					//  for add to cart/wishlist
					String move             = (String) request.getParameter("move");  				
					String productId111     = (String) request.getParameter("productId");
					String cartOrWishlist   = (String) request.getParameter("cartOrWishlist"); 
					
				/*************** Get Session **************/
					
					User user = (User) session.getAttribute("user");
					
				/*************** Process ******************/
					
					Long productId = 0L;
					int qty = 0;
					if (productId111 != null) {
						productId = Long.parseLong(productId111);
						int stock = TransientData.getStock(productId);
						qty = (stock == 0) ? 0 : 1; 
					}
					
					int size = Integer.parseInt(size1);
					
				/*************** Database *****************/
				
					List<TwoObjects<ProductBean, Integer>> productBeanAndQtyList = null;//, productBeanAndQtyList1 = null;
					
					BuyerSearchDAO buyerSearchDAO = new BuyerSearchDAO();
					
					if (move == null) {
						productBeanAndQtyList = buyerSearchDAO.addToCartOrWishList(productId, user.getUserInfo().getId(), cartOrWishlist, size);
						//productBeanAndQtyList1 = productBeanAndQtyList;
					}
					else   //  for add to cart/wishlist
						productBeanAndQtyList = buyerSearchDAO.moveToCartOrWishList(productId, user.getUserInfo().getId(), cartOrWishlist,
								qty, size);
					
				/*************** Thread Call For API Rate & Delivery ****************/
					
					List<TwoObjects<BigDecimal, String>> apiDataList = null;
					
					//if (productBeanAndQtyList1 != null) {
						ApiDataMultiThreadBean getApiDataMultiThread  = new ApiDataMultiThreadBean(productBeanAndQtyList, user);
						apiDataList = getApiDataMultiThread.getRateAndDeliveryList();
					//}
					
				/********** Set Session *******************/
					//if (productBeanAndQtyList1 != null) {						
						session.setAttribute("apiDataList", apiDataList);
					//}
					
				/************** Set Request ***************/
					
					request.setAttribute("productBeanAndQtyList", productBeanAndQtyList);
					request.setAttribute("apiDataList", apiDataList);
					
				/************** Next Page *****************/
					
					if (move == null) {
					
							if (cartOrWishlist.equals("cart")) {  // cart page					
								request.getRequestDispatcher("jsp_Buyer/Cart.jsp").forward(request, response);
							} else {                              // wishlist page
								request.getRequestDispatcher("jsp_Buyer/Wishlist.jsp").forward(request, response);
							}	
					} else {   
							// toggle the pages for 'Add to cart/wishlist'
							if (cartOrWishlist.equals("cart")) {  // wishlist page					
								request.getRequestDispatcher("jsp_Buyer/Wishlist.jsp").forward(request, response);
							} else {                              // cart page
								request.getRequestDispatcher("jsp_Buyer/Cart.jsp").forward(request, response);
							}	
					}
			
		}
		
		else if (servletPath.equals("/DeleteFromCartWishlistTable")) {
			
			System.out.println("Entered DeleteFromCartWishlistTable");
			
				/*************** Get Request **************/
				
					String productId111     = (String) request.getParameter("productId");
					String cartOrWishlist   = (String) request.getParameter("cartOrWishlist"); 
				
				/*************** Get Session **************/
				
					User user = (User) session.getAttribute("user");
				
				/*************** Process ******************/
				
					Long productId = 0L;
					if (productId111 != null)
						productId = Long.parseLong(productId111);
					
				/*************** Database *****************/				
					
					boolean status = false;
					
					BuyerSearchDAO buyerSearchDAO = new BuyerSearchDAO();
					status = buyerSearchDAO.deleteCartOrWishListItem(productId, user.getUserInfo().getId(), cartOrWishlist);
					
					CartAttributesBean cartAttributesBean = CartAttributesBean.getInstance();
					int    totalQty = cartAttributesBean.getTotalQty(user.getUserInfo().getId());
					double totalSum = cartAttributesBean.getTotalAmount(user.getUserInfo().getId());
					
				/************** Set Request ***************/
					
					JSONObject jsonObject = new JSONObject();
					
					if (status == true) {
						
							try {
								jsonObject.put("status", true);
								jsonObject.put("totalQty", totalQty);
								jsonObject.put("totalSum", totalSum);
							} catch (JSONException e) {							
								e.printStackTrace();
							}
					} else {
						
							try {
								jsonObject.put("status", false);
							} catch (JSONException e) {							
								e.printStackTrace();
							}
					}
					
					response.setContentType("application/json");
					response.getWriter().write(jsonObject.toString());   System.out.println(jsonObject.toString());
			
		}
		
		else if (servletPath.equals("/InsertQtyToCart")) {
			
				System.out.println("Entered InsertQtyToCart");
			
				/*************** Get Request **************/
			
				String productId111  = (String) request.getParameter("productId");
				String qty111        = (String) request.getParameter("qty");          
		
				/*************** Get Session **************/
			
				User user = (User) session.getAttribute("user");
			
				/*************** Process ******************/
			
				Long productId = Long.parseLong(productId111);        System.out.println("productId: " + productId);
				int qty        = Integer.parseInt(qty111);
				int stock      = TransientData.getStock(productId);
				int tempQty    = qty;
				
				qty = (qty > stock) ? stock : qty;   //if (qty > stock)  qty = stock;				 
				
				/*************** Database *****************/			
				
				BuyerSearchDAO buyerSearchDAO = new BuyerSearchDAO();
				int qty1 = buyerSearchDAO.insertQtyOfRow(user.getUserInfo().getId(), qty, productId);
				
				CartAttributesBean cartAttributesBean = CartAttributesBean.getInstance();
				int                totalQty           = cartAttributesBean.getTotalQty(user.getUserInfo().getId());
				double             totalSum           = cartAttributesBean.getTotalAmount(user.getUserInfo().getId());
				
				/************** Set Request ***************/
				
				JSONObject jsonObject = new JSONObject();				
				
					
				try {
					if (tempQty > stock)
						jsonObject.put("stock", "In Stock: " + stock + " only");
					
					jsonObject.put("qty",      qty1);
					jsonObject.put("totalQty", totalQty);
					jsonObject.put("totalSum", totalSum);
				} catch (JSONException e) {							
					e.printStackTrace();
				}
				
				
				response.setContentType("application/json");
				response.getWriter().write(jsonObject.toString());   
			
		}  // InsertQtyToCart
		
		else if (servletPath.equals("/Account")) {
			
			System.out.println("Entered Account");
		}
		
		else if (servletPath.equals("/CallRegistrationPage")) {
			
			request.getRequestDispatcher("jsp_Buyer/Registration.jsp").forward(request, response);
		}
		
	
		
		else if (servletPath.equals("/CheckUserId")) {
			
			System.out.println("Enter CheckUserId");
			
			PrintWriter out = response.getWriter();
			
			String User_Id = request.getParameter("user_id").trim();
			String msg = "";
			
			try {
				
				msg = UserDAO.CheckUserId(User_Id);
				System.out.println(msg+"YYYYYYYYYY");
				
				if (msg != null) {
					
					if (msg.equalsIgnoreCase("User_Id Is Already exists")) {
						
						out.print("User_Id Is Already exists");
					} else {
						
						out.print("User_Id Is Accepted");
					}
			} 
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		 }
		
		else if(servletPath.equals("/OrderHistroy")) {
			System.out.println("Enter OrderHistroy");
			
			/******* Get Session ******/
			User user = (User) session.getAttribute("user");
			
			/******* DataBase *******/
			
			BuyerSearchDAO dao = new BuyerSearchDAO();
			dao.getOrderIdForCustomer(user);		
			dao.getCustomerOrderHistroy(user);
			
			/****** NextPage ******/
			request.getRequestDispatcher("jsp_Buyer/Orderhistory.jsp").forward(request, response);

		}
		
	}
}
