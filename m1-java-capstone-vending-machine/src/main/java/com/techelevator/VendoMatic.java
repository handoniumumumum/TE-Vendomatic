package com.techelevator;

import java.io.File;
import java.util.Scanner;

public class VendoMatic {

	public static void main(String[] args) {
		
		File inputFile = new File("vendingmachine.csv");
		VendingMachine vendoMatic = new VendingMachine(inputFile);

		Scanner scan = new Scanner(System.in); 
		while(true){
		System.out.println("(1) Display Vending Machine Items.  (2) Purchase Item");
		int userInput = scan.nextInt(); 
			if(userInput == 0){
				vendoMatic.printSalesReport();
			}
		
			if(userInput == 1){
				for(String s : vendoMatic.displayStock()){
					System.out.println(s);
				}
			
			}
		
			if(userInput == 2){
				Transaction t = new Transaction();
				while(!t.getTransactionStatus()){
					System.out.println("(1)Feed Money (2)Select Product (3) Finish Transaction");
					System.out.println("Balance: " + t.getBalanceInDollars());
					int inputNumber = scan.nextInt();
				
					if(inputNumber == 1){
						System.out.println("Please Enter Money: ");
						int amount = scan.nextInt();
						t.insertMoney(amount);
						System.out.println("Money Inserted: " + t.getBalanceInDollars());
					}
			
					if(inputNumber == 2){
						System.out.println("Please Enter Your Selection: ");
						scan.reset();
						String selection = scan.next();
						System.out.println(vendoMatic.purchase(t, selection));
					}
					if(inputNumber == 3){
						System.out.println(" Your change is : " + t.getChange());
						t.transactionComplete();
					}
				
				}
			}
		}
		
	}
}



