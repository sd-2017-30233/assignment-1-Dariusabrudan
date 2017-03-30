package database_access;


import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.ResultSetMetaData;

public class AccountGateway { //Table Data Gateway DP
	public static synchronized boolean find(int id) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "SELECT `id_account`, `identification_number`, `type`, `amount_of_money`, `date_of_creation` FROM `account` where `id_account`=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setString(1, ((Integer)id).toString());
			ResultSet rs = dbStatement.executeQuery();
			
			while(rs.next()) {
				int id_account= rs.getInt("id_account");
				if(id==id_account)
					return true;
			}
			return false;
			
		} catch (SQLException e) {
		
			System.out.println("Error occured reading Accounts from the data source.");
			return false;
		}
	}
	
	public static synchronized void update(int id,int number,String type,int money,String date,int clid) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "UPDATE `account` SET `identification_number`=?, `type`=?, `amount_of_money`=?,`id_client`=? where `id_account`=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setInt(1, number);
			dbStatement.setString(2, type);
			dbStatement.setInt(3, money);
			dbStatement.setInt(4,clid);
			dbStatement.setInt(5,id);
			dbStatement.executeUpdate();
			
		} catch (SQLException e) {
			 
			System.out.println("Error occured reading Accounts from the data source.");
		}
	}
	
	public static synchronized void insert(int id,int number,String type,int money,String date,int clid) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "INSERT INTO `account` (`id_account`, `identification_number`, `type`, `amount_of_money`,`date_of_creation`,`id_client`) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setInt(1, id);
			dbStatement.setInt(2, number);
			dbStatement.setString(3, type);
			dbStatement.setInt(4, money);
			dbStatement.setString(5, date);
			dbStatement.setInt(6, clid);
			dbStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println("Error occured reading Accounts from the data source.");
		}
	}
	
	public static synchronized void delete(int id) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "DELETE FROM `account` where `id_account`=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setInt(1, id);
			dbStatement.executeUpdate();
			
		} catch (SQLException e) {
		
			System.out.println("Error occured reading Accounts from the data source.");
		}
	}
	public static synchronized void transfer(int id_s,int id_d, int amount) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "Select `amount_of_money` FROM `account` where `id_account`=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setInt(1, id_s);
			ResultSet rs = dbStatement.executeQuery();
			String statement1 = "Select `amount_of_money` FROM `account` where `id_account`=?";
			PreparedStatement dbStatement1 = conn.prepareStatement(statement1);
			dbStatement1.setInt(1, id_d);
			ResultSet rs1 = dbStatement1.executeQuery();
			int s1=0,s2=0,ns1,ns2;
			while(rs.next()) {
				s1 = rs.getInt("amount_of_money");
			}
			while(rs1.next()) {
				s2 = rs1.getInt("amount_of_money");
			}
			ns1=s1-amount;
			ns2=s2+amount;
			if(ns1>=0)
			{
				String statement2 = "UPDATE `account` SET `amount_of_money`=? where `id_account`=?";
				PreparedStatement dbStatement2 = conn.prepareStatement(statement2);
				dbStatement2.setInt(1, ns1);
				dbStatement2.setInt(2, id_s);
				dbStatement2.executeUpdate();
				
				String statement3 = "UPDATE `account` SET `amount_of_money`=? where `id_account`=?";
				PreparedStatement dbStatement3 = conn.prepareStatement(statement3);
				dbStatement3.setInt(1, ns2);
				dbStatement3.setInt(2, id_d);
				dbStatement3.executeUpdate();
			}
			else JOptionPane.showMessageDialog(null, "Transfer imposible");
			
		} catch (SQLException e) {
		
			System.out.println("Error occured reading Accounts from the data source.");
		}
	}
	public static synchronized void processBills(int id,int amount) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "Select `amount_of_money` FROM `account` where `id_account`=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setInt(1, id);
			ResultSet rs = dbStatement.executeQuery();
			int s1=0,ns1;
			while(rs.next()) {
				s1 = rs.getInt("amount_of_money");
			}
			ns1=s1-amount;
			if(ns1>=0)
			{
				String statement2 = "UPDATE `account` SET `amount_of_money`=? where `id_account`=?";
				PreparedStatement dbStatement2 = conn.prepareStatement(statement2);
				dbStatement2.setInt(1, ns1);
				dbStatement2.setInt(2, id);
				dbStatement2.executeUpdate();
			}
			else JOptionPane.showMessageDialog(null, "Payment imposible");
		} catch (SQLException e) {
		
			System.out.println("Error occured reading Accounts from the data source.");
		}
	}
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = (ResultSetMetaData) rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

	}
	public static synchronized void view() {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "Select * FROM `account`";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			//dbStatement.setInt(1, client.getClientID());
			//dbStatement.executeUpdate();
			ResultSet rs = dbStatement.executeQuery();

		    // It creates and displays the table
		    JTable table = new JTable(buildTableModel(rs));
		    table.setPreferredScrollableViewportSize(new Dimension(800,400));
		    // Closes the Connection
		    JOptionPane.showMessageDialog(null, new JScrollPane(table));
		
		} catch (SQLException e) {
		
			System.out.println("Error occured reading Clients from the data source.");
		}
	}
}
