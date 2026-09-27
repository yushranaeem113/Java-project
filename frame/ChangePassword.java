package frame;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repository.*;

public class ChangePassword extends JFrame implements ActionListener
{
	private JLabel userIdLabel,currentPassLabel, newPassLabel;
	private JTextField userTF;
	private JPasswordField currentPassPF,newPassPF;
	private JButton updateBtn, backBtn;
	private JPanel panel;
	private User u;
	
	
	
	public ChangePassword(User u)
	{
		super("Change Password ");
		this.setSize(500,350);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.userIdLabel=new JLabel("User Id:");
		this.userIdLabel.setBounds(100,50,60,30);
		this.panel.add(userIdLabel);
		
		this.userTF=new JTextField();
		this.userTF.setBounds(240,50,100,30);
		this.userTF.setText(u.getId());
		this.userTF.setEditable(false);
		this.panel.add(userTF);
		
		this.currentPassLabel=new JLabel("current Password:");
		this.currentPassLabel.setBounds(100,100,150,30);
		this.panel.add(currentPassLabel);
		
		this.currentPassPF=new JPasswordField();
		this.currentPassPF.setBounds(240,100,100,30);
		this.panel.add(currentPassPF);
		
		this.newPassLabel=new JLabel("New Password:");
		this.newPassLabel.setBounds(100,150,150,30);
		this.panel.add(newPassLabel);
		
		this.newPassPF=new JPasswordField();
		this.newPassPF.setBounds(240,150,100,30);
		this.panel.add(newPassPF);
		
		
		
		
		this.updateBtn=new JButton("update");
		this.updateBtn.setBounds(80,200,120,30);
		this.updateBtn.addActionListener(this);
		this.panel.add(updateBtn);
		
		
		
		this.backBtn=new JButton("back");
		this.backBtn.setBounds(250,200,100,30);
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
			
			if((!currentPassPF.getText().isEmpty()) && (!newPassPF.getText().isEmpty()))
			{
				
				if(currentPassPF.getText().equals(u.getPassword()))
				{
					
					u.setPassword(newPassPF.getText());
					
					UserRepo urp=new UserRepo();
					CustomersRepo cus = new CustomersRepo();
					Customers cs = cus.searchById(u.getId());
					urp.updateUser(u);
					cus.updateCustomers(cs);
					
					JOptionPane.showMessageDialog(this,"Password updated Successfully");
				}
				
				else
				{
					JOptionPane.showMessageDialog(this,"Current Password didn't match");
				}
		
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
	