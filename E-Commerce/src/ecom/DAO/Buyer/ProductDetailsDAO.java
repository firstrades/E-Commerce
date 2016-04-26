package ecom.DAO.Buyer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import ecom.common.ConnectionFactory;
import ecom.model.TwoObjects;

public class ProductDetailsDAO {
	
	public static TwoObjects<Double, String> getSellPriceAndWarranty(long productId) {		
		
		String sql            = null;			
		
		TwoObjects<Double, String> twoObjects = new TwoObjects<>();
		
		sql = "SELECT salePriceCustomer, warranty FROM product WHERE product_id = ?";
		
		try (Connection connection = ConnectionFactory.getNewConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {					
							
				preparedStatement.setLong(1, productId);	
				
						try (ResultSet resultSet = preparedStatement.executeQuery()) {					
						
							if (resultSet.next()) {											
								
								twoObjects.setObj1(resultSet.getDouble("salePriceCustomer"));
								twoObjects.setObj2(resultSet.getString("warranty"  ));					
							}	
							
						} catch(SQLException e1) {
							e1.printStackTrace();
						}
				
				System.out.println("SQL getSellPriceAndWarranty(long productId) Executed");
				return twoObjects;
				
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {				
			e.printStackTrace();				
		} finally {
			twoObjects = null;
			System.gc();
		}
		
		return null;
	}

	/********** Electronics - Mobile ************/
	
	public Map<String,String> getMobileFeatures(long productId) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet resultSet = null;		
		Map<String,String> map = new HashMap<>();
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM p_mobile_spec WHERE product_id = ?";
				
			preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setLong (1,  productId);			
		
			resultSet = preparedStatement.executeQuery();	
			
			if (resultSet.next()) {				
				
				map.put("Internal Storage", resultSet.getString("internal_storage"));
				map.put("O.S.",             resultSet.getString("os"));
				map.put("Touch",            resultSet.getString("touch"));
				map.put("WiFi",             resultSet.getString("wifi"));
				map.put("F.M.",             resultSet.getString("fm"));
				map.put("Front Camera",     resultSet.getString("front_camera"));
				map.put("Rear Camera",      resultSet.getString("rear_camera"));
				map.put("Connectivity",     resultSet.getString("connectivity"));
				
			} else {
				
				connection.commit();
				
				System.out.println("SQL getMobileFeatures Executed and ResultSet is empty...");
				
				return null;
			}
			
			connection.commit();
			
			System.out.println("SQL getMobileFeatures Executed");
			
			return map;
			
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e1) {
			try { connection.rollback();     } catch (SQLException e) { e.printStackTrace(); }
			e1.printStackTrace();
		} finally {
			map = null;
			try { preparedStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { connection.close();        } catch (SQLException e) { e.printStackTrace(); }
			System.gc();
		}
		
		
		return null;
	} //getMobileFeatures
	
	/********** Electronics - Laptop ************/
	
	public Map<String,String> getLaptopFeatures(long productId) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet resultSet = null;		
		Map<String,String> map = new HashMap<>();
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM p_laptop_spec WHERE product_id = ?";
				
			preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setLong (1,  productId);			
		
			resultSet = preparedStatement.executeQuery();	
			
			if (resultSet.next()) {				
				
				map.put("Battery Cell",      resultSet.getString("batteryCell"     ));
				map.put("Graphic Processor", resultSet.getString("graphicProcessor"));
				map.put("HDD Capacity",      resultSet.getString("hddCapacity"     ));
				map.put("O.S.",              resultSet.getString("OS"              ));
				map.put("Power Supply",      resultSet.getString("powerSupply"     ));
				map.put("Processor",         resultSet.getString("processor"       ));
				map.put("Screen Size",       resultSet.getString("screenSize"      ));
				map.put("Web Camera",        resultSet.getString("webCamera"       ));
				
				
			} else {
				
				connection.commit();
				
				System.out.println("SQL getLaptopFeatures Executed and ResultSet is empty...");
				
				return null;
			}
			
			connection.commit();
			
			System.out.println("SQL getLaptopFeatures Executed");
			
			return map;
			
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e1) {
			try { connection.rollback();     } catch (SQLException e) { e.printStackTrace(); }
			e1.printStackTrace();
		} finally {
			map = null;
			try { preparedStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { connection.close();        } catch (SQLException e) { e.printStackTrace(); }
			System.gc();
		}
		
		
		return null;
	} //getLaptopFeatures
	
	
	/************ Women - Leggings **************/
	
