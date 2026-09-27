package interfaces;
import entities.*;
import interfaces.*;
import java.lang.*;

public interface IMedicinesRepo{
	void addMedicines(Medicines o);
	void removeMedicines(String key);
	void updateMedicines(Medicines o);
	Medicines searchById(String id);
	Medicines[] allMedicines();
}