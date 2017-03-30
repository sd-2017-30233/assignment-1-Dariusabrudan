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

public class Client { //Table Module DP
	public static synchronized boolean find(int id) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "SELECT `id_client`, `name`, `identity_card_number`, `personal_numerical_code`, `address` FROM `clientt` where `id_client`=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setString(1, ((Integer)id).toString());
			ResultSet rs = dbStatement.executeQuery();
			
			while(rs.next()) {
				int id_client = rs.getInt("id_client");
				if(id==id_client)
					return true;
			}
			return false;
			
		} catch (SQLException e) {
		
			System.out.println("Error occured reading Clients from the data source.");
			return false;
		}
	}
	public static synchronized void update(int id,String name, int cardnumber,String cnp, String address) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "UPDATE `clientt` SET `name`=?, `identity_card_number`=?,`personal_numerical_code`=?, `address`=? where `id_client`=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setString(1, name);
			dbStatement.setInt(2, cardnumber);
			dbStatement.setString(3, cnp);
			dbStatement.setString(4, address);
			dbStatement.setInt(5, id);
			dbStatement.executeUpdate();
			
		} catch (SQLException e) {
			 
			System.out.println("Error occured reading Clients from the data source.");
		}
	}
	
	public static synchronized void insert(int id,String name, int cardnumber,String cnp, String address) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "INSERT INTO `clientt` (`id_client`, `name`, `identity_card_number`, `personal_numerical_code`,`address`) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setInt(1, id);
			dbStatement.setString(2, name);
			dbStatement.setInt(3, cardnumber);
			dbStatement.setString(4, cnp);
			dbStatement.setString(5, address);
			dbStatement.executeUpdate();
			
		} catch (SQLException e) {
			
			System.out.println("Error occured reading Clients from the data source.");
		}
	}
	
	public static synchronized void delete(int id) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "DELETE FROM `clientt` where `id_client`=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setInt(1, id);
			dbStatement.executeUpdate();
			
		} catch (SQLException e) {
		
			System.out.println("Error occured reading Clients from the data source.");
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
			String statement = "Select * FROM `clientt`";
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
