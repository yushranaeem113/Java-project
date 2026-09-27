
package frame;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;

public class PaymentOption extends JFrame implements ActionListener
{
	
	private JPanel panel;
	private JLabel label,b1,b2,b3,numberL,amountL;
	private ImageIcon icon;
	private Font font14;
	private JRadioButton bkash,nagad,bank;
	private ButtonGroup group;
    private JTextField numberField,amountField;
    private JButton payButton;
 
 
    public PaymentOption(float total) {
 
    	
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
        ImageIcon bkashImage = new ImageIcon("images/bkash.png");
        b1.setIcon(bkashImage);
        b1.setBounds(100, 230, 100, 46);
        panel.add(b1);

        JLabel b2 = new JLabel();
        ImageIcon nagadImage = new ImageIcon("images/nagad.png");
        b2.setIcon(nagadImage);
        b2.setBounds(250, 230, 100, 65);
        panel.add(b2);

        JLabel b3 = new JLabel();
        ImageIcon bankImage = new ImageIcon("images/bank.png");
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
 
        String tt = Float.toString(total);
        amountField= new JTextField();
		amountField.setText(tt);
		amountField.setEditable(false);
        amountField.setBounds(100,450,250,40);
        panel.add(amountField);

 
        payButton= new JButton("Pay");
        payButton.setFont(font14);
        payButton.setBounds(240,520,100, 40);
        panel.add(payButton);

 
        
       
		payButton.addActionListener(this);
        
        }
 
	   public void actionPerformed(ActionEvent e) 
	    {
         if (e.getSource() == payButton)
        {
			bkash.setActionCommand("Bkash");
			nagad.setActionCommand("Nagad");
			bank.setActionCommand("Bank");
            String payOption = (group.getSelection().getActionCommand());
			String payNumber = numberField.getText();
			String amount = amountField.getText();
			if(payNumber.equals(""))
            {
				JOptionPane.showMessageDialog(this,"Enter Your Pyament Number");
			}
            else
            {
				JOptionPane.showMessageDialog(this,(("Your Payment Option: "+payOption+"\n")+("Your Account number: "+payNumber+"\n")+("Your Total amount: "+amount)));
			
			}
        } 
     }
}
 