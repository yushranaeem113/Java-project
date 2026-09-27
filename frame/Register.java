//Tofayel Hossain
//23-51928-2

package frame;
import repository.*;
import entities.*;
import interfaces.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.lang.*;
import javax.swing.border.Border;

public class Register extends JFrame implements ActionListener{
	private JPanel mainPanel,imagePanel,registerPanel;
	private JCheckBox agree,employeeC,userC;
	private JTextField userF,emailF,idF,addressF,numberF,quesF,fullnameF;
	private JPasswordField passF;
	private JButton loginB,registerB;
	private JLabel ansL,imageL,userL,emailL,passL,titleL,idL,addressL,numberL,quesL,fullnameL;
	private ImageIcon icon;
	private Image bg;
	private ButtonGroup group;
	private Font font14,font16,font20;
	private String userType;
	
	
	public Register(String f){
		
		userType=f;
		
		icon = new ImageIcon("frame/images/register.jpg");
        bg = icon.getImage().getScaledInstance(350, 670, Image.SCALE_SMOOTH);
		
		font14 = new Font("League Spartan",Font.BOLD,14);
		font16 = new Font("League Spartan",Font.BOLD,16);
		font20 = new Font("League Spartan",Font.BOLD,20);
		
		
		
		this.setTitle("Register Page - PharmaCare");
		this.setSize(660,670);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0,0,660,670);
		
		
		imagePanel = new JPanel();
		imagePanel.setLayout(null);
		imagePanel.setBounds(0,0,350,670);
		mainPanel.add(imagePanel);
		
		imageL = new JLabel();
		imageL.setLayout(null);
		imageL.setBounds(0,0,350,670);
		imageL.setIcon(new ImageIcon(bg));
		imagePanel.add(imageL);
		
		registerPanel = new JPanel();
		registerPanel.setLayout(null);
		registerPanel.setBounds(350,0,310,670);
		mainPanel.add(registerPanel);
		
		titleL = new JLabel("Register Now");
		titleL.setBounds(30,70,130,30);
		titleL.setFont(font20);
		registerPanel.add(titleL);
		
	
		
		idL = new JLabel("User UID: ");
		idL.setBounds(30,120,80,30);
		idL.setFont(font14);
		registerPanel.add(idL);
		
		
		
		idF = new JTextField();
		idF.setBounds(135,120,130,30);
		idF.setEditable(false);
		idF.setText(f);
		idF.setBorder(BorderFactory.createLineBorder(null));
		registerPanel.add(idF);
		
		fullnameL = new JLabel("Full Name: ");
		fullnameL.setBounds(30,160,80,30);
		fullnameL.setFont(font14);
		registerPanel.add(fullnameL);
		
		fullnameF = new JTextField();
		fullnameF.setBounds(135,160,130,30);
		fullnameF.setBorder(BorderFactory.createLineBorder(null));
		registerPanel.add(fullnameF);
		
		userL = new JLabel("UserName: ");
		userL.setBounds(30,200,80,30);
		userL.setFont(font14);
		registerPanel.add(userL);
		
		userF = new JTextField();
		userF.setBounds(135,200,130,30);
		userF.setBorder(BorderFactory.createLineBorder(null));
		registerPanel.add(userF);
		
		emailL = new JLabel("Email: ");
		emailL.setBounds(30,240,80,30);
		emailL.setFont(font14);
		registerPanel.add(emailL);
		
		emailF = new JTextField();
		emailF.setBounds(135,240,130,30);
		emailF.setBorder(BorderFactory.createLineBorder(null));
		registerPanel.add(emailF);
		
		numberL = new JLabel("Number: ");
		numberL.setBounds(30,280,80,30);
		numberL.setFont(font14);
		registerPanel.add(numberL);
		
		numberF = new JTextField();
		numberF.setBounds(135,280,130,30);
		numberF.setBorder(BorderFactory.createLineBorder(null));
		registerPanel.add(numberF);
		
