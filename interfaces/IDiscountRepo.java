package interfaces;
import entities.*;
import interfaces.*;
import java.lang.*;

public interface IDiscountRepo{
	void addDiscount(Discount u);
	void removeDiscount(String key);
	void updateDiscount(Discount u);
	Discount searchById(String id);
	Discount[] allDiscount();
}