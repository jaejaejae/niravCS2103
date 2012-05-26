package StorageTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Storage.DateTime;
public class DateTimeTest {

	DateTime yesterday=new DateTime(2012,5,25);
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
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSetIntInt() {
		fail("Not yet implemented"); // TODO
	}

}
