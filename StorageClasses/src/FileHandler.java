import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
public class FileHandler 
{
private static String fileName="JotItDownDatabase.txt";
private TaskHashMap manager=new TaskHashMap();
public void writeObject()
{

	for(String key: manager.getKeySet())
	{
		try
		{
			BufferedOutputStream xmlOut=new BufferedOutputStream(new FileOutputStream(fileName));
			XMLEncoder xmlWrite=new XMLEncoder(xmlOut);
			xmlWrite.writeObject(manager.getTaskbyId(key));
		}
		catch(FileNotFoundException e)
		{
			//A logging error may be.
		}
	}
}

public TaskHashMap readObject()
{
	try
	{
		FileInputStream file=new FileInputStream(fileName);
		BufferedInputStream xmlIn=new BufferedInputStream(file);
		XMLDecoder xmlRead=new XMLDecoder(xmlIn);
		
		TaskHashMap taskFromDatabase=(TaskHashMap) xmlRead.readObject();
		
		
		xmlRead.close();
		
	}
	catch(IOException e)
	{
		// A logging error here as well.
	}
	return taskFromDatabase;
}
}
