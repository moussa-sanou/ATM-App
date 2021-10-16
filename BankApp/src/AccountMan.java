import java.util.Scanner;
import java.util.UUID;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;



public class AccountMan {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("--------------------------------------");
		System.out.println("Please Enter Your Name:");
		System.out.println("--------------------------------------");
		String mname = scanner.nextLine();
		UUID newId = UUID.randomUUID();
		
		BankAccount obj = new BankAccount(mname, "TSN-"+newId);
		obj.showMenu();
		
		
	}

}
class BankAccount{
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	BankAccount(String cname, String cid){
		customerName = cname;
		customerId = cid;
	}
	
	void deposit(int amount) {
		if(amount !=0){
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount) {
		if(amount !=0){
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	void getPreviousTransaction() {
		if(previousTransaction > 0) {
			System.out.println("Amount Deposited: " + previousTransaction);
		}
		
		else if(previousTransaction < 0) {
			System.out.println("Amount Withdrawn: " +Math.abs(previousTransaction));
		}
		else {
			System.out.println("No Transaction Occured at this time");
		}
	}
	void showMenu() {
		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------------------------------------");
		System.out.println("Hello " +customerName + " Welcome To Dollars Bank");
		System.out.println("-------------------------------------------");
		System.out.println("Your Transaction Number is: " +customerId);
		System.out.println("-------------------------------------------");
		
		
		System.out.println("A : Check Balance");
		System.out.println("B : Deposit");
		System.out.println("C : Withdraw");
		System.out.println("D : Previous Transaction");
		System.out.println("E : Exit");
		
		do {
			System.out.println("---------------------------------------");
			System.out.println("Enter Your Selection from the Menu");
			System.out.println("---------------------------------------");
			
			option = scanner.next().charAt(0);
			
			
			switch(option) {
			
			case 'A':
				System.out.println("-------------------------------------");
				System.out.println("Balance = "+balance);
				System.out.println("-------------------------------------");
				break;
				
			case 'B':
				System.out.println("-------------------------------------");
				System.out.println("Deposit Amount  ");
				System.out.println("-------------------------------------");
				
				
				int amount = scanner.nextInt();
				deposit(amount);
				
				break;
				
			case 'C':
				System.out.println("------------------------------------");
				System.out.println("Withdrawn Amount  ");
				System.out.println("------------------------------------");
				
				
				int amountwith = scanner.nextInt();
				deposit(amountwith);
				break;
				
			case 'D':
				System.out.println("----------------------------------");
				System.out.println();
				System.out.println("----------------------------------");
				
				break;	
				
			case 'E':
				System.out.println("---------------------------------");
				break;
				
			default:
				System.out.println("Invalid Entry! Please Select From the Option listed in the Menu.");
				break;
			}

		}
		while(option != 'E');
			System.out.println("Thank for Your Visit");
	}
}