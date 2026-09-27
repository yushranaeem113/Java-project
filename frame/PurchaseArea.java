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
import java.io.*;
import java.nio.file.*;
import java.lang.*;

public class PurchaseArea extends JFrame implements ActionListener{
	private JLabel stockL,numberL,addressL,chagePass,showhideL,userFullNameL,usernameL,emailL,passwordL,userphoto,discountL,imL1,totalL,titleL,priceL1,price1,mediname1,mediLa1,qntL1;
	private JTextArea area;
	private JPasswordField passwordF,chagePassF;
	private JTextField totalF,discountF,userFullNameF,usernameF,emailF,numberF,addressF;
	private JButton saveDetailsB,btn1,clearB,paymentB,backB,discountB,doneB;
	private JPanel p1,mainP,titlePanel,medicinePanel,areaPanel,btnPanel,profilePanel,quantityPanel,im1;
	private JSpinner s1;
	private Font font20,font16,font14,font12,smallfont;
	private JScrollPane scroll;
	private int total;
	private int discount;
	private int cnt=1;
	private ImageIcon bg,icon,icon1;
	private User us;
	
	public PurchaseArea(User us){
		font20 = new Font("League Spartan", Font.BOLD, 20);
		font16 = new Font("League Spartan", Font.BOLD, 16);
		font14 = new Font("League Spartan", Font.BOLD, 14);
		font12 = new Font("League Spartan", Font.BOLD, 12);
		

		
		mainP = new JPanel();
		mainP.setLayout(null);
		mainP.setBackground(Color.gray);
		mainP.setBounds(0,0,1260,650);
		
		this.setSize(1260,650);
		this.setTitle("Purchase Medicine - PharmaCare");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titlePanel = new JPanel();
		titlePanel.setBounds(0,0,860,50);
		titlePanel.setBackground(Color.gray);
		titlePanel.setForeground(Color.white);
		titlePanel.setLayout(null);
		mainP.add(titlePanel);
		
		titleL = new JLabel("Medicine List");
		titleL.setBounds(180,0,860,50);
		titleL.setFont(font20);
		titleL.setForeground(Color.white);
		titlePanel.add(titleL);
		
		
		profilePanel = new JPanel();
		profilePanel.setBounds(0,30,170,590);
		profilePanel.setLayout(null);
		mainP.add(profilePanel);
		
		userFullNameL = new JLabel("User Full Name");
		userFullNameL.setBounds(20,40,130,20);
		profilePanel.add(userFullNameL);
		
		userFullNameF = new JTextField();
		userFullNameF.setBounds(20,65,130,30);
		userFullNameF.setText(us.getName());
		userFullNameF.setEditable(false);
		profilePanel.add(userFullNameF);
		
		usernameL = new JLabel("UserName");
		usernameL.setBounds(20,105,130,20);
		profilePanel.add(usernameL);
		
		usernameF = new JTextField();
		usernameF.setBounds(20,130,130,30);
		usernameF.setText(us.getUsername());
		usernameF.setEditable(false);
		profilePanel.add(usernameF);
		
		numberL = new JLabel("User Number");
		numberL.setBounds(20,170,130,20);
		profilePanel.add(numberL);
		
		numberF = new JTextField();
		numberF.setBounds(20,195,130,30);
		numberF.setText(us.getNumber());
		numberF.setEditable(false);
		profilePanel.add(numberF);
		
		addressL = new JLabel("Address");
		addressL.setBounds(20,235,130,20);
		profilePanel.add(addressL);
		
		addressF = new JTextField();
		addressF.setBounds(20,260,130,30);
		addressF.setText(us.getAddress());
		addressF.setEditable(false);
		profilePanel.add(addressF);
		
		
		emailL = new JLabel("User Email");
		emailL.setBounds(20,300,130,20);
		profilePanel.add(emailL);
		
		emailF = new JTextField();
		emailF.setBounds(20,325,130,30);
		emailF.setText(us.getEmail());
		emailF.setEditable(false);
		profilePanel.add(emailF);
		
		passwordL = new JLabel("Password");
		passwordL.setBounds(20,365,130,20);
		profilePanel.add(passwordL);
		
		passwordF = new JPasswordField();
		passwordF.setBounds(20,390,130,30);
		passwordF.setEchoChar((char)0);
		passwordF.setText(us.getPassword());
		passwordF.setEditable(false);
		profilePanel.add(passwordF);
		
		
		JPanel medicinePanel = new JPanel();
        medicinePanel.setLayout(null);
        medicinePanel.setBounds(170, 50, 705, 590);
        medicinePanel.setBackground(Color.pink);
        
        JScrollPane scrollPane = new JScrollPane(medicinePanel);
        scrollPane.setBounds(170, 50, 705, 590);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        mainP.add(scrollPane);

        try {
            BufferedReader reader = new BufferedReader(new FileReader("repository/data/products.txt"));
            String read;
            int x = 10, y = 10, cntpr = 0;
            Font font14 = new Font("Arial", Font.PLAIN, 14);

            while ((read = reader.readLine()) != null) {
                String[] data = read.split(",");
                ImageIcon bg1 = new ImageIcon(data[4]);
                Image napa = bg1.getImage().getScaledInstance(160, 100, Image.SCALE_SMOOTH);

                JPanel p1 = new JPanel();
                p1.setLayout(null);
                p1.setBounds(x, y, 160, 210);
                p1.setBackground(Color.white);
                medicinePanel.add(p1);

                JPanel im1 = new JPanel();
                im1.setLayout(null);
                im1.setBounds(0, 0, 160, 100);
                p1.add(im1);

                JLabel imL1 = new JLabel();
                imL1.setLayout(null);
                imL1.setBounds(0, 0, 160, 100);
                imL1.setIcon(new ImageIcon(napa));
                im1.add(imL1);

                JLabel mediLa1 = new JLabel("Medicine: ");
                mediLa1.setBounds(10, 105, 70, 20);
                p1.add(mediLa1);

                JLabel mediname1 = new JLabel(data[1]);
                mediname1.setBounds(75, 105, 90, 20);
                p1.add(mediname1);

                JLabel priceL1 = new JLabel("Price: ");
                priceL1.setBounds(10, 130, 75, 20);
                p1.add(priceL1);

                JLabel price1 = new JLabel(data[2]);
                price1.setBounds(75, 130, 75, 20);
                p1.add(price1);


                JButton btn1 = new JButton("Add");
                btn1.setBackground(new Color(0xf5785d));
                btn1.setForeground(Color.white);
                btn1.setFont(font14);
                btn1.setBorder(BorderFactory.createLineBorder(new Color(0x997d77), 2));
                btn1.setBounds(25, 155, 100, 30);
                p1.add(btn1);

                btn1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try{
							int stock = Integer.parseInt(data[3]);
                            int amt = Integer.parseInt(JOptionPane.showInputDialog(null, "Select Quantity: ", 1));

                            if (amt<=0) {
                                JOptionPane.showMessageDialog(null,data[1]+" Amount Must be positive!!");
                            } else if(amt>stock) {
                                JOptionPane.showMessageDialog(null,data[1]+" have limited stock!\nTotal Stock: "+stock);
                            } else {
								
                                int mainprice = Integer.parseInt(data[2]);
                                int price = amt * mainprice;
                                area.append("   "+ cnt+". "+data[1]+"\t     "+amt+ "\t"+price+"\n");
                                cnt++;
                                total += price;
                                totalF.setText(Integer.toString(total));
								
								int newStock = (stock-amt);
								
								
								MedicinesRepo mediRe = new MedicinesRepo();
								Medicines medi = mediRe.searchById(data[0]);
								medi.setStock(newStock);
								mediRe.updateMedicines(medi);
								
								FileIo fio = new FileIo();
								String orderId = fio.lineCountOrder("repository/data/orderData.txt");
								String orderLineId = fio.lineCountOrderLine("repository/data/orderLine.txt");
								
								OrderLine mdc = new OrderLine(orderLineId,data[0],orderId,amt,price);
								OrderLineRepo repo = new OrderLineRepo();
								repo.addOrderLine(mdc);
								
								medicinePanel.revalidate();
								medicinePanel.repaint();
								
                            }
                        }
						catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid input!");
                        }
                    }
                });

                cntpr++;
                x += 170;
                if (cntpr == 4) {
                    x = 10;
                    y += 220;
                    cntpr = 0;
                }
            }

            int panelHeight = y + 230;
            medicinePanel.setPreferredSize(new Dimension(800, panelHeight));
            medicinePanel.revalidate();
            medicinePanel.repaint();

        }catch (Exception e) {
            e.printStackTrace();
        }

		
		btnPanel = new JPanel();
		btnPanel.setLayout(null);
		btnPanel.setBounds(875,465,385,150);
		mainP.add(btnPanel);
		
		area = new JTextArea();
		area.setBounds(875,50,385,420);
		area.setEditable(false);
		area.setFont(font14);
		area.setText("\n   ------------------- Medicine Purchase List ------------------\n\n"+("   Medicine Name\tQuantity\tPrice(Tk)\n\n"));
		mainP.add(area);
		
		discountL = new JLabel("Cupon: ");
		discountL.setBounds(20,15,75,30);
		discountL.setFont(font16);
		btnPanel.add(discountL);
		
		discountF = new JTextField();
		discountF.setBounds(100,15,120,30);
		discountF.setBorder(BorderFactory.createLineBorder(null));
		discountF.setFont(font12);
		discountF.setHorizontalAlignment(JTextField.CENTER);
		discountF.setText("");
		btnPanel.add(discountF);
		
		discountB = new JButton("Claim");
		discountB.setBounds(230,15,90,30);
		btnPanel.add(discountB);
		
		totalL = new JLabel("Total: ");
		totalL.setBounds(20,50,75,30);
		totalL.setFont(font16);
		btnPanel.add(totalL);
		
		totalF = new JTextField();
		totalF.setBounds(100,50,120,30);
		totalF.setBorder(BorderFactory.createLineBorder(null));
		totalF.setHorizontalAlignment(JTextField.CENTER);
		totalF.setBackground(Color.white);
		totalF.setFont(font16);
		totalF.setEditable(false);
		totalF.setText("0.0");
		btnPanel.add(totalF);
		
		doneB = new JButton("Done");
		doneB.setBounds(50,90,90,50);
		doneB.setFont(font14);
		btnPanel.add(doneB);
		
		paymentB = new JButton("Pay");
		paymentB.setBounds(50,90,90,50);
		paymentB.setFont(font14);
		
		clearB = new JButton("Clear");
		clearB.setBounds(150,90,90,50);
		clearB.setFont(font14);
		btnPanel.add(clearB);
		
		backB = new JButton("Back");
		backB.setBounds(250,90,90,50);
		backB.setFont(font14);
		btnPanel.add(backB);
		
		this.add(mainP);
		this.setVisible(true);
		discountB.addActionListener(this);
		paymentB.addActionListener(this);
		clearB.addActionListener(this);
		doneB.addActionListener(this);
		backB.addActionListener(this);
		
		this.us=us;
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==discountB){
			if((!discountF.getText().isEmpty())){
				String coupon = discountF.getText();
				DiscountRepo repo = new DiscountRepo();
				Discount d = repo.searchByCode(coupon);
				if(d!=null){
					double par = (d.getParcentage())/100.0;
					
					discountF.setEditable(false);
					discountB.setEnabled(false);
					discount = (int)(total*par);
					String totalAm = Integer.toString(total-discount);
					totalF.setText(totalAm);
					JOptionPane.showMessageDialog(this,"Congratulations you got "+d.getParcentage()+"% discount.");
				}else{
					JOptionPane.showMessageDialog(this,"not valid code");
				}
				
			}else{
				JOptionPane.showMessageDialog(this,"Coupon code is wrong! Try Again");
			}
		}
		if(e.getSource()==doneB){
			btnPanel.add(paymentB);
			btnPanel.remove(doneB);
			area.append("\n   ------------------------------------------------------------------------\n\n"+"   Sub Total\t\t "+total+" Tk\n"+"   Discount\t\t "+discount+" Tk\n"+"   Total\t\t "+(total-discount)+" Tk\n\n"+"                 Thank for buy medicine, Happy day!");
		}
		if(e.getSource()==clearB){
			total = 0;
			discount =0;
			
			cnt =1;
			
			area.setText("   -------------------- Medicine Purchase List --------------------\n\n"+("   Medicine Name\t\tPrice(Tk)\n\n"));
			
			totalF.setText("0.0");
			
			btnPanel.add(doneB);
			btnPanel.remove(paymentB);
			
			discountB.setEnabled(true);
			discountF.setText("");
			discountF.setEditable(true);
		}else if(e.getSource()==paymentB){
			new CustomerPaymentPage(us,total-discount);
			total = 0;
			discount =0;
			
			cnt =1;
			
			area.setText("   -------------------- Medicine Purchase List --------------------\n\n"+("   Medicine Name\t\tPrice(Tk)\n\n"));
			
			totalF.setText("0");
			
			btnPanel.add(doneB);
			btnPanel.remove(paymentB);
			
			discountB.setEnabled(true);
			discountF.setText("");
			discountF.setEditable(true);
			
		}else if(e.getSource()==backB){
			new CustomerPage(us);
			dispose();
		}
		
	}
	
	
}