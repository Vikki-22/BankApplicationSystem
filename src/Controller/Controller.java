package Controller;


import java.util.Scanner;

import Entity.account;

import ModelDAO.AccountDAO;
import View.Accountview;

public class Controller {
	
		 
		public static void start() {
			Accountview view= new Accountview();
			AccountDAO dao= new AccountDAO();
			while (true) {

				int ch = view.menu();
				account a = new account();
				switch (ch) {
				case 1:


					a.setName(view.getname());
					a.setAccountNumber(view.getaccountNumber());
					a.setPin(view.getpin());
					a.setBalance(view.getbalance());
                    dao.AddAccount(a);
					
					break;
				case 2:
					a.setAccountNumber(view.getaccountNumber());
					dao.DeleteAccount(a);
					break;
				
				case 3:
					
					dao.TransferAmount();
					break;
				case 4:
					a.setId(view.getid());
					dao.DepositAmount(a);
					break;
				
				case 5:
					a.setId(view.getid());
					dao.WithdrawAmount(a);
					break;
				case 6:
					a.setId(view.getid());
					dao.PinChange(a);
					break;
				
				case 7:
					a.setId(view.getid());
				    dao.ViewAccountHolder(a);
				    break;
				
				case 8:

				    java.util.List<account> list = dao.ViewAlldata();

				    for(account m : list)
				    {
				        System.out.println(m);
				    }

				    break;
				case 9:
					System.out.println("Thank You");
					System.exit(0);

				default:
					System.out.println("Invalid Choice");
				}	
		}
				
		}
		public static void main(String[] args) {
			start();
		}
	
}
