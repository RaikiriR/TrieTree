import java.io.BufferedReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

public class DictPrefixTree 
{
	private class TrieNode
	{
		Map<Character,TrieNode> children = new TreeMap<>();
		boolean aword = false;
	}
	
	private TrieNode root;
	public DictPrefixTree()
	{
		this.root = new TrieNode();
	}
	
	
	public DictPrefixTree fillTree(BufferedReader reader, DictPrefixTree tree) throws IOException
	{
		while(true)
		{
			String x = reader.readLine();
			if(x == null)
			{
				break;
			}
			x = convert(x);
			tree.insertString(x);
		}
		return tree;
	}
	
	public boolean findWord(String s) {
		return findWord(this.root, s);
	}
	
	private boolean findWord(TrieNode node, String s) {
		if(s != null && s.isEmpty() != true) 
		{
			//rest is a substring of s, by excluding the first character in s
			char ch = s.charAt(0);//ch is the first letter of s
			TrieNode child = node.children.get(ch);//return the child that ch associated with. 
			if(s.length() == 1 && child != null && child.aword == true)
			{
				return true;//if s contains only one letter, and current node has a child associated with that letter, we find the prefix in Trie!
			}                 //base case
			if(child == null)
				return false;
			else
			{
				String rest = s.substring(1);
				return findWord(child, rest); 
			}  //recursive, In this way, we follow the path of the trie from root down towards leaf
		}
		return false;
	}
	
	public void insertString(String s)
	{
		insertString(root, s);
	}
	
	private void insertString(TrieNode root,String s)
	{
		TrieNode curr = root;
		for(char ch : s.toCharArray())
		{
			TrieNode next = curr.children.get(ch);
			if(next == null)
			{
				curr.children.put(ch, next = new TrieNode());
			}
			curr = next;
		}
		curr.aword = true;
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
