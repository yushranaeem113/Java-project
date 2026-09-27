package entities;
import java.lang.*;

public class Employee extends User{
	int salary;
	
	public Employee(){}
	public Employee(String id,String name,String username,String quesAns,String password,String role,String status,String blockReason,String email,String number,String address,int salary){
		super(id,name,username,quesAns,password,role,status,blockReason,email,number,address);
		this.salary=salary;
	}
	
	public void setSalary(int salary){
		this.salary=salary;
	}
	
	public int getSalary(){
		return this.salary;
	}
	
	
	public String toStringEmployee(){
		String str = (this.id+","+this.name+","+this.username+","+this.quesAns+","+this.password+","+this.role+","+this.status+","+this.blockReason+","+this.email+","+this.number+","+this.address+","+this.salary+"\n");
		return str;
	}
	
	public Employee fromEmployee(String str){
		String data[] = str.split(",");
		
		Employee e= new Employee();
		
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
		e.setSalary(Integer.parseInt(data[11]));
		
		return e;
	}
}