package frame;
import entities.*;
import repository.*;
import interfaces.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
 
public class ViewAllPayment extends JFrame implements ActionListener
{
	private JButton backBtn;
	private JTable paymentTable;
	private JScrollPane paymentTableSP;
	private JPanel panel;
	private User u;
	
	public ViewAllPayment(User u)
	{
		
		
		super("All Payment Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.panel=new JPanel();
		this.panel.setLayout(null);

		this.backBtn=new JButton("back");
		this.backBtn.setBounds(100,50,100,50);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
		PaymentRepo prp=new PaymentRepo();
		Payment[] paymentList=prp.allPayment();
		String rows[][]=new String[paymentList.length][4];
		for(int i=0;i<paymentList.length;i++)
		{
			if(paymentList[i]!=null)
			{
				rows[i][0]=paymentList[i].getPaymentId();
				rows[i][1]=paymentList[i].getUserId();
				rows[i][2]=String.valueOf(paymentList[i].getPaidAmount());
				rows[i][3]=paymentList[i].getPaymentDate();
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
		this.setVisible(true);
		
		
		this.u=u;
		


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