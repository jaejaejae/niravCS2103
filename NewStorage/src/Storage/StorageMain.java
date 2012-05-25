package Storage;
import java.io.FileNotFoundException;

public class StorageMain {
public static void main(String args[]) throws FileNotFoundException
{
	TaskHashMap map=new TaskHashMap();
	DateTime oneStartDate=new DateTime(2012,5,26,15,0,0);
	DateTime oneEndDate=new DateTime(2012,5,26,16,0,0);
	Task one=new Task("Going to saloon","near Alkameen",oneStartDate,oneEndDate,"weekly");
	Task two=new Task("Going to doctor","with Parents",oneEndDate,oneStartDate,"monthly");
	DateTime threeStartDate=new DateTime(2012,5,28,14,0,0);
	DateTime threeEndDate=new DateTime(2012,5,28,16,0,0);
	Task three=new Task("Going to lecture","CS2103",threeStartDate,threeEndDate,null);
	map.addTask(one);
	map.addTask(two);
	map.addTask(three);
	FileHandler handle=new FileHandler("JotItDownDataBase.xml");
	handle.readObject(map);
	System.out.println(map.getKeySet().size());
}

}

