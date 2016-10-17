package com.techelevator;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class ItemTest {

	@Test
	public void test() {
		File vendingFile = new File("vendingmachine.csv");
		VendingMachine vm = new VendingMachine(vendingFile);
	}

}
