package repository;
import java.lang.*;
import entities.*;
import interfaces.*;

public class PaymentRepo implements IPaymentRepo{
	public void addPayment(Payment u){
		Payment[] list = this.allPayment();
		for(int i=0; i<list.length; i++){
			if(list[i]==null){
				list[i]=u;
				break;
			}
		}
		this.write(list);
	}
	public void removePayment(String key){
		Payment[] list = this.allPayment();
		for(int i=0; i<list.length; i++){
			if(list[i]!=null){
				if(list[i].getPaymentId().equals(key)){
					list[i]=null;
					break;
				}
			}
		}
		this.write(list);
	}
	public void updatePayment(Payment u){
		Payment[] list = this.allPayment();
		for(int i=0; i<100; i++){
			if(list[i].getPaymentId().equals(u.getPaymentId())){
				list[i]=u;
				break;
			}
		}
		this.write(list);
	}
	public Payment searchById(String id){
		Payment[] list = this.allPayment();
		for(int i=0; i<list.length; i++){
			if(list[i]!=null){
				if(list[i].getPaymentId().equals(id)){
					return list[i];
				}
			}
		}
		return null;
	}

	public Payment[] allPayment(){
		FileIo fio = new FileIo();
		String[] data = fio.readData("repository/data/payments.txt");
		
		Payment u = new Payment();
		Payment[] list = new Payment[100];
		int i=0;
		for(String str:data){
			if(data[i]!=null){
				list[i]=u.fromPayment(str);
			}
			i++;
		}
		return list;
	}
	
	public void write(Payment[] list){
		String[] str = new String[100];
		for(int i=0; i<100; i++){
			if(list[i]!=null){
				str[i] = list[i].toStringPayment();
			}
		}
		FileIo fio = new FileIo();
		fio.writeData(str,"repository/data/payments.txt");
	}
}