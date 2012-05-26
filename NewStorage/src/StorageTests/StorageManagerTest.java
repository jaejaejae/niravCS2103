package StorageTests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.DateTime;
import data.Task;
import storagecontroller.StorageManager;
public class StorageManagerTest {
	
	StorageManager manager=new StorageManager();
	DateTime start = new DateTime(2012,5,30,18,0,0);
	DateTime end = new DateTime(2012,5,30,18,30,0);
	DateTime start2=new DateTime(2012,5,30,19,0,0);
	DateTime end2=new DateTime(2012,5,30,20,0,0);
	Task one=new Task("Go to school","for buying a nb",start,end,"monthly");
	Task two=new Task("Wash Clothes","in R3",start2,end2,"weekly");
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testAddTask() 
	{
		manager.addTask(one);
		assertEquals(one, manager.getTaskById(one.getTaskId()));
	}

	@Test
	public final void testDeleteTaskTask() 
	{
		manager.deleteTask(one);
		assertEquals(0,manager.getAllTasks().length);
		//assertEquals(0,manager.getAllTasks().length);
	}

	@Test
	public final void testGetAllTasks() 
	{
		
		manager.addTask(one);
		manager.addTask(two);
		ArrayList<Task> taskList=new ArrayList<Task>();
		taskList.add(two);
		taskList.add(one);
		Task[] taskArray=new Task[2];
		taskList.toArray(taskArray);
		assertEquals(taskArray[1],manager.getAllTasks()[1]);
	}

	@Test
	public final void testGetTaskById() {
		manager.addTask(one);
		assertEquals(one,manager.getTaskById(one.getTaskId()));
	}

	@Test
	public final void testLoadFile() {
		fail("Not yet implemented");//TODO
	}

	@Test
	public final void testSaveFile() throws FileNotFoundException {
		manager.saveFile();
	}

	@Test
	public final void testExportToTxt() throws FileNotFoundException {
		manager.exportToTxt("Nirav.txt");
	}

	@Test
	public final void testDeleteTaskString() {
		manager.addTask(one);
		manager.addTask(two);
		manager.deleteTask(one);
		assertEquals(1,manager.getAllTasks().length);
	}

	@Test
	public final void testSaveArchive() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testClearArchive() {
		fail("Not yet implemented"); // TODO
	}

}
