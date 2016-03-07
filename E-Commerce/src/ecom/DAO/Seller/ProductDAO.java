package ecom.DAO.Seller;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecom.model.KeyFeatures;
import ecom.model.Price;
import ecom.model.ProductBean;
import ecom.model.User;
import ecom.common.ConnectionFactory;
import ecom.common.Conversions;

public class ProductDAO {

	public static synchronized boolean addProduct(User user, InputStream inputStream1, InputStream inputStream2, InputStream inputStream3, 
			ProductBean productBean) {		
		
		Connection connection = null; CallableStatement callableStatement = null;	
		
		String sql = "{call addProduct(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";			
		boolean status = false;
	
		try {
			
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			callableStatement = connection.prepareCall(sql); 			
			
			callableStatement.registerOutParameter(1, java.sql.Types.BOOLEAN);
			
			callableStatement.setLong  (2, user.getUserInfo().getId()     );
			callableStatement.setString(3, user.getUserInfo().getCompany());
			
			callableStatement.setBlob  (4, inputStream1);
			callableStatement.setBlob  (5, inputStream2);
			callableStatement.setBlob  (6, inputStream3);
			
			callableStatement.setString(7, productBean.getCategory());
			callableStatement.setString(8, productBean.getSubCategory());
			callableStatement.setString(9, productBean.getCompanyName());
			callableStatement.setString(10, productBean.getProductName());
			
			callableStatement.setString(11, productBean.getKeyFeatures().getKf1());
			callableStatement.setString(12, productBean.getKeyFeatures().getKf2());
			callableStatement.setString(13, productBean.getKeyFeatures().getKf3());
			callableStatement.setString(14, productBean.getKeyFeatures().getKf4());
			
			callableStatement.setDouble(15, productBean.getPrice().getManufacturingCost()     );
			callableStatement.setDouble(16, productBean.getPrice().getProfitMarginPercentage());
			callableStatement.setDouble(17, productBean.getPrice().getSalePriceToAdmin()      );
			callableStatement.setDouble(18, productBean.getPrice().getListPrice()             );
			callableStatement.setDouble(19, productBean.getPrice().getDiscount()              );
			
			callableStatement.setInt   (20, productBean.getStock()                  );
			callableStatement.setDouble(21, productBean.getWeight()                 );
			callableStatement.setString(22, productBean.getWarranty()               );
			callableStatement.setInt   (23, productBean.getCancellationAfterBooked());
			
			callableStatement.execute();
			
			status = callableStatement.getBoolean(1);  
			
			connection.commit();					
			System.out.println("SQL - addProduct executed");
			
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
	} //addProduct
	
	public List<ProductBean> getProducts(String category, String subCategory, long sellerId) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet resultSet = null;		
		List<ProductBean> list = new ArrayList<>();		
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM product WHERE seller_id = ? AND category = ? AND sub_category = ? AND status = 'approved'";
				
			preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setLong   (1, sellerId);
			preparedStatement.setString (2, category);
			preparedStatement.setString (3, subCategory);
		
			resultSet = preparedStatement.executeQuery();	
			
			while (resultSet.next()) { 
				
				ProductBean productBean = new ProductBean();
				productBean.setKeyFeatures(new KeyFeatures());
				productBean.setPrice(new Price());
				
				productBean.setProductId                 (resultSet.getInt   ("product_id"  ));
				productBean.setSellerId                  (resultSet.getLong  ("seller_id"   ));
				
				productBean.setCategory                  (resultSet.getString("category"    ));
				productBean.setSubCategory               (resultSet.getString("sub_category"));
				productBean.setProductName               (resultSet.getString("product_name"));
				productBean.setCompanyName               (resultSet.getString("company_name"));
				
				productBean.getPrice().setListPrice      (resultSet.getDouble("list_price"  ));
				productBean.getPrice().setDiscount       (resultSet.getDouble("discount"    ));
				productBean.getPrice().setSalePriceToAdmin(resultSet.getDouble("sale_price"  ));
				productBean.getPrice().setMarkup         (resultSet.getDouble("markup"      ));
				
				productBean.getKeyFeatures().setKf1      (resultSet.getString("kf_1"));
				productBean.getKeyFeatures().setKf2      (resultSet.getString("kf_2"));
				productBean.getKeyFeatures().setKf3      (resultSet.getString("kf_3"));
				productBean.getKeyFeatures().setKf4      (resultSet.getString("kf_4"));
				
				productBean.setStatus                    (Conversions.getEnumStatus(resultSet.getString("status")));
				
				
				list.add(productBean);
			}
			
			connection.commit();
			
			System.out.println("SQL getProducts Executed");
			
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
		
		
		return null;
	}
	
	public boolean deleteProduct(long productId, String subCategory) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		
		
		try {
			connection = ConnectionFactory.getNewConnection();
			//connection.setAutoCommit(false);   
			
			sql = "DELETE FROM product WHERE product_id = ?";	
			preparedStatement = connection.prepareStatement(sql);	
			preparedStatement.setLong(1, productId);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			
			/********************************************
			 				* Condition *
			 ********************************************/
			
			if (subCategory.equals("Mobile")) {  // if there is no data, autocommit is restricting from deleteing the rows from from both table
				
				sql = "DELETE FROM mobile_spec WHERE product_id = ?";						
			}
			
			/****************************************/
			
			preparedStatement = connection.prepareStatement(sql);	
			preparedStatement.setLong(1, productId);
			preparedStatement.executeUpdate();  
			
			System.out.println("Delete Product SQL Executed...");
			
			//connection.commit();
			
			return true;
			
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			/*try {
				connection.rollback();
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}*/
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
	}
	
}
