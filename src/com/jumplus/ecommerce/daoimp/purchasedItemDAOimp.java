package com.jumplus.ecommerce.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jumplus.ecommerce.connection.ConnectionManager;
import com.jumplus.ecommerce.dao.purchasedItemDAO;
import com.jumplus.ecommerce.model.purchasedItem;

public class purchasedItemDAOimp implements purchasedItemDAO{ 
	
	private Connection conn = ConnectionManager.getConnection();
	
	@Override
	public List<purchasedItem> getAllpurchasedItems(){
		// TODO Auto-generated method stub
        List<purchasedItem> purchasedItems = new ArrayList<purchasedItem>();
		
		try(Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from inventory"); ){
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String code = rs.getString(3);
				Double price = rs.getDouble(4);
				int userId = rs.getInt(5);
				String purchaseDate = rs.getString(6);
				int quantity = rs.getInt(7);
			
				purchasedItem purchaseditem = new purchasedItem(id, name,code,price, userId, purchaseDate, quantity);
				purchasedItems.add(purchaseditem);
			}
			return purchasedItems;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return purchasedItems;
	
	}


	@Override
	public List<purchasedItem> getpurchasedItems(int userId){
		// TODO Auto-generated method stub
		List<purchasedItem> purchasedItems = new ArrayList<purchasedItem>();
			
			try(PreparedStatement pstmt = conn.prepareStatement("select * from inventory where userId = ?")) {
				
				pstmt.setInt(1, userId);
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String code = rs.getString(3);
					Double price = rs.getDouble(4);
					int userId1 = rs.getInt(5);
					String purchaseDate = rs.getString(6);
					int quantity = rs.getInt(7);
					
					purchasedItem purchasedItem = new purchasedItem(id, name, code, price, userId1, purchaseDate, quantity);
					purchasedItems.add(purchasedItem);
					
				}
				return purchasedItems;
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			return purchasedItems;
		
	}

	@Override
	public boolean addpurchasedItem(purchasedItem purchasedItem) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into inventory values(?,?,?,?)");
			pstmt.setInt(1, purchasedItem.getItemId());
			pstmt.setString(2, purchasedItem.getName());
			pstmt.setString(3, purchasedItem.getCode());
			pstmt.setDouble(4, purchasedItem.getPrice());
			pstmt.setInt(5, purchasedItem.getUserId());
			pstmt.setString(6, purchasedItem.getPurchaseDate());
			pstmt.setInt(7,  purchasedItem.getQuantity());
			
			
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
	
	
	public boolean deletepurchasedItem(int itemId, int userId) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("delete * from cartinventory where itemId = ? and userId = ?");
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




}
