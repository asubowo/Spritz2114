package cs2114.spritz;

import student.TestCase;

/**
 * Test class for the CircularLinkedList.java class
 * 
 * @author Andrew Subowo (asubowo)
 * @version 4.29.2014
 */

public class CircularLinkedListTests extends TestCase {

	private CircularLinkedList<String> dataArray;
	
	/**
	 * Called before every test case
	 */
	public void setUp() {
		dataArray = new CircularLinkedList<String>();
	}
	
	/**
	 * Tests all aspects of the CircularLinkedList object
	 */
	public void testCircularLinkedList() {
		assertEquals(0, dataArray.size());
		
		dataArray.add("hello");
		dataArray.add("world!");
		
		dataArray.next();
		assertEquals("hello", dataArray.getCurrent());
		dataArray.previous();
		assertEquals("world!", dataArray.getCurrent());
		
		
		dataArray.add("this");
		dataArray.add("is");
		dataArray.add("bob");
	
		assertEquals("bob", dataArray.getCurrent());
		dataArray.clear();
		
		dataArray.add("hello");
		assertEquals(1, dataArray.size());
		assertEquals("hello", dataArray.getCurrent());
	}
	
	
}
