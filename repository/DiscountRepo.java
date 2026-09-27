package repository;
import entities.*;
import interfaces.*;
import frame.*;
import java.lang.*;

public class DiscountRepo implements IDiscountRepo{
	public void addDiscount(Discount u){
		Discount[] list = this.allDiscount();
		for(int i=0; i<list.length; i++){
			if(list[i]==null){
				list[i]=u;
				break;
			}
		}
		this.write(list);
	}
	public void removeDiscount(String key){
		Discount[] list = this.allDiscount();
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
	public void updateDiscount(Discount u){
		Discount[] list = this.allDiscount();
		for(int i=0; i<100; i++){
			if(list[i].getId().equals(u.getId())){
				list[i]=u;
				break;
			}
		}
		this.write(list);
	}
	public Discount searchById(String id){
		Discount[] list = this.allDiscount();
		for(int i=0; i<list.length; i++){
			if(list[i]!=null){
				if(list[i].getId().equals(id)){
					return list[i];
				}
			}
		}
		return null;
	}
	
	public Discount searchByCode(String code){
		Discount[] list = this.allDiscount();
		for(int i=0; i<list.length; i++){
			if(list[i]!=null){
				if(list[i].getCode().equals(code)){
					return list[i];
				}
			}
		}
		return null;
	}
	
	public Discount[] allDiscount(){
		FileIo fio = new FileIo();
		String[] data = fio.readData("repository/data/discountCode.txt");
		
		Discount u = new Discount();
		Discount[] list = new Discount[100];
		int i=0;
		for(String str:data){
			if(data[i]!=null){
				list[i]=u.fromDiscount(str);
			}
			i++;
		}
		return list;
	}
	
	public void write(Discount[] list){
		String[] str = new String[100];
		for(int i=0; i<100; i++){
			if(list[i]!=null){
				str[i] = list[i].toStringDiscount();
			}
		}
		FileIo fio = new FileIo();
		fio.writeData(str,"repository/data/discountCode.txt");
	}
}