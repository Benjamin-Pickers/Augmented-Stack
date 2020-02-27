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
}
