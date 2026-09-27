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
import javax.swing.border.Border;
import javax.swing.table.*;
import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class AddCompanyPage extends JFrame implements ActionListener
{
	private JLabel dateLabel,amountLabel,companyLabel;
	private JTextField amountField,companyField;
	private JButton addButton,backButton;
	private JPanel mainPanel;
	private JTable table;
	private JScrollPane scroll;
	private DefaultTableModel model;
	private User user;
	
	public AddCompanyPage(User user)
	{
		this.setTitle("AddCompanyPage - PharmaCare");
		this.setSize(600,580);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0,0,600,580);
		this.add(mainPanel);
		
		Date date = new Date();
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
		
		String dt = dateformat.format(date);
		
		
		dateLabel = new JLabel();
		dateLabel.setBounds(480,20,100,30);
		dateLabel.setFont(new Font("Poppins",Font.BOLD,14));
		dateLabel.setText(dt);
		mainPanel.add(dateLabel);
		
		amountLabel = new JLabel("Enter Amount");
		amountLabel.setBounds(230,60,200,30);
		amountLabel.setFont(new Font("Poppins",Font.BOLD,15));
		mainPanel.add(amountLabel);
		
		amountField = new JTextField();
		amountField.setBounds(185,100,210,40);
		mainPanel.add(amountField);
		
		companyLabel = new JLabel("Company Name");
		companyLabel.setBounds(230,150,200,30);
		companyLabel.setFont(new Font("Poppins",Font.BOLD,15));
		mainPanel.add(companyLabel);
		
		companyField = new JTextField();
		companyField.setBounds(185,190,210,40);
		mainPanel.add(companyField);
		
		addButton = new JButton("Add");
		addButton.setBounds(185,240,100,40);
		addButton.setFont(new Font("Poppins",Font.BOLD,15));
		mainPanel.add(addButton);
		
		backButton = new JButton("Back");
		backButton.setBounds(295,240,100,40);
		backButton.setFont(new Font("Poppins",Font.BOLD,15));
		mainPanel.add(backButton);
		
		
		model = new DefaultTableModel();
		String cols[] = {"Date","Company Name","Amount"};
		model.setColumnIdentifiers(cols);
		
		try{
			FileReader fr = new FileReader(new File("repository/data/company.txt"));
			BufferedReader br = new BufferedReader(fr);
			
			String line="";
			while((line=br.readLine())!=null){
				String data[] = line.split(",");
				String[] temRow = {data[0],data[1],data[2]};
				model.addRow(temRow);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		this.user=user;
		table = new JTable(model);
		scroll = new JScrollPane(table);
        scroll.setBounds(10,320,570,200);
		mainPanel.add(scroll);
		
		addButton.addActionListener(this);
		backButton.addActionListener(this);
		
		
 
		
		
		
		
		
		
	}	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==addButton){
			 String amount = amountField.getText();
			 String companyname = companyField.getText();
			 String date = dateLabel.getText();
			 if((amount.isEmpty()) && (companyname.isEmpty())){
				JOptionPane.showMessageDialog(this,"fill the details");
			 }else{
				String data[] = {date,companyname,amount};
				model.addRow(data);
				try{
					FileWriter fw = new FileWriter(new File("repository/data/company.txt"),true);
					fw.write(date+","+companyname+","+amount+"\n");
					fw.flush();
					fw.close();
				}
				catch(Exception p){
					p.printStackTrace();
				}
			 }
		}
		if(e.getSource()==backButton){
			new EmployeePage(user);
			dispose();
		}
	}
}
