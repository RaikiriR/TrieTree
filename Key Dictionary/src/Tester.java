
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Scanner;

public class Tester {

	public static void main(String[] args) throws IOException 
	{
		File file = new File("dictionary.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		Scanner ui = new Scanner(System.in);
		
		

		
		
		DictHashTable hash = new DictHashTable(reader);
		DictPrefixTree tree = new DictPrefixTree();
		
		
		//Resetting Buffer for second tree
		reader = new BufferedReader(new FileReader(file));
		tree = tree.fillTree(reader,tree);
		
		
		int[] test = console(ui);		
		int len = test.length;
		SolverTree solve = new SolverTree();
		solve.buildSolver(test, solve.root);

		//Linked List returning all possible combinations
		LinkedList results = solve.solveTree(len);
		System.out.println("Here are all of your results: ");
		System.out.print("Search using PrefixTree: ");
		solveTree(results,tree);
		System.out.print("Search using HashTable: ");
		solveList(results,hash);

		
	}
	
	public static void solveList(LinkedList list, DictHashTable dictionary)
	{
		String test;
		if(list == null)
		{
			System.out.println("none");
			return;
		}
		for(int i = 0; i < list.size();i++)
		{
			test = (String)list.get(i);
			if(dictionary.isWord(test)==true)
			{
				System.out.print(test + " ");
			}
		}
		System.out.println();
	}
	
	public static void solveTree(LinkedList list, DictPrefixTree dictionary)
	{
		String test;
		if(list == null)
		{
			System.out.println("none");
			return;
		}
		for(int i = 0; i < list.size();i++)
		{
			test = (String)list.get(i);
			if(dictionary.findWord(test)==true)
			{
				System.out.print(test + " ");
			}
		}
		System.out.println();
	}
	public static void printList(LinkedList list)
	{
		
		if(list == null)
		{
			System.out.println("none");
			return;
		}
		for(int i = 0; i < list.size();i++)
		{
			System.out.println(list.get(i));
		}
	}
	
	
	
	public String getPhone(String[][] phone,int location, int input)
	{
		return phone[location][input-2];
		
	}
	
	public static int[] console(Scanner ui)
	{
		String strings = ui.nextLine();
		int[] intarray=new int[strings.length()];
		for(int i = 0;i < intarray.length; i++)
		{
			intarray[i] = Character.getNumericValue(strings.charAt(i)) - 1;
		}
		return intarray;
	}
	
	
}
