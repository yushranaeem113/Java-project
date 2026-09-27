package frame;
 
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import entities.*;
import repository.*;
import interfaces.*;
 
public class MedicineList extends JFrame implements ActionListener
{
	private JButton backBtn;
	private JTable MedicinesTable;
	private JScrollPane MedicinesTableSP;
	private JPanel panel;
	private User u;

	public MedicineList(User u)
	{
		
		super("AllMedicines List");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.panel=new JPanel();
		this.panel.setLayout(null);

		this.backBtn=new JButton("back");
		this.backBtn.setBounds(100,50,100,50);
		this.backBtn.addActionListener(this);
		this.panel.add(backBtn);
		
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
		this.MedicinesTableSP.setBounds(50,110,700,450);
		this.MedicinesTable.setEnabled(false);
		this.panel.add(MedicinesTableSP);
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
			EmployeePage ap=new EmployeePage(u);
			dispose();
		}
	}
}