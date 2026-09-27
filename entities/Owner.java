package entities;
import java.lang.*;

public class Owner extends User{
	private double companySharePer;
	
	public Owner(){}
	public Owner(String id,String name,String username,String quesAns,String password,String role,String status,String blockReason,String email,String number,String address,double companySharePer){
		super(id,name,username,quesAns,password,role,status,blockReason,email,number,address);
		this.companySharePer=companySharePer;
	}
	
	public void setCompanySharePer(double companySharePer){
		this.companySharePer=companySharePer;
	}
	
	public double getCompanySharePer(){
		return this.companySharePer;
	}
	
	
	public String toStringOwner(){
		String str = (this.id+","+this.name+","+this.username+","+this.quesAns+","+this.password+","+this.role+","+this.status+","+this.blockReason+","+this.email+","+this.number+","+this.address+","+this.companySharePer+"\n");
		return str;
	}
	
	public Owner fromOwner(String str){
		String data[] = str.split(",");
		
		Owner o= new Owner();
		
		o.setId(data[0]);
		o.setName(data[1]);
		o.setUsername(data[2]);
		o.setQuesAns(data[3]);
		o.setPassword(data[4]);
		o.setRole(data[5]);
		o.setStatus(data[6]);
		o.setBlockReason(data[7]);
		o.setEmail(data[8]);
		o.setNumber(data[9]);
		o.setAddress(data[10]);
		o.setCompanySharePer(Double.parseDouble(data[11]));
		
		return o;
	}
}