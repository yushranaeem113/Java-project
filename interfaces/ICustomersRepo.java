package interfaces;
import entities.*;
import interfaces.*;
import java.lang.*;

public interface ICustomersRepo{
	void addCustomers(Customers u);
	void removeCustomers(String key);
	void updateCustomers(Customers u);
	Customers searchById(String id);
	Customers[] allCustomers();
}