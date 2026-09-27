package repository;
import java.lang.*;
import entities.*;
import interfaces.*;

public class OwnerRepo implements IOwnerRepo{
	public void addOwner(Owner u){
		Owner[] list = this.allOwner();
		for(int i=0; i<list.length; i++){
			if(list[i]==null){
				list[i]=u;
				break;
			}
		}
		this.write(list);
	}
	public void removeOwner(String key){
		Owner[] list = this.allOwner();
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
	public void updateOwner(Owner u){
		Owner[] list = this.allOwner();
		for(int i=0; i<100; i++){
			if(list[i].getId().equals(u.getId())){
				list[i]=u;
				break;
			}
		}
		this.write(list);
	}
	public Owner searchById(String id){
		Owner[] list = this.allOwner();
		for(int i=0; i<list.length; i++){
			if(list[i]!=null){
				if(list[i].getId().equals(id)){
					return list[i];
				}
			}
		}
		return null;
	}
	
	public Owner searchByUsername(String user){
		Owner[] list = this.allOwner();
		for(int i=0; i<list.length; i++){
			if(list[i]!=null){
				if(list[i].getUsername().equals(user)){
					return list[i];
				}
			}
		}
		return null;
	}
	
	public Owner[] allOwner(){
		FileIo fio = new FileIo();
		String[] data = fio.readData("repository/data/ownerData.txt");
		
		Owner u = new Owner();
		Owner[] list = new Owner[100];
		int i=0;
		for(String str:data){
			if(data[i]!=null){
				list[i]=u.fromOwner(str);
			}
			i++;
		}
		return list;
	}
	
	public void write(Owner[] list){
		String[] str = new String[100];
		for(int i=0; i<100; i++){
			if(list[i]!=null){
				str[i] = list[i].toStringOwner();
			}
		}
		FileIo fio = new FileIo();
		fio.writeData(str,"repository/data/ownerData.txt");
	}
}