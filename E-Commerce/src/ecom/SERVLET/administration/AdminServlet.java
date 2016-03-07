package ecom.SERVLET.administration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ecom.DAO.User.CreateUserDAO;
import ecom.DAO.administration.AdminDAO;
import ecom.model.ExtractFranchiseDetails;
import ecom.model.OrderTable;
import ecom.model.ProductBean;
import ecom.model.User;
import ecom.model.UserAndPickupAddress;

@MultipartConfig
public class AdminServlet extends HttpServlet {
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
			
			
			if (servletPath.equals("/RetrieveProductForApproval")) {
				
					System.out.println("Entered RetrieveProductForApproval");				
					
					/***************** DataBase ***********************/					
					AdminDAO adminDAO = new AdminDAO();
					List<ProductBean> productBeans = adminDAO.getAwaitingProductList();
					
					/************ Data for next page ******************/
					
					JSONObject items = new JSONObject();
					JSONArray jsonArray = new JSONArray();
					
					if (productBeans != null) {
						
						try {
						
							for (ProductBean productBean : productBeans) {
						
									JSONObject jsonObject = new JSONObject();
									
									jsonObject.put("productId",     productBean.getProductId()    );
									jsonObject.put("sellerId",     productBean.getSellerId()     );
									jsonObject.put("sellerCompany", productBean.getSellerCompany());
									
									jsonObject.put("category",    productBean.getCategory()     );
									jsonObject.put("sub_category",productBean.getSubCategory()  );							
									jsonObject.put("companyName", productBean.getCompanyName()  );	
									jsonObject.put("productName", productBean.getProductName()  );
									
									jsonObject.put("listPrice",              productBean.getPrice().getListPrice()             );
									jsonObject.put("discount",               productBean.getPrice().getDiscount()              );
									jsonObject.put("salePriceCustomer",      productBean.getPrice().getSalePriceCustomer()     );
									jsonObject.put("markupPercentage",       productBean.getPrice().getMarkup()                );
									jsonObject.put("salePriceToAdmin",       productBean.getPrice().getSalePriceToAdmin()      );
									jsonObject.put("manufacturingCost",      productBean.getPrice().getManufacturingCost()     );
									jsonObject.put("profitMarginPercentage", productBean.getPrice().getProfitMarginPercentage());
									
									jsonObject.put("stock",                         productBean.getStock()                  );
									jsonObject.put("weight",                        productBean.getWeight()                 );			
									jsonObject.put("warranty",                      productBean.getWarranty()               );										
									jsonObject.put("calcellationAfterBookedInDays", productBean.getCancellationAfterBooked());									
									
									jsonObject.put("fCommissionPercentage", productBean.getCommission().getFranchiseCommission()  );
									jsonObject.put("dCommissionPercentage", productBean.getCommission().getDistributorCommission());
									
									jsonArray.put(jsonObject);									
							
						
							}  // for close
						
							items.put("items", jsonArray);
						
						} catch (JSONException e) {								
							e.printStackTrace();
						}
						
						response.setContentType("application/json");
						response.getWriter().write(items.toString());
						
					} // if close
					
			} // RetrieveProductForApproval
			
			else if (servletPath.equals("/ApproveProduct")) {
				
					System.out.println("Entered ApproveProduct");								
					
					ProductBean productBean = new ProductBean();					
					
			        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			        
			        String jsonData = null;
			        
			        if (br != null) {
			        	
			            jsonData = br.readLine();                               
			        }
			        
			        try {
			        	
						JSONObject jsonObject1 = new JSONObject(jsonData);
						
						productBean.setProductId(Long.parseLong(jsonObject1.getString("productId")));          
						
						productBean.getPrice().setDiscount(Math.floor(Double.parseDouble(jsonObject1.getString("discount"))));              
						productBean.getPrice().setSalePriceCustomer(Math.ceil(Double.parseDouble(jsonObject1.getString("salePriceToCustomer"))));
						productBean.getPrice().setMarkup(Double.parseDouble(jsonObject1.getString("markupPercentage")));
						productBean.getPrice().setSalePriceToAdmin(Double.parseDouble(jsonObject1.getString("salePriceToAdmin")));     
						productBean.getPrice().setProfitMarginPercentage(Double.parseDouble(jsonObject1.getString("profitMarginPercentage"))); 
						
						productBean.getCommission().setFranchiseCommission(Double.parseDouble(jsonObject1.getString("franComm")));               
						productBean.getCommission().setDistributorCommission(Double.parseDouble(jsonObject1.getString("drisComm")));             
						
						productBean.setWeight(Double.parseDouble(jsonObject1.getString("weight")));               
						productBean.setWarranty(jsonObject1.getString("warranty"));              
						productBean.setCancellationAfterBooked(Integer.parseInt(jsonObject1.getString("cancellationAfterBooked"))); 
						
						
					} catch (JSONException e) {				
						e.printStackTrace();
					}		
					
				
					/***************** DataBase ***********************/					
					AdminDAO adminDAO = new AdminDAO();
					boolean status = adminDAO.setProductApprove(productBean);   System.out.println(status);
					
					/***************  Send Response  *****************/
					
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
			} // ApproveProduct
			
