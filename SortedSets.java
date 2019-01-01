package rsn170330.sp02;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;

public class SortedSets {
	
	public static void main(String[] args) {
		List<Integer> l1 = new LinkedList<>();
		List<Integer> l2 = new LinkedList<>();
		
		for (int i=0; i<25; i++) {
			if (i % 2 == 0) l2.add(i);
			l1.add(i);
		}
		
		List<Integer> intersections = new LinkedList<>();
		List<Integer> unions = new LinkedList<>();
		List<Integer> setDifferences = new LinkedList<>();
		
		intersect(l1, l2, intersections);
		union(l1, l2, unions);
		difference(l1, l2, setDifferences);
		
		System.out.println("Set 1: \t\t"+l1);
		System.out.println("Set 2: \t\t"+l2);
		System.out.println("Intersection: \t"+intersections);
		System.out.println("Union: \t\t"+unions);
		System.out.println("Difference: \t"+setDifferences);
	}
	
	// Fail- safe condition for next()
	public static<T> T next(Iterator<T> it) {
		return (it.hasNext())? it.next() : null;
	}
	
	/**
	 * Returns the intersection of two sorted sets, in the same order.
	 * Output is also a set without any duplicates.
	 * @param l1 the first input list without duplicates and sorted (set)
	 * @param l2 the second input list without duplicates and sorted (set)
	 * @param outList the intersection set of l1 and l2
	 */
	public static<T extends Comparable<? super T>> void intersect(List<T> l1, List<T> l2, List<T> outList) {
		ListIterator<T> lt1 = l1.listIterator();
		ListIterator<T> lt2 = l2.listIterator();
		
		T e1 = next(lt1); 
		T e2 = next(lt2); 
		
		while (e1 != null && e2 != null) {
			
			// When the elements are the same.
			if (e1.compareTo(e2) == 0) {
				outList.add(e1);
				e1 = next(lt1); 
				e2 = next(lt2); 
				
			} 
			// When e1 < e2
			else if (e1.compareTo(e2) < 0) {
				e1 = next(lt1);
			} 
			// When e2 < e1
			else {
				e2 = next(lt2);
			}
		}
	}
	
	/**
	 * Returns the union of two sorted sets, in the same order.
	 * Output is also a set without any duplicates.
	 * @param l1 the first input list without duplicates and sorted (set)
	 * @param l2 the second input list without duplicates and sorted (set)
	 * @param outList the union set of l1 and l2
	 */
	public static <T extends Comparable<? super T>> void union(List<T> l1, List<T> l2, List<T> outList) {
		ListIterator<T> lt1 = l1.listIterator();
		ListIterator<T> lt2 = l2.listIterator();
		
		T e1 = next(lt1);
		T e2 = next(lt2);
		
		while (e1 != null || e2 != null) {
			
			// When the elements are the same.
			if (e1.compareTo(e2) == 0) {
				outList.add(e1);
				e1 = next(lt1); 
				e2 = next(lt2); 
			} 
			// When e1 < e2
			else if (e1.compareTo(e2) < 0) {
				outList.add(e1);
				e1 = next(lt1);
			} 
			// When e2 < e1
			else {
				outList.add(e2);
				e2 = next(lt2);
			}
		}
	}
	
	/**
	 * Return the difference (l1 - l2: the items that are in l1 but not in l2), in sorted order 
	 * @param l1 the first list 
	 * @param l2 the second list
	 * @param outList the setDifference of l1 - l2
	 */
	public static <T extends Comparable<? super T>> void difference(List<T> l1, List<T> l2, List<T> outList) {
		ListIterator<T> lt1 = l1.listIterator();
		ListIterator<T> lt2 = l2.listIterator();
		
		T e1 = next(lt1); // lt1.next();
		T e2 = next(lt2); //lt2.next();
		
		while (e1 != null && e2 != null) {
				
			// When the elements are the same.
			if (e1.compareTo(e2) == 0) {
				e1 = next(lt1);
				e2 = next(lt2);
			} 
			// When e1 < e2
			else if (e1.compareTo(e2) < 0) {
				outList.add(e1);
				e1 = next(lt1);
			} 
			// When e2 < e1
			else {
				e2 = next(lt2);
			}
		}	
		while (e1 != null) {
			outList.add(e1);
			e1 = next(lt1);
		}
	}
}
