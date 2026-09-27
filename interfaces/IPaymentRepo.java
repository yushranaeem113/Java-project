package interfaces;
import entities.*;
import interfaces.*;
import java.lang.*;

public interface IPaymentRepo{
	void addPayment(Payment u);
	void removePayment(String key);
	void updatePayment(Payment u);
	Payment searchById(String id);
	Payment[] allPayment();
}