package repository;
import java.lang.*;
import entities.*;
import interfaces.*;

public class EmployeeRepo implements IEmployeeRepo{
	public void addEmployee(Employee u){
		Employee[] list = this.allEmployee();
		for(int i=0; i<list.length; i++){
			if(list[i]==null){
				list[i]=u;
				break;
			}
		}
		this.write(list);
	}
	public void removeEmployee(String key){
		Employee[] list = this.allEmployee();
		for(int i=0; i<list.length; i++){
			if(list[i]!=null){
				if(list[i].getId().equals(key)){
					list[i]=null;
					break;
				}
			}
		}
		this.write(list);
	}
	public void updateEmployee(Employee u){
		Employee[] list = this.allEmployee();
		for(int i=0; i<100; i++){
			if(list[i].getId().equals(u.getId())){
				list[i]=u;
				break;
			}
		}
		this.write(list);
	}
	public Employee searchById(String id){
		Employee[] list = this.allEmployee();
		for(int i=0; i<list.length; i++){
			if(list[i]!=null){
				if(list[i].getId().equals(id)){
					return list[i];
				}
			}
		}
		return null;
	}
	
	public Employee searchByUsername(String user){
		Employee[] list = this.allEmployee();
		for(int i=0; i<list.length; i++){
			if(list[i]!=null){
				if(list[i].getUsername().equals(user)){
					return list[i];
				}
			}
		}
		return null;
	}
	
	public Employee[] allEmployee(){
		FileIo fio = new FileIo();
		String[] data = fio.readData("repository/data/employeeDetails.txt");
		
		Employee u = new Employee();
		Employee[] list = new Employee[100];
		int i=0;
		for(String str:data){
			if(data[i]!=null){
				list[i]=u.fromEmployee(str);
			}
			i++;
		}
		return list;
	}
	
	public void write(Employee[] list){
		String[] str = new String[100];
		for(int i=0; i<100; i++){
			if(list[i]!=null){
				str[i] = list[i].toStringEmployee();
			}
		}
		FileIo fio = new FileIo();
		fio.writeData(str,"repository/data/employeeDetails.txt");
	}
}