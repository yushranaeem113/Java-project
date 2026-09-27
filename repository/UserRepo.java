package repository;
import entities.*;
import interfaces.*;
import frame.*;
import java.lang.*;

public class UserRepo implements IUserRepo{
	public void addUser(User u){
		User[] list = this.allUser();
		for(int i=0; i<list.length; i++){
			if(list[i]==null){
				list[i]=u;
				break;
			}
		}
		this.write(list);
	}
	public void removeUser(String key){
		User[] list = this.allUser();
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
	public void updateUser(User u){
		User[] list = this.allUser();
		for(int i=0; i<100; i++){
			if(list[i].getId().equals(u.getId())){
				list[i]=u;
				break;
			}
		}
		this.write(list);
	}
	public User searchById(String id){
		User[] list = this.allUser();
		for(int i=0; i<list.length; i++){
			if(list[i]!=null){
				if(list[i].getId().equals(id)){
					return list[i];
				}
			}
		}
		return null;
	}
	
	public boolean searchByUsername(String user){
		User[] list = this.allUser();
		for(int i=0; i<list.length; i++){
			if(list[i]!=null){
				if(list[i].getUsername().equals(user)){
					return true;
				}
			}
		}
		return false;
	}
	
	public User[] allUser(){
		FileIo fio = new FileIo();
		String[] data = fio.readData("repository/data/userData.txt");
		
		User u = new User();
		User[] list = new User[100];
		int i=0;
		for(String str:data){
			if(data[i]!=null){
				list[i]=u.fromUser(str);
			}
			i++;
		}
		return list;
	}
	
	public void write(User[] list){
		String[] str = new String[100];
		for(int i=0; i<100; i++){
			if(list[i]!=null){
				str[i] = list[i].toStringUser();
			}
		}
		FileIo fio = new FileIo();
		fio.writeData(str,"repository/data/userData.txt");
	}
}