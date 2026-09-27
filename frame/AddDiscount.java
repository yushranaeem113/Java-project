package frame;
import entities.*;
import interfaces.*;
import repository.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 
public class AddDiscount extends JFrame implements ActionListener
{
	private JPanel panel;
	private JTextField idFieldield,couponCodeField,percentageField;
	private JLabel titleLabel,idLabel,couponCodeLabel,percentageLabel;
	private JButton addButton,updateButton,removeButton,searchButton,backButton,clearButton;
	private JTable table;
	private JScrollPane scroll;
	private String id,code;
	private double parcentage;
	private User us;
	private FileIo fio = new FileIo();
	private String f;
	
	public AddDiscount(User us)
	{
		this.setTitle("Discount page");
		this.setSize(735,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		panel = new JPanel();
		this.setLocationRelativeTo(null);
		panel.setLayout(null);
		panel.setBounds(0,0,615,500);
		this.add(panel);
		titleLabel = new JLabel("Discount Page");
		titleLabel.setBounds(230,20,200,50);
		titleLabel.setFont(new Font("Poppins",Font.BOLD,20));
		panel.add(titleLabel);
		
		idLabel = new JLabel("Coupon ID :");
		idLabel.setBounds(20,70,130,40);
		idLabel.setFont(new Font("Poppins",Font.BOLD,17));
		panel.add(idLabel);
		
		couponCodeLabel = new JLabel("Coupon Code :");
		couponCodeLabel.setBounds(20,120,130,40);
		couponCodeLabel.setFont(new Font("Poppins",Font.BOLD,17));
		panel.add(couponCodeLabel);
		
		percentageLabel = new JLabel("Percentage :");
		percentageLabel.setBounds(20,170,130,40);
		percentageLabel.setFont(new Font("Poppins",Font.BOLD,17));
		panel.add(percentageLabel);
		
		
		f =fio.lineCountDiscount("repository/data/discountCode.txt");
		
		idFieldield = new JTextField();
		idFieldield.setText(f);
		idFieldield.setBounds(160,70,150,40);
		panel.add(idFieldield);
		
		couponCodeField = new JTextField();
		couponCodeField.setBounds(160,120,150,40);
		panel.add(couponCodeField);
		
		percentageField = new JTextField();
		percentageField.setBounds(160,170,150,40);
		panel.add(percentageField);
		
		addButton = new JButton("Add");
		addButton.setBounds(10,230,100,40);
		addButton.setFont(new Font("Poppins",Font.BOLD,17));
		panel.add(addButton);
		
		updateButton = new JButton("Update");
		updateButton.setBounds(130,230,100,40);
		updateButton.setFont(new Font("Poppins",Font.BOLD,17));
		panel.add(updateButton);
		
		removeButton = new JButton("Remove");
		removeButton.setBounds(250,230,100,40);
		removeButton.setFont(new Font("Poppins",Font.BOLD,16));
		panel.add(removeButton);
		
		clearButton = new JButton("Clear");
		clearButton.setBounds(370,230,100,40);
		clearButton.setFont(new Font("Poppins",Font.BOLD,16));
		panel.add(clearButton);
		
		searchButton = new JButton("Search");
		searchButton.setBounds(490,230,100,40);
		searchButton.setFont(new Font("Poppins",Font.BOLD,17));
		panel.add(searchButton);
		
		backButton = new JButton("Back");
		backButton.setBounds(610,230,100,40);
		backButton.setFont(new Font("Poppins",Font.BOLD,17));
		panel.add(backButton);
		
		DiscountRepo repo = new DiscountRepo();
		Discount[] list = repo.allDiscount();
		String discountData[][]=new String[list.length][3];
		for(int i=0; i<list.length; i++){
			if(list[i]!=null){
				list[i].toStringDiscount();
				discountData[i][0]=list[i].getId();
				discountData[i][1]=list[i].getCode();
				discountData[i][2] = String.valueOf(list[i].getParcentage());
			}
		}
		String cols[] = {"Discount ID","Coupon Code","Parcentage(%)"};
		table = new JTable(discountData,cols);
		table.setSelectionBackground(new Color(0xFA5B39));
		table.setBackground(new Color(0xffffff));
		scroll = new JScrollPane(table);
        scroll.setBounds(10,280,640,180);
		panel.add(scroll);
		
		clearButton.addActionListener(this);
		backButton.addActionListener(this);
		addButton.addActionListener(this);
		updateButton.addActionListener(this);
		searchButton.addActionListener(this);
		removeButton.addActionListener(this);
		this.us=us;
		

	}
	
	public void actionPerformed(ActionEvent a){
		if(a.getSource()==clearButton){
			idFieldield.setText(f);
			couponCodeField.setText("");
			percentageField.setText("");
		}
		if(a.getSource()==searchButton){
			String discount = JOptionPane.showInputDialog(this,"Enter Dicount Id:");
			DiscountRepo discountrep = new DiscountRepo();
			Discount findDis=discountrep.searchById(discount);
			
			if(findDis!=null){
				idFieldield.setText(findDis.getId());
				couponCodeField.setText(findDis.getCode());
				percentageField.setText(findDis.getParcentage()+"");
			}else{
				JOptionPane.showMessageDialog(this,"Wrong discount id!");
			}
		}
		if(a.getSource()==addButton){
			
			if((!percentageField.getText().isEmpty()) && (!couponCodeField.getText().isEmpty()) && (!idFieldield.getText().isEmpty()))
			{
				
				DiscountRepo urp=new DiscountRepo();
				try
				{
					id = idFieldield.getText();
					code = couponCodeField.getText();
					parcentage = Double.parseDouble(percentageField.getText());
					
					if((urp.searchById(id))!=null){
						JOptionPane.showMessageDialog(this,id+" this Discount id is already exists!");
					}else{
						Discount em=new Discount(id,code,parcentage);
					
						urp.addDiscount(em);
						JOptionPane.showMessageDialog(this,"Added Successfully");
					}
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this,"provide valid parcentage");
				}
		
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please fill up all the field properly");
			}
		}
		if(a.getSource()==backButton){
			new ProductlistPage(us);
			dispose();	
		}
		if(a.getSource()==updateButton){
			DiscountRepo discountrep = new DiscountRepo();
			
			if((!percentageField.getText().isEmpty()) && (!couponCodeField.getText().isEmpty()) && (!idFieldield.getText().isEmpty()))
			{
				id = idFieldield.getText();
				code = couponCodeField.getText();
				parcentage = Double.parseDouble(percentageField.getText());
				
				Discount findDis = discountrep.searchById(id);
				
				findDis.setId(id);
				findDis.setCode(code);
				findDis.setParcentage(parcentage);
				
				discountrep.updateDiscount(findDis);
				
				
				JOptionPane.showMessageDialog(this,"Dicount code data updated");
			}else{
				JOptionPane.showMessageDialog(this,"First search the discount code for update");
			}
				
			}
			
			if(a.getSource()==removeButton){
				String userId;
				if(!idFieldield.getText().isEmpty()) 
				{
					userId=idFieldield.getText();
					DiscountRepo arp=new DiscountRepo();
					Discount d=arp.searchById(userId);
					if(d!=null)
					{
						arp.removeDiscount(userId);
						JOptionPane.showMessageDialog(this,"Yeah! removed successfully");
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