		addressL = new JLabel("Address: ");
		addressL.setBounds(30,320,80,30);
		addressL.setFont(font14);
		registerPanel.add(addressL);
		
		addressF = new JTextField();
		addressF.setBounds(135,320,130,30);
		addressF.setBorder(BorderFactory.createLineBorder(null));
		registerPanel.add(addressF);
		
		quesL = new JLabel("Who is your favorite person?");
		quesL.setBounds(30,360,300,30);
		quesL.setFont(font14);
		registerPanel.add(quesL);
		
		quesL = new JLabel("Answer: ");
		quesL.setBounds(30,400,80,30);
		quesL.setFont(font14);
		registerPanel.add(quesL);
		
		quesF = new JTextField();
		quesF.setBounds(135,400,130,30);
		quesF.setBorder(BorderFactory.createLineBorder(null));
		registerPanel.add(quesF);
		
		passL = new JLabel("Password: ");
		passL.setBounds(30,440,80,30);
		passL.setFont(font14);
		registerPanel.add(passL);
		
		passF = new JPasswordField();
		passF.setBounds(135,440,130,30);
		passF.setBorder(BorderFactory.createLineBorder(null));
		registerPanel.add(passF);
		
		agree = new JCheckBox("I agree to the PharmaCare terms");
		agree.setBounds(30,480,250,20);
		registerPanel.add(agree);
		
		loginB = new JButton("Login");
		loginB.setBounds(30,515,115,40);
		loginB.setBackground(new Color(0xFF3131));
		loginB.setForeground(Color.white);
		loginB.setFont(font14);
		loginB.setBorder(BorderFactory.createLineBorder(null));
		registerPanel.add(loginB);
		
		registerB = new JButton("Register");
		registerB.setBounds(155,515,115,40);
		registerB.setBackground(new Color(0xFF3131));
		registerB.setForeground(Color.white);
		registerB.setFont(font14);
		registerB.setBorder(BorderFactory.createLineBorder(null));
		registerPanel.add(registerB);
		
		
		loginB.addActionListener(this);
		registerB.addActionListener(this);
		
		this.add(mainPanel);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==loginB){
			new Login();
			dispose();
		}
		if(e.getSource()==registerB){
			if((fullnameF.getText().isEmpty()) && (userF.getText().isEmpty()) && (emailF.getText().isEmpty()) && (numberF.getText().isEmpty()) && (addressF.getText().isEmpty()) && (quesF.getText().isEmpty()) && (passF.getText().isEmpty())){
				JOptionPane.showMessageDialog(this,"Enter All Details!");
			}else{
				if(agree.isSelected()){
					String id = idF.getText();
					String fullname = fullnameF.getText();
					String username = userF.getText();
					String email = emailF.getText();
					String number = numberF.getText();
					String address = addressF.getText();
					String QuesAns = quesF.getText();
					String password = passF.getText();
					
					int checkEmail=1;
					String checkEmailLength[] = email.split("");
					if(email.contains("@") && !(checkEmailLength.length<11)){
						checkEmail = 0;
					}
					UserRepo userrep = new UserRepo();
					if(userrep.searchByUsername(username)){
						JOptionPane.showMessageDialog(this,username+", this username already exisits! try again");
					}else if(checkEmail==1){
						JOptionPane.showMessageDialog(this,"Submit a valid email address.");
					}
					else{		
						User newUser = new User(id,fullname,username,QuesAns,password,"customer","unblocked","null",email,number,address);
						userrep.addUser(newUser);
						
						CustomersRepo customerrep = new CustomersRepo();
						customerrep.addCustomers(new Customers(id,fullname,username,QuesAns,password,"customer","unblocked","null",email,number,address,0));
						
						JOptionPane.showMessageDialog(this,"Registration completed successfully.");
						new Login();
						dispose();
					}
				}else{
					JOptionPane.showMessageDialog(this,"Accept our terms and conditions.");
				}
			}
		}
	}
	
}