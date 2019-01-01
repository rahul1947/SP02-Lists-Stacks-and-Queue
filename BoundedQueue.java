package rsn170330.sp02;

import java.util.Scanner;

/**
 * CS 5V81: Implementation of Data Structures and Algorithms
 * Short Project 02 SP2: Implementation of Bounded Queue
 * @author Rahul Nalawade
 * @author Bharath Rudra
 * 
 * Date: 2018-Aug-08
 */

public class BoundedQueue<T> {
	
	private int maxSize;
	private int front;
	private int rear;
	
	private T[] bQ;
	
	/**
	 * Implement a bounded-sized queue BoundedQueue<T>, using arrays with the following operations: 
	 * To avoid "generic array cannot be created" error, declare the array to be Object[] and 
	 * type-cast where needed to avoid type warnings. 
	 * 
	 * BoundedQueue(int size): 
	 * 		Constructor for queue of given size 
	 */
	public BoundedQueue(int size) {
		maxSize = size;
		bQ = (T[]) new Object[maxSize];
		front = rear = -1; // Empty Queue condition/ Initialization 
		//lastOperationAdded = false;
	}
	
	/**
	 * Add a new element x at the rear of the queue 
	 * @param x the element to be added
	 * @return false if the element was not added because the queue is full
	 */
	boolean offer(T x) {
		// When boundedQueue(bQ) is full
		if (size() == maxSize) return false;
		
		else {
			if (front == -1) { front++; } // The pointers (f,r) are at (-1,-1)
			rear = (rear + 1) % maxSize; // incrementing pointers in circular way
			bQ[rear] = x;
		}
 		return true;
		
	}
	
	/**
	 * Remove and return the element at the front of the queue 
	 * @return null if the queue is empty
	 */
	public T poll() {
		// the element to be polled (removed)
		T element;
		
		// When bQ is not empty
		if (!this.isEmpty()) {
			element = (T) bQ[front]; 
			
			// When the last element is to be removed, resulting into empty bQ.
			if (front == rear) front = rear = -1; // Empty Queue condition/ Initialization
			
			else front = (front+1) % maxSize; // circular increment of front
			
			return element;
		}
		return null;	
	}
	
	/**
	 * return front element, without removing it (null if queue is empty)
	 * @return the front element
	 */
	public T peek() {
		T element;
		
		// When bQ is not empty
		if (!this.isEmpty()) {
			element = (T) bQ[front];
			return element;
		}
		return null;
	}
	
	// return the number of elements in the queue 
	public int size() {
		// empty bQ state of (f,r) = (-1,-1)
		if (front == -1 && rear == -1) { return 0; }
		
		// e.g. when (f,r) = (5,2): size = 10 + (2 - 5) + 1 = 8.
		if (rear < front) { return maxSize + (rear - front) + 1; }
		
		return (rear - front + 1);
	}
	
	// check if the queue is empty
	public boolean isEmpty() {
		// When (f,r) = (-1,-1)
		if (size() == 0) return true;
		return false;
	}
	
	// clear the queue (size=0)
	public void clear() {
		front = rear = -1; // Empty Queue condition/ Initialization
	}
	
	/**
	 * fill user supplied array with the elements of the queue, in queue order
	 * @param a the supplied array
	 */
	public void toArray(T[] a) {
		int l = size();
		for (int i=0; i<l; i++) {
			// i iterating from front to rear in circular way
			a[i] = (T) bQ[(front+i) % maxSize];
		}
	}
	
	public static void main(String args[]) {
		Integer a[];
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter maxSize of BoundedQueue: ");
		int maxSize = in.nextInt();
		BoundedQueue<Integer> b = new BoundedQueue<>(maxSize);
		
		System.out.println("Enter choices 1. offer() 2. poll() 3. peek() 4. size() 5. isEmpty() 6. clear() 7. toArray(): 8. Quit");
		int choice = in.nextInt();
		
		while(choice != 8) {
			
			switch(choice) {
			case 1: // offer(x)
				Integer e = (Integer) in.nextInt();
				System.out.println("Element offered: "+b.offer(e));
				// Checking front and rear pointers
				System.out.println("(f,r) = "+b.front+" "+b.rear);
				break;
			
			case 2: // poll()
				System.out.println("Element polled: "+b.poll());
				System.out.println("(f,r) = "+b.front+" "+b.rear);
				break;
				
			case 3: // peek()
				System.out.println("boundedQueue[front] = "+b.peek());
				System.out.println("(f,r) = "+b.front+" "+b.rear);
				break;
				
			case 4: // size()
				System.out.println("Size: "+b.size());;
				System.out.println("(f,r) = "+b.front+" "+b.rear);
				break;
				
			case 5: // isEmpty()
				System.out.println("boundedQueue isEmpty: "+b.isEmpty());
				System.out.println("(f,r) = "+b.front+" "+b.rear);
				break;
				
			case 6: // clear()
				b.clear();
				System.out.println("(f,r) = "+b.front+" "+b.rear);
				break;
				
			case 7: // toArray()
				a = new Integer[b.size()];
				b.toArray(a);
				System.out.println("(f,r) = "+b.front+" "+b.rear);
				
				System.out.print("Array in queue order: ");
				for (int z: a) {System.out.print(z+" ");}
				System.out.println();
				
				break;
				
			case 8: // Exit
				break;
			}
			
			System.out.println("Enter choices 1. offer() 2. poll() 3. peek() 4. size() 5. isEmpty() 6. clear() 7. toArray(): 8. Quit");
			choice = in.nextInt();
			
		}
	}
}