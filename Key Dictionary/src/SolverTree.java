import java.util.Arrays;
import java.util.LinkedList;


public class SolverTree 
{
	private static String[] phone = new String[9];
	
	
	public Node root;
	public static class Node 
	{
		String data;
		Node child1;
		Node child2;
		Node child3;
		Node child4;
		
		public Node(String data)
		{
			phone[0] = "";
			phone[1] = "abc";
			phone[2] = "def";
			phone[3] = "ghi";
			phone[4] = "jkl";
			phone[5] = "mno";
			phone[6] = "pqrs";
			phone[7] = "tuv";
			phone[8] = "wxyz";
			this.data = data;
		}
	}
	
	
	public SolverTree()
	{
		//primer
		String c = "";
		
		this.root = new Node(c);
	}
	
	public void buildSolver(int digits[], Node curr)
	{
		if(digits.length == 0)
		{
			return;
		}
		
		int firstDigit = digits[0];
		
		curr.child1 = new Node(pullLetter(firstDigit,1));
		curr.child2 = new Node(pullLetter(firstDigit,2));
		curr.child3 = new Node(pullLetter(firstDigit,3));
		if(phone[firstDigit].length() >= 4)
		{
			curr.child4 = new Node(pullLetter(firstDigit,4));
		}
		
		//recursive calls
		buildSolver(Arrays.copyOfRange(digits,1,digits.length),curr.child1);
		buildSolver(Arrays.copyOfRange(digits,1,digits.length),curr.child2);
		buildSolver(Arrays.copyOfRange(digits,1,digits.length),curr.child3);
		
		if(curr.child4 != null)
		{
			buildSolver(Arrays.copyOfRange(digits,1,digits.length),curr.child4);
		}
		
		
	}
	
	private String pullLetter(int loc,int child)
	{
		String ret = this.phone[loc];
		if(child == 4)
		{
				if(ret.length() == 3)
				{
					return "";
				}
				else
				{
					char c = ret.charAt(3);
					String returns = Character.toString(c);
					return returns;
				}
		}
		char c = ret.charAt(child-1);
		String returns = Character.toString(c);
		
		return returns;
	}
	
	
	public LinkedList solveTree(int len) {
		
		LinkedList results = new LinkedList();
		bruteForce(root,"",results,len);
		//printList(results);
		return results;
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
	
	private void bruteForce(Node node,String s,LinkedList results,int len) 
	{
		if(node != null)
		{
			s += node.data;
			bruteForce(node.child1,s,results,len);
			bruteForce(node.child2,s,results,len);
			bruteForce(node.child3,s,results,len);
			bruteForce(node.child4,s,results,len);
			if(node.child1 == null || node.child2 == null|| node.child3 == null || node.child4 == null)
			{
				if(s.length()>= len)
				{
					results.add(s);
				}
				
			}
		}
		return;
	}
	
	
}
