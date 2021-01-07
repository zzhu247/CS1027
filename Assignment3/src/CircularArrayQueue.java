/**
 *  CircularArrayQueue.java:
 *  This class implements a queue implementation by a circular array
 * @author Zihan Zhu
 */
public class CircularArrayQueue<T> implements QueueADT<T> {
	/**Attribute:
	 * front - The front index of the Queue
	 * rear - The rear index of the Queue
	 * count -  The size of the Queue
	 * queue - The pointer to the Queue
	 * DEFAULT_CAPACITY - default capacity set as 20
	 */
	private int front;
	private int rear;
	private int count;
	private T[] queue;
	private final int DEFAULT_CAPACITY = 20;
	
    /**Constructor for the class  
     * Creates an empty queue 
     * The default initial capacity of the queue is 20
     */	
	public CircularArrayQueue() {
		front = DEFAULT_CAPACITY - 1;
		rear = DEFAULT_CAPACITY - 2;
		count = 0;
		queue = (T[])(new Object[DEFAULT_CAPACITY]);
	}

    /**Second Constructor for the class 
     * Creates an empty queue 
     * The default initial capacity of the queue is entered by the user
     * @param initialCapacity the size of the Queue entered by the user
     */
	public CircularArrayQueue(int initialCapacity) {
		front = initialCapacity - 1;
		rear = initialCapacity - 2;
		count = 0;
		queue = (T[])(new Object[initialCapacity]);
	}
	
	/** Takes in an element of the generic type and adds that element to the rear of the queue
     *  @param element the element needs to be pushed to to the rear of the queue.
     */
	public void enqueue (T element) {
		if (count == queue.length) {
			expandCapacity();
		}
		rear = (rear+1)%(queue.length);
		queue[rear] = element;
		count ++;
	}
	
	/** Remove and return the item at the front of the queue.
     *  throws an EmptyCollectionException if the queue is empty
     *  @return the item at the front of the queue
     */
	public T dequeue() throws EmptyCollectionException{
		if (isEmpty()) {
			throw new EmptyCollectionException("queue");
		}
		
		T result = queue[front];
		count--;
		front = (front+1)%(queue.length);
		
		return result;
	}

	/** Return the item at the front of the queue without removing it.
     *  throws an EmptyCollectionException if the queue is empty
     *  @return the item at the front of the queue
     */
	public T first() throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("queue");
		}
		
		T result = queue[front];
		return result;
	}
	/**
	 * Returns true if the queue is empty and returns false otherwise
	 * @return a boolean to indicate whether the queue is empty
	 */
	public boolean isEmpty() {
		if (front == (rear+1)%(queue.length)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Accessor method: Returns the number of items on the queue.
	 * @return the size of the queue
	 */	
	public int size() {
		return count;
	}

	/**
	 * Acessor method: Returns the front index value.
	 * @return the front index value
	 */
	public int getFront() {
		return front;
	}

	/**
	 * Accessor method: returns the rear index value
	 * @return rear index value
	 */
	public int getRear() {
		return rear;
	}
	/**
	 * Accessor method: Returns the current length (capacity) of the array
	 * @return capacity of the queue
	 */
	public int getLength() {
		return queue.length;
	}
	/**
	 * Returns the string containing "QUEUE: " followed by each of the queue's items
	 * @return string of the queue
	 */
	public String toString() {
		String output;
		if (isEmpty()) {
			output = "The queue is empty";
		} else {
			output = "QUEUE: ";
			for (int index=0; index < (count-1); index++) {
 				output += queue[(front + index)%(queue.length)] + ", ";
			}
			output += queue[rear] + ".";
		}
		return output;
	}
	
	/**
	 * Create a new array that has 20 more slots than the current array has.
	 */
	private void expandCapacity() {
		int newcapacity = getLength()+20;
		T[] newqueue = (T[])(new Object[newcapacity]);
		for (int t=1; t<=count; t++) {
			newqueue[t] = queue[(front+t-1)%(queue.length)];
		}
		queue = newqueue;
		front = 1;
		rear = count;
	}
}
