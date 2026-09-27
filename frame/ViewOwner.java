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
import java.lang.*;


public class ViewOwner extends JFrame implements ActionListener{
	private JPanel mainPanel;
	private JButton addBtn,updateBtn,clearBtn,backBtn,searchBtn,removeBtn;
	private JLabel numL,addressL,quesL,titleL,fullnameL,usernameL,statusL,amountL,emailL,passL,roleL,idL,reasonL;
	private JTable table;
	private JScrollPane scroll;
	private JTextField numF,addressF,quesF,fullnameF,usernameF,amountF,emailF,passF,idF,roleF;
	private JComboBox statusF;
	private Font font14,font16,font20;
	private String id,fullname,username,email,pass,role,status,salary,f,reason,quesAns,number,address;
	private double percentInt;
	private JTextArea reasonMsg;
	private FileIo fio = new FileIo();
	private User us;
	
	public ViewOwner(User us){
		font14 = new Font("League Spartan",Font.BOLD,14);
		font16 = new Font("League Spartan",Font.BOLD,16);
		font20 = new Font("League Spartan",Font.BOLD,20);
		
		
		this.setSize(800,650);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Customer Details - PharmaCare");
		
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0,0,800,650);
		mainPanel.setBackground(new Color(0xE8EBFD));

		titleL = new JLabel("Owner Details");
		titleL.setBounds(300,0,200,50);
		titleL.setFont(font20);
		mainPanel.add(titleL);
		
		
		f =fio.lineCountEmployee("repository/data/ownerData.txt");
		
		idL = new JLabel("ID: ");
		idL.setBounds(50,50,200,30);
		idL.setFont(font16);
		mainPanel.add(idL);

		idF = new JTextField();
		idF.setEditable(false);
		idF.setBounds(160,50,200,30);
		idF.setText(f);
		mainPanel.add(idF);

		fullnameL = new JLabel("Full Name: ");
		fullnameL.setBounds(50,90,200,30);
		fullnameL.setFont(font16);
		mainPanel.add(fullnameL);

		fullnameF = new JTextField();
		fullnameF.setBounds(160,90,200,30);
		fullnameF.setText("");
		mainPanel.add(fullnameF);

		usernameL = new JLabel("Username: ");
		usernameL.setBounds(50,130,200,30);
		usernameL.setFont(font16);
		mainPanel.add(usernameL);

		usernameF = new JTextField();
		usernameF.setBounds(160,130,200,30);
		usernameF.setText("");
		mainPanel.add(usernameF);
		

		statusL = new JLabel("Status: ");
		statusL.setBounds(50,170,200,30);
		statusL.setFont(font16);
		mainPanel.add(statusL);


		String status[] = {"unblocked","blocked"};
		statusF = new JComboBox(status);
		statusF.setBounds(160,170,200,30);
		mainPanel.add(statusF);
		
		numL = new JLabel("Number: ");
		numL.setBounds(50,210,200,30);
		numL.setFont(font16);
		mainPanel.add(numL);

		numF = new JTextField();
		numF.setBounds(160,210,200,30);
		numF.setText("");
		mainPanel.add(numF);
		
		reasonL = new JLabel("Block Reason: ");
		reasonL.setBounds(50,250,130,30);
		reasonL.setFont(font14);
		mainPanel.add(reasonL);
		
		reasonMsg = new JTextArea();
		reasonMsg.setBounds(160,250,200,30);
		reasonMsg.setFont(font16);
		mainPanel.add(reasonMsg);

		amountL = new JLabel("Amount: ");
		amountL.setBounds(410,50,200,30);
		amountL.setFont(font16);
		mainPanel.add(amountL);

		amountF = new JTextField();
		amountF.setBounds(520,50,200,30);
		amountF.setText("");
		mainPanel.add(amountF);

		emailL = new JLabel("Email: ");
		emailL.setBounds(410,90,200,30);
		emailL.setFont(font16);
		mainPanel.add(emailL);

		emailF = new JTextField();
		emailF.setBounds(520,90,200,30);
		emailF.setText("");
		mainPanel.add(emailF);
		
		addressL = new JLabel("Address: ");
		addressL.setBounds(410,130,200,30);
		addressL.setFont(font16);
		mainPanel.add(addressL);

		addressF = new JTextField();
		addressF.setBounds(520,130,200,30);
		addressF.setText("");
		mainPanel.add(addressF);
		
		roleL = new JLabel("Role: ");
		roleL.setBounds(410,170,200,30);
		roleL.setFont(font16);
		mainPanel.add(roleL);

		roleF = new JTextField();
		roleF.setText("owner");
		roleF.setEditable(false);
		roleF.setBounds(520,170,200,30);
		mainPanel.add(roleF);
		
