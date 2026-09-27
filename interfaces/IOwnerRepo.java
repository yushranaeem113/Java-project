package interfaces;
import entities.*;
import interfaces.*;
import java.lang.*;

public interface IOwnerRepo{
	void addOwner(Owner o);
	void removeOwner(String key);
	void updateOwner(Owner o);
	Owner searchById(String id);
	Owner[] allOwner();
}