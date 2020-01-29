import java.util.LinkedList;

public class Tester {

	public static void main(String[] args) 
	{
		Trie2 myTrie = new Trie2();
		myTrie.insertString("apple");
		myTrie.insertString("bike");
		myTrie.insertString("bake");
		myTrie.insertString("pen");
		myTrie.insertString("did");
		myTrie.insertString("ape");
		myTrie.insertString("child");
		myTrie.insertString("cat");
		myTrie.insertString("file");
		myTrie.insertString("hello");
		myTrie.insertString("he");
		myTrie.insertString("hell");
		
		System.out.println("Running words prefixed by ap:");
		LinkedList list1 = myTrie.wordsPrefixedBy("ap");
		printList(list1);
		
		System.out.println("Running words prefixed by he:");
		LinkedList list2 = myTrie.wordsPrefixedBy("he");
		printList(list2);
		
	}
	
	public static void printList(LinkedList list)
	{
		for(int i = 0; i < list.size();i++)
		{
			System.out.println(list.get(i));
		}
	}

}
