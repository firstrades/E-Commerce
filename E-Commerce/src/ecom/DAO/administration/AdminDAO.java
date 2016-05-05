package ecom.DAO.administration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecom.beans.AdminServletHelper;
import ecom.common.ConnectionFactory;
import ecom.common.Conversions;
import ecom.model.ExtractFranchiseDetails;
import ecom.model.OrderTable;
import ecom.model.ProductBean;
import ecom.model.User;
import ecom.model.UserAndPickupAddress;

public class AdminDAO {

	public List<ProductBean> getAwaitingProductList() {		
			
			String sql = "SELECT * FROM product WHERE status = 'awaiting' ";
			ResultSet resultSet = null;	
			
			List<ProductBean> productBeans = new ArrayList<>();
			
			try (Connection connection = ConnectionFactory.getNewConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				
				connection.setAutoCommit(false);				
				
				resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					
					ProductBean productBean = new ProductBean(); 					
					
					productBean.setProductId           (resultSet.getLong  ("product_id"    ));
					productBean.setSellerId            (resultSet.getLong  ("seller_id"     ));
					productBean.setSellerCompany       (resultSet.getString("seller_company"));
					
					productBean.setCategory            (resultSet.getString("category"      ));
					productBean.setSubCategory         (resultSet.getString("sub_category"  ));
					productBean.setProductName         (resultSet.getString("product_name"  ));					
					productBean.setCompanyName         (resultSet.getString("company_name"  ));					
					
					productBean.getPrice().setListPrice             (resultSet.getDouble("list_price"            ));					
					productBean.getPrice().setDiscount              (resultSet.getDouble("discount"              ));
					productBean.getPrice().setSalePriceCustomer     (resultSet.getDouble("salePriceCustomer"     ));					
					productBean.getPrice().setMarkup                (resultSet.getDouble("markup"                ));
					productBean.getPrice().setSalePriceToAdmin      (resultSet.getDouble("sale_price"            ));  // to Admin
					productBean.getPrice().setManufacturingCost     (resultSet.getDouble("manufacturingCost"     ));
					productBean.getPrice().setProfitMarginPercentage(resultSet.getDouble("profitMarginPercentage"));					
					
					productBean.setStock                  (resultSet.getInt   ("stock"                    ));
					productBean.setWeight                 (resultSet.getDouble("weight"                   ));
					productBean.setWarranty               (resultSet.getString("warranty"                 ));
					productBean.setCancellationAfterBooked(resultSet.getInt   ("calcellation_after_booked"));					
					
					productBean.getCommission().setFranchiseCommission  (resultSet.getDouble("f_commission"));
					productBean.getCommission().setDistributorCommission(resultSet.getDouble("d_commission"));  
					
					
					productBeans.add(productBean);
					
				}
				
				
				connection.commit();
				
				System.out.println("SQL - getAwaitingProductList()  Executed");
				
				return productBeans;
				
			} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException sqlException) {			
				sqlException.printStackTrace();
			} finally {		
				productBeans = null;				
				try { resultSet.close(); } catch (SQLException e)  { e.printStackTrace(); }
				System.gc();
			}	
			
			return null;
			
	}  //  getAwaitingProductList
	
	public boolean setProductApprove(ProductBean productBean) {		
			
		Connection connection = null; CallableStatement callableStatement = null;			
		String sql = "{call setApproveProduct(?,?,?,?,?,?,?,?,?,?,?,?)}";			
		boolean status = false;
	
		try {
			
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			callableStatement = connection.prepareCall(sql);    
			
			callableStatement.registerOutParameter(1, java.sql.Types.BOOLEAN);
			
			callableStatement.setLong  (2, productBean.getProductId());
			
			callableStatement.setDouble(3,  productBean.getPrice().getDiscount()                  );
			callableStatement.setDouble(4,  productBean.getPrice().getSalePriceCustomer()         );
			callableStatement.setDouble(5,  productBean.getPrice().getMarkup());
			callableStatement.setDouble(6,  productBean.getPrice().getSalePriceToAdmin()          );
			callableStatement.setDouble(7,  productBean.getPrice().getProfitMarginPercentage()    );
			
			callableStatement.setDouble(8,  productBean.getCommission().getFranchiseCommission()  );
			callableStatement.setDouble(9,  productBean.getCommission().getDistributorCommission());
			
			callableStatement.setDouble(10, productBean.getWeight()                               );
			callableStatement.setString(11, productBean.getWarranty()                             );
			callableStatement.setInt   (12, productBean.getCancellationAfterBooked()              );
			
			callableStatement.execute();
			
			status = callableStatement.getBoolean(1);  
			
			connection.commit();					
			System.out.println("SQL - setProductApprove executed");
			
			return status;			
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
			e.printStackTrace();
			
		} finally {			
			try { callableStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
			try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
			System.gc();
		}   
			
			return status;
	
	}  // setProductApprove
	
	public List<ExtractFranchiseDetails> getFranchiseDetails() {
		
			Connection connection = null;
			CallableStatement callableStatement = null;
			ResultSet resultSet = null;
			String sql = "{call extractFranchiseDetails()}";
			
			List<ExtractFranchiseDetails> list = new ArrayList<>();			
			
		
			try {
				
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
				
				callableStatement = connection.prepareCall(sql);
				
				resultSet = callableStatement.executeQuery();
				
				while (resultSet.next()) {
					
					ExtractFranchiseDetails extractFranchiseDetails = new ExtractFranchiseDetails();				
					
					extractFranchiseDetails.getUser().getUserInfo().setId      (resultSet.getLong  ("id"        ));
					extractFranchiseDetails.getUser().getUserInfo().setCompany (resultSet.getString("company"   ));
					extractFranchiseDetails.getUser().getPerson().setFirstName (resultSet.getString("first_name"));
					extractFranchiseDetails.getUser().getPerson().setLastName  (resultSet.getString("last_name" ));
					extractFranchiseDetails.getUser().getUserInfo().setBalance (resultSet.getDouble("balance"   ));
					
					//extractFranchiseDetails.getCommission().setCommission      (resultSet.getDouble("commission"));
					// pin1
					extractFranchiseDetails.getFranchisePins().setPin1         (resultSet.getString("pin"));				
					// pin2
					resultSet.next();
					extractFranchiseDetails.getFranchisePins().setPin2         (resultSet.getString("pin"));
					// pin3
					resultSet.next();
					extractFranchiseDetails.getFranchisePins().setPin3         (resultSet.getString("pin"));
					// pin4
					resultSet.next();
					extractFranchiseDetails.getFranchisePins().setPin4         (resultSet.getString("pin"));
					// pin5
					resultSet.next();
					extractFranchiseDetails.getFranchisePins().setPin5         (resultSet.getString("pin"));					
					
					
					list.add(extractFranchiseDetails);
					
				}
				
				
				connection.commit();
				System.out.println("SQL - getFranchisePinCommission executed");
				
				return list;
				
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
				e.printStackTrace();
				
			} finally {				
				try { resultSet.close();         } catch (SQLException e)  { e.printStackTrace();  }
				try { callableStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
				try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
				System.gc();
			}  
		
			return null;
			
	}  // getFranchiseDetails
	
	public boolean setPin(long id, String pin, int position) {
		
			Connection connection = null;
			CallableStatement callableStatement = null;			
			String sql = "{call setPin(?,?,?,?)}";			
			
		
			try {
				
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
				
				callableStatement = connection.prepareCall(sql);    
				callableStatement.setLong  (1, id);     
				callableStatement.setInt   (2, position);
				callableStatement.setString(3, pin);   				
				callableStatement.registerOutParameter(4, java.sql.Types.BOOLEAN);				
				
				callableStatement.execute();	
				
				boolean status = callableStatement.getBoolean(4);
				
				if (status == true) {
				
					connection.commit();					
					System.out.println("SQL - setPin executed");
					
					return true;
				} else {
					
					connection.commit();					
					System.out.println("SQL - Data not updated");
					
					return false;
				}
				
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
				e.printStackTrace();
				
			} finally {				
				try { callableStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
				try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
				System.gc();
			}  
			
			return false;
			
	} // setPinCommission
	
	
	public boolean setCommission(long id, double commission) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;			
		String sql = "UPDATE user_commission SET commission = ? WHERE user_id = ?";			
		
	
		try {
			
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			preparedStatement = connection.prepareStatement(sql);  
			preparedStatement.setDouble(1, commission);	
			preparedStatement.setLong  (2, id);  								
			
			int result = preparedStatement.executeUpdate();				
			
			if (result != 0) {
			
				connection.commit();					
				System.out.println("SQL - setCommission executed");
				
				return true;
			}
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
			e.printStackTrace();
			
		} finally {			
			try { preparedStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
			try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
			System.gc();
		}   
		
		
		return false;
		
	} // setCommission
	
	
	public double setAddtionalBalance(long id, double addtionalBalance) {
		
			Connection connection = null;
			CallableStatement callableStatement = null;			
			String sql = "{call setAddtionalBalance(?,?,?)}";			
			double balance = 0;
		
			try {
				
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
				
				callableStatement = connection.prepareCall(sql);    
				callableStatement.setLong  (1, id);     
				callableStatement.setDouble(2, addtionalBalance);	
				callableStatement.registerOutParameter(3, java.sql.Types.DOUBLE);
				
				callableStatement.execute();
				
				balance = callableStatement.getDouble(3);  System.out.println(balance);
				
				connection.commit();					
				System.out.println("SQL - setAddtionalBalance executed");
				
				return balance;
				
				
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
				e.printStackTrace();
				
			} finally {				
				try { callableStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
				try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
				System.gc();
			}   
			
			return balance;
		
	}  // setAddtionalBalance
	
	
	public List<OrderTable> getOrderTablesForAdmin() {
		
		Connection connection = null; CallableStatement callableStatement = null; ResultSet resultSet = null;
        
        List<OrderTable> list     = new ArrayList<OrderTable>();
        AdminServletHelper helper = new AdminServletHelper();
   
        
        try{
        	connection = ConnectionFactory.getNewConnection();
		    connection.setAutoCommit(false);
		    
		    callableStatement = connection.prepareCall("{call getOrderTablesForAdmin()}");		   		    
		    
		    resultSet = callableStatement.executeQuery() ; 
		    
		    while (resultSet.next()) {
		    	
		    	OrderTable orderTable = new OrderTable();
		    	
		    	orderTable.setId            (resultSet.getLong  ("id"           ));
		    	orderTable.setCustomerId    (resultSet.getLong  ("customer_id"  ));
		    	orderTable.setProductId     (resultSet.getLong  ("product_id"   ));
		    	orderTable.setSellerId      (resultSet.getLong  ("seller_id"    ));
		    	orderTable.setQty           (resultSet.getInt   ("qty"          ));
		    	orderTable.setSellPrice     (resultSet.getDouble("sell_price"   ));
		    	orderTable.setShippingCost  (resultSet.getDouble("shipping_cost"));
		    	orderTable.setWarranty      (resultSet.getString("warranty"     ));
		    	orderTable.setOrderId       (resultSet.getString("order_id"     ));		    	
		    	orderTable.setBookedDateTime(resultSet.getString("date_time"    ));	
		    	orderTable.setStatus        (resultSet.getString("status"       ));
		    	orderTable.setSize          (resultSet.getString("size"         ));		    	
		    	orderTable.setOrderState    (resultSet.getString("order_state"  ));
		    	orderTable.setPaymentType   (resultSet.getString("payment_type" ));
		    	
		    	orderTable.getDeliveryAddress().setContact (resultSet.getString("contact"   ));
		    	orderTable.getDeliveryAddress().setAddress (resultSet.getString("address"   ));
		    	orderTable.getDeliveryAddress().setAddress1(resultSet.getString("address1"  ));
		    	orderTable.getDeliveryAddress().setCity    (resultSet.getString("city"      ));
		    	orderTable.getDeliveryAddress().setState   (resultSet.getString("state"     ));
		    	orderTable.getDeliveryAddress().setPin     (resultSet.getString("pin"       ));
		    	orderTable.getDeliveryAddress().setfName   (resultSet.getString("first_name"));
		    	orderTable.getDeliveryAddress().setlName   (resultSet.getString("last_name" ));
		    	orderTable.getDeliveryAddress().setEmail   (resultSet.getString("email"     ));
		    	orderTable.getDeliveryAddress().setCompany (resultSet.getString("company"   ));
		    	orderTable.getDeliveryAddress().setCountry (resultSet.getString("country"   ));
		    	
		    	orderTable.getUser().getUserInfo().setId      (resultSet.getLong("uId"        ));
		    	orderTable.getUser().getUserInfo().setUserType(Conversions.getEnumUserType(resultSet.getString( "user_type" )));
		    	orderTable.getUser().getPerson().setFirstName (resultSet.getString("uFName"   ));
		    	orderTable.getUser().getPerson().setLastName  (resultSet.getString("uLName"   ));		    	
		    	orderTable.getUser().getUserInfo().setCompany (resultSet.getString("uCompany" ));
		    	orderTable.getUser().getAddress().setAddress  (resultSet.getString("uAddress" ));
		    	orderTable.getUser().getAddress().setAddress1 (resultSet.getString("uAddress1"));		    	
		    	orderTable.getUser().getAddress().setPin      (resultSet.getString("uPin"     ));
		    	orderTable.getUser().getAddress().setCity     (resultSet.getString("uCity"    ));
		    	orderTable.getUser().getAddress().setState    (resultSet.getString("uState"   ));
		    	orderTable.getUser().getAddress().setCountry  (resultSet.getString("uCountry" ));
		    	orderTable.getUser().getPerson().setSex       (resultSet.getString("uSex"     ));
		    	orderTable.getUser().getContact().setMobile1  (resultSet.getString("uMobile"  ));
		    	orderTable.getUser().getContact().setEmail1   (resultSet.getString("uEmail"   ));
		    	orderTable.getUser().getUserInfo().setBalance (resultSet.getDouble("balance"  ));
		    	
		    	/************** Increment 15 days ***************/		    	
		    	String date = helper.getDateIncremented(resultSet.getString("delivered_date"));	    	
		    	
		    	orderTable.getOrderTableAccessories().setTrackNumber            (resultSet.getString("track_number"             ));
		    	orderTable.getOrderTableAccessories().setDeliveredDate          (date                                            );
		    	orderTable.getOrderTableAccessories().setPickedUpDate           (resultSet.getString("picked_up_date"           ));
		    	orderTable.getOrderTableAccessories().setCancellationAfterBooked(resultSet.getInt   ("calcellation_after_booked"));
		    	orderTable.getOrderTableAccessories().setCourier                (resultSet.getString("courier"                  ));
		    			    	
		    	list.add(orderTable);
		    	
		    	date = null;
		    }
		   
		    System.out.println("SQL - getOrderTablesForAdmin Executed");
		    
		    connection.commit();
		    return list;

        } catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
			e.printStackTrace();
			
		} finally {		
			helper = null;
			list   = null;			
			try { resultSet.close();         } catch (SQLException e)  { e.printStackTrace();  }
			try { callableStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
			try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
			System.gc();
			
		}   
        
		return null;
	} //getOrderTablesForAdmin
	
	
	public List<User> getAllSellerForApprovalRegistration() {
		
		Connection connection = null; CallableStatement callableStatement = null; ResultSet resultSet = null;
        
        List<User> list = new ArrayList<User>();   
        
        try{
        	connection = ConnectionFactory.getNewConnection();
		    connection.setAutoCommit(false);
		    
		    callableStatement = connection.prepareCall("{call getAllSellerForApprovalRegistration()}");		    	    
		    
		    resultSet = callableStatement.executeQuery() ; 
		    
		    while (resultSet.next()) {
		    	
		    	User user = new User();
		    	
		    	user.getUserInfo().setId       (resultSet.getLong  ("id"        ));
		    	user.getLogin()   .setUserId   (resultSet.getString("user_id"   ));
		    	user.getPerson()  .setFirstName(resultSet.getString("first_name"));
		    	user.getPerson()  .setLastName (resultSet.getString("last_name" ));
		    	user.getUserInfo().setCompany  (resultSet.getString("company"   ));
		    	user.getContact() .setMobile1  (resultSet.getString("mobile1"   ));
		    	user.getContact() .setPhone1   (resultSet.getString("phone1"    ));
		    	user.getContact() .setEmail1   (resultSet.getString("email1"    ));
		    	
		    	list.add(user);
		    }
		   
		    System.out.println("SQL - getAllSellerForApprovalRegistration Executed");
		    
		    connection.commit();
		    return list;

        } catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
			e.printStackTrace();
			
		} finally {
			list = null;			
			try { resultSet.close();         } catch (SQLException e)  { e.printStackTrace();  }
			try { callableStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
			try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
			System.gc();
		}   
        
		return null;
	} //getAllSellerForApprovalRegistration
	
	
	public UserAndPickupAddress getUserAndPicupAddress(long id) {
		
		Connection connection = null; CallableStatement callableStatement = null; ResultSet resultSet = null;
        
		UserAndPickupAddress u = new UserAndPickupAddress(); 
        
        try{
        	connection = ConnectionFactory.getNewConnection();
		    connection.setAutoCommit(false);
		    
		    callableStatement = connection.prepareCall("{call getUserAndPicupAddress(?)}");	
		    callableStatement.setLong(1, id);
		    
		    resultSet = callableStatement.executeQuery() ; 
		    
		    while (resultSet.next()) {
		    	
		    	u.getUser().getUserInfo().setId       (resultSet.getLong("id"          ));
		    	u.getUser().getLogin()   .setUserId   (resultSet.getString("user_id"   ));
		    	u.getUser().getUserInfo().setUserType (Conversions.getEnumUserType(resultSet.getString("user_type")));
		    	u.getUser().getPerson()  .setFirstName(resultSet.getString("first_name"));
		    	u.getUser().getPerson()  .setLastName (resultSet.getString("last_name" ));
		    	u.getUser().getUserInfo().setCompany  (resultSet.getString("company"   ));
		    	u.getUser().getAddress() .setAddress  (resultSet.getString("address"   ));
		    	u.getUser().getAddress() .setAddress1 (resultSet.getString("address1"  ));
		    	u.getUser().getAddress() .setPin      (resultSet.getString("pin"       ));
		    	u.getUser().getAddress() .setCity     (resultSet.getString("city"      ));
		    	u.getUser().getAddress() .setState    (resultSet.getString("state"     ));
		    	u.getUser().getAddress() .setCountry  (resultSet.getString("country"   ));
		    	u.getUser().getPerson()  .setSex      (resultSet.getString("sex"       ));
		    	u.getUser().getContact() .setMobile1  (resultSet.getString("mobile1"   ));
		    	u.getUser().getContact() .setMobile2  (resultSet.getString("mobile2"   ));
		    	u.getUser().getContact() .setEmail1   (resultSet.getString("email1"    ));
		    	u.getUser().getContact() .setEmail2   (resultSet.getString("email2"    ));
		    	u.getUser().getContact() .setPhone1   (resultSet.getString("phone1"    ));
		    	u.getUser().getContact() .setPhone2   (resultSet.getString("phone2"    ));
		    	u.getUser().getContact() .setFax1     (resultSet.getString("fax1"      ));
		    	u.getUser().getContact() .setFax2     (resultSet.getString("fax2"      ));
		    	u.getUser().getUserInfo().setPan      (resultSet.getString("pan"       ));
		    	u.getUser().getUserInfo().setVoterId  (resultSet.getString("voter_id"  ));
		    	
		    	
		    	u.getDeliveryAddress().setId          (resultSet.getLong("da_id"       ));
		    	u.getDeliveryAddress().setUserId      (resultSet.getLong("userId"      ));
		    	u.getDeliveryAddress().setfName       (resultSet.getString("firstName" ));
		    	u.getDeliveryAddress().setlName       (resultSet.getString("lastName"  ));
		    	u.getDeliveryAddress().setCompany     (resultSet.getString("company1"  ));
		    	u.getDeliveryAddress().setAddress     (resultSet.getString("daAddress1"));
		    	u.getDeliveryAddress().setAddress1    (resultSet.getString("daAddress2"));
		    	u.getDeliveryAddress().setCity        (resultSet.getString("city1"     ));
		    	u.getDeliveryAddress().setPin         (resultSet.getString("pin1"      ));
		    	u.getDeliveryAddress().setState       (resultSet.getString("state1"    ));
		    	u.getDeliveryAddress().setContact     (resultSet.getString("mobile"    ));
		    	u.getDeliveryAddress().setEmail       (resultSet.getString("daEmail1"  ));
		    	u.getDeliveryAddress().setCountry     (resultSet.getString("country1"  ));
		    	
		    	
		    	
		    	
		    }
		   
		    System.out.println("SQL - getUserAndPicupAddress Executed");
		    
		    connection.commit();
		    return u;

        } catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
			e.printStackTrace();
			
		} finally {
			u = null;			
			try { resultSet.close();         } catch (SQLException e)  { e.printStackTrace();  }
			try { callableStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
			try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
			System.gc();
		}   
        
		return null;
	} //getUserAndPicupAddress
	
	
	public boolean setApproveSeller(UserAndPickupAddress u) {
		
		Connection connection = null; CallableStatement callableStatement = null;	
		
		String sql = "{call setApproveSeller(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";			
		boolean status = false;
	
		try {
			
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			callableStatement = connection.prepareCall(sql);    
			
			callableStatement.setLong  (1, u.getUser().getUserInfo().getId()     );     
			callableStatement.setString(2, u.getUser().getLogin().getUserId()    );	
			callableStatement.setString(3, u.getUser().getPerson().getFirstName());
			callableStatement.setString(4, u.getUser().getPerson().getLastName() );
			callableStatement.setString(5, u.getUser().getUserInfo().getCompany());
			callableStatement.setString(6, u.getUser().getAddress().getAddress() );
			callableStatement.setString(7, u.getUser().getAddress().getAddress1());
			callableStatement.setString(8, u.getUser().getAddress().getPin()     );
			callableStatement.setString(9, u.getUser().getAddress().getCity()    );
			callableStatement.setString(10,u.getUser().getAddress().getState()   );
			callableStatement.setString(11,u.getUser().getAddress().getCountry() );
			callableStatement.setString(12,u.getUser().getPerson().getSex()      );
			callableStatement.setString(13,u.getUser().getContact().getMobile1() );
			callableStatement.setString(14,u.getUser().getContact().getMobile2() );
			callableStatement.setString(15,u.getUser().getContact().getEmail1()  );
			callableStatement.setString(16,u.getUser().getContact().getEmail2()  );
			callableStatement.setString(17,u.getUser().getContact().getPhone1()  );
			callableStatement.setString(18,u.getUser().getContact().getPhone2()  );
			callableStatement.setString(19,u.getUser().getContact().getFax1()    );
			callableStatement.setString(20,u.getUser().getContact() .getFax2()   );
			callableStatement.setString(21,u.getUser().getUserInfo().getPan()    );
			callableStatement.setString(22,u.getUser().getUserInfo().getVoterId());
			
			callableStatement.setString(23, u.getDeliveryAddress().getfName()    );
			callableStatement.setString(24, u.getDeliveryAddress().getlName()    );
			callableStatement.setString(25, u.getDeliveryAddress().getCompany()  );
			callableStatement.setString(26, u.getDeliveryAddress().getAddress()  );
			callableStatement.setString(27, u.getDeliveryAddress().getAddress1() );
			callableStatement.setString(28, u.getDeliveryAddress().getCity()     );
			callableStatement.setString(29, u.getDeliveryAddress().getPin()      );
			callableStatement.setString(30, u.getDeliveryAddress().getState()    );
			callableStatement.setString(31, u.getDeliveryAddress().getContact()  );
			callableStatement.setString(32, u.getDeliveryAddress().getEmail()    );
			callableStatement.setString(33, u.getDeliveryAddress().getCountry()  );			
			
			callableStatement.registerOutParameter(34, java.sql.Types.BOOLEAN);
			
			callableStatement.execute();
			
			status = callableStatement.getBoolean(34);  
			
			connection.commit();					
			System.out.println("SQL - setApproveSeller executed");
			
			return status;
			
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
			e.printStackTrace();
			
		} finally {
			
			try { callableStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
			try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
			System.gc();
		}  
		
		return status;
		
	} // setApproveSeller
	
	
	
	
	
	/****************** Testing ********************/
	
	public static void main (String...args) {		
		
		List<ExtractFranchiseDetails> list = new AdminDAO().getFranchiseDetails();
		
		for (ExtractFranchiseDetails c: list) {
			
			//System.out.println(c.getCommission().getCommission());
			System.out.println(c.getFranchisePins().getPin1());
			System.out.println(c.getFranchisePins().getPin2());
			System.out.println(c.getFranchisePins().getPin3());
			System.out.println(c.getFranchisePins().getPin4());
			System.out.println(c.getFranchisePins().getPin5());
		}
		
		list = null;
		System.gc();
	}
}
