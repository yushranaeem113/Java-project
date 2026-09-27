package repository;
import java.lang.*;
import entities.*;
import interfaces.*;

public class MedicinesRepo implements IMedicinesRepo{
	public void addMedicines(Medicines o){
		Medicines[] list = this.allMedicines();
		for(int i=0; i<list.length; i++){
			if(list[i]==null){
				list[i]=o;
				break;
			}
		}
		this.write(list);
	}
	public void removeMedicines(String key){
		Medicines[] list = this.allMedicines();
		for(int i=0; i<list.length; i++){
			if(list[i]!=null){
				if(list[i].getId().equals(key)){
					list[i]=null;
					break;
				}
			}
		}
		this.write(list);
	}
	public void updateMedicines(Medicines o){
		Medicines[] list = this.allMedicines();
		for(int i=0; i<100; i++){
			if(list[i].getId().equals(o.getId())){
				list[i]=o;
				break;
			}
		}
		this.write(list);
	}
	public Medicines searchById(String id){
		Medicines[] list = this.allMedicines();
		for(int i=0; i<100; i++){
			if(list[i].getId().equals(id)){
				return list[i];
			}
		}
		return null;
	}
	public Medicines[] allMedicines(){
		FileIo fio = new FileIo();
		String[] data = fio.readData("repository/data/products.txt");
		
		Medicines o = new Medicines();
		Medicines[] list = new Medicines[100];
		int i=0;
		for(String str:data){
			if(data[i]!=null){
				list[i]=o.fromMedicines(str);
			}
			i++;
		}
		return list;
	}
	
	public void write(Medicines[] list){
		String[] str = new String[100];
		for(int i=0; i<100; i++){
			if(list[i]!=null){
				str[i] = list[i].toStringMedicines();
			}
		}
		FileIo fio = new FileIo();
		fio.writeData(str,"repository/data/products.txt");
	}
}