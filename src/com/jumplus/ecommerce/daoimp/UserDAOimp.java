package com.jumplus.ecommerce.daoimp;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jumplus.ecommerce.connection.ConnectionManager;
import com.jumplus.ecommerce.dao.UserDAO;
import com.jumplus.ecommerce.model.Invoice;
import com.jumplus.ecommerce.model.User;
import com.jumplus.ecommerce.model.User.ROLE;


public class UserDAOimp implements UserDAO {

	private Connection conn = ConnectionManager.getConnection();
	
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		try(Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from users"); ){
					
					while(rs.next()) {
						int id = rs.getInt(1);
						String username = rs.getString(2);
						String name = rs.getString(3);
						String password = rs.getString(4);
						String email=rs.getString(5);
						ROLE role=User.ROLE.valueOf(rs.getString(6));
						User user = new User(id, username, name, password, email, role);
						users.add(user);
					}
					
				}catch (Exception e) {
					e.printStackTrace();
				}
				
				return users;
			
			}

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		User user = null;
		
		try(PreparedStatement pstmt = conn.prepareStatement("select * from users where username = ?")) {
			
			pstmt.setString(1, username);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int userId = rs.getInt(1);
				String username1 = rs.getString(2);
				String name = rs.getString(3);
				String password = rs.getString(4);
				String email=rs.getString(5);
				ROLE role=User.ROLE.valueOf(rs.getString(6));
				
				
				user = new User(userId, username1, name, password, email, role);
			}
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return user;
	
	}
		

	public User getUserByPassword(String password) {
		  User user = null;
			
			try(PreparedStatement pstmt = conn.prepareStatement("select * from users where password = ?")) {
				
				pstmt.setString(1, password);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int userId = rs.getInt(1);
					String username = rs.getString(2);
					String name = rs.getString(3);
					String password1 = rs.getString(4);
					String email=rs.getString(5);
					ROLE role=User.ROLE.valueOf(rs.getString(6));
					user = new User(userId, username, name, password1, email, role);
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			return user;
			}

	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		 User user = null;
		 
		 try(PreparedStatement pstmt = conn.prepareStatement("select * from users where email = ?")) {
				
				pstmt.setString(1, email);
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int userId = rs.getInt(1);
					String username = rs.getString(2);
					String name = rs.getString(3);
					String password1 = rs.getString(4);
					String email1 =rs.getString(5);
					ROLE role=User.ROLE.valueOf(rs.getString(6));
					user = new User(userId, username, name, password1, email1, role);
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			
		
		return user;
		
	}

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into users values(?,?,?,?,?,?)");
			pstmt.setInt(1, user.getUserId());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getPassword());
			pstmt.setString(5, user.getEmail());
			pstmt.setString(6, user.getRole().name());			
			
			
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
	
	public boolean updateUser(User user) {
		try(PreparedStatement pstmt = conn.prepareStatement("UPDATE users SET userId = ?, username = ?, name = ?, password = ?, role = ? WHERE email = ?")){
			 
			 pstmt.setInt(1, user.getUserId());
			 pstmt.setString(2, user.getUsername());
			 pstmt.setString(3, user.getName());
			 pstmt.setString(4, user.getPassword());
			 pstmt.setString(5, user.getRole().name());
			 pstmt.setString(6,  user.getEmail());

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

	@Override
	public List<User> getUserByRole(ROLE role) {
		// TODO Auto-generated method stub
		List<User> users = new ArrayList<User>();
		 
		 try(PreparedStatement pstmt = conn.prepareStatement("select * from users where role = ?")) {
				
				pstmt.setString(1, role.name());
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					int userId = rs.getInt(1);
					String username = rs.getString(2);
					String name = rs.getString(3);
					String password = rs.getString(4);
					String email1=rs.getNString(5);
					ROLE role1=User.ROLE.valueOf(rs.getString(6));
					User user = new User(userId, username, name, password, email1, role1);
					users.add(user);
				}
				return users;
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		return users;
	}
	
	@Override
	public boolean deleteUser(User user) {
		try(PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM users WHERE email=?")){
			preparedStatement.setString(1, user.getEmail());
			
			int delete = preparedStatement.executeUpdate();
			if(delete > 0) {
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}

}
