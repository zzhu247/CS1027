public class ArrayStack<T> implements ArrayStackADT<T> {

	private final int INTIAL_ARRAY_LENGTH = 5;

	/** the underlying data structure for the stack */
	private T[] ArrayStack;
	
	public static String sequence;

	/** pointer to top of stack */
	private int top;

	/**
	 * Creates an empty stack.
	 */
	public ArrayStack() {

		ArrayStack = (T[]) new Object[INTIAL_ARRAY_LENGTH+1];
		sequence = "";
		top = 1;

	} // end ArrayStack

	/**
	 * Creates an empty stack.
	 */
	public ArrayStack(int initialCapacity) {

		ArrayStack = (T[]) new Object[initialCapacity+1];
		top = 1;

	} // end ArrayStack

	/**
	 * Adds one element to the top of this stack.
	 * 
	 * @param dataItem data item to be pushed onto stack
	 */
	public void push(T dataItem) {

		if (size() >= ArrayStack.length-1) {

			if (ArrayStack.length < 50) {
				
				//System.out.println("Size was " + (ArrayStack.length-1) + " and is now " + (ArrayStack.length-1)*10);

				setSize((ArrayStack.length-1) * 10);

			} // end if

			else {

				setSize(ArrayStack.length + 49);

			} // end else

		} // end if

		if (dataItem instanceof MapCell) {
			sequence += "push" + ((MapCell)dataItem).getIdentifier();
		}
		else {
			sequence += "push" + dataItem.toString();
		}
		
		//sequence += "push" + dataItem.toString();
		ArrayStack[top] = dataItem;
		top++;

	} // end push

	/**
	 * Sets the new maximum size of the ArrayStack
	 * 
	 * @param newSize the new maximum size
	 */
	private void setSize(int newSize) {

		T[] temp = (T[]) new Object[newSize+1];

		for (int i = 0; i <= size(); i++) {

			temp[i] = ArrayStack[i];

		} // end for

		ArrayStack = temp;

	} // end increaseSize

	/**
	 * Removes and returns the top element from this stack.
	 * 
	 * @return T data item removed from the top of the stack
	 */
	public T pop() throws EmptyStackException {

		if (isEmpty()) {

			throw new EmptyStackException("Stack");

		} // end if

		T result = ArrayStack[top-1];
		top--;

		if (size() < length() / 4 && length() > 50) {

			setSize(length()-26);

		} // end if
		
		//sequence += "pop" + ((MapCell)result).getIdentifier();
		//sequence += "pop" + result.toString();
		if (result instanceof MapCell) {
			sequence += "pop" + ((MapCell)result).getIdentifier();
		}
		else {
			sequence += "pop" + result.toString();
		}
		
		return result;

	} // end pop

	/**
	 * Returns without removing the top element of this stack.
	 * 
	 * @return T data item on top of the stack
	 */
	public T peek() throws EmptyStackException {

		if (isEmpty()) {

			throw new EmptyStackException("Stack");

		} // end if

		return ArrayStack[top-1];

	} // end peek

	/**
	 * Returns true if this stack contains no elements.
	 * 
	 * @return true if the stack is empty; false otherwise
	 */
	public boolean isEmpty() {

		if (top == 1) {

			return true;

		} // end if

		else {

			return false;

		} // end else

	} // end isEmpty

	/**
	 * Returns the maximum size of the ArrayStack
	 * 
	 * @return the maximum size
	 */
	public int length() {

		return ArrayStack.length;

	} // end length

	/**
	 * Returns the number of data items in this stack.
	 * 
	 * @return int number of data items in this stack
	 */
	public int size() {

		return top-1;

	} // end size

	/**
	 * Returns a string representation of this stack.
	 * 
	 * @return String representation of this stack
	 */
	public String toString() {

		String str = "Stack: ";

		for (int i = 0; i < size(); i++) {

			str = str + ArrayStack[i+1].toString();

			if (i < size() - 1) {

				str = str + ", ";

			} // end if

		} // end for

		return str;

	} // end toString
	
	public String getSequence() {
		
		return sequence;
		
	} //end getSequence

} // end ArrayStack
