package frame;
import entities.*;
import interfaces.*;
import repository.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.nio.file.*;
 
public class ProductlistPage extends JFrame implements ActionListener
 
{
   private JLabel productIdLabel,productNameLabel,pricLabel,stockLabel;
   private JTextField productIdTF,productNameTF,priceTF,stockTF;
   private JPanel panel;
   private JButton addBtn,updateBtn,clearBtn,backBtn,fileBtn,addDiscountBtn;
   private JTable MedicinesTable;
   private JScrollPane MedicinesTableSP;
   private User us;
   private String path,mediId,name,id;
   private int price,stock;
 
 
   public ProductlistPage(User us)
   {
    super("product list page");
    this.setSize(600,700);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
    this.panel=new JPanel();
    this.panel.setLayout(null);

	
	FileIo fio = new FileIo();
	mediId = fio.lineCountMedicine("repository/data/products.txt");
 
 
    this.productIdLabel= new JLabel("Product Id :");
    this.productIdLabel.setBounds(30,20,90,30);
    this.panel.add(productIdLabel);
 
    this.productIdTF= new JTextField();
	this.productIdTF.setText(mediId);
	this.productIdTF.setEditable(false);
    this.productIdTF.setBounds(130,20,140,30);
    this.panel.add(productIdTF);
 
    this.productNameLabel= new JLabel("Product Name :");
    this.productNameLabel.setBounds(30,60,100,30);
    this.panel.add(productNameLabel);
 
    this.productNameTF= new JTextField();
    this.productNameTF.setBounds(130,60,140,30);
    this.panel.add(productNameTF);
 
    this.pricLabel= new JLabel("Product Price :");
    this.pricLabel.setBounds(30,100,90,30);
    this.panel.add(pricLabel);
 
    this.priceTF= new JTextField();
    this.priceTF.setBounds(130,100,140,30);
    this.panel.add(priceTF);
 
    this.stockLabel= new JLabel("Product Stock :");
    this.stockLabel.setBounds(30,140,100,30);
    this.panel.add(stockLabel);
 
    this.stockTF= new JTextField();
    this.stockTF.setBounds(130,140,140,30);
    this.panel.add(stockTF);
	
	fileBtn = new JButton("Upload Image");
	fileBtn.setBounds(300,70,200,40);
	this.panel.add(fileBtn);
 
 
	this.addBtn=new JButton("Add");
	this.addBtn.setBounds(30,200,80,40);
	this.panel.add(addBtn);
 
    this.updateBtn=new JButton("Update");
	this.updateBtn.setBounds(130,200,80,40);
	this.panel.add(updateBtn);
 
    this.clearBtn=new JButton("Clean");
	this.clearBtn.setBounds(230,200,80,40);
	this.panel.add(clearBtn);
 
    this.backBtn=new JButton("Back");
	this.backBtn.setBounds(330,200,80,40);
	this.panel.add(backBtn);
 
    this.addDiscountBtn=new JButton("Add Discount");
	this.addDiscountBtn.setBounds(420,200,120,40);
	this.panel.add(addDiscountBtn);
 
   
	MedicinesRepo prp=new MedicinesRepo();
	Medicines[] MedicinesList=prp.allMedicines();
	String rows[][]=new String[MedicinesList.length][5];
	for(int i=0;i<MedicinesList.length;i++)
	{
		if(MedicinesList[i]!=null)
		{
			rows[i][0]=MedicinesList[i].getId();
			rows[i][1]=MedicinesList[i].getName();
			rows[i][2]=String.valueOf(MedicinesList[i].getPrice());
			rows[i][3]=String.valueOf(MedicinesList[i].getStock());
			rows[i][4]=MedicinesList[i].getImagepath();
		}

	}
	
	String head1[]={"MedicinesId","Name","Price","Stock","ImagePath"};
	this.MedicinesTable=new JTable(rows,head1);
	
	this.MedicinesTableSP=new JScrollPane(MedicinesTable);
	this.MedicinesTableSP.setBounds(20,280,560,350);
	this.MedicinesTable.setEnabled(false);
	this.panel.add(MedicinesTableSP);
 
 
    this.add(panel);
    addBtn.addActionListener(this);
    fileBtn.addActionListener(this);
    clearBtn.addActionListener(this);
    addDiscountBtn.addActionListener(this);
    backBtn.addActionListener(this);
	this.setVisible(true);
	this.us=us;
   }
   public void actionPerformed(ActionEvent e) 
   {
    if (e.getSource() == addBtn) {
		
		if((!productIdTF.getText().isEmpty()) && (!productNameTF.getText().isEmpty()) && (!priceTF.getText().isEmpty()) && (!stockTF.getText().isEmpty()))
		{
			
			try
			{
				id = productIdTF.getText();
				name = productNameTF.getText();
				price = Integer.parseInt(priceTF.getText());
				stock = Integer.parseInt(stockTF.getText());
				
				MedicinesRepo arp=new MedicinesRepo();
				
				Medicines em=new Medicines(id,name,price,stock,path);
				arp.addMedicines(em);
				JOptionPane.showMessageDialog(this,"Added Successfully");
				
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(this,"provide valid Path");
			}
	
		}
		else
		{
			JOptionPane.showMessageDialog(this,"please fill up all the field properly");
		}
    }
	if(e.getSource()==clearBtn)
	{
		productIdTF.setText(mediId);
		productNameTF.setText("");
		priceTF.setText("");
		stockTF.setText("");
	}
	if(e.getSource()==fileBtn){
		JFileChooser filecho = new JFileChooser();
		
		int res = filecho.showSaveDialog(null);  

		if (res==JFileChooser.APPROVE_OPTION)  
		{  
			path = filecho.getSelectedFile().getAbsolutePath();
		}
	}
	if(e.getSource()==backBtn){
		new OwnerPage(us);
		dispose();
	}
	if(e.getSource()==addDiscountBtn){
		new AddDiscount(us);
		dispose();
	}
}
 

}