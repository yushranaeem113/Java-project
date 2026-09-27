package frame;
 
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repository.*;
import interfaces.*;
 
public class AllPaymentList extends JFrame implements ActionListener
{
	private JButton backBtn;
	private JTable paymentTable;
	private JScrollPane paymentTableSP;
	private JPanel panel;
	private User u;

	public AllPaymentList(User u)
	{
		super(" All Payment Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel=new JPanel();
		this.panel.setLayout(null);
		this.setLocationRelativeTo(null);

		this.backBtn=new JButton("back");
		this.backBtn.setBounds(100,50,100,50);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		PaymentRepo prp=new PaymentRepo();
		Payment[] paymentList=prp.allPayment();
		String rows[][]=new String[paymentList.length][4];
		int j=0;
		for(int i=0;i<paymentList.length;i++)
		{
			if(paymentList[i]!=null)
			{
				if(u.getId().equals(paymentList[i].getUserId())){
					rows[j][0]=paymentList[i].getPaymentId();
					rows[j][1]=paymentList[i].getUserId();
					rows[j][2]=String.valueOf(paymentList[i].getPaidAmount());
					rows[j][3]=paymentList[i].getPaymentDate();
					j++;
				}
			}

		}
		
		String head1[]={"Payment id","User Id","Amount","Date"};
		this.paymentTable=new JTable(rows,head1);
		
		this.paymentTableSP=new JScrollPane(paymentTable);
		this.paymentTableSP.setBounds(50,110,700,450);
		this.paymentTable.setEnabled(false);
		this.panel.add(paymentTableSP);
		this.panel.revalidate();
		this.panel.repaint();
		this.add(panel);
		this.u=u;
		this.setVisible(true);


	}
	public void actionPerformed(ActionEvent ae)
	{
		String command=ae.getActionCommand();

		if(command.equals(backBtn.getText()))
		{
			CustomerPage ap=new CustomerPage(u);
			dispose();
		}
	}
}