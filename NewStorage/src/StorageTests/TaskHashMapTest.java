package StorageTests;

import data.DateTime;
import data.Task;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import data.TaskHashMap;
public class TaskHashMapTest {
	
	DateTime start = new DateTime(2012,5,30,18,0,0);
	DateTime end = new DateTime(2012,5,30,18,30,0);
	Task first=new Task("Eat dinner","at mcd",start,end,"weekly");
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testGenerateUniqueId() {
		TaskHashMap test=new TaskHashMap();
		test.addTask(first);
		assertEquals("",test.generateUniqueId(first));
	}

	@Test
	public final void testDeleteTaskById() {
	TaskHashMap test=new TaskHashMap();
	test.addTask(first);
	test.deleteTaskById(first.getTaskId());
	assertEquals(0 , test.getKeySet().size());
	}

	@Test
	public final void testClearHashMap() {
		TaskHashMap test=new TaskHashMap();
		test.addTask(first);
		test.addTask(first);
		assertEquals(2,test.getKeySet().size());
		test.clearHashMap();
		assertEquals(0,test.getKeySet().size());
	}

}
