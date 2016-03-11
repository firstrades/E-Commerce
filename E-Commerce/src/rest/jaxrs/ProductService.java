package rest.jaxrs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecom.common.ConnectionFactory;
import ecom.model.KeyFeatures;
import ecom.model.Price;
import ecom.model.ProductBean;

public class ProductService {

	private List<ProductBean> productBeans;

	public List<ProductBean> getProductBeans() {
		this.productBeans = getProducts();
		return productBeans;
	}		
	
	public List<ProductBean> getProducts() {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet resultSet = null;		
		List<ProductBean> list = new ArrayList<>();		
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM product WHERE status = 'approved'";
				
			preparedStatement = connection.prepareStatement(sql);			
			
		
			resultSet = preparedStatement.executeQuery();	
			
			while (resultSet.next()) { 
				
				ProductBean productBean = new ProductBean();
				productBean.setKeyFeatures(new KeyFeatures());
				productBean.setPrice(new Price());
				
				productBean.setProductId                 (resultSet.getInt   ("product_id"  ));				
				
				productBean.setCategory                  (resultSet.getString("category"    ));
				productBean.setSubCategory               (resultSet.getString("sub_category"));
				productBean.setProductName               (resultSet.getString("product_name"));
				productBean.setCompanyName               (resultSet.getString("company_name"));
				
				productBean.getPrice().setListPrice      (resultSet.getDouble("list_price"  ));
				productBean.getPrice().setDiscount       (resultSet.getDouble("discount"    ));
				productBean.getPrice().setSalePriceToAdmin(resultSet.getDouble("salePriceCustomer"  ));				
				
				productBean.getKeyFeatures().setKf1      (resultSet.getString("kf_1"));
				productBean.getKeyFeatures().setKf2      (resultSet.getString("kf_2"));
				productBean.getKeyFeatures().setKf3      (resultSet.getString("kf_3"));
				productBean.getKeyFeatures().setKf4      (resultSet.getString("kf_4"));
				
				productBean.setWarranty                  (resultSet.getString("warranty"      ));
				productBean.setSellerCompany             (resultSet.getString("seller_company"));
				
				
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
}
