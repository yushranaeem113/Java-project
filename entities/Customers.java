package entities;
import java.lang.*;

public class Customers extends User{
	int totalAmount;
	
	public Customers(){}
	public Customers(String id,String name,String username,String quesAns,String password,String role,String status,String blockReason,String email,String number,String address,int totalAmount){
		super(id,name,username,quesAns,password,role,status,blockReason,email,number,address);
		this.totalAmount=totalAmount;
	}
	
	public void setTotalAmount(int totalAmount){
		this.totalAmount=totalAmount;
	}
	
	public int getTotalAmount(){
		return this.totalAmount;
	}
	
	
	public String toStringCustomers(){
		String str = (this.id+","+this.name+","+this.username+","+this.quesAns+","+this.password+","+this.role+","+this.status+","+this.blockReason+","+this.email+","+this.number+","+this.address+","+this.totalAmount+"\n");
		return str;
	}
	
	public Customers fromCustomers(String str){
		String data[] = str.split(",");
		
		Customers e= new Customers();
		
		e.setId(data[0]);
		e.setName(data[1]);
		e.setUsername(data[2]);
		e.setQuesAns(data[3]);
		e.setPassword(data[4]);
		e.setRole(data[5]);
		e.setStatus(data[6]);
		e.setBlockReason(data[7]);
		e.setEmail(data[8]);
		e.setNumber(data[9]);
		e.setAddress(data[10]);
		e.setTotalAmount(Integer.parseInt(data[11]));
		
		return e;
	}
}