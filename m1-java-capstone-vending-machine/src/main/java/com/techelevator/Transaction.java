package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Transaction {
	private int balance;
	private boolean isComplete = false;

	public void transactionComplete(){
		isComplete = true;
	}
	public boolean getTransactionStatus()
	{
		return isComplete;
	}
	
	
	public void printTransaction(String itemName, String itemSlot, int itemPrice)
	{
		File transactionLog = new File("transactionLog.txt");
		if(!transactionLog.exists())
		{
			try
			{
				transactionLog.createNewFile();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			try(PrintWriter pw = new PrintWriter(new FileWriter(transactionLog, true)))
			{
				
				pw.println("DateTime            | Product | Slot | AmountAccepted | Balance");
				
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		try(PrintWriter pw = new PrintWriter(new FileWriter(transactionLog, true)))
		{
			
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-uuuu hh:mm a");
			pw.print(formatter.format(dateTime) + " | ");
			pw.print(itemName + " | ");
			pw.print(itemSlot + "   | ");
			pw.print(getBalanceInDollars() + " | ");
			pw.println(getBalanceInDollars(balance - itemPrice));
		}
		catch(Exception e)
		{
			System.out.println("There was a problem writing to the log file.");
			System.out.println(e.getMessage());
		}
		
	}
	
	public String insertMoney(int amount)
	{
		if(amount == 1 || amount == 2 || amount == 5 || amount == 10)
		{
			balance += amount * 100;
			return amount * 100 + " dollar(s) accepted.";
		}
		else
			return "Amount not accepted. Please only feed whole dollar amounts into the vending machine.";
		
	}
	
	public int getBalance() {
		return balance;
	}
	public String getBalanceInDollars()
	{
		DecimalFormat df = new DecimalFormat("###.00");
		return "$" + df.format(((double)balance / 100));
	}
	
	public String getBalanceInDollars(int givenBalance)
	{
		DecimalFormat df = new DecimalFormat("###.00");
		return "$" + df.format((double)givenBalance / 100);
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public String getChange()
	{
		int nickels = 0;
		int dimes= 0;
		int quarters= 0;
		File transactionLog = new File("transactionLog.txt");
		try(PrintWriter pw = new PrintWriter(new FileWriter(transactionLog, true)))
		{
			LocalDateTime dateTime = LocalDateTime.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-uuuu hh:mm a");
			pw.print(formatter.format(dateTime) + " | ");
			pw.println("ChangeTendered | N/A | " + getBalanceInDollars() + " | 0.00");
		}
		catch(Exception e)
		{
			System.out.println("There was a problem writing to the log file.");
		}
		
		while(balance >= 25)
		{
			quarters++;
			balance -= 25;
		}
		while(balance >= 10)
		{
			dimes++;
			balance -= 10;
		}
		while(balance >= 5)
		{
			nickels++;
			balance -= 5;
		}

		
		
		return quarters + " quarters, " + dimes + " dimes and " + nickels + " nickels";
	}
	
	

}
