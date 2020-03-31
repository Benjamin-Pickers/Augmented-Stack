public class AugmentedStack<T extends Comparable<T>>
{
	private Comparable<T>[] s;
	private Comparable<T>[] maxS;
	private int maxTop = -1;
	private int top = -1;
	
	public AugmentedStack()
	{
		this(100);
	}
	
	@SuppressWarnings("unchecked")
	public AugmentedStack(int size)
	{
		s = new Comparable[size]; 
		maxS = new Comparable[size];
	}
	
	/**
	 * Pushes element onto the top spot of the stack
	 * @param x an element to be pushed
	 */
	public void push(T x)
	{
		s[++top] = x;
		
		if(maxTop < 0 || (maxS[maxTop].compareTo(x)) < 0)
		{
			maxS[++maxTop] = x;
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
		
		if (maxS[maxTop] == obj)
		{
			maxS[maxTop] = null;
			maxTop--;
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
	 * @return maximum value from the stack 
	 */
	public Comparable<T> getMax()
	{
		if(maxTop < 0)
		{
			return null;
		}
		
		return maxS[maxTop];
	}
}
