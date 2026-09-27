package frame;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repository.*;
import interfaces.*;
 
public class AllOrderList extends JFrame implements ActionListener
{
	private JButton backBtn;
	private JTable OrderTable;
	private JScrollPane OrderTableSP;
	private JPanel panel;
	private User u;

	public AllOrderList(User u)
	{
		super("All Order List");
		this.u=u;
		
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel=new JPanel();
		this.setLocationRelativeTo(null);
		this.panel.setLayout(null);

		this.backBtn=new JButton("back");
		this.backBtn.setBounds(100,50,100,50);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		OrderRepo prp=new OrderRepo();
		Order[] OrderList=prp.allOrder();
		String rows[][]=new String[OrderList.length][5];
		for(int i=0;i<OrderList.length;i++)
		{
			if(OrderList[i]!=null)
			{
				rows[i][0]=OrderList[i].getId();
				rows[i][1]=OrderList[i].getCustomerId();
				rows[i][2]=String.valueOf(OrderList[i].getTotalAmt());
				rows[i][3]=OrderList[i].getPaymentOption();
				rows[i][4]=OrderList[i].getPaymentNum();
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
			try{	
				EmployeeRepo emR = new EmployeeRepo();
				Employee employee = emR.searchById(u.getId());
			
				if(employee!=null){
					new EmployeePage(u);
					dispose();
				}else{
					new OwnerPage(u);
					dispose();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}