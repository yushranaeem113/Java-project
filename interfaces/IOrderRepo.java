package interfaces;
import entities.*;
import interfaces.*;
import java.lang.*;

public interface IOrderRepo{
	void addOrder(Order o);
	void removeOrder(String key);
	void updateOrder(Order o);
	Order searchById(String id);
	Order[] allOrder();
}