			else if (servletPath.equals("/FranchiseRegistration")) {
				
					System.out.println("Entered FranchiseRegistration");
					
					/******************* Set Request *************/
					
					String title          = "Registration For Franchise";
					String submitFunction = "createFranchise()";
					
					request.setAttribute("title",          title);
					request.setAttribute("submitFunction", submitFunction);
					
					/***************  Next Page  *****************/
					request.getRequestDispatcher("jsp_Administration/FranchiseRegistration.jsp").forward(request, response);
				
			} // FranchiseRegistration
			
			else if (servletPath.equals("/AddFranchise")) {
				
					System.out.println("Entered AddFranchise");
					
					/*********** Get Request ***************/
					
					BufferedReader buffer = new BufferedReader(new InputStreamReader(request.getInputStream()));
					
					String json = buffer.readLine();
					
					JSONObject keyValue;
					String userId = null, password = null, fName = null, lName = null, sex = null, company = null, mobile1 = null, mobile2 = null, 
							email1 = null, email2 = null, phone1 = null, phone2 = null, fax1 = null, fax2 = null, address = null, city = null, 
							state = null, pin = null, pan = null, voterId = null;
					try {
						keyValue = new JSONObject(json);
						
						userId   = (String) keyValue.get("userId"  );   
						password = (String) keyValue.get("password");
						fName    = (String) keyValue.get("fName"   );
						lName    = (String) keyValue.get("lName"   );
						sex      = (String) keyValue.get("sex"     );
						company  = (String) keyValue.get("company" );
						mobile1  = (String) keyValue.get("mobile1" );
						mobile2  = (String) keyValue.get("mobile2" );
						email1   = (String) keyValue.get("email1"  );
						email2   = (String) keyValue.get("email2"  );
						phone1   = (String) keyValue.get("phone1"  );
						phone2   = (String) keyValue.get("phone2"  );
						fax1     = (String) keyValue.get("fax1"    );
						fax2     = (String) keyValue.get("fax2"    );
						address  = (String) keyValue.get("address" );
						city     = (String) keyValue.get("city"    );
						state    = (String) keyValue.get("state"   );
						pin      = (String) keyValue.get("pin"     );
						pan      = (String) keyValue.get("pan"     );
						voterId  = (String) keyValue.get("voterId" );
					} catch (JSONException e) {						
						e.printStackTrace();
					}
					
					/********* Get Session ************/
					User user = (User) session.getAttribute("user"); 
					
					/**************** Database ********************/
					boolean status = false;				
					
					status = CreateUserDAO.setFranchise(userId, password, fName, lName, sex, company, mobile1, mobile2, email1, email2, phone1, phone2,
							fax1, fax2, address, city, state, pin, pan, voterId, new java.sql.Timestamp(new java.util.Date().getTime()),
							user.getUserInfo().getId(), user.getUserInfo().getUserType());
					
					/*********** JSON data for next page ***************/
					JSONObject jsonObject = new JSONObject();;
					
					if (status == true) {  							
						
						try {
							jsonObject.put("message", "* User registration succesful");
						} catch (JSONException e) {							
							e.printStackTrace();
						}
						
					} // if close
					
					else {
						
						try {
							jsonObject.put("message", "* User registration not succesful");
						} catch (JSONException e) {							
							e.printStackTrace();
						}
					}
					
					
					/************* Response **************/
					response.setContentType("application/json");
					response.getWriter().write(jsonObject.toString());
				
			} // AddFranchise
			
