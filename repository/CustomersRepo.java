package repository;
import java.lang.*;
import entities.*;
import interfaces.*;

public class CustomersRepo implements ICustomersRepo{
	public void addCustomers(Customers u){
		Customers[] list = this.allCustomers();
		for(int i=0; i<list.length; i++){
			if(list[i]==null){
				list[i]=u;
				break;
			}
		}
		this.write(list);
	}
	public void removeCustomers(String key){
		Customers[] list = this.allCustomers();
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
	public void updateCustomers(Customers u){
		Customers[] list = this.allCustomers();
		for(int i=0; i<100; i++){
			if(list[i].getId().equals(u.getId())){
				list[i]=u;
				break;
			}
		}
		this.write(list);
	}
	public Customers searchById(String id){
		Customers[] list = this.allCustomers();
		for(int i=0; i<list.length; i++){
			if(list[i]!=null){
				if(list[i].getId().equals(id)){
					return list[i];
				}
			}
		}
		return null;
	}
	public Customers searchByUsername(String user){
		Customers[] list = this.allCustomers();
		for(int i=0; i<list.length; i++){
			if(list[i]!=null){
				if(list[i].getUsername().equals(user)){
					return list[i];
				}
			}
		}
		return null;
	}
	public Customers[] allCustomers(){
		FileIo fio = new FileIo();
		String[] data = fio.readData("repository/data/customerDetails.txt");
		
		Customers u = new Customers();
		Customers[] list = new Customers[100];
		int i=0;
		for(String str:data){
			if(data[i]!=null){
				list[i]=u.fromCustomers(str);
			}
			i++;
		}
		return list;
	}
	
	public void write(Customers[] list){
		String[] str = new String[100];
		for(int i=0; i<100; i++){
			if(list[i]!=null){
				str[i] = list[i].toStringCustomers();
			}
		}
		FileIo fio = new FileIo();
		fio.writeData(str,"repository/data/customerDetails.txt");
	}
}