		quesL = new JLabel("Security Ans: ");
		quesL.setBounds(410,210,200,30);
		quesL.setFont(font16);
		mainPanel.add(quesL);

		quesF = new JTextField();
		quesF.setBounds(520,210,200,30);
		quesF.setText("");
		mainPanel.add(quesF);
		
		passL = new JLabel("Password: ");
		passL.setBounds(410,250,200,30);
		passL.setFont(font16);
		mainPanel.add(passL);

		passF = new JTextField();
		passF.setBounds(520,250,200,30);
		passF.setText("");
		mainPanel.add(passF);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(45,320,110,40);
		addBtn.setBackground(new Color(0xFA5B39));
		addBtn.setForeground(Color.white);
		addBtn.setFont(font14);
		addBtn.setBorder(null);
		mainPanel.add(addBtn);
		
		updateBtn = new JButton("Update");
		updateBtn.setBounds(165,320,110,40);
		updateBtn.setBackground(new Color(0xFA5B39));
		updateBtn.setForeground(Color.white);
		updateBtn.setFont(font14);
		updateBtn.setBorder(null);
		mainPanel.add(updateBtn);
		
		clearBtn = new JButton("Clear");
		clearBtn.setBounds(285,320,110,40);
		clearBtn.setBackground(new Color(0xFA5B39));
		clearBtn.setForeground(Color.white);
		clearBtn.setFont(font14);
		clearBtn.setBorder(null);
		mainPanel.add(clearBtn);
		
		removeBtn = new JButton("Remove");
		removeBtn.setBounds(405,320,110,40);
		removeBtn.setBackground(new Color(0xFA5B39));
		removeBtn.setForeground(Color.white);
		removeBtn.setFont(font14);
		removeBtn.setBorder(null);
		mainPanel.add(removeBtn);
		
		searchBtn = new JButton("Search");
		searchBtn.setBounds(525,320,100,40);
		searchBtn.setBackground(new Color(0xFA5B39));
		searchBtn.setForeground(Color.white);
		searchBtn.setFont(font14);
		searchBtn.setBorder(null);
		mainPanel.add(searchBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(635,320,110,40);
		backBtn.setBackground(new Color(0xFA5B39));
		backBtn.setForeground(Color.white);
		backBtn.setFont(font14);
		backBtn.setBorder(null);
		mainPanel.add(backBtn);
		
		
		OwnerRepo repo = new OwnerRepo();
		Owner[] allEm = repo.allOwner();
		
		String Owner[][]=new String[allEm.length][12];
		for(int i=0; i<allEm.length; i++){
			if(allEm[i]!=null){
				allEm[i].toStringOwner();
				Owner[i][0]=allEm[i].getId();
				Owner[i][1]=allEm[i].getName();
				Owner[i][2]=allEm[i].getUsername();
				Owner[i][3]=allEm[i].getQuesAns();
				Owner[i][4]=allEm[i].getPassword();
				Owner[i][5]=allEm[i].getRole();
				Owner[i][6]=allEm[i].getStatus();
				Owner[i][7]=allEm[i].getBlockReason();
				Owner[i][8]=allEm[i].getEmail();
				Owner[i][9]=allEm[i].getNumber();
				Owner[i][10]=allEm[i].getAddress();
				Owner[i][11]=String.valueOf(allEm[i].getCompanySharePer());
			}
		}
		
		String cols[] = {"ID","Name","Username","Security","Password","Role","Status","Block Reason","Email","Number","Address","Amount"};
		table = new JTable(Owner,cols);
		table.setFont(font14);
		table.setSelectionBackground(new Color(0xFA5B39));
		table.setBackground(new Color(0xffffff));
		scroll = new JScrollPane(table);
        scroll.setBounds(10,400,765,200);
		mainPanel.add(scroll);
		
		addBtn.addActionListener(this);
		backBtn.addActionListener(this);
		clearBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		removeBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		this.add(mainPanel);
		this.setVisible(true);
		this.us=us;
	}
	
