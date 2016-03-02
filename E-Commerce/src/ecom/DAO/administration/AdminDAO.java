package ecom.DAO.administration;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecom.common.ConnectionFactory;
import ecom.common.Conversions;
import ecom.model.ExtractFranchiseDetails;
import ecom.model.KeyFeatures;
import ecom.model.OrderTable;
import ecom.model.Price;
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
					productBean.setKeyFeatures(new KeyFeatures());
					productBean.setPrice(new Price());
					
					productBean.setCompanyName         (resultSet.getString("company_name"  ));
					productBean.setCategory            (resultSet.getString("category"      ));
					productBean.getKeyFeatures().setKf1(resultSet.getString("kf_1"          ));
					productBean.getKeyFeatures().setKf2(resultSet.getString("kf_2"          ));
					productBean.getKeyFeatures().setKf3(resultSet.getString("kf_3"          ));
					productBean.getKeyFeatures().setKf4(resultSet.getString("kf_4"          ));
					productBean.getPrice().setDiscount (resultSet.getDouble("discount"      ));
					productBean.getPrice().setListPrice(resultSet.getDouble("list_price"    ));
					productBean.getPrice().setMarkup   (resultSet.getDouble("markup"        ));
					productBean.getPrice().setSalePrice(resultSet.getDouble("sale_price"    ));
					productBean.setProductId           (resultSet.getLong  ("product_id"    ));
					productBean.setProductName         (resultSet.getString("product_name"  ));
					productBean.setSellerId            (resultSet.getLong  ("seller_id"     ));
					productBean.setStatus              (Conversions.getEnumStatus(resultSet.getString("status")));
					productBean.setStock               (resultSet.getInt   ("stock"         ));
					productBean.setSubCategory         (resultSet.getString("sub_category"  ));
					productBean.setWarranty            (resultSet.getString("warranty"      ));
					productBean.setSellerCompany       (resultSet.getString("seller_company"));
					
					productBeans.add(productBean);
					
				}
				
				
				connection.commit();
				
				System.out.println("SQL - getAwaitingProductList()  Executed");
				
				return productBeans;
				
			} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException sqlException) {			
				sqlException.printStackTrace();
			} finally {			
				try {
					resultSet.close();  
				} catch (SQLException e) {				
					e.printStackTrace();
				}
			}	
			
			return null;
			
	}  //  getAwaitingProductList
	
	public boolean getApproveProduct(long productId, double markup, double franComm, double drisComm) {		
			
			String sql = "UPDATE product SET markup = ?, f_commission = ?, d_commission = ?, status = 'approved' WHERE product_id = ? ";					
			
			try (Connection connection = ConnectionFactory.getNewConnection();
				 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
				
				connection.setAutoCommit(false);				
				
				preparedStatement.setDouble(1, markup);
				preparedStatement.setDouble(2, franComm);
				preparedStatement.setDouble(3, drisComm);
				preparedStatement.setLong  (4, productId);
				int result = preparedStatement.executeUpdate();
				
				if (result != 0) {
					
					connection.commit();					
					System.out.println("SQL - getAwaitingProductList()  Executed");
					
					return true;
				}
				
			} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException sqlException) {			
				sqlException.printStackTrace();
			} 
			
			return false;
	
	}  // getApproveProduct
	
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
					
					extractFranchiseDetails.getCommission().setCommission      (resultSet.getDouble("commission"));
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
				
			}   
			
			return balance;
		
	}  // setAddtionalBalance
	
	
	public List<OrderTable> getOrderTablesForAdmin() {
		
		Connection connection = null; CallableStatement callableStatement = null; ResultSet resultSet = null;
        
        List<OrderTable> list = new ArrayList<OrderTable>();
   
        
        try{
        	connection = ConnectionFactory.getNewConnection();
		    connection.setAutoCommit(false);
		    
		    callableStatement = connection.prepareCall("{call getOrderTablesForAdmin()}");
		    //callableStatement.setLong(1, );		    
		    
		    resultSet = callableStatement.executeQuery() ; 
		    
		    while (resultSet.next()) {
		    	
		    	OrderTable orderTable = new OrderTable();
		    	
		    	orderTable.setBookedDateTime(resultSet.getString("date_time"    ));
		    	orderTable.setDelivered     (resultSet.getString("delivered"    ));
		    	orderTable.setId            (resultSet.getLong  ("id"           ));
		    	orderTable.setOrderId       (resultSet.getString("order_id"     ));
		    	orderTable.setOrderState    (resultSet.getString("order_state"  ));
		    	orderTable.setProductId     (resultSet.getLong  ("product_id"   ));
		    	orderTable.setQty           (resultSet.getInt   ("qty"          ));
		    	orderTable.setSellPrice     (resultSet.getDouble("sell_price"   ));
		    	orderTable.setShippingCost  (resultSet.getDouble("shipping_cost"));
		    	orderTable.setSize          (resultSet.getInt   ("size"         ));
		    	orderTable.setStatus        (resultSet.getString("status"       ));
		    	orderTable.setWarranty      (resultSet.getString("warranty"     ));
		    	orderTable.setSellerId      (resultSet.getLong  ("seller_id"    ));
		    	
		    	list.add(orderTable);
		    }
		   
		    System.out.println("SQL - getOrderTablesForAdmin Executed");
		    
		    connection.commit();
		    return list;

        } catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
			e.printStackTrace();
			
		} finally {
			try { resultSet.close();         } catch (SQLException e)  { e.printStackTrace();  }
			try { callableStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
			try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
			
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
			try { resultSet.close();         } catch (SQLException e)  { e.printStackTrace();  }
			try { callableStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
			try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
			
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
		    	u.getDeliveryAddress().setAddress     (resultSet.getString("address1"  ));
		    	u.getDeliveryAddress().setAddress1    (resultSet.getString("address2"  ));
		    	u.getDeliveryAddress().setCity        (resultSet.getString("city1"     ));
		    	u.getDeliveryAddress().setPin         (resultSet.getString("pin1"      ));
		    	u.getDeliveryAddress().setState       (resultSet.getString("state1"    ));
		    	u.getDeliveryAddress().setContact     (resultSet.getString("mobile"    ));
		    	u.getDeliveryAddress().setEmail       (resultSet.getString("email1"    ));
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
			try { resultSet.close();         } catch (SQLException e)  { e.printStackTrace();  }
			try { callableStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
			try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
			
		}   
        
		return null;
	} //getUserAndPicupAddress
	
	
	
	
	
	
	
	
	/****************** Testing ********************/
	
	public static void main (String...args) {
		
		
		List<ExtractFranchiseDetails> list = new AdminDAO().getFranchiseDetails();
		
		for (ExtractFranchiseDetails c: list) {
			
			System.out.println(c.getCommission().getCommission());
			System.out.println(c.getFranchisePins().getPin1());
			System.out.println(c.getFranchisePins().getPin2());
			System.out.println(c.getFranchisePins().getPin3());
			System.out.println(c.getFranchisePins().getPin4());
			System.out.println(c.getFranchisePins().getPin5());
		}
	}
}
