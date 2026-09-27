package entities;
import java.lang.*;

public class Medicines{
	private String id,name,imagepath;
	private int stock,price;
	
	public Medicines(){}
	public Medicines(String id,String name,int price,int stock,String imagepath){
		this.id=id;
		this.name=name;
		this.price=price;
		this.stock=stock;
		this.imagepath=imagepath;
	}
	
	public void setId(String id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}
	public void setPrice(int price){
		this.price=price;
	}
	public void setStock(int stock){
		this.stock=stock;
	}
	public void setImagepath(String imagepath){
		this.imagepath=imagepath;
	}
	
	public String getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	public int getPrice(){
		return this.price;
	}
	public int getStock(){
		return this.stock;
	}
	public String getImagepath(){
		return this.imagepath;
	}
	
	public String toStringMedicines(){
		String str = this.id+","+this.name+","+this.price+","+this.stock+","+this.imagepath+"\n";
		return str;
	}
	
	public Medicines fromMedicines(String str){
		String data[] = str.split(",");
		
		Medicines m= new Medicines();
		
		m.setId(data[0]);
		m.setName(data[1]);
		m.setPrice(Integer.parseInt(data[2]));
		m.setStock(Integer.parseInt(data[3]));
		m.setImagepath(data[4]);
		
		return m;
	}
}