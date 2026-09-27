package frame;
import entities.*;
import interfaces.*;
import repository.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class CustomerPaymentPage extends JFrame implements ActionListener
{
	
	private JPanel panel;
	private JLabel label,b1,b2,b3,numberL,amountL;
	private ImageIcon icon;
	private Font font14;
	private JRadioButton bkash,nagad,bank;
	private ButtonGroup group;
    private JTextField numberField,amountField;
    private JButton payButton;
	private User us;
 
 
    public CustomerPaymentPage(User us,int amount) {
 
    	
        this.setSize(600, 650);
        this.setTitle(" Customer-Payment-Page ");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        group =new ButtonGroup();

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,700,850);
        this.add(panel);
 
    	font14 = new Font("Arial",Font.BOLD,14);
 
        JLabel label = new JLabel();
        label.setText("Select Payment Option: ");
        label.setForeground(Color.black);
        label.setFont(font14);
        label.setBounds(200, 100, 300, 100);
        panel.add(label);

        bkash=new JRadioButton("Bkash");
        bkash.setFont(font14);
        bkash.setBounds(100,170, 100, 50);
        panel.add(bkash);
        
        nagad=new JRadioButton("Nagad");
        nagad.setFont(font14);
        nagad.setBounds(250, 170, 100, 50);
        panel.add(nagad);

        bank=new JRadioButton("Bank");
        bank.setFont(font14);
        bank.setBounds(400, 170, 100, 50);
        panel.add(bank);
        

        group.add(bkash);
        group.add(nagad);
        group.add(bank);


        
        JLabel b1 = new JLabel();
        ImageIcon bkashImage = new ImageIcon("frame/images/bkash.png");
        b1.setIcon(bkashImage);
        b1.setBounds(100, 230, 100, 46);
        panel.add(b1);

        JLabel b2 = new JLabel();
        ImageIcon nagadImage = new ImageIcon("frame/images/nagad.png");
        b2.setIcon(nagadImage);
        b2.setBounds(250, 230, 100, 65);
        panel.add(b2);

        JLabel b3 = new JLabel();
        ImageIcon bankImage = new ImageIcon("frame/images/bank.png");
        b3.setIcon(bankImage);
        b3.setBounds(400, 230, 100, 75);
        panel.add(b3);
        
        JLabel numberL = new JLabel();
        numberL.setText("Enter Bkash/Nagad/Bank Number : ");
        numberL.setFont(font14);
        numberL.setBounds(100, 290, 300,100);
        panel.add(numberL);

        
        numberField= new JTextField();
        numberField.setBounds(100,360,250,40);
        panel.add(numberField);

        JLabel amountL = new JLabel();
        amountL.setText("TOTAL AMOUNT : ");
        amountL.setFont(font14);
        amountL.setBounds(100,380,300,100);
        panel.add(amountL);
 
		String amt = amount+"";
        
        amountField= new JTextField();
		amountField.setText(amt);
		amountField.setEditable(false);
        amountField.setBounds(100,450,250,40);
        panel.add(amountField);

 
        payButton= new JButton("Pay");
        payButton.setFont(font14);
        payButton.setBounds(240,520,100, 40);
        panel.add(payButton);
       
		payButton.addActionListener(this);
        this.us=us;
        }
 
	   public void actionPerformed(ActionEvent e) 
	    {
         if (e.getSource() == payButton)
        {
			try{
				bkash.setActionCommand("Bkash");
				nagad.setActionCommand("Nagad");
				bank.setActionCommand("Bank");
				String payOption = (group.getSelection().getActionCommand());
				String payNumber = numberField.getText();
				String Tamount = amountField.getText();
				if(numberField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(this,"Fill the payment number field!");
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Your payment is complete");
					
					Date date = new Date();
					SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");
					String dt = dateformat.format(date);
					
					
					CustomersRepo repo = new CustomersRepo();
					Customers c = repo.searchById(us.getId());
					
					int oldAmt = c.getTotalAmount();
					int reAmt = Integer.parseInt(Tamount);
					int newAmt = (oldAmt+reAmt);
					
					
					
					c.setId(us.getId());
					c.setTotalAmount(newAmt);
					repo.updateCustomers(c);
					
					FileIo fio = new FileIo();
					String payId = fio.lineCountPayment("repository/data/payments.txt");
					
					Payment p = new Payment(payId,c.getId(),reAmt,dt);
					PaymentRepo payRep = new PaymentRepo();
					payRep.addPayment(p);
					
					
					String orderId = fio.lineCountOrder("repository/data/orderData.txt");
					Order order = new Order(orderId,c.getId(),reAmt,payOption,payNumber);
					OrderRepo orderRepo = new OrderRepo();
					orderRepo.addOrder(order);
					
					
					dispose();
				}
				
			}
			catch(Exception a){
				JOptionPane.showMessageDialog(this,"Submit a valid number!");
			}
        } 
     }
}
 