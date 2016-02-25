package ecom.DAO.Seller;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ecom.common.ConnectionFactory;
import ecom.model.KeyFeatures;
import ecom.model.LeggingsFeatures;
import ecom.model.MobileFeatures;
import ecom.model.Price;
import ecom.model.ProductBean;
import ecom.model.Size;

public class EditProductDAO {

	public ProductBean editProduct(long productId, long sellerId, String category, String subCategory, String company, String product, Double listPrice, 
			Double discount, Double salePrice, String kf1, String kf2, String kf3, String kf4, int stock, String warranty) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		
		ProductBean productBean = new ProductBean();
		Price price = new Price();
		KeyFeatures keyFeatures = new KeyFeatures();
		productBean.setPrice(price);
		productBean.setKeyFeatures(keyFeatures);
		
		
		try {
			connection = ConnectionFactory.getNewConnection();  
			connection.setAutoCommit(false);
			
			sql = "UPDATE product SET category = ?, sub_category = ?, product_name = ?, company_name = ?, " +
					"kf_1 = ?, kf_2 = ?, kf_3 = ?, kf_4 = ?, list_price = ?, discount = ?, sale_price = ?, " +
					"stock = ?, warranty = ?" +
					"WHERE seller_id = ? AND product_id = ?";
				
			
			preparedStatement = connection.prepareStatement(sql);		
			
			preparedStatement.setString (1, category);
			preparedStatement.setString (2, subCategory);
			preparedStatement.setString (3, product);
			preparedStatement.setString (4, company);
			preparedStatement.setString (5, kf1);
			preparedStatement.setString (6, kf2);
			preparedStatement.setString (7, kf3);
			preparedStatement.setString (8, kf4);
			preparedStatement.setDouble (9, listPrice);
			preparedStatement.setDouble (10, discount);
			preparedStatement.setDouble (11, salePrice);
			preparedStatement.setInt    (12, stock);
			preparedStatement.setString (13, warranty);
			preparedStatement.setLong   (14, sellerId);
			preparedStatement.setLong   (15, productId);			
			
		
			int result = preparedStatement.executeUpdate();
			
			
			//-------------------Set ProductBean--------------------------------
			
			if (result != 0) {
			
				productBean.setProductId           (productId);
				productBean.setSellerId            (sellerId);
				productBean.setCategory            (category);
				productBean.setCompanyName         (company);
				productBean.getKeyFeatures().setKf1(kf1);
				productBean.getKeyFeatures().setKf2(kf2);
				productBean.getKeyFeatures().setKf3(kf3);
				productBean.getKeyFeatures().setKf4(kf4);
				productBean.getPrice().setListPrice(listPrice);
				productBean.getPrice().setDiscount (discount);
				productBean.getPrice().setSalePrice(salePrice);
				productBean.setProductName         (product);
				productBean.setSubCategory         (subCategory);
				productBean.setStock               (stock);
				productBean.setWarranty            (warranty);		
			
			
				connection.commit();
				
				return productBean;
			
			} // if close
			
			
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
	
public ProductBean getBasicFeatures(long productId) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet resultSet = null;		
		ProductBean productBean = new ProductBean();
		productBean.setKeyFeatures(new KeyFeatures());
		productBean.setPrice(new Price());
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM product WHERE product_id = ?";
				
			preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setLong (1,  productId);			
		
			resultSet = preparedStatement.executeQuery();	
			
			while (resultSet.next()) {
				
				productBean.setProductId                 (resultSet.getInt   ("product_id"));
				productBean.setSellerId                  (resultSet.getLong  ("seller_id"));
				
				productBean.setCategory                  (resultSet.getString("category"));
				productBean.setSubCategory               (resultSet.getString("sub_category"));
				productBean.setProductName               (resultSet.getString("product_name"));
				productBean.setCompanyName               (resultSet.getString("company_name"));
				productBean.getPrice().setListPrice      (resultSet.getDouble("list_price"));
				productBean.getPrice().setDiscount       (resultSet.getDouble("discount"));
				productBean.getPrice().setSalePrice      (resultSet.getDouble("sale_price"));
				productBean.getPrice().setMarkup         (resultSet.getDouble("markup"));
				productBean.getKeyFeatures().setKf1      (resultSet.getString("kf_1"));
				productBean.getKeyFeatures().setKf2      (resultSet.getString("kf_2"));
				productBean.getKeyFeatures().setKf3      (resultSet.getString("kf_3"));
				productBean.getKeyFeatures().setKf4      (resultSet.getString("kf_4"));	
				productBean.setStock                     (resultSet.getInt   ("stock"));
				productBean.setWarranty                  (resultSet.getString("warranty"));
			}
			
			connection.commit();
			
			System.out.println("SQL getBasicFeatures Executed");
			
			return productBean;
			
			
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

	public boolean editImage(long productId, long sellerId, InputStream inputStream, String image) {		
		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			if (image.equals("iconImage")) {
				sql = "UPDATE product SET icon_image = ? WHERE product_id = ?";	
			} else if (image.equals("image1")) {
				sql = "UPDATE product SET image1 = ? WHERE product_id = ?";	
			} else if (image.equals("image2")) {
				sql = "UPDATE product SET image2 = ? WHERE product_id = ?";	
			}
			
			preparedStatement = connection.prepareStatement(sql);		
													
			preparedStatement.setBlob(1, inputStream);
			preparedStatement.setLong(2, productId);			
		
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
	
	
	/****************** Size ********************************/
	
	public Size getSizes(long productId) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql            = null;
		ResultSet resultSet   = null;		
		
		Size size = new Size();
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM garment_size WHERE product_id = ?";
				
			preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setLong (1,  productId);			
		
			resultSet = preparedStatement.executeQuery();	
			
			if (resultSet.next()) {
				
				size.setQtyOfSize26(resultSet.getInt("s26"));
				size.setQtyOfSize28(resultSet.getInt("s28"));
				size.setQtyOfSize30(resultSet.getInt("s30"));
				size.setQtyOfSize32(resultSet.getInt("s32"));
				size.setQtyOfSize34(resultSet.getInt("s34"));
				size.setQtyOfSize36(resultSet.getInt("s36"));
				size.setQtyOfSize38(resultSet.getInt("s38"));
				size.setQtyOfSize40(resultSet.getInt("s40"));
				size.setQtyOfSize42(resultSet.getInt("s42"));
				size.setQtyOfSize44(resultSet.getInt("s44"));
				size.setQtyOfSize46(resultSet.getInt("s46"));
				size.setQtyOfSize48(resultSet.getInt("s48"));
				
				
			} else {
				
				connection.commit();
				
				System.out.println("SQL getSizes Executed and ResultSet is empty...");
				
				return null;
			}
			
			connection.commit();
			
			System.out.println("SQL getSizes Executed");
			
			return size;
			
			
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
	
	/**************** ELECTRONICS - MOBILE ************************/
	
	public MobileFeatures getMobileFeatures(long productId) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet resultSet = null;		
		MobileFeatures mobileFeatures = new MobileFeatures();
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM p_mobile_spec WHERE product_id = ?";
				
			preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setLong (1,  productId);			
		
			resultSet = preparedStatement.executeQuery();	
			
			if (resultSet.next()) {
				
				mobileFeatures.setProductId      (resultSet.getLong("product_id"));
				mobileFeatures.setSellerId       (resultSet.getLong("seller_id"));
				
				mobileFeatures.setInternalStorage(resultSet.getString("internal_storage"));
				mobileFeatures.setOs             (resultSet.getString("os"));
				mobileFeatures.setTouch          (resultSet.getString("touch"));
				mobileFeatures.setWifi           (resultSet.getString("wifi"));
				mobileFeatures.setFm             (resultSet.getString("fm"));
				mobileFeatures.setFrontCamera    (resultSet.getString("front_camera"));
				mobileFeatures.setRearCamera     (resultSet.getString("rear_camera"));
				mobileFeatures.setConnectivity   (resultSet.getString("connectivity"));
				
			} else {
				
				connection.commit();
				
				System.out.println("SQL getBasicFeatures Executed and ResultSet is empty...");
				
				return null;
			}
			
			connection.commit();
			
			System.out.println("SQL getBasicFeatures Executed");
			
			return mobileFeatures;
			
			
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
	
	@SuppressWarnings("resource")
	public MobileFeatures editMobileFeatures(long productId, long sellerId, String internalStorage, String os, String touch, String wifi, 
			String fm, String frontCamera, String rearCamera, String connectivity) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet resultSet = null;	
		MobileFeatures mobileFeatures = new MobileFeatures();
		
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM p_mobile_spec WHERE product_id = ?";				
			preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setLong (1,  productId);			
			resultSet = preparedStatement.executeQuery();	
			
			
			if (resultSet.next()) {   System.out.println("Ent");
				
				sql = "UPDATE p_mobile_spec SET internal_storage = ?, os = ?, touch = ?, wifi = ?, fm = ?, front_camera = ?, " +
						"rear_camera = ?, connectivity = ? WHERE product_id = ?";				
				preparedStatement = connection.prepareStatement(sql);			
				preparedStatement.setString (1, internalStorage);
				preparedStatement.setString (2, os);
				preparedStatement.setString (3, touch);
				preparedStatement.setString (4, wifi);
				preparedStatement.setString (5, fm);
				preparedStatement.setString (6, frontCamera);
				preparedStatement.setString (7, rearCamera);
				preparedStatement.setString (8, connectivity);
				preparedStatement.setLong (9, productId);
				
				preparedStatement.executeUpdate();	
				
				
			} else {
				
				sql = "INSERT INTO p_mobile_spec (product_id, seller_id, internal_storage, os, touch, wifi, fm, front_camera, rear_camera, connectivity) "
						+ "VALUES(?,?,?,?,?,?,?,?,?,?)";				
				preparedStatement = connection.prepareStatement(sql);			
				preparedStatement.setLong   (1,  productId);
				preparedStatement.setLong   (2,  sellerId);
				preparedStatement.setString (3,  internalStorage);
				preparedStatement.setString (4,  os);
				preparedStatement.setString (5,  touch);
				preparedStatement.setString (6,  wifi);
				preparedStatement.setString (7,  fm);
				preparedStatement.setString (8,  frontCamera);
				preparedStatement.setString (9,  rearCamera);
				preparedStatement.setString (10, connectivity);
				
				preparedStatement.executeUpdate();	
				
			}
			
			//---------------------------Set MobileFeatures----------------------------
			
			mobileFeatures.setConnectivity(connectivity);
			mobileFeatures.setFm(fm);
			mobileFeatures.setFrontCamera(frontCamera);
			mobileFeatures.setInternalStorage(internalStorage);
			mobileFeatures.setOs(os);
			mobileFeatures.setRearCamera(rearCamera);
			mobileFeatures.setTouch(touch);
			mobileFeatures.setWifi(wifi);
			
			//-------------------------------------------------------------------------
			
			connection.commit();
			
			System.out.println("SQL editMobileFeatures Executed");
			
			return mobileFeatures;
			
			
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
	
	
	/********************* WOMEN - LEGGINGS ***********************/
	
	public LeggingsFeatures getLeggingsFeatures(long productId) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql            = null;
		ResultSet resultSet   = null;		
		
		LeggingsFeatures leggingsFeatures = new LeggingsFeatures();
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM p_leggings_spec WHERE product_id = ?";
				
			preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setLong (1,  productId);			
		
			resultSet = preparedStatement.executeQuery();	
			
			if (resultSet.next()) {
				
				leggingsFeatures.setId         (resultSet.getLong("id"         ));
				leggingsFeatures.setProductId  (resultSet.getLong("product_id" ));
				leggingsFeatures.setSellerId   (resultSet.getLong("seller_id"  ));
				
				leggingsFeatures.setFabric     (resultSet.getString("fabric"   ));
				leggingsFeatures.setPattern    (resultSet.getString("pattern"  ));
				leggingsFeatures.setSeason     (resultSet.getString("season"   ));
				leggingsFeatures.setStyle      (resultSet.getString("style"    ));
				leggingsFeatures.setWaistband  (resultSet.getString("waistband"));
				
				
			} else {
				
				connection.commit();
				
				System.out.println("SQL getLeggingsFeatures Executed and ResultSet is empty...");
				
				return null;
			}
			
			connection.commit();
			
			System.out.println("SQL getLeggingsFeatures Executed");
			
			return leggingsFeatures;
			
			
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
	
	
	public LeggingsFeatures editLeggingsFeatures(long productId, long sellerId, String pattern, String fabric, String style, 
			String season, String waistband) {		
		
		Connection connection   = null;
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;
		
		String sql = "{call editLeggingsFeatures(?,?,?,?,?,?,?)}";	
		
		LeggingsFeatures leggingsFeatures = new LeggingsFeatures();
		
		
		try {
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
				
				callableStatement = connection.prepareCall(sql);
				callableStatement.setLong  (1, productId);
				callableStatement.setLong  (2, sellerId);
				callableStatement.setString(3, pattern);
				callableStatement.setString(4, fabric);
				callableStatement.setString(5, style);
				callableStatement.setString(6, season);
				callableStatement.setString(7, waistband);
				 			
				resultSet = callableStatement.executeQuery();			
					
				if (resultSet.next()) {
					
					leggingsFeatures.setId       (resultSet.getLong  ("id"        ));
					leggingsFeatures.setProductId(resultSet.getLong  ("product_id"));
					leggingsFeatures.setSellerId (resultSet.getLong  ("seller_id" ));
					leggingsFeatures.setPattern  (resultSet.getString("pattern"   ));
					leggingsFeatures.setFabric   (resultSet.getString("fabric"    ));
					leggingsFeatures.setStyle    (resultSet.getString("style"     ));
					leggingsFeatures.setSeason   (resultSet.getString("season"    ));
					leggingsFeatures.setWaistband(resultSet.getString("waistband" ));
				}
				
				connection.commit();
				callableStatement.close();
				
				System.out.println("SQL - Select editLeggingsFeatures() successfull.");
				
				return leggingsFeatures;
				
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
			} catch (SQLException e1) {			
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {			
				e.printStackTrace();
			}
		}		
		
		return null;
	} //editLeggingsFeatures
	
	
	public Size editSizes(long productId, long sellerId, int size26, int size28, int size30, int size32, int size34, int size36, int size38,
			int size40, int size42, int size44, int size46, int size48) {
		
		Connection connection   = null;
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;
		
		String sql = "{call editSizes(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";	
		
		Size size = new Size();
		
		
		try {
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
				
				callableStatement = connection.prepareCall(sql);
				
				callableStatement.setLong(1,  productId);
				callableStatement.setLong(2,  sellerId );
				callableStatement.setInt (3,  size26);
				callableStatement.setInt (4,  size28);
				callableStatement.setInt (5,  size30);
				callableStatement.setInt (6,  size32);
				callableStatement.setInt (7,  size34);
				callableStatement.setInt (8,  size36);
				callableStatement.setInt (9,  size38);
				callableStatement.setInt (10, size40);
				callableStatement.setInt (11, size42);
				callableStatement.setInt (12, size44);
				callableStatement.setInt (13, size46);
				callableStatement.setInt (14, size48);
				
				 			
				resultSet = callableStatement.executeQuery();			
					
				if (resultSet.next()) {
					
					size.setQtyOfSize26(resultSet.getInt("s26"));
					size.setQtyOfSize28(resultSet.getInt("s28"));
					size.setQtyOfSize30(resultSet.getInt("s30"));
					size.setQtyOfSize32(resultSet.getInt("s32"));
					size.setQtyOfSize34(resultSet.getInt("s34"));
					size.setQtyOfSize36(resultSet.getInt("s36"));
					size.setQtyOfSize38(resultSet.getInt("s38"));
					size.setQtyOfSize40(resultSet.getInt("s40"));
					size.setQtyOfSize42(resultSet.getInt("s42"));
					size.setQtyOfSize44(resultSet.getInt("s44"));
					size.setQtyOfSize46(resultSet.getInt("s46"));
					size.setQtyOfSize48(resultSet.getInt("s48"));
				}
				
				connection.commit();
				callableStatement.close();
				
				System.out.println("SQL - Select editSizes() successfull.");
				
				return size;
				
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
			} catch (SQLException e1) {			
				e1.printStackTrace();
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
