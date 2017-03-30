package database_access;

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
	public static synchronized void insert(int id,String username, String password)
	{
		UserGateway.insert(id,username,password);
	}
	public static synchronized void update(int id,String username, String password) {
		 UserGateway.update(id,username,password);
	}
	
}
