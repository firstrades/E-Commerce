package ecom.DAO.Seller;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecom.model.KeyFeatures;
import ecom.model.Price;
import ecom.model.ProductBean;
import ecom.common.ConnectionFactory;
import ecom.common.Conversions;

public class ProductDAO {

	public boolean addProduct(long userId, String userCompanyName, String category, String subCategory, String company, String product, Double listPrice, 
			Double discount, Double salePrice, String kf1, String kf2, String kf3, String kf4, InputStream inputStream1, 
			InputStream inputStream2, InputStream inputStream3, int stock, String warranty, double weight) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "INSERT INTO product ("
				+ "seller_id, category, sub_category, product_name, company_name, kf_1, kf_2, kf_3, kf_4, "
				+ "list_price, discount, sale_price, icon_image, image1, image2, stock, warranty, status, seller_company, weight"			
				+ ") " 
				+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, 'awaiting',?,?)";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setLong   (1,  userId);
			preparedStatement.setString (2,  category);
			preparedStatement.setString (3,  subCategory);
			preparedStatement.setString (4,  product);
			preparedStatement.setString (5,  company);
			preparedStatement.setString (6,  kf1);
			preparedStatement.setString (7,  kf2);
			preparedStatement.setString (8,  kf3);
			preparedStatement.setString (9,  kf4);
			preparedStatement.setDouble (10, listPrice);
			preparedStatement.setDouble (11, discount);
			preparedStatement.setDouble (12, salePrice);										
			preparedStatement.setBlob   (13, inputStream1);
			preparedStatement.setBlob   (14, inputStream2);
			preparedStatement.setBlob   (15, inputStream3);
			preparedStatement.setInt    (16, stock);
			preparedStatement.setString (17, warranty);
			preparedStatement.setString (18, userCompanyName);
			preparedStatement.setDouble (19, weight);
			
		
			preparedStatement.executeUpdate();
			
			
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
				productBean.getPrice().setSalePrice      (resultSet.getDouble("sale_price"  ));
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
