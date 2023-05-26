import java.io.*;
import java.util.*;
import java.lang.*;

public class AtmInterface {
	
	Scanner input = new Scanner(System.in) ;
	
	
	public void TransactionHistory(String userid) throws Exception  {
		String str ="C:/Users/Mallika/Desktop/";
		str = str+userid+".txt";
		File f = new File(str);
		Scanner sc = new Scanner(f);
		
		int ch =0 ;
		while(sc.hasNextLine()) {
			if(ch>0) {
				System.out.println(sc.nextLine());
			}
			else {
				sc.nextLine();
			}
		ch++;		
		}
		sc.close();	
	}
	
	
	public void Withdraw(String userid) throws Exception {
		
		int withdraw  ;
		String str = "C:/Users/Mallika/Desktop/";
	    str = str+userid+".txt";
		File f = new File(str);
		
		ArrayList<String> fc = new ArrayList<String>();
		
		Scanner sc = new Scanner(f);
		while(sc.hasNextLine()) {
			fc.add(sc.nextLine());
		}
		sc.close();
		fc.remove(0);
		
		Scanner s = new Scanner(f);
		s.useDelimiter("[:\n]");
		int i=1;
		String temp,bal="";
		
		while(i==1) {
			temp = s.next();
			bal = s.next();
			i=2;
		}
		bal = bal.trim();
		int balance = Integer.parseInt(bal);
					
		System.out.println("ENTER THE AMOUNT :");
		withdraw = input.nextInt();
		if(balance >= withdraw)  
	        {  
	             
	            balance = balance - withdraw;  
	            System.out.println("PLEASE COLLECT YOUR MONEY");  
	         }  
	    else  
	         {  
	              
	             System.out.println("INSUFFICIENT AMOUNT");  
	         }
		fc.add(0,"Balance :"+balance);
			
			
		FileWriter fw = new FileWriter(str,false);
			
		for(String eachline : fc) {
			fw.write(eachline +"\n");
		}
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("withdraw "+withdraw);
		bw.close();
		fw.close();
	}
	
