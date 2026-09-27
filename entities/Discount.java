package entities;
import java.lang.*;
 
public class Discount
 
{
   private String id,code;
   private double parcentage;
   public Discount()
   {
   }
   public Discount(String id,String code,double parcentage)
   {
    this.id=id;
    this.code=code;
    this.parcentage=parcentage; 
   }
 
   public void setId(String id)
   {
    this.id=id;
   }
   public void setCode(String code)
   {
    this.code=code;
 
   }
   public void setParcentage(double parcentage)
   {
    this.parcentage=parcentage;
   }
   public String getId()
   {
    return this.id;
   }
   public String getCode()
   {
    return this.code;
   }
   public double getParcentage()
   {
    return this.parcentage;
   }
   
   public String toStringDiscount()
   {
    String str=this.id+","+this.code+","+this.parcentage+"\n";
    return str;
 
   }
   public Discount fromDiscount(String str)
   {
    String [] info=str.split(",");
    Discount p=new Discount();
    p.setId(info[0]);
    p.setCode(info[1]);
    p.setParcentage(Double.parseDouble(info[2]));
 
    return p;
	}
  }