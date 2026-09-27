//Tofayel Hossain
//23-51928-2

package frame;
import entities.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import javax.swing.border.Border;

public class OwnerPage extends JFrame implements ActionListener{
	private JButton viewUserB,viewEmployeeB,profileB,logoutB,addProductB,viewPaymentB,viewOwnwerB,viewOrderB;
	private ImageIcon viewUser,viewEmployee,profile,logout;
	private JLabel roleL,userL,titleL;
	private JPanel mainPanel;
	private Font font14,font16,font20;
	private User us;
	
	public OwnerPage(User us){
		viewUser = new ImageIcon("frame/icon/user.png");
		viewEmployee = new ImageIcon("frame/icon/employee.png");
		profile = new ImageIcon("frame/icon/profile.png");
		logout = new ImageIcon("frame/icon/logout.png");
		
		
		font14 = new Font("League Spartan",Font.BOLD,14);
		font16 = new Font("League Spartan",Font.BOLD,16);
		font20 = new Font("League Spartan",Font.BOLD,20);
		
		
		this.setTitle("Owner Page - PharmaCare");
		this.setSize(600,650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0,0,600,650);
		this.add(mainPanel);
		
		titleL = new JLabel("Admin Dashboard");
		titleL.setBounds(230,20,200,30);
		titleL.setFont(font20);
		mainPanel.add(titleL);
		
		roleL = new JLabel("Admin:");
		roleL.setBounds(230,60,80,30);
		roleL.setFont(font14);
		mainPanel.add(roleL);
		
		userL = new JLabel();
		userL.setBounds(315,60,150,30);
		userL.setFont(font14);
		userL.setText(us.getUsername());
		mainPanel.add(userL);
		
		viewUserB = new JButton("View User");
		viewUserB.setBounds(100,150,200,80);
		viewUserB.setBorder(BorderFactory.createLineBorder(null));
		viewUserB.setBackground(new Color(0xf5785d));
		viewUserB.setForeground(Color.white);
		viewUserB.setIcon(viewUser);
		mainPanel.add(viewUserB);
		
		viewEmployeeB = new JButton("View Employee");
		viewEmployeeB.setBounds(320,150,200,80);
		viewEmployeeB.setBorder(BorderFactory.createLineBorder(null));
		viewEmployeeB.setBackground(new Color(0xf5785d));
		viewEmployeeB.setForeground(Color.white);
		viewEmployeeB.setIcon(viewEmployee);
		mainPanel.add(viewEmployeeB);
		
		profileB = new JButton("Profile");
		profileB.setBounds(100,250,200,80);
		profileB.setBorder(BorderFactory.createLineBorder(null));
		profileB.setBackground(new Color(0xf5785d));
		profileB.setForeground(Color.white);
		profileB.setIcon(profile);
		mainPanel.add(profileB);
		
		addProductB = new JButton("Add Product");
		addProductB.setBounds(320,250,200,80);
		addProductB.setBorder(BorderFactory.createLineBorder(null));
		addProductB.setBackground(new Color(0xf5785d));
		addProductB.setForeground(Color.white);
		addProductB.setIcon(viewUser);
		mainPanel.add(addProductB);
		
		viewOwnwerB = new JButton("View Owner");
		viewOwnwerB.setBounds(100,350,200,80);
		viewOwnwerB.setBorder(BorderFactory.createLineBorder(null));
		viewOwnwerB.setBackground(new Color(0xf5785d));
		viewOwnwerB.setForeground(Color.white);
		viewOwnwerB.setIcon(viewEmployee);
		mainPanel.add(viewOwnwerB);
		
		viewOrderB = new JButton("View Order");
		viewOrderB.setBounds(320,350,200,80);
		viewOrderB.setBorder(BorderFactory.createLineBorder(null));
		viewOrderB.setBackground(new Color(0xf5785d));
		viewOrderB.setForeground(Color.white);
		viewOrderB.setIcon(profile);
		mainPanel.add(viewOrderB);
		
		viewPaymentB = new JButton("View Payment");
		viewPaymentB.setBounds(100,450,200,80);
		viewPaymentB.setBorder(BorderFactory.createLineBorder(null));
		viewPaymentB.setBackground(new Color(0xf5785d));
		viewPaymentB.setForeground(Color.white);
		viewPaymentB.setIcon(logout);
		mainPanel.add(viewPaymentB);
		
		logoutB = new JButton("Logout");
		logoutB.setBounds(320,450,200,80);
		logoutB.setBorder(BorderFactory.createLineBorder(null));
		logoutB.setBackground(new Color(0xf5785d));
		logoutB.setForeground(Color.white);
		logoutB.setIcon(logout);
		mainPanel.add(logoutB);
		
	
		
		
		
		viewUserB.addActionListener(this);
		viewOrderB.addActionListener(this);
		viewEmployeeB.addActionListener(this);
		profileB.addActionListener(this);
		viewOwnwerB.addActionListener(this);
		addProductB.addActionListener(this);
		viewPaymentB.addActionListener(this);
		logoutB.addActionListener(this);
		this.setVisible(true);
		this.us=us;
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==viewUserB){
			new ViewUser(us);
			dispose();
		}
		if(e.getSource()==viewEmployeeB){
			new ViewEmployee(us);
			dispose();
		}
		if(e.getSource()==viewOwnwerB){
			new ViewOwner(us);
			dispose();
		}
		if(e.getSource()==logoutB){
			new Login();
			dispose();
		}
		if(e.getSource()==profileB){
			new SelfProfile(us);
			dispose();
		}
		if(e.getSource()==addProductB){
			new ProductlistPage(us);
			dispose();
		}
		if(e.getSource()==viewOrderB){
			new AllOrderList(us);
			dispose();
		}
		if(e.getSource()==viewPaymentB){
			new ViewAllPayment(us);
			dispose();
		}
	}

}