package business;

import database_access.Account;
import database_access.AccountGateway;

public class AccountServices {

		public static synchronized void insert(int id,int number,String type,int money,String date, int clid)
		{
			Account.insert(id,number,type,money,date,clid);
		}
		public static synchronized void update(int id,int number,String type,int money,String date, int clid) {
			Account.update(id,number,type,money,date,clid);
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
		public static synchronized boolean find(int id) {
			return AccountGateway.find(id);
		}
}
