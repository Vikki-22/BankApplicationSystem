package Entity;

public class account {
   private int  id;
   private String name ;
   private String accountNumber;
   private String pin;
   private double balance;
   

   public account(String name, String accountNumber, String pin, double balance) {
	super();
	this.name = name;
	this.accountNumber = accountNumber;
	this.pin = pin;
	this.balance = balance;
   }

   public account(int id, String name, String accountNumber, String pin, double balance) {
	super();
	this.id = id;
	this.name = name;
	this.accountNumber = accountNumber;
	this.pin = pin;
	this.balance = balance;
   }

   public account() {
	super();
	// TODO Auto-generated constructor stub
   }

   public int getId() {
	return id;
   }

   public void setId(int id) {
	this.id = id;
   }

   public String getName() {
	return name;
   }

   public void setName(String name) {
	this.name = name;
   }

   public String getAccountNumber() {
	return accountNumber;
   }

   public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
   }

   public String getPin() {
	return pin;
   }

   public void setPin(String pin) {
	this.pin = pin;
   }

   public double getBalance() {
	return balance;
   }

   public void setBalance(double balance) {
	this.balance = balance;
   }

   @Override
   public String toString() {
	return "account [id=" + id + ", name=" + name + ", accountNumber=" + accountNumber + ", pin=" + pin + ", balance="
			+ balance + "]";
   }
   
   
   
   
}
