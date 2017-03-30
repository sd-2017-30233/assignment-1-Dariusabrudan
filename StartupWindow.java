package presentation;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import business.UserServices;


public class StartupWindow extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;


	public StartupWindow() {
		super("Bank Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 255, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogIn = new JLabel("Log in");
		lblLogIn.setBounds(145, 39, 424, 14);
		contentPane.add(lblLogIn);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(41, 87, 65, 14);
		contentPane.add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(145, 85, 121, 17);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(41, 113, 65, 17);
		contentPane.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(145, 110, 121, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(145, 161, 89, 23);
		btnOk.addActionListener(this);
        btnOk.setActionCommand("Open");
		contentPane.add(btnOk);
		
		setVisible(true);
	}
	    @Override
	    public void actionPerformed(ActionEvent e)
	    {
	        String cmd = e.getActionCommand();
	        String username=textField.getText();
	        String pass=textField_1.getText();
	        if(cmd.equals("Open"))
	        {
	            if(UserServices.exists(username))
		            {if(UserServices.checkPassword(username, pass))
			            {dispose();
			            if(UserServices.isAdministrator(username))
			             	new AdministratorFrame();
			            else {new EmployeeFrame(username);
					            try{
								    PrintWriter writer = new PrintWriter((new FileOutputStream(username+".txt", true)));
								    writer.println("Employee with username "+username+" logged in at : "+new Date());
								    writer.close();
								} catch (IOException ee) {
								   // do something
								}
					        }
			            }
		            else JOptionPane.showMessageDialog(null, "Incorrect password");
		            }
	            else JOptionPane.showMessageDialog(null, "Invalid username");
	        }
	    }
	public String getUserName()
	{
		String username=textField.getText();
		return username;
	}
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartupWindow frame = new StartupWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}