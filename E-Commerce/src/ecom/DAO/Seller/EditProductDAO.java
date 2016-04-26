package ecom.DAO.Seller;

import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ecom.common.ConnectionFactory;
import ecom.model.ProductBean;
import ecom.model.Size;
import ecom.model.product.features.LeggingsFeatures;
import ecom.model.product.features.MobileFeatures;
import ecom.model.product.features._LaptopFeatures;
import ecom.model.product.features._MenJeansFeatures;
import ecom.model.product.features._MenTshirtFeatures;
import ecom.model.product.features._TopFeatures;

public class EditProductDAO {

	public ProductBean editProduct(ProductBean productBean) {	
		
		/*sql = "UPDATE product SET category = ?, sub_category = ?, product_name = ?, company_name = ?, " +
				"kf_1 = ?, kf_2 = ?, kf_3 = ?, kf_4 = ?, list_price = ?, discount = ?, sale_price = ?, " +
				"stock = ?, warranty = ?" +
				"WHERE seller_id = ? AND product_id = ?";*/
		
		Connection connection = null; CallableStatement callableStatement = null; ResultSet resultSet = null;		
		String sql = "{call editProduct(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";			
	
		try {
			
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			callableStatement = connection.prepareCall(sql); 		
			
			callableStatement.setLong  (1,   productBean.getProductId());
			
			callableStatement.setString(2,   productBean.getCategory()   );
			callableStatement.setString(3,   productBean.getSubCategory());
			callableStatement.setString(4,   productBean.getCompanyName());
			callableStatement.setString(5,   productBean.getProductName());
			
			callableStatement.setString(6,   productBean.getKeyFeatures().getKf1());
			callableStatement.setString(7,   productBean.getKeyFeatures().getKf2());
			callableStatement.setString(8,   productBean.getKeyFeatures().getKf3());
			callableStatement.setString(9,   productBean.getKeyFeatures().getKf4());
			
			callableStatement.setDouble(10,  productBean.getPrice().getManufacturingCost()     );
			callableStatement.setDouble(11,  productBean.getPrice().getProfitMarginPercentage());
			callableStatement.setDouble(12,  productBean.getPrice().getSalePriceToAdmin()      );
			callableStatement.setDouble(13,  productBean.getPrice().getSalePriceCustomer()     );
			callableStatement.setDouble(14,  productBean.getPrice().getMarkup()                );
			callableStatement.setDouble(15,  productBean.getPrice().getListPrice()             );
			callableStatement.setDouble(16,  productBean.getPrice().getDiscount()              );			
			
			callableStatement.setInt   (17,  productBean.getStock()                  );
			callableStatement.setDouble(18,  productBean.getWeight()                 );
			callableStatement.setString(19,  productBean.getWarranty()               );
			callableStatement.setInt   (20,  productBean.getCancellationAfterBooked());			
			
			resultSet = callableStatement.executeQuery();
			
			while (resultSet.next()) {
				
				productBean.setProductId                 (resultSet.getInt   ("product_id")  );				
				
				productBean.setCategory                  (resultSet.getString("category"    ));
				productBean.setSubCategory               (resultSet.getString("sub_category"));
				productBean.setCompanyName               (resultSet.getString("company_name"));
				productBean.setProductName               (resultSet.getString("product_name"));
				
				productBean.getKeyFeatures().setKf1      (resultSet.getString("kf_1"));
				productBean.getKeyFeatures().setKf2      (resultSet.getString("kf_2"));
				productBean.getKeyFeatures().setKf3      (resultSet.getString("kf_3"));
				productBean.getKeyFeatures().setKf4      (resultSet.getString("kf_4"));	
				
				productBean.getPrice().setManufacturingCost     (resultSet.getDouble("manufacturingCost"     ));
				productBean.getPrice().setProfitMarginPercentage(resultSet.getDouble("profitMarginPercentage"));
				productBean.getPrice().setSalePriceToAdmin      (resultSet.getDouble("sale_price"            ));
				productBean.getPrice().setSalePriceCustomer     (resultSet.getDouble("salePriceCustomer"     ));
				productBean.getPrice().setMarkup                (resultSet.getDouble("markup"                ));				
				productBean.getPrice().setListPrice             (resultSet.getDouble("list_price"            ));
				productBean.getPrice().setDiscount              (resultSet.getDouble("discount"              ));								
				
				productBean.setStock                     (resultSet.getInt   ("stock"                    ));
				productBean.setWeight                    (resultSet.getDouble("weight"                   ));
				productBean.setWarranty                  (resultSet.getString("warranty"                 ));
				productBean.setCancellationAfterBooked   (resultSet.getInt   ("calcellation_after_booked"));
			}
			
			connection.commit();					
			System.out.println("SQL - editProduct executed");
			
			return productBean;			
			
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
	}// editProduct
	
	public ProductBean getBasicFeatures(long productId) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet resultSet = null;		
		ProductBean productBean = new ProductBean();		
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM product WHERE product_id = ?";
				
			preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setLong (1,  productId);			
		
			resultSet = preparedStatement.executeQuery();	
			
			while (resultSet.next()) {
				
				productBean.setProductId                 (resultSet.getInt   ("product_id"));				
				
				productBean.setCategory                  (resultSet.getString("category"    ));
				productBean.setSubCategory               (resultSet.getString("sub_category"));
				productBean.setCompanyName               (resultSet.getString("company_name"));
				productBean.setProductName               (resultSet.getString("product_name"));
				
				productBean.getKeyFeatures().setKf1      (resultSet.getString("kf_1"));
				productBean.getKeyFeatures().setKf2      (resultSet.getString("kf_2"));
				productBean.getKeyFeatures().setKf3      (resultSet.getString("kf_3"));
				productBean.getKeyFeatures().setKf4      (resultSet.getString("kf_4"));	
				
				productBean.getPrice().setManufacturingCost     (resultSet.getDouble("manufacturingCost"     ));
				productBean.getPrice().setProfitMarginPercentage(resultSet.getDouble("profitMarginPercentage"));
				productBean.getPrice().setSalePriceToAdmin      (resultSet.getDouble("sale_price"            ));
				productBean.getPrice().setSalePriceCustomer     (resultSet.getDouble("salePriceCustomer"     ));
				productBean.getPrice().setMarkup                (resultSet.getDouble("markup"                ));				
				productBean.getPrice().setListPrice             (resultSet.getDouble("list_price"            ));
				productBean.getPrice().setDiscount              (resultSet.getDouble("discount"              ));								
				
				productBean.setStock                     (resultSet.getInt   ("stock"                    ));
				productBean.setWeight                    (resultSet.getDouble("weight"                   ));
				productBean.setWarranty                  (resultSet.getString("warranty"                 ));
				productBean.setCancellationAfterBooked   (resultSet.getInt   ("calcellation_after_booked"));
				
				productBean.setSellerCompany             (resultSet.getString("seller_company"));
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
			productBean = null;
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
			System.gc();
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
			System.gc();
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
			System.gc();
		}
		
		return null;
	} //getSizes
	

	
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
			System.gc();
		}	
		
		return null;
	} //editSizes
	
	
	
	
	
	
	
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
			mobileFeatures = null;
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
			System.gc();
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
			mobileFeatures = null;
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
			System.gc();
		}
		
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**************** ELECTRONICS - Laptop ************************/
	
	public _LaptopFeatures getLaptopFeatures(long productId) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet resultSet = null;		
		_LaptopFeatures laptopFeatures = new _LaptopFeatures();
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM p_laptop_spec WHERE product_id = ?";
				
			preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setLong (1,  productId);			
		
			resultSet = preparedStatement.executeQuery();	
			
			if (resultSet.next()) {
				
				laptopFeatures.setId              (resultSet.getLong("id"                ));
				laptopFeatures.setProductId       (resultSet.getLong("product_id"        ));
				laptopFeatures.setSellerId        (resultSet.getLong("seller_id"         ));				
				laptopFeatures.setBatteryCell     (resultSet.getString("batteryCell"     ));
				laptopFeatures.setGraphicProcessor(resultSet.getString("graphicProcessor"));
				laptopFeatures.setHddCapacity     (resultSet.getString("hddCapacity"     ));
				laptopFeatures.setOs              (resultSet.getString("OS"              ));
				laptopFeatures.setPowerSupply     (resultSet.getString("powerSupply"     ));
				laptopFeatures.setProcessor       (resultSet.getString("processor"       ));
				laptopFeatures.setScreenSize      (resultSet.getString("screenSize"      ));
				laptopFeatures.setWebCamera       (resultSet.getString("webCamera"       ));
				
			} else {
				
				connection.commit();
				
				System.out.println("SQL getLaptopFeatures Executed and ResultSet is empty...");
				
				return null;
			}
			
			connection.commit();
			
			System.out.println("SQL getLaptopFeatures Executed");
			
			return laptopFeatures;
			
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		} finally {
			laptopFeatures = null;
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
			System.gc();
		}
		
		
		return null;
	} //getLaptopFeatures
	
	
	
	public _LaptopFeatures editLaptopFeatures(long productId, long sellerId, String webCamera, String powerSupply, 
			String batteryCell, String screenSize, String hddCapacity, String graphicProcessor, String os, 
			String processor) {		
		
		Connection        connection        = null;
		CallableStatement callableStatement = null;
		ResultSet         resultSet         = null;
		
		String sql = "{call editLaptopFeatures(?,?,?,?,?,?,?,?,?,?)}";	
		
		_LaptopFeatures laptopFeatures = new _LaptopFeatures();
		
		
		try {
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
				
				callableStatement = connection.prepareCall(sql);
				callableStatement.setLong  (1,  productId);
				callableStatement.setLong  (2,  sellerId);
				callableStatement.setString(3,  webCamera);
				callableStatement.setString(4,  powerSupply);
				callableStatement.setString(5,  batteryCell);
				callableStatement.setString(6,  screenSize);
				callableStatement.setString(7,  hddCapacity);
				callableStatement.setString(8,  graphicProcessor);
				callableStatement.setString(9,  os);
				callableStatement.setString(10, processor);
				 			
				resultSet = callableStatement.executeQuery();			
					
				if (resultSet.next()) {
					
					laptopFeatures.setId               (resultSet.getLong  ("id"              ));
					laptopFeatures.setProductId        (resultSet.getLong  ("product_id"      ));
					laptopFeatures.setSellerId         (resultSet.getLong  ("seller_id"       ));
					laptopFeatures.setWebCamera        (resultSet.getString("webCamera"       ));
					laptopFeatures.setPowerSupply      (resultSet.getString("powerSupply"     ));
					laptopFeatures.setBatteryCell      (resultSet.getString("batteryCell"     ));					
					laptopFeatures.setScreenSize       (resultSet.getString("screenSize"      ));
					laptopFeatures.setHddCapacity      (resultSet.getString("hddCapacity"     ));
					laptopFeatures.setGraphicProcessor (resultSet.getString("graphicProcessor"));
					laptopFeatures.setOs               (resultSet.getString("OS"              ));
					laptopFeatures.setProcessor        (resultSet.getString("processor"       ));
				}
				
				connection.commit();
				callableStatement.close();
				
				System.out.println("SQL - Select editLaptopFeatures() successfull.");
				
				return laptopFeatures;
				
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {	
			
			try {
				connection.rollback();
			} catch (SQLException e1) {					
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		} finally {	
			laptopFeatures = null;
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
			System.gc();
		}		
		
		return null;
	} //editLaptopFeatures
	
	
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
			leggingsFeatures = null;
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
			System.gc();
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
			leggingsFeatures = null;
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
			System.gc();
		}		
		
		return null;
	} //editLeggingsFeatures
	
	
	
	
	/********************* WOMEN - Top ***********************/
	
	public _TopFeatures getTopFeatures(long productId) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql            = null;
		ResultSet resultSet   = null;		
		
		_TopFeatures topFeatures = new _TopFeatures();
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM p_top_spec WHERE product_id = ?";
				
			preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setLong (1,  productId);			
		
			resultSet = preparedStatement.executeQuery();	
			
			if (resultSet.next()) {
				
				topFeatures.setId         (resultSet.getLong("id"         ));
				topFeatures.setProductId  (resultSet.getLong("product_id" ));
				topFeatures.setSellerId   (resultSet.getLong("seller_id"  ));
				
				topFeatures.setFabric     (resultSet.getString("fabric"   ));
				topFeatures.setPattern    (resultSet.getString("pattern"  ));
				topFeatures.setNeck       (resultSet.getString("neck"     ));
				topFeatures.setOccasion   (resultSet.getString("occasion" ));
				topFeatures.setSleeve     (resultSet.getString("sleeve"   ));
				
				
			} else {
				
				connection.commit();
				
				System.out.println("SQL getTopFeatures Executed and ResultSet is empty...");
				
				return null;
			}
			
			connection.commit();
			
			System.out.println("SQL getTopFeatures Executed");
			
			return topFeatures;
			
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			topFeatures = null;
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
			System.gc();
		}
		
		
		return null;
	} //getTopFeatures
	
	
	public _TopFeatures editTopFeatures(long productId, long sellerId, String sleeve, String fabric, String neck, 
			String pattern, String occasion) {		
		
		Connection        connection        = null;
		CallableStatement callableStatement = null;
		ResultSet         resultSet         = null;
		
		String sql = "{call editTopFeatures(?,?,?,?,?,?,?)}";	
		
		_TopFeatures topFeatures = new _TopFeatures();
		
		
		try {
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
				
				callableStatement = connection.prepareCall(sql);
				callableStatement.setLong  (1, productId);
				callableStatement.setLong  (2, sellerId);
				callableStatement.setString(3, sleeve);
				callableStatement.setString(4, fabric);
				callableStatement.setString(5, neck);
				callableStatement.setString(6, pattern);
				callableStatement.setString(7, occasion);
				 			
				resultSet = callableStatement.executeQuery();			
					
				if (resultSet.next()) {
					
					topFeatures.setId        (resultSet.getLong  ("id"        ));
					topFeatures.setProductId (resultSet.getLong  ("product_id"));
					topFeatures.setSellerId  (resultSet.getLong  ("seller_id" ));
					topFeatures.setSleeve    (resultSet.getString("sleeve"    ));
					topFeatures.setFabric    (resultSet.getString("fabric"    ));
					topFeatures.setNeck      (resultSet.getString("neck"      ));
					topFeatures.setPattern   (resultSet.getString("pattern"   ));
					topFeatures.setOccasion  (resultSet.getString("occasion"  ));
				}
				
				connection.commit();
				callableStatement.close();
				
				System.out.println("SQL - Select editTopFeatures() successfull.");
				
				return topFeatures;
				
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {	
			
			try {
				connection.rollback();
			} catch (SQLException e1) {					
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		} finally {	
			topFeatures = null;
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
			System.gc();
		}		
		
		return null;
	} //editTopFeatures
	
	
	
	/*****************************************************************************************************************/
	/************************************************     MEN     ****************************************************/
	/*****************************************************************************************************************/
	
	
	/********************* MEN - T-Shirt ***********************/
	
	public _MenTshirtFeatures getMenTshirtFeatures(long productId) {		
		
		Connection connection = null; PreparedStatement preparedStatement = null;  ResultSet resultSet = null;		
		String sql = null;
		
		_MenTshirtFeatures menTshirtFeatures = new _MenTshirtFeatures();
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM p_men_tshirt_spec WHERE product_id = ?";
				
			preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setLong (1,  productId);			
		
			resultSet = preparedStatement.executeQuery();	
			
			if (resultSet.next()) {
				
				menTshirtFeatures.setId         (resultSet.getLong  ("id"        ));
				menTshirtFeatures.setProductId  (resultSet.getLong  ("product_id"));
				menTshirtFeatures.setSellerId   (resultSet.getLong  ("seller_id" ));
				
				menTshirtFeatures.setSleeve     (resultSet.getString("sleeve"    ));
				menTshirtFeatures.setFabric     (resultSet.getString("fabric"    ));				
				menTshirtFeatures.setType       (resultSet.getString("type"      ));
				menTshirtFeatures.setFit        (resultSet.getString("fit"       ));				
				menTshirtFeatures.setPattern    (resultSet.getString("pattern"   ));
				
				
			} else {
				
				connection.commit();
				
				System.out.println("SQL getMenTshirtFeatures Executed and ResultSet is empty...");
				
				return null;
			}
			
			connection.commit();
			
			System.out.println("SQL getMenTshirtFeatures Executed");
			
			return menTshirtFeatures;
			
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e1) {
			try { connection.rollback();     } catch (SQLException e) {	e.printStackTrace(); }
			e1.printStackTrace();
		} finally {
			menTshirtFeatures = null;
			try { resultSet.close();         } catch (SQLException e) { e.printStackTrace(); }
			try { preparedStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { connection.close();        } catch (SQLException e) { e.printStackTrace(); }
			System.gc();
		}
		
		
		return null;
	} //getMenTshirtFeatures
	
	
	public _MenTshirtFeatures editMenTshirtFeatures(long productId, long sellerId, String sleeve, String fabric, String type, 
			String pattern, String fit) {		
		
		Connection connection = null; CallableStatement callableStatement = null; ResultSet resultSet = null;
		
		String sql = "{call _editMenTshirtFeatures(?,?,?,?,?,?,?)}";	
		
		_MenTshirtFeatures menTshirtFeatures = new _MenTshirtFeatures();
		
		
		try {
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
				
				callableStatement = connection.prepareCall(sql);
				callableStatement.setLong  (1, productId);
				callableStatement.setLong  (2, sellerId);
				callableStatement.setString(3, sleeve);
				callableStatement.setString(4, fabric);
				callableStatement.setString(5, type);
				callableStatement.setString(6, fit);
				callableStatement.setString(7, pattern);
				 			
				resultSet = callableStatement.executeQuery();			
					
				if (resultSet.next()) {
					
					menTshirtFeatures.setId         (resultSet.getLong  ("id"        ));
					menTshirtFeatures.setProductId  (resultSet.getLong  ("product_id"));
					menTshirtFeatures.setSellerId   (resultSet.getLong  ("seller_id" ));
					
					menTshirtFeatures.setSleeve     (resultSet.getString("sleeve"    ));
					menTshirtFeatures.setFabric     (resultSet.getString("fabric"    ));				
					menTshirtFeatures.setType       (resultSet.getString("type"      ));
					menTshirtFeatures.setFit        (resultSet.getString("fit"       ));				
					menTshirtFeatures.setPattern    (resultSet.getString("pattern"   ));
				}
				
				connection.commit();
				callableStatement.close();
				
				System.out.println("SQL - Select editMenTshirtFeatures() successfull.");
				
				return menTshirtFeatures;
				
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e1) {
			try { connection.rollback();     } catch (SQLException e) {	e.printStackTrace(); }
			e1.printStackTrace();
		} finally {
			menTshirtFeatures = null;
			try { resultSet.close();         } catch (SQLException e) { e.printStackTrace(); }
			try { callableStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { connection.close();        } catch (SQLException e) { e.printStackTrace(); }
			System.gc();
		}
		
		return null;
	} //editMenTshirtFeatures
	
	
	
	/********************* MEN - Jeans ***********************/
	public _MenJeansFeatures getMenJeansFeatures(long productId) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql            = null;
		ResultSet resultSet   = null;		
		
		_MenJeansFeatures menJeansFeatures = new _MenJeansFeatures();
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM p_men_jeans_spec WHERE product_id = ?";
				
			preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setLong (1,  productId);			
		
			resultSet = preparedStatement.executeQuery();	
			
			if (resultSet.next()) {
				
				menJeansFeatures.setId         (resultSet.getLong("id"         ));
				menJeansFeatures.setProductId  (resultSet.getLong("product_id" ));
				menJeansFeatures.setSellerId   (resultSet.getLong("seller_id"  ));
				
				menJeansFeatures.setFabric     (resultSet.getString("fabric"    ));
				menJeansFeatures.setBrandFit   (resultSet.getString("brand_fit" ));
				menJeansFeatures.setPattern    (resultSet.getString("pattern"   ));
				menJeansFeatures.setPockets    (resultSet.getString("pockets"   ));
				menJeansFeatures.setBeltLoops  (resultSet.getString("belt_loops"));
				menJeansFeatures.setOccasion   (resultSet.getString("occasion"  ));
				
				
			} else {
				
				connection.commit();
				
				System.out.println("SQL getMenJeansFeatures Executed and ResultSet is empty...");
				
				return null;
			}
			
			connection.commit();
			
			System.out.println("SQL getMenJeansFeatures Executed");
			
			return menJeansFeatures;
			
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			menJeansFeatures = null;
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
			System.gc();
		}
		
		
		return null;
	} //getMenJeansFeatures
	
	
	public _MenJeansFeatures editMenJeansFeatures (long productId, long sellerId, String fabric, String brandFit, String pattern, 
			String pockets, String beltLoops, String occasion) {		
		
		Connection connection   = null;
		CallableStatement callableStatement = null;
		ResultSet resultSet = null;
		
		String sql = "{call editMenJeansFeatures(?,?,?,?,?,?,?,?)}";	
		
		_MenJeansFeatures menJeansFeatures = new _MenJeansFeatures();
		
		
		try {
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
				
				callableStatement = connection.prepareCall(sql);
				callableStatement.setLong  (1, productId);
				callableStatement.setLong  (2, sellerId );
				callableStatement.setString(3, fabric   );
				callableStatement.setString(4, brandFit );
				callableStatement.setString(5, pattern  );
				callableStatement.setString(6, pockets  );
				callableStatement.setString(7, beltLoops);
				callableStatement.setString(8, occasion );
				 			
				resultSet = callableStatement.executeQuery();			
					
				if (resultSet.next()) {
					
					menJeansFeatures.setId       (resultSet.getLong  ("id"        ));
					menJeansFeatures.setProductId(resultSet.getLong  ("product_id"));
					menJeansFeatures.setSellerId (resultSet.getLong  ("seller_id" ));
					menJeansFeatures.setFabric   (resultSet.getString("fabric"    ));
					menJeansFeatures.setBrandFit (resultSet.getString("brand_fit" ));
					menJeansFeatures.setPattern  (resultSet.getString("pattern"   ));
					menJeansFeatures.setPockets  (resultSet.getString("pockets"   ));
					menJeansFeatures.setBeltLoops(resultSet.getString("belt_loops"));
					menJeansFeatures.setOccasion (resultSet.getString("occasion"  ));
				}
				
				connection.commit();
				callableStatement.close();
				
				System.out.println("SQL - Select editMenJeansFeatures() successfull.");
				
				return menJeansFeatures;
				
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {	
			
			try {
				connection.rollback();
			} catch (SQLException e1) {					
				e1.printStackTrace();
			}
			e.printStackTrace();
			
		} finally {	
			menJeansFeatures = null;
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
			System.gc();
		}		
		
		return null;
	} //editMenJeansFeatures

}
