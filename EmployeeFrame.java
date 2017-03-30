package presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import business.AccountServices;
import business.ClientServices;

public class EmployeeFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private String username;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
		public EmployeeFrame(String us)
	    {
	        super("Employee user");
	        this.username=us;
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 622, 555);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(204, 204, 102));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			  
			JButton btnAddClient = new JButton("Add client");
			btnAddClient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					if(textField.getText().equals("")|| !Pattern.matches("[0-9]+", textField.getText()))
						JOptionPane.showMessageDialog(null, "Invalid client id");
					else if(textField_1.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid name");
					else if(textField_2.getText().equals("")|| !Pattern.matches("[0-9]+", textField_2.getText()))
						JOptionPane.showMessageDialog(null, "Invalid identification card number");
					else if(textField_3.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid CNP");
					else if(textField_4.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid address");
					else {
							int id=Integer.parseInt(textField.getText());
					        String name=textField_1.getText();
					        int cardnb=Integer.parseInt(textField_2.getText());
					        String CNP=textField_3.getText();
					        String address=textField_4.getText();
					        if(cmd.equals("Open"))
					        {
					        	if(ClientServices.find(id)==false)
								{ClientServices.insert(id,name,cardnb,CNP,address);
								 JOptionPane.showMessageDialog(null, "Client added");    
						         }
					        else JOptionPane.showMessageDialog(null, "Client exists");  
					        	try{
								    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
								    writer.println(username+" inserted client "+name+" at : "+new Date());
								    writer.close();
								} catch (IOException ee) {
								   // do something
								}
					       }
					}
				}
			});
			btnAddClient.setBounds(45, 26, 130, 23);
			btnAddClient.setActionCommand("Open");
			contentPane.add(btnAddClient);
			
			JButton btnUpdateClient = new JButton("Update client");
			btnUpdateClient.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					if(textField.getText().equals("")|| !Pattern.matches("[0-9]+", textField.getText()))
						JOptionPane.showMessageDialog(null, "Invalid client id");
					else if(textField_1.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid name");
					else if(textField_2.getText().equals("")|| !Pattern.matches("[0-9]+", textField_2.getText()))
						JOptionPane.showMessageDialog(null, "Invalid identification card number");
					else if(textField_3.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid CNP");
					else if(textField_4.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid address");
					else {
							int id=Integer.parseInt(textField.getText());
					        String name=textField_1.getText();
					        int cardnb=Integer.parseInt(textField_2.getText());
					        String CNP=textField_3.getText();
					        String address=textField_4.getText();
					        //Client c=new Client(id,name,cardnb,CNP,address);
					        if(cmd.equals("Open"))
					        {
					        	if(ClientServices.find(id)==true)
					        	{
						         ClientServices.update(id,name,cardnb,CNP,address);
					             JOptionPane.showMessageDialog(null, "Client updated");		
					        	}
					        	  else JOptionPane.showMessageDialog(null, "Client don't exist"); 
					        	try{
								    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
								    writer.println(username+" updated client "+name+" at : "+new Date());
								    writer.close();
								} catch (IOException ee) {
								   // do something
								}
					        }
					}
				}
			});
			btnUpdateClient.setBounds(45, 60, 130, 23);
			btnUpdateClient.setActionCommand("Open");
			contentPane.add(btnUpdateClient);
			
			JButton btnNewButton = new JButton("View clients");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
			        if(cmd.equals("Open"))
			        {
			         ClientServices.view();			     
			        }
				}
			});
			btnNewButton.setBounds(45, 94, 130, 23);
			btnNewButton.setActionCommand("Open");
			contentPane.add(btnNewButton);
			
			JButton btnAddAccount = new JButton("Add account");
			btnAddAccount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					if(textField_5.getText().equals("")|| !Pattern.matches("[0-9]+", textField_5.getText()))
						JOptionPane.showMessageDialog(null, "Invalid account id");
					else if(textField_6.getText().equals("")|| !Pattern.matches("[0-9]+", textField_6.getText()))
						JOptionPane.showMessageDialog(null, "Invalid identification number");
					else if(textField_7.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid type");
					else if(textField_8.getText().equals("")|| !Pattern.matches("[0-9]+", textField_8.getText()))
						JOptionPane.showMessageDialog(null, "Invalid amount of money");
					else if(textField_9.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid date");
					else if(textField.getText().equals("")|| !Pattern.matches("[0-9]+", textField.getText()))
						JOptionPane.showMessageDialog(null, "Invalid client id");
					else {
							int id=Integer.parseInt(textField_5.getText());
					        int number=Integer.parseInt(textField_6.getText());
					        String type=textField_7.getText();
					        int money=Integer.parseInt(textField_8.getText());
					        String date=textField_9.getText();
					        int clid=Integer.parseInt(textField.getText());
					        if(cmd.equals("Open"))
					        {
					        	if(AccountServices.find(id)==false)
					            {
					            AccountServices.insert(id,number,type,money,date,clid);
					            JOptionPane.showMessageDialog(null, "Account added");	
					            }
					            else JOptionPane.showMessageDialog(null, "Account exists");
					        	try{
								    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
								    writer.println(username+" inserted account "+number+" at : "+new Date());
								    writer.close();
								} catch (IOException ee) {
								   // do something
								}
					        }
					}
				}
			});
			
			btnAddAccount.setBounds(45, 128, 130, 23);
			btnAddAccount.setActionCommand("Open");
			contentPane.add(btnAddAccount);
			
			JButton btnUpdateAccount = new JButton("Update account");
			btnUpdateAccount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					if(textField_5.getText().equals("")|| !Pattern.matches("[0-9]+", textField_5.getText()))
						JOptionPane.showMessageDialog(null, "Invalid account id");
					else if(textField_6.getText().equals("")|| !Pattern.matches("[0-9]+", textField_6.getText()))
						JOptionPane.showMessageDialog(null, "Invalid identification number");
					else if(textField_7.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid type");
					else if(textField_8.getText().equals("")|| !Pattern.matches("[0-9]+", textField_8.getText()))
						JOptionPane.showMessageDialog(null, "Invalid amount of money");
					else if(textField_9.getText().equals(""))
						JOptionPane.showMessageDialog(null, "Invalid date");
					else if(textField.getText().equals("")|| !Pattern.matches("[0-9]+", textField.getText()))
						JOptionPane.showMessageDialog(null, "Invalid client id");
					else {
							int id=Integer.parseInt(textField_5.getText());
					        int number=Integer.parseInt(textField_6.getText());
					        String type=textField_7.getText();
					        int money=Integer.parseInt(textField_8.getText());
					        String date=textField_9.getText();
					        int clid=Integer.parseInt(textField.getText());
					      //  Account acc=new Account(id,number,type,money,date,clid);
					        if(cmd.equals("Open"))
					        {
					        	if(AccountServices.find(id)==true)
					           {
					    	         AccountServices.update(id,number,type,money,date,clid);
					                JOptionPane.showMessageDialog(null, "Account updated");
					            }
					       	 else JOptionPane.showMessageDialog(null, "Account don't exist");
					        	try{
								    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
								    writer.println(username+" updated account "+number+" at : "+new Date());
								    writer.close();
								} catch (IOException ee) {
								   // do something
								}
					        }
					}
				}
			});
			btnUpdateAccount.setBounds(45, 162, 130, 23);
			btnUpdateAccount.setActionCommand("Open");
			contentPane.add(btnUpdateAccount);
			
			JButton btnDeleteAccount = new JButton("Delete account");
			btnDeleteAccount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					if(textField_5.getText().equals("")|| !Pattern.matches("[0-9]+", textField_5.getText()))
							JOptionPane.showMessageDialog(null, "Invalid account id");
					else {
						int id=Integer.parseInt(textField_5.getText());			       
				        if(cmd.equals("Open"))
				        {
				        	if(AccountServices.find(id)==true)
				            {
				        		AccountServices.delete(id);
				                JOptionPane.showMessageDialog(null, "Account deleted");
				            }
				       	 else JOptionPane.showMessageDialog(null, "Account don't exist");
				        	try{
							    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
							    writer.println(username+" deleted account "+id+" at : "+new Date());
							    writer.close();
							} catch (IOException ee) {
							   // do something
							}				        	
				        }
					}
				}
			});
			btnDeleteAccount.setBounds(45, 196, 130, 23);
			btnDeleteAccount.setActionCommand("Open");
			contentPane.add(btnDeleteAccount);
			
			JButton btnViewAccount = new JButton("View accounts");
			btnViewAccount.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
			        if(cmd.equals("Open"))
			        {
			        	AccountServices.view();	     
			        }
				}
			});
			btnViewAccount.setBounds(45, 230, 130, 23);
			btnViewAccount.setActionCommand("Open");
			contentPane.add(btnViewAccount);
			
			JButton btnTransferMoney = new JButton("Transfer money");
			btnTransferMoney.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					if(textField_10.getText().equals("")|| !Pattern.matches("[0-9]+", textField_10.getText()))
						JOptionPane.showMessageDialog(null, "Invalid source account id");
					else if(textField_11.getText().equals("")|| !Pattern.matches("[0-9]+", textField_11.getText()))
						JOptionPane.showMessageDialog(null, "Invalid destination account id");
					else if(textField_8.getText().equals("")|| !Pattern.matches("[0-9]+", textField_8.getText()))
						JOptionPane.showMessageDialog(null, "Invalid amount of money");
					else {
							int id_s=Integer.parseInt(textField_10.getText());
							int id_d=Integer.parseInt(textField_11.getText());
							int s=Integer.parseInt(textField_8.getText());
					        if(cmd.equals("Open"))
					        {
					        	if(AccountServices.find(id_s)==true && AccountServices.find(id_d)==true)
					            {
					        		AccountServices.transfer(id_s,id_d,s);
					                JOptionPane.showMessageDialog(null, "Transfer complete");
					            }
					       	 else JOptionPane.showMessageDialog(null, "Account don't exist");
					        	try{
								    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
								    writer.println(username+" made a trasnfer from "+id_s+" to "+id_d+" of "+s+" at : "+new Date());
								    writer.close();
								} catch (IOException ee) {
								   // do something
								}					        	
					        }
					}
				}
			});
			btnTransferMoney.setBounds(45, 267, 130, 23);
			btnTransferMoney.setActionCommand("Open");
			contentPane.add(btnTransferMoney);
			
			JButton btnProcessBills = new JButton("Process bills");
			btnProcessBills.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					int id=0,s=0;
					if(textField_5.getText().equals("")|| !Pattern.matches("[0-9]+", textField_5.getText()))
						JOptionPane.showMessageDialog(null, "Invalid account id");
					else {id=Integer.parseInt(textField_5.getText());
				    	  if(textField_12.getText().equals("") || !Pattern.matches("[0-9]+", textField_12.getText()))
				    		  JOptionPane.showMessageDialog(null, "Invalid amount of money");
				    	  else {s=Integer.parseInt(textField_12.getText());
					        if(cmd.equals("Open"))
					        {
					        	if(AccountServices.find(id)==true)
					            {
					        		AccountServices.processBills(id,s);
					                JOptionPane.showMessageDialog(null, "Payment complete");
					            }
					       	 else JOptionPane.showMessageDialog(null, "Account don't exist");
					        	try{
								    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
								    writer.println(username+" processed bills of "+s+" for account "+id+" at : "+new Date());
								    writer.close();
								} catch (IOException ee) {
								   // do something
								}					        	
					        }
				    	  }
					}
				}
			});
			btnProcessBills.setBounds(45, 304, 130, 23);
			btnProcessBills.setActionCommand("Open");
			contentPane.add(btnProcessBills);
			
			JButton btnLogout = new JButton("Log out");
			btnLogout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String cmd = e.getActionCommand();
					 if(cmd.equals("Open"))
				        {
							dispose();
							try{
							    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
							    writer.println(username+" logged off at : "+new Date());
							    writer.close();
							} catch (IOException ee) {
							   // do something
							}							
				            new StartupWindow();
				        }
				}
			});
			btnLogout.setBounds(45, 340, 130, 23);
			btnLogout.setActionCommand("Open");
			contentPane.add(btnLogout);
			
			JLabel lblNewLabel = new JLabel("Id client");
			lblNewLabel.setBounds(240, 30, 46, 14);
			contentPane.add(lblNewLabel);
			
			textField = new JTextField();
			textField.setBounds(357, 27, 123, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			JLabel lblName = new JLabel("Name");
			lblName.setBounds(240, 64, 46, 14);
			contentPane.add(lblName);
			
			textField_1 = new JTextField();
			textField_1.setBounds(357, 61, 123, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);
			
			JLabel lblCardNumber = new JLabel("Card number");
			lblCardNumber.setBounds(240, 98, 78, 14);
			contentPane.add(lblCardNumber);
			
			textField_2 = new JTextField();
			textField_2.setBounds(357, 95, 123, 20);
			contentPane.add(textField_2);
			textField_2.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("CNP");
			lblNewLabel_1.setBounds(240, 132, 46, 14);
			contentPane.add(lblNewLabel_1);
			
			textField_3 = new JTextField();
			textField_3.setBounds(357, 129, 123, 20);
			contentPane.add(textField_3);
			textField_3.setColumns(10);
			
			JLabel lblAddress = new JLabel("Address");
			lblAddress.setBounds(240, 166, 66, 14);
			contentPane.add(lblAddress);
			
			textField_4 = new JTextField();
			textField_4.setBounds(357, 163, 123, 20);
			contentPane.add(textField_4);
			textField_4.setColumns(10);
			
			JLabel lblIdAccount = new JLabel("Id account");
			lblIdAccount.setBounds(240, 200, 66, 14);
			contentPane.add(lblIdAccount);
			
			textField_5 = new JTextField();
			textField_5.setBounds(357, 197, 123, 20);
			contentPane.add(textField_5);
			textField_5.setColumns(10);
			
			JLabel lblNewLabel_2 = new JLabel("Number");
			lblNewLabel_2.setBounds(240, 236, 46, 14);
			contentPane.add(lblNewLabel_2);
			
			textField_6 = new JTextField();
			textField_6.setBounds(357, 233, 123, 20);
			contentPane.add(textField_6);
			textField_6.setColumns(10);
			
			JLabel lblType = new JLabel("Type");
			lblType.setBounds(240, 273, 46, 14);
			contentPane.add(lblType);
			
			textField_7 = new JTextField();
			textField_7.setBounds(357, 270, 123, 20);
			contentPane.add(textField_7);
			textField_7.setColumns(10);
			
			JLabel lblMoney = new JLabel("Money");
			lblMoney.setBounds(240, 312, 46, 14);
			contentPane.add(lblMoney);
			
			textField_8 = new JTextField();
			textField_8.setBounds(357, 309, 123, 20);
			contentPane.add(textField_8);
			textField_8.setColumns(10);
			
			JLabel lblDate = new JLabel("Date");
			lblDate.setBounds(240, 351, 46, 14);
			contentPane.add(lblDate);
			
			JLabel lblsa = new JLabel("Source account");
			lblsa.setBounds(240, 390, 96, 14);
			contentPane.add(lblsa);
			
			JLabel lblda = new JLabel("Destination account");
			lblda.setBounds(240, 429, 116, 14);
			contentPane.add(lblda);
			
			JLabel lblba = new JLabel("Bills amount");
			lblba.setBounds(240, 468, 116, 14);
			contentPane.add(lblba);
			
			
			textField_9 = new JTextField();
			textField_9.setBounds(357, 348, 123, 20);
			contentPane.add(textField_9);
			textField_9.setColumns(10);
			
			textField_10 = new JTextField();
			textField_10.setBounds(357, 387, 123, 20);
			contentPane.add(textField_10);
			textField_10.setColumns(10);
			
			textField_11 = new JTextField();
			textField_11.setBounds(357, 426, 123, 20);
			contentPane.add(textField_11);
			textField_11.setColumns(10);
			
			textField_12 = new JTextField();
			textField_12.setBounds(357, 465, 123, 20);
			contentPane.add(textField_12);
			textField_12.setColumns(10);

	        setVisible(true);
	    }
}

