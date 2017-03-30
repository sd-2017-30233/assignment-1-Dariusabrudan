package business;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import database_access.User;
import database_access.UserGateway;

public class UserServices {
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
	public static synchronized void insert(int id,String username, String password)
	{
		User.insert(id,username,password);
	}
	public static synchronized void update(int id,String username, String password) {
		 User.update(id,username,password);
	}
}
