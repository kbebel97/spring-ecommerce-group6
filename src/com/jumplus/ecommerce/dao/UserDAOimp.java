package com.jumplus.ecommerce.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jumplus.ecommerce.connection.ConnectionManager;
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
						String username = rs.getString(1);
						String name = rs.getString(2);
						String password = rs.getString(3);
						String email=rs.getNString(4);
						ROLE role=User.ROLE.valueOf(rs.getString("role"));
						User user = new User(username, name, password, email, role);
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
				String username1 = rs.getString(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String email=rs.getString(4);
				ROLE role=User.ROLE.valueOf(rs.getString("role"));
				
				
				user = new User(username1, name, password, email, role);
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
					String username = rs.getString(1);
					String name = rs.getString(2);
					String password1 = rs.getString(3);
					String email=rs.getString(4);
					ROLE role=User.ROLE.valueOf(rs.getString("role"));
					user = new User(username, name, password1, email, role);
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
					String username = rs.getString(1);
					String name = rs.getString(2);
					String password = rs.getString(3);
					String email1=rs.getNString(4);
					ROLE role=User.ROLE.valueOf(rs.getString("role"));
					
					
					
					user = new User(username, name, password, email1, role);
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			
		
		return user;
		
	}

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = conn.prepareStatement("insert into users values(?,?,?,?,?)");
			
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getRole().name());			
			
			
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
		try(PreparedStatement pstmt = conn.prepareStatement("UPDATE users SET username = ?, name = ?, password = ?, role = ? WHERE email = ?")){
			
			 pstmt.setString(1, user.getUsername());
			 pstmt.setString(2, user.getName());
			 pstmt.setString(3, user.getPassword());
			 pstmt.setString(4, user.getRole().name());
			 pstmt.setString(5,  user.getEmail());

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
	public User getUserByRole(ROLE role) {
		// TODO Auto-generated method stub
		User user = null;
		 
		 try(PreparedStatement pstmt = conn.prepareStatement("select * from users where role = ?")) {
				
				pstmt.setString(1, user.getRole().name());
				
				ResultSet rs = pstmt.executeQuery();
				
				if(rs.next()) {
					String username = rs.getString(1);
					String name = rs.getString(2);
					String password = rs.getString(3);
					String email1=rs.getNString(4);
					ROLE role1=User.ROLE.valueOf(rs.getString("role"));
				
					user = new User(username, name, password, email1, role1);
				}
				
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
			
		
		return user;
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