	public void actionPerformed(ActionEvent a){
		if(a.getSource()==clearBtn){
			idF.setText(f);
			fullnameF.setText("");
			usernameF.setText("");
			quesF.setText("");
			passF.setText("");
			statusF.setSelectedIndex(0);
			reasonMsg.setText("");
			emailF.setText("");
			numF.setText("");
			addressF.setText("");
			amountF.setText("");
		}
		if(a.getSource()==searchBtn){
			String user = JOptionPane.showInputDialog(this,"Enter Owner Username:");
			OwnerRepo Ownerrep = new OwnerRepo();
			Owner findEm=Ownerrep.searchByUsername(user);
			
			if(findEm!=null){
				idF.setText(findEm.getId());
				fullnameF.setText(findEm.getName());
				usernameF.setText(findEm.getUsername());
				quesF.setText(findEm.getQuesAns());
				passF.setText(findEm.getPassword());
				if(findEm.getStatus().equals("unblocked")){
					statusF.setSelectedIndex(0);
				}else{
					statusF.setSelectedIndex(1);
				}
				reasonMsg.setText(findEm.getBlockReason());
				emailF.setText(findEm.getEmail());
				numF.setText(findEm.getNumber());
				addressF.setText(findEm.getAddress());
				amountF.setText(String.valueOf(findEm.getCompanySharePer()));
			}else{
				JOptionPane.showMessageDialog(this,"Wrong Owner details.");
			}
		}
		if(a.getSource()==addBtn){
			
			if((!usernameF.getText().isEmpty()) && (!fullnameF.getText().isEmpty()) && (!emailF.getText().isEmpty()) && (!numF.getText().isEmpty()) && (!addressF.getText().isEmpty()) && (!quesF.getText().isEmpty()) && (!passF.getText().isEmpty()))
			{
				
				UserRepo urp=new UserRepo();
				try
				{
					id = idF.getText();
					fullname = fullnameF.getText();
					username = usernameF.getText();
					status = statusF.getSelectedItem().toString();
					salary = amountF.getText();
					percentInt = Integer.parseInt(amountF.getText());
					email = emailF.getText();
					quesAns = quesF.getText();
					number = numF.getText();
					address = addressF.getText();
					pass = passF.getText();
					reason = reasonMsg.getText();
					role = roleF.getText();
					
					OwnerRepo arp=new OwnerRepo();
					if((arp.searchByUsername(username))!=null){
						JOptionPane.showMessageDialog(this,username+" this username is already exists!");
					}else if((arp.searchById(id))!=null){
						JOptionPane.showMessageDialog(this,id+" this Owner id is already exists!");
					}else{
						Owner em=new Owner(id,fullname,username,quesAns,pass,role,status,reason,email,number,address,percentInt);
					
						urp.addUser(em);
						arp.addOwner(em);
						JOptionPane.showMessageDialog(this,"Added Successfully");
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this,"provide valid salary");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}
		if(a.getSource()==backBtn){
			new OwnerPage(us);
			dispose();
		}
		if(a.getSource()==updateBtn){
			OwnerRepo Ownerrep = new OwnerRepo();
			UserRepo userrep = new UserRepo();
			
			if((!usernameF.getText().isEmpty()) && (!fullnameF.getText().isEmpty()) && (!emailF.getText().isEmpty()) && (!numF.getText().isEmpty()) && (!addressF.getText().isEmpty()) && (!quesF.getText().isEmpty()) && (!passF.getText().isEmpty())){
				id = idF.getText();
				fullname = fullnameF.getText();
				username = usernameF.getText();
				status = statusF.getSelectedItem().toString();
				salary = amountF.getText();
				percentInt = Integer.parseInt(amountF.getText());
				email = emailF.getText();
				quesAns = quesF.getText();
				number = numF.getText();
				address = addressF.getText();
				pass = passF.getText();
				reason = reasonMsg.getText();
				role = roleF.getText();
				
				Owner findEm = Ownerrep.searchById(id);
				User findUs = userrep.searchById(id);
				
				findEm.setId(id);
				findEm.setName(fullname);
				findEm.setUsername(username);
				findEm.setStatus(status);
				findEm.setCompanySharePer(percentInt);
				findEm.setEmail(email);
				findEm.setQuesAns(quesAns);
				findEm.setNumber(number);
				findEm.setAddress(address);
				findEm.setPassword(pass);
				findEm.setBlockReason(reason);
				findEm.setRole(role);
				Ownerrep.updateOwner(findEm);
				userrep.updateUser(findUs);
				
				
				JOptionPane.showMessageDialog(this,"Owner data updated");
			}else{
				JOptionPane.showMessageDialog(this,"Seach the Owner for update");
			}
				
			}
			if(a.getSource()==removeBtn){
				String userId;
				if(!idF.getText().isEmpty()) 
				{
					userId=idF.getText();
					OwnerRepo arp=new OwnerRepo();
					Owner o=arp.searchById(userId);
					if(o!=null)
					{
						UserRepo urp=new UserRepo();
						urp.removeUser(userId);
						arp.removeOwner(userId);
						JOptionPane.showMessageDialog(this,"Yeah! Owner removed successfully");
					}
					
					else
					{
						JOptionPane.showMessageDialog(this,"Provide valid user ID!");
					}
			
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Please Provide a valid userId");
				}
			}
		}
}