package business;

import database_access.AccountGateway;

public class Account {

	private int accountID;
	private int identificationNumber;
	private String type;
	private int amountOfMoney;
	private String dateOfCreation;
	private int clientID;
	
	public Account(int id)
	{
		this.accountID=id;
	}
	public Account(int id,int in,String t,int am,String d,int cid)
	{
		this.accountID=id;
		this.identificationNumber=in;
		this.type=t;
		this.amountOfMoney=am;
		this.dateOfCreation=d;
		this.clientID=cid;
	}
	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public int getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(int identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAmountOfMoney() {
		return amountOfMoney;
	}

	public void setAmountOfMoney(int amountOfMoney) {
		this.amountOfMoney = amountOfMoney;
	}

	public String getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}
	public synchronized void insert()
	{
		AccountGateway.insert(this);
	}
	public synchronized void update() {
		 AccountGateway.update(this);
	}
	public static synchronized void delete(int id) {
		AccountGateway.delete(id);
	}
	public static synchronized void view()
	{
		AccountGateway.view();
	}
	public static synchronized void transfer(int id_s,int id_d, int amount)
	{
		AccountGateway.transfer(id_s,id_d,amount);
	}
	public static synchronized void processBills(int id,int amount)
	{
		 AccountGateway.processBills(id,amount);
	}
	public static synchronized Account find(int id) {
		return AccountGateway.find(id);
	}
}
