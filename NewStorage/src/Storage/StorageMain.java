package Storage;
import java.io.FileNotFoundException;

public class StorageMain {
public static void main(String args[]) throws FileNotFoundException
{
	DateTime oneStartDate=new DateTime(2012,5,26,15,0,0);
	DateTime oneEndDate=new DateTime(2012,5,26,16,0,0);
	Task one=new Task("Going to saloon","near Alkameen",oneStartDate,oneEndDate,"weekly");
	Task two=new Task("Going to doctor","with Parents",oneEndDate,oneStartDate,"monthly");
	DateTime threeStartDate=new DateTime(2012,5,28,14,0,0);
	DateTime threeEndDate=new DateTime(2012,5,28,16,0,0);
	Task three=new Task("Going to lecture","CS2103",threeStartDate,threeEndDate,null);
	DateTime fourStartDate=new DateTime(2012,5,28,14,0,0);
	DateTime fourEndDate=new DateTime(2012,5,29,15,0,0);
	Task four=new Task("Going to tutorial","Project meeting",fourStartDate,fourEndDate,"daily");
	StorageManager manager=new StorageManager();
	manager.addTask(one);
	manager.addTask(two);
	manager.addTask(three);
	manager.addTask(four);
	manager.saveFile();
	manager.loadFile();
	Task[] tasks=manager.getAllTasks();
	manager.exportToTxt("JotItDownDataBase.txt");
	manager.deleteTask(one.getTaskId());
	for(int i=0;i<tasks.length;i++)
	{
		System.out.println(tasks[i].getEndDateTime().formattedToString());
	}
	manager.saveFile();
	manager.loadFile();
	Task[] tasks1=manager.getAllTasks();
	System.out.println(tasks1.length);
	for(int i=0;i<tasks1.length;i++)
	{
		System.out.println(tasks1[i].getEndDateTime().formattedToString());
	}
}

}

