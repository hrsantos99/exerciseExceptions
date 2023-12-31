package application;

import java.io.ObjectInputStream.GetField;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter account data");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		Double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.println("Account data:\n" + account);
		System.out.println();
		
		try {
		System.out.print("Enter amount for withdraw: ");
		double amount = sc.nextDouble();
		account.withdraw(amount);
		System.out.println();
		System.out.println("Account data:\n" + account);
		}
		catch(DomainExceptions e) {
			System.out.println();
			System.out.println("Withdraw error: " + e.getMessage());
		}
		
		
		sc.close();

	}

}
