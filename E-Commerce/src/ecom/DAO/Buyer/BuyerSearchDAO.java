package ecom.DAO.Buyer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ecom.common.ConnectionFactory;
import ecom.model.CartWishlist;
import ecom.model.CustomerOrderHistroy;
import ecom.model.KeyFeatures;
import ecom.model.Order;
import ecom.model.Price;
import ecom.model.ProductBean;
import ecom.model.SizeGarment;
import ecom.model.TwoObjects;
import ecom.model.User;

public class BuyerSearchDAO {

	public List<ProductBean> searchBySubCategory(String subCategory) {  		
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String sql = null;
		ResultSet resultSet = null;		
		List<ProductBean> list = new ArrayList<>();		
		
		try {
			connection = ConnectionFactory.getNewConnection();
			connection.setAutoCommit(false);
			
			sql = "SELECT * FROM product WHERE sub_category = ? AND status = 'approved'";
				
			preparedStatement = connection.prepareStatement(sql);				
			preparedStatement.setString (1, subCategory);   
			 			
			resultSet = preparedStatement.executeQuery();	
			 			
			while (resultSet.next()) {
				
				ProductBean productBean = new ProductBean();
				productBean.setKeyFeatures(new KeyFeatures());
				productBean.setPrice(new Price());
				
				productBean.setProductId                 (resultSet.getInt   ("product_id"));
				productBean.setSellerId                  (resultSet.getLong  ("seller_id"));
				
				productBean.setCategory                  (resultSet.getString("category"));
				productBean.setSubCategory               (resultSet.getString("sub_category"));
				productBean.setProductName               (resultSet.getString("product_name"));
				productBean.setCompanyName               (resultSet.getString("company_name"));
				
				productBean.getPrice().setListPrice      (resultSet.getDouble("list_price"));
				productBean.getPrice().setDiscount       (resultSet.getDouble("discount"));
				productBean.getPrice().setSalePriceCustomer(resultSet.getDouble("salePriceCustomer"));				
				productBean.getPrice().setMarkup         (resultSet.getDouble("markup"));
				
				productBean.getKeyFeatures().setKf1      (resultSet.getString("kf_1"));
				productBean.getKeyFeatures().setKf2      (resultSet.getString("kf_2"));
				productBean.getKeyFeatures().setKf3      (resultSet.getString("kf_3"));
				productBean.getKeyFeatures().setKf4      (resultSet.getString("kf_4"));
				
				
				list.add(productBean);
			}
			
			connection.commit();
			
			System.out.println("SQL getProducts Executed");
			
			return list;
			
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {			
			try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
			e.printStackTrace();
			
		} finally {				
			try { resultSet.close();         } catch (SQLException e)  { e.printStackTrace();  }
			try { preparedStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
			try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
		}		
		
		
		return null;		
		
	}
	
	public List<TwoObjects<ProductBean, Integer>> addToCartOrWishList(long productId, long userId, String cartOrWishlist, int size) {		
			
			Connection connection   = null;
			PreparedStatement preparedStatement = null;
			String sql              = null;
			ResultSet resultSet     = null;		
			ProductBean productBean = null;	
			
			List<TwoObjects<Long, Integer>>        productIdAndQtyList   = new ArrayList<>();
			List<TwoObjects<ProductBean, Integer>> productBeanAndQtyList = new ArrayList<>();
			
			try {
					connection = ConnectionFactory.getNewConnection();
					connection.setAutoCommit(false);
					
					//---------------------------------------------------------------------------------------------------------------------------------
					if (productId != 0L)  {
					
								/**
								 * @Check if Product already exist
								 */
								sql = "SELECT * FROM cart_wishlist WHERE product_id = ? AND cart_wishlist = ? AND user_id = ?";
																															
								preparedStatement = connection.prepareStatement(sql);				
								preparedStatement.setLong   (1, productId);   
								preparedStatement.setString (2, cartOrWishlist); 
								preparedStatement.setLong   (3, userId);
								 			
								resultSet = preparedStatement.executeQuery();			
								 																								
								if (resultSet.next()) {
									
										resultSet.close();
										preparedStatement.close();		
									
								} else {
									
										resultSet.close();
										preparedStatement.close();
										
										/**
										 * @Insert Product
										 */
										sql = "INSERT INTO cart_wishlist (product_id, user_id, cart_wishlist, qty, size) VALUES (?,?,?, 1,?)";
										
										preparedStatement = connection.prepareStatement(sql);
										preparedStatement.setLong   (1, productId);
										preparedStatement.setLong   (2, userId);
										preparedStatement.setString (3, cartOrWishlist); 
										preparedStatement.setInt    (4, size);
										 			
										int result = preparedStatement.executeUpdate();
										
										if (result != 0) System.out.println("SQL - Insert successfull.");
										
										preparedStatement.close();
								}  // else close
								
					} // if close
					
					//--------------------------------------------------COMMON FOR ALL--------------------------------------------------------------------
					
					/**
					 * @Retrieve all productIds for this User
					 */
					
					sql = "SELECT product_id, qty FROM cart_wishlist WHERE user_id = ? AND cart_wishlist = ?";
					
					preparedStatement = connection.prepareStatement(sql);				
					preparedStatement.setLong   (1, userId); 
					preparedStatement.setString (2, cartOrWishlist);
					 			
					resultSet = preparedStatement.executeQuery();
				
					while (resultSet.next()) {
						
						TwoObjects<Long, Integer> twoObjects = new TwoObjects<>();
						
						twoObjects.setObj1 (resultSet.getLong("product_id"));  System.out.println(twoObjects.getObj1());
						twoObjects.setObj2 (resultSet.getInt ("qty"       ));  System.out.println(twoObjects.getObj2());
						
						productIdAndQtyList.add(twoObjects);
					}
					
					resultSet.close();
					preparedStatement.close();
					
					/**
					 * @Retrieve ProductBeanList
					 */
					
					for (TwoObjects<Long, Integer> twoObjects : productIdAndQtyList) {
						
							sql = "SELECT * FROM product WHERE product_id = ?";
							
							preparedStatement = connection.prepareStatement(sql);				
							preparedStatement.setLong (1, twoObjects.getObj1());   
							 			
							resultSet = preparedStatement.executeQuery();
							
							if (resultSet.next()) {
							
									productBean = new ProductBean();
									//productBean.setKeyFeatures(new KeyFeatures());
									//productBean.setPrice(new Price());
									
									TwoObjects<ProductBean, Integer> twoObjects2 = new TwoObjects<>();
									
									productBean.setProductId                 (resultSet.getInt   ("product_id"  ));
									productBean.setSellerId                  (resultSet.getLong  ("seller_id"   ));
									
									productBean.setCategory                  (resultSet.getString("category"    ));
									productBean.setSubCategory               (resultSet.getString("sub_category"));
									productBean.setProductName               (resultSet.getString("product_name"));
									productBean.setCompanyName               (resultSet.getString("company_name"));
									
									productBean.getPrice().setListPrice      (resultSet.getDouble("list_price"  ));
									productBean.getPrice().setDiscount       (resultSet.getDouble("discount"    ));
									productBean.getPrice().setSalePriceCustomer(resultSet.getDouble("salePriceCustomer"));
									productBean.getPrice().setMarkup         (resultSet.getDouble("markup"      ));
									
									productBean.getKeyFeatures().setKf1      (resultSet.getString("kf_1"));
									productBean.getKeyFeatures().setKf2      (resultSet.getString("kf_2"));
									productBean.getKeyFeatures().setKf3      (resultSet.getString("kf_3"));
									productBean.getKeyFeatures().setKf4      (resultSet.getString("kf_4"));
									
									twoObjects2.setObj1(productBean);
									twoObjects2.setObj2(twoObjects.getObj2());
									
									productBeanAndQtyList.add(twoObjects2);
									
							}  // if close
							
							resultSet.close();
							preparedStatement.close();
							
					}  // for close
					
					connection.commit();		
					
					System.out.println("SQL addToCartOrWishList Executed");
					
					return productBeanAndQtyList;
				
				
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {			
				try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
				e.printStackTrace();
				
			} finally {				
				try { resultSet.close();         } catch (SQLException e)  { e.printStackTrace();  }
				try { preparedStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
				try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
			}		
			
			
			return null;		
	}
	
	
	public boolean deleteCartOrWishListItem(long productId, long userId, String cartOrWishlist) {		
			
			Connection connection   = null;
			PreparedStatement preparedStatement = null;
			String sql              = null;
			
			try {
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
				
				sql = "DELETE FROM cart_wishlist WHERE product_id = ? AND user_id = ? AND cart_wishlist = ?";
				
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setLong  (1, productId);
				preparedStatement.setLong  (2, userId);
				preparedStatement.setString(3, cartOrWishlist);
				int result = preparedStatement.executeUpdate();
				
				connection.commit();		
				
				System.out.println("SQL deleteCartOrWishListItem Executed");
				
				if (result != 0)  return true;
				
				
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {			
				try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
				e.printStackTrace();
				
			} finally {				
				
				try { preparedStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
				try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
			}		
			
			return false;
	}
	
	
	public List<TwoObjects<ProductBean, Integer>> moveToCartOrWishList(long productId, long userId, String cartOrWishlist,
			int qty, int size) {  //wish		
				
				Connection connection   = null;
				PreparedStatement preparedStatement = null;
				String sql              = null;
				ResultSet resultSet     = null;		
				ProductBean productBean = null;	
				
				List<TwoObjects<Long, Integer>>        productIdAndQtyList   = new ArrayList<>();
				List<TwoObjects<ProductBean, Integer>> productBeanAndQtyList = new ArrayList<>();
				
				try {
						connection = ConnectionFactory.getNewConnection();
						connection.setAutoCommit(false);
						
						//----------------------------------------------------------------------------------------------------------------------------------
						
						String toggle = null;
						
						if (cartOrWishlist.equals("cart"))					
							toggle = "wishlist";				
						else					
							toggle = "cart";
						
						/**
						 * @Check if Product already exist
						 */
						sql = "SELECT * FROM cart_wishlist WHERE product_id = ? AND cart_wishlist = ? AND user_id = ?";
																													
						preparedStatement = connection.prepareStatement(sql);				
						preparedStatement.setLong   (1, productId);   
						preparedStatement.setString (2, toggle);  
						preparedStatement.setLong   (3, userId);
						 			
						resultSet = preparedStatement.executeQuery();			
						 																								
						if (resultSet.next()) {
							
								resultSet.close();
								preparedStatement.close();	
								
								sql = "DELETE FROM cart_wishlist WHERE product_id = ? AND user_id = ? AND cart_wishlist = ?";
								
								preparedStatement = connection.prepareStatement(sql);
								preparedStatement.setLong  (1, productId);
								preparedStatement.setLong  (2, userId);
								preparedStatement.setString(3, cartOrWishlist);
								int result = preparedStatement.executeUpdate();
								
								if (result != 0) System.out.println("SQL - Delete successfull.");
							
						} else {
							
								resultSet.close();
								preparedStatement.close();
						
								
								
								sql = "UPDATE cart_wishlist SET cart_wishlist = ?, qty = ? WHERE product_id = ? AND user_id = ? AND cart_wishlist = ?";
								
								preparedStatement = connection.prepareStatement(sql);
								preparedStatement.setString (1, toggle);
								preparedStatement.setInt    (2, qty);
								preparedStatement.setLong   (3, productId);
								preparedStatement.setLong   (4, userId); 
								preparedStatement.setString (5, cartOrWishlist);
								 			
								int result = preparedStatement.executeUpdate();
								
								if (result != 0) System.out.println("SQL - Update successfull.");
								
						}  // else close		
						
						//--------------------------------------------------COMMON FOR ALL--------------------------------------------------------------------
						
						/**
						 * @Retrieve all productIds for this User
						 */
						
						sql = "SELECT product_id, qty FROM cart_wishlist WHERE user_id = ? AND cart_wishlist = ?";
						
						preparedStatement = connection.prepareStatement(sql);				
						preparedStatement.setLong   (1, userId); 
						preparedStatement.setString (2, toggle);
						 			
						resultSet = preparedStatement.executeQuery();
					
						while (resultSet.next()) {
							
							TwoObjects<Long, Integer> twoObjects = new TwoObjects<>();
							
							twoObjects.setObj1 (resultSet.getLong("product_id"));  System.out.println(twoObjects.getObj1());
							twoObjects.setObj2 (resultSet.getInt("qty"        ));  System.out.println(twoObjects.getObj2());
							
							productIdAndQtyList.add(twoObjects);
						}
						
						resultSet.close();
						preparedStatement.close();
						
						/**
						 * @Retrieve ProductBeanList
						 */
						
						for (TwoObjects<Long, Integer> twoObjects : productIdAndQtyList) {
							
								sql = "SELECT * FROM product WHERE product_id = ?";
								
								preparedStatement = connection.prepareStatement(sql);				
								preparedStatement.setLong (1, twoObjects.getObj1());   
								 			
								resultSet = preparedStatement.executeQuery();
								
								if (resultSet.next()) {
								
										productBean = new ProductBean();
										productBean.setKeyFeatures(new KeyFeatures());
										productBean.setPrice(new Price());
										
										TwoObjects<ProductBean, Integer> twoObjects2 = new TwoObjects<>();
										
										productBean.setProductId                 (resultSet.getInt   ("product_id"  ));
										productBean.setSellerId                  (resultSet.getLong  ("seller_id"   ));
										
										productBean.setCategory                  (resultSet.getString("category"    ));
										productBean.setSubCategory               (resultSet.getString("sub_category"));
										productBean.setProductName               (resultSet.getString("product_name"));
										productBean.setCompanyName               (resultSet.getString("company_name"));
										
										productBean.getPrice().setListPrice      (resultSet.getDouble("list_price"  ));
										productBean.getPrice().setDiscount       (resultSet.getDouble("discount"    ));
										productBean.getPrice().setSalePriceCustomer(resultSet.getDouble("salePriceCustomer"));
										productBean.getPrice().setMarkup         (resultSet.getDouble("markup"  ));
										
										productBean.getKeyFeatures().setKf1      (resultSet.getString("kf_1"));
										productBean.getKeyFeatures().setKf2      (resultSet.getString("kf_2"));
										productBean.getKeyFeatures().setKf3      (resultSet.getString("kf_3"));
										productBean.getKeyFeatures().setKf4      (resultSet.getString("kf_4"));
										
										twoObjects2.setObj1(productBean);
										twoObjects2.setObj2(twoObjects.getObj2());
										
										productBeanAndQtyList.add(twoObjects2);
										
								}  // if close
								
								resultSet.close();
								preparedStatement.close();
								
						}  // for close
						
						connection.commit();		
						
						System.out.println("SQL addToCartOrWishList Executed");
						
						return productBeanAndQtyList;
						
						
					
					
				} catch (InstantiationException | IllegalAccessException
						| ClassNotFoundException | SQLException e) {			
					try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
					e.printStackTrace();
					
				} finally {				
					try { resultSet.close();         } catch (SQLException e)  { e.printStackTrace();  }
					try { preparedStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
					try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
				}		
				
				
				return null;		
	} // moveToCartOrWishList	
	
	
	public int insertQtyOfRow(long user_id, int qty, long productId) {		
		
		Connection connection   = null;
		CallableStatement callableStatement = null;
		String sql = "{call insertQtyOfRow(?,?,?)}";			
		
		int qty1 = 0;
		
		try {
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
				
				callableStatement = connection.prepareCall(sql);
				callableStatement.setInt  (1, qty      );
				callableStatement.setLong (2, productId);
				callableStatement.setLong (3, user_id  ); 
				callableStatement.registerOutParameter(1, java.sql.Types.INTEGER);
				 			
				callableStatement.execute();			
					
				qty1 = callableStatement.getInt(1);			
				
				connection.commit();
				callableStatement.close();
				
				System.out.println("SQL - Select insertQtyOfRow() successfull.");
				
				return qty1;
				
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {			
			try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
			e.printStackTrace();
			
		} finally {				
			
			try { callableStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
			try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
		}		
		
		return 0;
		
	} // insertQtyOfRow
	
	
	public static List<CartWishlist> getCartWishlist(Long productId, int qty, String cart, long userId, int size) {			
		
		Connection connection   = null;
		PreparedStatement preparedStatement = null;
		String sql              = null;
		ResultSet resultSet     = null;	
		
		long id = 0;
		int  result;
		
		CartWishlist cartWishlist = new CartWishlist();
		List<CartWishlist> list = new ArrayList<>();
		
		try {
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
				//----SQL----
				sql = "SELECT * FROM cart_wishlist WHERE product_id = ? AND user_id = ? AND cart_wishlist = ?";			
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setLong  (1, productId);
				preparedStatement.setLong  (2, userId);
				preparedStatement.setString(3, cart);			
				resultSet = preparedStatement.executeQuery();
				
				if (resultSet.next()) {
					
						id = resultSet.getLong("id");
						
						System.out.println("Product Exist...");
						resultSet.close();
						preparedStatement.close();
						
				} else {
					
						System.out.println("Product Not Exist...");
						resultSet.close();
						preparedStatement.close();
						//----SQL---
						sql = "INSERT INTO cart_wishlist (product_id, user_id, cart_wishlist, qty, size) VALUES (?,?,?,?,?)";					
						preparedStatement = connection.prepareStatement(sql);
						preparedStatement.setLong  (1, productId);
						preparedStatement.setLong  (2, userId);
						preparedStatement.setString(3, cart);
						preparedStatement.setInt   (4, qty);
						preparedStatement.setInt   (5, size);
						result = preparedStatement.executeUpdate();
						preparedStatement.close();
						
						if (result != 0) {  
								//----SQL----
								sql = "SELECT MAX(id) FROM cart_wishlist";							
								preparedStatement = connection.prepareStatement(sql);
								resultSet         = preparedStatement.executeQuery();	
								
								if (resultSet.next()) {
									id = resultSet.getLong(1);
								}
								
								resultSet.close();
								preparedStatement.close();
						}
				}
			
				//----SQL----
				sql = "SELECT product_id, qty, size FROM cart_wishlist WHERE id = ?";  
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setLong(1, id);
				resultSet         = preparedStatement.executeQuery();	
				
				if (resultSet.next()) {
					
					cartWishlist.setProductId(resultSet.getLong("product_id"));
					cartWishlist.setQty      (resultSet.getInt ("qty"));
					cartWishlist.setSize     (resultSet.getInt ("size"));
					
					list.add(cartWishlist);
				}							
			
				connection.commit();
				
				System.out.println("SQL - getProductIdAndQty(Long productId, int qty, String cart, long userId) Successfull.");
				
				return list;
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {			
			try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
			e.printStackTrace();
			
		} finally {				
			try { resultSet.close();         } catch (SQLException e)  { e.printStackTrace();  }
			try { preparedStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
			try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
		}	
		
		return null;
	}
	
	public static List<CartWishlist> getCartWishlist(String cart, long userId) {			
		
		Connection connection   = null;
		PreparedStatement preparedStatement = null;
		String sql              = null;
		ResultSet resultSet     = null;				
		
		List<CartWishlist> list = new ArrayList<>();
		
		try {
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
				
				//----SQL----
				sql = "SELECT product_id, qty, size FROM cart_wishlist WHERE user_id = ? AND cart_wishlist = ?";
				preparedStatement = connection.prepareStatement(sql);				
				preparedStatement.setLong  (1, userId);
				preparedStatement.setString(2, cart);			
				resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {						
					
					CartWishlist cartWishlist = new CartWishlist();
					
					
					cartWishlist.setProductId(resultSet.getLong("product_id"));
					cartWishlist.setQty      (resultSet.getInt ("qty"       ));
					cartWishlist.setSize     (resultSet.getInt ("size"      ));
			
					list.add(cartWishlist);	
				}
			
				connection.commit();
				
				System.out.println("SQL - getProductIdAndQty(String cart, long userId) Successfull.");
				
				return list;
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {			
			try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
			e.printStackTrace();
			
		} finally {				
			try { resultSet.close();         } catch (SQLException e)  { e.printStackTrace();  }
			try { preparedStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
			try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
		}	
		
		return null;
	} // getProductIdAndQty
	
	public Order setDeliveryAddressIfExists(Order order, User user) {
		
			Connection connection               = null;
			CallableStatement callableStatement = null;			
			String sql = "{call setDeliveryAddressIfExists(?,?,?,?,?,?,?,?,?,?,?,?,?)}";				
			
			
			try {
					connection = ConnectionFactory.getNewConnection();
					connection.setAutoCommit(false);
					
					callableStatement = connection.prepareCall(sql);
					
					callableStatement.setLong(1, user.getUserInfo().getId());
					callableStatement.registerOutParameter(1,  java.sql.Types.INTEGER);
					callableStatement.registerOutParameter(2,  java.sql.Types.BOOLEAN);
					callableStatement.registerOutParameter(3,  java.sql.Types.INTEGER);
					callableStatement.registerOutParameter(4,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(5,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(6,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(7,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(8,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(9,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(10, java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(11, java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(12, java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(13, java.sql.Types.VARCHAR);
					 			
					callableStatement.execute();			
					// if address exists
					order.getDeliveryAddress().setExits(callableStatement.getBoolean(2));	
					
					boolean addressExists = order.getDeliveryAddress().isExits();
					
					if (addressExists) {
						
						order.getDeliveryAddress().setUserId (callableStatement.getLong(1)   );
						order.getDeliveryAddress().setId     (callableStatement.getLong(3)   );
						order.getDeliveryAddress().setfName  (callableStatement.getString(4) );
						order.getDeliveryAddress().setlName  (callableStatement.getString(5) );
						order.getDeliveryAddress().setContact(callableStatement.getString(6) );
						order.getDeliveryAddress().setAddress(callableStatement.getString(7) );  
						order.getDeliveryAddress().setAddress1(callableStatement.getString(8) );  
						order.getDeliveryAddress().setCity   (callableStatement.getString(9) );
						order.getDeliveryAddress().setState  (callableStatement.getString(10) );
						order.getDeliveryAddress().setPin    (callableStatement.getString(11));
						order.getDeliveryAddress().setEmail  (callableStatement.getString(12));
						order.getDeliveryAddress().setCompany(callableStatement.getString(13));
					}
					
					connection.commit();
					callableStatement.close();
					
					System.out.println("SQL - Select setDeliveryAddressIfExists() successfull.");
					
					return order;
					
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {			
				try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
				e.printStackTrace();
				
			} finally {				
				
				try { callableStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
				try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
			}		
			
		return null;
		
	} // setDeliveryAddressIfExists
	
	
	public Order editDeliveryAddress(String fName, String lName, String pincode, String address1, String address2, String city, 
			String state, String contact, Order order, User user) {
		
			Connection connection               = null;
			CallableStatement callableStatement = null;			
			String sql = "{call editDeliveryAddress(?,?,?,?,?,?,?,?,?)}";				
			
			
			try {
					connection = ConnectionFactory.getNewConnection();
					connection.setAutoCommit(false);
					
					callableStatement = connection.prepareCall(sql);
					
					callableStatement.setLong  (1, user.getUserInfo().getId());
					callableStatement.setString(2, fName  );
					callableStatement.setString(3, lName  );
					callableStatement.setString(4, contact);
					callableStatement.setString(5, address1);
					callableStatement.setString(6, address2);
					callableStatement.setString(7, city   );
					callableStatement.setString(8, state  );
					callableStatement.setString(9, pincode);					
					
					callableStatement.registerOutParameter(1,  java.sql.Types.INTEGER);
					callableStatement.registerOutParameter(2,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(3,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(4,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(5,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(6,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(7,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(8,  java.sql.Types.VARCHAR);	
					callableStatement.registerOutParameter(9,  java.sql.Types.VARCHAR);	
					 			
					callableStatement.execute();						
					
					order.getDeliveryAddress().setfName  (callableStatement.getString(2));
					order.getDeliveryAddress().setlName  (callableStatement.getString(3));
					order.getDeliveryAddress().setContact(callableStatement.getString(4));					
					order.getDeliveryAddress().setAddress(callableStatement.getString(5));
					order.getDeliveryAddress().setAddress1(callableStatement.getString(6));
					order.getDeliveryAddress().setCity   (callableStatement.getString(7));
					order.getDeliveryAddress().setState  (callableStatement.getString(8));					
					order.getDeliveryAddress().setPin    (callableStatement.getString(9));
					
					
					connection.commit();
					callableStatement.close();
					
					System.out.println("SQL - Select editDeliveryAddress() successfull.");
					
					return order;
					
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {			
				try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
				e.printStackTrace();
				
			} finally {				
				
				try { callableStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
				try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
			}		
			
			return null;
		
	} // editDeliveryAddress
	
	
	public Order newDeliveryAddress(String fName, String lName, String pincode, String address1, String address2, String city, 
			String state, String contact, Order order, User user) {
		
			Connection connection               = null;
			CallableStatement callableStatement = null;			
			String sql = "{call newDeliveryAddress(?,?,?,?,?,?,?,?,?)}";				
			
			
			try {
					connection = ConnectionFactory.getNewConnection();
					connection.setAutoCommit(false);
					
					callableStatement = connection.prepareCall(sql);
					
					callableStatement.setLong  (1, user.getUserInfo().getId());
					callableStatement.setString(2, fName  );
					callableStatement.setString(3, lName  );
					callableStatement.setString(4, contact);
					callableStatement.setString(5, address1);
					callableStatement.setString(6, address2);
					callableStatement.setString(7, city   );
					callableStatement.setString(8, state  );
					callableStatement.setString(9, pincode);					
					
					callableStatement.registerOutParameter(2,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(3,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(4,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(5,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(6,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(7,  java.sql.Types.VARCHAR);
					callableStatement.registerOutParameter(8,  java.sql.Types.VARCHAR);	
					callableStatement.registerOutParameter(9,  java.sql.Types.VARCHAR);
					 			
					callableStatement.execute();						
					
					order.getDeliveryAddress().setfName  (callableStatement.getString(2));
					order.getDeliveryAddress().setlName  (callableStatement.getString(3));
					order.getDeliveryAddress().setContact(callableStatement.getString(4));					
					order.getDeliveryAddress().setAddress(callableStatement.getString(5));
					order.getDeliveryAddress().setAddress(callableStatement.getString(6));
					order.getDeliveryAddress().setCity   (callableStatement.getString(7));
					order.getDeliveryAddress().setState  (callableStatement.getString(8));					
					order.getDeliveryAddress().setPin    (callableStatement.getString(9));
					
					order.getDeliveryAddress().setExits  (true);
					
					connection.commit();
					callableStatement.close();
					
					System.out.println("SQL - Select editDeliveryAddress() successfull.");
					
					return order;
					
			} catch (InstantiationException | IllegalAccessException
					| ClassNotFoundException | SQLException e) {			
				try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
				e.printStackTrace();
				
			} finally {				
				
				try { callableStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
				try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
			}		
			
			return null;
		
	} // NewDeliveryAddress
	
	public ProductBean getProductBean(long productId) {
		
		Connection connection   = null;
		PreparedStatement preparedStatement = null;
		String sql              = null;
		ResultSet resultSet     = null;				
		
		ProductBean productBean = new ProductBean();
		
		try {
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);				
				
				sql = "SELECT category, company_name, product_name, seller_company, sub_category, warranty, calcellation_after_booked FROM product WHERE product_id = ?";
				
				preparedStatement = connection.prepareStatement(sql);				
				preparedStatement.setLong  (1, productId);
						
				resultSet = preparedStatement.executeQuery();
				
				if (resultSet.next()) {					
				
					productBean.setCategory     (resultSet.getString("category"      ));
					productBean.setCompanyName  (resultSet.getString("company_name"  ));
					productBean.setProductName  (resultSet.getString("product_name"  ));
					productBean.setSellerCompany(resultSet.getString("seller_company"));
					productBean.setSubCategory  (resultSet.getString("sub_category"  ));
					productBean.setWarranty     (resultSet.getString("warranty"      ));
					productBean.setCancellationAfterBooked(resultSet.getInt("calcellation_after_booked"));
				}
			
				connection.commit();
				
				System.out.println("SQL - getProductBean Successfull.");
				
				return productBean;
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {			
			try { connection.rollback();     } catch (SQLException e1) { e1.printStackTrace(); }
			e.printStackTrace();
			
		} finally {				
			try { resultSet.close();         } catch (SQLException e)  { e.printStackTrace();  }
			try { preparedStatement.close(); } catch (SQLException e)  { e.printStackTrace();  }
			try { connection.close();        } catch (SQLException e)  { e.printStackTrace();  }
		}	
		
		return null;
	} // getProductBean
	
	
	public SizeGarment getSizeGarmentModel(long productId, SizeGarment sizeGarment) {
		
		Connection connection = null; CallableStatement callableStatement = null; ResultSet resultSet = null;
		
		String sql = "{call getSizeGarmentModel(?)}";		
		
		try {
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
				
				callableStatement = connection.prepareCall(sql);
				
				callableStatement.setLong(1, productId);							
				 			
				resultSet = callableStatement.executeQuery();						
				
				if (resultSet.next()) {
					//if exists
					sizeGarment.setProductIdExists(true);
					
					sizeGarment.setId       (resultSet.getLong("id"));
					sizeGarment.setProductId(resultSet.getLong("product_id"));
					
					sizeGarment.getSize().setQtyOfSize26(resultSet.getInt("s26"));  
					sizeGarment.getSize().setQtyOfSize28(resultSet.getInt("s28"));
					sizeGarment.getSize().setQtyOfSize30(resultSet.getInt("s30"));
					sizeGarment.getSize().setQtyOfSize32(resultSet.getInt("s32"));
					sizeGarment.getSize().setQtyOfSize34(resultSet.getInt("s34"));
					sizeGarment.getSize().setQtyOfSize36(resultSet.getInt("s36"));
					sizeGarment.getSize().setQtyOfSize38(resultSet.getInt("s38"));
					sizeGarment.getSize().setQtyOfSize40(resultSet.getInt("s40"));
					sizeGarment.getSize().setQtyOfSize42(resultSet.getInt("s42"));
					sizeGarment.getSize().setQtyOfSize44(resultSet.getInt("s44"));
					sizeGarment.getSize().setQtyOfSize46(resultSet.getInt("s46"));
					sizeGarment.getSize().setQtyOfSize48(resultSet.getInt("s48")); 
					
				}
				
				connection.commit();
				callableStatement.close();
				
				System.out.println("SQL - Select getSizeGarmentModel() successfull.");
				
				return sizeGarment;
				
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
		
	} //getSizeGarmentModel
	
	//Soumya
	public List<CustomerOrderHistroy> getCustomerOrderHistroy(User user) {
		
		Connection connection = null; CallableStatement callableStatement = null; ResultSet resultSet = null;
		
	    List<CustomerOrderHistroy> list = new ArrayList<CustomerOrderHistroy>();
	    
		String sql = "{call getCustomerOrderHistroy(?)}";		
		
		try {
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
				
				callableStatement = connection.prepareCall(sql);
				
				callableStatement.setLong(1, user.getUserInfo().getId());							
				 			
				resultSet = callableStatement.executeQuery();						
				
				while (resultSet.next()) {
					
					CustomerOrderHistroy customerOrderHistroy = new CustomerOrderHistroy();
					
					customerOrderHistroy.setCalcellationAfterBooked(resultSet.getInt   ("calcellationAfterBooked"));
					customerOrderHistroy.setCompanyName            (resultSet.getString("companyName"            ));
					customerOrderHistroy.setDeliveredDate          (resultSet.getString("deliveredDate"          ));
					customerOrderHistroy.setId                     (resultSet.getInt   ("id"                     )); // Order Table ID 
					customerOrderHistroy.setOrderId                (resultSet.getString("orderId"                ));  
					customerOrderHistroy.setOrderState             (resultSet.getString("orderState"             ));
					customerOrderHistroy.setOrderTableId           (resultSet.getLong  ("orderTableId"           ));
					customerOrderHistroy.setPaymentType            (resultSet.getString("paymentType"            ));
					customerOrderHistroy.setProductId              (resultSet.getLong  ("productId"              ));
					customerOrderHistroy.setProductName            (resultSet.getString("productName"            ));
					customerOrderHistroy.setQty                    (resultSet.getInt   ("qty"                    ));
					customerOrderHistroy.setSellerCompany          (resultSet.getString("sellerCompany"          ));
					customerOrderHistroy.setSellPrice              (resultSet.getDouble("sellPrice"              ));
					customerOrderHistroy.setShippingCost           (resultSet.getDouble("shippingCost"           ));
					customerOrderHistroy.setSize                   (resultSet.getInt   ("size"                   ));
					customerOrderHistroy.setStatus                 (resultSet.getString("status"                 ));
					customerOrderHistroy.setWarranty               (resultSet.getString("warranty"               ));
					customerOrderHistroy.setOrderBookedDate        (resultSet.getString("orderBookedDate"        ));             
		
					list.add(customerOrderHistroy);
					
				}
				
				connection.commit();
				callableStatement.close();
				
				System.out.println("SQL - Select getCustomerOrderHistroy() successfull.");
				
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
		
	} //getCustomerOrderHistroy
	
	//Soumya
	public Set<String> getOrderIdForCustomer(User user) {
		
		Connection connection = null; CallableStatement callableStatement = null; ResultSet resultSet = null;
		
	    Set<String> set = new HashSet<>();
	    
		String sql = "{call getOrderIdForCustomer(?)}";		
		
		try {
				connection = ConnectionFactory.getNewConnection();
				connection.setAutoCommit(false);
				
				callableStatement = connection.prepareCall(sql);
				
				callableStatement.setLong(1, user.getUserInfo().getId());							
				 			
				resultSet = callableStatement.executeQuery();						
				
				while (resultSet.next()) {
					
					
					String orderId = resultSet.getString("order_id");
		
					set.add(orderId);
					
				}
				
				connection.commit();
				callableStatement.close();
				
				System.out.println("SQL - Select getOrderIdForCustomer() successfull.");
				
				return set;
				
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
		
	} //getOrderIdForCustomer
}
