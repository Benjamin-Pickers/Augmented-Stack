package a2;

/*
 * Name: Benjamin Pickers
 * EECS account: ben10p
 * Student Number: 216425456
 */


public class AugmentedStack<T extends Comparable<T>>
{
	private Comparable<T>[] s;
	private Comparable<T>[] minS;
	private int minTop = -1;
	private int top = -1;
	
	public AugmentedStack()
	{
		this(100);
	}
	
	@SuppressWarnings("unchecked")
	public AugmentedStack(int size)
	{
		s = new Comparable[size]; 
		minS = new Comparable[size];
	}
	
	/**
	 * Pushes element onto the top spot of the stack
	 * @param x an element to be pushed
	 */
	public void push(T x)
	{
		s[++top] = x;
		
		if(minTop < 0 || (minS[minTop].compareTo(x)) > 0)
		{
			minS[++minTop] = x;
		}
	}
	
	/**
	 * Removes top element from stack
	 * @return popped element, returns null if empty
	 */
	public Comparable<T> pop()
	{
		if(top < 0)
		{
			return null;			
		}
		
		Comparable<T> obj = s[top];
		s[top] = null;
		top--;
		
		if (minS[minTop] == obj)
		{
			minS[minTop] = null;
			minTop--;
		}
		return obj;
	}
	
	/**
	 * Checks if stack is empty
	 * @return true if stack is empty, false otherwise
	 */
	public boolean isEmpty()
	{
		if (top < 0)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Returns top element of stack but does not remove it
	 * @return top of element of stack
	 */
	public Comparable<T> top()
	{
		if(top<0)
		{
			return null;
		}
		
		return s[top];
	}
	
	/**
	 * 
	 * @return minimum value from the stack 
	 */
	public Comparable<T> getMin()
	{
		if(minTop < 0)
		{
			return null;
		}
		
		return minS[minTop];
	}
	
	public static void main(String[] args)
	{
		AugmentedStack<String> s = new AugmentedStack<>(10);
		System.out.println("Is it empty "+s.isEmpty());
		System.out.println("Push ben");
		s.push("ben");
		System.out.println("Push abc");
		s.push("abc");
		System.out.println("Is it empty "+ s.isEmpty());
		System.out.println("Push aac");
		s.push("aac");
		System.out.println("Push xyz");
		s.push("xyz");
		System.out.println("Min element is "+s.getMin());
		System.out.println("Popped " + s.pop());
		System.out.println("Top element is " + s.top());
		System.out.println("Popped " + s.pop());
		System.out.println("Min element is "+s.getMin());
		System.out.println("Is it empty "+s.isEmpty());
		System.out.println("Popped " + s.pop());
		System.out.println("Popped " + s.pop());
		System.out.println("Is it empty "+ s.isEmpty());
		System.out.println("Min element is "+s.getMin());
		System.out.println("Popped " + s.pop());
		
		System.out.println("-----------------------");
		
		AugmentedStack<Integer> s2 = new AugmentedStack<>(10);
		System.out.println("Is it empty "+s2.isEmpty());
		System.out.println("Push -10");
		s2.push(-10);
		System.out.println("Push 5");
		s2.push(5);
		System.out.println("Is it empty "+ s2.isEmpty());
		System.out.println("Push -15");
		s2.push(-15);
		System.out.println("Push -11");
		s2.push(-11);
		System.out.println("Push 10");
		s2.push(10);
		System.out.println("Min element is "+s2.getMin());
		System.out.println("Popped " + s2.pop());
		System.out.println("Top element is " + s2.top());
		System.out.println("Popped " + s2.pop());
		System.out.println("Min element is "+s2.getMin());
		System.out.println("Is it empty "+s2.isEmpty());
		System.out.println("Popped " + s2.pop());
		System.out.println("Popped " + s2.pop());
		System.out.println("Popped " + s2.pop());
		System.out.println("Is it empty "+ s2.isEmpty());
		System.out.println("Min element is "+s2.getMin());
		System.out.println("Popped " + s2.pop());
	}
	
}
