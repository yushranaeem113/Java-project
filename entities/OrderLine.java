package entities;
import java.lang.*;

public class OrderLine{
	private String id,orderid,medicineid;
	private int quantity;
	private int amount;
	
	public OrderLine(){}
	public OrderLine(String id,String orderid,String medicineid,int quantity,int amount){
		this.id=id;
		this.orderid=orderid;
		this.medicineid=medicineid;
		this.quantity=quantity;
		this.amount=amount;
	}
	
	public void setId(String id){
		this.id=id;
	}
	public void setOrderId(String orderid){
		this.orderid=orderid;
	}
	public void setMedicineId(String medicineid){
		this.medicineid=medicineid;
	}
	public void setQuantity(int quantity){
		this.quantity=quantity;
	}
	public void setAmount(int amount){
		this.amount=amount;
	}


	public String getId(){
		return this.id;
	}
	public String getOrderId(){
		return this.orderid;
	}
	public String getMedicineId(){
		return this.medicineid;
	}
	public int getQuantity(){
		return this.quantity;
	}
	public int getAmount(){
		return this.amount;
	}
	
	public String toStringOrderLine(){
		String str = this.id+","+this.orderid+","+this.medicineid+","+this.quantity+","+this.amount+"\n";
		return str;
	}
	
	public OrderLine fromOrderLine(String str){
		String data[] = str.split(",");
		
		OrderLine m= new OrderLine();
		
		m.setId(data[0]);
		m.setOrderId(data[1]);
		m.setMedicineId(data[2]);
		m.setQuantity(Integer.parseInt(data[3]));
		m.setAmount(Integer.parseInt(data[4]));
		
		return m;
	}
}