package interfaces;
import entities.*;
import interfaces.*;
import java.lang.*;

public interface IUserRepo{
	void addUser(User u);
	void removeUser(String key);
	void updateUser(User u);
	User searchById(String id);
	User[] allUser();
}