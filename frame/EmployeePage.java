//MD JAKARIA NAIM
//23-51932-2
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

public class EmployeePage extends JFrame implements ActionListener
{
	private JButton viewUserB,profileB,logoutB,addSaleB,addCompanyB,exitB,medicineListB,viewOrderB,paymentB;
	private JPanel mainPanel;
	private JLabel dashboardLabel,employeeLabel,userLabel;
	private User user;
	
	public EmployeePage(User user)
	{
		this.user=user;
		this.setTitle("Employee Page - PharmaCare");
		this.setSize(600,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0,0,600,600);
		this.add(mainPanel);
		
		dashboardLabel = new JLabel("Employee Dashboard");
		dashboardLabel.setBounds(175,25,250,30);
		dashboardLabel.setFont(new Font("Poppins",Font.BOLD,22));
		mainPanel.add(dashboardLabel);
		
		employeeLabel = new JLabel("Employee  :");
		employeeLabel.setBounds(190,65,120,15);
		employeeLabel.setFont(new Font("Poppins",Font.BOLD,15));
        mainPanel.add(employeeLabel);
		
		userLabel = new JLabel();
		userLabel.setText(user.getUsername());
		userLabel.setBounds(300,65,120,15);
		userLabel.setFont(new Font("Poppins",Font.BOLD,15));
        mainPanel.add(userLabel);
		
		viewUserB = new JButton("View User");
		ImageIcon viewUser = new ImageIcon("frame/icon/user.png");
		viewUserB.setBounds(100,100,200,80);
		viewUserB.setFont(new Font("Poppins",Font.BOLD,14));
		viewUserB.setIcon(viewUser);
		mainPanel.add(viewUserB);
		
		profileB = new JButton("View Profile");
		ImageIcon viewProfile = new ImageIcon("frame/icon/profile.png");
		profileB.setBounds(320,100,200,80);
		profileB.setFont(new Font("Poppins",Font.BOLD,14));
		profileB.setIcon(viewProfile);
		mainPanel.add(profileB);
		
		addSaleB = new JButton("Add Sale");
		ImageIcon addSale = new ImageIcon("frame/icon/addsale.png");
		addSaleB.setBounds(100,200,200,80);
		addSaleB.setFont(new Font("Poppins",Font.BOLD,14));
		addSaleB.setIcon(addSale);
		mainPanel.add(addSaleB);
		
		addCompanyB = new JButton("Company");
		ImageIcon addCompany = new ImageIcon("frame/icon/addcompany.png");
		addCompanyB.setBounds(320,200,200,80);
		addCompanyB.setFont(new Font("Poppins",Font.BOLD,14));
		addCompanyB.setIcon(addCompany);
		mainPanel.add(addCompanyB);
		
		medicineListB = new JButton("Medicine List");
		ImageIcon medicineList = new ImageIcon("frame/icon/Medicine.png");
		medicineListB.setBounds(100,300,200,80);
		medicineListB.setFont(new Font("Poppins",Font.BOLD,14));
		medicineListB.setIcon(medicineList);
		mainPanel.add(medicineListB);
		
		paymentB = new JButton("Payment");
		ImageIcon payment = new ImageIcon("frame/icon/payment.png");
		paymentB.setBounds(320,300,200,80);
		paymentB.setFont(new Font("Poppins",Font.BOLD,14));
		paymentB.setIcon(payment);
		mainPanel.add(paymentB);
		
		viewOrderB = new JButton("View Order");
		ImageIcon viewOrder = new ImageIcon("frame/icon/viewOrder.png");
		viewOrderB.setBounds(100,400,200,80);
		viewOrderB.setFont(new Font("Poppins",Font.BOLD,14));
		viewOrderB.setIcon(viewOrder);
		mainPanel.add(viewOrderB);
		
		
		
		logoutB = new JButton("Logout");
		ImageIcon logOut = new ImageIcon("frame/icon/logout.png");
		logoutB.setBounds(320,400,200,80);
		logoutB.setFont(new Font("Poppins",Font.BOLD,14));
		logoutB.setIcon(logOut);
		mainPanel.add(logoutB);
		
		viewUserB.addActionListener(this);
		viewOrderB.addActionListener(this);
		addCompanyB.addActionListener(this);
		addSaleB.addActionListener(this);
		profileB.addActionListener(this);
		medicineListB.addActionListener(this);
		paymentB.addActionListener(this);
		logoutB.addActionListener(this);
		this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==viewUserB){
			 new ViewUser(user);
			 dispose();
		}
		if(e.getSource()==viewOrderB){
			new AllOrderList(user);
			dispose();
		}
		if(e.getSource()==addCompanyB){
			 new AddCompanyPage(user);
			 dispose();
		}
		if(e.getSource()==addSaleB){
			new AddSalePage(user);
			dispose();
		}
		if(e.getSource()==profileB){
			 new SelfProfile(user);
			 dispose();
		}
		if(e.getSource()==medicineListB){
			new MedicineList(user);
			dispose();
		}
		if(e.getSource()==paymentB){
			 new ViewAllPayment(user);
			 dispose();
		}
		if(e.getSource()==logoutB){
			new Login();
			dispose();
		}
	}
}