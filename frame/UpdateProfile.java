package frame;
 
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repository.*;
 
public class UpdateProfile extends JFrame implements ActionListener
{
	private JLabel userIdLabel,nameLabel, emailLabel, phoneNoLabel, genderLabel, ageLabel, addressLabel,customerTypeLabel;
	private JTextField userTF, nameTF, emailTF, phoneNoTF, genderTF, ageTF, addressTF, customerTypeTF;
	private JButton addBtn, removeBtn, updateBtn, resetBtn,searchBtn, backBtn;
	private JPanel panel;
	private User u;
	private Customers customer;

	public UpdateProfile(User u)
	{
		super("Update profile Frame");
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel=new JPanel();
		this.setLocationRelativeTo(null);
		this.panel.setLayout(null);
		
		CustomersRepo arp=new CustomersRepo();
		this.customer=arp.searchById(u.getId());
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(50,50,60,30);
		this.panel.add(userIdLabel);
		this.userTF=new JTextField();
		this.userTF.setBounds(120,50,100,30);
		this.userTF.setText(customer.getId());
		this.userTF.setEditable(false);
		
		this.panel.add(userTF);
		this.nameLabel=new JLabel("User Name:");
		this.nameLabel.setBounds(50,100,60,30);
		this.panel.add(nameLabel);
		this.nameTF=new JTextField();
		this.nameTF.setBounds(120,100,100,30);
		this.nameTF.setText(customer.getUsername());
		this.nameTF.setEditable(false);
		this.panel.add(nameTF);
		this.emailLabel=new JLabel("email:");
		this.emailLabel.setBounds(50,150,60,30);
		this.panel.add(emailLabel);
		this.emailTF=new JTextField();
		this.emailTF.setBounds(120,150,150,30);
		this.emailTF.setText(customer.getEmail());
		this.panel.add(emailTF);
		this.phoneNoLabel=new JLabel("phone No:");
		this.phoneNoLabel.setBounds(50,200,60,30);
		this.panel.add(phoneNoLabel);
		this.phoneNoTF=new JTextField();
		this.phoneNoTF.setBounds(120,200,100,30);
		this.phoneNoTF.setText(customer.getNumber());
		this.panel.add(phoneNoTF);
		
		this.addressLabel=new JLabel("Address:");
		this.addressLabel.setBounds(50,250,60,30);
		this.panel.add(addressLabel);
		
		this.addressTF=new JTextField();
		this.addressTF.setBounds(120,250,100,30);
		this.addressTF.setText(customer.getAddress());
		this.panel.add(addressTF);

		this.updateBtn=new JButton("update");
		this.updateBtn.setBounds(50,300,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);

		this.backBtn=new JButton("back");
		this.backBtn.setBounds(190,300,100,30);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		this.setVisible(true);
		this.add(panel);
		this.u=u;


	}
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();

		if(command.equals(updateBtn.getText()))
		{
			if((!emailTF.getText().isEmpty()) && (!phoneNoTF.getText().isEmpty()) && (!addressTF.getText().isEmpty()))
			{
				customer.setEmail(emailTF.getText());
				customer.setNumber(phoneNoTF.getText());
				customer.setAddress(addressTF.getText());
				
				CustomersRepo cuR = new CustomersRepo();
				Customers cusstomer = cuR.searchById(u.getId());
				cuR.updateCustomers(cusstomer);
					
				JOptionPane.showMessageDialog(this,"Updated Successfully");
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}

		if(command.equals(backBtn.getText()))
		{
			new CustomerPage(u);
			dispose();
		}
	}
}