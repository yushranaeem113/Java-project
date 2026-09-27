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

public class ForgetPass extends JFrame implements ActionListener{
	private JPanel mainP,forgetImage,forgetSide;
	private JLabel idL,userL,ansL,quesL,resetL,logo,imL,forgetL;
	private JTextField idF,userF,ansF;
	private JButton resetB,backB,findUser;
	private Font font12,font14,font16,font25;
	private ImageIcon bg;
	
	public ForgetPass(){
		bg = new ImageIcon("frame/images/forget.png");
		
		font25 = new Font("Arial", Font.BOLD, 25);
		font16 = new Font("Arial", Font.BOLD, 16);
		font14 = new Font("Arial", Font.BOLD, 14);
		font12 = new Font("Arial", Font.BOLD, 12);
		
		this.setSize(660,510);
		this.setTitle("Forget Password?");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainP = new JPanel();
		mainP.setLayout(null);
		mainP.setBackground(Color.gray);
		mainP.setBounds(0,0,660,510);
		
		forgetImage = new JPanel();
		forgetImage.setLayout(null);
		forgetImage.setBounds(0,0,350,510);
		mainP.add(forgetImage);
		
		imL = new JLabel(bg);
		imL.setLayout(null);
		imL.setBounds(0,0,bg.getIconWidth(),510);
		forgetImage.add(imL);
		
		forgetSide = new JPanel();
		forgetSide.setLayout(null);
		forgetSide.setBounds(350,0,310,510);
		mainP.add(forgetSide);
		
		forgetL = new JLabel("Forget");
		forgetL.setBounds(30,55,100,20);
		forgetL.setFont(font16);
		forgetSide.add(forgetL);
		
		resetL = new JLabel("Password??");
		resetL.setBounds(30,80,150,30);
		resetL.setFont(font25);
		forgetSide.add(resetL);
		
		idL = new JLabel("ID: ");
		idL.setBounds(30,120,100,30);
		idL.setFont(font14);
		forgetSide.add(idL);
		
		idF = new JTextField();
		idF.setBounds(110,120,130,30);
		idF.setBorder(BorderFactory.createLineBorder(null));
		idF.setFont(font14);
		forgetSide.add(idF);
		
		userL = new JLabel("UserName: ");
		userL.setBounds(30,160,100,30);
		userL.setFont(font14);
		forgetSide.add(userL);
		
		userF = new JTextField();
		userF.setBounds(110,160,130,30);
		userF.setBorder(BorderFactory.createLineBorder(null));
		userF.setFont(font14);
		forgetSide.add(userF);
		
		findUser = new JButton("Find User");
		findUser.setBounds(110,200,130,30);
		findUser.setBackground(new Color(0xFF3131));
		findUser.setForeground(Color.white);
		findUser.setFont(font14);
		findUser.setVisible(true);
		forgetSide.add(findUser);
		
		quesL = new JLabel("Who is your favorite person?");
		quesL.setBounds(30,240,300,30);
		quesL.setFont(font14);
		forgetSide.add(quesL);
		
		ansL = new JLabel("Answer: ");
		ansL.setBounds(30,280,100,30);
		ansL.setFont(font14);
		forgetSide.add(ansL);
		
		ansF = new JTextField();
		ansF.setBounds(110,280,130,30);
		ansF.setBorder(BorderFactory.createLineBorder(null));
		ansF.setFont(font14);
		ansF.setEditable(false);
		forgetSide.add(ansF);
		
		
		
		backB = new JButton("Back");
		backB.setBounds(30,320,115,40);
		backB.setBackground(new Color(0xFF3131));
		backB.setForeground(Color.white);
		backB.setFont(font14);
		backB.setBorder(BorderFactory.createLineBorder(null));
		forgetSide.add(backB);
		
		resetB = new JButton("Password");
		resetB.setBounds(155,320,115,40);
		resetB.setBackground(new Color(0xFF3131));
		resetB.setForeground(Color.white);
		resetB.setFont(font14);
		resetB.setBorder(BorderFactory.createLineBorder(null));
		forgetSide.add(resetB);
		
		backB.addActionListener(this);
		findUser.addActionListener(this);
		resetB.addActionListener(this);
		
		
		this.add(mainP);
		this.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==backB){
			new Login();
			dispose();
		}
		if(e.getSource()==findUser){
			if((!userF.getText().isEmpty()) && (!idF.getText().isEmpty())){
				String username = userF.getText();
				UserRepo repo = new UserRepo();
				if(repo.searchByUsername(username)){
					ansF.setEditable(true);
					userF.setEditable(false);
					findUser.setEnabled(false);
				}else{
					JOptionPane.showMessageDialog(this,"Invalid Username");
				}
			}else{
				JOptionPane.showMessageDialog(this,"Fill the field!");
			}
		}
		if(e.getSource()==resetB){
			String username = userF.getText();
			String id = idF.getText();
			String ans = ansF.getText();
			UserRepo repo = new UserRepo();
			User u = repo.searchById(id);
			
			if(!ansF.getText().isEmpty()){
				if(ans.equals(u.getQuesAns())){
					JOptionPane.showMessageDialog(this,"Your Password is: "+u.getPassword());
				}else{
					JOptionPane.showMessageDialog(this,"Wrong security answer!");
				}
			}else{
				JOptionPane.showMessageDialog(this,"Fill the field!");
			}
		}
	}
}