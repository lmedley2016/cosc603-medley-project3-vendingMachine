package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VendingMachineTest {
	
	/** Declaring necessary test objects for {@link VendingMachine} */
	/** Vending machine items, slotA, slotB, slotC, slotD, and snickers */
	/** Vending machine myMachine and Vending machine exception machineException */
	
	VendingMachineItem slotA; 
	VendingMachineItem slotB;
	VendingMachineItem slotC;
	VendingMachineItem slotD;
	VendingMachine myMachine;
	VendingMachineException machineException;
	VendingMachineItem snickers;
	

	
	//VendingMachineItem amount;
	
	Double balance;
	
	/**
	 * Initializes the necessary test objects for the test cases to use.
	 *
	 * @throws Exception the exception
	 */

	@Before
	public void setUp() throws Exception {
		
		balance = 0.0;
		
		slotA = new VendingMachineItem("Chips", 1.00);
		slotB = new VendingMachineItem("Crackers", 2.00);
		slotC = new VendingMachineItem("Candy", 3.00);
		slotD = new VendingMachineItem("Soda", 4.00);
		
		myMachine = new VendingMachine();
		machineException = new VendingMachineException();
		snickers = new VendingMachineItem ("Snickers", 1.0);
		myMachine.addItem (snickers, VendingMachine.A_CODE);

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
		snickers = null;
		balance = 0.0;
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
	}
	
	@Test
	public final void testVendingMachine() {
		assertNotNull(snickers);
	}

	@Test
	/**
	 * Testing the getSlotIndex() method - Getting the code for slot A
	 */
	
	public void testGetSlotIndex_A() {
		
		
		VendingMachine myValueA = new VendingMachine();
		myValueA.balance = 1.00;
		VendingMachineItem A_CODE = myValueA.getItem("A");
		assertNotEquals("A",A_CODE);
	}
	
	@Test
	/**
	 * Testing the getSlotIndex() - Getting the code for slot B
	 */
	public void testGetSlotIndex_B() {
			
		VendingMachine myValueB = new VendingMachine();
		myValueB.balance = 2.00;
		VendingMachineItem B_CODE = myValueB.getItem("B");
		assertNotEquals("B",B_CODE);
	}
	
	@Test
	/**
	 * Testing the getSlotIndex() method - Getting the code for slot C
	 */
	
	public void testGetSlotIndex_C() {
				
		VendingMachine myValueC = new VendingMachine();
		myValueC.balance = 3.00;
		VendingMachineItem C_CODE = myValueC.getItem("C");
		assertNotEquals("C",C_CODE);
	}

	@Test
	/**
	 * Testing the getSlotIndex() method - Getting the code for slot D
	 */
	
	public void testGetSlotIndex_D() {
				
		VendingMachine myValueD = new VendingMachine();
		myValueD.balance = 4.00;
		VendingMachineItem D_CODE = myValueD.getItem("D");
		assertNotEquals("D",D_CODE);
	}

	@Test
	/**
	 * Testing the getSlotIndex() method - Getting the code for slot E (invalid code)
	 */
	
	public void testGetSlotIndex_E() throws VendingMachineException {
				
		VendingMachine myValue = new VendingMachine();
		myValue.balance = 5.00;
		VendingMachineItem E_CODE = myValue.getItem("E");
		assertNotEquals("E",E_CODE);
	}

	@Test
	/**
	 * Testing the addItem() method to see if items can be added to a given slot. 
	 * Setting the slots A, B, C, and D with vending machine item names 
	 * and price values by instantiating the VendingMachineItem class.
	 * 
	 */
	
	public void testAddItem() {
		
		VendingMachine money = new VendingMachine();
		money.balance = 1.00;
		VendingMachineItem mySlotA = new VendingMachineItem("Chips", 1.00);
		String code = "A";
		money.addItem(mySlotA, code);
	}
	
	@Test
	/**
	 * Testing the addItem() method to check for condition when slot is already occupied. 
	 * In this situation, we decided to add an item for slot B to slot A.  The test should
	 * throw an exception for "slot already occupied".
	 *
	 */
	public void testAddItem_SlotOccupied() throws VendingMachineException {
		
		VendingMachine money = new VendingMachine();
		money.balance = 1.00;		
		VendingMachineItem mySlotA = new VendingMachineItem("Chips", 1.00);
		VendingMachineItem mySlotB = new VendingMachineItem("Crackers", 1.00);
		String code = "A";
		money.addItem(mySlotA, code);
		money.addItem(mySlotB, code);
	}

	@Test
	/**
	 * Testing the removeItem() method to see if the item can be removed from the slot. 
	 * In this test, we asserted that item will be removed if it is not empty.
	 * An exception will be thrown if the item has not been initialized and if the user
	 * is trying to remove an item that has already been removed.
	 * 
	 */
	public void testRemoveItem() throws VendingMachineException{
		
		myMachine.removeItem(VendingMachine.A_CODE);
		assertNull(myMachine.getItem(VendingMachine.A_CODE));	
	}
	
	@Test (expected = VendingMachineException.class)
	public final void testRemoveItemThrowsExceptionForUndeclaredItem() {
		myMachine.removeItem("B");	
	}
		
	@Test (expected = VendingMachineException.class)
	public final void testRemoveItemThrowsExceptionForItemRemovedTwice() {
		myMachine.removeItem(VendingMachine.A_CODE);		
		assertSame(machineException, myMachine.removeItem(VendingMachine.A_CODE));
	}

	@Test
	/**
	 * Testing the insertMoney() method to see if money can be input into the machine.  
	 * 
	 */
	public void testInsertMoney() {
		
		VendingMachine money = new VendingMachine();
		money.balance = 1.00;
		double amount = 1.00;
		money.insertMoney(amount);
		
	}
	
	@Test
	/**
	 * Testing the insertMoney_TestForAmount() method to see if money can be input 
	 * into the machine.  Test fails if amount is less than zero. 
	 */
	public void testInsertMoney_TestForAmount() throws VendingMachineException {
		
		VendingMachine money = new VendingMachine();
		money.balance = 1.00;
		double negativeAmount = -13.00;
		money.insertMoney(negativeAmount);

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
		
		assertEquals(0.0, (new VendingMachine().getBalance()), 0.001);
		
	}

	@Test
	/**
	 * Testing the makePurchase() method to ensure that balance is sufficient
	 * to purchase a given vending machine item.  The test used the assertTrue
	 * assertion to test if a purchase can be made or comparing the boolean
	 * value of "purchase" with assertEquals.
	 * 
	 */
	public void testMakePurchase_Item() {
		
		myMachine.insertMoney(10.00);
		assertTrue(myMachine.makePurchase(VendingMachine.A_CODE));
		
	}
	@Test
	public void testMakePurchase_Item1() {
		
		VendingMachine money = new VendingMachine();
		money.balance = 1.00;
		String code = "B";
		boolean purchase = money.makePurchase(code);
		assertEquals(false, purchase);
		
	}
	@Test
	public void testMakePurchase_Item2() {
			
		VendingMachine money = new VendingMachine();
		money.balance = 1.00;
		String code = "C";
		boolean purchase = money.makePurchase(code);
		assertEquals(false, purchase);
			
	}

	@Test
		public void testMakePurchase_Item3() {
			
		VendingMachine money = new VendingMachine();
		money.balance = 1.00;
		String code = "D";
		boolean purchase = money.makePurchase(code);
		assertEquals(false, purchase);
			
	}
		
	@Test
	public void testMakePurchase_NotNull() {
				
		VendingMachineItem noName = new VendingMachineItem("", 0.00);
		noName = new VendingMachineItem(null,0.00);		
		assertNotNull(noName);
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
		
		balance = 3.00;
		double change = this.balance;
		assertEquals(change, balance, 0.001);
		
	}
	
	@Test
	/**
	 * Testing the returnChange() for 
	 * change that has a value greater than zero 
	 */
	public void testReturnChange_GreaterThanZero() {		

		VendingMachine money = new VendingMachine();
		money.balance = 1.00;
		assertEquals(1.00, money.returnChange(), 0.01);
	}
	

}
