package frame;
 
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repository.*;
import interfaces.*;
 
public class OrderListView extends JFrame implements ActionListener
{
	private JButton backBtn;
	private JTable OrderTable;
	private JScrollPane OrderTableSP;
	private JPanel panel;
	private User u;

	public OrderListView(User u)
	{
		
		super("Self Order List");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.panel=new JPanel();
		this.panel.setLayout(null);
		
		
		this.u=u;

		this.backBtn=new JButton("back");
		this.backBtn.setBounds(100,50,100,50);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		OrderRepo prp=new OrderRepo();
		Order[] OrderList=prp.allOrder();
		String rows[][]=new String[OrderList.length][5];
		int j=0;
		for(int i=0;i<OrderList.length;i++)
		{
			if(OrderList[i]!=null)
			{
				if(u.getId().equals(OrderList[i].getCustomerId())){
					rows[j][0]=OrderList[i].getId();
					rows[j][1]=OrderList[i].getCustomerId();
					rows[j][2]=String.valueOf(OrderList[i].getTotalAmt());
					rows[j][3]=OrderList[i].getPaymentOption();
					rows[j][4]=OrderList[i].getPaymentNum();
					j++;
				}
			}

		}
		
		String head1[]={"OrderId","CustomerId","Amount","PaymentOption","PaymentNumber"};
		this.OrderTable=new JTable(rows,head1);
		
		this.OrderTableSP=new JScrollPane(OrderTable);
		this.OrderTableSP.setBounds(50,110,700,450);
		this.OrderTable.setEnabled(false);
		this.panel.add(OrderTableSP);
		this.panel.revalidate();
		this.panel.repaint();
		this.add(panel);
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