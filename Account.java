package database_access;

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
		public static synchronized void insert(int id,int number,String type,int money,String date,int clid)
		{
			AccountGateway.insert(id,number,type,money,date,clid);
		}
		public static synchronized void update(int id,int number,String type,int money,String date,int clid)
		{
			 AccountGateway.update(id,number,type,money,date,clid);
		}
	}
