package business;

import database_access.ClientGateway;

public class Client {
	
	private int clientID;
	private String name;
	private int identityCardNumber;
	private String CNP;
	private String address;
	
	public Client(int id) {
		this.clientID=id;
	}
	public Client(int id,String n, int cn,String cnp, String adr) {
		this.clientID=id;
		this.name=n;
		this.identityCardNumber=cn;
		this.CNP=cnp;
		this.address=adr;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdentityCardNumber() {
		return identityCardNumber;
	}

	public void setIdentityCardNumber(int identityCardNumber) {
		this.identityCardNumber = identityCardNumber;
	}

	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) {
		CNP = cNP;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public synchronized void insert()
	{
		ClientGateway.insert(this);
	}
	public synchronized void update() {
		ClientGateway.update(this);
	}
	public static synchronized void view()
	{
		ClientGateway.view();
	}
	public static synchronized Client find(int id) {
		return ClientGateway.find(id);
	}
}
	
