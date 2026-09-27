//Tofayel Hossain
//23-51928-2

package frame;
import repository.*;
import entities.*;
import interfaces.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;

public class Login extends JFrame implements ActionListener, MouseListener{
	private JPanel mainP,loginImage,loginSide;
	private JLabel userL,passL,helloL,welcomeL,imL,logo,showhideL,forgetL;
	private JTextField userF;
	private JPasswordField passF;
	private JButton loginB,registerB;
	private Font font12,font14,font16,font25;
	private ImageIcon bg,icon,icon1;
	private Image show,hide;
	
	public Login(){
		bg = new ImageIcon("frame/images/login.png");
		icon = new ImageIcon("frame/icon/show.png");
        show = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		
		icon1 = new ImageIcon("frame/icon/hide.png");
        hide = icon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		
		font25 = new Font("Arial", Font.BOLD, 25);
		font16 = new Font("Arial", Font.BOLD, 16);
		font14 = new Font("Arial", Font.BOLD, 14);
		font12 = new Font("Arial", Font.BOLD, 12);
		
		this.setSize(660,420);
		this.setTitle("Login Page - PharmaCare");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainP = new JPanel();
		mainP.setLayout(null);
		mainP.setBackground(Color.gray);
		mainP.setBounds(0,0,660,580);
		
		loginImage = new JPanel();
		loginImage.setLayout(null);
		loginImage.setBounds(0,0,350,580);
		mainP.add(loginImage);
		
		imL = new JLabel(bg);
		imL.setLayout(null);
		imL.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		loginImage.add(imL);
		
		loginSide = new JPanel();
		loginSide.setLayout(null);
		loginSide.setBounds(350,0,310,580);
		mainP.add(loginSide);
		
		helloL = new JLabel("Hello,");
		helloL.setBounds(30,60,100,20);
		helloL.setFont(font16);
		loginSide.add(helloL);
		
		welcomeL = new JLabel("Welcome!");
		welcomeL.setBounds(30,90,150,30);
		welcomeL.setFont(font25);
		loginSide.add(welcomeL);
		
		userL = new JLabel("User : ");
		userL.setBounds(30,150,80,30);
		userL.setFont(font14);
		loginSide.add(userL);
		
		userF = new JTextField();
		userF.setBounds(110,150,120,30);
		userF.setBorder(BorderFactory.createLineBorder(null));
		userF.setFont(font14);
		loginSide.add(userF);
		
		passL = new JLabel("Password: ");
		passL.setBounds(30,190,80,30);
		passL.setFont(font14);
		loginSide.add(passL);
		
		passF = new JPasswordField();
		passF.setBounds(110,190,120,30);
		passF.setBorder(BorderFactory.createLineBorder(null));
		passF.setFont(font14);
		loginSide.add(passF);
		
		
		
		showhideL = new JLabel();
		showhideL.setLayout(null);
		showhideL.setBounds(235,190,30,30);
		showhideL.setIcon(new ImageIcon(hide));
		loginSide.add(showhideL);
		
		
		registerB = new JButton("Register");
		registerB.setBounds(30,240,115,40);
		registerB.setBackground(new Color(0xFF3131));
		registerB.setForeground(Color.white);
		registerB.setFont(font14);
		registerB.setBorder(BorderFactory.createLineBorder(null));
		loginSide.add(registerB);
		
		loginB = new JButton("Login");
		loginB.setBounds(155,240,115,40);
		loginB.setBackground(new Color(0xFF3131));
		loginB.setForeground(Color.white);
		loginB.setFont(font14);
		loginB.setBorder(BorderFactory.createLineBorder(null));
		loginSide.add(loginB);
		
		
		forgetL = new JLabel("Forget Password?");
		forgetL.setForeground(Color.red);
		forgetL.setBounds(95,290,120,30);
		loginSide.add(forgetL);
		
		
		registerB.addActionListener(this);
		loginB.addActionListener(this);
		showhideL.addMouseListener(this);
		forgetL.addMouseListener(this);
		this.add(mainP);
		this.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==registerB){
			FileIo fio = new FileIo();
			String f =fio.lineCountCustomer("repository/data/customerDetails.txt");
			new Register(f);
			dispose();
		}
		if(e.getSource()==loginB){
			String userId = userF.getText();
			String password = passF.getText();
			if(userId.equals("") && password.equals("")){
				JOptionPane.showMessageDialog(this,"First submit your detaiils!");
			}else{
				UserRepo userRep = new UserRepo();
				User u = userRep.searchById(userId);
				
				if(u!=null){
					if(u.getId().equals(userId) && u.getPassword().equals(password)){
						if(u.getStatus().equals("unblocked")){
							if(u.getRole().equals("admin")){	
								new OwnerPage(u);
								this.dispose();
							}else if(u.getRole().equals("employee")){
								new EmployeePage(u);
								this.dispose();
							}else if(u.getRole().equals("customer")){
								new CustomerPage(u);
								this.dispose();
							}
						}else{
							JOptionPane.showMessageDialog(this,"Your account is blocked by admin!\nReason: "+u.getBlockReason());
						}
					}else{
						JOptionPane.showMessageDialog(this,"Wrong userid and password!");
					}
				}else{
					JOptionPane.showMessageDialog(this,"Wrong user detaiils!");
				}
			}
		}
	}
	public void mouseClicked(MouseEvent e) {
        if(e.getSource()==forgetL){
			new ForgetPass();
			dispose();
		}
    }

    public void mousePressed(MouseEvent e) {
		if(e.getSource()==showhideL){
			showhideL.setIcon(new ImageIcon(show));
			passF.setEchoChar((char)0);
		}
    }

    public void mouseReleased(MouseEvent e) {
        if(e.getSource()==showhideL){
			showhideL.setIcon(new ImageIcon(hide));
			passF.setEchoChar('*');
		}
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}
