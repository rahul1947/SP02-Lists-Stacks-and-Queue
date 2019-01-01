package rsn170330.sp02;

/**
 * 3. Write the Merge sort algorithm that works on linked lists.  
 * 
 * This will be a member function of a linked list class, so that 
 * it can work with the internal details of the class. 
 * The function should use only O(log n) extra space (mainly for 
 * recursion), and not make copies of elements unnecessarily. 
 * 
 * You can start from the SinglyLinkedList class provided or create your own.
 * 
 * @author Rahul Nalawade (rsn170330)
 *
 */

public class SortableList<T extends Comparable<? super T>> extends rsn170330.sp01.SinglyLinkedList<T>  {
	// merge this list with other list
	void merge (SortableList<T> otherList) {
		
	}

	// Sort this list
	void mergeSort() {
		
	}

	public static<T extends Comparable<? super T>> void mergeSort(SortableList<T> list) {
		list.mergeSort();
	}

	public static void main(String[] args) {
		
	}
}
