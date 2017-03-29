package business;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import database_access.UserGateway;

public class User { 

	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	private String username;
	private String password;
	private boolean isAdmin;
	
	public User(int id, String us,String pass)
	{
		this.userId=id;
		this.username=us;
		this.password=pass;
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	public synchronized void insert()
	{
		UserGateway.insert(this);
	}
	public synchronized void update() {
		 UserGateway.update(this);
	}
	public static synchronized void delete(int id) {
		UserGateway.delete(id);
	}
	public static boolean exists(String user)
	{
		return UserGateway.exists(user);
	}
	public static boolean checkPassword(String username,String pass)
	{
		return UserGateway.checkPassword(username, pass);
	}
	public static boolean isAdministrator(String user)
	{
		return UserGateway.isAdministrator(user);
	}
	public static String report(String u) throws FileNotFoundException
	{
		@SuppressWarnings("resource")
		String text = new Scanner( new File(u+".txt") ).useDelimiter("\\A").next();
        return text;
	}
}
