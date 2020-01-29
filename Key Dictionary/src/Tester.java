
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
		
		

		int[] test = console(ui);		
		DictHashTable hash = new DictHashTable(reader);
		DictPrefixTree tree = new DictPrefixTree();
		
		//Resetting Buffer for second tree
		reader = new BufferedReader(new FileReader(file));
		tree = tree.fillTree(reader,tree);
		
		SolverTree solve = new SolverTree();
		solve.buildSolver(test, solve.root);

		//Linked List returning all possible combinations
		LinkedList results = solve.solveTree();
		System.out.println("Here are all of your results: ");
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
			if(dictionary.checkValue(test)==true)
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
		String answer = "yes";
		int[] out = new int[4];
		while(true)
		{
			System.out.println("Do you want to enter 3 numbers? yes for 3 and no for 4. (y/n): ");
			answer = ui.next();
			if(answer.contains("y"))
			{
				break;
			}
			if(answer.contains("n"))
			{
				break;
			}
		}
		if(answer.equalsIgnoreCase("y"))
		{
			System.out.println("Enter 3 numbers individually pressing enter after each");
			out[0]= ui.nextInt();
			out[1]= ui.nextInt();
			out[2]= ui.nextInt();
			
		}
		else
		{
			System.out.println("Enter 4 numbers individually pressing enter after each");
			out[0]= ui.nextInt();
			out[1]= ui.nextInt();
			out[2]= ui.nextInt();
			out[3]= ui.nextInt();
			
		}
		return out;
	}
}