	public void Deposit(String userid)  throws Exception{ 

		int amount ;
		
		System.out.println("ENTER THE AMOUNT :");
		amount = input.nextInt();
		
		System.out.println("PLEASE KEEP THE CASH IN THE SLOT PROVIDED ");
	
		System.out.println(amount +" successfully deposited into your account ");
		
		String str = "C:/Users/Mallika/Desktop/";
	    str = str+userid+".txt";
		File f = new File(str);
		
		ArrayList<String> fc = new ArrayList<String>();
		
		Scanner sc = new Scanner(f);
		while(sc.hasNextLine()) {
			fc.add(sc.nextLine());
		}
		sc.close();
		fc.remove(0);
		
		Scanner s = new Scanner(f);
		s.useDelimiter("[:\n]");
		int i=1;
		String temp,bal="";
		
		while(i==1) {
			temp = s.next();
			bal = s.next();
			i=2;
		}
		bal = bal.trim();
		int balance = Integer.parseInt(bal);
		fc.add(0,"Balance :"+(balance+amount));
			
			
		FileWriter fw = new FileWriter(str,false);
			
		for(String eachline : fc) {
			fw.write(eachline +"\n");
		}
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("deposited "+amount);
		bw.close();
		fw.close();
	
	}
	public void Transfer(String userid) throws Exception {
		
		System.out.println("Enter the userid of the account which you are transffering the money :");
		
		String uid = input.next();
		
		System.out.println("ENTER THE AMOUNT :");
		
		int amount = input.nextInt();

	    String path = "C:/Users/Mallika/Desktop/";
		path = path +userid+".txt";
		File f = new File(path);
		
		ArrayList<String> fc = new ArrayList<String>();
		
		Scanner sc = new Scanner(f);
		while(sc.hasNextLine()) {
			fc.add(sc.nextLine());
		}
		sc.close();
		fc.remove(0);
		
		Scanner s = new Scanner(f);
		s.useDelimiter("[:\n]");
		int i=1;
		String temp,bal="";
		
		while(i==1) {
			temp = s.next();
			bal = s.next();
			i=2;
		}
		bal = bal.trim();
		
		
		int balance = Integer.parseInt(bal);
		
		if(balance >= amount)  
        {  
            
            balance = balance -amount;  
            System.out.println(amount + "  is successfully transfered to "+uid); 
			fc.add(0,"Balance :"+(balance));
		
			
			FileWriter fw = new FileWriter(path,false);
			
			for(String eachline : fc) {
				fw.write(eachline +"\n");
			}
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("deposited "+amount);
			bw.close();
			fw.close();
		    FileWriter fw1 = new FileWriter(path,true);
			BufferedWriter out = new BufferedWriter(fw1);
			out.write("\nwithdraw " + amount);
			out.close();
			fw1.close();
			
			String str = "C:/Users/Mallika/Desktop/";
			str = str +uid+".txt";
			File f1 = new File(str);
		
			ArrayList<String> fc1 = new ArrayList<String>();
		
			Scanner sc1 = new Scanner(f1);
			while(sc1.hasNextLine()) {
				fc1.add(sc1.nextLine());
			}
			sc1.close();
			fc1.remove(0);
		
			Scanner s1 = new Scanner(f1);
			s1.useDelimiter("[:\n]");
			int k=1;
			String temp1,bal1="";
		
			while(k==1) {
				temp1 = s1.next();
				bal1 = s1.next();
				k=2;
			}
			bal1 = bal1.trim();
			int balance1 = Integer.parseInt(bal1);
			fc1.add(0,"Balance :"+(balance1+amount));
			
			FileWriter fw2 = new FileWriter(str,false);
			
			for(String eachline : fc1) {
				fw2.write(eachline +"\n");
			}
			BufferedWriter bw2 = new BufferedWriter(fw2);
		
			bw2.write("deposited "+amount);
			bw2.close();
			fw2.close();
        }  
        else  
        {  
             
            System.out.println("INSUFFICIENT AMOUNT");  
        }
	
	}
	
	
	public static boolean verify(String username,String pin, File file) {
		
		boolean found = false ;
		String tempUsername = "";
		String tempPin = "";
		
		try {
			
			Scanner x = new Scanner(file);
			x.useDelimiter("[,\n]");
			
			while (x.hasNext() && !found) {
				tempUsername = x.next();
				tempPin = x.next();
				
				if(tempUsername.trim().equals(username.trim()) && tempPin.trim().equals(pin.trim())) {
					found = true ;
				}
			}
			x.close();
		}
		
		catch(Exception e){
			System.out.println(e);
		}
		return found;
	}
	public static void main (String [] args) throws Exception {
		
		File f = new File("C:/Users/Mallika/Desktop/Atmpass.txt");
		Scanner sc = new Scanner(System.in);
		String userid,pin;
		System.out.println("Enter the user id :");
		userid = sc.next();
		System.out.println("Enter the user pin :");
		pin = sc.next();
		AtmInterface obj = new AtmInterface();
		int c;
		if(obj.verify(userid,pin,f)) {
			
			
			
			System.out.println("			*******WELCOME*******");
			System.out.println("\n			AUTOMATED TELLER MACHINE\n");
			System.out.println("1.Transaction History \n2.Withdraw \n3.Deposit \n4.Transfer\n5.Quit\n");
			
			while(true) {
				
			int ch=0;
			System.out.println("Choose the operation you want to perform :");
			c = sc.nextInt();
			
			switch(c) {
			case 1 : obj.TransactionHistory(userid);ch=1;
					 break;
			case 2 : obj.Withdraw(userid);ch=1;
			         break; 
			case 3 : obj.Deposit(userid);ch=1;
			         break;
			case 4 : obj.Transfer(userid);ch=1;
			         break;
			case 5 : System.exit(0);
			
			default :System.out.println("ERROR ! Please enter correct number ");
			
			}
			
			if(ch==1) {
				System.exit(0);
			}
		
			}
			
		}
		else {
			System.out.println("INVALID USER ID AND USER PIN");
		}
	}
}