package ecom.DAO.User;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import ecom.common.ConnectionFactory;
import ecom.common.UserType;

public class CreateUserDAO {

	public synchronized static boolean setFranchise(String fUserId, String password, String fName, String lName, String sex, String company, String mobile1, String mobile2, 
			String email1, String email2, String phone1, String phone2, String fax1, String fax2, String address, String city, String state, 
			String pin, String pan, String voterId, java.sql.Timestamp joiningDate, long userId, UserType userType) {
		
			String userType1 = null;
		
			if (userType == UserType.ADMIN)  userType1 = "admin";
			
			Connection connection = null;
			CallableStatement callableStatement = null;
		
			String sql = "{call createFranchise(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		
			try {
				
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
					
				callableStatement = connection.prepareCall(sql);
				
				callableStatement.setString(1,  fUserId);
				callableStatement.setString(2,  password);
				callableStatement.setString(3,  fName);
				callableStatement.setString(4,  lName);
				callableStatement.setString(5,  sex);
				callableStatement.setString(6,  company);
				callableStatement.setString(7,  mobile1);
				callableStatement.setString(8,  mobile2);
				callableStatement.setString(9,  email1);
				callableStatement.setString(10, email2);
				callableStatement.setString(11, phone1);
				callableStatement.setString(12, phone2);
				callableStatement.setString(13, fax1);
				callableStatement.setString(14, fax2);
				callableStatement.setString(15, address);
				callableStatement.setString(16, city);
				callableStatement.setString(17, state);
				callableStatement.setString(18, pin);
				callableStatement.setString(19, pan);
				callableStatement.setString(20, voterId);
				callableStatement.setTimestamp(21, joiningDate);
				callableStatement.setLong  (22, userId);
				callableStatement.setString(23, userType1);
				
				callableStatement.execute();  				
					
				System.out.println("SQL- setFranchise executed");
				
				connection.commit();
				
				return true;
				
				
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				
				try {
					connection.rollback();
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
				
				e.printStackTrace();
			}
		
		
		return false;
		
	} // setFranchise()	
	
	public synchronized static boolean setDistributor(String dUserId, String password, String fName, String lName, String sex, String company, String mobile1, String mobile2, 
			String email1, String email2, String phone1, String phone2, String fax1, String fax2, String address, String city, String state, 
			String pin, String pan, String voterId, java.sql.Timestamp joiningDate, long userId, UserType userType,
			String choosePin, String area) {
		
			String userType1 = null;
		
			if (userType == UserType.FRANCHISE)  userType1 = "franchise";
			
			Connection connection = null;
			CallableStatement callableStatement = null;
		
			String sql = "{call createDistributor(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		
			try {
				
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
					
				callableStatement = connection.prepareCall(sql);
				
				callableStatement.setString(1,  dUserId);
				callableStatement.setString(2,  password);
				callableStatement.setString(3,  fName);
				callableStatement.setString(4,  lName);
				callableStatement.setString(5,  sex);
				callableStatement.setString(6,  company);
				callableStatement.setString(7,  mobile1);
				callableStatement.setString(8,  mobile2);
				callableStatement.setString(9,  email1);
				callableStatement.setString(10, email2);
				callableStatement.setString(11, phone1);
				callableStatement.setString(12, phone2);
				callableStatement.setString(13, fax1);
				callableStatement.setString(14, fax2);
				callableStatement.setString(15, address);
				callableStatement.setString(16, city);
				callableStatement.setString(17, state);
				callableStatement.setString(18, pin);
				callableStatement.setString(19, pan);
				callableStatement.setString(20, voterId);
				callableStatement.setTimestamp(21, joiningDate);
				callableStatement.setLong  (22, userId);
				callableStatement.setString(23, userType1);
				callableStatement.setString(24, choosePin);
				callableStatement.setString(25, area);
				
				callableStatement.execute();  				
					
				System.out.println("SQL- setDistributor executed");
				
				connection.commit();
				
				return true;
				
				
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {
				
				try {
					connection.rollback();
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}
				
				e.printStackTrace();
			}
		
		
		return false;
		
	} // setDistributor()	
	
	/*public synchronized static boolean setCustomerLogin(String Userid, String Password) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		
		try {
			 connection = ConnectionFactory.getNewConnection();
			 connection.setAutoCommit(false);
			 
			 sql = "INSERT INTO user (user_id, password1) VALUES (?,?)";
			 
				preparedStatement = connection.prepareStatement(sql);
				
				preparedStatement.setString(1, Userid);
				preparedStatement.setString(2, Password);

				preparedStatement.executeUpdate();
		
				System.out.println("SQL - Executed setRegistration Login for Customer");
				
				connection.commit();
				
				return true;
				
		}  catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				preparedStatement.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		}
		return false;
	} //setRegistration Login for Customer
*/	
	
	//Soumya
	public boolean setUserRegistration (String User_Id, String Password, String First_Name, String Last_Name, 
			 String Gender, String Email, String Contact_Number, String Address, String Pin, String City, String State, 
			 String First_Name2, String Last_Name2, String Email2, String Contact_Number2, String Address2, String Pin2, String City2, String State2) {
			 
			 Connection connection = null;
			 CallableStatement callableStatement = null;
			 boolean exist = false;
			 String User_type = "customer";
			 
			 try{
				 
				 connection = ConnectionFactory.getNewConnection();
				 connection.setAutoCommit(false);
				 
				 callableStatement = connection.prepareCall("{call registerUser(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				 
				 callableStatement.setString(1, User_Id);
				 callableStatement.setString(2, Password);
				 callableStatement.setString(3, First_Name);
				 callableStatement.setString(4, Last_Name);
				 callableStatement.setString(5, Gender);
				 callableStatement.setString(6, Email);
				 callableStatement.setString(7, Contact_Number);
				 callableStatement.setString(8, Address);
				 callableStatement.setString(9, Pin);
				 callableStatement.setString(10, City);
				 callableStatement.setString(11, State);
				 callableStatement.setString(12, User_type);
				 callableStatement.setString(13, First_Name2);
				 callableStatement.setString(14, Last_Name2);
				 callableStatement.setString(15, Email2);
				 callableStatement.setString(16, Contact_Number2);
				 callableStatement.setString(17, Address2);
				 callableStatement.setString(18, Pin2);
				 callableStatement.setString(19, City2);
				 callableStatement.setString(20, State2);
				 
				 callableStatement.registerOutParameter(21, Types.BOOLEAN);
				 
			    callableStatement.execute() ; 
				 
				 exist = callableStatement.getBoolean(21);
				 
				 System.out.println("SQL - setUserRegistration");
				 
				 connection.commit();
				 
				 return exist;
				
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
			 return false;
	}

}
