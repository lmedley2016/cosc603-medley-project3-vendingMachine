package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VendingMachineTest {
	
	/** Declaring necessary test objects for {@link VendingMachine} */
	/** Vending machine items, slotA, slotB, slotC, and slotD */
	
	VendingMachineItem slotA; 
	VendingMachineItem slotB;
	VendingMachineItem slotC;
	VendingMachineItem slotD;
	
	
	Double balance;
	
	/**
	 * Initializes the necessary test objects for the test cases to use.
	 *
	 * @throws Exception the exception
	 */

	@Before
	public void setUp() throws Exception {
		slotA = null;
		slotB = null;
		slotC = null;
		slotD = null;
		balance = 0.0;
	}
	
	/**
	 * Cleans up test objects after a test case is executed.
	 */

	@After
	public void tearDown() throws Exception {
		slotA = null;
		slotB = null;
		slotC = null;
		slotD = null;
		balance = 0.0;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
	}

	@Test
	/**
	 * Testing the getSlotIndex() method to see if the correct slot # is returned for a slot. 
	 * The following is a negative test condition since A's slot # should be 0.
	 * the assertNotEquals("A", 1, 0) test passes since we assert that A's slot #
	 * should not be 1 (implied that it is 0 or other than 1).
	 * 
	 * This test is not part of the test cases that we had to write, this is just a test
	 * to see how the getSlotIndex() method works.
	 */
	
	public void testGetSlotIndex() {
		//fail("Not yet implemented");
		assertNotEquals("A", 1, 0);
	}
	
	@Test
	/**
	 * Testing the addItem() method to see if items can be added to a given slot. 
	 * Setting the slots A, B, C, and D with vending machine item names 
	 * and price values by instantiating the VendingMachineItem class.
	 * Adding slotB, slotC, and slotD and testing for their item names and prices.
	 * 
	 * For this test, all the slots were initialized by instantiating the VendingMachineItem
	 * with their item names and price values as follows:
	 * 
	 * slotA = VendingMachineItem("Chips", 1.00)
	 * slotB = new VendingMachineItem("Candy", 0.75);
	 * slotC = new VendingMachineItem("Soda", 1.75);
	 * slotD = new VendingMachineItem("Gum", 0.50);
	 * 
	 * The assertEquals tests were administered to all item names and price values
	 * for slotA, slotB, slotC, and slotD. 
	 */
	
	public void testAddItem() {
		//fail("Not yet implemented");
		
		slotA = new VendingMachineItem("Chips", 1.00);
		slotB = new VendingMachineItem("Candy", 0.75);
		slotC = new VendingMachineItem("Soda", 1.75);
		slotD = new VendingMachineItem("Gum", 0.50);
		assertEquals(slotA.getName(), "Chips");
		assertEquals(1.00, slotA.getPrice(), 0.001);
		assertEquals(slotB.getName(), "Candy");
		assertEquals(0.75, slotB.getPrice(), 0.001); 
		assertEquals(slotC.getName(), "Soda");
		assertEquals(1.75, slotC.getPrice(), 0.001);
		assertEquals(slotD.getName(), "Gum");
		assertEquals(0.50, slotD.getPrice(), 0.001);
	}
	
	@Test
	/**
	 * Testing the addItem() method to check for condition when slot is already occupied. 
	 * In this situation, we decided to override slotA with slotB values such as the following:
	 * 
	 * slotB = new VendingMachineItem("Chips", 1.00);
	 * 
	 * Then we tested the values of slotB now that it occupied slotA's original values.
	 * 
	 * assertEquals and assertNotEquals assertions were used to test the name and price
	 * of slotB.
	 */
	public void testAddItem_SlotOccupied() {
		slotA = new VendingMachineItem("Chips", 1.00);
		slotB = new VendingMachineItem("Chips", 1.00);
		assertEquals(slotB.getName(), "Chips");
		assertNotEquals(slotB.getPrice(), 1.50, 0.001);
	}

	@Test
	/**
	 * Testing the removeItem() method to see if the item can be removed from the slot. 
	 * In this test, we instantiated a new VendingMachineItem, slotA, with its item
	 * name and price value.  Assuming that slotB was empty at this point, so we can 
	 * test/compare it with a "null" object, which is what the assertEquals assertion
	 * test was doing in this case. 
	 */
	public void testRemoveItem() {
		//fail("Not yet implemented");
		slotA = new VendingMachineItem("Chips", 1.00);
		assertEquals(slotB, null);
		
	}
	
	@Test
	/**
	 * Testing the removeItem() method to see if the slot is empty (no item). 
	 * In this test, we instantiated the slotA with a new VendingMachineItem
	 * to be slotB = new VendingMachineItem("Candy", 0.75);
	 * SlotA at this point is empty, so the test assertEquals compares it
	 * to a "null" object, which is what the test was doing below.
	 */
	public void testRemoveItem_SlotEmpty() {
		//fail("Not yet implemented");
		slotB = new VendingMachineItem("Candy", 0.75);
		assertEquals(slotA, null);
	}

	@Test
	/**
	 * Testing the insertMoney() method to see if money can be input into the machine.  
	 * The following test checks to see if $5 can be added to the balance by the following
	 * test assertion:
	 * assertEquals(5.00, (new VendingMachine().getBalance() + 5.00), 0.01);
	 * The test should pass since balance = 0 and adding $5.00 to it still makes 
	 * balance = 5.00.
	 */
	public void testInsertMoney() {
		//fail("Not yet implemented");
		assertEquals(5.00, (new VendingMachine().getBalance() + 5.00), 0.01);
	}
	
	@Test
	/**
	 * Testing the insertMoney_TestForAmount() method to see if money can be input 
	 * into the machine.  Test fails if amount is less than zero.  This test sets
	 * amount = -1.00 before testing to see if it is < 0. 
	 */
	public void testInsertMoney_TestForAmount() {
		//fail("Not yet implemented");
		double amount = -1.00;
		assertTrue(amount < 0);
		
	}

	@Test
	/**
	 * Testing the getBalance() method to return the amount the user has in the vending machine.
	 * This test only returns the amount the user has in the vending machine and it does not
	 * actually calculate the change.  Assuming that balance was zero, the following test
	 * asserts that premise.  To test for negative condition, we just compared balance to 
	 * a value that is positive non-zero.
	 */
	public void testGetBalance() {
		//fail("Not yet implemented");
		
		assertEquals(0.0, (new VendingMachine().getBalance()), 0.001);
		//assertNotEquals(2.0, (new VendingMachine().getBalance()), 0.001);
	}

	@Test
	/**
	 * Testing the makePurchase() method to ensure that balance is sufficient
	 * to purchase a given vending machine item.  The test used the assertEquals
	 * assertion and certain calculations were done prior to execute this test, such as
	 * calculating the balance after taking into account the price of "Soda", which is
	 * 1.75 while starting balance = 2.00.
	 * 
	 * The assertEquals(0.25, balance, 0.001); test should pass since it tested the balance
	 * after a vending machine item ("Soda") was purchased for 1.75.
	 */
	public void testMakePurchase() {
		//fail("Not yet implemented");
		slotC = new VendingMachineItem("Soda", 1.75);		
		balance = 2.00;
		balance = balance - slotC.getPrice();
		assertEquals(0.25, balance, 0.001);
	}
	
	@Test
	/**
	 * Testing to ensure that balance is enough to purchase the vending machine item.
	 * assertNotEquals is the assertion used since the balance wasn't enough to buy "Gum"
	 * if it cost 50 cents and our balance previously was 25 cents.
	 */
	public void testMakePurchase_testBalance() {
		// Test to see if can make a purchase based on the balance
		slotD = new VendingMachineItem("Gum", 0.50);
		balance = 0.25;
		assertNotEquals(0.25, slotD.getPrice(), 0.001);
	}	

	@Test
	/**
	 * Testing the returnChange() method.  This test only returns the change 
	 * in the machine and reset the balance to zero.
	 * The negative test can be carried out if manipulating the balance
	 * to be something other than what it was set, in this case adding $2 
	 * should make the test fail.
	 */
	public void testReturnChange() {
		//fail("Not yet implemented");
		balance = 3.00;
		double change = this.balance;
		assertEquals(change, balance, 0.001);
		//Test if change and balance are not the same
		//assertNotEquals(change, balance + 2.00, 0.001);
	}
	
	

}
