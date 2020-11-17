package com.jumplus.ecommerce.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jumplus.ecommerce.connection.ConnectionManager;
import com.jumplus.ecommerce.dao.cartItemDAO;
import com.jumplus.ecommerce.model.User;
import com.jumplus.ecommerce.model.cartItem;


public class cartItemDAOimp implements cartItemDAO {
	private Connection conn = ConnectionManager.getConnection();
	
	@Override
	public List<cartItem> getAllcartItems() {
		// TODO Auto-generated method stub
        List<cartItem> cartItems = new ArrayList<cartItem>();
		
		try(Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from cartitems"); ){
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String code = rs.getString(3);
				Double price = rs.getDouble(4);
				int userId = rs.getInt(5);
				int quantity = rs.getInt(6);
				
				
			
				// add to list
				cartItem cartitem = new cartItem(id, name,code,price, userId, quantity);
				cartItems.add(cartitem);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return cartItems;
	
	}

	@Override
	public List<cartItem> getcartItems(int userId) {
		// TODO Auto-generated method stub
		 List<cartItem> cartItems = new ArrayList<cartItem>();
			
			try(PreparedStatement pstmt = conn.prepareStatement("select * from cartitems where userId = ?")) {
				
				pstmt.setInt(1, userId);
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String code = rs.getString(3);
					Double price = rs.getDouble(4);
					int userId1 = rs.getInt(5);
					int quantity = rs.getInt(6);
					
					
					cartItems.add(new cartItem(id, name, code, price, userId1, quantity));
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			return cartItems;
	}
	
	@Override
	public cartItem getcartItem(int userId, int cartitemId) {
		// TODO Auto-generated method stub
		 cartItem cartItem = null;
			
			try(PreparedStatement pstmt = conn.prepareStatement("select * from cartitems where userId = ? and cartitemId = ?")) {
				
				pstmt.setInt(1, userId);
				pstmt.setInt(2, cartitemId);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String code = rs.getString(3);
					Double price = rs.getDouble(4);
					int userId1 = rs.getInt(5);
					int quantity = rs.getInt(6);
					
					
					cartItem = new cartItem(id, name, code, price, userId1, quantity);
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			return cartItem;
	}


	@Override
	public boolean addcartItem(cartItem cartItem) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into cartitems values(?,?,?,?,?,?)");
			pstmt.setInt(1, cartItem.getItemId());
			pstmt.setString(2, cartItem.getName());
			pstmt.setString(3, cartItem.getCode());
			pstmt.setDouble(4, cartItem.getPrice());
			pstmt.setInt(5, cartItem.getUserId());
			pstmt.setInt(6, cartItem.getQuantity());
			
			
			int insert = pstmt.executeUpdate();
			
			if(insert > 0) {
				return true;
			}
			
			pstmt.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return false;
	}
	
	@Override
	public boolean deletecartItem(int itemId, int userId) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("delete * from cartitems where itemId = ? and userId = ?");
			pstmt.setInt(1, itemId);
			pstmt.setInt(2, userId);
			int delete = pstmt.executeUpdate();
			if(delete > 0) {
				return true;
			}
			
			pstmt.close();
		}	catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	@Override
	public boolean updatecartItemQuantity(cartItem cartItem) {
		try(PreparedStatement pstmt = conn.prepareStatement("UPDATE cartitems SET quantity = ? WHERE itemId = ?")){
			
			 pstmt.setInt(1, cartItem.getQuantity());
			 pstmt.setInt(2, cartItem.getItemId());
			 pstmt.executeUpdate();
			 
			 int insert = pstmt.executeUpdate();
				if(insert > 0) {
					return true;
				}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
