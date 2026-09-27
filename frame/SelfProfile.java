//Tofayel Hossain
//23-51928-2

package frame;
import entities.*;
import interfaces.*;
import repository.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.border.Border;

public class SelfProfile extends JFrame implements ActionListener{
	private JPanel profilePanel;
	private JLabel userFullNameL,usernameL,addressL,numberL,passwordL,emailL,chagePass;
	private JTextField userFullNameF,usernameF,addressF,numberF,emailF,chagePassF;
	private JPasswordField passwordF;
	private JButton saveDetailsB,backB;
	private User us;
	
	public SelfProfile(User us){
		this.us=us;
		this.setSize(400,610);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Profile - PharmaCare");
		
		profilePanel = new JPanel();
		profilePanel.setBounds(0,0,400,610);
		profilePanel.setLayout(null);
		this.add(profilePanel);
		
		userFullNameL = new JLabel("User Full Name");
		userFullNameL.setBounds(85,40,130,20);
		profilePanel.add(userFullNameL);
		
		userFullNameF = new JTextField();
		userFullNameF.setBounds(85,65,220,30);
		userFullNameF.setText(us.getName());
		userFullNameF.setEditable(false);
		profilePanel.add(userFullNameF);
		
		usernameL = new JLabel("UserName");
		usernameL.setBounds(85,105,130,20);
		profilePanel.add(usernameL);
		
		usernameF = new JTextField();
		usernameF.setBounds(85,130,220,30);
		usernameF.setText(us.getUsername());
		usernameF.setEditable(false);
		profilePanel.add(usernameF);
		
		numberL = new JLabel("User Number");
		numberL.setBounds(85,170,130,20);
		profilePanel.add(numberL);
		
		numberF = new JTextField();
		numberF.setBounds(85,195,220,30);
		numberF.setText(us.getNumber());
		numberF.setEditable(false);
		profilePanel.add(numberF);
		
		addressL = new JLabel("Address");
		addressL.setBounds(85,235,130,20);
		profilePanel.add(addressL);
		
		addressF = new JTextField();
		addressF.setBounds(85,260,220,30);
		addressF.setText(us.getAddress());
		addressF.setEditable(false);
		profilePanel.add(addressF);
		
		
		emailL = new JLabel("User Email");
		emailL.setBounds(85,300,130,20);
		profilePanel.add(emailL);
		
		emailF = new JTextField();
		emailF.setBounds(85,325,220,30);
		emailF.setText(us.getEmail());
		emailF.setEditable(false);
		profilePanel.add(emailF);
		
		passwordL = new JLabel("Password");
		passwordL.setBounds(85,365,130,20);
		profilePanel.add(passwordL);
		
		passwordF = new JPasswordField();
		passwordF.setBounds(85,390,220,30);
		passwordF.setEchoChar((char)0);
		passwordF.setText(us.getPassword());
		passwordF.setEditable(false);
		profilePanel.add(passwordF);
		
		backB = new JButton("Back");
		backB.setBounds(85,485,220,40);
		profilePanel.add(backB);
		
		this.setVisible(true);
		backB.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae){
		if(ae.getSource()==backB){
			try{	
				EmployeeRepo emR = new EmployeeRepo();
				Employee employee = emR.searchById(us.getId());
				CustomersRepo cuR = new CustomersRepo();
				Customers cusstomer = cuR.searchById(us.getId());
			
				if(employee!=null){
					new EmployeePage(us);
					dispose();
				}else if(cusstomer!=null){
					new CustomerPage(us);
					dispose();
				}
				else{
					new OwnerPage(us);
					dispose();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}