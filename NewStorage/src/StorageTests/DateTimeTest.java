package StorageTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import data.DateTime;
public class DateTimeTest {

	DateTime yesterday=new DateTime(2012,1,25,4,30);
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testCompareTo() {
	int value=yesterday.compareTo(DateTime.getCurrentDate());
	assertEquals(-1,value);
	}
	@Test
	public final void testGet() {
		assertEquals(2012,yesterday.get(1));
	}

	@Test
	public final void testFormattedToString() {
		assertEquals("25-05-2012",yesterday.formattedToString());
	}

	@Test
	public final void testIsDefaultTime() {
		assertEquals(false,yesterday.isDefaultTime());
	}
	@Test
	public final void testGetDate(){
		System.out.println(yesterday.generateDateCode());
	}

	@Test
	public final void testSetIntInt() {
		yesterday.set(1, 2011);
		assertEquals("25-05-2011",yesterday.getDate().formattedToString());
	}
	@Test 
	public final void testPresentableToString(){
		assertEquals("25 May '12 4:30 AM",yesterday.presentableToString());
	}

}
