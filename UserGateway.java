package database_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.User;

public class UserGateway {
	public static boolean isAdministrator(String user)
	{
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "SELECT `type` FROM `userrole` where `id_user`=(Select `id_user` from `user` where `username`=?)";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setString(1, user);
			ResultSet rs = dbStatement.executeQuery();
			
			while(rs.next()) {
				String type1 = rs.getString("type");
				if(type1.equals("admin"))
					return true;
				else return false;
			}
			return false;
		} catch (SQLException e) {
		
			System.out.println("Error occured reading Users from the data source.");
			return false;
		}
	}
	public static boolean checkPassword(String username,String pass)
	{	
		try {
		Connection conn=null;
		conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
		String statement = "SELECT `password` FROM `user` where `username`=?";
		PreparedStatement dbStatement = conn.prepareStatement(statement);
		dbStatement.setString(1, username);
		ResultSet rs = dbStatement.executeQuery();
		
		while(rs.next()) {
			String pass1 = rs.getString("password");
			if(pass1.equals(pass))
				return true;
			else return false;
		}
		return false;
	} catch (SQLException e) {
	
		System.out.println("Error occured reading Users from the data source.");
		return false;
		}
	}
	public static boolean exists(String user)
	{
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "SELECT `id_user` FROM `user` where `username`=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setString(1, user);
			ResultSet rs = dbStatement.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id_user");
				if(id!=0)
					return true;
				else return false;
			}
			return false;
		} catch (SQLException e) {
		
			System.out.println("Error occured reading Users from the data source.");
			return false;
		}
	}
	public static synchronized void update(User user) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "UPDATE `user` SET `username`=?, `password`=? where `id_user`=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setString(1, user.getUsername());
			dbStatement.setString(2, user.getPassword());
			dbStatement.setInt(3, user.getUserId());
			dbStatement.executeUpdate();
			
		} catch (SQLException e) {
			 
			System.out.println("Error occured reading Users from the data source.");
		}
	}
	
	public static synchronized void insert(User user) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "INSERT INTO `user` (`id_user`, `username`, `password`) VALUES (?, ?, ?)";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setInt(1, user.getUserId());
			dbStatement.setString(2, user.getUsername());
			dbStatement.setString(3, user.getPassword());
			dbStatement.executeUpdate();
			String statement1 = "INSERT INTO `userrole` (`id_role`, `type`, `id_user`) VALUES (?, ?, ?)";
			PreparedStatement dbStatement1 = conn.prepareStatement(statement1);
			dbStatement1.setInt(1, user.getUserId()+2);
			dbStatement1.setString(2, "employee");
			dbStatement1.setInt(3, user.getUserId());
			dbStatement1.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println("Error occured reading Users from the data source.");
		}
	}
	
	public static synchronized void delete(int id) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");
			String statement1="DELETE FROM userrole WHERE userrole.id_user='"+id+"'";
			String statement = "DELETE FROM user where id_user='"+id+"'";
			PreparedStatement dbStatement1 = conn.prepareStatement(statement1);
			dbStatement1.executeUpdate();
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			//dbStatement.setInt(1, user.getUserId());
			dbStatement.executeUpdate();
			
		} catch (SQLException e) {
		
			System.out.println("Error occured reading Users from the data source.");
		}
	}
}
