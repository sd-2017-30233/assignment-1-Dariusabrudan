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

import business.*;

public class ClientGateway { 
	
	public static synchronized Client find(int id) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "SELECT `id_client`, `name`, `identity_card_number`, `personal_numerical_code`, `address` FROM `clientt` where `id_client`=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setString(1, ((Integer)id).toString());
			ResultSet rs = dbStatement.executeQuery();
			
			while(rs.next()) {
				int id_client = rs.getInt("id_client");
				String name = rs.getString("name");
				int icn = rs.getInt("identity_card_number");
				String cnp = rs.getString("personal_numerical_code");
				String address=rs.getString("address");
				
				Client client = new Client(id_client);
				client.setName(name);
				client.setIdentityCardNumber(icn);
				client.setCNP(cnp);
				client.setAddress(address);
				
				return client;
			}
			return null;
			
		} catch (SQLException e) {
		
			System.out.println("Error occured reading Clients from the data source.");
			return null;
		}
	}
	public static synchronized void update(Client client) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "UPDATE `clientt` SET `name`=?, `identity_card_number`=?, `address`=? where `id_client`=?";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setString(1, client.getName());
			dbStatement.setInt(2, client.getIdentityCardNumber());
			dbStatement.setString(3, client.getAddress());
			dbStatement.setInt(4, client.getClientID());
			dbStatement.executeUpdate();
			
		} catch (SQLException e) {
			 
			System.out.println("Error occured reading Clients from the data source.");
		}
	}
	
	public static synchronized void insert(Client client) {
		try {
			Connection conn=null;
			conn=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/a1","root","");	
			String statement = "INSERT INTO `clientt` (`id_client`, `name`, `identity_card_number`, `personal_numerical_code`,`address`) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement dbStatement = conn.prepareStatement(statement);
			dbStatement.setInt(1, client.getClientID());
			dbStatement.setString(2, client.getName());
			dbStatement.setInt(3, client.getIdentityCardNumber());
			dbStatement.setString(4, client.getCNP());
			dbStatement.setString(5, client.getAddress());
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
	public static void main(String[] args)
	{
	Client c=ClientGateway.find(1);
	System.out.println(c.getCNP());
	//Client c1=new Client(6,"plaaas",45,"as","sa");
	//ClientGateway.insert(c1);
	ClientGateway.delete(99);
	//ClientGateway.update(c1);
	//ClientGateway.view();
	
	}
	
}
