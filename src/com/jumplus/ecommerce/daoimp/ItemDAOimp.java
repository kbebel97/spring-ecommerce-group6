package com.jumplus.ecommerce.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jumplus.ecommerce.connection.ConnectionManager;
import com.jumplus.ecommerce.dao.ItemDAO;
import com.jumplus.ecommerce.model.Item;


public class ItemDAOimp implements ItemDAO {
	private Connection conn = ConnectionManager.getConnection();
	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
        List<Item> items = new ArrayList<Item>();
		
		try(Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from inventory"); ){
			
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String code = rs.getString(3);
				Double price = rs.getDouble(4);
			
				Item item = new Item(id, name,code,price);
				items.add(item);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return items;
	
	}


	@Override
	public Item getItem(int itemId) {
		// TODO Auto-generated method stub
		 Item item = null;
			
			try(PreparedStatement pstmt = conn.prepareStatement("select * from inventory where itemId = ?")) {
				
				pstmt.setInt(1, itemId);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String code1 = rs.getString(3);
					Double price = rs.getDouble(4);
					
					
					item = new Item(id, name, code1, price);
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			return item;
		
	}

	@Override
	public boolean addItem(Item item) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into inventory values(?,?,?,?)");
			pstmt.setInt(1, item.getItemId());
			pstmt.setString(2, item.getName());
			pstmt.setString(3, item.getCode());
			pstmt.setDouble(4, item.getPrice());
			
			
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

}
