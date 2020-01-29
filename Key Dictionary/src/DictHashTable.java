import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

public class DictHashTable 
{
	private Hashtable<String, Integer> dictionary;
	
	
	public DictHashTable(BufferedReader reader) throws IOException 
	{
		this.dictionary = fillHashtable(reader);
	}

	public boolean isWord(String check)
	{
		boolean x = dictionary.containsKey(check);
		return x;
	}
	
	public Hashtable<String,Integer> fillHashtable(BufferedReader reader) throws IOException
	{
		Hashtable<String,Integer> newdictionary = new Hashtable<String,Integer>();
		
		while(true)
		{
			String x = reader.readLine();
			if(x == null)
			{
				break;
			}
			x = convert(x);
			newdictionary.put(x,1);
		}
		
		return newdictionary;
	}
	
	private static String convert(String in)
	{
		String out = "";
		char compare;
		for(int i = 0; i < in.length(); i++)
		{
			compare = in.charAt(i);
			if(Character.toString(compare).equals(","))
			{
				break;
			}
			else
			{
				out += Character.toString(compare);
			}
		}
		return out;
	}
	
}
