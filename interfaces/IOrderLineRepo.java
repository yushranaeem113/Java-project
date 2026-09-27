package interfaces;
import entities.*;
import interfaces.*;
import java.lang.*;

public interface IOrderLineRepo{
	void addOrderLine(OrderLine o);
	void removeOrderLine(String key);
	void updateOrderLine(OrderLine o);
	OrderLine searchById(String id);
	OrderLine[] allOrderLine();
}