			else if (servletPath.equals("/RetrievePinCommission")) {
				
				System.out.println("Entered RetrievePinCommission");				
				
				/***************** DataBase ***********************/					
				AdminDAO adminDAO = new AdminDAO();
				List<ExtractFranchiseDetails> extractFranchiseDetails = adminDAO.getFranchiseDetails();
				
				/************ Data for next page ******************/
				
				JSONObject items = new JSONObject();
				JSONArray jsonArray = new JSONArray();
				
				if (extractFranchiseDetails != null) {
					
					try {
					
						for (ExtractFranchiseDetails franchiseDetails : extractFranchiseDetails) {
					
								JSONObject jsonObject = new JSONObject();						
						
								jsonObject.put("companyName", franchiseDetails.getUser().getUserInfo().getCompany());							
								jsonObject.put("firstName",   franchiseDetails.getUser().getPerson().getFirstName());
								jsonObject.put("lastName",    franchiseDetails.getUser().getPerson().getLastName() );
								jsonObject.put("id",          franchiseDetails.getUser().getUserInfo().getId()     );
								jsonObject.put("balance",     franchiseDetails.getUser().getUserInfo().getBalance());
								jsonObject.put("pin1",        franchiseDetails.getFranchisePins().getPin1()        );
								jsonObject.put("pin2",        franchiseDetails.getFranchisePins().getPin2()        );
								jsonObject.put("pin3",        franchiseDetails.getFranchisePins().getPin3()        );
								jsonObject.put("pin4",        franchiseDetails.getFranchisePins().getPin4()        );
								jsonObject.put("pin5",        franchiseDetails.getFranchisePins().getPin5()        );																
								
								jsonArray.put(jsonObject);									
						
					
						}  // for close
					
						items.put("items", jsonArray);
					
					} catch (JSONException e) {								
						e.printStackTrace();
					}
					
					response.setContentType("application/json");
					response.getWriter().write(items.toString());
					
				} // if close
				
			} // RetrieveProductForApproval
			
			else if (servletPath.equals("/SetPin")) {
				
				System.out.println("Entered SetPin");
				
				String id1         = null;	  
				String pin         = null;   
				String position1   = null;  				  
				
		        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		        
		        String jsonData = null;
		        
		        if (br != null) {
		        	
		            jsonData = br.readLine();                               
		        }
		        
		        try {
		        	
					JSONObject jsonObject1 = new JSONObject(jsonData);
					
					id1         = jsonObject1.getString("id"      );            
					pin         = jsonObject1.getString("pin"     );        
					position1   = jsonObject1.getString("position");   
					
				} catch (JSONException e) {				
					e.printStackTrace();
				}		        
							
				
				/********* Process ***************/
				
				long id      = Long.parseLong(id1);
				int position = Integer.parseInt(position1);
			
				/***************** DataBase ***********************/					
				AdminDAO adminDAO = new AdminDAO();
				boolean status    = adminDAO.setPin(id, pin, position);
				
				/***************  Send Response  *****************/
				
				JSONObject jsonObject = new JSONObject();
				
				if (status == true) {					
					
					try {
						jsonObject.put("success", "* Details Set Successfully");
					} catch (JSONException e) {					
						e.printStackTrace();
					}				
					
				} // if close
				
				else {
					
					try {
						jsonObject.put("failed", "* Details Could Not Set Successfully");
					} catch (JSONException e) {					
						e.printStackTrace();
					}	
				}
				
				response.setContentType("application/json");
				response.getWriter().write(jsonObject.toString());
				
			} // SetPin
			
