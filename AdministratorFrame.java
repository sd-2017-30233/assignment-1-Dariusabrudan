package presentation;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import business.UserServices;

public class AdministratorFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public AdministratorFrame() {
		super("Administrator user");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 370);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnInsertEmployee = new JButton("Insert employee");
		btnInsertEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(textField.getText().equals("")|| !Pattern.matches("[0-9]+", textField.getText()))
					JOptionPane.showMessageDialog(null, "Invalid user id");
				else if(textField_1.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Invalid username");
				else if(textField_2.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Invalid password");
				else {
						int id=Integer.parseInt(textField.getText());
				        String username=textField_1.getText();
				        String pass=textField_2.getText();
				        //User u=new User(id,username,pass);
				        if(cmd.equals("Open"))
				        {
				        	if(!UserServices.exists(username))
				            {UserServices.insert(id,username,pass);
				            JOptionPane.showMessageDialog(null, "Employee inserted");
				            }
				    		else JOptionPane.showMessageDialog(null, "Employee exists");
				        }
				}
			}
		});
		btnInsertEmployee.setBounds(47, 54, 150, 32);
		btnInsertEmployee.setActionCommand("Open");
		contentPane.add(btnInsertEmployee);
		
		JButton btnNewButton = new JButton("Update employee");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(textField.getText().equals("")|| !Pattern.matches("[0-9]+", textField.getText()))
					JOptionPane.showMessageDialog(null, "Invalid user id");
				else if(textField_1.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Invalid username");
				else if(textField_2.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Invalid password");
				else {
						int id=Integer.parseInt(textField.getText());
				        String username=textField_1.getText();
				        String pass=textField_2.getText();
				        if(cmd.equals("Open"))
				        {
				        	if(UserServices.exists(username))
				    		{ UserServices.update(id,username,pass);
				             JOptionPane.showMessageDialog(null, "Employee updated");	
				    		}
				    		else JOptionPane.showMessageDialog(null, "Employee don't exist");	     
				        }
				}
			}
		});
		btnNewButton.setBounds(47, 97, 150, 32);
		btnNewButton.setActionCommand("Open");
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete employee");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				if(textField.getText().equals("")|| !Pattern.matches("[0-9]+", textField.getText()))
					JOptionPane.showMessageDialog(null, "Invalid user id");
				else {
						int id=Integer.parseInt(textField.getText());
				        if(cmd.equals("Open"))
				        {
				        	try{
				   	         {UserServices.delete(id);
				               JOptionPane.showMessageDialog(null, "Employee deleted");
				               }
				          }
				          catch(Exception ee){
				          	 JOptionPane.showMessageDialog(null, "Employee don't exist");
				          }
				        }
		        }
			}
		});
		btnNewButton_1.setBounds(47, 140, 150, 32);
		btnNewButton_1.setActionCommand("Open");
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Generate report");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_1.getText().equals(""))
					JOptionPane.showMessageDialog(null, "Invalid username");
				else {String username=textField_1.getText();
					  if(UserServices.exists(username))
							try {
								try {
										JOptionPane.showMessageDialog(null,UserServices.report(username));
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							} catch (HeadlessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					  else JOptionPane.showMessageDialog(null, "Username don't exist");
				}
			}
		});
		
		btnNewButton_2.setBounds(47, 183, 150, 32);
		btnNewButton_2.setActionCommand("Open");
		contentPane.add(btnNewButton_2);
		
		JButton btnLogout = new JButton("Log out");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand();
				 if(cmd.equals("Open"))
			        {
						dispose();
			            new StartupWindow();
			        }
			}
		});
		btnLogout.setBounds(45, 226, 150, 32);
		btnLogout.setActionCommand("Open");
		contentPane.add(btnLogout);
		
		JLabel lblIdEmployee = new JLabel("Id employee");
		lblIdEmployee.setBounds(250, 54, 101, 23);
		contentPane.add(lblIdEmployee);
		
		textField = new JTextField();
		textField.setBounds(374, 54, 116, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(250, 106, 86, 14);
		contentPane.add(lblUsername);
		
		textField_1 = new JTextField();
		textField_1.setBounds(374, 103, 116, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(250, 149, 86, 14);
		contentPane.add(lblPassword);
		
		textField_2 = new JTextField();
		textField_2.setBounds(374, 146, 116, 23);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
        setVisible(true);
	}
}