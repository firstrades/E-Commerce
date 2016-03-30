package ecom.DAO.Seller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import ecom.common.ConnectionFactory;
import ecom.model.OrderTable;
import ecom.model.User;

public class SellerDAO {
	
	private SellerDAO() {}
	
	public static SellerDAO getNewInstance() {		
		return new SellerDAO();
	}
	
	/*************************************************************/
	
	public boolean setPickedUp(long orderTableId, String date) {
		
		Connection connection = null;
        CallableStatement callableStatement = null;        
        
        boolean picked = false;   
        
        try{
        	connection = ConnectionFactory.getNewConnection();
		    connection.setAutoCommit(false);
		    
		    callableStatement = connection.prepareCall("{call setPickedUp(?,?,?)}");
		    callableStatement.setLong  (1, orderTableId);
		    callableStatement.setString(2, date        );
		    callableStatement.registerOutParameter(3, Types.BOOLEAN);
		    
		    callableStatement.execute(); 		   
		    	
		    picked = callableStatement.getBoolean(3);
		    
		   
		    System.out.println("SQL - setPickedUp Executed");
		    
		    connection.commit();
		    return picked;

        }catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		} finally {
			try {
				callableStatement.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		}   
        
		return picked;
	} //setPickedUp
	
	
	public List<OrderTable> getOrderTables(User user) {
		
		Connection connection = null;
        CallableStatement callableStatement = null;
        ResultSet resultSet = null;
        
        List<OrderTable> list = new ArrayList<OrderTable>();
   
        
        try{
        	connection = ConnectionFactory.getNewConnection();
		    connection.setAutoCommit(false);
		    
		    callableStatement = connection.prepareCall("{call getOrderTables(?)}");
		    callableStatement.setLong(1, user.getUserInfo().getId());
		    
		    
		    resultSet = callableStatement.executeQuery() ; 
		    
		    while (resultSet.next()) {
		    	
		    	OrderTable orderTable = new OrderTable();
		    	
		    	orderTable.setBookedDateTime(resultSet.getString("date_time"    ));		    	
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
		    	orderTable.setPaymentType   (resultSet.getString("payment_type" ));
		    	
		    	orderTable.getDeliveryAddress().setfName   (resultSet.getString("first_name" ));
		    	orderTable.getDeliveryAddress().setlName   (resultSet.getString("last_name"  ));
		    	orderTable.getDeliveryAddress().setContact (resultSet.getString("contact" ));
		    	orderTable.getDeliveryAddress().setAddress (resultSet.getString("address" ));
		    	orderTable.getDeliveryAddress().setAddress1(resultSet.getString("address1"));
		    	orderTable.getDeliveryAddress().setCity    (resultSet.getString("city"    ));
		    	orderTable.getDeliveryAddress().setState   (resultSet.getString("state"   ));
		    	orderTable.getDeliveryAddress().setPin     (resultSet.getString("pin"     ));
		    	orderTable.getDeliveryAddress().setEmail   (resultSet.getString("email"   ));
		    	
		    	list.add(orderTable);
		    }
		   
		    System.out.println("SQL - getOrderTables Executed");
		    
		    connection.commit();
		    return list;

        } catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		} finally {
			try {
				callableStatement.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		}   
        
		return null;
	} //getOrderTables
	
	
	public boolean setItemCancelled(long orderTableId) {
		
		Connection connection = null; CallableStatement callableStatement = null;  
		boolean status = false;
        
        try{
        	connection = ConnectionFactory.getNewConnection();
		    connection.setAutoCommit(false);
		    
		    callableStatement = connection.prepareCall("{call setItemCancelled(?,?)}");
		    callableStatement.setLong   (1, orderTableId);
		    callableStatement.registerOutParameter(2, Types.BOOLEAN);
		    
		    callableStatement.execute();
		    
		    status = callableStatement.getBoolean(2);   System.out.println(status);
		   
		    System.out.println("SQL - setItemCancelled Executed");
		    
		    connection.commit();
		    return status;

        } catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
			e.printStackTrace();
			
		} finally {
			
			try { callableStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
			try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
			
		}   
        
		return status;
	} //setItemCancelled
	

}
