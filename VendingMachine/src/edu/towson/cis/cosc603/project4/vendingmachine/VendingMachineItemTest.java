package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VendingMachineItemTest {
	
	/** Declaring necessary test objects for {@link VendingMachineItem} */
	Double price1;
	Double price2;
	Double price3;

	VendingMachineItem butterfinger;
	VendingMachineItem noName;
	VendingMachineItem snickers;
	
		
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	
	}
	
	/**
	 * Initializes the necessary test objects for the test cases to use.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		
		snickers = new VendingMachineItem("Snicker", 1.00);
		butterfinger = new VendingMachineItem("Butterfinger",1.50);
		noName = new VendingMachineItem(null,2.00);
		
		
		price1 = 1.00;
		price2 = -1.00;

	}

	/**
	 * Cleans up test objects after a test case is executed.
	 */
	@After
	public void tearDown() throws Exception {
		price1 = 0.0;
		price2 = 0.0;
		price3 = 0.0;

		snickers = new VendingMachineItem(null, 0.00);
		butterfinger = new VendingMachineItem(null,0.00);
		noName = new VendingMachineItem(null,0.00);
	}

	@Test
	/**
	 * Testing the VendingMachineItem Constructor to 
	 * ensure that price value is greater than or equal to 
	 * zero  
	 */
	
	public void testVendingMachineItem_GreaterThanEqualToZero() {
		//fail("Not yet implemented");
		assertTrue(price1>=0);
	}
	
	@Test
	/**
	 * Testing the VendingMachineItem Constructor to 
	 * see if price value is less than zero 
	 */
	public void testVendingMachineItem_LessThanZero() {
		//fail("Not yet implemented");
		assertTrue(price2<0);
	}

	@Test
	/**
	 * Testing the GetName() to make sure that Vending Items
	 * have a name. 
	 */
	public void testGetName_ItemHasName(){
		//fail("Not yet implemented");
		assertNotNull(butterfinger.getName());
	}
	@Test
	/**
	 * Testing the GetName() for Vending Items that do not
	 * have a name.
	 */
	public void testGetName_ItemNameMissing(){
		//fail("Not yet implemented");
		assertNull(noName.getName());
	}
	
	@Test
	/**
	 * Testing the GetPrice() that Vending Item Prices
	 * have a price value greater than or equal to 0.00
	 */
	public void testGetPrice_PositiveNumber() {
		//fail("Not yet implemented");
		assertEquals(1.00,snickers.getPrice(),0.01);
	}
	
	@Test (expected = VendingMachineException.class)
	/** Testing the GetPrice() for those Vending Items Prices that 
	 * have a value less than zero.  The VendingMachineException is thrown
	 * for those items with a value less than 0. 
	 * 
	 */
	public void testGetPrice_NegativeNumber() {
		//Performing test for a purchase where the price is not legal. 
		VendingMachineItem free = new VendingMachineItem("free", -1.00);
		assertEquals(-1.00,free.getPrice(),0.01);
	}
}
