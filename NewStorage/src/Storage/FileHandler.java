package Storage;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class FileHandler 
{
	private static String fileName;
	public FileHandler(String name)
	{
		fileName=name;
	}
	public void writeObject(TaskHashMap instance) throws FileNotFoundException
	{
		try
		{
		BufferedOutputStream xmlOut=new BufferedOutputStream(new FileOutputStream(fileName));
		XMLEncoder writeToXml=new XMLEncoder(xmlOut);
		for(String key: instance.getKeySet())
		{
			writeToXml.writeObject(instance.getTaskById(key));
		}
		writeToXml.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found!");
		}
	}
	public TaskHashMap readObject() throws FileNotFoundException, ArrayIndexOutOfBoundsException
	{
		TaskHashMap instance =new TaskHashMap();
		BufferedInputStream xmlIn=new BufferedInputStream(new FileInputStream(fileName));
		XMLDecoder readFromXml=new XMLDecoder(xmlIn);
		try
		{
			Task obj;
			while((obj=(Task)readFromXml.readObject())!=null)
			{
				System.out.println("in while loop");
				instance.addTaskById(obj);
			}
			//System.out.println(instance.getKeySet().size());
			readFromXml.close();
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			return null;
		}
		catch(NullPointerException e)
		{
			return null;
		}
		
		return instance;
	}
}