	public Map<String,String> getLeggingsFeatures(long productId) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet resultSet = null;		
		Map<String,String> map = new HashMap<>();
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM p_leggings_spec WHERE product_id = ?";
				
			preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setLong (1,  productId);			
		
			resultSet = preparedStatement.executeQuery();	
			
			if (resultSet.next()) {				
				
				map.put("Pattern",   resultSet.getString("pattern"));
				map.put("Fabric",    resultSet.getString("fabric"));
				map.put("Style",     resultSet.getString("style"));
				map.put("season",    resultSet.getString("season"));
				map.put("Waistband", resultSet.getString("waistband"));
				
				
			} else {
				
				connection.commit();
				
				System.out.println("SQL getLeggingsFeatures Executed and ResultSet is empty...");
				
				return null;
			}
			
			connection.commit();
			
			System.out.println("SQL getLeggingsFeatures Executed");
			
			return map;
			
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e1) {
			try { connection.rollback();     } catch (SQLException e) { e.printStackTrace(); }
			e1.printStackTrace();
		} finally {
			map = null;
			try { preparedStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { connection.close();        } catch (SQLException e) { e.printStackTrace(); }
			System.gc();
		}
		
		
		return null;
	} //getLeggingsFeatures
	
	/************ Women - Top **************/
	
	public Map<String,String> getTopFeatures(long productId) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet resultSet = null;		
		Map<String,String> map = new HashMap<>();
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM p_top_spec WHERE product_id = ?";
				
			preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setLong (1,  productId);			
		
			resultSet = preparedStatement.executeQuery();	
			
			if (resultSet.next()) {				
				
				map.put("Pattern",  resultSet.getString("pattern" ));
				map.put("Fabric",   resultSet.getString("fabric"  ));
				map.put("Neck",     resultSet.getString("neck"    ));
				map.put("Occasion", resultSet.getString("occasion"));
				map.put("Sleeve",   resultSet.getString("sleeve"  ));
				
				
			} else {
				
				connection.commit();
				
				System.out.println("SQL getTopFeatures Executed and ResultSet is empty...");
				
				return null;
			}
			
			connection.commit();
			
			System.out.println("SQL getTopFeatures Executed");
			
			return map;
			
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e1) {
			try { connection.rollback();     } catch (SQLException e) { e.printStackTrace(); }
			e1.printStackTrace();
		} finally {
			map = null;
			try { preparedStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { connection.close();        } catch (SQLException e) { e.printStackTrace(); }
			System.gc();
		}
		
		
		return null;
	} //getTopFeatures
	
	/************ Men - T-Shirt **************/
	
	public Map<String,String> getMenTshirtFeatures(long productId) {		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet resultSet = null;		
		Map<String,String> map = new HashMap<>();
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM p_men_tshirt_spec WHERE product_id = ?";
				
			preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setLong (1,  productId);			
		
			resultSet = preparedStatement.executeQuery();	
			
			if (resultSet.next()) {				
				
				map.put("Pattern", resultSet.getString("pattern" ));
				map.put("Fabric",  resultSet.getString("fabric"  ));
				map.put("Type",    resultSet.getString("type"  ));
				map.put("Fit",     resultSet.getString("fit"     ));
				map.put("Sleeve",  resultSet.getString("sleeve"  ));
				
				
			} else {
				
				connection.commit();
				
				System.out.println("SQL getMenTshirtFeatures Executed and ResultSet is empty...");
				
				return null;
			}
			
			connection.commit();
			
			System.out.println("SQL getMenTshirtFeatures Executed");
			
			return map;
			
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e1) {
			try { connection.rollback();     } catch (SQLException e) { e.printStackTrace(); }
			e1.printStackTrace();
		} finally {
			map = null;
			try { preparedStatement.close(); } catch (SQLException e) { e.printStackTrace(); }
			try { connection.close();        } catch (SQLException e) { e.printStackTrace(); }
			System.gc();
		}
		
		
		return null;
	} //getMenTshirtFeatures
}
