package repository;
import java.lang.*;
import java.io.*;

public class FileIo{
	private String uid;
	public void writeData(String[] data, String filename){
		try{
			File f=new File(filename);
			FileWriter fw = new FileWriter(f);
			
			for(String str:data){
				if(str!=null){
					fw.write(str);
					fw.flush();
				}
			}
			fw.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String[] readData(String filename){
		try{
			File f= new File(filename);
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String[] data = new String[100];
			String line="";
			int i=0;
			while((line=br.readLine())!=null){
				data[i]=line;
				i++;
			}
			return data;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public String lineCountEmployee(String f){
		try{
			File file = new File(f);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s;
			int cnt=1;
			while((s=br.readLine())!=null){
				cnt++;
			}
			uid=("E241-"+cnt);
			return uid;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;		
	}
	
	public String lineCountCustomer(String f){
		try{
			File file = new File(f);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s;
			int cnt=1;
			while((s=br.readLine())!=null){
				cnt++;
			}
			uid=("C242-"+cnt);
			return uid;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public String lineCountMedicine(String f){
		try{
			File file = new File(f);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s;
			int cnt=1;
			while((s=br.readLine())!=null){
				cnt++;
			}
			uid=("M-"+cnt);
			return uid;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public String lineCountPayment(String f){
		try{
			File file = new File(f);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s;
			int cnt=1;
			while((s=br.readLine())!=null){
				cnt++;
			}
			uid=("P-"+cnt);
			return uid;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public String lineCountOrder(String f){
		try{
			File file = new File(f);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s;
			int cnt=1;
			while((s=br.readLine())!=null){
				cnt++;
			}
			uid=("O-"+cnt);
			return uid;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	public String lineCountOrderLine(String f){
		try{
			File file = new File(f);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s;
			int cnt=1;
			while((s=br.readLine())!=null){
				cnt++;
			}
			uid=("OL-"+cnt);
			return uid;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public String lineCountDiscount(String f){
		try{
			File file = new File(f);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String s;
			int cnt=1;
			while((s=br.readLine())!=null){
				cnt++;
			}
			uid=("D-"+cnt);
			return uid;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}