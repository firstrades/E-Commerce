package ecom.SERVLET.administration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.servlet.ServletException;
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
							
									jsonObject.put("companyName", productBean.getCompanyName()  );							
									jsonObject.put("category",    productBean.getCategory()     );
									jsonObject.put("kf1",         productBean.getKeyFeatures().getKf1());
									jsonObject.put("kf2",         productBean.getKeyFeatures().getKf2());
									jsonObject.put("kf3",         productBean.getKeyFeatures().getKf3());
									jsonObject.put("kf4",         productBean.getKeyFeatures().getKf4());
									jsonObject.put("discount",    productBean.getPrice().getDiscount());
									jsonObject.put("listPrice",   productBean.getPrice().getListPrice());
									jsonObject.put("markup",      productBean.getPrice().getMarkup());
									jsonObject.put("salePrice",   productBean.getPrice().getSalePrice());
									jsonObject.put("productId",   productBean.getProductId()    );
									jsonObject.put("productName", productBean.getProductName()  );
									jsonObject.put("seller_id",   productBean.getSellerId()     );
									jsonObject.put("status",      productBean.getStatus()       );
									jsonObject.put("stock",       productBean.getStock()        );
									jsonObject.put("sub_category",productBean.getSubCategory()  );
									jsonObject.put("warranty",    productBean.getWarranty()     );										
									jsonObject.put("seller",      productBean.getSellerCompany());									
									
									
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
					
					String productId1  = null;	
					String markup1     = null;
					String franComm1   = null;
					String drisComm1   = null;
					
					if (request.getParameter("productId") == null) {   
					
					        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
					        
					        String jsonData = null;
					        
					        if (br != null) {
					        	
					            jsonData = br.readLine();                               
					        }
					        
					        try {
					        	
								JSONObject jsonObject1 = new JSONObject(jsonData);
								
								productId1  = jsonObject1.getString("productId");
								markup1     = jsonObject1.getString("markup");
								franComm1   = jsonObject1.getString("franComm");
								drisComm1   = jsonObject1.getString("drisComm");
								
							} catch (JSONException e) {				
								e.printStackTrace();
							}
			        
					} // if close
					
					
					/************** Process *****************/					
					long productId  = Long.parseLong(productId1);
					double markup   = Double.parseDouble(markup1);
					double franComm = Double.parseDouble(franComm1);
					double drisComm = Double.parseDouble(drisComm1);
				
					/***************** DataBase ***********************/					
					AdminDAO adminDAO = new AdminDAO();
					boolean status = adminDAO.getApproveProduct(productId, markup, franComm, drisComm);
					
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
								jsonObject.put("commission",  franchiseDetails.getCommission().getCommission()     );								
								
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
			}
			
	}
}
