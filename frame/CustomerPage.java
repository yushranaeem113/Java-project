package frame;
import entities.*;
import interfaces.*;
import repository.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;

 
public class CustomerPage extends JFrame implements ActionListener {
 private JPanel jp;
 private JLabel fullnameLabel ,usernameLabel,passwordLabel,mblNoLabel,userIdLabel,addressLabel,emailLabel;
 private JTextField fullnameField,usernameField,addressField,mblNoField,emailField,userIdField;
 private JPasswordField passwordField;
 private JButton logoutBtn,buyBtn,changepasBtn,listBtn,updateBtn,payHisBtn;	
 private User us;
 
    
public CustomerPage(User us){
	this.us=us;
	CustomersRepo cus = new CustomersRepo();
	Customers c= cus.searchById(us.getId());
	
	this.setTitle("Customer - Page");
	this.setSize(600,500);
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JPanel jp = new JPanel();
	jp.setLayout(null);
	
	userIdLabel = new JLabel("User ID");
	userIdLabel.setBounds(100, 60, 110, 30);
	jp.add(userIdLabel);

	userIdField = new JTextField();
	userIdField.setBounds(180, 60, 150, 30);
	userIdField.setText(c.getId());
	userIdField.setEditable(false);
	jp.add(userIdField);

	fullnameLabel = new JLabel("Full name:");
	fullnameLabel.setBounds(100, 95, 95, 30);
	jp.add(fullnameLabel);
   
	fullnameField = new JTextField();
	fullnameField.setBounds(180, 95, 150, 30);
	fullnameField.setText(c.getName());
	fullnameField.setEditable(false);
	jp.add(fullnameField);

	usernameLabel = new JLabel("User name:");
	usernameLabel.setBounds(100, 130, 100, 30);
	jp.add(usernameLabel);
   
	usernameField = new JTextField();
	usernameField.setBounds(180, 130, 150, 30);
	usernameField.setText(c.getUsername());
	usernameField.setEditable(false);
	jp.add(usernameField);
	
	addressLabel= new JLabel("Address:");
	addressLabel.setBounds(100, 165, 100, 30);
	jp.add(addressLabel);
  
	addressField = new JTextField();
	addressField.setBounds(180, 165, 150, 30);
	addressField.setText(c.getAddress());
	addressField.setEditable(false);
	jp.add(addressField);
	
	mblNoLabel = new JLabel("Mobile No:");
	mblNoLabel.setBounds(100, 200, 120, 30);
	jp.add(mblNoLabel);
	
	mblNoField = new JTextField();
	mblNoField.setBounds(180, 200, 150, 30);
	mblNoField.setText(c.getNumber());
	mblNoField.setEditable(false);
	jp.add(mblNoField);

	emailLabel= new JLabel("Email:");
	emailLabel.setBounds(100, 235, 100, 30);
	jp.add(emailLabel);
	
	emailField = new JTextField();
	emailField.setBounds(180, 235, 150, 30);
	emailField.setText(c.getEmail());
	emailField.setEditable(false);
	jp.add(emailField);
	
	JLabel passwordLabel = new JLabel("Password:");
	passwordLabel.setBounds(100, 270, 100, 30);
	jp.add(passwordLabel);

	passwordField = new JPasswordField();
	passwordField.setBounds(180, 270, 150, 30);
	passwordField.setText(c.getPassword());
	passwordField.setEditable(false);
	jp.add(passwordField);

	buyBtn = new JButton("Buy");
	buyBtn.setBounds(100, 320, 70, 30);
	jp.add(buyBtn);

	listBtn = new JButton("List");
	listBtn.setBounds(180, 320, 70, 30);
	jp.add(listBtn);

	changepasBtn = new JButton("Change Password");
	changepasBtn.setBounds(260, 320, 140, 30);
	jp.add(changepasBtn);

	updateBtn = new JButton("Update");
	updateBtn .setBounds(100, 370, 80, 30);
	jp.add(updateBtn );

	payHisBtn = new JButton("Payment History");
	payHisBtn.setBounds(190, 370,140 , 30);
	jp.add(payHisBtn);

	logoutBtn = new JButton("Logout");
	logoutBtn.setBounds(340, 370, 80, 30);
	jp.add(logoutBtn);
	

	buyBtn.addActionListener(this);
	payHisBtn.addActionListener(this);
	changepasBtn.addActionListener(this);
	updateBtn.addActionListener(this);
	logoutBtn.addActionListener(this);
	listBtn.addActionListener(this);
	this.add(jp);
	this.setVisible(true);

}

public void actionPerformed(ActionEvent e) {
	if(e.getSource() == buyBtn){
		new PurchaseArea(us);
		dispose();
	} 
	if(e.getSource() == payHisBtn){
		new AllPaymentList(us);
		dispose();
	} 
	if(e.getSource()==logoutBtn){
		new Login();
		dispose();
	}
	if(e.getSource()==listBtn){
		new OrderListView(us);
		dispose();
	}
	if(e.getSource()==changepasBtn){
		new ChangePassword(us);
		dispose();
	}
	if(e.getSource()==updateBtn){
		new UpdateProfile(us);
		dispose();
	}
}


}