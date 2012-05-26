package storagecontroller;
import data.TaskHashMap;
import data.Task;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class StorageManager 
{
	private TaskHashMap liveStorage;
	public StorageManager()
	{
		liveStorage=new TaskHashMap();
	}
	
	public void addTask(Task taskToBeAdded)
	{
		liveStorage.addTask(taskToBeAdded);
	}
	public void deleteTask(Task taskToBeRemoved)
	{
		liveStorage.deleteTask(taskToBeRemoved);
	}
	public Task[] getAllTasks()
	{
		ArrayList<Task> tasks=new ArrayList<Task>();
		for(String key: liveStorage.getKeySet())
		tasks.add(liveStorage.getTaskById(key));
		Task[] taskArray=new Task[tasks.size()];
		tasks.toArray(taskArray);
		return taskArray;
	}	
	public Task getTaskById(String id)
	{
		return liveStorage.getTaskById(id);
	}
	public boolean loadFile() throws ArrayIndexOutOfBoundsException, FileNotFoundException
	{
		FileHandler handler=new FileHandler("JotItDownDatabase.xml");
		if(liveStorage.getKeySet().size()!=0)
			liveStorage.clearHashMap();
		if(handler.readFromFile(liveStorage))
			return true;
		else 
			return false;
	}
	public boolean saveFile() throws FileNotFoundException
	{
	FileHandler handler=new FileHandler("JotItDownDatabase.xml");
	if(handler.writeToFile(liveStorage))
		return true;
	else 
		return false;
	}
	public void replaceTask(Task taskToBeReplaced,Task taskToReplaceBy)
	{
		liveStorage.deleteTask(taskToBeReplaced);
		liveStorage.addTask(taskToReplaceBy);
	}
	public void exportToTxt(String fileName) throws FileNotFoundException
	{
		FileHandler handler=new FileHandler(fileName);
		handler.writeToFile(liveStorage);
	}
	public void deleteTask(String id)
	{
		liveStorage.deleteTaskById(id);
	}
	public void saveArchive()
	{
		
	}
	public void clearArchive()
	{
		
	}
}

