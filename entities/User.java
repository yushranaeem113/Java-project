package entities;
import java.lang.*;

public class User{
	protected String id,name,username,email,number,password,quesAns,role,address,status,blockReason;

	public User(){}
	public User(String id,String name,String username,String quesAns,String password,String role,String status,String blockReason,String email,String number,String address){
		this.id=id;
		this.name=name;
		this.username=username;
		this.status=status;
		this.email=email;
		this.number=number;
		this.password=password;
		this.quesAns=quesAns;
		this.role=role;
		this.address=address;
		this.blockReason=blockReason;
	}
	public void setId(String id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setUsername(String username){
		this.username=username;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public void setNumber(String number){
		this.number=number;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public void setQuesAns(String quesAns){
		this.quesAns=quesAns;
	}
	public void setRole(String role){
		this.role=role;
	}
	public void setAddress(String address){
		this.address=address;
	}
	public void setBlockReason(String blockReason){
		this.blockReason=blockReason;
	}
	
	public String getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public String getUsername(){
		return this.username;
	}
	public String getStatus(){
		return this.status;
	}
	public String getEmail(){
		return this.email;
	}
	public String getNumber(){
		return this.number;
	}
	public String getPassword(){
		return this.password;
	}
	public String getQuesAns(){
		return this.quesAns;
	}
	public String getRole(){
		return this.role;
	}
	public String getAddress(){
		return this.address;
	}
	public String getBlockReason(){
		return this.blockReason;
	}
	
	public String toStringUser(){
		String str = (this.id+","+this.name+","+this.username+","+this.quesAns+","+this.password+","+this.role+","+this.status+","+this.blockReason+"\n");
		return str;
	}
	
	public User fromUser(String str){
		String data[] = str.split(",");
		
		User u= new User();
		
		u.setId(data[0]);
		u.setName(data[1]);
		u.setUsername(data[2]);
		u.setQuesAns(data[3]);
		u.setPassword(data[4]);
		u.setRole(data[5]);
		u.setStatus(data[6]);
		u.setBlockReason(data[7]);
		
		return u;
	}
}