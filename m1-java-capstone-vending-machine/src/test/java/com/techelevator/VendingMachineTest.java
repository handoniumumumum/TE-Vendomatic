package com.techelevator;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.Assert;
import org.junit.Test;


public class VendingMachineTest {

	@Test
	public void file_is_read_properly_when_given_to_vending_machine() {
		File vendingFile = new File("vendingmachine.csv");
		VendingMachine vm = new VendingMachine(vendingFile);
		String line = " ";
		try(FileReader fr = new FileReader(vendingFile);
			BufferedReader br = new BufferedReader(fr)){
				
				while((line = br.readLine()) != null){
					break;
				}
			}
		catch(Exception e){
			
		}		
		String result = "A1|Potato Crisps|3.25";
		Assert.assertEquals(result, line);
	}
	
	@Test
	public void display_items_is_properly_displayed(){
		File vendingFile = new File("vendingmachine.csv");
		VendingMachine vm = new VendingMachine(vendingFile);
		vm.displayStock();
	}
	
	@Test
	public void returns_itemName_from_itemList_at_given_index(){
		File vendingFile = new File("vendingmachine.csv");
		VendingMachine vm = new VendingMachine(vendingFile);
		Item thisItem = vm.getItem("A1");
		Item compareItem = new Item("A1", "Potato Crisps", 325);
		String actual = thisItem.getName();
		String result = compareItem.getName();
		Assert.assertEquals(result, actual );
	}
	
	@Test
	public void returns_itemSlot_from_itemList_at_given_index(){
		File vendingFile = new File("vendingmachine.csv");
		VendingMachine vm = new VendingMachine(vendingFile);
		Item thisItem = vm.getItem("A1");
		Item compareItem = new Item("A1", "Potato Crisps", 325);
		String actual = thisItem.getSlot();
		String result = compareItem.getSlot();
		Assert.assertEquals(result, actual );
	}
	
	@Test
	public void returns_itemPrice_from_itemList_at_given_index(){
		File vendingFile = new File("vendingmachine.csv");
		VendingMachine vm = new VendingMachine(vendingFile);
		Item thisItem = vm.getItem("A1");
		Item compareItem = new Item("A1", "Potato Crisps", 325);
		int actual = thisItem.getPrice();
		int result = compareItem.getPrice();
		Assert.assertEquals(result, actual );
	}

}
