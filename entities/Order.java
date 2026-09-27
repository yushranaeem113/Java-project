package entities;
import java.lang.*;

public class Order{
	private String id,customerId,paymentNum,payOption;
	private int totalAmt;
	
	public Order(){}
	public Order(String id,String customerId,int totalAmt,String payOption,String paymentNum){
		this.id=id;
		this.customerId=customerId;
		this.totalAmt=totalAmt;
		this.payOption=payOption;
		this.paymentNum=paymentNum;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setTotalAmt(int totalAmt) {
		this.totalAmt = totalAmt;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public void setPaymentOption(String payOption) {
		this.payOption = payOption;
	}
	public void setPaymentNum(String paymentNum) {
		this.paymentNum = paymentNum;
	}
	

	public String getId() {
		return this.id;
	}
	public int getTotalAmt() {
		return this.totalAmt;
	}
	public String getCustomerId() {
		return this.customerId;
	}
	public String getPaymentOption() {
		return this.payOption;
	}
	public String getPaymentNum() {
		return this.paymentNum;
	}
	
	public String toStringOrder(){
		String str = (this.id+","+this.customerId+","+this.totalAmt+","+this.payOption+","+this.paymentNum+"\n");
		return str;
	}
	
	public Order fromOrder(String str){
		String data[] = str.split(",");
		
		Order m= new Order();
		
		m.setId(data[0]);
		m.setCustomerId(data[1]);
		m.setTotalAmt(Integer.parseInt(data[2]));;
		m.setPaymentOption(data[3]);
		m.setPaymentNum(data[4]);
		
		return m;
	}
}