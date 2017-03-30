package business;

import database_access.Client;

public class ClientServices {
	public static synchronized void insert(int id,String name, int cardnumber,String cnp, String address)
	{
		Client.insert(id,name,cardnumber, cnp, address);
	}
	public static synchronized void update(int id,String name, int cardnumber,String cnp, String address) {
		Client.update(id,name,cardnumber,cnp, address);
	}
	public static synchronized void view()
	{
		Client.view();
	}
	public static synchronized boolean find(int id) {
		return Client.find(id);
	}
}
