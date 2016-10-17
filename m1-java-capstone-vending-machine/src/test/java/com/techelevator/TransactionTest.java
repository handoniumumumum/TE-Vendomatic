package com.techelevator;

import static org.junit.Assert.*;

import java.io.File;
import java.text.DecimalFormat;

import org.junit.Test;

public class TransactionTest {

	@Test
	public void test_transaction_returns_correct_change_of_three_dollars()
	{
		File vendingFile = new File("vendingmachine.csv");
		VendingMachine vm = new VendingMachine(vendingFile);
		Transaction t = new Transaction();
		t.insertMoney(5);
		t.insertMoney(1);
		t.insertMoney(1);
		vm.purchase(t, "D1");
		vm.purchase(t, "A1");

		assertEquals("12 quarters, 0 dimes and 0 nickels", t.getChange());
	}
	@Test
	public void test_transaction_does_not_accept_non_dollar_amounts_of_money()
	{
		File vendingFile = new File("vendingmachine.csv");
		VendingMachine vm = new VendingMachine(vendingFile);
		Transaction t = new Transaction();
		assertEquals("Amount not accepted. Please only feed whole dollar amounts into the vending machine.", t.insertMoney(42));
	}
	@Test
	public void test_transaction_returns_balance_in_dollars()
	{
		File vendingFile = new File("vendingmachine.csv");
		VendingMachine vm = new VendingMachine(vendingFile);
		Transaction t = new Transaction();
		t.insertMoney(5);
		vm.purchase(t, "D1");
		assertEquals("$4.25", t.getBalanceInDollars());
	}
	
	
	

}
