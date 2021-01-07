/**
 *  ArrayStack.java:
 *  This class implements the ArrayStackADT
 * @author Zihan Zhu
 */
public class ArrayStack<T> implements ArrayStackADT<T> {
	/**Attribute:
	 * stack - The array stores the data items of the stack
	 * top - The variable stores the position of the last data item in the stack
	 * sequence -  used for TestSearch.java
	 */
	private T[] stack;
	private int top;
	public static String sequence;
	
    /** Creates an empty stack 
     *  The default initial capacity of the array is 5
     */	
	public ArrayStack () 
	{
		top = 1;
		sequence = "";
		stack = (T[])(new Object[5]);
	}
	
    /** Creates an empty stack using an array of 
     * length equal to the value of the parameter
     *  @param initialCapacity the initial size of the stack
     */	
	public ArrayStack (int initialCapacity) {
		top = 1;
		sequence = "";
		stack = (T[])(new Object[initialCapacity]);
	}
	
    /** Adds dataItem to the top of the stack.
     *  @param dataItem the element needs to be pushed to the stack
     */	
	public void push(T dataItem) {
		if (top == (stack.length+1)) {
			int UpdatedCapacity;
			if (stack.length < 50) {
				UpdatedCapacity = stack.length * 10;
			} else {
				UpdatedCapacity = stack.length + 50;
			}
			setSize(UpdatedCapacity, true);
		}
		
		stack[top-1] = dataItem;
		top ++;

		if (dataItem instanceof MapCell) {
			sequence += "push" + ((MapCell)dataItem).getIdentifier();
		} else {
			sequence += "push" + dataItem.toString();
		}
		
	}
	
    /** increase/decrease the size of the stack
     *  @param newsize the new size of the stack
     *  @param increase/decrease mask
     */	
	private void setSize(int newsize, boolean increase) {
		T[] temp = (T[]) new Object[newsize];
		if (increase) {
			for (int index=0; index < stack.length; index++) {
				temp[index] = stack[index];
			}
		} else {
			for (int index=0; index < newsize; index++) {
				temp[index] = stack[index];
			}
		}
		stack = temp;
	}
	
    /** Removes and returns the data item at the top of the stack
     *  An EmptyStackException is thrown if the stack is empty
     */	
	public T pop() throws EmptyStackException{
		if (isEmpty()) {
			throw new EmptyStackException("stack");
		}
		top --;
		T result = stack[top-1];
		
		stack[top-1] = null;
		
		int length = stack.length;
		double trigger = length/4;
		if (size() < (trigger) && length >= 50) {
			int updatedCapacity = length - 25;
			setSize(updatedCapacity, false);
		}
		
		if (result instanceof MapCell) {
			sequence += "pop" + ((MapCell)result).getIdentifier();
		} else {
			sequence += "pop" + result.toString();
		}
		return result;
	}
	
    /** Returns the data item at the top of the stack without removing it.
     *  An EmptyStackException is thrown if the stack is empty.
     */	
	public T peek() throws EmptyStackException {
		if (isEmpty()) {
			throw new EmptyStackException("stack");
		}
		return stack[top-2];
	}
	
	/**
	 * Returns true if the stack is empty and returns false otherwise
	 * @return a boolean to indicate if the stack is empty
	 */
	public boolean isEmpty() {
		if (top == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns the number of data items in the stack.
	 * @return the size of the stack
	 */
	public int size() {
		return (top-1);
	}
	
	/**
	 * Returns the capacity of the array stack.
	 * @return the capacity of the stack
	 */
	public int length() {
		return stack.length;
	}
	
	/**
	 * Returns a String representation of the stack of the form
	 * @return a string of the stack
	 */
	public String toString() {
		String output = "Stack: ";
		if (isEmpty()) {
			output += "empty stack";
		} else {
			for (int index=0; index < (size()-1); index++) {
 				output += stack[index] + ", ";
			}
			output += stack[size()-1];
		}
		
		return output;
		
	}
	
}