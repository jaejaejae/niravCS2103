package StorageTests;
import Storage.Task;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import Storage.DateTime;
public class TaskTest {
	DateTime start=new DateTime(2012,5,30);
	DateTime end=new DateTime(2012,5,30);
	Task one=new Task("Vacations","in India",start,end,"yearly");
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testSetEndDateTime() {
		DateTime start1=new DateTime(2012,5,31);
		one.setEndDateTime(start1);
	}

	@Test
	public final void testIsEqual() {
		assertEquals(true,one.isEqual(one));
	}

	@Test
	public final void testToggleImportant() {
		one.toggleImportant();
		assertEquals(true,one.getImportant());
		one.toggleImportant();
		assertEquals(false,one.getImportant());
	}

	@Test
	public final void testToggleCompleted() {
		one.toggleCompleted();
		assertEquals(true,one.getCompleted());
		one.toggleCompleted();
		assertEquals(false,one.getCompleted());
	}

}
