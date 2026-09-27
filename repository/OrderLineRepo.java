package repository;
import java.lang.*;
import entities.*;
import interfaces.*;

public class OrderLineRepo implements IOrderLineRepo{
	public void addOrderLine(OrderLine o){
		OrderLine[] list = this.allOrderLine();
		for(int i=0; i<list.length; i++){
			if(list[i]==null){
				list[i]=o;
				break;
			}
		}
		this.write(list);
	}
	public void removeOrderLine(String key){
		OrderLine[] list = this.allOrderLine();
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
	public void updateOrderLine(OrderLine o){
		OrderLine[] list = this.allOrderLine();
		for(int i=0; i<100; i++){
			if(list[i].getId().equals(o.getId())){
				list[i]=o;
				break;
			}
		}
		this.write(list);
	}
	public OrderLine searchById(String id){
		OrderLine[] list = this.allOrderLine();
		for(int i=0; i<100; i++){
			if(list[i].getId().equals(id)){
				return list[i];
			}
		}
		return null;
	}
	public OrderLine[] allOrderLine(){
		FileIo fio = new FileIo();
		String[] data = fio.readData("repository/data/orderLine.txt");
		
		OrderLine o = new OrderLine();
		OrderLine[] list = new OrderLine[100];
		int i=0;
		for(String str:data){
			if(data[i]!=null){
				list[i]=o.fromOrderLine(str);
			}
			i++;
		}
		return list;
	}
	
	public void write(OrderLine[] list){
		String[] str = new String[100];
		for(int i=0; i<100; i++){
			if(list[i]!=null){
				str[i] = list[i].toStringOrderLine();
			}
		}
		FileIo fio = new FileIo();
		fio.writeData(str,"repository/data/orderLine.txt");
	}
}