			else if (servletPath.equals("/SetCommission")) {
				
				System.out.println("Entered SetCommission");
				
				String commission1 = null;	
				String id1         = null;
				
		        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
		        
		        String jsonData = null;
		        
		        if (br != null) {
		        	
		            jsonData = br.readLine();                               
		        }
		        
		        try {
		        	
					JSONObject jsonObject1 = new JSONObject(jsonData);
					
					commission1 = jsonObject1.getString("commission"); 
					id1         = jsonObject1.getString("id"        );
					
				} catch (JSONException e) {				
					e.printStackTrace();
				}		        
							
				
				/********* Process ***************/
				
				double commission = Double.parseDouble(commission1);  
				long id           = Long.parseLong(id1);          
			
				/***************** DataBase ***********************/					
				AdminDAO adminDAO = new AdminDAO();
				boolean status    = adminDAO.setCommission(id, commission);
				
				/***************  Send Response  *****************/
				
				JSONObject jsonObject = new JSONObject();
				
				if (status == true) {					
					
					try {
						jsonObject.put("success", "* Details Set Successfully");
					} catch (JSONException e) {					
						e.printStackTrace();
					}				
					
				} // if close
				
				else {
					
					try {
						jsonObject.put("failed", "* Details Could Not Set Successfully");
					} catch (JSONException e) {					
						e.printStackTrace();
					}	
				}
				
				response.setContentType("application/json");
				response.getWriter().write(jsonObject.toString());
				
			} // SetCommission
			
			else if (servletPath.equals("/FranchiseAdditionalBalance")) {
				
					System.out.println("Entered FranchiseAdditionalBalance");
					
					String addtionalBalance1 = null;	
					String id1              = null;
					
			        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
			        
			        String jsonData = null;
			        
			        if (br != null) {
			        	
			            jsonData = br.readLine();                               
			        }
			        
			        try {
			        	
						JSONObject jsonObject1 = new JSONObject(jsonData);
						
						addtionalBalance1 = jsonObject1.getString("addtionalBalance"); 
						id1               = jsonObject1.getString("id"        );
						
					} catch (JSONException e) {				
						e.printStackTrace();
					}		        
								
					
					/********* Process ***************/
					
					double addtionalBalance = Double.parseDouble(addtionalBalance1);  
					long id                 = Long.parseLong(id1);          
				
					/***************** DataBase ***********************/					
					AdminDAO adminDAO = new AdminDAO();
					double balance    = adminDAO.setAddtionalBalance(id, addtionalBalance);
					
					/***************  Send Response  *****************/
					
					JSONObject jsonObject = new JSONObject();
					
					if (balance != 0) {					
						
						try {
							jsonObject.put("balance", balance);
							jsonObject.put("success", "* Balance Added Successfully");
						} catch (JSONException e) {					
							e.printStackTrace();
						}				
						
					} // if close
					
					else {
						
						try {
							jsonObject.put("failed", "* Balance Not Added Successfully");
						} catch (JSONException e) {					
							e.printStackTrace();
						}	
					}
					
					response.setContentType("application/json");
					response.getWriter().write(jsonObject.toString());
					
			} // FranchiseAdditionalBalance
			
