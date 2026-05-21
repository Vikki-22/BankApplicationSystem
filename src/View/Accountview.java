package View;

import java.util.Scanner;

public class Accountview {
	
	private Scanner sc = new Scanner(System.in);

	public int menu() {

		System.out.println("\n===== Account Saction =====");

		System.out.println("1. Add Account ");
		System.out.println("2. Delete Account ");
		System.out.println("3. Transfer Amount ");
		System.out.println("4. Deposite Amount ");
		System.out.println("5. Withdraw Amount ");
		System.out.println("6. change pin");
		System.out.println("7. View Account Holder Details ");
		System.out.println("8. View All Account Holder Detials....");
		System.out.println("9. EXit");
		return sc.nextInt();
	}

	public int getid() {
		System.out.print("Enter Account ID : ");
		return sc.nextInt();
	}

	public String getname() {
		sc.nextLine();
		System.out.print("Enter Name : ");
		return sc.nextLine();
	}

	public String getaccountNumber() {
		System.out.print("Enter AccountNumber : ");
		return sc.next();
	}

	public String getpin() {
		System.out.print("Enter Pin : ");
		return sc.next();
	}

	public double getbalance() {
		System.out.print("Enter Balance : ");
		return sc.nextDouble();
	}

}
