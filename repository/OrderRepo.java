package repository;
import java.lang.*;
import entities.*;
import interfaces.*;

public class OrderRepo implements IOrderRepo{
	public void addOrder(Order o){
		Order[] list = this.allOrder();
		for(int i=0; i<list.length; i++){
			if(list[i]==null){
				list[i]=o;
				break;
			}
		}
		this.write(list);
	}
	public void removeOrder(String key){
		Order[] list = this.allOrder();
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
	public void updateOrder(Order o){
		Order[] list = this.allOrder();
		for(int i=0; i<100; i++){
			if(list[i].getId().equals(o.getId())){
				list[i]=o;
				break;
			}
		}
		this.write(list);
	}
	public Order searchById(String id){
		Order[] list = this.allOrder();
		for(int i=0; i<100; i++){
			if(list[i].getId().equals(id)){
				return list[i];
			}
		}
		return null;
	}
	public Order[] allOrder(){
		FileIo fio = new FileIo();
		String[] data = fio.readData("repository/data/orderData.txt");
		
		Order o = new Order();
		Order[] list = new Order[100];
		int i=0;
		for(String str:data){
			if(data[i]!=null){
				list[i]=o.fromOrder(str);
			}
			i++;
		}
		return list;
	}
	
	public void write(Order[] list){
		String[] str = new String[100];
		for(int i=0; i<100; i++){
			if(list[i]!=null){
				str[i] = list[i].toStringOrder();
			}
		}
		FileIo fio = new FileIo();
		fio.writeData(str,"repository/data/orderData.txt");
	}
}