			else if (servletPath.equals("/RetrieveOrderedItemsForAdmin")) {
				
				System.out.println("Entered RetrieveOrderedItemsForAdmin");
				
				/********** Get Session **************/
				//User user = (User) session.getAttribute("user");
				
				/************* Database **************/
				
				AdminDAO dao = new AdminDAO();
				List<OrderTable> orderTables = dao.getOrderTablesForAdmin();			
				
				/********* JSON for Next Page **********/
				
				JSONObject jsonObject = new JSONObject();
				JSONArray  jsonArray  = new JSONArray();
				
				JSONObject jsonObject2 = null;
				
				try {
				
					for (OrderTable orderTable : orderTables) {
						
						jsonObject2 = new JSONObject();						
						
						jsonObject2.put("productId",      orderTable.getProductId());
						jsonObject2.put("qty",            orderTable.getQty());
						jsonObject2.put("sellerId",       orderTable.getSellerId());
						jsonObject2.put("sellPrice",      orderTable.getSellPrice());
						jsonObject2.put("shippingCost",   orderTable.getShippingCost());
						jsonObject2.put("size",           orderTable.getSize());
						jsonObject2.put("bookedDateTime", orderTable.getBookedDateTime());
						jsonObject2.put("delivered",      orderTable.getDelivered());
						jsonObject2.put("orderId",        orderTable.getOrderId());
						jsonObject2.put("orderState",     orderTable.getOrderState());
						jsonObject2.put("status",         orderTable.getStatus());
						jsonObject2.put("warranty",       orderTable.getWarranty());							
						
						jsonArray.put(jsonObject2);					
						
					} // for 
					
					jsonObject.put("items", jsonArray);
				
				
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				response.setContentType("application/json");
				response.getWriter().write(jsonObject.toString());
				
				
			} // /RetrieveOrderedItemsForAdmin
			
			
			else if (servletPath.equals("/RetrieveAllSellerForApprovalRegistration")) {
				
				System.out.println("Entered RetrieveAllSellerForApprovalRegistration");
				
				/************ Database *******************/
				AdminDAO dao = new AdminDAO();
				List<User> userList = dao.getAllSellerForApprovalRegistration();
				
				/********* JSON for Next Page **********/
				
				JSONObject jsonObject = new JSONObject();
				JSONArray  jsonArray  = new JSONArray();
				
				JSONObject jsonObject2 = null;
				
				try {
				
					for (User user : userList) {
						
						jsonObject2 = new JSONObject();						
						
						jsonObject2.put("id",         user.getUserInfo().getId());
						jsonObject2.put("userId",     user.getLogin().getUserId());
						jsonObject2.put("firstName",  user.getPerson().getFirstName());
						jsonObject2.put("lastName",   user.getPerson().getLastName());
						jsonObject2.put("company",    user.getUserInfo().getCompany());
						jsonObject2.put("mobile1",    user.getContact().getMobile1());
						jsonObject2.put("phone1",     user.getContact().getPhone1());
						jsonObject2.put("email1",     user.getContact().getEmail1());													
						
						jsonArray.put(jsonObject2);					
						
					} // for 
					
					jsonObject.put("items", jsonArray);
				
				
				} catch (JSONException e) {
					
					e.printStackTrace();
				}
				
				
				response.setContentType("application/json");
				response.getWriter().write(jsonObject.toString());
				
			} // /RetrieveAllSellerForApprovalRegistration
			
			
			else if (servletPath.equals("/ApproveSellerRegistrationPage")) {
				
				System.out.println("Entered ApproveSellerRegistrationPage");
				
				/***************  Get Request  *****************/
				long id = new Long(request.getParameter("id"));   
				
				/***************  Database  *****************/
				AdminDAO dao = new AdminDAO();
				UserAndPickupAddress userAndPickupAddress = dao.getUserAndPicupAddress(id);
				
				/********** Set Request ****************/
				request.setAttribute("userAndPickupAddress", userAndPickupAddress);
				
				/***************  Next Page  *****************/
				request.getRequestDispatcher("jsp_Administration/ApproveSellerRegistration.jsp").forward(request, response);
			} //ApproveSellerRegistrationPage
			
			
			else if (servletPath.equals("/ApproveSeller")) {
				
				System.out.println("Entered ApproveSeller");
				
				UserAndPickupAddress u = new UserAndPickupAddress();
				
				/*// Get Request for User
				long id               = Integer.parseInt(request.getParameter("id"));  
				String userId         = request.getParameter("userId"        );
				String firstName      = request.getParameter("firstName"     );
				String lastName       = request.getParameter("lastName"      );
				String sex            = request.getParameter("sex"           );
				String company        = request.getParameter("company"       );
				String mobile1        = request.getParameter("mobile1"       );
				String mobile2        = request.getParameter("mobile2"       );				
				String email1         = request.getParameter("email1"        );
				String email2         = request.getParameter("email2"        );
				String phone1         = request.getParameter("phone1"        );
				String phone2         = request.getParameter("phone2"        );
				String fax1           = request.getParameter("fax1"          );
				String fax2           = request.getParameter("fax2"          );
				String addressLine1   = request.getParameter("addressLine1"  );
				String addressLine2   = request.getParameter("addressLine2"  );
				String city           = request.getParameter("city"          );
				String state          = request.getParameter("state"         );				
				String pin            = request.getParameter("pin"           );
				String country        = request.getParameter("country"       );
				String pan            = request.getParameter("pan"           );
				String voterId        = request.getParameter("voterId"       );
				
				
				// Get Request for DeliveryAddress
				String daFirstName    = request.getParameter("daFirstName"   );   
				String daLastName     = request.getParameter("daLastName"    );
				String daCompany      = request.getParameter("daCompany"     );
				String daContact      = request.getParameter("daContact"     );
				String daAddressLine1 = request.getParameter("daAddressLine1");
				String daAddressLine2 = request.getParameter("daAddressLine2");
				String daCity         = request.getParameter("daCity"        );
				String daPin          = request.getParameter("daPin"         );
				String daState        = request.getParameter("daState"       );
				String daCountry      = request.getParameter("daCountry"     );
				String daEmail        = request.getParameter("daEmail"       );			*/	
				
				
				// Get Request for User
				u.getUser().getUserInfo().setId       (Integer.parseInt(request.getParameter("id")));
		    	u.getUser().getLogin()   .setUserId   (request.getParameter("userId"        ));		    	
		    	u.getUser().getPerson()  .setFirstName(request.getParameter("firstName"     ));
		    	u.getUser().getPerson()  .setLastName (request.getParameter("lastName"      ));
		    	u.getUser().getUserInfo().setCompany  (request.getParameter("company"       ));
		    	u.getUser().getAddress() .setAddress  (request.getParameter("addressLine1"  ));
		    	u.getUser().getAddress() .setAddress1 (request.getParameter("addressLine2"  ));
		    	u.getUser().getAddress() .setPin      (request.getParameter("pin"           ));
		    	u.getUser().getAddress() .setCity     (request.getParameter("city"          ));
		    	u.getUser().getAddress() .setState    (request.getParameter("state"         ));
		    	u.getUser().getAddress() .setCountry  (request.getParameter("country"       ));
		    	u.getUser().getPerson()  .setSex      (request.getParameter("sex"           ));
		    	u.getUser().getContact() .setMobile1  (request.getParameter("mobile1"       ));
		    	u.getUser().getContact() .setMobile2  (request.getParameter("mobile2"       ));
		    	u.getUser().getContact() .setEmail1   (request.getParameter("email1"        ));
		    	u.getUser().getContact() .setEmail2   (request.getParameter("email2"        ));
		    	u.getUser().getContact() .setPhone1   (request.getParameter("phone1"        ));
		    	u.getUser().getContact() .setPhone2   (request.getParameter("phone2"        ));
		    	u.getUser().getContact() .setFax1     (request.getParameter("fax1"          ));
		    	u.getUser().getContact() .setFax2     (request.getParameter("fax2"          ));
		    	u.getUser().getUserInfo().setPan      (request.getParameter("pan"           ));
		    	u.getUser().getUserInfo().setVoterId  (request.getParameter("voterId"       ));		    	
		    	
		    	
		    	// Get Request for DeliveryAddress
		    	u.getDeliveryAddress().setfName       (request.getParameter("daFirstName"   ));
		    	u.getDeliveryAddress().setlName       (request.getParameter("daLastName"    ));
		    	u.getDeliveryAddress().setCompany     (request.getParameter("daCompany"     ));
		    	u.getDeliveryAddress().setAddress     (request.getParameter("daAddressLine1"));
		    	u.getDeliveryAddress().setAddress1    (request.getParameter("daAddressLine2"));
		    	u.getDeliveryAddress().setCity        (request.getParameter("daCity"        ));
		    	u.getDeliveryAddress().setPin         (request.getParameter("daPin"         ));
		    	u.getDeliveryAddress().setState       (request.getParameter("daState"       ));
		    	u.getDeliveryAddress().setContact     (request.getParameter("daContact"     ));
		    	u.getDeliveryAddress().setEmail       (request.getParameter("daEmail"       ));
		    	u.getDeliveryAddress().setCountry     (request.getParameter("daCountry"     ));
				
				
				/********* Database ***********/
		    	AdminDAO dao = new AdminDAO();
				boolean status = dao.setApproveSeller(u);   
				
				
				/***************  Send Response  *****************/
				
				JSONObject jsonObject = new JSONObject();
				
				if (status == true) {					
					
					try {
						jsonObject.put("status", status);  
						
					} catch (JSONException e) {					
						e.printStackTrace();
					}				
					
				} // if close
				
				
				response.setContentType("application/json");
				response.getWriter().write(jsonObject.toString());;
				
			
			} //ApproveSeller
			
			
			
	}
}
