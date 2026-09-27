package interfaces;
import entities.*;
import interfaces.*;
import java.lang.*;

public interface IEmployeeRepo{
	void addEmployee(Employee u);
	void removeEmployee(String key);
	void updateEmployee(Employee u);
	Employee searchById(String id);
	Employee[] allEmployee();
}