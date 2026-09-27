package entities;
import java.lang.*;
 
public class Payment
 
{
   private String paymentId,userId,paymentDate;
   private float paidAmount;
   public Payment()
   {
   }
   public Payment(String paymentId,String userId,float paidAmount,String paymentDate)
   {
    this.paymentId=paymentId;
    this.userId=userId;
    this.paymentDate=paymentDate;
    this.paidAmount=paidAmount; 
   }
 
   public void setPaymentId(String paymentId)
   {
    this.paymentId=paymentId;
   }
   public void setUserId(String userId)
   {
    this.userId=userId;
 
   }
   public void setPaymentDate(String paymentDate)
   {
    this.paymentDate=paymentDate;
 
   }
   public void setPaidAmount(float paidAmount)
   {
    this.paidAmount=paidAmount;
   }
   public String getPaymentId()
   {
    return this.paymentId;
   }
   public String getUserId()
   {
    return this.userId;
   }
   public String getPaymentDate()
   {
    return this.paymentDate;
   }
   public float getPaidAmount()
   {
    return this.paidAmount;
   }
   public String toStringPayment()
   {
    String str=this.paymentId+","+this.userId+","+this.paidAmount+","+this.paymentDate+"\n";
    return str;
 
   }
   public Payment fromPayment(String str)
   {
    String [] info=str.split(",");
    Payment p=new Payment();
    p.setPaymentId(info[0]);
    p.setUserId(info[1]);
    p.setPaidAmount(Float.parseFloat(info[2]));
    p.setPaymentDate(info[3]);
 
    return p;
}
   }